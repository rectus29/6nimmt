package com.rectus29.nimmt.entities;

import com.rectus29.nimmt.report.SceneReport;
import com.sun.istack.internal.NotNull;

public class CardPayLoad extends PayLoad implements Comparable<CardPayLoad>{

    private Card card;

    public CardPayLoad(@NotNull Player player, @NotNull Card card) {
        super(player);
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CardPayLoad)) return false;

		CardPayLoad payLoad = (CardPayLoad) o;

        return player != null ? player.equals(payLoad.player) : payLoad.player == null;
    }

    @Override
    public int hashCode() {
        return player != null ? player.hashCode() : 0;
    }

	@Override
	public int compareTo(CardPayLoad o) {
		if(this.getCard().getValue() < o.getCard().getValue()){
			return -1;
		}else if(this.getCard().getValue() > o.getCard().getValue()){
			return 1;
		}
    	return 0;
	}

    @Override
    public SceneReport act(Scene scene) {
        return scene.addCard(getCard());
    }
}
