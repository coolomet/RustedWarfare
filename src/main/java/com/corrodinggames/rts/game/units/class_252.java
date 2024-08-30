package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.a.class_1052;
import com.corrodinggames.rts.game.units.a.DisplayType;
import com.corrodinggames.rts.game.units.a.class_226;

// $FF: renamed from: com.corrodinggames.rts.game.units.h.1
final class class_252 extends class_226 {
    class_252(String var1) {
        super(var1);
    }

    public boolean a(Unit var1, boolean var2) {
        return !EditorOrBuilder.w();
    }

    public String type() {
        return "Reload all unit data from disk (for modding)";
    }

    public String b() {
        return "Reload units";
    }

    public int c() {
        return 0;
    }

    public int b(Unit var1, boolean var2) {
        return -1;
    }

    public UnitType g_() {
        return null;
    }

    public class_1052 e() {
        return class_1052.none;
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
        return this.g_();
    }
}
