package com.ageofaquarius.proximacentauri.gaming.entity;

import java.util.Dictionary;

/**
 * Created by Mars on 2016-11-18.
 */

public interface HasCost {
    Dictionary<String, Double> getCosts();
    double getCost(String resourceName);
}
