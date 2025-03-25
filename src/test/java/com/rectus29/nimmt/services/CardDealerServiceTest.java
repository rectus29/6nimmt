package com.rectus29.nimmt.services;

import com.rectus29.nimmt.configuration.NimmtConfiguration;
import com.rectus29.nimmt.entities.Party;
import com.rectus29.nimmt.entities.Player;
import org.junit.Assert;
import org.junit.Test;

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