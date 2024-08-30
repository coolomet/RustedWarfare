package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.a.class_1052;
import com.corrodinggames.rts.game.units.a.DisplayType;
import com.corrodinggames.rts.game.units.a.class_253;
import com.corrodinggames.rts.gameFramework.f.InterfaceEngine;

// $FF: renamed from: com.corrodinggames.rts.game.units.l
class class_266 extends class_253 {
    boolean a;
    boolean b;

    public class_266(boolean var1, boolean var2) {
        super("changeTypeFilter" + var1 + "d:" + var2);
        this.a = var1;
        this.b = var2;
    }

    public strictfp boolean b(Unit var1) {
        EditorOrBuilder var2 = EditorOrBuilder.L();
        if (var2 != null) {
            return var2.G == class_812.b;
        } else {
            return true;
        }
    }

    public strictfp String b() {
        if (this.b) {
            EditorOrBuilder var1 = EditorOrBuilder.L();
            if (var1 != null) {
                return var1.F != null ? var1.F.type() : "All types";
            } else {
                return "Type Filter";
            }
        } else {
            return this.a ? "<- Set type" : "Set type ->";
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
                return var1.F == null ? "All mods" : var1.F.type();
            }
        }
    }

    public strictfp String type() {
        return "Change filtered type";
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
