package com.rectus29.nimmt.entities;

import com.sun.istack.internal.NotNull;

public class Scene extends GenericEntities{

	private Pipe pipe0;

	private Pipe pipe1;

	private Pipe pipe2;

	private Pipe pipe3;

	public Scene() {
	}

	public Scene initScene(@NotNull Card card0, @NotNull Card card1, @NotNull Card card2,
			@NotNull Card card3) {
		this.pipe0 = new Pipe(card0);
		this.pipe1 = new Pipe(card1);
		this.pipe2 = new Pipe(card2);
		this.pipe3 = new Pipe(card3);
		return this;
	}
}
