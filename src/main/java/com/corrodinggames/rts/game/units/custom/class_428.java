package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicString;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.al
public strictfp class class_428 extends class_423 {
    class_428(LogicBoolean var1) {
        super(var1);
    }

    String a(OrderableUnit var1) {
        return LogicString.arrayToString(var1, this.a);
    }
}
