package com.corrodinggames.rts.game.units.custom.a.a;

import android.graphics.PointF;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.custom.class_113;
import com.corrodinggames.rts.game.units.custom.class_395;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.custom.a.class_1037;
import com.corrodinggames.rts.game.units.custom.a.class_776;
import com.corrodinggames.rts.gameFramework.utility.UnitConfig;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.a.a.k
public strictfp class class_780 extends class_776 {
    public class_395 a;
    public class_395 b;

    public static void a(class_591 var0, UnitConfig var1, String var2, String var3, class_1037 var4, String var5, boolean var6) {
        class_395 var7 = class_395.a(var0, var1, var2, var3 + "produceUnits");
        if (!var7.b()) {
            class_780 var8 = new class_780();
            var8.a = var7;
            var4.ac.add(var8);
        }

        class_395 var10 = class_395.a(var0, var1, var2, var3 + "spawnUnits");
        if (!var10.b()) {
            class_780 var9 = new class_780();
            var9.b = var10;
            var4.ac.add(var9);
        }

    }

    public boolean a(class_113 var1, class_226 var2, PointF var3, Unit var4, int var5) {
        if (this.a != null) {
            class_684 var6 = new class_684();
            this.a.a(var6, var1.bX, var1, false);
            Iterator var7 = var6.iterator();

            while(var7.hasNext()) {
                Unit var8 = (Unit)var7.next();
                var1.E(var8);
                var1.F(var8);
            }
        }

        if (this.b != null) {
            this.b.spawnUnitsAt(var1.xCord, var1.yCord, var1.zCord, var1.cg, var1.bX, false, var1);
        }

        return true;
    }
}
