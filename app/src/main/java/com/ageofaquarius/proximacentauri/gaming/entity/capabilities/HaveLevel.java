package com.ageofaquarius.proximacentauri.gaming.entity.capabilities;

import com.ageofaquarius.proximacentauri.mechanism.ExperienceFormula;
import com.ageofaquarius.proximacentauri.gaming.entity.capabilities.utils.ExperienceGainingType;

/**
 * Created by Mars on 2016-12-19.
 */

public class HaveLevel extends Capability {
    private int currentExperience;
    private int currentLevel;
    private int maxLevel;
    private ExperienceGainingType type;
    private ExperienceFormula formula;
}
