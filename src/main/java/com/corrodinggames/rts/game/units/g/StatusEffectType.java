package com.corrodinggames.rts.game.units.g;

// $FF: renamed from: com.corrodinggames.rts.game.units.g.b
abstract class StatusEffectType {
    public static final StatusEffectType MOVEMENT_SPEED = new class_797("movementSpeed", 0);
    public static final StatusEffectType SPECIAL_ACTION_BLOCK = new class_798("specialActionBlock", 1);
    // $FF: synthetic field
    private static final StatusEffectType[] c = new StatusEffectType[]{MOVEMENT_SPEED, SPECIAL_ACTION_BLOCK};

    public static StatusEffectType[] values() {
        return (StatusEffectType[])c.clone();
    }

    private StatusEffectType(String var1, int var2) {
    }

    abstract class_792 a();

    // $FF: synthetic method
    StatusEffectType(String var1, int var2, class_1022 var3) {
        this(var1, var2);
    }
}
