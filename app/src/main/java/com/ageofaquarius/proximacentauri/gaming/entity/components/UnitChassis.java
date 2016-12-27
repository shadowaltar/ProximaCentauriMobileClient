package com.ageofaquarius.proximacentauri.gaming.entity.components;

import com.ageofaquarius.proximacentauri.gaming.environment.RealmType;
import com.ageofaquarius.proximacentauri.gaming.events.Event;

import java.util.ArrayList;

/**
 * Created by Mars on 2016-11-06.
 */

public class UnitChassis extends Component {

    public float movementPoint;
    public float actionPoint;
    public float buildCost;
    public String realm;
    public ArrayList<String> factions = new ArrayList<>();

    public ArrayList<Event> onAttackedEffects = new ArrayList<>();
    public ArrayList<Event> onDestroyedEffects = new ArrayList<>();

    private RealmType stationingRealm;
}
