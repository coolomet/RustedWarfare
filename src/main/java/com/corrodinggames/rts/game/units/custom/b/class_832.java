package com.corrodinggames.rts.game.units.custom.b;

import com.corrodinggames.rts.game.units.custom.class_113;
import com.corrodinggames.rts.game.units.custom.class_585;
import com.corrodinggames.rts.game.units.custom.class_588;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.gameFramework.utility.UnitConfig;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.b.j
public strictfp class class_832 extends class_827 {
    LogicBoolean a;
    float b;
    float c;
    class_588 d;
    boolean e;

    public static strictfp void a(class_591 var0, UnitConfig var1) {
        String var2 = "movement_repelFromUnits";
        if (var1.g(var2)) {
            class_832 var3 = new class_832();
            var3.a(var0, var1, var2, var2);
            if (!LogicBoolean.isStaticFalse(var3.a)) {
                var0.a((class_827)var3);
            }
        }

    }

    public strictfp void a(class_591 var1, UnitConfig var2, String var3, String var4) {
        this.a = var2.a(var1, var3, "enabled");
        this.b = var2.i(var3, "speed");
        this.c = var2.getValueAsFloatOrDefault(var3, "maxSpeed", 5.0F);
        this.d = class_585.a((String)var2.getValueAsStaticString(var3, "otherUnitHasTag", (String)null), (class_588)null);
        this.e = var2.getValueAsBoolean(var3, "onlySameTeam", false);
    }

    public strictfp void b(class_113 var1, float var2) {
        if (this.a.read(var1)) {
            ;
        }
    }
}
