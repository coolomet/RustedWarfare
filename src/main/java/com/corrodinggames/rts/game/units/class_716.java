package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.buildings.turrets.AntiAirTurret;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.41
final class class_716 extends UnitType {
    class_716(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public boolean j() {
        return true;
    }

    public boolean C() {
        return true;
    }

    public Unit a(boolean var1) {
        AntiAirTurret var2 = new AntiAirTurret(var1);
        var2.a(2);
        return var2;
    }

    public void b() {
    }

    public int price() {
        return UnitType.turret.price() + AntiAirTurret.e.c();
    }

    public float D() {
        return 6.0E-4F;
    }
}
