package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.sea.AttackSubmarine;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.31
final class class_727 extends UnitType {
    class_727(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public boolean C() {
        return false;
    }

    public Unit a(boolean var1) {
        return new AttackSubmarine(var1);
    }

    public void b() {
        AttackSubmarine.b();
    }

    public int price() {
        return 800;
    }

    public float D() {
        return 0.001F;
    }
}
