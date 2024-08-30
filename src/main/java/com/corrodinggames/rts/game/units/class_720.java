package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.buildings.CommandCenter;
import java.util.ArrayList;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.45
final class class_720 extends UnitType {
    class_720(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public boolean j() {
        return true;
    }

    public boolean C() {
        return true;
    }

    public Unit a(boolean var1) {
        return new CommandCenter(var1);
    }

    public void b() {
        CommandCenter.b();
    }

    public int price() {
        return 3000;
    }

    public float D() {
        return 5.0E-4F;
    }

    public void a(ArrayList var1, int var2) {
        CommandCenter.a(var1, var2);
    }
}
