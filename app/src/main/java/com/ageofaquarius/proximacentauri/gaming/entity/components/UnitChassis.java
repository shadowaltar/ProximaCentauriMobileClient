package com.ageofaquarius.proximacentauri.gaming.entity.components;

import com.ageofaquarius.proximacentauri.gaming.Effect;
import com.ageofaquarius.proximacentauri.gaming.environment.RealmType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mars on 2016-11-06.
 */

public class UnitChassis extends Component {

    public float movementPoint;
    public float actionPoint;
    public float buildCost;
    public String realm;
    public List<String> factions = new ArrayList<>();

    public List<Effect> onAttackedEffects = new ArrayList<>();
    public List<Effect> onDestroyedEffects = new ArrayList<>();

    private RealmType stationingRealm;
}
