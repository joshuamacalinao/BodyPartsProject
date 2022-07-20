package com.juswa.bodyparts.shared;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {

    public static final String TAG = "Body";
    private static SharedPref application;
    private static Context cont;



    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;
    private static final String SHARED_DATA = "SHARED_DATA";
    private static final String SHARED_SPLASH = "false";
    private static final String SoungON = "SoungON";


    public SharedPref(Context context){
        cont = context;
    }

    public static synchronized SharedPref getInstance(Context context){
        if(application == null){
            application = new SharedPref(context);
        }
        return application;
    }

    public boolean setFinishSplash(boolean b){
        editor = sharedPreferences.edit();
        editor.putBoolean(SHARED_SPLASH,b);
        editor.apply();
        return true;
    }

    public boolean soundON(){
        editor = sharedPreferences.edit();
        editor.putBoolean(SoungON,true);
        editor.apply();
        return true;
    }

    public boolean soundOFF(){
        editor = sharedPreferences.edit();
        editor.putBoolean(SoungON,false);
        editor.apply();
        return true;
    }

    public boolean sound(){
        sharedPreferences = cont.getSharedPreferences(SHARED_DATA,Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(SoungON, true);
    }

    public boolean finishSplash(){
        sharedPreferences = cont.getSharedPreferences(SHARED_DATA,Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(SHARED_SPLASH, false);
    }

}
