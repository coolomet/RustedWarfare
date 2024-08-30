package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope$CachedWriter$Operator;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope$CachedWriter$WriterElement;
import com.corrodinggames.rts.gameFramework.GameEngine;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.av
public strictfp class class_59 extends VariableScope$CachedWriter$WriterElement {
    public class_399 a;
    public LogicBoolean b;
    public VariableScope$CachedWriter$Operator c;

    public void writeToUnit(OrderableUnit var1) {
        if (!(var1 instanceof class_113)) {
            GameEngine.n("Cannot change data on non custom unit:" + Unit.A(var1));
        } else {
            class_113 var2 = (class_113)var1;
            this.a.a(var2, this.b, this.c);
        }
    }
}
