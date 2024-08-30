package com.corrodinggames.rts.gameFramework.f;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import java.util.ArrayList;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.f.al
abstract class class_501 {
    static class_501 a = new class_506();
    static class_501 b = new class_503();
    static class_501 c = new class_502();
    static class_501 d = new class_505();
    static class_501 e = new class_504();
    static class_501 f = new class_507();

    public abstract boolean a(OrderableUnit var1);

    public static void a(ArrayList var0, class_501 var1, class_501 var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        if (var3.bS.q() != 1) {
            var0.clear();
        }

        OrderableUnit var4 = var3.bS.t();
        if (var4 != null) {
            if (!var1.a(var4) && (var2 == null || !var2.a(var4))) {
                var0.clear();
            } else if (!var0.contains(var4)) {
                var0.add(var4);
            }
        }

        OrderableUnit var5 = a(var0, var1);
        if (var5 == null && var2 != null) {
            var5 = a(var0, var2);
        }

        if (var5 == null) {
            var0.clear();
            if (var4 != null) {
                var0.add(var4);
            }

            var5 = a(var0, var1);
            if (var5 == null && var2 != null) {
                var5 = a(var0, var2);
            }
        }

        if (var5 != null) {
            var3.bS.y();
            var3.bS.j(var5);
            var3.b(var5.xCord, var5.yCord);
            var0.add(var5);
        }

    }

    public static OrderableUnit a(ArrayList var0, class_501 var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        OrderableUnit var3 = null;
        float var4 = -1.0F;
        Iterator var5 = Unit.bE.iterator();

        while(true) {
            OrderableUnit var7;
            float var8;
            do {
                do {
                    do {
                        do {
                            Unit var6;
                            do {
                                if (!var5.hasNext()) {
                                    return var3;
                                }

                                var6 = (Unit)var5.next();
                            } while(!(var6 instanceof OrderableUnit));

                            var7 = (OrderableUnit)var6;
                        } while(!var2.bS.m(var7));
                    } while(!var1.a(var7));
                } while(var0.contains(var7));

                var8 = class_340.a(var2.cy + var2.cI, var2.cz + var2.cJ, var7.xCord, var7.yCord);
            } while(var3 != null && !(var8 < var4));

            var4 = var8;
            var3 = var7;
        }
    }
}
