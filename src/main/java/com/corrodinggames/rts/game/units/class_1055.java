package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.custom.d.class_447;
import java.util.Comparator;

// $FF: renamed from: com.corrodinggames.rts.game.units.h.15
final class class_1055 implements Comparator {
    public strictfp int a(class_31 var1, class_31 var2) {
        Unit var4 = Unit.c(var1);
        Unit var5 = Unit.c(var2);
        Boolean var6 = var4.bP();
        Boolean var7 = var5.bP();
        int var3 = var6.compareTo(var7);
        if (var3 != 0) {
            return var3;
        } else {
            Boolean var8 = var1.j();
            Boolean var9 = var2.j();
            var3 = var8.compareTo(var9);
            if (var3 != 0) {
                return var3;
            } else {
                Boolean var10 = var4.bO();
                Boolean var11 = var5.bO();
                var3 = var10.compareTo(var11);
                if (var3 != 0) {
                    return var3;
                } else {
                    class_447 var12 = var1.u();
                    class_447 var13 = var2.u();
                    class_447 var14 = var1.B();
                    class_447 var15 = var2.B();
                    if (var14 != null) {
                        var12 = class_447.a(var12, var14);
                    }

                    if (var15 != null) {
                        var13 = class_447.a(var13, var15);
                    }

                    var3 = var12.a(var13);
                    return var3 != 0 ? var3 : 0;
                }
            }
        }
    }

    // $FF: synthetic method
    public int compare(Object var1, Object var2) {
        return this.a((class_31)var1, (class_31)var2);
    }
}
