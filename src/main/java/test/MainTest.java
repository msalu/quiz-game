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

       /* Question question = new Question("What is Java?");
        QuestionRepository questionRepository = new QuestionRepository();
        questionRepository.save(question);

        Answer answer1 = new Answer("a", true, question);
        Answer answer2 = new Answer("b", false, question);*/

        /*Question question2 = new Question("What is SQL?");
        QuestionRepository questionRepository = new QuestionRepository();
        questionRepository.save(question2);
        Answer answer1 = new Answer("f", true, question2);
        Answer answer2 = new Answer("g", false, question2);
        Answer answer3 = new Answer("h", false, question2);*/


        AnswerRepository answerRepository = new AnswerRepository();

     /*   answerRepository.save(answer1);
        answerRepository.save(answer2);
        answerRepository.save(answer3);*/

        // ar = answerRepository
        answerRepository.answersWhereQuestionIdIsSame(2).forEach(ar -> System.out.println(ar.toString()));
    }
}
