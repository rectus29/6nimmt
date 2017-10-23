package com.rectus29.nimmt.services;

import com.rectus29.nimmt.entities.Card;
import com.rectus29.nimmt.entities.Party;
import com.rectus29.nimmt.entities.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardDealerService {
	
	private static List<Card> refCardList;

	public CardDealerService() {
		this.refCardList = buildRefStack();
	}
	
	private List<Card> buildRefStack() {
		List<Card> out = new ArrayList<>();
		for (int i = 1; i <= 104; i++) {
			int weight = 1;
			if(i % 10 == 5){
				weight += 1;
			}
			if(i %10 == 0){
				weight += 2;
			}
			if(i %11 == 0){
				weight += 4;
			}
			out.add(new Card(i, weight));
		}	
		return out;
	}

	public Party initParty(Party party){
		List<Card> currentPickList = new ArrayList<>(refCardList);
		//for each player in the party build an and 
		for (Player player : party.getPlayerList()) {
			List<Card> cardList = new ArrayList<>();
			//TODO place access to config here
			for (int i = 0; i < 10; i++) {
				cardList.add(getACard(currentPickList));
			}
			player.setCardList(cardList);			
		}
		//place pick list into the party
		party.setPickList(currentPickList);
		return party;
	}

	private Card getACard(List<Card> currentPickList) {
		int index = 0 + new Random().nextInt(currentPickList.size() - 0);
		Card card = currentPickList.get(index);
		currentPickList.remove(card);
		return card;
	}

	//fine par 5 =2 
	//dizaine =3
	//double chiffre  =5
	// 55 = 7
	
}
