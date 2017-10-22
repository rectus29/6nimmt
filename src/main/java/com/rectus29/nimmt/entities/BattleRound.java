package com.rectus29.nimmt.entities;

import com.rectus29.nimmt.enums.GameAction;
import com.rectus29.nimmt.enums.State;
import com.rectus29.nimmt.report.SceneReport;
import com.sun.istack.internal.NotNull;

import java.util.*;


public class BattleRound extends GenericEntities {

    private State state = State.WIP;
    private Set<CardPayLoad> payLoadList = new TreeSet<>();
    private List<PipePayLoad> pipePayLoadList = new ArrayList<>();
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
        if(pipePayLoadList != null && !pipePayLoadList.isEmpty()) {
            PipePayLoad pipePayLoad = pipePayLoadList.get(pipePayLoadList.size() - 1);
            pipePayLoadList.remove(pipePayLoad);
            return pipePayLoad;
        }
        CardPayLoad result = null;
        for (CardPayLoad cardPayLoad : payLoadList) {
            result = cardPayLoad;
            break;
        }
        if(result == null){
            throw new Exception("missing in translation");
        }
        payLoadList.remove(result);
        if(payLoadList.size() == 0) {
            readyToSolve = false;
            state = State.CLOSED;
        }
        return result;
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
                break;
            case ADDTOPIPE:
                state = State.CLOSED;
                break;
            case FLUSHPIPE:
                state = State.CLOSED;
                break;

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
        this.pipePayLoadList.add(new PipePayLoad((CardPayLoad) this.sceneReportList.get(sceneReportList.size()-1).getPayload(), userPipeToFlushedNumber));
        this.readyToSolve = true;
        return this;
    }

    public void setReadyToSolve(boolean readyToSolve) {
        this.readyToSolve = readyToSolve;
    }

    public Set<CardPayLoad> getPayLoadList() {
        return payLoadList;
    }

    public BattleRoundReport resolve(Scene scene) throws Exception {
        while (isReadyToResolve()) {
            PayLoad currentPayload = nextPayLoad();
            SceneReport sceneReport = currentPayload.act(scene);
            if(sceneReport.getGameAction().equals(GameAction.PICKPIPE)){
                readyToSolve  = false;
            }
            sceneReport.setPayload(currentPayload);
            addSceneReport(sceneReport);
        }
       return new BattleRoundReport(getState());
    }
}

