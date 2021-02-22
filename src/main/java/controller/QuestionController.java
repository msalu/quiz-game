package controller;

import javafx.scene.control.RadioButton;
import model.Answer;
import persistance.QuestionRepository;

public class QuestionController {
    private QuestionRepository questionRepository;

    public QuestionController() {
        questionRepository = new QuestionRepository();
    }

    public boolean checkIfCorrectAnswer(RadioButton selectedRadio, Answer correctAnswer){
        return selectedRadio.getText().equals(correctAnswer.getAnswer());
    }

    public String findQuestionByIdAndGetQuestionValue(int questionId){
        return questionRepository.findQuestionById(questionId).getQuestion();
    }



}
