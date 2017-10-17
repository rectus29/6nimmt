package com.rectus29.nimmt.entities;

import com.rectus29.nimmt.enums.State;
import com.rectus29.nimmt.report.SceneReport;
import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class BattleRound extends GenericEntities {

    private Party party;
    private State state = State.WIP;
    private Set<CardPayLoad> payLoadList = new TreeSet<>();
    private List<SceneReport> sceneReportList = new ArrayList<>();

    public BattleRound(Party party) {
        this.party = party;
    }

    public Set<CardPayLoad> getPayLoadList() {
        return payLoadList;
    }

    public BattleRound addPayload(@NotNull Player player, @NotNull Card card) {
        this.payLoadList.add(new CardPayLoad(player, card));
        return this;
    }
    
    public boolean isReadyToResolve() {
        return payLoadList.size() == party.getPlayerList().size();
    }

    public boolean hasPlayLoad(Player player) {
        //TODO I have to Iter on playLoadList...A map ?
        for (PayLoad payLoad : payLoadList) {
            if(payLoad.getPlayer().equals(player)){
                return true;
            }
        }
        return false;
    }

	public CardPayLoad nextCardPayLoad() throws Exception {
		for (CardPayLoad payLoad : payLoadList) {
			boolean found = false;
			for (SceneReport sceneReport : sceneReportList) {
				if (sceneReport.getPayload() == payLoad) {
					found = true;
				}
			}
			if(!found){
				return payLoad;	
			}
		}
		throw new Exception("missing in translation");
	}

	/**
	 * Add scene report battle round.
	 *
	 * @param sceneReport the scene report
	 * @return the battle round
	 */
	public BattleRound addSceneReport(SceneReport sceneReport) {
    	this.sceneReportList.add(sceneReport);
    	return this;
	}
}
