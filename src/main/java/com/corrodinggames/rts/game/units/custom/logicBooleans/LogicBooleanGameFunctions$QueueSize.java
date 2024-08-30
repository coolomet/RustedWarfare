package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.class_585;

public final strictfp class LogicBooleanGameFunctions$QueueSize extends LogicBoolean$AbstractNumberBoolean {
    public class_585 _withActionTag;

    @LogicBoolean$Parameter
    public void withActionTag(String var1) {
        this._withActionTag = class_585.c(var1);
    }

    public String getName() {
        return "QueueSize";
    }

    public float getValue(OrderableUnit var1) {
        return (float)var1.a((class_585)this._withActionTag);
    }

    public float getMaxValue(OrderableUnit var1) {
        return 2.1474836E9F;
    }
}
