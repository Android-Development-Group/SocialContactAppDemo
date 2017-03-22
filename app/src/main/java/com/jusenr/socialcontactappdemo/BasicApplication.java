package com.jusenr.socialcontactappdemo;

import android.app.Application;

/**
 * Created by T5-Jusenr on 2017/3/22.
 */

public class BasicApplication extends Application {

    public static String sdCardPath;

    @Override
    public void onCreate() {
        super.onCreate();

        sdCardPath = "";
    }
}
