package com.corrodinggames.rts.game.units.a;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.buildings.class_73;
import com.corrodinggames.rts.game.units.buildings.class_8;

// $FF: renamed from: com.corrodinggames.rts.game.units.a.w
public abstract strictfp class class_281 extends class_226 {
    public class_281(int var1) {
        super(var1);
    }

    public class_281(String var1) {
        super(var1);
    }

    public int b(Unit var1, boolean var2) {
        return !(var1 instanceof class_8) ? 99 : ((class_8)var1).a(this.N(), var2);
    }

    public float p(Unit var1) {
        if (!(var1 instanceof class_8)) {
            return -1.0F;
        } else {
            class_8 var2 = (class_8)var1;
            class_73 var3 = var2.dw();
            if (var3 == null) {
                return -1.0F;
            } else if (!this.d(var3.j)) {
                return -1.0F;
            } else {
                float var4 = var3.m;
                if (var4 < 0.0F) {
                    return 0.0F;
                } else {
                    return var4 > 1.0F ? 1.0F : var4;
                }
            }
        }
    }

    public float K() {
        return 0.01F;
    }

    public boolean u() {
        return true;
    }

    public class_1052 e() {
        return class_1052.popupQueue;
    }
}
