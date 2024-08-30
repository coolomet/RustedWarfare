package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.a.class_1052;
import com.corrodinggames.rts.game.units.a.DisplayType;
import com.corrodinggames.rts.game.units.a.class_253;
import com.corrodinggames.rts.gameFramework.f.InterfaceEngine;

// $FF: renamed from: com.corrodinggames.rts.game.units.j
class class_268 extends class_253 {
    boolean a;
    boolean b;

    public class_268(boolean var1, boolean var2) {
        super("changeModFilter" + var1 + "d:" + var2);
        this.a = var1;
        this.b = var2;
    }

    public strictfp boolean b(Unit var1) {
        EditorOrBuilder var2 = EditorOrBuilder.L();
        if (var2 != null) {
            return var2.G == class_812.d;
        } else {
            return true;
        }
    }

    public strictfp String b() {
        if (this.b) {
            EditorOrBuilder var1 = EditorOrBuilder.L();
            if (var1 != null) {
                return var1.E != null ? var1.E.modName() : "All mods";
            } else {
                return "Mod Filter";
            }
        } else {
            return this.a ? "<- Set mod" : "Set mod ->";
        }
    }

    public strictfp String d() {
        if (!this.b) {
            return this.a ? "<-" : "->";
        } else {
            EditorOrBuilder var1 = EditorOrBuilder.L();
            if (var1 == null) {
                return "NA";
            } else {
                return var1.E == null ? "All mods" : var1.E.b();
            }
        }
    }

    public strictfp String type() {
        return "Change filtered mod";
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
