package com.ageofaquarius.proximacentauri.gaming.entity;

import java.util.List;

/**
 * Created by Mars on 2016-11-19.
 */

public interface SupportiveMapObject extends MapObject {

    List<Structure> getSupportingStructure();

    List<Unit> getSupportingUnits();

    SupportiveMapObject getSupportedBy();

    void setSupportedBy(SupportiveMapObject supporter);
}
