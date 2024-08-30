package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.MovementType;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.utility.class_694;

public strictfp class LogicBooleanGameFunctions$OverPassableTileBoolean extends LogicBoolean$LogicBooleanCommonLocking {
    MovementType movementType;

    public LogicBooleanGameFunctions$OverPassableTileBoolean() {
        this.movementType = MovementType.LAND;
    }

    @LogicBoolean$Parameter
    public void type(String var1) {
        this.movementType = MovementType.a(var1, "isOverPassableTile()");
    }

    public boolean read(OrderableUnit var1) {
        boolean var2 = false;
        GameEngine var3 = GameEngine.getGameEngine();
        if (!class_694.a(var1.xCord, var1.yCord, this.movementType)) {
            var2 = true;
        }

        return var2;
    }

    public String getMatchFailReasonForPlayer(OrderableUnit var1) {
        return "OverLand";
    }
}
