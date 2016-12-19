package com.ageofaquarius.proximacentauri.gaming.entity.capabilities;

import com.ageofaquarius.proximacentauri.gaming.entity.MapObject;

/**
 * Created by Mars on 2016-12-20.
 */

public class CanMorph extends Capability {
    private MapObject target;
    private MapObject source;
    private int morphSpeed;
    private boolean isInvincibleDuringMorphing;
}
