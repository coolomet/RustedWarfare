package com.corrodinggames.rts.game;

// $FF: renamed from: com.corrodinggames.rts.game.q
public enum Side {
    OWN("own", 0),
    ALLY("ally", 1),
    ALLY_NOT_OWN("allyNotOwn", 2),
    ENEMY("enemy", 3),
    NEUTRAL("neutral", 4),
    ANY("any", 5),
    NOT_OWN("notOwn", 6);
    // $FF: synthetic field
    private static final Side[] h = new Side[]{OWN, ALLY, ALLY_NOT_OWN, ENEMY, NEUTRAL, ANY, NOT_OWN};
    Side(String var1, int var2) {
    }
}
