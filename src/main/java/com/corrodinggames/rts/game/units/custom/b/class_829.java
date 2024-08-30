package com.corrodinggames.rts.game.units.custom.b;

import com.corrodinggames.rts.game.units.custom.class_113;
import com.corrodinggames.rts.game.units.buildings.RepairBay;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.b.b
public strictfp class class_829 extends class_827 {
    public static final class_827 a = new class_829();

    public strictfp void b(class_113 var1, float var2) {
        var1.u += var2;
        if (var1.u > 40.0F && var1.aq()) {
            var1.u = 0.0F;
            RepairBay.a(var1, var2, 0.0F, false);
        }

    }
}
