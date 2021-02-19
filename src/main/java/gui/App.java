package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("gui/startMenu.fxml"));
        primaryStage.setTitle("Java Quiz Game");
        primaryStage.setScene(new Scene(root, 500, 700));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
