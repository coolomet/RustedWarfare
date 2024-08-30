package com.corrodinggames.rts.game.units;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.20
final class class_737 extends UnitType {
    class_737(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public boolean C() {
        return true;
    }

    public Unit a(boolean var1) {
        return new Tree(var1);
    }

    public void b() {
        Tree.b();
    }

    public int price() {
        return 0;
    }

    public float D() {
        return 0.0025F;
    }
}
