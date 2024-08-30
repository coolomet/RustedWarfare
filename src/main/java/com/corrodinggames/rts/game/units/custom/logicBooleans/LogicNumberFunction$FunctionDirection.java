package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.gameFramework.class_340;

public strictfp class LogicNumberFunction$FunctionDirection extends LogicNumberFunction {
    @LogicBoolean$Parameter(
        type = LogicBoolean$ReturnType.number,
        positional = 0,
        required = true
    )
    public LogicBoolean x1;
    @LogicBoolean$Parameter(
        type = LogicBoolean$ReturnType.number,
        positional = 1,
        required = true
    )
    public LogicBoolean y1;
    @LogicBoolean$Parameter(
        type = LogicBoolean$ReturnType.number,
        positional = 2,
        required = true
    )
    public LogicBoolean x2;
    @LogicBoolean$Parameter(
        type = LogicBoolean$ReturnType.number,
        positional = 3,
        required = true
    )
    public LogicBoolean y2;

    public String getName() {
        return "Direction";
    }

    public float readNumber(OrderableUnit var1) {
        float var2 = this.x1.readNumber(var1);
        float var3 = this.y1.readNumber(var1);
        float var4 = this.x2.readNumber(var1);
        float var5 = this.y2.readNumber(var1);
        return class_340.d(var2, var3, var4, var5);
    }
}
