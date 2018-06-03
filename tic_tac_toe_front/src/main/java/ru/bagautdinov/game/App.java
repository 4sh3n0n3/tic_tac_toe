package ru.bagautdinov.game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ru.bagautdinov.ClientEndPoint;
import ru.bagautdinov.Message;

import javax.websocket.EncodeException;
import javax.websocket.Session;
import java.io.IOException;

public class App  extends Application {

    public static Stage menuStage;
    public static Stage gameStage;

    private ClientEndPoint  clientEndPoint = new ClientEndPoint();
    @Override
    public void start(Stage primaryStage) throws Exception {
        menuStage = new Stage();
        System.out.println("abc");
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/main.fxml"));
            menuStage.setTitle("Tic Tac Toe Menu");
            menuStage.setScene(new Scene(root));
            menuStage.initModality(Modality.WINDOW_MODAL);
        } catch (Exception e) {
            e.printStackTrace();
        }

        gameStage = new Stage();
        try {
            Parent gameRoot = FXMLLoader.load(getClass().getResource("/tictactoe.fxml"));
            gameStage.setTitle("Tic Tac Toe Game");
            gameStage.setScene(new Scene(gameRoot));
            menuStage.initModality(Modality.WINDOW_MODAL);
        } catch (Exception e) {
            e.printStackTrace();
        }menuStage.show();

    }
    public static void changeStage(String name)  {
        gameStage.show();
        Message outcomingMessageData=new Message();
        outcomingMessageData.setUsername(name);
        outcomingMessageData.setMessage("init");

        ClientEndPoint
                .sendMessage(outcomingMessageData);

    }

}
