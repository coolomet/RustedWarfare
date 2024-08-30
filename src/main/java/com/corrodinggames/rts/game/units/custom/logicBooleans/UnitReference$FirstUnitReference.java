package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.Side;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.CustomException;
import com.corrodinggames.rts.game.units.custom.class_585;
import com.corrodinggames.rts.game.units.custom.class_588;
import com.corrodinggames.rts.gameFramework.utility.UnitConfig;
import com.corrodinggames.rts.gameFramework.utility.class_649;

public strictfp class UnitReference$FirstUnitReference extends UnitReference {
    public class_585 _withTag;
    public Side relation;
    @LogicBoolean$Parameter
    public boolean incompleteBuildings;

    public UnitReference$FirstUnitReference() {
        this.relation = Side.ANY;
    }

    public String getClassDebugName() {
        return "globalSearchForFirstUnit";
    }

    @LogicBoolean$Parameter
    public void withTag(String var1) {
        this._withTag = class_585.c(var1);
    }

    @LogicBoolean$Parameter
    public void relation(String var1) {
        try {
            this.relation = (Side)UnitConfig.convertStringToEnumOrDefault(var1, (Enum)null, Side.class);
        } catch (Exception var3) {
            throw new class_649(var3.getMessage(), var3);
        }
    }

    public Unit getSingleRaw(OrderableUnit var1) {
        Unit[] var2 = Unit.bE.a();
        int var3 = 0;

        for(int var4 = Unit.bE.size(); var3 < var4; ++var3) {
            Unit var5 = var2[var3];
            if ((this.relation == Side.ANY || var1.bX.a(this.relation, var5.bX)) && var1 != var5) {
                class_588 var6 = var5.de();
                if ((this._withTag == null || var6 != null && class_585.a(this._withTag, var6)) && (!(var5.cm < 1.0F) || this.incompleteBuildings)) {
                    return var5;
                }
            }
        }

        return null;
    }
}
