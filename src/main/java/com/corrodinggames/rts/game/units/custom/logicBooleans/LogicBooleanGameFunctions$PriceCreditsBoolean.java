package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;

public final strictfp class LogicBooleanGameFunctions$PriceCreditsBoolean extends LogicBoolean$AbstractNumberBoolean {
    public String getName() {
        return "PriceCredits";
    }

    public float getValue(OrderableUnit var1) {
        return (float)var1.cL();
    }

    public float getMaxValue(OrderableUnit var1) {
        return 2.1474836E9F;
    }
}
