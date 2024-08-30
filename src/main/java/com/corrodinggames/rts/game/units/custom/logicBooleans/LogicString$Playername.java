package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;

public strictfp class LogicString$Playername extends LogicString {
    public String readString(OrderableUnit var1) {
        return var1.bX.name;
    }
}
