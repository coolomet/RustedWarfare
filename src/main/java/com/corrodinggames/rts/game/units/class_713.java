package com.corrodinggames.rts.game.units;

import java.util.ArrayList;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.47
final class class_713 extends UnitType {
    class_713(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public boolean A() {
        return true;
    }

    public boolean C() {
        return true;
    }

    public Unit a(boolean var1) {
        return new EditorOrBuilder(var1);
    }

    public void b() {
        EditorOrBuilder.K();
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
        return false;
    }

    public boolean n() {
        return false;
    }

    public void a(ArrayList var1, int var2) {
    }
}
