package com.ageofaquarius.proximacentauri.gaming.entity;

/**
 * Created by Mars on 2016-11-19.
 */

public class ZOC implements HasZOC {
    int zoneOfControlRadius;

    @Override
    public int getZoneOfControlRadius() {
        return zoneOfControlRadius;
    }

    @Override
    public void setZoneOfControlRadius(int zoneOfControlRadius) {
        this.zoneOfControlRadius = zoneOfControlRadius;
    }
}
