package com.corrodinggames.rts.game.units.custom.a.a;

import android.graphics.PointF;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.custom.class_113;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.custom.a.class_1037;
import com.corrodinggames.rts.game.units.custom.a.class_776;
import com.corrodinggames.rts.game.units.custom.d.class_448;
import com.corrodinggames.rts.game.units.custom.e.BuiltInResource;
import com.corrodinggames.rts.gameFramework.utility.UnitConfig;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.a.a.a
public strictfp class class_785 extends class_776 {
    BuiltInResource a;
    double b = -1.7976931348623157E308;
    BuiltInResource c;
    float d = 1.0F;
    class_448 e;
    class_448 f;

    public static void a(class_591 var0, UnitConfig var1, String var2, String var3, class_1037 var4, String var5, boolean var6) {
        BuiltInResource var7 = var1.a(var0, var2, var3 + "resourceAmount", (BuiltInResource)null, true);
        if (var7 != null) {
            class_785 var8 = new class_785();
            var8.a = var7;
            var8.b = var1.getValueAsDoubleOrDefault(var2, var3 + "resourceAmount_setValue", -1.7976931348623157E308);
            var8.c = var1.a(var0, var2, var3 + "resourceAmount_addOtherResource", (BuiltInResource)null, true);
            var8.d = var1.getValueAsFloatOrDefault(var2, var3 + "resourceAmount_multiplyBy", 1.0F);
            var4.ac.add(var8);
        }

        class_448 var11 = class_448.a(var0, var1, var2, var3 + "addResourcesWithLogic", (class_448)null);
        class_448 var9 = class_448.a(var0, var1, var2, var3 + "setResourcesWithLogic", (class_448)null);
        if (var11 != null || var9 != null) {
            class_785 var10 = new class_785();
            var10.f = var9;
            var10.e = var11;
            var4.ac.add(var10);
        }

    }

    public boolean a(class_113 var1, class_226 var2, PointF var3, Unit var4, int var5) {
        if (this.a != null) {
            double var6;
            if (this.b != -1.7976931348623157E308) {
                var6 = this.b;
            } else {
                var6 = this.a.a((Unit)var1);
            }

            if (this.c != null) {
                var6 += this.c.a((Unit)var1);
            }

            var6 *= (double)this.d;
            this.a.a(var1, var6);
        }

        if (this.f != null) {
            this.f.d(var1);
        }

        if (this.e != null) {
            this.e.e(var1);
        }

        return true;
    }
}
