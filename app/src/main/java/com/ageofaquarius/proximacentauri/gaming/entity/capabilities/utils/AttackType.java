package com.ageofaquarius.proximacentauri.gaming.entity.capabilities.utils;

/**
 * Created by Mars on 2016-12-19.
 */

public enum AttackType {

    /**
     * Attack simultaneously till one die.
     */
    DUAL,

    /**
     * Attack and then be retaliated.
     */
    TAKE_TURN,

    /**
     * Attack with no retaliation.
     */
    SINGLE_SIDED,

    /**
     * Counter attack (excluding duals).
     */
    COUNTERATTACK,

    /**
     * Attack along with a friendly unit, then be retaliated.
     */
    COVER,

    /**
     * Attack along with a friendly unit, without retaliation.
     */
    SINGLE_SIDED_COVER,

    /**
     * Attack the incoming missile.
     */
    MISSILE_INTERCEPT,
}