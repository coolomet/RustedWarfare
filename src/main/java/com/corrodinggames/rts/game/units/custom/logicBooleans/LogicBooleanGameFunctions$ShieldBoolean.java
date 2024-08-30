package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;

public final strictfp class LogicBooleanGameFunctions$ShieldBoolean extends LogicBoolean$AbstractNumberBoolean {
    public String getName() {
        return "Shield";
    }

    public float getValue(OrderableUnit var1) {
        return var1.cx;
    }

    public float getMaxValue(OrderableUnit var1) {
        return var1.cA;
    }
}
