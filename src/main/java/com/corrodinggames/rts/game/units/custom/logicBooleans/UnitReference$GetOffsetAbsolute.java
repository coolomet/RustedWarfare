package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;

public strictfp class UnitReference$GetOffsetAbsolute extends UnitReference$PlaceholderUnitReference {
    @LogicBoolean$Parameter(
        type = LogicBoolean$ReturnType.number,
        positional = 0
    )
    public LogicBoolean x;
    @LogicBoolean$Parameter(
        type = LogicBoolean$ReturnType.number,
        positional = 1
    )
    public LogicBoolean y;
    @LogicBoolean$Parameter(
        type = LogicBoolean$ReturnType.number
    )
    public LogicBoolean height;

    public UnitReference$GetOffsetAbsolute() {
        this.x = LogicBoolean$StaticValueBoolean.static_0;
        this.y = LogicBoolean$StaticValueBoolean.static_0;
        this.height = LogicBoolean$StaticValueBoolean.static_0;
    }

    public String getClassDebugName() {
        return "getOffsetAbsolute";
    }

    public strictfp Unit getSingleRaw(OrderableUnit var1) {
        OrderableUnit var2 = var1.bX.t;
        OrderableUnit var3 = getParameterContext(var1);
        var2.cg = var1.cg;
        var2.xCord = var1.xCord + this.x.readNumber(var3);
        var2.yCord = var1.yCord + this.y.readNumber(var3);
        var2.zCord = var1.zCord + this.height.readNumber(var3);
        return var2;
    }
}
