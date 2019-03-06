package com.yjhs.cbsdlib.utils;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.yjhs.cbsdlib.CBSDApplication;

public class AppSharedPreferences {
    private static final String IsFisrtStart = "FISRT_START";
    private static final String USER_NAME = "USER_NAME";
    private static final String USER_ID = "USER_ID";
    private static final String TOKEN = "TOKEN";
    private static final String GRAFE = "GRADE";

    private static final String VerImg = "VERIMG";

    private static SharedPreferences getPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(CBSDApplication.getInstance().getApplicationContext());
    }

    public static void saveIsFisrtStart(boolean isFisrtStart) {
        getPreferences().edit().putBoolean(IsFisrtStart, isFisrtStart).apply();
    }

    public static boolean getIsFisrtStart() {
        return getPreferences().getBoolean(IsFisrtStart,false);
    }

    public static void setUserName(String userName){
        getPreferences().edit().putString(USER_NAME, userName).apply();
    }
    public static String getUserName() {
        return getPreferences().getString(USER_NAME,"");
    }
    public static void setUserGrade(String grade){
        getPreferences().edit().putString(GRAFE, grade).apply();
    }
    public static String getUserGrade() {
        return getPreferences().getString(GRAFE,"");
    }

    public static void setUserID(String userId){
        getPreferences().edit().putString(USER_ID, userId).apply();
    }
    public static String getUserId() {
        return getPreferences().getString(USER_ID,"");
    }
    public static void setToken(String token){
        getPreferences().edit().putString(TOKEN, token).apply();
    }

    public static String getTOKEN() {
        return getPreferences().getString(TOKEN,"");
    }

    private static String getVerImg(){
        return getPreferences().getString(VerImg,"");
    }

    public static void clear(){
        getPreferences().edit().clear().commit();
    }
}
