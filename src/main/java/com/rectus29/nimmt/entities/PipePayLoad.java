package com.rectus29.nimmt.entities;

import com.rectus29.nimmt.report.SceneReport;

public class PipePayLoad extends PayLoad {
    private final int userPipeToFlushedNumber;

    public PipePayLoad(Player player, int userPipeToFlushedNumber) {
        super(player);
        this.userPipeToFlushedNumber = userPipeToFlushedNumber;
    }

    @Override
    public SceneReport act(Scene scene) {
        return scene.flush(userPipeToFlushedNumber);
    }
}
