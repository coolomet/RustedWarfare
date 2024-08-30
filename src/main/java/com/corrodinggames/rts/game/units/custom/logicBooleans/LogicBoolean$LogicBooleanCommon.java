package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;

public abstract strictfp class LogicBoolean$LogicBooleanCommon extends LogicBoolean {
    public abstract String getName();

    public String getMatchFailReasonForPlayer(OrderableUnit var1) {
        String var2 = this.getName() + "=" + (this.read(var1) ? "true" : "false") + "";
        return var2;
    }
}
