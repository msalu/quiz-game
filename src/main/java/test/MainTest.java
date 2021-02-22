package test;

import controller.PlayerController;
import model.Answer;
import model.Question;
import persistance.AnswerRepository;

public class MainTest {

    public static void main(String[] args) {
        PlayerController playerController = new PlayerController();

        System.out.println(playerController.getLastSavedPlayerNameAndReturnItsValue());
    }
}
