package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.buildings.turrets.AntiAirTurret;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.51
final class class_762 extends UnitType {
    class_762(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public boolean j() {
        return true;
    }

    public boolean C() {
        return true;
    }

    public Unit a(boolean var1) {
        return new AntiAirTurret(var1);
    }

    public void b() {
        AntiAirTurret.b();
    }

    public int price() {
        return 600;
    }

    public float D() {
        return 8.0E-4F;
    }
}
