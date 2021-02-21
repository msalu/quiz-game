package gui;

import controller.PlayerController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Player;
import persistance.PlayerRepository;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SelectNicknameController implements Initializable {

    private Scene scene;
    private PlayerController playerController;
    private Stage stage = new Stage();

    private Alert alert = new Alert(AlertType.NONE);

    @FXML
    private TextField nickname;

    public SelectNicknameController() {
        playerController = new PlayerController();
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
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
