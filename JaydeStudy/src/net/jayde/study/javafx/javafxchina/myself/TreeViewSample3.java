package net.jayde.study.javafx.javafxchina.myself;

/**
 * Created by jayde on 2016-12-20 16:29.
 * 版权所有
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTreeCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TreeViewSample3 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tree View Sample");

        CheckBoxTreeItem<String> rootItem =
                new CheckBoxTreeItem<>("View Source Files");
        rootItem.setExpanded(true);

        final TreeView tree = new TreeView(rootItem);
        tree.setEditable(true);

        tree.setCellFactory(CheckBoxTreeCell.<String>forTreeView());
        for (int i = 0; i < 8; i++) {
            final CheckBoxTreeItem<String> checkBoxTreeItem =
                    new CheckBoxTreeItem<>("Sample" + (i+1));
            rootItem.getChildren().add(checkBoxTreeItem);
        }

        tree.setRoot(rootItem);
        tree.setShowRoot(true);

        StackPane root = new StackPane();
        root.getChildren().add(tree);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}