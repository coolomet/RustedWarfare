package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;

public final strictfp class LogicBooleanGameFunctions$TeamWipedOutBoolean extends LogicBoolean$LogicBooleanCommon {
    public String getName() {
        return "teamWipedOut";
    }

    public boolean read(OrderableUnit var1) {
        return var1.bX.G;
    }
}
