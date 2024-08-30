package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;

public strictfp class UnitReference$Memory1UnitReference extends UnitReference {
    public Unit getSingleRaw(OrderableUnit var1) {
        Unit var2 = var1.bu;
        return var2 != null && !var2.bV ? var2 : null;
    }

    public String getClassDebugName() {
        return "customTarget1";
    }
}
