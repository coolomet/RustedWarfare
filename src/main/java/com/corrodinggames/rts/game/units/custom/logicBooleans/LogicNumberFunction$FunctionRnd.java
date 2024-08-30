package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.utility.class_649;

public strictfp class LogicNumberFunction$FunctionRnd extends LogicNumberFunction {
    @LogicBoolean$Parameter(
        type = LogicBoolean$ReturnType.number,
        positional = 0,
        required = true
    )
    public LogicBoolean min;
    @LogicBoolean$Parameter(
        type = LogicBoolean$ReturnType.number,
        positional = 1,
        required = true
    )
    public LogicBoolean max;
    int randomIndex;

    public void forMeta(class_591 var1) {
        if (var1 == null) {
            throw new class_649("FunctionRnd requires metadata");
        } else {
            ++var1.S;
            this.randomIndex = var1.S;
        }
    }

    public String getName() {
        return "Rnd";
    }

    public float readNumber(OrderableUnit var1) {
        float var2 = this.min.readNumber(var1);
        float var3 = this.max.readNumber(var1);
        int var4 = 0;
        if (var1 != null) {
            var4 = var1.bC;
        }

        return class_340.b(var2, var3, this.randomIndex + var4);
    }
}
