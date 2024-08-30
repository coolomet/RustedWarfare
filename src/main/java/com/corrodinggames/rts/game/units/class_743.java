package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.land.TankDestroyer;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.15
final class class_743 extends UnitType {
    class_743(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public boolean C() {
        return true;
    }

    public Unit a(boolean var1) {
        return new TankDestroyer(var1);
    }

    public void b() {
        TankDestroyer.f();
    }

    public int price() {
        return 800;
    }

    public float D() {
        return 0.003F;
    }
}
