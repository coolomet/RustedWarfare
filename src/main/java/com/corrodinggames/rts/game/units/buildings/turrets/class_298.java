package com.corrodinggames.rts.game.units.buildings.turrets;

import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.a.DisplayType;
import com.corrodinggames.rts.game.units.a.class_281;

// $FF: renamed from: com.corrodinggames.rts.game.units.d.a.a.1
final class class_298 extends class_281 {
    class_298(int var1) {
        super(var1);
    }

    public boolean g() {
        return false;
    }

    public String type() {
        return "-Increases HP, attack damage, and range";
    }

    public String b() {
        return "Upgrade";
    }

    public int c() {
        return 1200;
    }

    public float K() {
        return 0.001F;
    }

    public boolean a(Unit var1, boolean var2) {
        Turret var3 = (Turret)var1;
        return !var3.j && var3.a(this.N(), var2) <= 0 ? super.a(var1, var2) : false;
    }

    public boolean b(Unit var1) {
        Turret var2 = (Turret)var1;
        return !var2.j;
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
