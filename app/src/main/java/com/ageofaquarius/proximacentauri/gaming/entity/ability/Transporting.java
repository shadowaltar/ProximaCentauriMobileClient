package com.ageofaquarius.proximacentauri.gaming.entity.ability;

/**
 * Created by Mars on 2016-11-20.
 */

public class Transporting extends Capability {
    public static final String GROUP_NAME = "TRANSPORTINGADDON";

    private int capacity;
    private int currentOccupiedCapacity;

    public int getCurrentOccupiedCapacity() {
        return currentOccupiedCapacity;
    }

    public void setCurrentOccupiedCapacity(int currentOccupiedCapacity) {
        this.currentOccupiedCapacity = currentOccupiedCapacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
