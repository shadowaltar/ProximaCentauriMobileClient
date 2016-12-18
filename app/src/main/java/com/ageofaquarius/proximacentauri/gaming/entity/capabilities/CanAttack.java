package com.ageofaquarius.proximacentauri.gaming.entity.capabilities;

import com.ageofaquarius.proximacentauri.gaming.entity.capabilities.utils.AttackType;
import com.ageofaquarius.proximacentauri.gaming.entity.capabilities.utils.DamageGradientType;

/**
 * Created by Mars on 2016-12-18.
 */

public class CanAttack extends Capability {
    private AttackType type;

    private String damageType;
    private double damage;
    private double accuracy;
    private double actionPointRequired;

    private int range;
    private int impactRadius;
    private DamageGradientType damageGradient;
    private String[] effectiveGroups;
    private String[] ineffectiveGroups;
}
