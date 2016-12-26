package com.ageofaquarius.proximacentauri;

import android.content.Context;

/**
 * Created by Mars on 2016-12-26.
 */

public class ServiceLocator {

    private Context applicationContext;

    private static ServiceLocator instance;
    static {
        instance = new ServiceLocator();
    }

    public static void setAppContext(Context context){
        instance.applicationContext = context;
    }

    public static Context getAppContext(){
        return instance.applicationContext;
    }
}
