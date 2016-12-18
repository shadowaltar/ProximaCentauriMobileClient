package com.ageofaquarius.proximacentauri.gaming.entity.components.addon;

import com.ageofaquarius.proximacentauri.gaming.entity.capabilities.Capability;
import com.ageofaquarius.proximacentauri.gaming.entity.components.Addon;
import com.ageofaquarius.proximacentauri.gaming.environment.Coordinate;

import java.util.Set;

/**
 * Created by Mars on 2016-11-21.
 */

public class FieldGenerating extends Addon {
    private int minimumItemCount;
    private int maximumDistance;
    private Set<Coordinate> affectingArea;
    private Capability capability;
}
