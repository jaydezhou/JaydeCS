package net.jayde.study.javafx.javafxchina.myself;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**
 * Created by jayde on 2016-12-18 17:03.
 * 版权所有
 */
public class demoHandle {

    @FXML
    private Button button1;
    @FXML
    private BorderPane borderPane;

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
        System.out.println(event);
        button1.setText("Sign in button pressed");
        borderPane.setLeft(new Button("xxx"));
    }
}
