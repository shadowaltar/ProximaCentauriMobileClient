package com.ageofaquarius.proximacentauri.gaming.entity;

import com.ageofaquarius.proximacentauri.gaming.environment.Coordinate;

import java.util.Set;

/**
 * Created by Mars on 2016-11-18.
 */

public class Contour {

    public Contour() {
    }

    public Contour(Set<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    private Set<Coordinate> coordinates;

    public Set<Coordinate> getCoordinates() {
        return coordinates;
    }

    int getSize() {
        if (coordinates == null)
            return 1;
        return coordinates.size();
    }
}
