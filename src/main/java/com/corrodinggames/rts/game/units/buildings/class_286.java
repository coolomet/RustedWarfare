package com.corrodinggames.rts.game.units.buildings;

import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.a.DisplayType;
import com.corrodinggames.rts.game.units.a.class_281;
import com.corrodinggames.rts.gameFramework.h.class_1009;

// $FF: renamed from: com.corrodinggames.rts.game.units.d.p.1
final class class_286 extends class_281 {
    class_286(int var1) {
        super(var1);
    }

    public boolean g() {
        return false;
    }

    public String type() {
        return class_1009.a("units.laserDefence.upgrade.description");
    }

    public String b() {
        return class_1009.a("units.laserDefence.upgrade.name");
    }

    public int c() {
        return UnitType.laserDefence.upgradePrice(2);
    }

    public float K() {
        return 3.0E-4F;
    }

    public boolean a(Unit var1, boolean var2) {
        LaserDefence var3 = (LaserDefence)var1;
        return !var3.d && var3.a(this.N(), var2) <= 0 ? super.a(var1, var2) : false;
    }

    public boolean b(Unit var1) {
        LaserDefence var2 = (LaserDefence)var1;
        return !var2.d;
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
