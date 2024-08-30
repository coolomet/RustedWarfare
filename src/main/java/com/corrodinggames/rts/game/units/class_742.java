package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.sea.BattleShip;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.14
final class class_742 extends UnitType {
    class_742(String var1, int var2) {
        super(var1, var2, (class_754)null);
    }

    public boolean C() {
        return false;
    }

    public Unit a(boolean var1) {
        return new BattleShip(var1);
    }

    public void b() {
        BattleShip.f();
    }

    public int price() {
        return 1500;
    }

    public float D() {
        return 0.001F;
    }
}
