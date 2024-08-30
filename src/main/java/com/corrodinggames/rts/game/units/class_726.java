package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.buildings.Fabricator;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.30
final class class_726 extends UnitType {
    class_726(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public boolean j() {
        return true;
    }

    public boolean C() {
        return true;
    }

    public Unit a(boolean var1) {
        return new Fabricator(var1);
    }

    public void b() {
        Fabricator.K();
    }

    public int price() {
        return 1500;
    }

    public int upgradePrice(int var1) {
        if (var1 == 2) {
            return 3000;
        } else {
            return var1 == 3 ? 5000 : 0;
        }
    }

    public float D() {
        return 6.0E-4F;
    }
}
