package com.ageofaquarius.proximacentauri.gaming.environment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Created by Mars on 2016-11-06.
 */

public class Map {
    public int width;
    public int height;
    public MapType mapType;
    public List<Realm> realms = new ArrayList<>();
    public HashMap<Coordinate,Tile> tiles = new HashMap<>();

    public void createTiles(long seed){

    }
}
