package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;

public strictfp class UnitReference$LockedUnitReference extends UnitReference {
    Unit target;

    public UnitReference$LockedUnitReference(Unit var1) {
        this.target = var1;
    }

    public Unit getSingleRaw(OrderableUnit var1) {
        return this.target;
    }

    public String getClassDebugName() {
        return "unit";
    }
}
