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
import model.Answer;
import persistance.AnswerRepository;
import persistance.QuestionRepository;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class QuestionsMenuController implements Initializable {

    private Stage stage;
    private Scene scene;
    private static int count = 1;

    @FXML
    private Label playerText;

    @FXML
    private Label scoreNumber;

    @FXML
    private Label questionText;

    @FXML
    private RadioButton option1, option2, option3, option4;

    @FXML
    public void  onClickCheckAnswer(ActionEvent event){
        count++;
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
        currentQuestion(count);

        AnswerRepository answerRepository = new AnswerRepository();
        RadioButton[] radioButtons = new RadioButton[]{option1, option2, option3, option4};
        List<Answer> answers = answerRepository.answersWhereQuestionIdIsSame(count);
        for (int i = 0; i <=radioButtons.length; i++){
            for(Answer answer : answers){
                radioButtons[i].setText(answer.getAnswer());
            }
        }
    }

    private void currentQuestion(int questionId) {
        QuestionRepository qr = new QuestionRepository();
        questionText.setText(qr.findQuestionById(questionId).getQuestion());
    }


}
