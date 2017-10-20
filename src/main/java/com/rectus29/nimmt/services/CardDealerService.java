package com.rectus29.nimmt.services;

import com.rectus29.nimmt.entities.Card;
import com.rectus29.nimmt.entities.Party;

import java.util.ArrayList;
import java.util.List;

public class CardDealerService {
	
	private static List<Card> refCardList;

	public CardDealerService() {
		this.refCardList = initRefPickList();
	}

    private List<Card> initRefPickList() {
	    return new ArrayList<>();
    }


    public Party initParty(Party party){
		List<Card> currentPickList = new ArrayList<>(refCardList);
		return null;
	}
	
	
	//fine par 5 =2 
	//dizaine =3
	//double chiffre  =5
	// 55 = 7
	
}
