package com.ageofaquarius.proximacentauri.gaming.entity.capabilities;

import com.ageofaquarius.proximacentauri.gaming.entity.MapObject;

import java.util.HashSet;

/**
 * Created by Mars on 2016-12-18.
 */

public class Transportable extends Capability {
    private int size;
    private HashSet<MapObject> allowedTransporters;
}
