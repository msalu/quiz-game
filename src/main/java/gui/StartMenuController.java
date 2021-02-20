package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class StartMenuController implements Initializable {
    private Scene scene;
    private Stage stage;

    @FXML
    public void nextPageButton(ActionEvent event){
        try {
            Node source = (Node) event.getSource();
            stage = (Stage) source.getScene().getWindow();
            stage.close();
            scene = new Scene(FXMLLoader.load(getClass().getClassLoader().getResource("gui/selectNickname.fxml")));
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
