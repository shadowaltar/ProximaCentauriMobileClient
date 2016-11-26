package com.ageofaquarius.proximacentauri.gaming.entity;

import com.ageofaquarius.proximacentauri.gaming.tech.Technology;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mars on 2016-11-15.
 */

public abstract class Entity {

    private String name;
    private String displayName;
    private List<String> groupNames = new ArrayList<>();
    private List<Technology> technologyPrerequisites = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public List<String> getGroupNames() {
        return groupNames;
    }

    public List<Technology> getTechnologyPrerequisites() {
        return technologyPrerequisites;
    }
}
