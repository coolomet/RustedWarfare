package com.corrodinggames.rts.gameFramework.m;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.m.t
public final strictfp class class_923 {
    public int a;
    public class_847[] b;

    public class_923(int var1) {
        if (var1 < 0) {
            throw new IllegalArgumentException("capacity < 0: " + var1);
        } else {
            this.b = var1 == 0 ? new class_847[0] : new class_847[var1];
        }
    }

    public final boolean a(class_847 var1) {
        class_847[] var2 = this.b;
        int var3 = this.a;
        if (var3 == var2.length) {
            class_847[] var4 = new class_847[var3 + (var3 < 6 ? 12 : var3 >> 1)];
            System.arraycopy(var2, 0, var4, 0, var3);
            var2 = var4;
            this.b = var4;
        }

        var2[var3] = var1;
        this.a = var3 + 1;
        return true;
    }
}
