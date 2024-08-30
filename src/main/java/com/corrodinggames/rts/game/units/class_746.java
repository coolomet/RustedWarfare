package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.buildings.LaserDefence;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.18
final class class_746 extends UnitType {
    class_746(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public boolean j() {
        return true;
    }

    public boolean C() {
        return true;
    }

    public Unit a(boolean var1) {
        return new LaserDefence(var1);
    }

    public void b() {
        LaserDefence.b();
    }

    public int price() {
        return 1200;
    }

    public int upgradePrice(int var1) {
        return var1 == 2 ? 2000 : 0;
    }

    public float D() {
        return 0.001F;
    }
}
