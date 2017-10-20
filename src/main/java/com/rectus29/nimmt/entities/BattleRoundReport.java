package com.rectus29.nimmt.entities;

import com.rectus29.nimmt.enums.State;
import com.rectus29.nimmt.report.GameReport;

public class BattleRoundReport implements GameReport {
    State state;

    public BattleRoundReport(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
