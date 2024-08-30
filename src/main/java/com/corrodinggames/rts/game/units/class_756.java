package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.sea.MissileShip;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.7
final class class_756 extends UnitType {
    class_756(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public boolean C() {
        return true;
    }

    public Unit a(boolean var1) {
        return new MissileShip(var1);
    }

    public void b() {
        MissileShip.f();
    }

    public int price() {
        return 900;
    }

    public float D() {
        return 0.001F;
    }
}
