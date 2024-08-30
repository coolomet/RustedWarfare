package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.gameFramework.GameEngine;

// $FF: renamed from: com.corrodinggames.rts.game.units.n
public abstract strictfp class class_812 {
    public static final class_812 a = new class_813("all", 0);
    public static final class_812 b = new class_814("types", 1);
    public static final class_812 c = new class_815("terrain", 2);
    public static final class_812 d = new class_816("modded", 3);
    public static final class_812 e = new class_817("search", 4);
    public static final class_812 f = new class_818("actions", 5);
    // $FF: synthetic field
    private static final class_812[] g = new class_812[]{a, b, c, d, e, f};

    public static strictfp class_812[] values() {
        return (class_812[])g.clone();
    }
    private final String name;
    private final int ordinal;
    private class_812(String var1, int var2) {
        name = var1;
        ordinal = var2;
    }

    public abstract boolean a(class_31 var1);

    public strictfp String type() {
        return name;
    }

    public strictfp boolean b() {
        return true;
    }

    public strictfp class_812 a(boolean var1) {
        return !var1 ? this.a(1, 0) : this.a(-1, 0);
    }

    public strictfp class_812 a(int var1, int var2) {
        int var3 = this.ordinal + var1;
        var3 %= values().length;
        if (var3 < 0) {
            var3 += values().length;
        }

        class_812 var4 = values()[var3];
        if (!var4.b()) {
            if (var2 > 30) {
                GameEngine.log("jumpBy recursion limit hit");
                return var4;
            }

            var4 = var4.a(var1, var2 + 1);
        }

        return var4;
    }

    // $FF: synthetic method
    class_812(String var1, int var2, class_252 var3) {
        this(var1, var2);
    }
}
