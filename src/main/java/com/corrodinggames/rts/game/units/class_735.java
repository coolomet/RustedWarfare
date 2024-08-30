package com.corrodinggames.rts.game.units;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.28
final class class_735 extends UnitType {
    class_735(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public boolean j() {
        return true;
    }

    public boolean C() {
        return true;
    }

    public Unit a(boolean var1) {
        return new CrystalResource(var1);
    }

    public void b() {
        CrystalResource.a_();
    }

    public int price() {
        return 5000;
    }

    public float D() {
        return 0.001F;
    }
}
