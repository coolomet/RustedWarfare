package com.corrodinggames.rts.gameFramework.f;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.f.c
class class_549 {
    Unit a;
    class_226 b;
    float c;
    boolean d;
    boolean e;
    static class_684 f = new class_684();

    public static void a(Unit var0, class_226 var1, boolean var2, boolean var3) {
        class_549 var4 = a(var0, var1, var3);
        if (var4 == null) {
            var4 = new class_549();
            f.add(var4);
        }

        var4.a = var0;
        var4.b = var1;
        var4.c = 10.0F;
        var4.d = var2;
        var4.e = var3;
    }

    public static class_549 a(Unit var0, class_226 var1, boolean var2) {
        Iterator var3 = f.iterator();

        class_549 var4;
        do {
            if (!var3.hasNext()) {
                return null;
            }

            var4 = (class_549)var3.next();
        } while(var4.a != var0 || var4.b != var1 || var4.e != var2);

        return var4;
    }

    public static float b(Unit var0, class_226 var1, boolean var2) {
        class_549 var3 = a(var0, var1, var2);
        if (var3 != null) {
            float var4 = var3.c / 10.0F;
            if (var3.d) {
                var4 = -var4;
            }

            return var4;
        } else {
            return 0.0F;
        }
    }

    public static void a(float var0) {
        for(int var1 = f.size() - 1; var1 >= 0; --var1) {
            class_549 var2 = (class_549)f.get(var1);
            var2.c -= var0;
            if (var2.c <= 0.0F) {
                f.remove(var1);
            }
        }

    }
}
