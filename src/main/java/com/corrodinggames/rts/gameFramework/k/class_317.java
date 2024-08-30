package com.corrodinggames.rts.gameFramework.k;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.k.e
public final strictfp class class_317 extends class_316 {
    boolean a;
    int b;
    final class_329 c = new class_329(100);
    final class_329 d = new class_329(900);

    public strictfp void a(class_322 var1) {
        int var2 = var1.c;
        if (var2 <= this.b) {
            if (var2 == this.b) {
                this.c.b(var1);
            } else {
                this.c();
                this.b = var2;
                this.c.a(var1);
            }
        } else {
            this.d.b(var1);
        }
    }

    public strictfp class_322 a() {
        long var1 = -1L;

        try {
            class_322 var3;
            if (this.c.b > 0) {
                var3 = this.c.b();
                return var3;
            } else if (this.d.b == 0) {
                this.b = Integer.MAX_VALUE;
                var3 = null;
                return var3;
            } else {
                this.d();
                var3 = this.c.b();
                return var3;
            }
        } finally {
            ;
        }
    }

    public strictfp void b() {
        this.a((class_315)null);
    }

    public strictfp void a(class_315 var1) {
        if (var1 != null) {
            class_322[] var2 = this.c.a();

            for(int var3 = this.c.b - 1; var3 >= 0; --var3) {
                class_322 var4 = var2[var3];
                var1.a(var4);
            }

            class_322[] var6 = this.d.a();

            for(int var7 = this.d.b - 1; var7 >= 0; --var7) {
                class_322 var5 = var6[var7];
                var1.a(var5);
            }
        }

        this.c.clear();
        this.d.clear();
        this.b = Integer.MAX_VALUE;
        this.a = true;
    }

    private strictfp void c() {
        class_322[] var1 = this.c.a();
        int var2 = 0;

        for(int var3 = this.c.b; var2 < var3; ++var2) {
            class_322 var4 = var1[var2];
            this.d.a(var4);
        }

        this.c.clear();
    }

    private strictfp void d() {
        long var1 = -1L;
        int var3 = Integer.MAX_VALUE;
        class_329 var4 = this.d;
        class_322[] var5 = var4.a();

        int var6;
        class_322 var7;
        int var8;
        for(var6 = var4.b - 1; var6 >= 0; --var6) {
            var7 = var5[var6];
            var8 = var7.c;
            if (var8 < var3) {
                var3 = var8;
            }
        }

        for(var6 = var4.b - 1; var6 >= 0; --var6) {
            var7 = var5[var6];
            if (var7.c == var3) {
                this.c.a(var7);
                var8 = var4.b - 1;
                var5[var6] = var5[var8];
                var5[var8] = null;
                var4.b = var8;
            }
        }

        this.b = var3;
    }
}
