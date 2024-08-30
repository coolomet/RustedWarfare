package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.ap
public strictfp class class_426 extends class_423 {
    class_426(LogicBoolean var1) {
        super(var1);
    }

    String a(OrderableUnit var1) {
        Unit var2 = this.a.readUnit(var1);
        return Unit.f(var2, false);
    }
}
