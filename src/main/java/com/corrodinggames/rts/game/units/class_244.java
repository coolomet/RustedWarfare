package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.a.class_1052;
import com.corrodinggames.rts.game.units.a.DisplayType;
import com.corrodinggames.rts.game.units.a.class_226;

// $FF: renamed from: com.corrodinggames.rts.game.units.h.17
final class class_244 extends class_226 {
    class_244(String var1) {
        super(var1);
    }

    public String type() {
        return "Clones units at point x50";
    }

    public String b() {
        return "Unit Clone";
    }

    public int c() {
        return 0;
    }

    public int b(Unit var1, boolean var2) {
        return -1;
    }

    public UnitType k() {
        return null;
    }

    public class_1052 e() {
        return class_1052.targetGround;
    }

    public DisplayType f() {
        return DisplayType.action;
    }

    public boolean g() {
        return false;
    }

    public boolean a(Unit var1, boolean var2) {
        return true;
    }

    public boolean h() {
        return true;
    }

    // $FF: synthetic method
    public class_31 i() {
        return this.k();
    }
}
