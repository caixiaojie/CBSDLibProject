package com.yjhs.cbsdlib;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;


import com.yjhs.cbsdlib.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;


/**
 * Author:Ariana Wong
 * Date: 2017-12-17
 * Desctiption:
 */

public class CBSDApplication extends Application {
    public static CBSDApplication instances;

    private List<Activity> activities = new ArrayList<Activity>();

    @Override
    public void onCreate() {
        super.onCreate();
        instances = this;
        ToastUtil.init(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);//finally
    }

    public static CBSDApplication getInstance() {
        return instances;
    }


    public void addActivity(Activity activity){
        activities.add(activity);
    }
    public void removeActivity(Activity activity){
        if (activity!=null) {
            this.activities.remove(activity);
        }
    }
    public void finishActivity(Activity activity){
        if (activity!=null) {
            this.activities.remove(activity);
            activity.finish();
            activity = null;
        }
    }
    public void exit(){
        for (Activity activity : activities) {
            if (activity!=null) {
                activity.finish();
            }
        }
    }
    public Activity getTaskTop() {
        if (activities.size() > 0) {
            return activities.get(activities.size() - 1);
        }
        return null;
    }
}
