package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.gameFramework.utility.class_694;

public strictfp class LogicBooleanGameFunctions$InMapBoolean extends LogicBoolean {
    public boolean read(OrderableUnit var1) {
        boolean var2 = false;
        if (class_694.a(var1.xCord, var1.yCord)) {
            var2 = true;
        }

        return var2;
    }

    public String getMatchFailReasonForPlayer(OrderableUnit var1) {
        return "InMap";
    }
}
