package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.d.class_447;

public final strictfp class LogicBooleanGameFunctions$AmmoIncludingQueuedBoolean extends LogicBoolean$AbstractNumberBoolean {
    public String getName() {
        return "AmmoIncludingQueued";
    }

    public float getValue(OrderableUnit var1) {
        int var2 = var1.cE;
        class_447 var3 = var1.by();
        var2 += var3.f;
        return (float)var2;
    }

    public float getMaxValue(OrderableUnit var1) {
        return 2.1474836E9F;
    }
}
