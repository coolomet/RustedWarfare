package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;

public final strictfp class LogicBooleanGameFunctions$AmmoBoolean extends LogicBoolean$AbstractNumberBoolean {
    public String getName() {
        return "Ammo";
    }

    public float getValue(OrderableUnit var1) {
        return (float)var1.cE;
    }

    public float getMaxValue(OrderableUnit var1) {
        return 2.1474836E9F;
    }
}
