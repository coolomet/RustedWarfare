package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.gameFramework.class_340;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.an
public strictfp class class_424 extends class_423 {
    class_424(LogicBoolean var1) {
        super(var1);
    }

    String a(OrderableUnit var1) {
        return class_340.g(this.a.readNumber(var1));
    }
}
