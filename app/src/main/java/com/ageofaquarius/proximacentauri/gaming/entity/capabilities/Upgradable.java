package com.ageofaquarius.proximacentauri.gaming.entity.capabilities;

import com.ageofaquarius.proximacentauri.gaming.entity.MapObject;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Mars on 2016-11-21.
 */

public class Upgradable extends Capability {
    private boolean isUpgradable;
    private HashSet<MapObject> possibleUpgrades;
    private HashMap<MapObject, Resources> upgradeCosts;
    private HashMap<MapObject, Integer> upgradeTurns;
    private int currentUpgradingTurn;
}
