package com.ageofaquarius.proximacentauri;

import com.ageofaquarius.proximacentauri.gaming.faction.Faction;
import com.ageofaquarius.proximacentauri.infra.Game;
import com.ageofaquarius.proximacentauri.infra.GameFactory;
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
            Faction currentPlayer = game.getCurrentActiveFaction();
            if (currentPlayer.isPlayer()) {
                while (!game.roundComplete()) {
                    RoundStatus status = GameUI.letUserPerform(game);
                    if (status != RoundStatus.NORMAL) {
                        break ROUND;
                    }
                }
            } else if (currentPlayer.isComputer()) {
                game.letComputerPerform(currentPlayer);
            }

            game.performEnvironmentalActions();
        }

        game.calculateEndGame();
        GameUI.showEndGame(game);
    }
}
