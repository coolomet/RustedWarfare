package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;

public strictfp class VariableScope$VariableDataNull extends VariableScope$VariableData {
    public LogicBoolean$ReturnType getReturnType() {
        return LogicBoolean$ReturnType.voidReturn;
    }

    public String getMatchFailReasonForPlayer(OrderableUnit var1) {
        return "null";
    }
}
