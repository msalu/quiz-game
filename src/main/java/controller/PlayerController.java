package controller;

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
}
