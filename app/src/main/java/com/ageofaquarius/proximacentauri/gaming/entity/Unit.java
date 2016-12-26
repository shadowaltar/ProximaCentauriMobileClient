package com.ageofaquarius.proximacentauri.gaming.entity;

import com.ageofaquarius.proximacentauri.gaming.environment.Coordinate;
import com.ageofaquarius.proximacentauri.gaming.environment.RealmType;

import java.util.List;
import java.util.Set;

/**
 * Unit include troops, map structures/terraforming objects, and cities.
 */

public abstract class Unit extends Entity
        implements MapObject {

    private String type;
    private String customName;

    private int allowedAddonCount;

    private int killCount;
    private int level;
    private double experience;

    private double movementPoints;
    private double currentMovementPoints;
    private String currentRealmType;
    private List<String> allowedRealmTypes;

    private double actionPoints;
    private double currentActionPoints;

    private int transportingSize;
    private boolean isTransportable;

    private String layer;

    @Override
    public Coordinate getCoordinate() {
        return null;
    }

    @Override
    public RealmType getCurrentRealm() {
        return null;
    }

    @Override
    public Set<RealmType> getAllowedRealms() {
        return null;
    }
}
