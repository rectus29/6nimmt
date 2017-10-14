package com.rectus29.nimmt.entities;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Player extends GenericEntities{

    public UUID uuid = UUID.randomUUID();

    public String name;

    private double score = 0;

    private List<Card> cardList = new ArrayList<>();

	public Player(@NotNull String name) {
		this.name = name;
	}

    public UUID getUuid() {
        return uuid;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;

        Player player = (Player) o;

        return uuid != null ? uuid.equals(player.uuid) : player.uuid == null;
    }

    @Override
    public int hashCode() {
        return uuid != null ? uuid.hashCode() : 0;
    }

    public String getName() {
        return name;
    }

    public Card getCard(int valueCard) throws Exception {
	    //TODO cardlist is not smart, i need cart with value valueCard
        //This must be in cardList hndler
        for (Card card : cardList) {
            if(card.getValue() == valueCard){
                return card;
            }
        }
        throw new Exception("This player has no card with value "+valueCard);
    }
}
