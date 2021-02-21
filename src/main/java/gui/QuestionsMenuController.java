package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import model.Count;
import model.Player;
import persistance.PlayerRepository;
import persistance.QuestionRepository;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class QuestionsMenuController implements Initializable {

    private Stage stage;
    private Scene scene;

    @FXML
    private Label playerText;

    @FXML
    private Label scoreNumber;

    @FXML
    private Label questionText;

    @FXML
    private RadioButton option1, option2, option3, option4;

    private Count count = new Count();

    @FXML
    public void  onClickCheckAnswer(ActionEvent event){
        try{
            Node source = (Node) event.getSource();
            stage = (Stage) source.getScene().getWindow();
            stage.close();
            scene = new Scene(FXMLLoader.load(getClass().getClassLoader().getResource("gui/questionMenu.fxml")));
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        QuestionRepository qr = new QuestionRepository();
        int init = count.getCounter() + 1;
        count.setCounter(init);
//        int max = 2;
//        int min = 1;
//        int randomNumber =(int) (Math.random() * (max - min + 1) + min);
//        questionText.setText(qr.findQuestionById(randomNumber).getQuestion());
        questionText.setText(qr.findQuestionById(count.getCounter()).getQuestion());

    }


}
