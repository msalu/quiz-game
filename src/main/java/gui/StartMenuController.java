package gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class StartMenuController {
    private Scene scene;
    private Stage stage = new Stage();

    @FXML
    public void nextPageButton(){
        try {
            stage.close();
            scene = new Scene(FXMLLoader.load(getClass().getClassLoader().getResource("gui/selectNickname.fxml")));
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
