package com.corrodinggames.rts.game.units.custom.d;

import com.corrodinggames.rts.game.units.custom.e.BuiltInResource;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$StaticValueBoolean;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.d.d
class class_445 {
    public final BuiltInResource a;
    public double b;
    public LogicBoolean c;

    public class_445(BuiltInResource var1, LogicBoolean var2) {
        this.a = var1;
        if (this.c instanceof LogicBoolean$StaticValueBoolean) {
            this.b = (double)((LogicBoolean$StaticValueBoolean)this.c).getStaticValue();
        } else {
            this.c = var2;
        }

    }
}
