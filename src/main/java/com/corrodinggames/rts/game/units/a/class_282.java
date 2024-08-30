package com.corrodinggames.rts.game.units.a;

import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.custom.d.class_447;
import com.corrodinggames.rts.gameFramework.f.class_71;

// $FF: renamed from: com.corrodinggames.rts.game.units.a.l
public strictfp class class_282 extends class_281 {
    class_31 a;

    public class_282(class_31 var1) {
        this(var1, -999.0F);
    }

    public class_282(class_31 var1, float var2) {
        super("u_" + var1.v());
        class_31 var3 = class_591.c(var1);
        if (var3 != null) {
            var1 = var3;
            this.a("u_" + var3.v());
        }

        this.g = var2;
        this.a = var1;
    }

    public strictfp String type() {
        String var1 = this.a.f();
        boolean var2 = false;
        boolean var3 = true;
        var1 = var1 + "\n\n" + class_71.a(Unit.c(this.a), false, var2, var3);
        return var1;
    }

    public strictfp String b() {
        return this.a.e();
    }

    public strictfp int c() {
        return this.B().a();
    }

    public strictfp class_447 B() {
        class_447 var1 = this.h.a();
        return var1 != null ? var1 : this.a.u();
    }

    public strictfp class_447 r_() {
        class_447 var1 = this.h.b();
        return var1 != null ? var1 : this.a.B();
    }

    public strictfp class_31 i() {
        return this.a;
    }

    public strictfp float K() {
        return this.a.D();
    }

    public strictfp DisplayType f() {
        return DisplayType.queueUnit;
    }

    public strictfp boolean n_() {
        return !this.a.C();
    }

    public strictfp boolean g(Unit var1) {
        return this.i().w() ? true : super.g(var1);
    }

    public strictfp boolean g() {
        return true;
    }
}
