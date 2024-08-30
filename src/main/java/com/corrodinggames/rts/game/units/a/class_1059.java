package com.corrodinggames.rts.game.units.a;

import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import java.util.HashMap;

// $FF: renamed from: com.corrodinggames.rts.game.units.a.c
public strictfp class class_1059 {
    private static final HashMap c = new HashMap();
    public static final class_1059 a = a("-1");
    String b;

    public static class_1059 a(String var0) {
        class_1059 var1 = (class_1059)c.get(var0);
        if (var1 != null) {
            return var1;
        } else {
            class_1059 var2 = new class_1059(var0);
            c.put(var0, var2);
            return var2;
        }
    }

    public String a() {
        return this.b;
    }

    private class_1059(String var1) {
        this.b = var1;
    }

    public static void a(GameOutputStream var0, class_1059 var1) {
        String var2 = null;
        if (var1 != null) {
            var2 = var1.b;
        }

        var0.writeIsString(var2);
    }

    public static class_1059 a(GameInputStream var0) {
        String var1 = var0.isReadString();
        return var1 != null ? a(var1) : null;
    }

    public boolean equals(Object var1) {
        return this == var1;
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        return "ActionId(" + this.b + ")";
    }

    public final boolean a(class_1059 var1) {
        return this == var1;
    }
}
