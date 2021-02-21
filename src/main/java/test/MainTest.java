package test;

import model.Answer;
import model.Question;
import persistance.AnswerRepository;

public class MainTest {

    public static void main(String[] args) {
        AnswerRepository answerRepository = new AnswerRepository();
        Question question = new Question();
        question.setQuestionId(5);

        Answer answer1 = new Answer("1", true, question);
        Answer answer2 = new Answer("2", false, question);
        Answer answer3 = new Answer("3", false, question);
        Answer answer4 = new Answer("4", false, question);
        answerRepository.save(answer1);
        answerRepository.save(answer2);
        answerRepository.save(answer3);
        answerRepository.save(answer4);
    }
}
