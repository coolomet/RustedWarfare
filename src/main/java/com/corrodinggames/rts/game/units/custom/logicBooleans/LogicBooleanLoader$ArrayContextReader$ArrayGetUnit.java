package com.corrodinggames.rts.game.units.custom.logicBooleans;

public strictfp class LogicBooleanLoader$ArrayContextReader$ArrayGetUnit extends LogicBooleanLoader$ArrayContextReader$ArrayGet {
    public LogicBooleanLoader$LogicBooleanContext createContext() {
        return UnitReference.unitContextChangingContext;
    }

    public LogicBoolean setChild(LogicBoolean var1) {
        UnitReference$UnitContextChangingBooleanByLogic var2 = UnitReference$UnitContextChangingBooleanByLogic.create(this, var1);
        return var2;
    }

    public LogicBoolean$ReturnType getReturnType() {
        return LogicBoolean$ReturnType.unit;
    }
}
