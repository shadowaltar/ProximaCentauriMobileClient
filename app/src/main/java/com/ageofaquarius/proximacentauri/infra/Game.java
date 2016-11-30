package com.ageofaquarius.proximacentauri.infra;

import com.ageofaquarius.proximacentauri.gaming.Planet;
import com.ageofaquarius.proximacentauri.gaming.entity.Unit;
import com.ageofaquarius.proximacentauri.gaming.environment.Map;
import com.ageofaquarius.proximacentauri.gaming.environment.MapType;
import com.ageofaquarius.proximacentauri.gaming.faction.Faction;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by Mars on 2016-11-17.
 */

public class Game {

    // game statuses

    private int maxAllowedRound;
    private int round;
    private boolean isInVictoryStatus;

    // player statuses

    private Player currentPlayer;
    private Player nextPlayer;
    private Queue<Player> playerQueue = new LinkedList<>();

    // planet statuses

    private Planet planet;

    public Game(GameSettings settings, SavedGameInfo savedGame) {
        if (savedGame == null) {
            playerQueue.addAll(settings.getPlayers());
        } else {
            playerQueue.addAll(savedGame.getPlayers());
        }
    }

    public Map initializeMap(MapType mapType, int width, int height,
                             GameSettings settings, SavedGameInfo savedGame) {
        Map map = new Map();
        map.mapType = mapType;
        map.width = width;
        map.height = height;
        maxAllowedRound = settings.getMaxAllowedRound();
        round = 0;
        generateTerrain(map);
        if (savedGame == null) {
            placeUnits(map, savedGame.getUnits());
        } else {
            placeUnits(map, GameFactory.getNewGameUnits());
        }
        return map;
    }

    public void generateTerrain(Map map) {

    }

    public void placeUnits(Map map, Set<Unit> units) {

    }

    public boolean nextRound() {
        return false;
    }

    public Faction getCurrentFaction() {
        return currentPlayer.getFaction();
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

    public void runFactionPhrase(Player player) {

    }

    public Player nextPlayer() {
        playerQueue.add(currentPlayer);
        currentPlayer = playerQueue.poll();
        if (playerQueue.size() > 1) {
            nextPlayer = playerQueue.peek();
        } else {
            isInVictoryStatus = true;
        }
        return currentPlayer;
    }

    public boolean hasNextPlayer() {
        return playerQueue.size() > 1;
    }

    public boolean hasNextRound() {
        return hasNextPlayer() && !isMaxAllowedRoundReached();
    }

    private boolean isMaxAllowedRoundReached() {
        return round > maxAllowedRound;
    }

    public void runPlanetPhrase() {
    }
}