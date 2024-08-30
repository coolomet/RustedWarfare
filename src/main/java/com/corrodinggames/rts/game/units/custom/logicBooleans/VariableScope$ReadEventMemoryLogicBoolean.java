package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.class_589;

public strictfp class VariableScope$ReadEventMemoryLogicBoolean extends VariableScope$ReadUnitMemoryLogicBoolean {
    public LogicBoolean getUnitMemory(OrderableUnit var1) {
        class_589 var2 = LogicBoolean.activeEvent;
        VariableScope var3 = null;
        if (var2 != null) {
            var3 = var2.e;
        }

        if (var3 == null) {
            return this.defaultValue;
        } else {
            LogicBoolean var4 = var3.getAsLogicBoolean(this._name);
            return var4 == null ? this.defaultValue : var4;
        }
    }
}
