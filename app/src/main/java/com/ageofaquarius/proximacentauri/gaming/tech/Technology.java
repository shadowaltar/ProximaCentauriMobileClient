package com.ageofaquarius.proximacentauri.gaming.tech;

import com.ageofaquarius.proximacentauri.gaming.entity.Entity;

import java.util.Dictionary;
import java.util.Set;

/**
 * Created by Mars on 2016-11-19.
 */

public class Technology extends Entity {

    private TechType type;

    private int level;

    private Set<Technology> prerequisites;
}
