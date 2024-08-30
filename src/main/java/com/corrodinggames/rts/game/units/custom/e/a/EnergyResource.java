package com.corrodinggames.rts.game.units.custom.e.a;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.custom.class_388;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.e.a.d
public strictfp class EnergyResource extends class_949 {
    public EnergyResource() {
        this.u = true;
        this.t = true;
        this.b = "energy";
        this.c = class_388.a("energy");
    }

    public double a(Unit var1) {
        return (double)var1.cB;
    }

    public void a(Unit var1, double var2) {
        var1.cB = (float)var2;
    }

    public void b(Unit var1, double var2) {
        var1.cB = (float)((double)var1.cB + var2);
    }
}
