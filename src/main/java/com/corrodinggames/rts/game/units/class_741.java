package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.buildings.AntiNukeLaucher;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.24
final class class_741 extends UnitType {
    class_741(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public boolean j() {
        return true;
    }

    public boolean C() {
        return false;
    }

    public Unit a(boolean var1) {
        return new AntiNukeLaucher(var1);
    }

    public void b() {
        com.corrodinggames.rts.game.units.buildings.AntiNukeLaucher.b();
    }

    public int price() {
        return 15000;
    }

    public float D() {
        return 7.0E-4F;
    }
}
