package com.ageofaquarius.proximacentauri.gaming.entity;

import com.ageofaquarius.proximacentauri.gaming.entity.addon.Addon;
import com.ageofaquarius.proximacentauri.gaming.environment.Coordinate;
import com.ageofaquarius.proximacentauri.gaming.environment.RealmType;
import com.ageofaquarius.proximacentauri.gaming.faction.Faction;

import java.util.Map;
import java.util.Set;

/**
 * Created by Mars on 2016-11-18.
 */

public interface MapObject {

    // positioning and size attributes

    Coordinate getCoordinate();

    RealmType getCurrentRealm();

    Set<RealmType> getAllowedRealms();

    int getSize();

    Contour getContour();

    // rendering attributes

    String getLayer();

    void setLayer(String layer);

    // entity movement

    boolean isMovable();

    void setMovable(boolean movable);

    double getMovementPoint();

    void setMovementPoint(double movementPoint);

    int getMovementResetPerTurn();

    void setMovementResetPerTurn(int turns);

    // entity sight

    int getSightRadius();

    void setSightRadius(int sightRadius);

    // entity zoc

    int getZoneOfControlRadius();

    void setZoneOfControlRadius(int zoneOfControlRadius);

    // entity action point

    double getActionPoint();

    void setActionPoint(double actionPoint);

    int getActionResetPerTurn();

    void setActionResetPerTurn(int turns);

    // entity lifespan

    int getLifeSpan();

    void setLifeSpan(int turns);

    // entity ownership

    Faction getOwner();

    void setOwner(Faction faction);
    
    boolean isOccupiable();
    
    void setOccupiable(boolean occupiable);

    // entity functionality
    Map<String, Addon> getAddons();

}


