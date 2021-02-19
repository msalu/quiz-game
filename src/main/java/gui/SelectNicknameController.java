package gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Player;
import persistance.PlayerRepository;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SelectNicknameController implements Initializable {

    private Scene scene;
    private PlayerRepository playerRepository;
    private Player player;
    private Stage stage = new Stage();

    @FXML
    private TextField inputTxt;

    public void onClick(){
        String nickname = inputTxt.getText();
        player = new Player(nickname);
        playerRepository = new PlayerRepository();
        playerRepository.save(player);

        try {
            scene = new Scene(FXMLLoader.load(getClass().getClassLoader().getResource("gui/questionScene.fxml")));
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
