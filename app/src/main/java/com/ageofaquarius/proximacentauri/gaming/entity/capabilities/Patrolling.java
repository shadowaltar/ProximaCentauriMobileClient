package com.ageofaquarius.proximacentauri.gaming.entity.capabilities;

import com.ageofaquarius.proximacentauri.gaming.entity.EntityAction;

import java.util.Set;

/**
 * Created by Mars on 2016-11-28.
 */

public class Patrolling extends Capability {
    public Patrolling(CanMove canMove) {
        dependingOn = canMove;
    }

    private Set<EntityAction> allowedActions;
}
