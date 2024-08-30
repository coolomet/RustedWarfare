package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;

public final strictfp class LogicBooleanGameFunctions$BuiltAmountBoolean extends LogicBoolean$AbstractNumberBoolean {
    public String getName() {
        return "BuiltAmount";
    }

    public float getValue(OrderableUnit var1) {
        return var1.cm;
    }

    public float getMaxValue(OrderableUnit var1) {
        return 1.0F;
    }
}
