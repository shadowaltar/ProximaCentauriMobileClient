package com.ageofaquarius.proximacentauri.gaming.entity.capabilities;

import com.ageofaquarius.proximacentauri.gaming.entity.MapObject;

import java.util.ArrayList;

/**
 * Created by Mars on 2016-12-20.
 */

public class CanMorph extends Capability {
    private ArrayList<MapObject> targets;
    private MapObject source;
    private int morphSpeed;
    private boolean isInvincibleDuringMorphing;
}
