package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.buildings.Wall_v;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.29
final class class_736 extends UnitType {
    class_736(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public boolean j() {
        return true;
    }

    public boolean C() {
        return true;
    }

    public Unit a(boolean var1) {
        return new Wall_v(var1);
    }

    public void b() {
        Wall_v.b();
    }

    public int price() {
        return 100;
    }

    public float D() {
        return 0.003F;
    }
}
