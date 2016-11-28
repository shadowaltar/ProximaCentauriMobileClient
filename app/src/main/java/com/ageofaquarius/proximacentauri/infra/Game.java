package com.ageofaquarius.proximacentauri.infra;

import com.ageofaquarius.proximacentauri.gaming.entity.Unit;
import com.ageofaquarius.proximacentauri.gaming.environment.Map;
import com.ageofaquarius.proximacentauri.gaming.environment.MapType;
import com.ageofaquarius.proximacentauri.gaming.faction.Faction;

import java.util.Set;

/**
 * Created by Mars on 2016-11-17.
 */

public class Game {


    private Faction currentActiveFaction;
    private Set<Unit> units;

    public Map initializeMap(MapType mapType, int width, int height) {
        Map map = new Map();
        map.mapType = mapType;
        map.width = width;
        map.height = height;
        generateTerrain(map);

        placeUnits(map,units);
        return map;
    }

    public void generateTerrain(Map map){

    }

    public void placeUnits(Map map, Set<Unit> units){

    }

    public boolean nextRound() {
        return false;
    }

    public Faction getCurrentActiveFaction() {
        
        return currentActiveFaction;
    }

    public boolean roundComplete() {
        return false;
    }

    public void performEnvironmentalActions() {
        
    }

    public void letComputerPerform(Faction currentPlayer) {

    }

    public void calculateEndGame() {

    }
}
