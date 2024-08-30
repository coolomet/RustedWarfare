package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.gameFramework.class_340;

public strictfp class UnitReference$GetOffsetRelativeStatic extends UnitReference$PlaceholderUnitReference {
    @LogicBoolean$Parameter(
        positional = 0
    )
    public float x;
    @LogicBoolean$Parameter(
        positional = 1
    )
    public float y;
    @LogicBoolean$Parameter
    public float height;
    @LogicBoolean$Parameter
    public float dirOffset;

    public String getClassDebugName() {
        return "getOffsetRelativeStatic";
    }

    public strictfp Unit getSingleRaw(OrderableUnit var1) {
        OrderableUnit var2 = var1.bX.t;
        float var3 = var1.cg + this.dirOffset;
        float var4 = class_340.k(var3);
        float var5 = class_340.j(var3);
        float var6 = this.x;
        float var7 = this.y;
        float var8 = var4 * var7 - var5 * var6;
        float var9 = var5 * var7 + var4 * var6;
        var2.cg = var3;
        var2.xCord = var1.xCord + var8;
        var2.yCord = var1.yCord + var9;
        var2.zCord = var1.zCord + this.height;
        return var2;
    }
}
