package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.buildings.turrets.Turret;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.42
final class class_717 extends UnitType {
    class_717(String var1, int var2) {
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
        var2.a_("gunT2");
        return var2;
    }

    public void b() {
    }

    public int price() {
        return UnitType.turret.price() + Turret.dL.c();
    }

    public float D() {
        return 6.0E-4F;
    }
}
