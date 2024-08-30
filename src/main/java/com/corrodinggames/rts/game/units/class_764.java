package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.land.Tank;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.53
final class class_764 extends UnitType {
    class_764(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public boolean C() {
        return true;
    }

    public Unit a(boolean var1) {
        return new Tank(var1);
    }

    public void b() {
        Tank.f();
    }

    public int price() {
        return 350;
    }

    public float D() {
        return 0.002F;
    }
}
