package com.corrodinggames.rts.gameFramework.f;

import com.corrodinggames.rts.gameFramework.class_340;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.f.au
abstract class class_512 implements Comparable {
    long c;
    long d = 5000L;
    float e;
    float f;
    String g;
    boolean h;
    boolean i;

    public class_512(float var1, float var2) {
        this.e = var1;
        this.f = var2;
    }

    public strictfp int c(class_512 var1) {
        return (int)(var1.c - this.c);
    }

    public strictfp boolean a(class_512 var1) {
        if (this.c + this.b() < System.currentTimeMillis()) {
            return false;
        } else {
            float var2 = class_340.a(this.e, this.f, var1.e, var1.f);
            return !(var2 > 90000.0F);
        }
    }

    protected strictfp long b() {
        return 5000L;
    }

    public abstract void b(class_512 var1);

    public abstract String type();

    // $FF: synthetic method
    public int compareTo(Object var1) {
        return this.c((class_512)var1);
    }
}
