package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;

public final strictfp class LogicBooleanGameFunctions$KillsBoolean extends LogicBoolean$AbstractNumberBoolean {
    public String getName() {
        return "Kills";
    }

    public float getValue(OrderableUnit var1) {
        return (float)var1.cU;
    }

    public float getMaxValue(OrderableUnit var1) {
        return 2.1474836E9F;
    }
}
