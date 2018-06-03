package ru.bagautdinov.utils;

import ru.bagautdinov.models.Game;
import ru.bagautdinov.models.Player;

public class CommadnsHandler {

    public void proceedCommand(String command, Game game, Player player) {
        String[] commands = command.split(" ");
        if (commands[0].equals("init") && (game == null)) {
            makeGame(player);
        } else if (commands[0].equals("turn")) {
            makeTurn(game, commands[1], commands[2]);
        }
    }
}
