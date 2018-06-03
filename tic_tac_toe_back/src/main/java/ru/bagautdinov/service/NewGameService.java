package ru.bagautdinov.service;

import ru.bagautdinov.models.Game;
import ru.bagautdinov.models.Player;

public class NewGameService {
    private static Game currentGame;
    private Game newCollectedGame;


    public static Game makeNewGame(Player player) {
        if (currentGame == null) {
            currentGame = new Game();
            currentGame.setP1(player);
            newCollectedGame = currentGame;
        } else {
            currentGame.setP2(player);
            newCollectedGame = currentGame;
            currentGame = null;
        }
        return newCollectedGame;
    }
}
