package com.corrodinggames.rts.game.units;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.46
final class class_721 extends UnitType {
    class_721(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public boolean A() {
        return true;
    }

    public boolean C() {
        return true;
    }

    public Unit a(boolean var1) {
        DamagingBorder var2 = new DamagingBorder(var1);
        var2.q = true;
        return var2;
    }

    public void b() {
        DamagingBorder.d_();
    }

    public int price() {
        return 1000;
    }

    public float D() {
        return 6.0E-4F;
    }
}
