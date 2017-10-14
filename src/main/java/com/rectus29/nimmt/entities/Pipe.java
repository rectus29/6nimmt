package com.rectus29.nimmt.entities;

import com.rectus29.nimmt.configuration.NimmtConfigurationResourceBundle;
import com.rectus29.nimmt.enums.PipeAction;

import java.util.ArrayList;
import java.util.List;

public class Pipe extends GenericEntities{

	private List<Card> cardList = new ArrayList<Card>();

	public Pipe(Card newCard) {
		this.cardList.add(newCard);
	}

	public List<Card> getCardList() {
		return cardList;
	}

	public Pipe setCardList(List<Card> cardList) {
		this.cardList = cardList;
		return this;
	}

	/**
	 * use to add card in the current pipe, return a pipe report
	 * @param card the card to add to the pipe
	 * @return a pipe report, if the pipe has flush the pipe action is set to FLUSH and the content of the 
	 * pipe is in the report 
	 */
	public PipeReport addCard(Card card) {
		if (this.cardList.size() >= NimmtConfigurationResourceBundle.getInstance().getMaxPipeLenght()) {
			return new PipeReport(PipeAction.FLUSH, this.flush());
		} else {
			return new PipeReport(card);
		}
	}

	/**
	 * this function flush the current pipe and return the content of the pipe
	 *
	 * @return the card who was present in the pipe before the flush
	 */
	private List<Card> flush() {
		List<Card> out = new ArrayList<>(this.cardList);
		this.cardList.clear();
		return out;
	}

	
	private class PipeReport{

		private List<Card> cardList = new ArrayList<>();

		private PipeAction pipeAction = PipeAction.ADD;

		public PipeReport(Card card) {
			this.cardList.add(card);
		}

		public PipeReport(PipeAction pipeAction, List<Card> flush) {
			this.cardList = flush;
			this.pipeAction = pipeAction;
		}

		public List<Card> getCardList() {
			return cardList;
		}

		public PipeAction getPipeAction() {
			return pipeAction;
		}
	}
}
