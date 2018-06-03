package ru.bagautdinov.utils;

import ru.bagautdinov.models.Game;
import ru.bagautdinov.models.Player;
import ru.bagautdinov.service.NewGameService;
import ru.bagautdinov.service.PerformTurnService;

public class CommadnsHandler {

    public void proceedCommand(String command, Game game, Player player) {
        String[] commands = command.split(" ");
        if (commands[0].equals("init") && (game == null)) {
            NewGameService.makeNewGame(player);
        } else if (commands[0].equals("turn")) {
            PerformTurnService.makeTurn(player,game, Integer.parseInt(commands[1]), Integer.parseInt(commands[2]));
        }
    }



}
