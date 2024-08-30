package com.corrodinggames.rts.game.units.custom.b;

import com.corrodinggames.rts.game.units.custom.class_113;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.utility.UnitConfig;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.b.l
public strictfp class class_831 extends class_827 {
    LogicBoolean a;
    float b;
    float c;
    int d;

    public static strictfp void a(class_591 var0, UnitConfig var1) {
        String var2 = "movement_random";
        if (var1.g(var2)) {
            class_831 var3 = new class_831();
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
        this.d = var2.getValueAsIntegerOrDefault(var3, "awayFromEdge", 75);
    }

    public strictfp void b(class_113 var1, float var2) {
        if (this.a.read(var1)) {
            GameEngine var3 = GameEngine.getGameEngine();
            if (var1.bi()) {
                if (class_340.c(var1.cc) < this.c) {
                    var1.cc += class_340.b(var1, -this.b, this.b, 1);
                }

                if (class_340.c(var1.cd) < this.c) {
                    var1.cd += class_340.b(var1, -this.b, this.b, 2);
                }
            } else {
                if (class_340.c(var1.cf) < this.c) {
                    var1.cf += class_340.b(var1, -this.b, this.b, 1);
                }

                var1.cg += class_340.b(var1, -1.0F, 1.0F, 2);
            }

            if (this.d > 0) {
                if (var1.yCord > var3.bL.j() - (float)this.d) {
                    var1.cd -= class_340.b(var1, 0.0F, this.b * 0.25F, 10);
                }

                if (var1.yCord < (float)this.d) {
                    var1.cd += class_340.b(var1, 0.0F, this.b * 0.25F, 11);
                }

                if (var1.xCord > var3.bL.i() - (float)this.d) {
                    var1.cc -= class_340.b(var1, 0.0F, this.b * 0.25F, 12);
                }

                if (var1.xCord < (float)this.d) {
                    var1.cc += class_340.b(var1, 0.0F, this.b * 0.25F, 13);
                }
            }

            var1.ay = true;
        }
    }
}
