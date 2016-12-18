package com.ageofaquarius.proximacentauri.gaming.entity.capabilities.utils;

public enum DamageGradientType {
    /**
     * Same damage applied to all tiles in impact range.
     */
    UNIFORM,
    /**
     * The farther from impact center tile the weaker damage applied.
     */
    DAMPING,
}
