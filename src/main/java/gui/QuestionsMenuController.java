package gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

import java.net.URL;
import java.util.ResourceBundle;

public class QuestionsMenuController implements Initializable {

    @FXML
    private Label playerText;

    @FXML
    private Label scoreNumber;

    @FXML
    private Label questionText;

    @FXML
    private RadioButton option1, option2, option3, option4;

    @FXML
    public void  onClickCheckAnswer(){

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }


}
