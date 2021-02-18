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
        Scanner scanner = new Scanner(System.in);

//        Question question = new Question("What is Java?");
//        QuestionRepository questionRepository = new QuestionRepository();
//        questionRepository.save(question);
//        Answer answer1 = new Answer("a", true, question);
//        Answer answer2 = new Answer("b", false, question);

        AnswerRepository answerRepository = new AnswerRepository();

//        answerRepository.save(answer1);
//        answerRepository.save(answer2);

        answerRepository.answersWhereQuestionIdIsSame(1).forEach(a -> System.out.println(a.toString()));
    }
}
