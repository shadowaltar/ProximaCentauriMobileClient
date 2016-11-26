package com.ageofaquarius.proximacentauri.infra;

/**
 * Created by Mars on 2016-11-19.
 */

public class GlobalContext {

    private static GlobalContext instance = null;

    private GlobalContext() {
    }

    public static GlobalContext getInstance() {
        if (instance == null) {
            instance = new GlobalContext();
        }
        return instance;
    }
}
