package com.rectus29.nimmt.report;

import com.rectus29.nimmt.entities.Card;
import com.rectus29.nimmt.entities.CardPayLoad;
import com.rectus29.nimmt.entities.PayLoad;
import com.rectus29.nimmt.entities.Player;
import com.rectus29.nimmt.enums.GameAction;

import java.util.ArrayList;
import java.util.List;

public class SceneReport implements GameReport{

	private GameAction gameAction = GameAction.ADDTOPIPE;
	private List<Card> cardList = new ArrayList<>();
	private PayLoad payload;	


	public SceneReport() {
	}

	public SceneReport(GameAction gameAction, Card card) {
		this.gameAction = gameAction;
		this.cardList.add(card);
	}

	public SceneReport(GameAction gameAction, List<Card> flush) {
		this.cardList = flush;
		this.gameAction = gameAction;
	}

	public List<Card> getCardList() {
		return cardList;
	}

	public GameAction getGameAction() {
		return gameAction;
	}

	public Player getPlayer() {
		return this.payload.getPlayer();
	}

	public void setPayload(PayLoad payload) {
		this.payload = payload;
	}

	public PayLoad getPayload() {
		return payload;
	}
}
