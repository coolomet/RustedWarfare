package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.a.class_231;
import com.corrodinggames.rts.game.units.a.class_661;

// $FF: renamed from: com.corrodinggames.rts.game.units.h.16
final class class_662 extends class_661 {
    public boolean isAvailable(class_226 var1, Unit var2) {
        if (var1 instanceof class_231) {
            var1 = ((class_231)var1).q_();
        }

        EditorOrBuilder var3 = EditorOrBuilder.L();
        if (var3 == null) {
            return true;
        } else {
            class_812 var4 = var3.G;
            if (var4 == null) {
                var4 = class_812.a;
            }

            if (var4 == class_812.a && EditorOrBuilder.a(var1, var2)) {
                return false;
            } else if (var4 == class_812.d && var1 == EditorOrBuilder.h) {
                return true;
            } else if (var4 == class_812.d && var1 == EditorOrBuilder.i) {
                return true;
            } else if (var4 == class_812.e && var1 == EditorOrBuilder.y) {
                return true;
            } else if (var1 == EditorOrBuilder.B && !EditorOrBuilder.B.b(var2)) {
                return false;
            } else if (var1 == EditorOrBuilder.C && !EditorOrBuilder.C.b(var2)) {
                return false;
            } else {
                class_31 var5 = var1.i();
                return var4.a(var5);
            }
        }
    }
}
