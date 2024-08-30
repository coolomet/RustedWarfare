package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.buildings.AirFactory;
import java.util.ArrayList;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.23
final class class_740 extends UnitType {
    class_740(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public boolean j() {
        return true;
    }

    public boolean C() {
        return true;
    }

    public Unit a(boolean var1) {
        return new AirFactory(var1);
    }

    public void b() {
        AirFactory.b();
    }

    public int price() {
        return 1000;
    }

    public int upgradePrice(int var1) {
        return var1 == 2 ? 1500 : 0;
    }

    public float D() {
        return 0.001F;
    }

    public void a(ArrayList var1, int var2) {
        AirFactory.a(var1, var2);
    }
}
