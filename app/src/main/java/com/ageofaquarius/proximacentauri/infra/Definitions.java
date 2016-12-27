package com.ageofaquarius.proximacentauri.infra;

import android.content.Context;

import com.ageofaquarius.proximacentauri.ServiceLocator;
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
import com.ageofaquarius.proximacentauri.gaming.governing.TradingAction;
import com.ageofaquarius.proximacentauri.gaming.governing.policies.GovernmentPolicy;
import com.ageofaquarius.proximacentauri.gaming.governing.societies.PoliticalSystem;
import com.ageofaquarius.proximacentauri.gaming.governing.societies.SocietyIdeology;
import com.ageofaquarius.proximacentauri.util.FileAccess;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Mars on 2016-12-20.
 */

public class Definitions {

    public static final String NAME_COLUMN = "Name";

    private HashMap<String, ResourceType> resourceTypes = null;
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

    public void load(DefinitionSchemas schemas) {
        Context context = ServiceLocator.getAppContext();
        ArrayList<String> classNames = schemas.getClassNames();
        for (String className : classNames) {
            try {
                int key = schemas.getResourceKey(className);
                ArrayList<String[]> data = FileAccess.readTextFileAsArray(context, key);
                HashMap<String, String[]> schema = schemas.getSchema(className);
                Class theClass = schemas.getClass(className);
                resourceTypes = construct(theClass, data, schema);
            } catch (DefinitionSchemaException e) {
                e.printStackTrace();
            }
        }
    }


    public static <T> HashMap<String, T> construct(Class definitionClass,
                                                   ArrayList<String[]> data,
                                                   HashMap<String, String[]> colDefinitions) {
        HashMap<String, T> results = new HashMap<>();
        try {
            if (!colDefinitions.containsKey("HEADER")
                    || !colDefinitions.containsKey("TYPE")
                    || !colDefinitions.containsKey("FIELD")
                    || !colDefinitions.get("HEADER")[0].equals("NAME")
                    || !colDefinitions.get("TYPE")[0].equals("STRING"))
                // must be two sets of strings: 1st is col name, 2nd is col type.
                // 1st column must be NAME (STRING).
                throw new DefinitionSchemaException();
            String[] headers = colDefinitions.get("HEADER");
            String[] typeHints = colDefinitions.get("TYPE");
            String[] fieldNames = colDefinitions.get("FIELD");
            int colCount = headers.length;
            String[] dataHeaderRow = data.get(0);

            for (int i = 0; i < dataHeaderRow.length; i++) {
                if (!headers[i].equals(dataHeaderRow[i]))
                    // colDefinition and header row must match.
                    throw new DefinitionSchemaException();
            }

            data.remove(0);
            for (String[] row : data) {
                String instanceName = "";
                Object instance = definitionClass.newInstance();
                for (int i = 0; i < colCount; i++) {
                    String value = row[i];
                    String fieldName = fieldNames[i];
                    String typeHint = typeHints[i];
                    Method method;
                    switch (typeHint) {
                        case "STRING":
                            method = definitionClass.getMethod("set" + fieldName, String.class);
                            method.invoke(instance, value);
                            break;
                        case "INTEGER":
                            method = definitionClass.getMethod("set" + fieldName, Integer.class);
                            method.invoke(instance, Integer.parseInt(value));
                            break;
                        case "DOUBLE":
                            method = definitionClass.getMethod("set" + fieldName, Double.class);
                            method.invoke(instance, Double.parseDouble(value));
                            break;
                        case "BOOLEAN":
                            method = definitionClass.getMethod("set" + fieldName, Boolean.class);
                            method.invoke(instance, Boolean.parseBoolean(value));
                            break;
                        case "INTEGERS":
                            Class intArrayCls = Class.forName("[L" + Integer.class.getName() + ";");
                            method = definitionClass.getMethod("set" + fieldName, intArrayCls);
                            String[] intStrings = value.split(",");
                            int[] intResults = new int[intStrings.length];
                            for (int j = 0; j < intStrings.length; j++)
                                intResults[j] = Integer.parseInt(intStrings[j]);
                            method.invoke(instance, intResults);
                            break;
                        case "DOUBLES":
                            Class dblArrayCls = Class.forName("[L" + Double.class.getName() + ";");
                            method = definitionClass.getMethod("set" + fieldName, dblArrayCls);
                            String[] doubleStrings = value.split(",");
                            int[] doubleResults = new int[doubleStrings.length];
                            for (int j = 0; j < doubleStrings.length; j++)
                                doubleResults[j] = Integer.parseInt(doubleStrings[j]);
                            method.invoke(instance, doubleResults);
                            break;
                        case "STRINGS":
                            Class strArrayCls = Class.forName("[L" + Double.class.getName() + ";");
                            method = definitionClass.getMethod("set" + fieldName, strArrayCls);
                            String[] strings = value.split(",");
                            method.invoke(instance, strings);
                            break;
                        default:
                            method = definitionClass.getMethod("set" + fieldName, Object.class);
                            method.invoke(instance, value);
                            break;
                    }
                    if (fieldName.equals(NAME_COLUMN)) {
                        instanceName = value;
                    }
                }
                results.put(instanceName, (T) instance);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (DefinitionSchemaException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return results;
    }

    public HashMap<String, ResourceType> getResourceTypes() {
        return resourceTypes;
    }

    public HashMap<String, Capability> getCapabilities() {
        return capabilities;
    }

    public HashMap<String, Faction> getFactions() {
        return factions;
    }

    public HashMap<String, DiplomacyAction> getDiplomacyActions() {
        return diplomacyActions;
    }

    public HashMap<String, TradingAction> getTradingActions() {
        return tradingActions;
    }

    public HashMap<String, GovernmentPolicy> getGovernmentPolicies() {
        return governmentPolicies;
    }

    public HashMap<String, SocietyIdeology> getSocietyIdeologies() {
        return societyIdeologies;
    }

    public HashMap<String, PoliticalSystem> getPoliticalSystems() {
        return politicalSystems;
    }

    public HashMap<String, City> getCities() {
        return cities;
    }

    public HashMap<String, Structure> getStructures() {
        return structures;
    }

    public HashMap<String, Unit> getSpecialUnits() {
        return specialUnits;
    }

    public HashMap<String, MapObject> getSpecialMapObjects() {
        return specialMapObjects;
    }

    public HashMap<String, Action> getMapObjectActions() {
        return mapObjectActions;
    }

    public HashMap<String, Component> getMapObjectComponents() {
        return mapObjectComponents;
    }

    public HashMap<String, TemporaryStatus> getMapObjectStatuses() {
        return mapObjectStatuses;
    }
}
