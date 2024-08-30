package com.corrodinggames.rts.gameFramework.g;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.g.d
public abstract strictfp class class_165 implements Comparable {
    private int a;

    public void b(class_173 var1) {
        this.a = this.a(var1);
    }

    public abstract String b();

    public abstract boolean a();

    public abstract int c();

    public abstract int d();

    public abstract int a(class_173 var1);

    public int a(class_165 var1) {
        return this.a == var1.a ? this.b().compareTo(var1.b()) : var1.a - this.a;
    }

    // $FF: synthetic method
    public int compareTo(Object var1) {
        return this.a((class_165)var1);
    }

    // $FF: synthetic method
    static int b(class_165 var0) {
        return var0.a;
    }
}
