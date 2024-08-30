package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.land.HoverTank;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.2
final class class_755 extends UnitType {
    class_755(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public boolean C() {
        return true;
    }

    public Unit a(boolean var1) {
        return new HoverTank(var1);
    }

    public void b() {
        HoverTank.f();
    }

    public int price() {
        return 450;
    }

    public float D() {
        return 0.002F;
    }
}
