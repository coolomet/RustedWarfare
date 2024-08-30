package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.class_585;
import com.corrodinggames.rts.game.units.custom.class_588;
import com.corrodinggames.rts.gameFramework.utility.class_684;

public strictfp class LogicBooleanGameFunctions$TransportingUnitWithTagsBoolean extends LogicBoolean {
    public class_585 includesTag;

    @LogicBoolean$Parameter
    public void includes(String var1) {
        this.includesTag = class_585.c(var1);
    }

    public String getMatchFailReasonForPlayer(OrderableUnit var1) {
        String var2 = "TransportingUnitWithTags ";
        if (this.includesTag != null) {
            var2 = var2 + " includes " + this.includesTag;
        }

        return var2;
    }

    public boolean read(OrderableUnit var1) {
        boolean var2 = false;
        if (this.includesTag != null) {
            class_684 var3 = var1.bz();
            if (var3 != null) {
                Object[] var4 = var3.a();

                for(int var5 = 0; var5 < var3.a; ++var5) {
                    Unit var6 = (Unit)var4[var5];
                    class_588 var7 = var6.de();
                    if (var7 != null && class_585.a(this.includesTag, var7)) {
                        var2 = true;
                    }
                }
            }
        }

        return var2;
    }
}
