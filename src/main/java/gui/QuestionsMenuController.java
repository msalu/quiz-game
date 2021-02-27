package gui;

import controller.PlayerController;
import controller.QuestionController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import model.Answer;
import model.DifficultyLevel;

import persistance.AnswerRepository;


import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class QuestionsMenuController implements Initializable {

    private Alert alert = new Alert(Alert.AlertType.NONE);


    private static int questionCounter = 1;
    private static final int POINTS_PER_CORRECT_ANSWER = 1;
    protected static final int AMOUNT_OF_QUESTIONS_IN_QUIZ = 5;
    private DifficultyLevel difficultyLevel = DifficultyLvlController.difficultyLevel;

    protected static int score;


    private QuestionController questionController;
    private PlayerController playerController;
    private NextWindow nextWindow;

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
        questionController = new QuestionController();
        playerController = new PlayerController();
        nextWindow = new NextWindow();
    }

    @FXML
    public void  onClickCheckAnswer(ActionEvent event){
        alert.setAlertType(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Are you sure?");

        Optional<ButtonType> confirmationAlert = alert.showAndWait();
        RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();
        Answer correctAnswer = answerRepository.getByQuestionIdCorrectAnswer(questionCounter);

        if (questionCounter == AMOUNT_OF_QUESTIONS_IN_QUIZ){
            nextWindow.closeWindowAndOpenNext(event, "gui/checkResults.fxml");
        }

        if (confirmationAlert.get() == ButtonType.OK){
            checkIfCorrectThenAssignPoints(event, selectedRadioButton, correctAnswer);
            nextWindow.closeWindowAndOpenNext(event, "gui/questionMenu.fxml");
        }else if(confirmationAlert.get() == ButtonType.CANCEL){
            return;
        }
    }

    private void checkIfCorrectThenAssignPoints(ActionEvent event, RadioButton selectedRadioButton, Answer correctAnswer) {
        if (questionController.checkIfCorrectAnswer(selectedRadioButton, correctAnswer)) {
            score = score + POINTS_PER_CORRECT_ANSWER;
            questionCounter++;
        }else if(!questionController.checkIfCorrectAnswer(selectedRadioButton, correctAnswer)){
            pointsAssigmentBasedOnDifficultyLevel();
            questionCounter++;
        }
    }

    private void pointsAssigmentBasedOnDifficultyLevel() {
        switch (difficultyLevel){
            case MEDIUM:
                score--;
                break;
            case HARD:
                score = 0;
                break;
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
        scoreNumber.setText(Integer.toString(score));
    }
}
