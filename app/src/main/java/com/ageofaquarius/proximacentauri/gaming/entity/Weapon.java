package com.ageofaquarius.proximacentauri.gaming.entity;

import com.ageofaquarius.proximacentauri.gaming.Effect;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mars on 2016-11-06.
 */

public class Weapon extends Entity {
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
    private List<String> factions = new ArrayList<>();
    private List<String> allowedChassis = new ArrayList<>();
    private List<String> affectedGroups = new ArrayList<>();
    private List<Effect> normalEffects = new ArrayList<>();
    private List<Effect> onAttackedEffects = new ArrayList<>();

    private HealthBar health;
}
