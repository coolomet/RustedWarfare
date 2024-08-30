package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;

public final strictfp class LogicBooleanGameFunctions$HpBoolean extends LogicBoolean$AbstractNumberBoolean {
    public String getName() {
        return "Hp";
    }

    public float getValue(OrderableUnit var1) {
        return var1.health;
    }

    public float getMaxValue(OrderableUnit var1) {
        return var1.totalHealth;
    }
}
