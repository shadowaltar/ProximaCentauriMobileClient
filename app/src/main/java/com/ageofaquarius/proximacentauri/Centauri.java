package com.ageofaquarius.proximacentauri;

import com.ageofaquarius.proximacentauri.gaming.faction.Faction;
import com.ageofaquarius.proximacentauri.infra.Game;
import com.ageofaquarius.proximacentauri.infra.GameFactory;
import com.ageofaquarius.proximacentauri.infra.Player;
import com.ageofaquarius.proximacentauri.infra.RoundStatus;

import java.util.List;

/**
 * Created by Mars on 2016-11-28.
 */

public class Centauri {
    public static void newGame() {
        Game game = GameFactory.newGame();
        Centauri.start(game);
    }

    public static void continueGame() {
        List<Game> games = GameFactory.getSavedGames();
        Centauri.start(games.get(0));
    }

    public static void loadGame() {
        List<Game> games = GameFactory.getSavedGames();
        Game game = GameUI.selectSavedGame(games);
        Centauri.start(game);
    }

    public static void goGameSetting() {
    }

    public static void goCredit() {
    }

    private static void start(Game game) {
        ROUND:
        while (game.nextRound()) {
            while (game.hasNextPlayer()) {
                Player player = game.nextPlayer();
                game.runFactionPhrase(player);
            }
            if (game.hasNextRound())
                game.runPlanetPhrase();
        }

        game.calculateEndGame();
        GameUI.showEndGame(game);
    }
}
