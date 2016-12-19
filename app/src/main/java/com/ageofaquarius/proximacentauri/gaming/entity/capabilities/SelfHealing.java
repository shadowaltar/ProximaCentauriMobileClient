package com.ageofaquarius.proximacentauri.gaming.entity.capabilities;

/**
 * Created by Mars on 2016-12-18.
 */

public class SelfHealing extends Capability {
    public SelfHealing(HaveEndurance haveEndurance) {
        dependingOn = haveEndurance;
    }

    private double percentageHealingRate;
    private double percentageHealingCap;
}
