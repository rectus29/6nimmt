package com.rectus29.nimmt.entities;

import com.rectus29.nimmt.report.SceneReport;

public class PipePayLoad extends PayLoad {
    private final int userPipeToFlushedNumber;
    private CardPayLoad cardPayLoad;

    public PipePayLoad(CardPayLoad payLoad, int userPipeToFlushedNumber) {
        super(payLoad.getPlayer());
        this.cardPayLoad = payLoad;
        this.userPipeToFlushedNumber = userPipeToFlushedNumber;
    }

    @Override
    public SceneReport act(Scene scene) {
        return scene.flush(userPipeToFlushedNumber, cardPayLoad.getCard());
    }
}
