package com.ageofaquarius.proximacentauri.infra;

import com.ageofaquarius.proximacentauri.gaming.environment.Tile;
import com.ageofaquarius.proximacentauri.gaming.faction.Faction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mars on 2016-11-17.
 */

public class SavedGameInfo {
    public List<Tile> tiles = new ArrayList<>();
    public List<Faction> factions = new ArrayList<>();
}
