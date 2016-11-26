package com.ageofaquarius.proximacentauri.gaming.tech;

import com.ageofaquarius.proximacentauri.gaming.entity.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mars on 2016-11-18.
 */

public class Research extends Entity {
    public List<Research> prerequisites = new ArrayList<>();
    public String description;
    public int tier;
    public double totalEffort;
    public List<ResearchConsequence> consequences = new ArrayList<>();
}
