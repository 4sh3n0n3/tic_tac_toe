package ru.bagautdinov.service;

import org.springframework.stereotype.Service;
import ru.bagautdinov.Message;
import ru.bagautdinov.models.Game;
import ru.bagautdinov.models.Player;

import javax.websocket.EncodeException;
import java.io.IOException;

/**
 * Created by User on 03.06.2018.
 */

@Service
public class PerformTurnService {
    public void makeTurn(Player player, Game game, int a, int b) throws IOException, EncodeException {
        int currentPlayer=game.getCounter()%2;
        if ((player.equals(game.getP1())&&currentPlayer==0)||(player.equals(game.getP2())&&currentPlayer==1)){
            if(game.getField()[a][b]==' '){
                if(currentPlayer==0){
                    game.getField()[a][b]='X';
                    if(checkWinner(game,'X')){
                        endGame(game,'X');
                    }
                }
                else{
                    game.getField()[a][b]='O';
                    if(checkWinner(game,'O')){
                        endGame(game,'O');
                    }
                }
            }
        }
    }

    private static void endGame(Game game, char x) throws IOException, EncodeException {
        Message outcomingMessageData=new Message();
        outcomingMessageData.setUsername("System");
        outcomingMessageData.setMessage("win "+x);
        game.getP1Session().getBasicRemote().sendObject(outcomingMessageData);
        game.getP2Session().getBasicRemote().sendObject(outcomingMessageData);
    }
    private static boolean checkWinner(Game game, char x) {
        boolean ans=false;
        char[][] field=game.getField();
        if(field[0][0]==x&&field[1][1]==x&&field[2][2]==x)ans=true;
        if(field[2][0]==x&&field[1][1]==x&&field[0][2]==x)ans=true;
        if(field[0][0]==x&&field[1][0]==x&&field[2][0]==x)ans=true;
        if(field[0][0]==x&&field[0][1]==x&&field[0][2]==x)ans=true;
        if(field[1][0]==x&&field[1][1]==x&&field[1][2]==x)ans=true;
        if(field[2][0]==x&&field[2][1]==x&&field[2][2]==x)ans=true;
        if(field[0][1]==x&&field[1][1]==x&&field[2][1]==x)ans=true;
        if(field[0][2]==x&&field[1][2]==x&&field[2][2]==x)ans=true;
        return ans;
    }
}
