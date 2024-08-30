package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;

public final strictfp class LogicBoolean$AndBoolean extends LogicBoolean$JoinerBoolean {
    public String type() {
        return "and";
    }

    public boolean read(OrderableUnit var1) {
        LogicBoolean[] var2 = this.children;
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            LogicBoolean var5 = var2[var4];
            if (!var5.read(var1)) {
                return false;
            }
        }

        return true;
    }
}
