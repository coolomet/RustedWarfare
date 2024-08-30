package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;

public strictfp class LogicString$Debug extends LogicString$WrappingLogicString {
    public String readString(OrderableUnit var1) {
        return this.children[0].getMatchFailReasonForPlayer(var1);
    }
}
