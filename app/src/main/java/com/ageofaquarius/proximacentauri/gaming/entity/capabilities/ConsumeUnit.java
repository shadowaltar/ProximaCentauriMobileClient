package com.ageofaquarius.proximacentauri.gaming.entity.capabilities;

import com.ageofaquarius.proximacentauri.gaming.entity.MapObject;

import java.util.HashSet;

/**
 * Created by Mars on 2016-12-20.
 */

public class ConsumeUnit extends Capability {
    private HashSet<MapObject> objectsBeingConsumed;
    private Capability effectAfterConsumed;
}
