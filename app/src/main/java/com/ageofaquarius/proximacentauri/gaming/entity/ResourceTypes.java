package com.ageofaquarius.proximacentauri.gaming.entity;

import com.ageofaquarius.proximacentauri.gaming.entity.exceptions.InvalidResourceException;

/**
 * Created by Mars on 2016-11-19.
 */

public class ResourceTypes {

    public static final String ResourceGroup = "RESOURCE";

    private static final String[] MineralGroups = new String[]{"MINERAL", ResourceGroup};
    private static final String[] EnergyGroups = new String[]{"ENERGY", ResourceGroup};
    private static final String[] NutrientGroups = new String[]{"NUTRIENT", ResourceGroup};

//    public String[] getGroup(String type) {
//        switch (type) {
//            case MINERAL:
//                return MineralGroups;
//            case ENERGY:
//                return EnergyGroups;
//            case NUTRIENT:
//                return NutrientGroups;
//        }
//        throw new InvalidResourceException("Must provide correct BasicResourceType, given: "+ type);
//    }
}
