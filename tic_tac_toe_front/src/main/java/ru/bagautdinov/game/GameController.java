package ru.bagautdinov.game;

import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import ru.bagautdinov.Message;

import java.awt.event.MouseEvent;

public class GameController {

    private String playerChar;

    public String getPlayerChar() {
        return playerChar;
    }

    public void setPlayerChar(String playerChar) {
        this.playerChar = playerChar;
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

        Message outcomingMessageData=new Message();
        outcomingMessageData.setUsername(username);
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
        outcomingMessageData.setMessage("turn "+ location);
    }
}
