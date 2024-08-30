package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.class_589;

public strictfp class UnitReference$EventSourceReference extends UnitReference {
    public Unit getSingleRaw(OrderableUnit var1) {
        class_589 var2 = LogicBoolean.activeEvent;
        return var2 == null ? null : var2.c;
    }

    public String getClassDebugName() {
        return "EventSource";
    }
}
