package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;

public final strictfp class CompareJoinerBoolean$MathDivideJoinerBoolean extends CompareJoinerBoolean$MathJoinerBoolean {
    public String type() {
        return "/";
    }

    public float readNumber(OrderableUnit var1) {
        float var2 = this.children[0].readNumber(var1);

        for(int var3 = 1; var3 < this.children.length; ++var3) {
            var2 /= this.children[var3].readNumber(var1);
        }

        return var2;
    }
}
