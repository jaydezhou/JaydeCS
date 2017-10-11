/*
 * LayoutSansTears.java - JavaFX layout example
 * Author - Jim Weaver jim.weaver@javafxpert.com
 */
package net.jayde.study.javafx.javafxchina.myself.layoutSansTears;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LayoutSansTears extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Region headerLeftSpring = new Region();

        // TO DO: Declare a variable of type Region, assigning a
        // new Region object to it for use as a "spring" in the
        // header between the title of the app and the search box

        // TO DO: Declare a variable of type Region, assigning a
        // new Region object to it for use as a "spring" in the
        // footer between the left and right labels

        ImageView logo = new ImageView(
                new Image(getClass().getResourceAsStream("images/javafx-logo.png"))
        );

        HBox searchBox = new HBox();
        searchBox.setSpacing(5);
        TextArea textArea = new TextArea();
        textArea.setPrefWidth(120);
        textArea.setPrefHeight(40);
        searchBox.getChildren().add(textArea);
        Button button = new Button("Go");
        searchBox.getChildren().add(button);

        Scene scene = new Scene(new Group());

        BorderPane borderPane = new BorderPane();
        HBox hBox = new HBox();
        hBox.getChildren().addAll(logo, headerLeftSpring, new Label("App Title"));
        borderPane.setTop(hBox);
        TabPane tabPane = new TabPane();
        tabPane.getTabs().addAll(new Tab("Tab A"), new Tab("Tab B"), new Tab("Tab C"));
        borderPane.setCenter(tabPane);
        HBox hBox1 = new HBox();
        hBox1.getChildren().addAll(new Label("Footer Left"), new Label("Footer Right"));
        borderPane.setBottom(hBox1);

        ((Group) scene.getRoot()).getChildren().add(borderPane);

        HBox.setHgrow(headerLeftSpring, Priority.ALWAYS);

        // TO DO: Use a static method of HBox to allow the headerRightSpring
        // to compete for any extra horizontal space

        // TO DO: Use a static method of HBox to allow the footerCenterSpring
        // to compete for  any extra horizontal space

        // TO DO: Use a static method of HBox to give the searchBox
        // a margin of 20 pixels on the top and 10 pixels on the right
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.setTitle("Layout Sans Tears: Exercise");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
