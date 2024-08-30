package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;

public final strictfp class LogicBoolean$StaticBooleanFalse extends LogicBoolean$StaticBoolean {
    public String getMatchFailReasonForPlayer(OrderableUnit var1) {
        return "false";
    }

    public boolean read(OrderableUnit var1) {
        return false;
    }
}
