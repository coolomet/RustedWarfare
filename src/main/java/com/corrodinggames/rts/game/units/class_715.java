package com.corrodinggames.rts.game.units;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.40
final class class_715 extends UnitType {
    class_715(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public boolean C() {
        return true;
    }

    public Unit a(boolean var1) {
        SpreadingFire var2 = new SpreadingFire(var1);
        return var2;
    }

    public void b() {
        SpreadingFire.b();
    }

    public int price() {
        return 1000;
    }

    public float D() {
        return 6.0E-4F;
    }
}
