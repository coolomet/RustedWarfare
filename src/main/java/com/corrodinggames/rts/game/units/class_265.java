package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.a.class_1052;
import com.corrodinggames.rts.game.units.a.DisplayType;
import com.corrodinggames.rts.game.units.a.class_253;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.f.InterfaceEngine;

// $FF: renamed from: com.corrodinggames.rts.game.units.m
class class_265 extends class_253 {
    boolean a;
    boolean b;

    public class_265(boolean var1, boolean var2) {
        super("changeUnitTab" + var1 + "d:" + var2);
        this.a = var1;
        this.b = var2;
    }

    public strictfp String b() {
        return this.d();
    }

    public strictfp String d() {
        EditorOrBuilder var1 = EditorOrBuilder.L();
        if (var1 == null) {
            return "<NULL>";
        } else if (this.b) {
            return var1.G.type();
        } else {
            String var2 = "";
            if (this.a) {
                var2 = var2 + "<- ";
            }

            if (!this.a) {
                var2 = var2 + " ->";
            }

            return var2;
        }
    }

    public strictfp void n() {
        EditorOrBuilder var1 = EditorOrBuilder.L();
        if (var1 == null) {
            GameEngine.print("Editor not active");
        } else if (!this.b) {
            var1.G = var1.G.a(this.a);
        }
    }

    public strictfp String type() {
        return "Change unit tab in editor";
    }

    public strictfp float l() {
        return !InterfaceEngine.bP ? 0.8F : 0.5F;
    }

    public strictfp int m() {
        return this.b ? 2 : 4;
    }

    public strictfp DisplayType f() {
        return this.b ? DisplayType.infoOnly : super.f();
    }

    public strictfp class_1052 e() {
        return this.b ? class_1052.infoOnly : super.e();
    }
}
