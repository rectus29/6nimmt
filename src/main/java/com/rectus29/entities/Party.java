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
package com.rectus29.entities;

import java.util.ArrayList;
import java.util.List;

public class Party extends GenericEntities{
	
	private List<Player> playerList = new ArrayList<Player>();
	private List<Card> pickList = new ArrayList<Card>(); 
	private Scene scene = new Scene();

	public Party() {
	}

	public List<Player> getPlayerList() {
		return playerList;
	}

	public Party setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
		return this;
	}

	public List<Card> getPickList() {
		return pickList;
	}

	public Party setPickList(List<Card> pickList) {
		this.pickList = pickList;
		return this;
	}

	public Scene getScene() {
		return scene;
	}

	public Party setScene(Scene scene) {
		this.scene = scene;
		return this;
	}
}
