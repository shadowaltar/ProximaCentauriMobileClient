package com.ageofaquarius.proximacentauri.gaming.environment;

import com.ageofaquarius.proximacentauri.gaming.entity.Contour;
import com.ageofaquarius.proximacentauri.gaming.entity.MapObject;

import java.util.List;

/**
 * Created by Mars on 2016-11-18.
 */

public class MapResource implements MapObject {

    private Coordinate coordinate;
    public String resourceType;

    @Override
    public Coordinate getCoordinate() {
        return null;
    }

    @Override
    public RealmType getCurrentRealm() {
        return null;
    }

    @Override
    public List<RealmType> getAllowedRealms() {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public Contour getContour() {
        return null;
    }

    @Override
    public String getLayer() {
        return null;
    }

    @Override
    public void setLayer(String layer) {

    }
}
