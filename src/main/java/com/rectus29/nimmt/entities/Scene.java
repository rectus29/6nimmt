package com.rectus29.nimmt.entities;

import com.rectus29.nimmt.enums.GameAction;
import com.rectus29.nimmt.report.SceneReport;
import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Scene extends GenericEntities{

	private List<Pipe> pipeList = new ArrayList<>();	
	
	public Scene() {
	}

	public Scene initScene(@NotNull Card card0, @NotNull Card card1, @NotNull Card card2,
			@NotNull Card card3) {
		this.pipeList.add(new Pipe(card0));
		this.pipeList.add(new Pipe(card1));
		this.pipeList.add(new Pipe(card2));
		this.pipeList.add(new Pipe(card3));
		return this;
	}

	public SceneReport addCard(Card card){
		Collections.sort(this.pipeList, new Comparator<Pipe>(){
			@Override
			public int compare(Pipe o1, Pipe o2) {
				if(o1.getTopValue() > o2.getTopValue()){
					return -1;
				}else if (o1.getTopValue() < o2.getTopValue()){
					return 1;
				}
				return 0;
			}
		});
		//normal case 
		for (Pipe pipe : pipeList) {
			if(card.getValue() > pipe.getTopValue()){
				return pipe.addCard(card);
			}
		}
		//if no suitable pipe found return a report 
		return new SceneReport(GameAction.PICKPIPE, card);
	}

    public List<Pipe> getPipeList() {
        return pipeList;
    }

    public SceneReport flush(int pipeNumber, Card card){
        return pipeList.get(pipeNumber).forceFlush(card);
    }

}
