package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.gameFramework.class_340;

public strictfp class LogicBooleanGameFunctions$SpeedBoolean extends LogicBoolean {
    @LogicBoolean$Parameter
    public boolean atTopSpeed;

    public boolean read(OrderableUnit var1) {
        boolean var2 = false;
        float var3 = var1.speed() - 0.1F;
        if (var1.bi()) {
            float var4 = class_340.a(0.0F, 0.0F, var1.cc, var1.cd);
            if (var4 != 0.0F && var4 > var3 * var3) {
                var2 = true;
            }
        } else if (var1.cf != 0.0F && var1.cf > var3) {
            var2 = true;
        }

        return var2;
    }

    public String getMatchFailReasonForPlayer(OrderableUnit var1) {
        return "Speed";
    }
}
