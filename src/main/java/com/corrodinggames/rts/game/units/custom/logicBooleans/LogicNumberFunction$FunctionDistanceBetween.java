package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.gameFramework.class_340;

public strictfp class LogicNumberFunction$FunctionDistanceBetween extends LogicNumberFunction {
    @LogicBoolean$Parameter(
        type = LogicBoolean$ReturnType.unit,
        positional = 0,
        required = true
    )
    public LogicBoolean unit1;
    @LogicBoolean$Parameter(
        type = LogicBoolean$ReturnType.unit,
        positional = 1,
        required = true
    )
    public LogicBoolean unit2;

    public String getName() {
        return "DistanceBetween";
    }

    public float readNumber(OrderableUnit var1) {
        Unit var2 = this.unit1.readUnit(var1);
        if (var2 == null) {
            return 0.0F;
        } else {
            float var3 = var2.xCord;
            float var4 = var2.yCord;
            var2 = this.unit2.readUnit(var1);
            if (var2 == null) {
                return 0.0F;
            } else {
                float var5 = var2.xCord;
                float var6 = var2.yCord;
                return class_340.b(var3, var4, var5, var6);
            }
        }
    }
}
