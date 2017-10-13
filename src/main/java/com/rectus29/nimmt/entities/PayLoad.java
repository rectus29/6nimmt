package com.rectus29.nimmt.entities;

import com.sun.istack.internal.NotNull;

public class PayLoad extends GenericEntities{

    private Player player;
    private Card card;

    public PayLoad(@NotNull Player player, @NotNull Card card) {
        this.player = player;
        this.card = card;
    }

    public Player getPlayer() {
        return player;
    }

    public Card getCard() {
        return card;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PayLoad)) return false;

        PayLoad payLoad = (PayLoad) o;

        return player != null ? player.equals(payLoad.player) : payLoad.player == null;
    }

    @Override
    public int hashCode() {
        return player != null ? player.hashCode() : 0;
    }
}
