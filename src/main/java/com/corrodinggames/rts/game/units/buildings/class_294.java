package com.corrodinggames.rts.game.units.buildings;

import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.a.DisplayType;
import com.corrodinggames.rts.game.units.a.class_281;
import com.corrodinggames.rts.gameFramework.h.class_1009;

// $FF: renamed from: com.corrodinggames.rts.game.units.d.q.2
final class class_294 extends class_281 {
    class_294(int var1) {
        super(var1);
    }

    public boolean g() {
        return false;
    }

    public String type() {
        return class_1009.a("gui.actions.buildNuke.description");
    }

    public String b() {
        return class_1009.a("gui.actions.buildNuke");
    }

    public int c() {
        return 11000;
    }

    public float K() {
        return 3.0E-4F;
    }

    public boolean a(Unit var1, boolean var2) {
        NukeLaucher var3 = (NukeLaucher)var1;
        float var4 = (float)(var3.c + var3.a(this.N(), var2));
        return var4 >= 4.0F ? false : super.a(var1, var2);
    }

    public UnitType L() {
        return null;
    }

    public DisplayType f() {
        return DisplayType.queueUnit;
    }

    // $FF: synthetic method
    public class_31 i() {
        return this.L();
    }
}
