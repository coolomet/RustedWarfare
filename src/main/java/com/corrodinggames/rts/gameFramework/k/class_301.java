package com.corrodinggames.rts.gameFramework.k;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.k.g
public strictfp class class_301 {
    int a;
    int b;
    int c;
    int d;
    byte[] e;
    byte[] f;

    public class_301(int var1, int var2) {
        this.a = var1;
        this.b = var2;
        this.e = new byte[var1 * var2];
        this.f = new byte[var1 * var2];
    }

    public final byte a(int var1, int var2) {
        return this.e[var1 * this.b + var2];
    }

    public final byte a(class_319 var1) {
        return this.e[var1.a * this.b + var1.b];
    }

    public boolean b(class_319 var1) {
        return this.a(var1) <= 0;
    }

    public void a(class_319 var1, byte var2) {
        this.e[var1.a * this.b + var1.b] = var2;
    }

    public void a(class_319 var1, boolean var2) {
        this.f[var1.a * this.b + var1.b] = (byte)(var2 ? 1 : 0);
    }

    public boolean c(class_319 var1) {
        return this.f[var1.a * this.b + var1.b] == 1;
    }
}
