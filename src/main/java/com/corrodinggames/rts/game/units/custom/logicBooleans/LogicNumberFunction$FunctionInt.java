package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;

public strictfp class LogicNumberFunction$FunctionInt extends LogicNumberFunction$LogicNumberFunctionRawArgs {
    public String getName() {
        return "Int";
    }

    public float readNumber(OrderableUnit var1) {
        float var2 = this.value.readNumber(var1);
        var2 = this.doFunction(var2);
        return var2;
    }

    public float doFunction(float var1) {
        return (float)((int)var1);
    }
}
