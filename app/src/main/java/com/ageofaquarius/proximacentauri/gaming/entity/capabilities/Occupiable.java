package com.ageofaquarius.proximacentauri.gaming.entity.capabilities;

import java.util.Map;
import java.util.Set;

/**
 * Created by Mars on 2016-12-18.
 */

public class Occupiable extends Capability {
    private Set<String> allowedOccupierTypes;
    private Map<String, Integer> requiredOccupyTurns;
}
