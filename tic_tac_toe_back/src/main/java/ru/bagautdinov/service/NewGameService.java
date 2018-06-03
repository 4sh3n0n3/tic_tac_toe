package ru.bagautdinov.service;

import org.springframework.stereotype.Service;
import ru.bagautdinov.Message;
import ru.bagautdinov.models.Game;
import ru.bagautdinov.models.Player;

import javax.websocket.EncodeException;
import javax.websocket.Session;
import java.io.IOException;
import java.util.Arrays;

@Service
public class NewGameService {
    private static Game currentGame;
    private Game newCollectedGame;


    public Game makeNewGame(Player player, Session s) throws IOException, EncodeException {
        Message outcomingMessageData=new Message();
        outcomingMessageData.setUsername("System");
        char x;
        if (currentGame == null) {
            currentGame = new Game();
            char[][] field=new char[3][3];
            Arrays.fill(field[0],' ');
            Arrays.fill(field[1],' ');
            Arrays.fill(field[2],' ');
            currentGame.setField(field);
            currentGame.setP1(player);
            x='X';
            currentGame.setP1Session(s);
            newCollectedGame = currentGame;
        } else {
            x='O';
            currentGame.setP2(player);
            currentGame.setP2Session(s);
            newCollectedGame = currentGame;
            currentGame = null;
        }
        outcomingMessageData.setMessage("set "+x);
        s.getBasicRemote().sendObject(outcomingMessageData);
        return newCollectedGame;
    }
}
