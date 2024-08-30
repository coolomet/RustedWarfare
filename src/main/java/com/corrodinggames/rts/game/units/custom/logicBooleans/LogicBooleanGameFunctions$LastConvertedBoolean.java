package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;

public final strictfp class LogicBooleanGameFunctions$LastConvertedBoolean extends LogicBoolean$TimeBoolean {
    public String getName() {
        return "LastConverted";
    }

    public int getTime(OrderableUnit var1) {
        return var1.bB;
    }
}
