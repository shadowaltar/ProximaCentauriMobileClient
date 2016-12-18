package com.ageofaquarius.proximacentauri.gaming.entity.capabilities;

import com.ageofaquarius.proximacentauri.gaming.entity.capabilities.utils.RealmVisibility;

import java.util.HashSet;

/**
 * Created by Mars on 2016-12-18.
 */

public class MinimapVisibility extends Capability {
    private boolean isVisible;
    private HashSet<RealmVisibility> visibilities;
}
