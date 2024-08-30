package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;

public abstract strictfp class VariableScope$VariableData extends LogicBoolean {
    public abstract LogicBoolean$ReturnType getReturnType();

    public boolean read(OrderableUnit var1) {
        return false;
    }

    public String getMatchFailReasonForPlayer(OrderableUnit var1) {
        return "Data(" + this.valueToStringDebug((OrderableUnit)null) + ")";
    }

    public float readNumber(OrderableUnit var1) {
        return 0.0F;
    }

    public String readString(OrderableUnit var1) {
        return "";
    }
}
