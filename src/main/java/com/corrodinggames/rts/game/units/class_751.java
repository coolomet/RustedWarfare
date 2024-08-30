package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.c.Ladybug;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.13
final class class_751 extends UnitType {
    class_751(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public boolean C() {
        return true;
    }

    public Unit a(boolean var1) {
        return new Ladybug(var1);
    }

    public void b() {
        Ladybug.f();
    }

    public int price() {
        return 400;
    }

    public float D() {
        return 0.004F;
    }
}
