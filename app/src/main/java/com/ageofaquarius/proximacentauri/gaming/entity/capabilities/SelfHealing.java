package com.ageofaquarius.proximacentauri.gaming.entity.capabilities;

/**
 * Created by Mars on 2016-12-18.
 */

public class SelfHealing extends Capability {
    public SelfHealing(EnduranceEnabled enduranceEnabled) {
        dependingOn = enduranceEnabled;
    }

    private double percentageHealingRate;
    private double percentageHealingCap;
}
