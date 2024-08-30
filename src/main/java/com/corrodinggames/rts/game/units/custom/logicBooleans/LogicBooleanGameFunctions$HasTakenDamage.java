package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;

public strictfp class LogicBooleanGameFunctions$HasTakenDamage extends LogicBoolean$TimeBoolean {
    public int getTime(OrderableUnit var1) {
        return var1.bs;
    }

    public String getName() {
        return "HasTakenDamage";
    }
}
