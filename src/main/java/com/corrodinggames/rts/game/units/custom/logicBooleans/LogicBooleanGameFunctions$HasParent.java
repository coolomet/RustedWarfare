package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.class_585;
import com.corrodinggames.rts.game.units.custom.class_588;

public final strictfp class LogicBooleanGameFunctions$HasParent extends LogicBoolean {
    public class_585 _withTag;

    @LogicBoolean$Parameter
    public void withTag(String var1) {
        this._withTag = class_585.c(var1);
    }

    public boolean read(OrderableUnit var1) {
        boolean var2 = false;
        Unit var3 = var1.dr();
        if (var3 != null) {
            var2 = true;
            if (this._withTag != null) {
                class_588 var4 = var3.de();
                if (!class_585.a(this._withTag, var4)) {
                    var2 = false;
                }
            }
        }

        return var2;
    }

    public String getMatchFailReasonForPlayer(OrderableUnit var1) {
        return "HasParent";
    }
}
