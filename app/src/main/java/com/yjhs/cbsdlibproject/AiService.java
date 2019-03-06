package com.yjhs.cbsdlibproject;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class AiService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("TAG", "onBind");
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("TAG", "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("TAG", "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.e("TAG", "onDestroy");
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("TAG", "onUnbind");
        return super.onUnbind(intent);
    }
}
