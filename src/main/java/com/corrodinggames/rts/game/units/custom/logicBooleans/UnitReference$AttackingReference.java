package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;

public strictfp class UnitReference$AttackingReference extends UnitReference {
    public Unit getSingleRaw(OrderableUnit var1) {
        Unit var2 = var1.R;
        return var2;
    }

    public String getClassDebugName() {
        return "Attacking";
    }
}
