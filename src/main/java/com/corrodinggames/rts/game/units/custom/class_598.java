package com.corrodinggames.rts.game.units.custom;

import android.graphics.PointF;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.a.class_281;
import com.corrodinggames.rts.gameFramework.net.GameNetEngine;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import lombok.SneakyThrows;

import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.u
public strictfp class class_598 {
    class_684 a = new class_684();
    class_684 b;
    String c;
    String d;

    public strictfp void a(class_591 var1) {
    }

    @SneakyThrows
    public strictfp void b(class_591 var1) {
        class_684 var2 = new class_684();
        Iterator var3 = this.a.iterator();

        while(var3.hasNext()) {
            String var4 = (String)var3.next();
            class_226 var5 = var1.h(var4);
            if (var5 == null) {
                throw new CustomException("[" + this.d + "]" + this.c + " Could not find action:" + var4 + " on unit: " + var1.b());
            }

            if (!(var5 instanceof class_281)) {
                throw new CustomException("[" + this.d + "]" + this.c + " Action:" + var4 + " on unit: " + var1.b() + " doesn't have the right type");
            }

            var2.add((class_281)var5);
        }

        this.b = var2;
    }

    public strictfp void a(class_113 var1, PointF var2, Unit var3, int var4, int var5) {
        if (this.b == null) {
            GameNetEngine.g("Action on " + var1.dt().i() + " has not been linked");
        } else {
            Iterator var6 = this.b.iterator();

            while(var6.hasNext()) {
                class_226 var7 = (class_226)var6.next();
                var1.a(var7, var2, var3, var4, var5);
            }

        }
    }

    public strictfp class_684 a() {
        if (this.b == null) {
            GameNetEngine.g("Action on [" + this.d + "]" + this.c + " has not been linked");
            return new class_684();
        } else {
            return this.b;
        }
    }

    public strictfp void a(class_113 var1, PointF var2, Unit var3) {
        if (this.b == null) {
            GameNetEngine.g("Action on " + var1.dt().i() + " has not been linked");
        } else {
            Iterator var4 = this.b.iterator();

            while(var4.hasNext()) {
                class_226 var5 = (class_226)var4.next();
                var1.dL.a((class_281)var5, false, var2, var3);
            }

        }
    }
}
