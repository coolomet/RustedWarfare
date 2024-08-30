package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.buildings.turrets.Turret;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.43
final class class_718 extends UnitType {
    class_718(String var1, int var2) {
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
        var2.a_("gunT3");
        return var2;
    }

    public void b() {
    }

    public int price() {
        return UnitType.turret.price() + Turret.dL.c() + Turret.dM.c();
    }

    public float D() {
        return 3.0E-4F;
    }
}
