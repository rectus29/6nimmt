package com.rectus29.entities;

public class Card extends GenericEntities{

	private int weight = 0;

	private int value = 0;

	public Card(int weight, int value) {
		this.weight = weight;
		this.value = value;
	}

	public int getWeight() {
		return weight;
	}

	public Card setWeight(int weight) {
		this.weight = weight;
		return this;
	}

	public int getValue() {
		return value;
	}

	public Card setValue(int value) {
		this.value = value;
		return this;
	}
}
