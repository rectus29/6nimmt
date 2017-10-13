package com.rectus29.nimmt;

import com.rectus29.nimmt.entities.Party;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
		final Logger log = LogManager.getLogger(Main.class);
		log.debug("start");
		log.debug(NimmtConfiguration.getInstance().getMaxPlayer());
        Scanner sc = new Scanner(System.in);
		Party party = new Party();
		party.begin();
		String userName = getUserName( sc);
        log.debug("first user "+userName);
	// write your code here
    }

    private static String getUserName(Scanner sc) {
        System.out.println("Saisir le nom d'un joueur");
        return sc.nextLine();
    }
}
