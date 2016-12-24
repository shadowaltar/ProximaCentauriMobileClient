package com.ageofaquarius.proximacentauri.infra;

import com.ageofaquarius.proximacentauri.gaming.actions.Action;
import com.ageofaquarius.proximacentauri.gaming.actions.DiplomacyAction;
import com.ageofaquarius.proximacentauri.gaming.entity.City;
import com.ageofaquarius.proximacentauri.gaming.entity.MapObject;
import com.ageofaquarius.proximacentauri.gaming.entity.Structure;
import com.ageofaquarius.proximacentauri.gaming.entity.Unit;
import com.ageofaquarius.proximacentauri.gaming.entity.capabilities.Capability;
import com.ageofaquarius.proximacentauri.gaming.entity.components.Component;
import com.ageofaquarius.proximacentauri.gaming.entity.statuses.TemporaryStatus;
import com.ageofaquarius.proximacentauri.gaming.faction.Faction;
import com.ageofaquarius.proximacentauri.gaming.governing.policies.GovernmentPolicy;
import com.ageofaquarius.proximacentauri.gaming.governing.TradingAction;
import com.ageofaquarius.proximacentauri.gaming.governing.societies.PoliticalSystem;
import com.ageofaquarius.proximacentauri.gaming.governing.societies.SocietyIdeology;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Mars on 2016-12-20.
 */

public class Definitions {

    private HashSet<String> resourceTypes;
    private HashMap<String, Capability> capabilities;

    private HashMap<String, Faction> factions;
    private HashMap<String, DiplomacyAction> diplomacyActions;
    private HashMap<String, TradingAction> tradingActions;
    private HashMap<String, GovernmentPolicy> governmentPolicies;
    private HashMap<String, SocietyIdeology> societyIdeologies;
    private HashMap<String, PoliticalSystem> politicalSystems;

    private HashMap<String, City> cities;
    private HashMap<String, Structure> structures;

    private HashMap<String, Unit> specialUnits;
    private HashMap<String, MapObject> specialMapObjects;

    private HashMap<String, Action> mapObjectActions;
    private HashMap<String, Component> mapObjectComponents;
    private HashMap<String, TemporaryStatus> mapObjectStatuses;

    public void load(){
        
    }

}
