package ru.bagautdinov.service;

import ru.bagautdinov.models.Game;
import ru.bagautdinov.models.Player;

public class NewGameService {
    private static Game currentGame;
    private Game newCollectedGame;


    public Game makeNewGame(Player player) {
        if (currentGame == null) {
            currentGame = new Game();
            currentGame.setPlayer1(player);
            newCollectedGame = currentGame;
        } else {
            currentGame.setPlayer2(player);
            newCollectedGame = currentGame;
            currentGame = null;
        }
        return newCollectedGame;
    }
}
