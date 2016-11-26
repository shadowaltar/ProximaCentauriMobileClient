package com.ageofaquarius.proximacentauri.gaming.entity.ability;

import com.ageofaquarius.proximacentauri.gaming.entity.MapObject;
import com.ageofaquarius.proximacentauri.utility.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mars on 2016-11-20.
 */

public class Manufacturing extends Capability {
    public static final String GROUP_NAME = "FACTORYADDON";

    private ArrayList<MapObject> allowedItems = new ArrayList<>();
    private ArrayList<MapObject> ongoingItems = new ArrayList<>();
    private ArrayList<MapObject> pausedItems = new ArrayList<>();
    private Map<MapObject, MapObject[]> prerequisiteItems = new HashMap<>();

    public List<MapObject> getAllowedItems() {
        return allowedItems;
    }

    public List<MapObject> getOngoingItems() {
        return ongoingItems;
    }

    public List<MapObject> getPausedItems() {
        return pausedItems;
    }

    public MapObject getPrerequisiteItem(MapObject object) {
        MapObject[] items = prerequisiteItems.get(object);
        if (items == null || items.length == 0)
            return null;
        return items[0];
    }

    public MapObject[] getPrerequisiteItems(MapObject object) {
        return prerequisiteItems.get(object);
    }

    public void addPrerequisiteItems(MapObject object, MapObject[] prerequisites) {
        MapObject[] items = prerequisiteItems.get(object);
        if (items == null) {
            prerequisiteItems.put(object, prerequisites);
        } else {
            prerequisiteItems.put(object, Arrays.concatAll(items, prerequisites));
        }
    }
}
