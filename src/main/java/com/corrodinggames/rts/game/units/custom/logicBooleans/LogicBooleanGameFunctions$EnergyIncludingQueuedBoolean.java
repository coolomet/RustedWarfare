package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.d.class_447;

public final strictfp class LogicBooleanGameFunctions$EnergyIncludingQueuedBoolean extends LogicBoolean$AbstractNumberBoolean {
    public String getName() {
        return "EnergyIncludingQueued";
    }

    public float getValue(OrderableUnit var1) {
        float var2 = var1.cB;
        class_447 var3 = var1.by();
        var2 += var3.c;
        return var2;
    }

    public float getMaxValue(OrderableUnit var1) {
        return var1.bd();
    }
}
