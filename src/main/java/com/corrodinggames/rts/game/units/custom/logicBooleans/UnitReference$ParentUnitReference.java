package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;

public strictfp class UnitReference$ParentUnitReference extends UnitReference {
    public Unit getSingleRaw(OrderableUnit var1) {
        return var1.dr();
    }

    public String getMatchFailReasonForPlayer(OrderableUnit var1) {
        return "parent";
    }
}
