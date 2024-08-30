package com.corrodinggames.rts.game.units;

import java.util.Locale;

// $FF: renamed from: com.corrodinggames.rts.game.units.n.5
final class class_817 extends class_812 {
    class_817(String var1, int var2) {
        super(var1, var2, (class_252)null);
    }

    public boolean a(class_31 var1) {
        EditorOrBuilder var2 = EditorOrBuilder.L();
        if (var2 == null) {
            return false;
        } else if (var2.H == null) {
            return false;
        } else {
            if (var2.I) {
                var2.I = false;
                var2.J = var2.H.toLowerCase().trim();
            }

            if (var1 == null) {
                return false;
            } else if (var1.i() != null && var1.i().toLowerCase(Locale.ROOT).contains(var2.J)) {
                return true;
            } else {
                return var1.i() != null && var1.e().toLowerCase(Locale.ROOT).contains(var2.J);
            }
        }
    }

    public boolean b() {
        EditorOrBuilder var1 = EditorOrBuilder.L();
        if (var1 == null) {
            return false;
        } else {
            return var1.H != null;
        }
    }
}
