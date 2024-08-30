package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.buildings.SupplyDepot;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.35
final class class_731 extends UnitType {
    class_731(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public boolean j() {
        return true;
    }

    public boolean C() {
        return true;
    }

    public Unit a(boolean var1) {
        return new SupplyDepot(var1);
    }

    public void b() {
        SupplyDepot.K();
    }

    public int price() {
        return 1000;
    }

    public float D() {
        return 0.001F;
    }
}
