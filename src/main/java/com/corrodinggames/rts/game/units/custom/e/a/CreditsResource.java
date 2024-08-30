package com.corrodinggames.rts.game.units.custom.e.a;

import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.custom.class_388;
import com.corrodinggames.rts.game.units.custom.e.GroupingStyle;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.e.a.c
public strictfp class CreditsResource extends class_949 {
    public CreditsResource() {
        this.u = true;
        this.t = true;
        this.b = "credits";
        this.c = class_388.a("$");
        this.o = true;
        this.q = GroupingStyle.SPACE;
    }

    public double a(Unit var1) {
        return var1.bX.credits;
    }

    public void a(Unit var1, double var2) {
        var1.bX.credits = var2;
    }

    public void b(Unit var1, double var2) {
        PlayerData var10000 = var1.bX;
        var10000.credits += var2;
    }

    public String a(boolean var1) {
        return "$";
    }
}
