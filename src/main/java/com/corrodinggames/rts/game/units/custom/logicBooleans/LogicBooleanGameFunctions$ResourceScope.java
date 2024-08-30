package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.custom.e.BuiltInResource;

public strictfp class LogicBooleanGameFunctions$ResourceScope extends LogicBooleanLoader$LogicBooleanScopeOnly {
    public LogicBoolean parseNextElementInChain(String var1, class_591 var2, String var3, boolean var4, String var5, String var6, LogicBoolean var7) {
        BuiltInResource var9 = var2.j(var3);
        if (var9 == null) {
            throw new BooleanParseException("'" + var5 + "': Could not find resource: '" + var3 + "'");
        } else {
            LogicBooleanGameFunctions$ResourceCountBoolean var10 = new LogicBooleanGameFunctions$ResourceCountBoolean();
            var10.meta = var2;
            var10.type = var9;
            return var10;
        }
    }
}
