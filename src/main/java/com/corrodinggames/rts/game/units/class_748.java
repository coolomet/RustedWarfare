package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.land.LaserTank;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.10
final class class_748 extends UnitType {
    class_748(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public boolean C() {
        return false;
    }

    public Unit a(boolean var1) {
        return new LaserTank(var1);
    }

    public void b() {
        LaserTank.f();
    }

    public int price() {
        return 1300;
    }

    public float D() {
        return 0.0013F;
    }

    public int g() {
        return 2;
    }
}
