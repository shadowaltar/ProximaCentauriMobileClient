package com.ageofaquarius.proximacentauri.infra;

import java.util.HashMap;

/**
 * Created by Mars on 2017-01-05.
 */

public class DefinitionSchema {
    private String name;
    private boolean global;
    private boolean useSpecialClass;
    private boolean predefined;
    private HashMap<String, DefinitionColumn> columns = new HashMap<>();
    private HashMap<String, Object> otherSettings = new HashMap<>();

    public HashMap<String, DefinitionColumn> getColumns() {
        return columns;
    }

    public HashMap<String, Object> getOtherSettings() {
        return otherSettings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGlobal() {
        return global;
    }

    public void setGlobal(boolean global) {
        this.global = global;
    }

    public boolean isUseSpecialClass() {
        return useSpecialClass;
    }

    public void setUseSpecialClass(boolean useSpecialClass) {
        this.useSpecialClass = useSpecialClass;
    }

    public boolean isPredefined() {
        return predefined;
    }

    public void setPredefined(boolean predefined) {
        this.predefined = predefined;
    }
}
