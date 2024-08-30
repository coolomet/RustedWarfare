package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.gameFramework.GameEngine;

public abstract strictfp class VariableScope$AbstractMemoryLogicBoolean extends LogicBoolean {
    public LogicBooleanLoader$LogicBooleanContext createContext() {
        LogicBoolean$ReturnType var1 = this.getReturnType();
        if (var1 == LogicBoolean$ReturnType.unit) {
            return UnitReference.unitContextChangingContext;
        } else if (LogicBoolean$ReturnType.isArrayType(var1)) {
            if (var1 == LogicBoolean$ReturnType.numberArray) {
                return LogicBooleanLoader.numberArrayContextReader;
            } else if (var1 == LogicBoolean$ReturnType.boolArray) {
                return LogicBooleanLoader.boolArrayContextReader;
            } else if (var1 == LogicBoolean$ReturnType.unitArray) {
                return LogicBooleanLoader.unitArrayContextReader;
            } else {
                GameEngine.print("Unhandled array context type: " + var1);
                return LogicBooleanLoader.voidContextReader;
            }
        } else {
            return super.createContext();
        }
    }

    public LogicBoolean setChild(LogicBoolean var1) {
        LogicBoolean$ReturnType var2 = this.getReturnType();
        if (LogicBoolean$ReturnType.isArrayType(var2)) {
            return var1;
        } else {
            UnitReference$UnitContextChangingBooleanByLogic var3 = UnitReference$UnitContextChangingBooleanByLogic.create(this, var1);
            return var3;
        }
    }
}
