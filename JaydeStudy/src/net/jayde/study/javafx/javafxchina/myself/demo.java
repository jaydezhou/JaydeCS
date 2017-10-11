package net.jayde.study.javafx.javafxchina.myself;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;

import java.util.Arrays;

/**
 * Created by jayde on 2016-12-17 23:53.
 * 版权所有
 */
public class demo extends Application {


    public static void main(String[] args) {
        launch(args);

    }


    public Parent createContent() {
        final TreeItem<String> treeRoot = new TreeItem<String>("Root_node");
        treeRoot.getChildren().addAll(Arrays.asList(
                new TreeItem<String>("Child Node 1"),
                new TreeItem<String>("Child Node 2"),
                new TreeItem<String>("Child Node 3")));

        treeRoot.getChildren().get(2).getChildren().addAll(Arrays.asList(
                new TreeItem<String>("Child Node 4"),
                new TreeItem<String>("Child Node 5"),
                new TreeItem<String>("Child Node 6"),
                new TreeItem<String>("Child Node 7"),
                new TreeItem<String>("Child Node 8")));

        final TreeView treeView = new TreeView();
        treeView.setShowRoot(true);
        treeView.setRoot(treeRoot);
        treeRoot.setExpanded(true);

        return treeView;

    }
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("FXMLExample");
        Parent root = FXMLLoader.load(getClass().getResource("LibraryTree.fxml"));
//                ResourceBundle.getBundle("fxmlexample.fxml_example"));
//        root


        Scene scene = new Scene(root,1024 , 768);
        stage.setScene(scene);
        stage.show();
    }
}
