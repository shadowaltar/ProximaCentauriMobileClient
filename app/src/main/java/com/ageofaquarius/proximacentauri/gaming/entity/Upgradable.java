package com.ageofaquarius.proximacentauri.gaming.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Mars on 2016-11-21.
 */

public interface Upgradable {
    boolean isUpgradable();

    boolean isEnhanceable();

    List<Double> getRequiredExperiences();

    double getCurrentExperience();

    Set<MapObject> getAllowedEnhancementTarget();

    Map<MapObject, Map<String, Double>> getRequiredEnhancementResources();

    List<String> getLevelNames();
}
