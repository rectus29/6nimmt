package com.rectus29.nimmt.entities;

import com.rectus29.nimmt.report.SceneReport;

public abstract class PayLoad extends GenericEntities{
	
	protected Player player;
	
	public PayLoad(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return player;
	}

    public abstract SceneReport act(Scene scene) ;
}
