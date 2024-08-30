package com.corrodinggames.rts.game.units.a;

import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.gameFramework.h.class_1009;

// $FF: renamed from: com.corrodinggames.rts.game.units.a.n
public strictfp class class_235 extends class_226 {
    public class_235() {
        super("c_3");
    }

    public String type() {
        return class_1009.a("gui.actions.repairTarget");
    }

    public String b() {
        return class_1009.a("gui.actions.repairTarget");
    }

    public int c() {
        return 0;
    }

    public int b(Unit var1, boolean var2) {
        return -1;
    }

    public UnitType K() {
        return null;
    }

    public class_1052 e() {
        return class_1052.repairTarget;
    }

    public boolean h_() {
        return true;
    }

    public DisplayType f() {
        return DisplayType.action;
    }

    public boolean g() {
        return false;
    }

    public boolean h() {
        return true;
    }

    // $FF: synthetic method
    public class_31 i() {
        return this.K();
    }
}
