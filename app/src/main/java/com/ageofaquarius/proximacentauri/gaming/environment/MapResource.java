package com.ageofaquarius.proximacentauri.gaming.environment;

import com.ageofaquarius.proximacentauri.gaming.entity.Contour;
import com.ageofaquarius.proximacentauri.gaming.entity.MapObject;
import com.ageofaquarius.proximacentauri.gaming.entity.components.Addon;
import com.ageofaquarius.proximacentauri.gaming.faction.Faction;

import java.util.*;
import java.util.Map;

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
    public Set<RealmType> getAllowedRealms() {
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

    @Override
    public boolean isMovable() {
        return false;
    }

    @Override
    public void setMovable(boolean movable) {

    }

    @Override
    public double getMovementPoint() {
        return 0;
    }

    @Override
    public void setMovementPoint(double movementPoint) {

    }

    @Override
    public int getMovementResetPerTurn() {
        return 0;
    }

    @Override
    public void setMovementResetPerTurn(int turns) {

    }

    @Override
    public int getSightRadius() {
        return 0;
    }

    @Override
    public void setSightRadius(int sightRadius) {

    }

    @Override
    public int getZoneOfControlRadius() {
        return 0;
    }

    @Override
    public void setZoneOfControlRadius(int zoneOfControlRadius) {

    }

    @Override
    public double getActionPoint() {
        return 0;
    }

    @Override
    public void setActionPoint(double actionPoint) {

    }

    @Override
    public int getActionResetPerTurn() {
        return 0;
    }

    @Override
    public void setActionResetPerTurn(int turns) {

    }

    @Override
    public int getLifeSpan() {
        return 0;
    }

    @Override
    public void setLifeSpan(int turns) {

    }

    @Override
    public Faction getOwner() {
        return null;
    }

    @Override
    public void setOwner(Faction faction) {

    }

    @Override
    public boolean isOccupiable() {
        return false;
    }

    @Override
    public void setOccupiable(boolean occupiable) {

    }

    @Override
    public Map<String, Addon> getAddons() {
        return null;
    }
}
