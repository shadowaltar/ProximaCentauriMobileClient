package com.ageofaquarius.proximacentauri.gaming.entity.addon;

import com.ageofaquarius.proximacentauri.gaming.entity.Entity;
import com.ageofaquarius.proximacentauri.gaming.entity.ability.Capability;

/**
 * Created by Mars on 2016-11-06.
 */

public class Addon extends Entity {

    private Capability capability;

    public Capability getCapability() {
        return capability;
    }

    public void setCapability(Capability capability) {
        this.capability = capability;
    }
}
