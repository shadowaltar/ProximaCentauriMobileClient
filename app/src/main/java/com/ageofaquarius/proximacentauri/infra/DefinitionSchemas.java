package com.ageofaquarius.proximacentauri.infra;

import java.util.HashMap;

/**
 * Created by Mars on 2016-12-25.
 */

public class DefinitionSchemas {
    private static String[][] resourceTypes = new String[2][];

    static {
        resourceTypes[0][0] = "NAME";
        resourceTypes[0][1] = "DISPLAY_NAME";
        resourceTypes[1][0] = "String";
        resourceTypes[1][1] = "String";
    }

    public static String[][] getResourceTypes() {
        return resourceTypes;
    }
}
