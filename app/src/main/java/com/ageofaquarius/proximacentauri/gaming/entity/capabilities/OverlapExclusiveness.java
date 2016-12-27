package com.ageofaquarius.proximacentauri.gaming.entity.capabilities;

import com.ageofaquarius.proximacentauri.gaming.entity.MapObject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Capability that describes what entities can be overlapped to this entity and what cannot. Realm-
 * sensitive.
 */
public class OverlapExclusiveness extends Capability {
    private HashMap<String, HashSet<String>> deniedNames;
    private HashMap<String, HashSet<String>> allowedNames;
}
