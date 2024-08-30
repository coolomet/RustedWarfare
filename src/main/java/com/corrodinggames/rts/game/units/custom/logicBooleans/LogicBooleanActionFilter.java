package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.a.class_661;
import com.corrodinggames.rts.game.units.custom.class_113;

public strictfp class LogicBooleanActionFilter extends class_661 {
    LogicBoolean logicBoolean;
    class_113 target;

    public LogicBooleanActionFilter(LogicBoolean var1, class_113 var2) {
        this.logicBoolean = var1;
    }

    public boolean isAvailable(class_226 var1, Unit var2) {
        return this.logicBoolean.read(this.target);
    }
}
