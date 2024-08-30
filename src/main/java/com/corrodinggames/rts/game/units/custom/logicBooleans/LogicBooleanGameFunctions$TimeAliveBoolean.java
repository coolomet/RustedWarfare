package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;

public final strictfp class LogicBooleanGameFunctions$TimeAliveBoolean extends LogicBoolean$TimeBoolean {
    public String getName() {
        return "TimeAlive";
    }

    public int getTime(OrderableUnit var1) {
        return var1.bz;
    }
}
