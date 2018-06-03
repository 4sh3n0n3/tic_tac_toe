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
    void makeTurn(Player player,Game game,int a,int b){
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

    private boolean checkWinner(Game game, char x) {
    }
}
