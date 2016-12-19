package com.ageofaquarius.proximacentauri.gaming.entity.capabilities;

import com.ageofaquarius.proximacentauri.gaming.entity.Unit;

import java.util.HashSet;

/**
 * Created by Mars on 2016-11-20.
 */

public class CanTransport extends Capability {

    private int capacity;
    private int currentOccupiedCapacity;
    private HashSet<Unit> allowedUnits;
    private HashSet<Unit> onboardUnits;
}
