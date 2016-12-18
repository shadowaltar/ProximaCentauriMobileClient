package com.ageofaquarius.proximacentauri.gaming.entity.capabilities;

import com.ageofaquarius.proximacentauri.gaming.entity.MapObject;
import com.ageofaquarius.proximacentauri.gaming.entity.capabilities.utils.BuildProgress;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Mars on 2016-11-20.
 */

public class CanProduceUnit extends Capability {
    private HashSet<MapObject> allowedItems;
    private HashSet<BuildProgress> itemsInProgress;
    private HashSet<BuildProgress> pausedItems;

    private HashMap<String, Integer> simultaneouslyAllowedUnitCount;
}
