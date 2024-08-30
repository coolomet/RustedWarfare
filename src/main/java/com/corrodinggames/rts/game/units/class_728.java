package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.sea.BuilderShip;
import java.util.ArrayList;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.32
final class class_728 extends UnitType {
    class_728(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public boolean C() {
        return true;
    }

    public Unit a(boolean var1) {
        return new BuilderShip(var1);
    }

    public void b() {
        BuilderShip.t_();
    }

    public int price() {
        return 500;
    }

    public float D() {
        return 0.001F;
    }

    public boolean l() {
        return true;
    }

    public boolean m() {
        return false;
    }

    public void a(ArrayList var1, int var2) {
        BuilderShip.a(var1, var2);
    }
}
