package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.air.GunShip;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.6
final class class_759 extends UnitType {
    class_759(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public boolean C() {
        return true;
    }

    public Unit a(boolean var1) {
        return new GunShip(var1);
    }

    public void b() {
        GunShip.f();
    }

    public int price() {
        return 800;
    }

    public float D() {
        return 0.001F;
    }

    public int g() {
        return 2;
    }
}
