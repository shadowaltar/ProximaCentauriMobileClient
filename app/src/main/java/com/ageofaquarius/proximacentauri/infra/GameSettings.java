package com.ageofaquarius.proximacentauri.infra;

import java.util.Collection;
import java.util.List;

/**
 * Created by Mars on 2016-12-01.
 */
public class GameSettings {
    private int maxAllowedRound;
    private List<Player> players;

    public int getMaxAllowedRound() {
        return maxAllowedRound;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
