package com.rectus29.nimmt;

import com.rectus29.nimmt.configuration.NimmtConfiguration;
import com.rectus29.nimmt.configuration.NimmtConfigurationResourceBundle;
import com.rectus29.nimmt.entities.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
		final Logger log = LogManager.getLogger(Main.class);
		log.debug("init party");
        NimmtConfiguration configuration = NimmtConfigurationResourceBundle.getInstance();
		log.debug(configuration.getMaxPlayer());
        Scanner sc = new Scanner(System.in);
		Party party = new Party(configuration);

		party.begin();
		String userName = getUserName(sc);
		party.addUser(userName).toString();
        log.debug("first user "+userName);
        userName = getUserName(sc);
        log.debug("second user "+userName);
        party.addUser(userName);
        party.startGame();
        diplayScene(party.getScene());
        while(party.hasBattleRound()){
            party.startNewBattleRound();
            //TODO Token de battleround for ui sync
            for (Player player : party.getPlayerList()) {
                while(!party.getCurrentBattleround().hasPlayLoad(player)) {
                    try {
                        party.getCurrentBattleround().addPayload(player, player.getCard(getUserCardValue(player, sc)));
                    } catch (Exception e) {
                        SetErrorValueCard();
                    }
                }
            }

        }
        party.finish();

	// write your code here
    }

    private static void diplayScene(Scene scene) {
        displayPipe(scene.getPipe0());
        System.out.println("");
        displayPipe(scene.getPipe1());
        System.out.println("");
        displayPipe(scene.getPipe2());
        System.out.println("");
        displayPipe(scene.getPipe3());
        System.out.println("");
    }

    private static void displayPipe(Pipe pipe) {
        List<Card> cards = pipe.getCardList();
        int cpt = 0;
        for (Card card : cards) {
            displayCard(card);
            cpt++;
        }
    }

    private static void displayCard(Card card) {
        System.out.printf("%3s", card.getValue());
    }

    private static void SetErrorValueCard() {
        System.out.println("Cette carte n'est pas dans ta main. Essaie encore");
    }

    private static int getUserCardValue(Player player, Scanner sc) {
        System.out.println("Joueur "+player.getName()+", Que jouez vous ?");
        return sc.nextInt();
    }

    private static String getUserName(Scanner sc) {
        System.out.println("Saisir le nom d'un joueur");
        return sc.nextLine();
    }
}
