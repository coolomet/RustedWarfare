package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.gameFramework.GameEngine;

public strictfp class LogicBooleanGameFunctions$IsGameFrameBoolean extends LogicBoolean {
    @LogicBoolean$Parameter
    public int mod;
    @LogicBoolean$Parameter
    public int equalTo;
    @LogicBoolean$Parameter
    public boolean offset;

    @LogicBoolean$Parameter
    public void mod(int var1) {
        this.mod = var1;
    }

    public boolean read(OrderableUnit var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        boolean var3;
        if (this.mod >= 0) {
            if (this.offset) {
                var3 = ((long)var2.tick + var1.id) % (long)this.mod == (long)this.equalTo;
            } else {
                var3 = var2.tick % this.mod == this.equalTo;
            }
        } else if (this.offset) {
            var3 = (long)var2.tick + var1.id == (long)this.equalTo;
        } else {
            var3 = var2.tick == this.equalTo;
        }

        return var3;
    }

    public String getMatchFailReasonForPlayer(OrderableUnit var1) {
        return "IsGameFrame(mod=" + this.mod + ")";
    }
}
