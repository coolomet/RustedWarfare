package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;

public strictfp class UnitReference$ChainedUnitReference extends UnitReference {
    UnitReference[] chain;

    UnitReference$ChainedUnitReference(UnitReference[] var1) {
        this.chain = var1;
    }

    public Unit getSingleRaw(OrderableUnit var1) {
        UnitReference[] var2 = this.chain;
        Object var3 = var1;
        LogicBoolean.outerUnitParameterContext = var1;

        for(int var4 = 0; var4 < var2.length; ++var4) {
            var3 = var2[var4].get((Unit)var3);
            if (var3 == null) {
                return null;
            }
        }

        LogicBoolean.outerUnitParameterContext = null;
        return (Unit)var3;
    }

    public String getMatchFailReasonForPlayer(OrderableUnit var1) {
        UnitReference[] var2 = this.chain;
        Object var3 = var1;
        String var4 = "";
        if (var1 instanceof OrderableUnit) {
            LogicBoolean.outerUnitParameterContext = (OrderableUnit)var1;
        }

        var4 = var4 + "[";

        for(int var5 = 0; var5 < var2.length; ++var5) {
            var4 = var4 + var2[var5].getMatchFailReasonForPlayer(var1);
            if (var5 != var2.length - 1) {
                var4 = var4 + ",";
            }

            var3 = var2[var5].get((Unit)var3);
            if (var3 == null) {
                var4 = var4 + "<null>";
                break;
            }
        }

        LogicBoolean.outerUnitParameterContext = null;
        var4 = var4 + "]";
        return var4;
    }
}
