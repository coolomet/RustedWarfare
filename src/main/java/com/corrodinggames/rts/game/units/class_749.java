package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.land.Hovercraft;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.11
final class class_749 extends UnitType {
    class_749(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public boolean C() {
        return true;
    }

    public Unit a(boolean var1) {
        return new Hovercraft(var1);
    }

    public void b() {
        Hovercraft.L();
    }

    public int price() {
        return 600;
    }

    public float D() {
        return 0.003F;
    }
}
