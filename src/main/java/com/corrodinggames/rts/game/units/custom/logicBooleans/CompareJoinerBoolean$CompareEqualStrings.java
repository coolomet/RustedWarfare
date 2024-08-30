package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;

public final strictfp class CompareJoinerBoolean$CompareEqualStrings extends CompareJoinerBoolean {
    public String type() {
        return "==";
    }

    public boolean read(OrderableUnit var1) {
        LogicBoolean[] var2 = this.children;
        String var3 = var2[0].readString(var1);
        if (var3 == null) {
            var3 = "";
        }

        for(int var4 = 1; var4 < var2.length; ++var4) {
            String var5 = var2[var4].readString(var1);
            if (var5 == null) {
                var5 = "";
            }

            if (!var3.equals(var5)) {
                return false;
            }

            var3 = var5;
        }

        return true;
    }
}
