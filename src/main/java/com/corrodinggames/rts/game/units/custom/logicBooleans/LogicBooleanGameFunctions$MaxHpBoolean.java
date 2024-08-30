package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;

public final strictfp class LogicBooleanGameFunctions$MaxHpBoolean extends LogicBoolean$AbstractNumberBoolean {
    public String getName() {
        return "maxHp";
    }

    public float getValue(OrderableUnit var1) {
        return var1.totalHealth;
    }

    public float getMaxValue(OrderableUnit var1) {
        return 2.1474836E9F;
    }
}
