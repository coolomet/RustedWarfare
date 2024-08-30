package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.buildings.LandFactory;
import java.util.ArrayList;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.12
final class class_750 extends UnitType {
    class_750(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public boolean j() {
        return true;
    }

    public boolean C() {
        return true;
    }

    public Unit a(boolean var1) {
        return new LandFactory(var1);
    }

    public void b() {
        LandFactory.b();
    }

    public int price() {
        return 700;
    }

    public int upgradePrice(int var1) {
        return var1 == 2 ? 2000 : 0;
    }

    public float D() {
        return 0.001F;
    }

    public void a(ArrayList var1, int var2) {
        LandFactory.a(var1, var2);
    }
}
