package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.buildings.turrets.Turret;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.50
final class class_761 extends UnitType {
    class_761(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public boolean j() {
        return true;
    }

    public boolean C() {
        return true;
    }

    public Unit a(boolean var1) {
        return new Turret(var1);
    }

    public void b() {
        Turret.dB();
    }

    public int price() {
        return 500;
    }

    public float D() {
        return 6.0E-4F;
    }
}
