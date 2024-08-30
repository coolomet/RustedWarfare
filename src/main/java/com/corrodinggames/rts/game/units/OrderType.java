package com.corrodinggames.rts.game.units;

// $FF: renamed from: com.corrodinggames.rts.game.units.ag
public enum OrderType {
    ATTACK("attack", 0),
    MOVE("move", 1),
    NEW_SELECTION("newSelection", 2);
    // $FF: synthetic field
    private static final OrderType[] d = new OrderType[]{ATTACK, MOVE, NEW_SELECTION};
    OrderType(String var1, int var2) {
    }
}
