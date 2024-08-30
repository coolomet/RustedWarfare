package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;

public final strictfp class LogicBoolean$StaticBooleanTrue extends LogicBoolean$StaticBoolean {
    public String getMatchFailReasonForPlayer(OrderableUnit var1) {
        return "true";
    }

    public boolean read(OrderableUnit var1) {
        return true;
    }
}
