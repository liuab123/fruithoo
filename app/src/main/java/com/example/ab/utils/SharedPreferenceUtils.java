package com.example.ab.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.ab.base.App;

public class SharedPreferenceUtils {

    public static SharedPreferences getSharedPreferences(){
        return App.getInstance().getSharedPreferences("data", Context.MODE_PRIVATE);
    }

    public static void putString(String key,String value){
        SharedPreferences preferences = getSharedPreferences();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key,value);
        editor.apply();
    }

    public static String getString(String key){
        SharedPreferences preferences = getSharedPreferences();
        return preferences.getString(key,"");
    }

    public static void putBoolean(String key,boolean value){
        SharedPreferences preferences = getSharedPreferences();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key,value);
        editor.apply();
    }

    public static Boolean getBoolean(String key){
        SharedPreferences preferences = getSharedPreferences();
        return preferences.getBoolean(key,true);
    }

}
