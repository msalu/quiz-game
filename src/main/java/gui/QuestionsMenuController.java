package gui;

import controller.PlayerController;
import controller.QuestionController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Answer;
import model.Score;
import persistance.AnswerRepository;


import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class QuestionsMenuController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Alert alert = new Alert(Alert.AlertType.NONE);

    private static int questionCounter = 1;
    private static final int POINTS_PER_CORRECT_ANSWER = 1;
    private static final int AMOUNT_OF_QUESTIONS_IN_QUIZ = 5;
    private Score score;

    private QuestionController questionController;
    private PlayerController playerController;

    private AnswerRepository answerRepository;

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

    public QuestionsMenuController(){
        answerRepository = new AnswerRepository();
        score = Score.getScoreInstance();
        questionController = new QuestionController();
        playerController = new PlayerController();
    }

    @FXML
    public void  onClickCheckAnswer(ActionEvent event){
        alert.setAlertType(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Are you sure?");

        Optional<ButtonType> confirmationAlert = alert.showAndWait();
        RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();
        Answer correctAnswer = answerRepository.getByQuestionIdCorrectAnswer(questionCounter);

        if (questionCounter == AMOUNT_OF_QUESTIONS_IN_QUIZ) closeWindowAndOpenNext(event, "gui/endGame.fxml");

        if (confirmationAlert.get() == ButtonType.OK){
            checkIfCorrectThenAssignPointsElseNoPointsAndNextQuestion(event, selectedRadioButton, correctAnswer);
            closeWindowAndOpenNext(event, "gui/questionMenu.fxml");
        }else if(confirmationAlert.get() == ButtonType.CANCEL){
            return;
        }

    }

    private void checkIfCorrectThenAssignPointsElseNoPointsAndNextQuestion(ActionEvent event, RadioButton selectedRadioButton, Answer correctAnswer) {
        if (questionController.checkIfCorrectAnswer(selectedRadioButton, correctAnswer)) {
            score.increaseScore(POINTS_PER_CORRECT_ANSWER);
            playerController.saveLastSavedPlayersScore(score.returnNum());
            questionCounter++;
        }else if(!questionController.checkIfCorrectAnswer(selectedRadioButton, correctAnswer)){
            questionCounter++;
        }
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
           new NoMoreQuestionsException("No more Questions");
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setCurrentQuestionToDisplay(questionCounter);
        setRadioButtonsAnswersText(questionCounter);
        setScoreToDisplay();
        setPlayerNameToDisplay();
    }

    private void setCurrentQuestionToDisplay(int questionId) {
        questionText.setText(questionController.findQuestionByIdAndGetQuestionValue(questionId));
    }

    private void setRadioButtonsAnswersText(int questionId) {
        List<Answer> answers = answerRepository.answersWhereQuestionIdIsSame(questionId);
        option1.setText(answers.get(0).getAnswer());
        option2.setText(answers.get(1).getAnswer());
        option3.setText(answers.get(2).getAnswer());
        option4.setText(answers.get(3).getAnswer());
    }

    private void setPlayerNameToDisplay() {
        playerText.setText(playerController.getLastSavedPlayerNameAndReturnItsValue());
    }

    private void setScoreToDisplay() {
        scoreNumber.setText(Integer.toString(playerController.getLastSavedPlayersScore()));
    }
}
