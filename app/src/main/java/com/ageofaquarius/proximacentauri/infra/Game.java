package com.ageofaquarius.proximacentauri.infra;

import com.ageofaquarius.proximacentauri.gaming.entity.Unit;
import com.ageofaquarius.proximacentauri.gaming.environment.Map;
import com.ageofaquarius.proximacentauri.gaming.environment.MapType;

import java.util.Set;

/**
 * Created by Mars on 2016-11-17.
 */

public class Game {

    public static Game startNewGame() {
        Game game = new Game();
        return game;
    }

    public static Game loadGame(){

    }

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
}
