package ru.bagautdinov.game;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;

import javax.websocket.EncodeException;
import java.io.IOException;


public class MainController {

    @FXML
    public TextField username;
    @FXML
    public Button button;

    public void initialize() {
        System.out.println("abc");
        button.setOnMouseClicked(event -> {
            System.out.println("abc");
            App.changeStage(username.getText());

        });
    }
}
