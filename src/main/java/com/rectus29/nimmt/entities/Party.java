package com.rectus29.nimmt.entities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Party extends GenericEntities{

    final Logger log = LogManager.getLogger(Party.class);
	
	private List<Player> playerList = new ArrayList<>();
	private List<Card> pickList = new ArrayList<>();
    private List<BattleRound> battleRounds = new ArrayList<>();
	private Scene scene = new Scene();

	public Party() {
	}

	public List<Player> getPlayerList() {
		return playerList;
	}

	public Party setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
		return this;
	}

	public List<Card> getPickList() {
		return pickList;
	}

	public Party setPickList(List<Card> pickList) {
		this.pickList = pickList;
		return this;
	}

	public Scene getScene() {
		return scene;
	}

	public Party setScene(Scene scene) {
		this.scene = scene;
		return this;
	}

    public void begin() {
    }

    public Player addUser(String userName) {
        Player player = new Player(userName);
        playerList.add(player);
        return player;
    }

    public void startGame() {
        log.debug("party start");
    }


    public BattleRound startNewBattleRound() {
        BattleRound newBattleRound = new BattleRound(this);
        battleRounds.add(newBattleRound);
        return newBattleRound;
    }

    public boolean hasBattleRound() {
	    return false;
    }

    public void finish() {
        log.debug("party finish");
    }

    public BattleRound getCurrentBattleround() {
	    //TODO check all previous battleround are closed
        return battleRounds.get(battleRounds.size());
    }
}
