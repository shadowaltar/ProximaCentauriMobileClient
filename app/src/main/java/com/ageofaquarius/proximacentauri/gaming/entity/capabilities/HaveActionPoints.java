package com.ageofaquarius.proximacentauri.gaming.entity.capabilities;

/**
 * Created by Mars on 2016-12-18.
 */

public class HaveActionPoints extends Capability {
    public static final String NAME = "ActionEnabled";

    private boolean isActionPointRecoverable;
    private double maxActionPoints;
    private double currentActionPoints;
    private double actionPointRecoveryRate;
}
