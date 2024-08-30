package com.corrodinggames.rts.game.units.buildings;

import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.a.DisplayType;
import com.corrodinggames.rts.game.units.a.class_281;
import com.corrodinggames.rts.gameFramework.h.class_1009;

// $FF: renamed from: com.corrodinggames.rts.game.units.d.h.2
final class class_292 extends class_281 {
    class_292(int var1) {
        super(var1);
    }

    public boolean g() {
        return false;
    }

    public String type() {
        return class_1009.a("units.fabricator.upgrade.descriptionT3");
    }

    public String b() {
        return class_1009.a("units.fabricator.upgrade.nameT3");
    }

    public int c() {
        return UnitType.fabricator.upgradePrice(3);
    }

    public float K() {
        return 2.0E-4F;
    }

    public boolean a(Unit var1, boolean var2) {
        Fabricator var3 = (Fabricator)var1;
        return var3.r == 2 && var3.a(this.N(), var2) <= 0 ? super.a(var1, var2) : false;
    }

    public boolean b(Unit var1) {
        Fabricator var2 = (Fabricator)var1;
        return var2.r == 2;
    }

    public UnitType L() {
        return null;
    }

    public DisplayType f() {
        return DisplayType.upgrade;
    }

    // $FF: synthetic method
    public class_31 i() {
        return this.L();
    }
}
