package com.corrodinggames.rts.game.units;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.48
final class class_714 extends UnitType {
    class_714(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public String e() {
        return this.i();
    }

    public String i() {
        return "marker";
    }

    public boolean A() {
        return true;
    }

    public boolean C() {
        return true;
    }

    public Unit a(boolean var1) {
        DummyNonUnitWithTeam var2 = new DummyNonUnitWithTeam(var1);
        return var2;
    }

    public void b() {
        DummyNonUnitWithTeam.b();
    }

    public int price() {
        return 9999;
    }

    public float D() {
        return 1.0F;
    }
}
