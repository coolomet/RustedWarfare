package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;

public strictfp class VariableScope$VariableDataString extends VariableScope$VariableData {
    String text;

    public VariableScope$VariableDataString(String var1) {
        this.text = var1;
    }

    public LogicBoolean$ReturnType getReturnType() {
        return LogicBoolean$ReturnType.string;
    }

    public String readString(OrderableUnit var1) {
        return this.text;
    }
}
