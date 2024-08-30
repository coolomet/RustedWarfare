package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.land.HeavyTank;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.16
final class class_744 extends UnitType {
    class_744(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public boolean C() {
        return true;
    }

    public Unit a(boolean var1) {
        return new HeavyTank(var1);
    }

    public void b() {
        HeavyTank.f();
    }

    public int price() {
        return 800;
    }

    public float D() {
        return 0.0011F;
    }

    public int g() {
        return 2;
    }
}
