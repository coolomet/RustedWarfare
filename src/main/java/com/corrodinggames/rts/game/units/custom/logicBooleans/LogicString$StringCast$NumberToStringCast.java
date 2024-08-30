package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.gameFramework.class_340;

public strictfp class LogicString$StringCast$NumberToStringCast extends LogicString$StringCast {
    public String readString(OrderableUnit var1) {
        float var2 = this.child.readNumber(var1);
        return class_340.a(var2, 2);
    }
}
