package com.corrodinggames.rts.gameFramework.f;

import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.gameFramework.h.class_1009;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.f.ar
class class_515 extends class_512 {
    class_31 a;
    int b;

    public class_515(float var1, float var2, class_31 var3) {
        super(var1, var2);
        this.a = var3;
        this.b = 1;
    }

    public strictfp boolean a(class_512 var1) {
        if (super.a(var1) && var1 instanceof class_515) {
            class_515 var2 = (class_515)var1;
            return var2.a == this.a;
        } else {
            return false;
        }
    }

    public strictfp void b(class_512 var1) {
        this.c = var1.c;
        ++this.b;
        this.g = null;
        this.h = false;
    }

    public strictfp String type() {
        if (this.g == null) {
            String var1 = "gui.log.unitCreated";
            if (this.a.j()) {
                var1 = "gui.log.buildingConstructed";
            }

            this.g = String.format(class_1009.a(var1), this.a.e(), this.b);
        }

        return this.g;
    }
}
