package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;

public strictfp class LogicBooleanGameFunctions$HeightBoolean extends LogicBoolean {
    @LogicBoolean$Parameter
    public boolean underwater;
    @LogicBoolean$Parameter
    public boolean ground;
    @LogicBoolean$Parameter
    public boolean flying;

    public String getMatchFailReasonForPlayer(OrderableUnit var1) {
        String var2 = "";
        if (this.underwater) {
            var2 = var2 + "underwater";
        }

        if (this.ground) {
            var2 = var2 + "ground";
        }

        if (this.flying) {
            var2 = var2 + "flying";
        }

        if (var2.equals("")) {
            var2 = var2 + "height";
        }

        return var2;
    }

    public boolean read(OrderableUnit var1) {
        boolean var2 = false;
        if (this.underwater && var1.zCord < -2.0F) {
            var2 = true;
        }

        if (this.ground && var1.zCord > -2.0F && var1.zCord < 5.0F) {
            var2 = true;
        }

        if (this.flying && var1.zCord > 5.0F) {
            var2 = true;
        }

        return var2;
    }
}
