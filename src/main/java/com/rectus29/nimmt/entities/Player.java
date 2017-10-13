package com.rectus29.nimmt.entities;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Player extends GenericEntities{

	private String name;

	private double score = 0;

	private List<Card> cardList = new ArrayList<Card>();

	public Player(@NotNull String name) {
		this.name = name;
	}
}
