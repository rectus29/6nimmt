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
package com.rectus29.nimmt.entities;

import com.sun.istack.internal.NotNull;

public class Scene extends GenericEntities{

	private Pipe pipe0;

	private Pipe pipe1;

	private Pipe pipe2;

	private Pipe pipe3;

	public Scene() {
	}

	private void initScene(@NotNull Card card0, @NotNull Card card1, @NotNull Card card2,
			@NotNull Card card3) {
		this.pipe0 = new Pipe(card0);
		this.pipe1 = new Pipe(card1);
		this.pipe2 = new Pipe(card2);
		this.pipe3 = new Pipe(card3);
	}
}
