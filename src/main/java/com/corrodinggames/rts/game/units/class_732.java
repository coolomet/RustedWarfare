package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.land.MammothTank;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.25
final class class_732 extends UnitType {
    class_732(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public boolean C() {
        return false;
    }

    public Unit a(boolean var1) {
        return new MammothTank(var1);
    }

    public void b() {
        MammothTank.f();
    }

    public int price() {
        return 3900;
    }

    public float D() {
        return 9.0E-4F;
    }

    public int g() {
        return 3;
    }
}
