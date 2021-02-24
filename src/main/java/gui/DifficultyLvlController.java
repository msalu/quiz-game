package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.DifficultyLevel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DifficultyLvlController implements Initializable {

    protected static DifficultyLevel difficultyLevel;

    private Stage stage;
    private Scene scene;

    @FXML
    public void setEasyLvl(ActionEvent event){
        difficultyLevel = DifficultyLevel.EASY;
        setNewScene(event);
    }

    @FXML
    public void setMediumLvl(ActionEvent event){
        difficultyLevel = DifficultyLevel.MEDIUM;
        setNewScene(event);
    }

    @FXML
    public void setHighLvl(ActionEvent event){
        difficultyLevel = DifficultyLevel.HARD;
        setNewScene(event);
    }

    private void setNewScene(ActionEvent event) {
        try {
            Node source = (Node) event.getSource();
            stage = (Stage) source.getScene().getWindow();
            stage.close();
            scene = new Scene(FXMLLoader.load(getClass().getClassLoader().getResource("gui/questionMenu.fxml")));
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
