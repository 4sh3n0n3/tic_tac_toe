package ru.bagautdinov.game;

import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import ru.bagautdinov.ClientEndPoint;
import ru.bagautdinov.Message;

import javax.websocket.EncodeException;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class GameController {

    private static String playerChar;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPlayerChar() {
        return playerChar;
    }

    public static void setPlayerChar(String playerChar1) {
        playerChar = playerChar;
    }

    @FXML
    public StackPane cell_0_0;
    @FXML
    public StackPane cell_0_1;
    @FXML
    public StackPane cell_0_2;
    @FXML
    public StackPane cell_1_0;
    @FXML
    public StackPane cell_1_1;
    @FXML
    public StackPane cell_1_2;
    @FXML
    public StackPane cell_2_0;
    @FXML
    public StackPane cell_2_1;
    @FXML
    public StackPane cell_2_2;

    public void initialize() {
        System.out.println("abc");
        cell_0_0.setOnMouseClicked(event -> {
            Message outcomingMessageData=new Message();
            outcomingMessageData.setUsername(username);
            if (text_0_0.getText().equals("")) {
                text_0_0.setText(playerChar);
            }

            outcomingMessageData.setMessage("turn 0 0");

            ClientEndPoint.sendMessage(outcomingMessageData);
        });
        cell_0_1.setOnMouseClicked(event -> {
            Message outcomingMessageData=new Message();
            outcomingMessageData.setUsername(username);
            if (text_0_1.getText().equals("")) {
                text_0_1.setText(playerChar);
            }

            outcomingMessageData.setMessage("turn 0 1");


            ClientEndPoint.sendMessage(outcomingMessageData);
        });
        cell_0_2.setOnMouseClicked(event -> {Message outcomingMessageData=new Message();
            outcomingMessageData.setUsername(username);
            if (text_0_2.getText().equals("")) {
                text_0_2.setText(playerChar);
            }


            outcomingMessageData.setMessage("turn 0 2");


                ClientEndPoint.sendMessage(outcomingMessageData);
        });
        cell_1_0.setOnMouseClicked(event -> {Message outcomingMessageData=new Message();
            outcomingMessageData.setUsername(username);
            if (text_1_0.getText().equals("")) {
                text_1_0.setText(playerChar);
            }

            outcomingMessageData.setMessage("turn 1 0");


            ClientEndPoint.sendMessage(outcomingMessageData);
        });
        cell_1_1.setOnMouseClicked(event -> {Message outcomingMessageData=new Message();
            outcomingMessageData.setUsername(username);
            if (text_1_1.getText().equals("")) {
                text_1_1.setText(playerChar);
            }


            outcomingMessageData.setMessage("turn 1 1");

            ClientEndPoint.sendMessage(outcomingMessageData);
        });
        cell_1_2.setOnMouseClicked(event -> {Message outcomingMessageData=new Message();
            outcomingMessageData.setUsername(username);
            if (text_1_2.getText().equals("")) {
                text_1_2.setText(playerChar);
            }
            outcomingMessageData.setMessage("turn 1 2");

            ClientEndPoint.sendMessage(outcomingMessageData);
        });
        cell_2_0.setOnMouseClicked(event -> {Message outcomingMessageData=new Message();
            outcomingMessageData.setUsername(username);
            if (text_2_0.getText().equals("")) {
                text_2_0.setText(playerChar);
            }

            outcomingMessageData.setMessage("turn 2 0");

            ClientEndPoint.sendMessage(outcomingMessageData);

        });
        cell_2_1.setOnMouseClicked(event -> {Message outcomingMessageData=new Message();
            outcomingMessageData.setUsername(username);
            if (text_2_1.getText().equals("")) {
                text_2_1.setText(playerChar);
            }
            outcomingMessageData.setMessage("turn 2 1");

            ClientEndPoint.sendMessage(outcomingMessageData);
        });
        cell_2_2.setOnMouseClicked(event -> {Message outcomingMessageData=new Message();
            outcomingMessageData.setUsername(username);
            if (text_2_2.getText().equals("")) {
                text_2_2.setText(playerChar);
            }
            outcomingMessageData.setMessage("turn 2 2");

            ClientEndPoint.sendMessage(outcomingMessageData);

        });
    }
    @FXML
    public Text text_0_0;
    @FXML
    public Text text_0_1;
    @FXML
    public Text text_0_2;
    @FXML
    public Text text_1_0;
    @FXML
    public Text text_1_1;
    @FXML
    public Text text_1_2;
    @FXML
    public Text text_2_0;
    @FXML
    public Text text_2_1;
    @FXML
    public Text text_2_2;

    public void paneCliced(javafx.scene.input.MouseEvent event) {


        String location="";
        if (event.getSource() == cell_0_0) {
            location="0 0";
            if (text_0_0.getText().equals("")) {
                text_0_0.setText(playerChar);
            }
        }
        if (event.getSource() == cell_0_1) {
            location="0 1";
            if (text_0_1.getText().equals("")) {
                text_0_1.setText(playerChar);
            }
        }
        if (event.getSource() == cell_0_2) {
            location="0 2";
            if (text_0_2.getText().equals("")) {
                text_0_2.setText(playerChar);
            }
        }
        if (event.getSource() == cell_1_0) {
            location="1 0";
            if (text_1_0.getText().equals("")) {
                text_1_0.setText(playerChar);
            }
        }
        if (event.getSource() == cell_1_1) {
            location="1 1";
            if (text_1_1.getText().equals("")) {
                text_1_1.setText(playerChar);
            }
        }
        if (event.getSource() == cell_1_2) {
            location="1 2";
            if (text_1_2.getText().equals("")) {
                text_1_2.setText(playerChar);
            }
        }
        if (event.getSource() == cell_2_0) {
            location="2 0";
            if (text_2_0.getText().equals("")) {
                text_2_0.setText(playerChar);
            }
        }
        if (event.getSource() == cell_2_1) {
            location="2 1";
            if (text_2_1.getText().equals("")) {
                text_2_1.setText(playerChar);
            }
        }
        if (event.getSource() == cell_2_2) {
            location="2 2";
            if (text_2_2.getText().equals("")) {
                text_2_2.setText(playerChar);
            }
        }
    }
}
