package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.gameFramework.class_340;

public strictfp class LogicBooleanGameFunctions$SpeedValueBoolean extends LogicBoolean$AbstractNumberBoolean {
    public String getName() {
        return "Speed";
    }

    public float getValue(OrderableUnit var1) {
        float var2;
        if (var1.bi()) {
            var2 = class_340.b(0.0F, 0.0F, var1.cc, var1.cd);
            return var2;
        } else {
            var2 = var1.cf;
            return var2 < 0.0F ? -var2 : var2;
        }
    }

    public float getMaxValue(OrderableUnit var1) {
        return 2.1474836E9F;
    }
}
