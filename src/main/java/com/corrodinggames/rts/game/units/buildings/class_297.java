package com.corrodinggames.rts.game.units.buildings;

import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.a.DisplayType;
import com.corrodinggames.rts.game.units.a.class_281;
import com.corrodinggames.rts.gameFramework.h.class_1009;

// $FF: renamed from: com.corrodinggames.rts.game.units.d.b
class class_297 extends class_281 {
    public class_297() {
        super(AirFactory.h.a());
    }

    public strictfp boolean g() {
        return false;
    }

    public strictfp String type() {
        return "-Allows factory to build Tech 2 units";
    }

    public strictfp String b() {
        return class_1009.a("gui.actions.upgradeT2");
    }

    public strictfp int c() {
        return UnitType.airFactory.upgradePrice(2);
    }

    public strictfp float K() {
        return 4.0E-4F;
    }

    public strictfp boolean a(Unit var1, boolean var2) {
        AirFactory var3 = (AirFactory)var1;
        return var3.f == 1 && var3.a(this.N(), var2) <= 0 ? super.a(var1, var2) : false;
    }

    public strictfp UnitType L() {
        return null;
    }

    public strictfp DisplayType f() {
        return DisplayType.upgrade;
    }

    // $FF: synthetic method
    public class_31 i() {
        return this.L();
    }
}
