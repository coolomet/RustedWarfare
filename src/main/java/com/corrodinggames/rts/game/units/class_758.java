package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.air.AirShip;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.5
final class class_758 extends UnitType {
    class_758(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public boolean C() {
        return true;
    }

    public Unit a(boolean var1) {
        return new AirShip(var1);
    }

    public void b() {
        AirShip.f();
    }

    public int price() {
        return 600;
    }

    public float D() {
        return 0.002F;
    }
}
