package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.am
public strictfp class class_425 extends class_423 {
    class_425(LogicBoolean var1) {
        super(var1);
    }

    String a(OrderableUnit var1) {
        return this.a.read(var1) ? "true" : "false";
    }
}
