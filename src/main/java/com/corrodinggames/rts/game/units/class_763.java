package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.land.Builder;
import java.util.ArrayList;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.52
final class class_763 extends UnitType {
    class_763(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public boolean C() {
        return true;
    }

    public Unit a(boolean var1) {
        return new Builder(var1);
    }

    public void b() {
        Builder.K();
    }

    public int price() {
        return 500;
    }

    public float D() {
        return 0.002F;
    }

    public boolean l() {
        return true;
    }

    public boolean m() {
        return true;
    }

    public boolean n() {
        return true;
    }

    public void a(ArrayList var1, int var2) {
        Builder.a(var1, var2);
        EditorOrBuilder.a((ArrayList)null, var2);
    }
}
