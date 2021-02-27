package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;


public class StartMenuController implements Initializable {

    private NextWindow nextWindow;

    public StartMenuController(){
        nextWindow = new NextWindow();
    }

    @FXML
    public void nextPageButton(ActionEvent event){
        nextWindow.closeWindowAndOpenNext(event, "gui/selectNickname.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
