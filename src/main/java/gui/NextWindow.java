package gui;

import exception.NoMoreQuestionsException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NextWindow {

    private Stage stage;
    private Scene scene;

    public void closeWindowAndOpenNext(ActionEvent event, String s) {
        try {
            Node source = (Node) event.getSource();
            stage = (Stage) source.getScene().getWindow();
            stage.close();
            scene = new Scene(FXMLLoader.load(getClass().getClassLoader().getResource(s)));
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            new NoMoreQuestionsException("No more Questions");
        }
    }
}
