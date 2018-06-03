package ru.bagautdinov.service;

import org.springframework.stereotype.Service;
import ru.bagautdinov.models.Game;
import ru.bagautdinov.models.Player;

/**
 * Created by User on 03.06.2018.
 */

@Service
public class PerformTurnService {
    public void makeTurn(Player player, Game game, int a, int b){
        int currentPlayer=game.getCounter()%2;
        if ((player.equals(game.getP1())&&currentPlayer==0)||(player.equals(game.getP2())&&currentPlayer==1)){
            if(game.getField[a][b]==' '){
                if(currentPlayer==0){
                    game.getField[a][b]='X';
                    if(checkWinner(game,'X')){

                    }
                }
                else{
                    game.getField[a][b]='O';
                    checkWinner(game,'X');
                }
            }
        }
    }

    private static boolean checkWinner(Game game, char x) {
    }
}
