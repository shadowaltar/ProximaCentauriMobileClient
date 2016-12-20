package com.ageofaquarius.proximacentauri.infra;

import com.ageofaquarius.proximacentauri.gaming.actions.Action;
import com.ageofaquarius.proximacentauri.gaming.entity.City;
import com.ageofaquarius.proximacentauri.gaming.entity.MapObject;
import com.ageofaquarius.proximacentauri.gaming.entity.Structure;
import com.ageofaquarius.proximacentauri.gaming.entity.capabilities.Capability;
import com.ageofaquarius.proximacentauri.gaming.faction.Faction;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Mars on 2016-12-20.
 */

public class Definitions {

    private HashMap<String, Capability> capabilities;
    private HashMap<String, MapObject> specialMapObjects;
    private HashMap<String, Action> mapObjectActions;
    private HashSet<String> resourceTypes;
    private HashMap<String, Structure> structures;
    private HashMap<String, City> cities;
    private HashMap<String, Faction> factions;

    public Definitions() {
    }

}
