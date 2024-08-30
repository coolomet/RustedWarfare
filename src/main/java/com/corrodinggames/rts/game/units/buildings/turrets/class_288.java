package com.corrodinggames.rts.game.units.buildings.turrets;

import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.a.DisplayType;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.a.class_281;
import com.corrodinggames.rts.gameFramework.h.class_1009;

// $FF: renamed from: com.corrodinggames.rts.game.units.d.a.b.1
final class class_288 extends class_281 {
    class_288(int var1) {
        super(var1);
    }

    public boolean g() {
        return false;
    }

    public String type() {
        return "-Increases HP, attack damage, and range";
    }

    public String b() {
        return class_1009.a("gui.actions.upgradeToGunT2");
    }

    public int c() {
        return 1000;
    }

    public float K() {
        return 0.001F;
    }

    public boolean a(Unit var1, boolean var2) {
        Turret var3 = (Turret)var1;
        return var3.M() == 1 && var3.a(class_226.i, var2) <= 0 ? super.a(var1, var2) : false;
    }

    public boolean b(Unit var1) {
        Turret var2 = (Turret)var1;
        return var2.M() == 1;
    }

    public UnitType L() {
        return null;
    }

    public DisplayType f() {
        return DisplayType.upgrade;
    }

    public void f(Unit var1) {
        Turret var2 = (Turret)var1;
        var2.b(Turret.u);
        Turret.a(var2);
    }

    // $FF: synthetic method
    public class_31 i() {
        return this.L();
    }
}
