package com.corrodinggames.rts.game.units.custom.e.a;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.custom.class_388;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.e.a.b
public strictfp class AmmoResource extends class_949 {
    public AmmoResource() {
        this.u = true;
        this.t = true;
        this.b = "ammo";
        this.c = class_388.a("ammo");
    }

    public double a(Unit var1) {
        return (double)var1.cE;
    }

    public void a(Unit var1, double var2) {
        var1.cE = (int)var2;
    }

    public void b(Unit var1, double var2) {
        var1.cE = (int)((double)var1.cE + var2);
    }
}
