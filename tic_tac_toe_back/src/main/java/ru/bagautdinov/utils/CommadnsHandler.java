package ru.bagautdinov.utils;

import org.springframework.beans.factory.annotation.Autowired;
import ru.bagautdinov.models.Game;
import ru.bagautdinov.models.Player;
import ru.bagautdinov.service.NewGameService;
import ru.bagautdinov.service.PerformTurnService;

public class CommadnsHandler {
    @Autowired
    NewGameService newGameService;
    @Autowired
    PerformTurnService performTurnService;

    public void proceedCommand(String command, Game game, Player player) {
        String[] commands = command.split(" ");
        if (commands[0].equals("init") && (game == null)) {
            newGameService.makeNewGame(player);
        } else if (commands[0].equals("turn")) {
            performTurnService.makeTurn(player,game, Integer.parseInt(commands[1]), Integer.parseInt(commands[2]));
        }
    }
}
