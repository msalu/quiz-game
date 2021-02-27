package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import model.DifficultyLevel;

import java.net.URL;
import java.util.ResourceBundle;

public class DifficultyLvlController implements Initializable {

    protected static DifficultyLevel difficultyLevel;

    private NextWindow nextWindow;

    public DifficultyLvlController(){
        nextWindow = new NextWindow();
    }

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
        nextWindow.closeWindowAndOpenNext(event, "gui/questionMenu.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
