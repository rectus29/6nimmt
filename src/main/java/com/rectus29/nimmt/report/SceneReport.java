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


	public SceneReport(Card card) {
		this.cardList.add(card);
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
