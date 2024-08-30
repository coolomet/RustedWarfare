package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;

public final strictfp class LogicBooleanGameFunctions$TeamVictoryBoolean extends LogicBoolean$LogicBooleanCommon {
    public String getName() {
        return "teamVictory";
    }

    public boolean read(OrderableUnit var1) {
        return var1.bX.H;
    }
}
