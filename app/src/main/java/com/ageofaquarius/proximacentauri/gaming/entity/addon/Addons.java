package com.ageofaquarius.proximacentauri.gaming.entity.addon;

import com.ageofaquarius.proximacentauri.gaming.entity.MapObject;
import com.ageofaquarius.proximacentauri.gaming.entity.ability.Manufacturing;
import com.ageofaquarius.proximacentauri.gaming.entity.ability.Transporting;
import com.ageofaquarius.proximacentauri.gaming.entity.addon.Addon;

/**
 * Created by Mars on 2016-11-20.
 */

public class Addons {
    public static <T> T getAddon(MapObject object, String name) {
        Addon addon = object.getAddons().get(name);
        return (T) addon;
    }

    public static boolean hasAddon(MapObject object, String name) {
        return object.getAddons().containsKey(name);
    }

    public static boolean isTransporter(MapObject object) {
        return hasAddon(object, Transporting.GROUP_NAME);
    }

    public static boolean isFactory(MapObject object) {
        return hasAddon(object, Manufacturing.GROUP_NAME);
    }
}
