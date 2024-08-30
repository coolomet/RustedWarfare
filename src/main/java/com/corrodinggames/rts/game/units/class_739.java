package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.buildings.NukeLaucher;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.22
final class class_739 extends UnitType {
    class_739(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public boolean j() {
        return true;
    }

    public boolean C() {
        return false;
    }

    public Unit a(boolean var1) {
        return new NukeLaucher(var1);
    }

    public void b() {
        com.corrodinggames.rts.game.units.buildings.NukeLaucher.b();
    }

    public int price() {
        return 45000;
    }

    public float D() {
        return 1.0E-4F;
    }
}
