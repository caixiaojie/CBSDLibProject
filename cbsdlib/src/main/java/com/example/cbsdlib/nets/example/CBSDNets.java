package com.example.cbsdlib.nets.example;

import android.content.Context;
import android.util.Log;

import com.example.cbsdlib.CBSDApplication;
import com.example.cbsdlib.nets.BaseNet;
import com.example.cbsdlib.utils.AppSharedPreferences;

/**
 * Author:Ariana Wong
 * Date: 2017-12-18
 * Desctiption:
 */

public class CBSDNets extends BaseNet<CBSDApi> {


    private static CBSDNets Instance;

    protected CBSDNets(Context context) {
        super(context);
    }

    public static CBSDNets getInstance() {
        if (Instance == null) {
            Instance = new CBSDNets(CBSDApplication.getInstance());
        }
        return Instance;
    }

    @Override
    protected String getSfzh() {
        return "";
    }

    @Override
    protected String getCurrentToken() {
        Log.e("WLH","token:"+ AppSharedPreferences.getTOKEN());
        return AppSharedPreferences.getTOKEN();
    }

    @Override
    protected long getCurrentUserId() {
        return 0;
    }

    @Override
    protected Class<CBSDApi> getApiClazz() {
        return CBSDApi.class;
    }

    @Override
    protected String getBaseUrl() {
        return CBSDApi.baseUrl;
    }
}
