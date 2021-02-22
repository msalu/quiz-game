package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Answer;
import model.Player;
import model.Score;
import persistance.AnswerRepository;
import persistance.PlayerRepository;
import persistance.QuestionRepository;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class QuestionsMenuController implements Initializable {

    private Stage stage;
    private Scene scene;
    private static int count = 1;
    private Score score;

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

    private Alert alert = new Alert(Alert.AlertType.NONE);

    private AnswerRepository answerRepository;

    public QuestionsMenuController(){
        qr = new QuestionRepository();
        answerRepository = new AnswerRepository();
        score = Score.getScoreInstance();
    }

    @FXML
    public void  onClickCheckAnswer(ActionEvent event){
        alert.setAlertType(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Are you sure?");
        Optional<ButtonType> result = alert.showAndWait();
        RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();
        Answer correctAnswer = answerRepository.getByQuestionIdCorrectAnswer(count);

        if (count == 5) {
            closeWindowAndOpenNext(event, "gui/endGame.fxml");
        }
        if (result.get() == ButtonType.OK){

            if (checkIfCorrectAnswer(selectedRadioButton, correctAnswer)) {
                Score.increaseScore(20);
                count++;
                closeWindowAndOpenNext(event, "gui/questionMenu.fxml");
            }else if(!checkIfCorrectAnswer(selectedRadioButton, correctAnswer)){
                count++;
                closeWindowAndOpenNext(event, "gui/questionMenu.fxml");
            }
        }else if(result.get() == ButtonType.CANCEL){
            return;
        }

    }

    private boolean checkIfCorrectAnswer(RadioButton selectedRadio, Answer correctAnswer){
        return selectedRadio.getText().equals(correctAnswer.getAnswer());
    }

    private void closeWindowAndOpenNext(ActionEvent event, String s) {
        try {
            Node source = (Node) event.getSource();
            stage = (Stage) source.getScene().getWindow();
            stage.close();
            scene = new Scene(FXMLLoader.load(getClass().getClassLoader().getResource(s)));
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        currentQuestion(count);
        radioButtonsAnswersText(count);
        scoreNumber.setText(Integer.toString(Score.getScoreInstance().returnNum()));
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
