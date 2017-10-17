package com.rectus29.nimmt.entities;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

public class Card extends GenericEntities{

	private int weight = 1;

	private int value = 0;

	public Card(@Nullable int value,@NotNull int weight) {
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Card card = (Card) o;

		if (weight != card.weight) return false;
		return value == card.value;
	}

	@Override
	public int hashCode() {
		int result = weight;
		result = 31 * result + value;
		return result;
	}
}
