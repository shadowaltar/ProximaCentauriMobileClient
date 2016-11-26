package com.ageofaquarius.proximacentauri.gaming.tech;

import com.ageofaquarius.proximacentauri.gaming.entity.Entity;
import com.ageofaquarius.proximacentauri.gaming.entity.HasCost;

import java.util.Dictionary;

/**
 * Created by Mars on 2016-11-19.
 */

public class Technology extends Entity implements HasCost {

    @Override
    public Dictionary<String, Double> getCosts() {
        return null;
    }

    @Override
    public double getCost(String resourceName) {
        return 0;
    }
}
