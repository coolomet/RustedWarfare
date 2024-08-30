package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.buildings.ExperimentalLandFactory;
import java.util.ArrayList;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.27
final class class_734 extends UnitType {
    class_734(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public boolean j() {
        return true;
    }

    public boolean C() {
        return false;
    }

    public Unit a(boolean var1) {
        return new ExperimentalLandFactory(var1);
    }

    public void b() {
        ExperimentalLandFactory.b();
    }

    public int price() {
        return 11000;
    }

    public float D() {
        return 3.5E-4F;
    }

    public void a(ArrayList var1, int var2) {
        ExperimentalLandFactory.a(var1, var2);
    }
}
