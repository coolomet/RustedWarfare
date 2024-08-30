package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.land.ExperimentalHoverTank;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.36
final class class_722 extends UnitType {
    class_722(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public boolean C() {
        return false;
    }

    public Unit a(boolean var1) {
        return new ExperimentalHoverTank(var1);
    }

    public void b() {
        ExperimentalHoverTank.f();
    }

    public int price() {
        return 21000;
    }

    public float D() {
        return 2.0E-4F;
    }

    public int g() {
        return 3;
    }
}
