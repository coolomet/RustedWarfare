package com.corrodinggames.rts.game.units.custom.a.a;

import android.graphics.PointF;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.custom.class_113;
import com.corrodinggames.rts.game.units.custom.CustomException;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.custom.a.class_1037;
import com.corrodinggames.rts.game.units.custom.a.class_776;
import com.corrodinggames.rts.game.units.custom.e.BuiltInResource;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.utility.UnitConfig;
import lombok.SneakyThrows;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.a.a.g
public strictfp class class_784 extends class_776 {
    BuiltInResource a;
    BuiltInResource b;
    double c;
    double d;
    float e;

    @SneakyThrows
    public static void a(class_591 var0, UnitConfig var1, String var2, String var3, class_1037 var4, String var5, boolean var6) {
        BuiltInResource var7 = var1.a(var0, var2, "convertResource_from", (BuiltInResource)null, true);
        BuiltInResource var8 = var1.a(var0, var2, "convertResource_to", (BuiltInResource)null, true);
        if (var7 == null && var8 == null || var7 != null && var8 != null) {
            if (var7 != null && var8 != null) {
                class_784 var9 = new class_784();
                var9.a = var7;
                var9.b = var8;
                var9.c = var1.getValueAsDoubleOrDefault(var2, "convertResource_minAmount", 0.0);
                var9.d = var1.getValueAsDouble(var2, "convertResource_maxAmount");
                if (var9.c < 0.0) {
                    throw new CustomException("[" + var2 + "] convertResource_minAmount cannot be < 0");
                }

                if (var9.d < 0.0) {
                    throw new CustomException("[" + var2 + "] convertResource_maxAmount cannot be < 0");
                }

                if (var9.d < var9.c) {
                    throw new CustomException("[" + var2 + "] convertResource_maxAmount cannot be < convertResource_minAmount");
                }

                var9.e = var1.getValueAsFloatOrDefault(var2, "convertResource_multiplyAmountBy", 1.0F);
                var4.ac.add(var9);
            }

        } else {
            throw new CustomException("[" + var2 + "] Both convertResource_from and convertResource_to are required together");
        }
    }

    public boolean a(class_113 var1, class_226 var2, PointF var3, Unit var4, int var5) {
        double var6 = this.a.a((Unit)var1);
        if (var6 > this.c) {
            double var8 = class_340.a(var6, this.d);
            this.a.b(var1, -var8);
            var8 *= (double)this.e;
            this.b.b(var1, var8);
        }

        return true;
    }
}
