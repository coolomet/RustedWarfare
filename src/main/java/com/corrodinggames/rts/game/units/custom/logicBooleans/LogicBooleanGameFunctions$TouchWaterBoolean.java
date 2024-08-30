package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;

public strictfp class LogicBooleanGameFunctions$TouchWaterBoolean extends LogicBoolean {
    public boolean read(OrderableUnit var1) {
        boolean var2 = false;
        if (var1.cH()) {
            var2 = true;
        }

        return var2;
    }

    public String getMatchFailReasonForPlayer(OrderableUnit var1) {
        return "TouchWater";
    }
}
