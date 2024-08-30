package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.custom.class_591;

// $FF: renamed from: com.corrodinggames.rts.game.units.n.4
final class class_816 extends class_812 {
    class_816(String var1, int var2) {
        super(var1, var2, (class_252)null);
    }

    public boolean a(class_31 var1) {
        if (var1 == null) {
            return false;
        } else if (var1 instanceof class_591) {
            class_591 var2 = (class_591)var1;
            if (var2.J == null) {
                return false;
            } else {
                EditorOrBuilder var3 = EditorOrBuilder.L();
                return var3 == null || var3.E == null || var2.J == var3.E;
            }
        } else {
            return false;
        }
    }
}
