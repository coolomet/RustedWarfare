package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.sea.GunBoat;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.8
final class class_757 extends UnitType {
    class_757(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public boolean C() {
        return true;
    }

    public Unit a(boolean var1) {
        return new GunBoat(var1);
    }

    public void b() {
        GunBoat.f();
    }

    public int price() {
        return 300;
    }

    public float D() {
        return 0.005F;
    }
}
