package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.land.HeavyHoverTank;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.17
final class class_745 extends UnitType {
    class_745(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public boolean C() {
        return true;
    }

    public Unit a(boolean var1) {
        return new HeavyHoverTank(var1);
    }

    public void b() {
        HeavyHoverTank.f();
    }

    public int price() {
        return 1000;
    }

    public float D() {
        return 0.001F;
    }

    public int g() {
        return 2;
    }
}
