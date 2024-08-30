package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.air.AmphibiousJet;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.33
final class class_729 extends UnitType {
    class_729(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public boolean C() {
        return false;
    }

    public Unit a(boolean var1) {
        return new AmphibiousJet(var1);
    }

    public void b() {
        AmphibiousJet.L();
    }

    public int price() {
        return 2000;
    }

    public float D() {
        return 0.001F;
    }

    public int g() {
        return 2;
    }
}
