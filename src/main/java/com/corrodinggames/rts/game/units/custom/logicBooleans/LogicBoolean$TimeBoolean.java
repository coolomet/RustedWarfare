package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;

public abstract strictfp class LogicBoolean$TimeBoolean extends LogicBoolean {
    @LogicBoolean$Parameter
    public float laterThanSeconds = -1.0F;
    @LogicBoolean$Parameter
    public float withinSeconds = -1.0F;

    public abstract String getName();

    public abstract int getTime(OrderableUnit var1);

    public LogicBoolean$ReturnType getReturnType() {
        return this.laterThanSeconds == -1.0F && this.withinSeconds == -1.0F ? LogicBoolean$ReturnType.number : LogicBoolean$ReturnType.bool;
    }

    public void validate(String var1, String var2, String var3, LogicBooleanLoader$LogicBooleanContext var4, boolean var5) {
        super.validate(var1, var2, var3, var4, var5);
        if (var5 && this.laterThanSeconds == -1.0F && this.withinSeconds == -1.0F) {
            throw new BooleanParseException("Expended laterThanSeconds, or withinSeconds argument for function:" + var1 + " to return a boolean");
        }
    }

    public String getMatchFailReasonForPlayer(OrderableUnit var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        String var3 = this.getName() + "=" + this.msToSecondsString((float)(var2.by - this.getTime(var1)));
        if (this.laterThanSeconds != -1.0F) {
            var3 = var3 + ">" + this.msToSecondsString(this.laterThanSeconds * 1000.0F);
        }

        if (this.withinSeconds != -1.0F) {
            var3 = var3 + "<" + this.msToSecondsString(this.withinSeconds * 1000.0F);
        }

        return var3;
    }

    private String msToSecondsString(float var1) {
        return class_340.g(var1 / 1000.0F) + "s";
    }

    public float readNumber(OrderableUnit var1) {
        int var2 = this.getTime(var1);
        GameEngine var3 = GameEngine.getGameEngine();
        return (float)(var3.by - var2) * 0.001F;
    }

    public boolean read(OrderableUnit var1) {
        int var2 = this.getTime(var1);
        boolean var3 = true;
        GameEngine var4 = GameEngine.getGameEngine();
        if (this.withinSeconds > 0.0F && (float)var4.by - this.withinSeconds * 1000.0F > (float)var2) {
            var3 = false;
        }

        if (this.laterThanSeconds > 0.0F && (float)var4.by - this.laterThanSeconds * 1000.0F < (float)var2) {
            var3 = false;
        }

        return var3;
    }
}
