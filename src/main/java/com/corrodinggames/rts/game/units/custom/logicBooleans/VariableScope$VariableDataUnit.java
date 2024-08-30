package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;

public strictfp class VariableScope$VariableDataUnit extends VariableScope$VariableData {
    Unit unit;

    public VariableScope$VariableDataUnit(Unit var1) {
        this.unit = var1;
    }

    public LogicBoolean$ReturnType getReturnType() {
        return LogicBoolean$ReturnType.unit;
    }

    public Unit readUnit(OrderableUnit var1) {
        return this.unit;
    }
}
