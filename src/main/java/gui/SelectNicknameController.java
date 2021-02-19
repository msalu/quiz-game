package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Player;
import persistance.PlayerRepository;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SelectNicknameController implements Initializable {

    private Scene scene;
    private PlayerRepository playerRepository;
    private Player player;
    private Stage stage = new Stage();

    @FXML
    private TextField nickname;


    @FXML
    public void onClick(ActionEvent event){
        try {
            Node source = (Node) event.getSource();
            stage = (Stage) source.getScene().getWindow();
            stage.close();
            scene = new Scene(FXMLLoader.load(getClass().getClassLoader().getResource("gui/startMenu.fxml")));
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void saveOnClick(){
        String name = nickname.getText();
        player = new Player(name);
        playerRepository = new PlayerRepository();
        playerRepository.save(player);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
