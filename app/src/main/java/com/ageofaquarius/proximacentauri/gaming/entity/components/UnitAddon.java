package com.ageofaquarius.proximacentauri.gaming.entity.components;

import com.ageofaquarius.proximacentauri.gaming.entity.Entity;
import com.ageofaquarius.proximacentauri.gaming.entity.capabilities.Capability;

/**
 * Created by Mars on 2016-11-06.
 */

public class UnitAddon extends Component {

    private Capability capability;

    public Capability getCapability() {
        return capability;
    }

    public void setCapability(Capability capability) {
        this.capability = capability;
    }
}
