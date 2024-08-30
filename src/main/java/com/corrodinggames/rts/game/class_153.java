package com.corrodinggames.rts.game;

// $FF: renamed from: com.corrodinggames.rts.game.t
public strictfp class class_153 {
    public static final class_150[] a = new class_150[0];
    class_150[] b;
    int c;

    public class_153() {
        this.b = a;
        this.c = 0;
    }

    public boolean a(class_150 var1) {
        class_150[] var2 = this.b;
        int var3 = this.c;
        if (var3 == var2.length) {
            class_150[] var4 = new class_150[var3 + (var3 < 6 ? 12 : var3 >> 1)];
            System.arraycopy(var2, 0, var4, 0, var3);
            var2 = var4;
            this.b = var4;
        }

        var2[var3] = var1;
        this.c = var3 + 1;
        return true;
    }
}
