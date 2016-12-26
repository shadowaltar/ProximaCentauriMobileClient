package com.ageofaquarius.proximacentauri.gaming.entity;

import com.ageofaquarius.proximacentauri.gaming.entity.capabilities.Capability;
import com.ageofaquarius.proximacentauri.gaming.environment.Coordinate;
import com.ageofaquarius.proximacentauri.gaming.environment.RealmType;
import com.ageofaquarius.proximacentauri.gaming.faction.Faction;

import java.util.Map;
import java.util.Set;

/**
 * Created by Mars on 2016-11-18.
 */

public interface MapObject {

    Coordinate getCoordinate();
    RealmType getCurrentRealm();
    Set<RealmType> getAllowedRealms();

    String getLayer();
    void setLayer(String layer);

    Map<String, Capability> getCapabilities();
}


