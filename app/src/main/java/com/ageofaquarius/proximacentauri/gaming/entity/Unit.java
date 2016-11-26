package com.ageofaquarius.proximacentauri.gaming.entity;

import com.ageofaquarius.proximacentauri.gaming.entity.ability.Transporting;
import com.ageofaquarius.proximacentauri.gaming.entity.addon.Addon;
import com.ageofaquarius.proximacentauri.gaming.environment.Coordinate;
import com.ageofaquarius.proximacentauri.gaming.environment.RealmType;
import com.ageofaquarius.proximacentauri.gaming.faction.Faction;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Unit include troops, map structures/terraforming objects, and cities.
 */

public abstract class Unit extends Entity
        implements Controllable, MapObject, HasHealthBar, HasExperience, HasCost {

    private String type;
    private String customName;

    private Weapon primaryWeapon;
    private List<Weapon> weapons;
    private Armor armor;
    private Engine engine;
    private Chassis chassis;
    private Map<String, Addon> addons = new HashMap<>();
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
    private List<Chassis> allowedBoardingOnChassis;

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
    public boolean isInvincible() {
        return false;
    }

    @Override
    public String getLayer() {
        return layer;
    }

    @Override
    public void setLayer(String layer) {
        this.layer = layer;
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
    public HealthBar getHealthBar() {
        return null;
    }

    @Override
    public List<HealthBar> getHealthBars() {
        return null;
    }

    @Override
    public Dictionary<String, Double> getCosts() {
        return null;
    }

    @Override
    public double getCost(String resourceName) {
        return 0;
    }

    @Override
    public int getExperience() {
        return 0;
    }

    @Override
    public void setExperience(int experience) {

    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public void setLevel(int level) {

    }

    @Override
    public double getCurrentExperiencePoint() {
        return 0;
    }

    @Override
    public void setCurrentExperiencePoint(double currentExperiencePoint) {

    }

    @Override
    public double[] getExperiences() {
        return new double[0];
    }

    @Override
    public void setExperiences(double[] experiences) {

    }

    @Override
    public int getMaxLevel() {
        return 0;
    }

    @Override
    public void setMaxLevel(int maxLevel) {

    }

    public boolean isTransporter() {
        return addons.containsKey(Transporting.GROUP_NAME);
    }

    public int getTransporterCapacity() {
        if (isTransporter())
            return ((Transporting)addons.get(Transporting.GROUP_NAME).getCapability())
                    .getCapacity();
        return 0;
    }

    public int getOccupiedTransporterCapacity() {
        if (isTransporter())
            return ((Transporting)addons.get(Transporting.GROUP_NAME).getCapability())
                    .getCurrentOccupiedCapacity();
        return 0;
    }
}
