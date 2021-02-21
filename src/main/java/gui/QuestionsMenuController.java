package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import model.Answer;
import model.Player;
import persistance.AnswerRepository;
import persistance.PlayerRepository;
import persistance.QuestionRepository;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class QuestionsMenuController implements Initializable {

    private Stage stage;
    private Scene scene;
    private static int count = 1;
    private static int score = 0;

    @FXML
    private Label playerText;

    @FXML
    private Label scoreNumber;

    @FXML
    private Label questionText;

    @FXML
    private RadioButton option1, option2, option3, option4;

    @FXML
    private ToggleGroup toggleGroup;

    private QuestionRepository qr;

    private AnswerRepository answerRepository;

    public QuestionsMenuController(){
        qr = new QuestionRepository();
        answerRepository = new AnswerRepository();
    }

    @FXML
    public void  onClickCheckAnswer(ActionEvent event){
        RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();
        Answer correctAnswer = answerRepository.getByQuestionIdCorrectAnswer(count);
        if (selectedRadioButton.getText().equals(correctAnswer.getAnswer())) {
        score += 10;
            count++;
            try {
                Node source = (Node) event.getSource();
                stage = (Stage) source.getScene().getWindow();
                stage.close();
                scene = new Scene(FXMLLoader.load(getClass().getClassLoader().getResource("gui/questionMenu.fxml")));
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        currentQuestion(count);
        radioButtonsAnswersText(count);
        scoreNumber.setText(Integer.toString(score));
        PlayerRepository playerRepository = new PlayerRepository();
        Player player = playerRepository.getLastEntry();
        playerText.setText(player.getName());
    }

    private void radioButtonsAnswersText(int questionId) {
        List<Answer> answers = answerRepository.answersWhereQuestionIdIsSame(questionId);
        option1.setText(answers.get(0).getAnswer());
        option2.setText(answers.get(1).getAnswer());
        option3.setText(answers.get(2).getAnswer());
        option4.setText(answers.get(3).getAnswer());
    }

    private void currentQuestion(int questionId) {
        questionText.setText(qr.findQuestionById(questionId).getQuestion());
    }


}
