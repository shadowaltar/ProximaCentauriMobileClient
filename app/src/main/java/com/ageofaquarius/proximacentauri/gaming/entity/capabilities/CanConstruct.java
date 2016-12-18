package com.ageofaquarius.proximacentauri.gaming.entity.capabilities;

import com.ageofaquarius.proximacentauri.gaming.entity.MapObject;
import com.ageofaquarius.proximacentauri.gaming.entity.capabilities.utils.BuildProgress;
import com.ageofaquarius.proximacentauri.gaming.environment.Tile;

import java.util.HashSet;

/**
 * Created by Mars on 2016-12-18.
 */

public class CanConstruct extends Capability {
    private HashSet<MapObject> allowedItems;
    private BuildProgress itemInProgress;
    private BuildProgress pausedItem;
    private Tile buildingSite;
}
