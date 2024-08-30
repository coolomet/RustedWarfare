package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.net.GameNetEngine;

public strictfp class LogicString$DebugPassthrough extends LogicString$WrappingLogicString {
    public void addMessage(OrderableUnit var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        if (var2.bv && var2.bl) {
            String var3 = "";
            if (var1 != null) {
                var3 = var1.r().i() + "(" + var1.id + ") ";
            }

            String var4 = var3 + "DebugPassthrough: " + this.children[0].getMatchFailReasonForPlayer(var1);
            GameNetEngine.a((String)null, (String)var4);
        }

    }

    public LogicBoolean$ReturnType getReturnType() {
        return this.children[0].getReturnType();
    }

    public boolean read(OrderableUnit var1) {
        this.addMessage(var1);
        return this.children[0].read(var1);
    }

    public float readNumber(OrderableUnit var1) {
        this.addMessage(var1);
        return this.children[0].readNumber(var1);
    }

    public String readString(OrderableUnit var1) {
        this.addMessage(var1);
        return this.children[0].readString(var1);
    }

    public Unit readUnit(OrderableUnit var1) {
        this.addMessage(var1);
        return this.children[0].readUnit(var1);
    }
}
