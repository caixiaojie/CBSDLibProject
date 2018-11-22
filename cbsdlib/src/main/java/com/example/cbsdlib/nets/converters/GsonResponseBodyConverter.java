package com.example.cbsdlib.nets.converters;

import android.text.TextUtils;
import android.util.Log;

import com.example.cbsdlib.nets.entities.CBSDResultEntity;
import com.example.cbsdlib.nets.exceptions.ResultException;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * created by Damon on 2017/7/4 9:19
 * <p>
 * description:
 */
public class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final TypeAdapter<T> adapter;

    public GsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {

        String response = value.string();
        Log.e("cbsd", "raw response string :" + response);
        try {
            CBSDResultEntity resultModel = gson.fromJson(response, CBSDResultEntity.class);
            if (resultModel.getCode() == 1) {//请求成功
                if (resultModel.getData() != null) {
                    if (resultModel.getData().isJsonArray()) {
                        return adapter.fromJson(response);
                    }
                    return adapter.fromJson(response);
                }
                return null;
            } else {
                if(resultModel.getData()==null){
                    throw new ResultException(resultModel.getCode(), resultModel.getMsg());
                }else{
                    throw new ResultException(resultModel.getCode(), resultModel.getMsg(), resultModel.getData().toString());
                }


            }
        } finally {
            value.close();
        }




    }


    private String decodeResult(String original) throws JSONException, UnsupportedEncodingException {
        JSONObject result = new JSONObject(original);
        if (result.has("salt") && result.has("body")) {
            String salt = result.getString("salt");
            String body = result.getString("body");
            if (!TextUtils.isEmpty(body)) {
                String key = DigestUtils.md5(salt + DigestUtils.E_KEY);
                String json = new String(Des3Utils.des3DecodeECB(key,
                        DigestUtils.decodeBase64(body.getBytes("utf-8"))),
                        "utf-8");
                if (json.length() > 0 && json.charAt(0) == '[') {
                    result.put("body", new JSONArray(json));
                } else {
                    result.put("body", new JSONObject(json));
                }
            }
        }

        return result.toString();
    }
}
