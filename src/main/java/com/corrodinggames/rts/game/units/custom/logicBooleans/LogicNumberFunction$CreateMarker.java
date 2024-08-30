package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;

public strictfp class LogicNumberFunction$CreateMarker extends UnitReference {
    @LogicBoolean$Parameter(
        type = LogicBoolean$ReturnType.number,
        positional = 0,
        required = true
    )
    public LogicBoolean x;
    @LogicBoolean$Parameter(
        type = LogicBoolean$ReturnType.number,
        positional = 1,
        required = true
    )
    public LogicBoolean y;
    @LogicBoolean$Parameter(
        type = LogicBoolean$ReturnType.number,
        positional = 2,
        required = false
    )
    public LogicBoolean height;
    @LogicBoolean$Parameter(
        type = LogicBoolean$ReturnType.number
    )
    public LogicBoolean teamId;
    @LogicBoolean$Parameter(
        type = LogicBoolean$ReturnType.number
    )
    public LogicBoolean dir;

    public void validate(String var1, String var2, String var3, LogicBooleanLoader$LogicBooleanContext var4, boolean var5) {
        super.validate(var1, var2, var3, var4, var5);
        if (this.height == null) {
            this.height = LogicBoolean$StaticValueBoolean.static_0;
        }

        if (this.dir == null) {
            this.dir = LogicBoolean$StaticValueBoolean.static_0;
        }

        if (this.teamId == null) {
            this.teamId = LogicBoolean$StaticValueBoolean.static_neg1;
        }

    }

    public Unit getSingleRaw(OrderableUnit var1) {
        float var2 = this.x.readNumber(var1);
        float var3 = this.y.readNumber(var1);
        float var4 = this.height.readNumber(var1);
        float var5 = this.dir.readNumber(var1);
        PlayerData var6 = PlayerData.getPlayerData((int)this.teamId.readNumber(var1));
        if (var6 == null) {
            var6 = PlayerData.i;
        }

        OrderableUnit var7 = var6.t;
        var7.cg = var5;
        var7.xCord = var2;
        var7.yCord = var3;
        var7.zCord = var4;
        return var7;
    }

    public String getClassDebugName() {
        return "createMarker";
    }
}
