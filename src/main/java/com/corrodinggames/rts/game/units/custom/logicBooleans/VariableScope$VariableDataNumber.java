package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;

public strictfp class VariableScope$VariableDataNumber extends VariableScope$VariableData {
    double number;

    public VariableScope$VariableDataNumber(double var1) {
        this.number = var1;
    }

    public LogicBoolean$ReturnType getReturnType() {
        return LogicBoolean$ReturnType.number;
    }

    public float readNumber(OrderableUnit var1) {
        return (float)this.number;
    }
}
