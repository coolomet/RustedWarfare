package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.land.MegaTank;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.9
final class class_760 extends UnitType {
    class_760(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public boolean C() {
        return true;
    }

    public Unit a(boolean var1) {
        return new MegaTank(var1);
    }

    public void b() {
        MegaTank.f();
    }

    public int price() {
        return 800;
    }

    public float D() {
        return 0.0015F;
    }
}
