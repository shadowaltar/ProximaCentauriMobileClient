package com.ageofaquarius.proximacentauri.gaming.entity;

import com.ageofaquarius.proximacentauri.gaming.environment.Realm;

import java.util.List;
import java.util.Set;

/**
 * Created by Mars on 2016-11-21.
 */

public interface Buildable {

    boolean isUnderConstruction();

    int getRequiredBuildRounds();

    double getInProgressBuildPoints();

    double getRequiredBuildPoints();
}

