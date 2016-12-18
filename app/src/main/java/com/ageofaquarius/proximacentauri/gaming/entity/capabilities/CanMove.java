package com.ageofaquarius.proximacentauri.gaming.entity.capabilities;

import com.ageofaquarius.proximacentauri.gaming.environment.Realm;

/**
 * Created by Mars on 2016-11-21.
 */

public class CanMove extends Capability {

    private boolean isMovementPointRecoverable;
    private Realm realm;
    private double maxMovementPoints;
    private double currentMovementPoints;
    private double movementRecoveryRate;
}
