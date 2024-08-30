package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.gameFramework.class_340;

public abstract strictfp class LogicBoolean$LogicNumberOnly extends LogicBoolean {
    public LogicBoolean$ReturnType getReturnType() {
        return LogicBoolean$ReturnType.number;
    }

    public boolean read(OrderableUnit var1) {
        return false;
    }

    public abstract String getName();

    public abstract float readNumber(OrderableUnit var1);

    public String getMatchFailReasonForPlayer(OrderableUnit var1) {
        String var2 = this.getName() + "(" + getAllParametersDebug(this, var1) + ")=" + class_340.a(this.readNumber(var1), 3) + "";
        return var2;
    }
}
