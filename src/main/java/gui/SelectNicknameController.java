package gui;

import controller.PlayerController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

import java.net.URL;

import java.util.ResourceBundle;

public class SelectNicknameController implements Initializable {

    private PlayerController playerController;
    private NextWindow nextWindow;

    private Alert alert = new Alert(AlertType.NONE);

    @FXML
    private TextField nickname;

    public SelectNicknameController() {
        playerController = new PlayerController();
        nextWindow = new NextWindow();
    }

    @FXML
    public void onClick(ActionEvent event){
        String name = nickname.getText();
        playerController.savePlayer(name);

        if (nickname.getText().isEmpty() || nickname.getText() == null){
            alert.setAlertType(AlertType.ERROR);
            alert.setContentText("Nickname field should not be empty!");
            alert.show();
        }

        if(!alert.isShowing()) {
            nextWindow.closeWindowAndOpenNext(event, "gui/difficultyLvlSelect.fxml");
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
