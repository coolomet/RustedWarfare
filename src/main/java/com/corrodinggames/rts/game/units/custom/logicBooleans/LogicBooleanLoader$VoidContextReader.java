package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.custom.class_591;

public final strictfp class LogicBooleanLoader$VoidContextReader extends LogicBooleanLoader$LogicBooleanContextWithDefault {
    String debugType;

    LogicBooleanLoader$VoidContextReader(String var1) {
        this.debugType = var1;
    }

    public LogicBoolean parseNextElementInChain(String var1, class_591 var2, String var3, boolean var4, String var5, String var6, LogicBoolean var7) {
        if (var6 != null) {
            if (this.debugType != null) {
                throw new RuntimeException("No field:'" + var3 + "' in '" + var6 + "' (" + this.debugType + ")");
            } else {
                throw new RuntimeException("No field:'" + var3 + "' in '" + var6 + "'");
            }
        } else {
            throw new RuntimeException("No field:'" + var3 + "'");
        }
    }
}
