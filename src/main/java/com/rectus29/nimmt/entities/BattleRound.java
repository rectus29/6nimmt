package com.rectus29.nimmt.entities;

import com.rectus29.nimmt.enums.State;
import com.rectus29.nimmt.report.SceneReport;
import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;


public class BattleRound extends GenericEntities {

    private State state = State.WIP;
    private List<PayLoad> payLoadList = new ArrayList<>();
    private List<SceneReport> sceneReportList = new ArrayList<>();
    private boolean readyToSolve  = false;

    public BattleRound() {

    }


    public BattleRound addPayload(@NotNull Player player, @NotNull Card card) {
        this.payLoadList.add(new CardPayLoad(player, card));
        return this;
    }
    
    public boolean isReadyToResolve() {
            return readyToSolve;
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

	public PayLoad nextPayLoad() throws Exception {
		for (PayLoad payLoad : payLoadList) {
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
	    switch (sceneReport.getGameAction()){
            case PICKPIPE:
                state = State.WAITUSERACTION;
            case ADDTOPIPE:
                state = State.CLOSED;
            case FLUSHPIPE:
                state = State.CLOSED;

        }
    	this.sceneReportList.add(sceneReport);
    	return this;
	}

    public State getState() {
	    return state;
    }

    public Player getWaitedUser() {
	    return sceneReportList.get(sceneReportList.size()-1).getPlayer();
    }

    public BattleRound addPipePayload(Player p, int userPipeToFlushedNumber) {
        this.payLoadList.add(new PipePayLoad(p, userPipeToFlushedNumber));
        this.readyToSolve = true;
        return this;
    }

    public void setReadyToSolve(boolean readyToSolve) {
        this.readyToSolve = readyToSolve;
    }

    public List<PayLoad> getPayLoadList() {
        return payLoadList;
    }
}

