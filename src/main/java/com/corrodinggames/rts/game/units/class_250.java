package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.a.class_1052;
import com.corrodinggames.rts.game.units.a.DisplayType;
import com.corrodinggames.rts.game.units.a.class_226;

// $FF: renamed from: com.corrodinggames.rts.game.units.q
class class_250 extends class_226 {
    class_143 a;

    public class_250(class_143 var1) {
        super("SetTerrainType" + var1.ordinal());
        this.a = var1;
    }

    public boolean b(Unit var1) {
        EditorOrBuilder var2 = EditorOrBuilder.L();
        if (var2 != null) {
            return var2.G == class_812.c;
        } else {
            return true;
        }
    }

    public String type() {
        return "Set terrain type to: " + this.a.name();
    }

    public String b() {
        return "Set " + this.a.name();
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

    public UnitType n() {
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

    public boolean o() {
        return true;
    }

    public boolean a(float var1, float var2) {
        return true;
    }

    public boolean p() {
        return true;
    }

    // $FF: synthetic method
    public class_31 i() {
        return this.n();
    }
}
