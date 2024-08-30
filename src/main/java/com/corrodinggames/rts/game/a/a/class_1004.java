package com.corrodinggames.rts.game.a.a;

import android.graphics.PointF;
import com.corrodinggames.rts.game.a.class_138;
import com.corrodinggames.rts.game.a.class_660;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.custom.class_585;
import com.corrodinggames.rts.game.units.custom.a.AIUse;
import com.corrodinggames.rts.game.units.custom.d.class_447;
import com.corrodinggames.rts.game.units.buildings.class_8;

// $FF: renamed from: com.corrodinggames.rts.game.a.a.d
public strictfp class class_1004 extends class_1003 {
    public final boolean b = true;
    static final class_585 c = class_585.c("nukeLauncher");

    public class_462 a() {
        return class_462.NUKING;
    }

    public boolean c(class_138 var1, OrderableUnit var2) {
        return this.a(var2);
    }

    public PointF d(class_138 var1, OrderableUnit var2) {
        return var1.at();
    }

    public void e(class_138 var1, OrderableUnit var2) {
        class_226 var3 = class_660.a(var1, var2, AIUse.launch);
        if (var3 != null) {
            if (var3.b((Unit)var2) && var3.a(var2, false)) {
                PointF var4 = this.d(var1, var2);
                if (var4 != null) {
                    var1.c((String)("nuke: launching at:" + var4.x + ", " + var4.y));
                    var1.a(var2, var3, var4, (Unit)null);
                } else {
                    var1.c((String)"nuke: no target");
                }
            } else {
                var1.c((String)"nuke: not ready");
            }
        }

    }

    public void f(class_138 var1, OrderableUnit var2) {
        if (var2 instanceof class_8 && ((class_8)var2).dy()) {
            class_226 var3 = class_660.a(var1, var2, AIUse.launchAmmo);
            if (var3 != null && var1.a((class_447)var3.B(), (Unit)var2)) {
                var1.c((String)"ai nuke building");
                var1.a(var2, var3);
            }
        }

    }

    public boolean a(OrderableUnit var1) {
        return class_660.a(var1, c);
    }

    public void b(float var1, class_138 var2) {
        Unit[] var3 = this.a.a();
        int var4 = 0;

        for(int var5 = this.a.size(); var4 < var5; ++var4) {
            OrderableUnit var6 = (OrderableUnit)var3[var4];
            this.f(var2, var6);
            this.e(var2, var6);
        }

    }
}
