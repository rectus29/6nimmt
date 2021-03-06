package com.rectus29.nimmt;

import com.rectus29.nimmt.configuration.NimmtConfiguration;
import com.rectus29.nimmt.configuration.NimmtConfigurationResourceBundle;
import com.rectus29.nimmt.entities.*;
import com.rectus29.nimmt.enums.State;
import com.rectus29.nimmt.report.GameReport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        final Logger log = LogManager.getLogger(Main.class);
        log.debug("init party");
        NimmtConfiguration configuration = NimmtConfigurationResourceBundle.getInstance();
        log.debug(configuration.getMaxPlayer());
        Scanner sc = new Scanner(System.in);
        Party party = new Party(configuration);

        party.begin();
//        String userName = getUserName(sc);
        String userName = "Emi";
        party.addUser(userName).toString();
        log.debug("first user " + userName);
//        userName = getUserName(sc);
        userName = "Jno";
        log.debug("second user " + userName);
        party.addUser(userName);
        party.startGame();
        for (Player player : party.getPlayerList()) {
            diplayUserGame(player);
        }
        while (party.hasBattleRound()) {
            diplayScene(party.getScene());
            party.startNewBattleRound();
            //TODO Token de battleround for ui sync
            for (Player player : party.getPlayerList()) {
                while (!party.getCurrentBattleround().hasPlayLoad(player)) {
                    try {
                        displayHand(player);
                        party.addPayload(player, player.getCard(getUserCardValue(player, sc)));
                    } catch (Exception e) {
                        SetErrorValueCard();
                    }
                }
            }
            BattleRoundReport report = party.resolveBattleRound();
            while (!State.CLOSED.equals(report.getState())) {
                diplayScene(party.getScene());
                Player p =  party.getCurrentBattleround().getWaitedUser();
                party.addPipePayload(p, getUserPipeToFlushedNumber(p, sc));
                report = party.resolveBattleRound();
            }
        }
        party.finish();
        // write your code here
    }

    private static void displayHand(Player player) {
        for (Card card : player.getCardList()) {
			displayCard(card);
        }
        System.out.println();
    }

    private static int getUserPipeToFlushedNumber(Player p, Scanner sc) {
        System.out.println("Joueur " + p.getName() +" Quel ligne voulez vous rammasser ");
        return sc.nextInt();
    }

    private static void diplayUserGame(Player player) {
    }

    private static void diplayScene(Scene scene) {
        System.out.println("--------------SCENE-----------------");
		for (int i = 0; i < scene.getPipeList().size(); i++) {
			System.out.printf(i + " -");
			displayPipe(scene.getPipeList().get(i));
			System.out.println("");
			
		}
        System.out.println("-----------------------------------");
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
		System.out.printf("%3s", " " + card.getValue() + "|" + card.getWeight() + " ");
    }

    private static void SetErrorValueCard() {
        System.out.println("Cette carte n'est pas dans ta main. Essaie encore");
    }

    private static int getUserCardValue(Player player, Scanner sc) {
        System.out.println("Joueur " + player.getName() + ", Que jouez vous ?");
        return sc.nextInt();
    }

    private static String getUserName(Scanner sc) {
        System.out.println("Saisir le nom d'un joueur");
        return sc.nextLine();
    }
}
