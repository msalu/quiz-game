package test;

import model.Answer;
import model.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Question question = new Question("What is Java?", "a");

        Answer answer2 = new Answer();
        answer2.setAnswer("b");
        Answer answer3 = new Answer();
        answer3.setAnswer("c");
        Answer answer4 = new Answer();
        answer4.setAnswer("d");

        List<Answer> answers = new ArrayList<>();
        answers.add(answer2);
        answers.add(answer3);
        answers.add(answer4);

        System.out.println(question.getQuestion());
        System.out.println(question.getCorrectAnswer());
        randomAnswerGenerator(answers);
        String response = scanner.next();

        correctAnswerValidator(question, response);
    }

    private static void correctAnswerValidator(Question question, String response) {
        if (question.getCorrectAnswer().equals(response)){
            System.out.println("you got it!");
        }else{
            System.out.println("that is wrong!");
        }
    }

    private static void randomAnswerGenerator(List<Answer> answers) {
        for (Answer answer : answers){
            System.out.println(answer.getAnswer());
        }
    }
}
