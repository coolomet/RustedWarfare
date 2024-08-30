package com.corrodinggames.rts.game.units.custom.e.a;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.custom.class_388;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.e.a.e
public strictfp class HPResource extends class_949 {
    public HPResource() {
        this.u = true;
        this.t = true;
        this.b = "hp";
        this.c = class_388.a("hp");
    }

    public double a(Unit var1) {
        return (double)var1.health;
    }

    public void a(Unit var1, double var2) {
        var1.o((float)var2);
    }

    public void b(Unit var1, double var2) {
        var1.o(var1.health + (float)var2);
    }
}
