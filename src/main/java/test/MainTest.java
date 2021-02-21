package test;

import model.Answer;
import model.Question;
import persistance.AnswerRepository;

public class MainTest {

    public static void main(String[] args) {
        AnswerRepository answerRepository = new AnswerRepository();
        Question question = new Question();
        question.setQuestionId(2);

        Answer answer = new Answer("sfgdfgdfg", false, question);
        answerRepository.save(answer);


    }
}
