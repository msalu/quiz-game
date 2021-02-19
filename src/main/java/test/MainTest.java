package test;

import model.Answer;
import model.Question;
import persistance.AnswerRepository;
import persistance.QuestionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {

        QuestionRepository questionRepository = new QuestionRepository();
        AnswerRepository answerRepository = new AnswerRepository();
        Scanner scanner = new Scanner(System.in);

        Question question = questionRepository.findQuestionById(1);
        System.out.println(question.getQuestion());
        List<Answer> answers = answerRepository.answersWhereQuestionIdIsSame(1);
        answers.forEach(answer -> System.out.println(answer.getAnswer()));
    }
}
