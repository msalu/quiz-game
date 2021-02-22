package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Score;


import java.net.URL;
import java.util.ResourceBundle;

public class EndGameController implements Initializable {

    private Stage stage;
    private Score score;

    public EndGameController(){
        score = Score.getScoreInstance();
    }

    @FXML
    private Label fieldText;

    @FXML
    public void closeGame(ActionEvent event){
        Node source = (Node) event.getSource();
        stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fieldText.setText(Integer.toString(score.returnNum()));
    }
}
