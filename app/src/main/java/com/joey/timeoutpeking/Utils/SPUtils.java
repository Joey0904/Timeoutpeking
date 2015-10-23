package com.joey.timeoutpeking.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * this is a encapsulation of SharedPreferences;
 * const SP_FILE_NAME is the filename of the file where contains SPs;
 * Created by Di on 10/13/15.
 */
public class SPUtils {

    public static void putBoolean(Context context, String key, boolean value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(MyConst.SP_FILE_NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().putBoolean(key, value).commit();
    }

    public static Boolean getBoolean(Context context, String key, boolean defValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(MyConst.SP_FILE_NAME, context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, defValue);
    }

    public static void putString(Context context, String key, String value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(MyConst.SP_FILE_NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().putString(key, value).commit();
    }

    public static String getString(Context context, String key, String defValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(MyConst.SP_FILE_NAME, context.MODE_PRIVATE);
        return sharedPreferences.getString(key, defValue);
    }

    public static void putInt(Context context, String key, int value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(MyConst.SP_FILE_NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().putInt(key, value).commit();
    }

    public static int getInt(Context context, String key, int defValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(MyConst.SP_FILE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(key, defValue);
    }


}
