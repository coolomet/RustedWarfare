package com.corrodinggames.rts.gameFramework.f;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.custom.d.class_447;
import com.corrodinggames.rts.game.units.custom.e.class_1069;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.utility.class_684;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.f.an
public strictfp class class_517 {
    static class_684 a = new class_684();
    static final class_87 b = new class_87();

    public static class_518 a(long var0) {
        Object[] var2 = a.a();

        for(int var3 = a.a - 1; var3 >= 0; --var3) {
            class_518 var4 = (class_518)var2[var3];
            if (var4.a == var0) {
                return var4;
            }
        }

        return null;
    }

    public static class_518 a(Unit var0) {
        long var1 = var0.id;
        class_518 var3 = a(var1);
        if (var3 == null) {
            var3 = new class_518();
            var3.a = var0.id;
            var3.b = var0.cE;
            var3.c = var0.cF;
            var3.d = GameEngine.getGameEngine().netEngine.loaclTick;
            a.add(var3);
        }

        return var3;
    }

    public static void a(Unit var0, class_447 var1) {
        if (GameEngine.getGameEngine().netEngine.B) {
            class_518 var2 = a(var0);
            var2.b += var1.f;
            var2.c = var1.c(var2.c);
            if (!var1.k.c()) {
                var2.e = class_1069.b(var2.e, var1.k);
            }

        }
    }

    public static void b(Unit var0, class_447 var1) {
        if (GameEngine.getGameEngine().netEngine.B) {
            class_518 var2 = a(var0);
            var2.b -= var1.f;
            var2.c = var1.c(var2.c);
            if (!var1.k.c()) {
                var2.e = class_1069.a(var2.e, var1.k);
            }

            if (a.a > 0) {
            }

        }
    }

    public static boolean c(Unit var0, class_447 var1) {
        class_518 var2 = a(var0.id);
        if (var2 != null) {
            b.bX = var0.bX;
            b.cE = var2.b;
            b.cF = var2.c;
            class_1069 var3 = b.df();
            b.a(var2.e);
            boolean var4 = var1.b((Unit)b);
            b.a(var3);
            return var4;
        } else {
            return var1.b(var0);
        }
    }

    public static boolean a(LogicBoolean var0, OrderableUnit var1) {
        class_518 var2 = a(var1.id);
        if (var2 != null) {
            int var3 = var1.cE;
            int var4 = var1.cF;
            var1.cE = var2.b;
            var1.cF = var2.c;
            boolean var5 = var0.read(var1);
            var1.cE = var3;
            var1.cF = var4;
            return var5;
        } else {
            return var0.read(var1);
        }
    }

    public static void a() {
        if (a.a > 0) {
            GameEngine.log("LagHiding: clearing: " + a.a);
        }

        a.clear();
    }

    public static void a(OrderableUnit var0, class_226 var1) {
        if (a.size() != 0) {
            int var2 = GameEngine.getGameEngine().netEngine.loaclTick;

            for(int var3 = a.size() - 1; var3 >= 0; --var3) {
                class_518 var4 = (class_518)a.get(var3);
                if (var4.a == var0.id) {
                    a.remove(var3);
                    break;
                }

                if (var4.d < var2 + 80) {
                    a.remove(var3);
                    break;
                }
            }

        }
    }
}
