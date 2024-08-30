package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;

public abstract strictfp class LogicBooleanLoader$LogicBooleanScopeOnly extends LogicBoolean implements LogicBooleanLoader$LogicBooleanContext {
    public LogicBooleanLoader$LogicBooleanContext createContext() {
        return this;
    }

    public LogicBoolean setChild(LogicBoolean var1) {
        return var1;
    }

    public boolean read(OrderableUnit var1) {
        return false;
    }

    public LogicBoolean$ReturnType getReturnType() {
        return LogicBoolean$ReturnType.voidReturn;
    }

    public String getMatchFailReasonForPlayer(OrderableUnit var1) {
        return "<scope>";
    }
}
