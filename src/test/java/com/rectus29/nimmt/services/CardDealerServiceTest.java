package com.rectus29.nimmt.services;

import com.rectus29.nimmt.configuration.NimmtConfiguration;
import com.rectus29.nimmt.entities.Party;
import com.rectus29.nimmt.entities.Player;
import org.junit.Assert;
import org.junit.Test;

/******************************************************************************
 * Copyright (c) 2000-2017 E-DEAL
 *
 * E-DEAL
 * 41 Rue Périer
 * 92120 Montrouge
 * France
 *
 * T: +33 (0)1 73 03 29 80
 * F: +33 (0)1 73 01 69 77
 * http://www.e-deal.com
 *
 * La diffusion de ce code source sous quelque forme que ce soit sans
 * l'autorisation de E-DEAL est interdite.
 *
 * Vous êtes autorisé à modifier ce code source uniquement pour votre usage
 * propre et sous réserve que les mentions de copyright demeurent intactes.
 *
 * Ce code est fourni en l'état. Aucune garantie d'aucune sorte, explicite ou
 * implicite n'est donnée. En aucun cas E-DEAL ne pourra être tenu pour
 * responsable des dommages pouvant résulter de l'utilisation de ce code
 * source.
 ******************************************************************************/
public class CardDealerServiceTest{

	@Test
	public void initParty() throws Exception {
		Party testPArty = new Party(new NimmtConfiguration(){

			@Override
			public int getBattleRoundNumber() {
				return 0;
			}

			@Override
			public int getMaxPlayer() {
				return 0;
			}

			@Override
			public int getMaxPipeLenght() {
				return 0;
			}
		});
		
		testPArty.addUser("test0");
		testPArty.addUser("test1");
		CardDealerService cds = new CardDealerService();
		testPArty = cds.initParty(testPArty);
		for (Player player : testPArty.getPlayerList()) {
			Assert.assertEquals("worng number of card", player.getCardList().size(), 10);
		}
	}

	@Test
	public void buildRefStackTest() throws Exception {
		CardDealerService test = new CardDealerService();
		System.out.println("yolo");
	}
}