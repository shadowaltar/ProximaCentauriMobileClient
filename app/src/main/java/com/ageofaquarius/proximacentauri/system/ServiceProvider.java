package com.ageofaquarius.proximacentauri.system;

import android.content.Context;

/**
 * Created by Mars on 2016-12-26.
 */

public class ServiceProvider {

    private Context applicationContext;

    private static ServiceProvider instance = new ServiceProvider();

    private ServiceProvider() {
    }

    public static ServiceProvider getInstance(){
        return instance;
    }

    public void setAppContext(Context context) {
        applicationContext = context;
    }

    public Context getAppContext() {
        return applicationContext;
    }
}
