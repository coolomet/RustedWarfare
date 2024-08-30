package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.class_1042;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;

public strictfp class UnitReference$ActiveWaypointTargetReference extends UnitReference {
    public Unit getSingleRaw(OrderableUnit var1) {
        class_1042 var2 = var1.ar();
        if (var2 == null) {
            return null;
        } else {
            Unit var3 = var2.l();
            return var3;
        }
    }

    public String getClassDebugName() {
        return "ActiveWaypointTarget";
    }
}
