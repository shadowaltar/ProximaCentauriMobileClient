package com.ageofaquarius.proximacentauri.gaming.entity;

import com.ageofaquarius.proximacentauri.gaming.Effect;
import com.ageofaquarius.proximacentauri.gaming.environment.RealmType;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

/**
 * Created by Mars on 2016-11-06.
 */

public class Chassis extends Entity
        implements HasHealthBar, HasCost {

    public float movementPoint;
    public float actionPoint;
    public float buildCost;
    public String realm;
    public List<String> factions = new ArrayList<>();

    public List<Effect> onAttackedEffects = new ArrayList<>();
    public List<Effect> onDestroyedEffects = new ArrayList<>();

    private RealmType stationingRealm;


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
}
