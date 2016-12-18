package com.ageofaquarius.proximacentauri.gaming.entity.capabilities;

import java.util.List;
import java.util.Map;

/**
 * Created by Mars on 2016-11-21.
 */

public class Populated extends Capability {
    public static final String NAME = "Populated";

    public static final String Starving = "STARVINGPOPSTATUS";
    public static final String Plague = "PLAGUEPOPSTATUS";

    private int currentPopulation;
    private Map<String, List<Double>> requiredResources;
    private double currentResourceAcquired;
    private boolean maxPopulation;
    private double growthRate;
    private boolean isFrozen;
}
