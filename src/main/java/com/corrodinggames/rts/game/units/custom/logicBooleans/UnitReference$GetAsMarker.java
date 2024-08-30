package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;

public strictfp class UnitReference$GetAsMarker extends UnitReference$PlaceholderUnitReference {
    public String getClassDebugName() {
        return "getAsMarker";
    }

    public Unit getSingleRaw(OrderableUnit var1) {
        OrderableUnit var2 = var1.bX.t;
        var2.cg = var1.cg;
        var2.xCord = var1.xCord;
        var2.yCord = var1.yCord;
        var2.zCord = var1.zCord;
        return var2;
    }
}
