package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.gameFramework.GameEngine;

public strictfp class LogicBooleanGameFunctions$GameModeBoolean extends LogicBoolean$LogicBooleanCommonLocking {
    @LogicBoolean$Parameter
    public boolean nukesEnabled;

    public boolean read(OrderableUnit var1) {
        boolean var2 = true;
        GameEngine var3 = GameEngine.getGameEngine();
        if (this.nukesEnabled && var3.O() && var3.netEngine.gameMapData.nukes) {
            var2 = false;
        }

        return var2;
    }

    public String getMatchFailReasonForPlayer(OrderableUnit var1) {
        return "GameMode(" + (this.nukesEnabled ? "Nukes enabled" : "Nukes disabled") + ")";
    }
}
