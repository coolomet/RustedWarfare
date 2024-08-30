package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$ReturnType;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.aq
public abstract strictfp class class_423 extends class_421 {
    LogicBoolean a;

    class_423(LogicBoolean var1) {
        this.a = var1;
    }

    static class_423 a(LogicBoolean var0) {
        LogicBoolean$ReturnType var1 = var0.getReturnType();
        if (var1 == LogicBoolean$ReturnType.number) {
            return new class_424(var0);
        } else if (var1 == LogicBoolean$ReturnType.string) {
            return new class_427(var0);
        } else if (var1 == LogicBoolean$ReturnType.unit) {
            return new class_426(var0);
        } else {
            return (class_423)(LogicBoolean$ReturnType.isArrayType(var1) ? new class_428(var0) : new class_425(var0));
        }
    }
}
