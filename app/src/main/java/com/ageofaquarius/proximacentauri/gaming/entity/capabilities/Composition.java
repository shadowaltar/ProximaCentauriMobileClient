package com.ageofaquarius.proximacentauri.gaming.entity.capabilities;

import com.ageofaquarius.proximacentauri.gaming.entity.components.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Mars on 2016-12-18.
 */

public class Composition extends Capability {
    private HashSet<String> allowedComponentTypes;
    private ArrayList<Component> currentComponents;
}
