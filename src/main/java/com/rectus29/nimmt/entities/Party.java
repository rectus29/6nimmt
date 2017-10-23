package com.rectus29.nimmt.entities;

import com.rectus29.nimmt.configuration.NimmtConfiguration;
import com.rectus29.nimmt.enums.GameAction;
import com.rectus29.nimmt.report.GameReport;
import com.rectus29.nimmt.report.SceneReport;
import com.rectus29.nimmt.services.CardDealerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Party extends GenericEntities {

    final Logger log = LogManager.getLogger(Party.class);

    private List<Player> playerList = new ArrayList<>();
    private List<Card> pickList = new ArrayList<>();
    private List<BattleRound> battleRounds = new ArrayList<>();
    private Scene scene = new Scene();
    private NimmtConfiguration configuration;

    public Party(NimmtConfiguration configuration) {
        this.configuration = configuration;
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
        //TODO fill here
    }

    public Player addUser(String userName) {
        Player player = new Player(userName);
        playerList.add(player);
        return player;
    }

    public void startGame() {
        log.debug("party start");
		new CardDealerService().initParty(this);
		scene.initScene(getCardOnDrill(), getCardOnDrill(), getCardOnDrill(), getCardOnDrill());
    }

    //TODO i think we can create Drill object


    List<Card> getCardList(int cardNubmer) {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < cardNubmer; i++) {
            cards.add(getCardOnDrill());
        }
        return cards;
    }

    private Card getCardOnDrill() {
        long random = Math.round(Math.random() * 100);
        int pickListIndex = new Long(random % pickList.size()).intValue();
        Card result = pickList.get(pickListIndex);
        pickList.remove(result);
        return result;
    }


    public BattleRound startNewBattleRound() {
        BattleRound newBattleRound = new BattleRound();
        battleRounds.add(newBattleRound);
        return newBattleRound;
    }

    public boolean hasBattleRound() {
        return battleRounds.size() < 10;
    }

    public void finish() {
        log.debug("party finish");
    }

    public BattleRound getCurrentBattleround() {
        //TODO check all previous battleround are closed
        return battleRounds.get(battleRounds.size() -1 );
    }


    public BattleRoundReport resolveBattleRound() throws Exception {
        return getCurrentBattleround().resolve(scene);
    }

    public BattleRoundReport addPipePayload(Player p, int userPipeToFlushedNumber) throws Exception {
        getCurrentBattleround().addPipePayload(p, userPipeToFlushedNumber);
        return resolveBattleRound();
    }

    public void addPayload(Player player, Card card) {
        BattleRound currentBattleround = getCurrentBattleround();
        player.getCardList().remove(card);
        currentBattleround.addPayload(player, card);
        if (currentBattleround.getPayLoadList().size() == getPlayerList().size()) {
            currentBattleround.setReadyToSolve(true);
        }
    }
}
