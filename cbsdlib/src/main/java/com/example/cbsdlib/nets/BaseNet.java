package com.example.cbsdlib.nets;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.example.cbsdlib.CBSDApplication;
import com.example.cbsdlib.nets.converters.GsonConverterFactory;
import com.example.cbsdlib.utils.WechantSign;
import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
//import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * created by Damon on 2017/7/4 9:20
 * <p>
 * description:
 */
public abstract class BaseNet<T> {
    private T api;
    private Class<T> clazz;
    private OkHttpClient okHttpClient;
    private String session_id;
    private String deviceId;
    private long userId;
//    private String sfzh;

    @SuppressWarnings("FieldCanBeLocal")
    private InputStream mCertificate;

    private Converter.Factory converterFactory;
    private CallAdapter.Factory rxJavaCallAdapterFactory;

    private Context context;

    protected BaseNet(Context context) {
        this.context = context;
        converterFactory = GsonConverterFactory.create();
        rxJavaCallAdapterFactory = RxJava2CallAdapterFactory.create();
        clazz = getApiClazz();
    }

    public T getApi() {
        if (api == null) {
            initHttpClient(context);
            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(getBaseUrl())
                    .addConverterFactory(converterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            api = retrofit.create(clazz);
        }
        return api;
    }

    private void initHttpClient(final Context context) {
        if (okHttpClient == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder()
                    .readTimeout(60, TimeUnit.SECONDS)//设置读取超时时间
                    .writeTimeout(60, TimeUnit.SECONDS)//设置写的超时时间
                    .connectTimeout(10, TimeUnit.SECONDS)//设置连接超时时间\
                    .sslSocketFactory(HTTPSUtils.getSSLSocketFactory1(context), new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                        }

                        @Override
                        public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                        }

                        @Override
                        public X509Certificate[] getAcceptedIssuers() {
                            return new X509Certificate[0];
                        }
                    })
                    .hostnameVerifier(new HostnameVerifier() {
                        @Override
                        public boolean verify(String hostname, SSLSession session) {
                            return true;
                        }
                    })
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
//                            if (!isNetworkConnected(context)) {
//
//                                ((Activity)context).runOnUiThread(new Runnable() {
//                                    @Override
//                                    public void run() {
//                                        Toast.makeText(context, "当前无网络!", Toast.LENGTH_SHORT).show();
//                                    }
//                                });
//                            }
                            //
                            Request request = chain.request();
                            if (request.method().equals("GET")) {
                                String nonce_str = WechantSign.create_nonce_str();
                                String timestamp = WechantSign.create_timestamp();
                                //添加公共参数
                                HttpUrl httpUrl = request.url()
                                        .newBuilder()
                                        .addQueryParameter("nonce_str", nonce_str)
                                        .addQueryParameter("time_str", timestamp)
                                        .build();
                                //获取原有的参数
                                Set<String> nameSet = httpUrl.queryParameterNames();
                                ArrayList<String> nameList = new ArrayList<>();
                                nameList.addAll(nameSet);
                                Map<String,Object> map = new HashMap<>();
                                for (int i = 0; i < nameList.size(); i++) {
                                    String value = httpUrl.queryParameterValues(nameList.get(i)) != null
                                            && httpUrl.queryParameterValues(nameList.get(i)).size() > 0 ? httpUrl.queryParameterValues(nameList.get(i)).get(0) : "";
                                    map.put(nameList.get(i), value);
                                }
                                httpUrl = request.url().newBuilder()
                                        .addQueryParameter("nonce_str", nonce_str)
                                        .addQueryParameter("time_str", timestamp)
                                        .addQueryParameter("sign",WechantSign.getSign(map,"123"))
                                        .build();

                                request = request.newBuilder().url(httpUrl).build();

                            }
                            //
                            session_id = getCurrentToken();
                            request = request.newBuilder().addHeader("session_id",session_id).build();
                            request = dealRequest(request);
                            Logger.i("request" + request);
                            Response response = null;
                            try {
                                response = chain.proceed(request);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            Logger.i("response=" + response);
                            dealResponse(response);
                            return response;
                        }
                    });
//            if (isNeedHttps()) {
//                try {
//                    if (mCertificate == null) {
//                        throw new RuntimeException("please override setCertificateInputStream()");
//                    }
//                    SSLSocketFactory sslSocketFactory = CertificateUtils.getSSLSocketFactoryCertificate(mCertificate);
//                    builder.socketFactory(sslSocketFactory);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
            okHttpClient = builder.build();
        }
    }

    protected abstract String getSfzh();

    protected abstract String getCurrentToken();


    protected abstract long getCurrentUserId();

    protected void dealResponse(Response response) {
    }

    /**
     * 若需要使用https请求,请设置证书信息
     */
    private boolean isNeedHttps() {
        return false;
    }

    protected void setCertificateInputStream(InputStream certificate) {
        mCertificate = certificate;
    }


    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
        clear();
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    private void clear() {
        okHttpClient = null;
        api = null;
    }

    protected abstract Class<T> getApiClazz();

    protected abstract String getBaseUrl();

    protected Request dealRequest(Request request) {
        return request;
    }

    public boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isConnected();
            }
        }
        return false;
    }
}
