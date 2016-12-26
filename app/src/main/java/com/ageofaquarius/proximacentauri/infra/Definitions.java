package com.ageofaquarius.proximacentauri.infra;

import com.ageofaquarius.proximacentauri.gaming.actions.Action;
import com.ageofaquarius.proximacentauri.gaming.actions.DiplomacyAction;
import com.ageofaquarius.proximacentauri.gaming.entity.City;
import com.ageofaquarius.proximacentauri.gaming.entity.MapObject;
import com.ageofaquarius.proximacentauri.gaming.entity.ResourceType;
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
import com.ageofaquarius.proximacentauri.util.FileAccess;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Mars on 2016-12-20.
 */

public class Definitions {

    private HashMap<String, ResourceType> resourceTypes = new HashMap<>();
    private HashMap<String, Capability> capabilities = new HashMap<>();

    private HashMap<String, Faction> factions = new HashMap<>();
    private HashMap<String, DiplomacyAction> diplomacyActions = new HashMap<>();
    private HashMap<String, TradingAction> tradingActions = new HashMap<>();
    private HashMap<String, GovernmentPolicy> governmentPolicies = new HashMap<>();
    private HashMap<String, SocietyIdeology> societyIdeologies = new HashMap<>();
    private HashMap<String, PoliticalSystem> politicalSystems = new HashMap<>();

    private HashMap<String, City> cities = new HashMap<>();
    private HashMap<String, Structure> structures = new HashMap<>();

    private HashMap<String, Unit> specialUnits = new HashMap<>();
    private HashMap<String, MapObject> specialMapObjects = new HashMap<>();

    private HashMap<String, Action> mapObjectActions = new HashMap<>();
    private HashMap<String, Component> mapObjectComponents = new HashMap<>();
    private HashMap<String, TemporaryStatus> mapObjectStatuses = new HashMap<>();

    public void load() {
        String[][] schema = DefinitionSchemas.getResourceTypes();
        String[][] data = FileAccess.readRawDefinitions(ResourceType.class);
        List<ResourceType> resourceTypes = FileAccess.construct(ResourceType.class, data, schema);
    }

}
