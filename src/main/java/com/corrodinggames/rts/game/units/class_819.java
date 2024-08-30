package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.gameFramework.GameEngine;

// $FF: renamed from: com.corrodinggames.rts.game.units.o
public abstract strictfp class class_819 {
    public static final class_819 a = new class_820("land", 0);
    public static final class_819 b = new class_821("air", 1);
    public static final class_819 c = new class_822("sea", 2);
    public static final class_819 d = new class_823("buildings", 3);
    public static final class_819 e = new class_824("bio", 4);
    // $FF: synthetic field
    private static final class_819[] f = new class_819[]{a, b, c, d, e};

    public static strictfp class_819[] values() {
        return (class_819[])f.clone();
    }

    private final String name;
    private final int ordinal;
    private class_819(String var1, int var2) {
        name = var1;
        ordinal = var2;
    }

    public abstract boolean a(class_31 var1);

    public strictfp String type() {
        return this.name;
    }

    public strictfp class_819 a(boolean var1) {
        return !var1 ? this.a(1, 0) : this.a(-1, 0);
    }

    public strictfp class_819 a(int var1, int var2) {
        int var3 = this.ordinal + var1;
        var3 %= values().length;
        if (var3 < 0) {
            var3 += values().length;
        }

        class_819 var4 = values()[var3];
        if (!var4.b()) {
            if (var2 > 30) {
                GameEngine.log("jumpBy recursion limit hit");
                return var4;
            }

            var4 = var4.a(var1, var2 + 1);
        }

        return var4;
    }

    public strictfp boolean b() {
        return true;
    }

    // $FF: synthetic method
    class_819(String var1, int var2, class_252 var3) {
        this(var1, var2);
    }
}
