package com.ageofaquarius.proximacentauri.gaming.entity.components;

import com.ageofaquarius.proximacentauri.gaming.entity.Contour;
import com.ageofaquarius.proximacentauri.gaming.entity.HealthBar;

import java.util.ArrayList;

/**
 * Created by Mars on 2016-11-06.
 */

public class UnitWeapon extends Component {
    private float attackStrength;
    private int attackPerRound;
    private float accuracy;
    private float actionPointCost;
    private float buildCost;
    private Contour attackShape;
    private int range;
    private int impactRange;
    private String attackType;
    private String damageGradient;
    private ArrayList<String> factions = new ArrayList<>();
    private ArrayList<String> allowedChassis = new ArrayList<>();
    private ArrayList<String> affectedGroups = new ArrayList<>();

    private HealthBar health;
}
