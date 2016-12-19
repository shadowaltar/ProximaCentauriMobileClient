package com.ageofaquarius.proximacentauri.gaming.entity.capabilities;

import com.ageofaquarius.proximacentauri.gaming.entity.MapObject;
import com.ageofaquarius.proximacentauri.gaming.entity.Resources;
import com.ageofaquarius.proximacentauri.gaming.environment.Coordinate;
import com.ageofaquarius.proximacentauri.gaming.environment.Realm;

import java.util.HashMap;

/**
 * Created by Mars on 2016-12-19.
 */

public class HoldPopulatedTerritory extends Capability {
    private int radius;
    private Realm realm;
    private MapObject territoryProvider;
    private HashMap<Coordinate, Resources> resourceOutputs;
}
