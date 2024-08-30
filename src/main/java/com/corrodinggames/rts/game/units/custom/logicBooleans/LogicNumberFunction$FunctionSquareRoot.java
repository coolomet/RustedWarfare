package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.gameFramework.class_340;

public strictfp class LogicNumberFunction$FunctionSquareRoot extends LogicNumberFunction$LogicNumberFunctionRawArgs {
    public String getName() {
        return "SquareRoot";
    }

    public float readNumber(OrderableUnit var1) {
        float var2 = this.value.readNumber(var1);
        var2 = this.doFunction(var2);
        return var2;
    }

    public float doFunction(float var1) {
        return class_340.a(var1);
    }
}
