package com.ageofaquarius.proximacentauri.gaming.entity.capabilities;

import com.ageofaquarius.proximacentauri.gaming.entity.Entity;

/**
 * Created by Mars on 2016-11-20.
 */

public abstract class Capability extends Entity {
    protected boolean isEnabled;
    protected Capability dependingOn;
}
