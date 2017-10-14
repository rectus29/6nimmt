package com.rectus29.nimmt.entities;

import com.rectus29.nimmt.enums.State;
import com.sun.istack.internal.NotNull;

import java.util.HashSet;
import java.util.Set;

public class BattleRound extends GenericEntities {

    private Party party;
    private State state = State.WIP;
    private Set<PayLoad> payLoadList = new HashSet<>();

    public BattleRound(Party party) {
        this.party = party;
    }

    public Set<PayLoad> getPayLoadList() {
        return payLoadList;
    }

    public BattleRound addPayload(@NotNull Player player, @NotNull Card card) {
        this.payLoadList.add(new PayLoad(player, card));
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
}
