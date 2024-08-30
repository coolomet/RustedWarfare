package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.buildings.SeaFactory;
import java.util.ArrayList;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.34
final class class_730 extends UnitType {
    class_730(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public boolean j() {
        return true;
    }

    public boolean C() {
        return true;
    }

    public Unit a(boolean var1) {
        return new SeaFactory(var1);
    }

    public void b() {
        SeaFactory.b();
    }

    public int price() {
        return 1000;
    }

    public int upgradePrice(int var1) {
        return var1 == 2 ? 2000 : 0;
    }

    public float D() {
        return 7.0E-4F;
    }

    public void a(ArrayList var1, int var2) {
        SeaFactory.a(var1, var2);
    }

    public int a(Unit var1) {
        return 110;
    }
}
