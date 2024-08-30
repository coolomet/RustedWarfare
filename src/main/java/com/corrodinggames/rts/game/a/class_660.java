package com.corrodinggames.rts.game.a;

import com.corrodinggames.rts.game.units.WaypointType;
import com.corrodinggames.rts.game.units.class_1042;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.custom.class_585;
import com.corrodinggames.rts.game.units.custom.class_588;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.custom.a.AIUse;
import com.corrodinggames.rts.gameFramework.class_340;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.game.a.f
public strictfp class class_660 {
    static boolean a(OrderableUnit var0) {
        boolean var1 = false;
        if (var0.aq()) {
            var1 = true;
        }

        if (!var1) {
            class_1042 var2 = var0.ar();
            if (var2 != null && var2.d() == WaypointType.reclaim) {
                var1 = true;
            }
        }

        return var1;
    }

    static boolean b(OrderableUnit var0) {
        boolean var1 = false;
        if (var0.aq()) {
            var1 = true;
        }

        return var1;
    }

    public static Object a(AbstractList var0) {
        int var1 = var0.size();
        return var1 == 0 ? null : var0.get(class_340.rand(0, var1 - 1));
    }

    public static boolean a(OrderableUnit var0, class_585 var1) {
        class_31 var2 = var0.r();
        if (var2 instanceof class_591) {
            class_588 var3 = ((class_591)var2).fv;
            if (class_585.a(var1, var3)) {
                return true;
            }
        }

        return false;
    }

    public static class_226 a(class_138 var0, OrderableUnit var1, AIUse var2) {
        ArrayList var3 = var1.N();
        ArrayList var4 = var0.ap();
        Iterator var5 = var3.iterator();

        while(var5.hasNext()) {
            class_226 var6 = (class_226)var5.next();
            if (var6.v(var1) == var2) {
                var4.add(var6);
            }
        }

        if (var4.size() > 0) {
            return (class_226)a((AbstractList)var4);
        } else {
            return null;
        }
    }
}
