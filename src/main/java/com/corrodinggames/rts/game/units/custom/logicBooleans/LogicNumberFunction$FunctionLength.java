package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;

public strictfp class LogicNumberFunction$FunctionLength extends LogicNumberFunction {
    @LogicBoolean$Parameter(
        type = LogicBoolean$ReturnType.string,
        positional = 0,
        required = true
    )
    public LogicBoolean a;

    public String getName() {
        return "Length";
    }

    public float readNumber(OrderableUnit var1) {
        String var2 = this.a.readString(var1);
        return var2 == null ? 0.0F : (float)var2.length();
    }
}
