package player;

import util.io.PlayerControls;

public class Player extends Fighter {

    public PlayerControls controls;
    public FighterConstants.Characters character;

    public int spawnPos;

    public Player(int playerNum, FighterConstants.Characters character) {
        super(playerNum, character);
        this.controls = new PlayerControls(playerNum);
        this.character = character;
    }
}
