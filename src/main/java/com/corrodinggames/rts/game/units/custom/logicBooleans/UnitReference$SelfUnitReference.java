package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;

public strictfp class UnitReference$SelfUnitReference extends UnitReference {
    public Unit getSingleRaw(OrderableUnit var1) {
        return var1;
    }

    public String getClassDebugName() {
        return "self";
    }
}
