package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.a.class_1052;
import com.corrodinggames.rts.game.units.a.DisplayType;
import com.corrodinggames.rts.game.units.a.class_226;

// $FF: renamed from: com.corrodinggames.rts.game.units.h.19
final class class_246 extends class_226 {
    class_246(String var1) {
        super(var1);
    }

    public String type() {
        return "Kill units at a point";
    }

    public String b() {
        return "Kill units at";
    }

    public boolean h_() {
        return false;
    }

    public int c() {
        return 0;
    }

    public int b(Unit var1, boolean var2) {
        return -1;
    }

    public UnitType j_() {
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
        return this.j_();
    }
}
