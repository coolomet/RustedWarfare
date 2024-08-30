package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.buildings.RepairBay;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.21
final class class_738 extends UnitType {
    class_738(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public boolean j() {
        return true;
    }

    public boolean C() {
        return true;
    }

    public Unit a(boolean var1) {
        return new RepairBay(var1);
    }

    public void b() {
        RepairBay.M();
    }

    public int price() {
        return 1500;
    }

    public float D() {
        return 0.001F;
    }
}
