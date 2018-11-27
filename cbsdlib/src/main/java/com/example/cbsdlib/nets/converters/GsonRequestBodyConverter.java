package com.example.cbsdlib.nets.converters;

import android.util.Log;

import com.example.cbsdlib.nets.example.bean.BaseReqBean;
import com.example.cbsdlib.utils.WechantSign;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.Converter;

/**
 *
 *created by Damon on 2017/7/4 9:19
 *
 *description: 
 *
 */
public class GsonRequestBodyConverter<T> implements Converter<T, RequestBody> {
    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");
    private static final Charset UTF_8 = Charset.forName("UTF-8");

    private final Gson gson;
    private final TypeAdapter<T> adapter;

    public GsonRequestBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override
    public RequestBody convert(T value) throws IOException {
        //加密开始
        Log.i("cbsd","加密前："+gson.toJson(value));

        BaseReqBean baseReqBean = (BaseReqBean) value;
        String nonce_str = WechantSign.create_nonce_str();
        String timestamp = WechantSign.create_timestamp();
        baseReqBean.setNonce_str(nonce_str);
        baseReqBean.setTime_str(timestamp);

        Map<String,Object> map = WechantSign.objectToMap(baseReqBean);
        map.put("nonce_str",nonce_str);
        map.put("time_str",timestamp);
        String sign = WechantSign.getSign(map, "123");
        map.put("sign",sign);
        baseReqBean.setSign(sign);
        Log.i("cbsd","加密后："+gson.toJson(baseReqBean));
        //加密结束

        Buffer buffer = new Buffer();
        Writer writer = new OutputStreamWriter(buffer.outputStream(), UTF_8);
        JsonWriter jsonWriter = gson.newJsonWriter(writer);
        adapter.write(jsonWriter, (T) baseReqBean);
//        adapter.write(jsonWriter, value);
        jsonWriter.close();



        return RequestBody.create(MEDIA_TYPE, buffer.readByteString());
    }

}
