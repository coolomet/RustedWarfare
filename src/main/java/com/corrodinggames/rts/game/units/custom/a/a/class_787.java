package com.corrodinggames.rts.game.units.custom.a.a;

import android.graphics.PointF;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.custom.class_113;
import com.corrodinggames.rts.game.units.custom.class_588;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.custom.a.class_1037;
import com.corrodinggames.rts.game.units.custom.a.class_776;
import com.corrodinggames.rts.gameFramework.utility.UnitConfig;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.a.a.l
public strictfp class class_787 extends class_776 {
    boolean a;
    class_588 b;
    class_588 c;
    class_588 d;
    class_588 e;

    public static void a(class_591 var0, UnitConfig var1, String var2, String var3, class_1037 var4, String var5, boolean var6) {
        boolean var7 = var1.getValueAsBoolean(var2, var3 + "resetToDefaultTags", false);
        class_588 var8 = var1.a((class_591)var0, var2, (String)(var3 + "temporarilyAddTags"), (class_588)null);
        class_588 var9 = var1.a((class_591)var0, var2, (String)(var3 + "temporarilyRemoveTags"), (class_588)null);
        if (var7 || var8 != null || var9 != null) {
            class_787 var10 = new class_787();
            var10.a = var7;
            var10.b = var8;
            var10.c = var9;
            var4.ac.add(var10);
        }

        class_588 var13 = var1.a((class_591)var0, var2, (String)(var3 + "addGlobalTeamTags"), (class_588)null);
        class_588 var11 = var1.a((class_591)var0, var2, (String)(var3 + "removeGlobalTeamTags"), (class_588)null);
        if (var13 != null || var11 != null) {
            class_787 var12 = new class_787();
            var12.d = var13;
            var12.e = var11;
            var4.ac.add(var12);
        }

    }

    public boolean a(class_113 var1, class_226 var2, PointF var3, Unit var4, int var5) {
        if (this.a) {
            var1.j(false);
        }

        if (this.c != null) {
            var1.b(this.c);
        }

        if (this.b != null) {
            var1.a(this.b);
        }

        if (this.d != null) {
            var1.bX.b(this.d);
        }

        if (this.e != null) {
            var1.bX.c(this.e);
        }

        return true;
    }
}
