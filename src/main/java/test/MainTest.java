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
        Scanner scanner = new Scanner(System.in);
        Question question = questionRepository.findQuestionById(1);
    }
}
