package com.corrodinggames.rts.game.units.custom;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.n
enum ActionType {
    move,
    attack,
    idle,
    created,
    underConstruction,
    underConstructionWithLinkedBuiltTime,
    queuedUnits,
    repair,
    reclaim;
    // $FF: synthetic field

    public static strictfp ActionType a(String var0) {
        try {
            return valueOf(var0);
        } catch (IllegalArgumentException var2) {
            return null;
        }
    }
}
