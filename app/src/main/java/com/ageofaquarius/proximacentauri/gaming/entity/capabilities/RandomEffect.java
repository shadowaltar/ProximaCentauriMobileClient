package com.ageofaquarius.proximacentauri.gaming.entity.capabilities;

import com.ageofaquarius.proximacentauri.gaming.entity.capabilities.utils.RandomEffectType;
import com.ageofaquarius.proximacentauri.gaming.events.Event;

import java.util.HashMap;

/**
 * Created by Mars on 2016-12-26.
 */

public class RandomEffect extends Capability {
    private HashMap<Event, Double> randomConsequences;
    private RandomEffectType type;
    private int effectiveTimes;
}
