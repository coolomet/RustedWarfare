package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.land.Artillery;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.3
final class class_752 extends UnitType {
    class_752(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public boolean C() {
        return true;
    }

    public Unit a(boolean var1) {
        return new Artillery(var1);
    }

    public void b() {
        Artillery.f();
    }

    public int price() {
        return 900;
    }

    public float D() {
        return 0.0014F;
    }
}
