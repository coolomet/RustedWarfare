package com.corrodinggames.rts.game.units.custom.e.a;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.custom.class_388;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.e.a.f
public strictfp class ShieldResource extends class_949 {
    public ShieldResource() {
        this.u = true;
        this.t = true;
        this.b = "shield";
        this.c = class_388.a("shield");
    }

    public double a(Unit var1) {
        return (double)var1.cx;
    }

    public void a(Unit var1, double var2) {
        var1.cx = (float)var2;
    }

    public void b(Unit var1, double var2) {
        var1.cx = (float)((double)var1.cx + var2);
    }
}
