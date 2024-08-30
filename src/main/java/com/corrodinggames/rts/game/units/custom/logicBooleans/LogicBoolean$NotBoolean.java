package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;

public final strictfp class LogicBoolean$NotBoolean extends LogicBoolean {
    LogicBoolean child;

    public LogicBoolean$NotBoolean(LogicBoolean var1) {
        this.child = var1;
    }

    public boolean read(OrderableUnit var1) {
        return !this.child.read(var1);
    }

    public String getMatchFailReasonForPlayer(OrderableUnit var1) {
        return "not(" + this.child.getMatchFailReasonForPlayer(var1) + ")";
    }
}
