package com.corrodinggames.rts.gameFramework.f;

import com.corrodinggames.rts.gameFramework.h.class_1009;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.f.as
class class_514 extends class_512 {
    private boolean a;

    public class_514(float var1, float var2, boolean var3) {
        super(var1, var2);
        this.a = var3;
    }

    public strictfp boolean a(class_512 var1) {
        if (super.a(var1) && var1 instanceof class_514) {
            class_514 var2 = (class_514)var1;
            return var2.a == this.a;
        } else {
            return false;
        }
    }

    public strictfp void b(class_512 var1) {
    }

    protected strictfp long b() {
        return 20000L;
    }

    public strictfp String type() {
        if (this.g == null) {
            if (this.a) {
                this.g = class_1009.a("gui.log.baseDamaged");
            } else {
                this.g = class_1009.a("gui.log.unitDamaged");
            }
        }

        return this.g;
    }
}
