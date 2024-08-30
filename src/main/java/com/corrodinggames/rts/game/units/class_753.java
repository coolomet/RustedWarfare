package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.air.Helicopter;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.4
final class class_753 extends UnitType {
    class_753(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public boolean C() {
        return true;
    }

    public Unit a(boolean var1) {
        return new Helicopter(var1);
    }

    public void b() {
        Helicopter.f();
    }

    public int price() {
        return 650;
    }

    public float D() {
        return 0.0012F;
    }
}
