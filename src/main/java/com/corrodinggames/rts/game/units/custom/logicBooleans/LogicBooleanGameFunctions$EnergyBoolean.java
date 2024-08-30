package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;

public final strictfp class LogicBooleanGameFunctions$EnergyBoolean extends LogicBoolean$AbstractNumberBoolean {
    public String getName() {
        return "Energy";
    }

    public float getValue(OrderableUnit var1) {
        return var1.cB;
    }

    public float getMaxValue(OrderableUnit var1) {
        return var1.bd();
    }
}
