package com.corrodinggames.rts.game.units;

// $FF: renamed from: com.corrodinggames.rts.game.units.b
public enum AttackMovementType {
    NORMAL("normal", 0),
    STRAFING("strafing", 1),
    MOVEAWAY("moveaway", 2),
    BOMBER("bomber", 3);
    // $FF: synthetic field
    private static final AttackMovementType[] e = new AttackMovementType[]{NORMAL, STRAFING, MOVEAWAY, BOMBER};

    private AttackMovementType(String var1, int var2) {
    }
}
