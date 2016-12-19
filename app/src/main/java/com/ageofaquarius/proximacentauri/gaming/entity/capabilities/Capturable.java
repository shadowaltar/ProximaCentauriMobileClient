package com.ageofaquarius.proximacentauri.gaming.entity.capabilities;

import com.ageofaquarius.proximacentauri.mechanism.Condition;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 * Created by Mars on 2016-12-18.
 */

public class Capturable extends Capability {
    private Set<String> allowedOccupierTypes;
    private ArrayList<Condition> occupiableConditions;
    private Map<String, Integer> requiredOccupyTurns;
}
