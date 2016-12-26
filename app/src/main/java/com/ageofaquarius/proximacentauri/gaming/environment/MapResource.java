package com.ageofaquarius.proximacentauri.gaming.environment;

import com.ageofaquarius.proximacentauri.gaming.entity.MapObject;
import com.ageofaquarius.proximacentauri.gaming.entity.Resource;
import com.ageofaquarius.proximacentauri.gaming.entity.capabilities.Capability;

import java.util.Map;
import java.util.Set;

/**
 * Created by Mars on 2016-11-18.
 */

public class MapResource implements MapObject {

    private Coordinate coordinate;
    private Resource resource;

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

    @Override
    public String getLayer() {
        return null;
    }

    @Override
    public void setLayer(String layer) {
    }
    @Override
    public Map<String, Capability> getCapabilities() {
        return null;
    }
}
