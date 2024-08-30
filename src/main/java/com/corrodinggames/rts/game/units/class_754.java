package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.buildings.Extractor;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.1
final class class_754 extends UnitType {
    class_754(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public boolean j() {
        return true;
    }

    public boolean C() {
        return true;
    }

    public Unit a(boolean var1) {
        return new Extractor(var1);
    }

    public void b() {
        Extractor.K();
    }

    public int price() {
        return 700;
    }

    public int upgradePrice(int var1) {
        if (var1 == 2) {
            return 1200;
        } else {
            return var1 == 3 ? 2500 : 0;
        }
    }

    public boolean p() {
        return true;
    }

    public float D() {
        return 0.001F;
    }

    public int a(Unit var1) {
        return var1.cJ() ? 110 : 0;
    }
}
