package com.corrodinggames.rts.game.units.custom.e;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.custom.d.class_447;
import com.corrodinggames.rts.game.units.custom.e.a.class_949;
import com.corrodinggames.rts.gameFramework.utility.class_684;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.e.c
public strictfp class class_1065 {
    public final class_684 a = new class_684();

    public void a(BuiltInResource var1) {
        if (!this.a.contains(var1)) {
            this.a.add(var1);
        }

    }

    public void a(class_1069 var1, Unit var2, double var3) {
        int var5 = var1.b.a;
        Object[] var6 = var1.b.a();

        for(int var7 = 0; var7 < var5; ++var7) {
            class_1067 var8 = (class_1067)var6[var7];
            double var9 = var8.a.a(var2);
            if (var9 < var8.b * var3) {
                this.a(var8.a);
            }
        }

    }

    public void a(class_447 var1, Unit var2, double var3) {
        if (!var1.k.c()) {
            this.a(var1.k, var2, var3);
        }

        if (var1.b > 0 && var2.bX.credits < (double)var1.b * var3) {
            this.a(class_949.D);
        }

    }

    public boolean a(class_1069 var1) {
        int var2 = var1.b.a;
        Object[] var3 = var1.b.a();

        for(int var4 = 0; var4 < var2; ++var4) {
            class_1067 var5 = (class_1067)var3[var4];
            if (this.a.contains(var5.a)) {
                return true;
            }
        }

        return false;
    }

    public boolean a(class_447 var1) {
        if (var1.b > 0 && this.a.contains(class_949.D)) {
            return true;
        } else {
            return !var1.k.c() && this.a(var1.k);
        }
    }

    public void a() {
        this.a.clear();
    }
}
