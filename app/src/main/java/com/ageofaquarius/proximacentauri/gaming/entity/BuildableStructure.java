package com.ageofaquarius.proximacentauri.gaming.entity;

import java.util.Set;

public interface BuildableStructure extends Buildable {

    Set<MapObject> getMutualExclusiveObjectsOnMap();
}
