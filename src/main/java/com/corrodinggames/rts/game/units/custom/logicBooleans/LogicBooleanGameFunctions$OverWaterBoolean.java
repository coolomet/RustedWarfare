package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;

public strictfp class LogicBooleanGameFunctions$OverWaterBoolean extends LogicBoolean {
    public boolean read(OrderableUnit var1) {
        boolean var2 = false;
        if (var1.cJ()) {
            var2 = true;
        }

        return var2;
    }

    public String getMatchFailReasonForPlayer(OrderableUnit var1) {
        return "OverWater";
    }
}
