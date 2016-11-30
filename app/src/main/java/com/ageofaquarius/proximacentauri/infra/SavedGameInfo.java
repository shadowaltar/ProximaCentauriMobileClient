package com.ageofaquarius.proximacentauri.infra;

import com.ageofaquarius.proximacentauri.gaming.entity.Unit;
import com.ageofaquarius.proximacentauri.gaming.environment.Tile;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Mars on 2016-11-17.
 */

public class SavedGameInfo {
    public List<Tile> tiles = new ArrayList<>();

    private Set<Unit> units;
    private List<Player> players;

    public Set<Unit> getUnits() {
        return units;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
