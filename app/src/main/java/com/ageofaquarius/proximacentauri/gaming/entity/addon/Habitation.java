package com.ageofaquarius.proximacentauri.gaming.entity.addon;

import java.util.List;
import java.util.Map;

/**
 * Created by Mars on 2016-11-21.
 */

public class Habitation extends Addon {
    public static final String Starving = "STARVINGPOPSTATUS";
    public static final String Plague = "PLAGUEPOPSTATUS";
    private int currentPopulation;
    private Map<String, List<Double>> requiredNutrients;
    private double currentNutrient;
    private boolean maximumPopulation;
    private double growthRate;
    private boolean isFrozen;
}
