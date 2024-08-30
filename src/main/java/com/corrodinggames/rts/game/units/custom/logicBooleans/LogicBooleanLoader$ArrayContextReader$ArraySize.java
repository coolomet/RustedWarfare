package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;

public strictfp class LogicBooleanLoader$ArrayContextReader$ArraySize extends LogicBooleanLoader$ArrayContextReader$ArrayFunction {
    LogicBoolean targetArray;

    public void setArrayTarget(LogicBoolean var1) {
        this.targetArray = var1;
    }

    public LogicBoolean$ReturnType getReturnType() {
        return LogicBoolean$ReturnType.number;
    }

    public boolean read(OrderableUnit var1) {
        return false;
    }

    public float readNumber(OrderableUnit var1) {
        int var2 = this.targetArray.getArraySize(var1);
        return (float)var2;
    }

    public String getName() {
        return "size";
    }

    public String getMatchFailReasonForPlayer(OrderableUnit var1) {
        String var2 = "";
        if (this.targetArray != null) {
            var2 = var2 + this.targetArray.getMatchFailReasonForPlayer(var1);
        }

        var2 = var2 + this.getName() + "(=" + this.readNumber(var1) + ")";
        return var2;
    }
}
