package controller;

import model.DifficultyLevel;
import model.Player;
import persistance.PlayerRepository;

public class PlayerController {

    private PlayerRepository playerRepository;

    public PlayerController() {
        playerRepository = new PlayerRepository();
    }

    public void savePlayer(String name){
        Player player = new Player(name);
        playerRepository.save(player);
    }

    public String getLastSavedPlayerNameAndReturnItsValue(){
        return playerRepository.getLastEntry().getName();
    }

    public void saveLastSavedPlayersScore(int newScoreValue){
        Player player = playerRepository.getLastEntry();
        player.setScore(newScoreValue);
        playerRepository.update(player);
    }

    public int getLastSavedPlayersScore(){
        Player player = playerRepository.getLastEntry();
        return player.getScore();
    }
}
