package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.buildings.turrets.Turret;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.38
final class class_724 extends UnitType {
    class_724(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public boolean j() {
        return true;
    }

    public boolean C() {
        return true;
    }

    public Unit a(boolean var1) {
        Turret var2 = new Turret(var1);
        var2.a_("flamethrower");
        return var2;
    }

    public void b() {
    }

    public int price() {
        return UnitType.turret.price() + Turret.dO.c();
    }

    public float D() {
        return 6.0E-4F;
    }
}
