package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;

import java.util.ResourceBundle;

public class CheckResultsController implements Initializable {

    private NextWindow nextWindow;

    public CheckResultsController(){
        nextWindow = new NextWindow();
    }

    @FXML
    public void getResult(ActionEvent event){
        nextWindow.closeWindowAndOpenNext(event, "gui/endGame.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
