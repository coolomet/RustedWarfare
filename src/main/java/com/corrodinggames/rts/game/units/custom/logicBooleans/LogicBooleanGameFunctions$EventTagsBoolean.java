package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.class_585;
import com.corrodinggames.rts.game.units.custom.class_588;

public strictfp class LogicBooleanGameFunctions$EventTagsBoolean extends LogicBoolean {
    public class_585 includesTag;

    @LogicBoolean$Parameter
    public void includes(String var1) {
        this.includesTag = class_585.c(var1);
    }

    public String getMatchFailReasonForPlayer(OrderableUnit var1) {
        String var2 = "EventTag";
        if (this.includesTag != null) {
            var2 = var2 + " includes " + this.includesTag;
        }

        return var2;
    }

    public boolean read(OrderableUnit var1) {
        boolean var2 = true;
        if (this.includesTag != null) {
            class_588 var3 = null;
            if (LogicBoolean.activeEvent != null) {
                var3 = LogicBoolean.activeEvent.d;
            }

            if (var3 == null || !class_585.a(this.includesTag, var3)) {
                var2 = false;
            }
        }

        return var2;
    }
}
