package com.corrodinggames.rts.game.units.a;

import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.gameFramework.f.InterfaceEngine;
import com.corrodinggames.rts.gameFramework.h.class_1009;

// $FF: renamed from: com.corrodinggames.rts.game.units.a.i
public strictfp class class_232 extends class_226 {
    public class_232() {
        super("c_9");
    }

    public int b(Unit var1, boolean var2) {
        return -1;
    }

    public int c() {
        return 0;
    }

    public UnitType w() {
        return null;
    }

    public class_1052 e() {
        return class_1052.patrol;
    }

    public DisplayType f() {
        return DisplayType.none;
    }

    public boolean g() {
        return false;
    }

    public String type() {
        return class_1009.a("gui.actions.patrol.description");
    }

    public String b() {
        return class_1009.a("gui.actions.patrol");
    }

    public boolean s() {
        return true;
    }

    public float l() {
        return !InterfaceEngine.bP ? 0.6F : 0.5F;
    }

    public boolean h() {
        return true;
    }

    public boolean o_() {
        return true;
    }

    // $FF: synthetic method
    public class_31 i() {
        return this.w();
    }
}
