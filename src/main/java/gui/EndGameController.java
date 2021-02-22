package gui;

import controller.PlayerController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Player;
import model.Score;
import persistance.PlayerRepository;


import java.net.URL;
import java.util.ResourceBundle;

public class EndGameController implements Initializable {

    private Stage stage;
    private PlayerController playerController;
    private PlayerRepository playerRepository;

    public EndGameController(){
        playerController = new PlayerController();
        playerRepository = new PlayerRepository();
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
        Player player = playerRepository.getLastEntry();
        fieldText.setText(Integer.toString(player.getScore()));
    }
}
