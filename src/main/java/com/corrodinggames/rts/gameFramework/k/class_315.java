package com.corrodinggames.rts.gameFramework.k;

import com.corrodinggames.rts.gameFramework.GameEngine;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.k.m
public final strictfp class class_315 {
    int a;
    int b;
    public static int c;
    final class_329 d;
    final class_317 e = new class_317();

    class_315() {
        short var1 = 1000;
        this.d = new class_329(var1 + 100);

        for(int var2 = 0; var2 < var1; ++var2) {
            this.d.a(new class_322());
        }

    }

    strictfp class_322 a() {
        if (this.d.b == 0) {
            ++c;
            return new class_322();
        } else {
            return this.d.b();
        }
    }

    final strictfp void a(class_322 var1) {
        if (var1 != null) {
            this.d.b(var1);
        }

    }

    strictfp void b() {
        if (this.d.size() > 50000) {
            GameEngine.log("PathOpenList: resetPool:memoryPool over 50000 clearing");
            this.d.clear();
        }

        this.e.a(this);
    }

    public strictfp void a(int var1, int var2) {
        this.b();
        this.a = var1;
        this.b = var2;
    }

    public final strictfp void a(int var1, short var2, short var3) {
        class_322 var4 = this.a();
        var4.a(var2, var3);
        var4.a(var1, this.a, this.b);
        this.e.a(var4);
    }

    public final strictfp class_322 c() {
        class_322 var1 = this.e.a();
        if (var1 != null) {
            this.a(var1);
        }

        return var1;
    }
}
