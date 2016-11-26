package com.ageofaquarius.proximacentauri.gaming.environment;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Mars on 2016-11-08.
 */

public class TerrainType {
    public static final String[] predefined = new String[]{
            "NONE",
            "LAND",
            "SEA",
            "AIR",
            "SPACE",
            "VOID",
    };

    public static final List<String> values = Arrays.asList(predefined);
}
