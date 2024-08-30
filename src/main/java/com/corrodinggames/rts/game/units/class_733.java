package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.land.ExperimentalTank;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.26
final class class_733 extends UnitType {
    class_733(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public boolean C() {
        return false;
    }

    public Unit a(boolean var1) {
        return new ExperimentalTank(var1);
    }

    public void b() {
        ExperimentalTank.f();
    }

    public int price() {
        return 14000;
    }

    public float D() {
        return 2.0E-4F;
    }

    public int g() {
        return 3;
    }
}
