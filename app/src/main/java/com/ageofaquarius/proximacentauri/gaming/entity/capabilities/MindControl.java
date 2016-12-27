package com.ageofaquarius.proximacentauri.gaming.entity.capabilities;

import com.ageofaquarius.proximacentauri.gaming.entity.MapObject;

import java.util.HashSet;

/**
 * Created by Mars on 2016-12-20.
 */

public class MindControl extends Capability {
    private int maxDuration;
    private HashSet<MindControlStatus> currentControlledUnits;

    public class MindControlStatus {
        private MapObject target;
        private int controlledDuration;
    }
}
