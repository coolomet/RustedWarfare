package com.corrodinggames.rts.gameFramework.d;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.GameObject;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;

public strictfp class Emitter extends GameObject {
    public float a;
    public boolean b = true;
    float c;
    float d;
    float e;
    float f;
    float g;
    float h;
    class_998 i;
    public int j = 0;
    public int k = 0;
    public int l = -1;
    float m;
    float n;
    float o;
    float p;
    float q;
    float r;
    Priority s;
    public float t;
    public boolean u = false;
    static class_998 v;
    static class_998 w;
    private final class_986 x;

    public static strictfp void load() {
        class_986 var0 = GameEngine.getGameEngine().bR;
        class_998 var1 = new class_998(var0);
        a(var1, false);
        var1.aq = 18;
        var1.t = 15.0F;
        v = var1;
        var1 = new class_998(var0);
        b(var1, false);
        w = var1;
    }

    public strictfp void a(GameOutputStream var1) {
        var1.writeFloat(this.xCord);
        var1.writeFloat(this.yCord);
        var1.writeFloat(this.a);
        super.a(var1);
    }

    public strictfp void a(GameInputStream var1) {
        this.xCord = var1.readFloat();
        this.yCord = var1.readFloat();
        this.a = var1.readFloat();
        this.b = false;
        super.a(var1);
    }

    public Emitter(class_986 var1) {
        this.x = var1;
    }

    public static strictfp void a(class_998 var0, boolean var1) {
        var0.c();
        var0.aq = 5;
        if (var1) {
            var0.ap = class_340.rand(0, 1);
        } else {
            var0.ap = 0;
        }

        var0.Y = 0.0F;
        var0.an = true;
        var0.P = 0.1F;
        var0.R = 0.5F;
        var0.u = true;
        var0.V = 300.0F;
        var0.W = var0.V;
        var0.r = true;
        var0.s = true;
        var0.t = 40.0F;
        var0.as = false;
        var0.ar = 2;
        var0.G = 0.4F;
        var0.F = 1.5F;
        var0.g = class_998.k;
    }

    public static strictfp void b(class_998 var0, boolean var1) {
        var0.c();
        var0.aq = 7;
        if (var1) {
            var0.ap = class_340.rand(0, 3);
        } else {
            var0.ap = 0;
        }

        var0.Y = 0.0F;
        var0.an = true;
        var0.P = 0.0F;
        var0.R = 0.2F;
        var0.u = true;
        var0.V = 50.0F;
        var0.W = var0.V;
        var0.r = true;
        var0.s = true;
        var0.t = 10.0F;
        var0.as = false;
        var0.ar = 2;
        var0.g = class_998.n;
    }

    public static strictfp Emitter a(float var0, float var1) {
        Emitter var2 = a(var0, var1, v);
        var2.a = 280.0F;
        var2.f = 10.0F;
        var2.c = 10.0F;
        var2.m = 0.03F;
        var2.n = 0.03F;
        var2.p = 6.0F;
        var2.q = 6.0F;
        var2.s = Priority.verylow;
        var2.r = 180.0F;
        var2.j = -16777216;
        return var2;
    }

    public static strictfp Emitter b(float var0, float var1) {
        Emitter var2 = a(var0, var1, w);
        var2.a = 330.0F;
        var2.f = 10.0F;
        var2.c = 10.0F;
        var2.m = 0.1F;
        var2.n = 0.03F;
        var2.p = 4.0F;
        var2.q = 4.0F;
        var2.s = Priority.verylow;
        return var2;
    }

    public static strictfp Emitter a(float var0, float var1, class_998 var2) {
        class_986 var3 = GameEngine.getGameEngine().bR;
        Emitter var4 = new Emitter(var3);
        var4.xCord = var0;
        var4.yCord = var1;
        var4.a = 100.0F;
        var4.f = 10.0F;
        var4.i = var2;
        if (var2 == null) {
            var4.i = new class_998(var3);
            GameEngine.print("Error: Emitter create srcEffect==null");
        }

        return var4;
    }

    public strictfp boolean c() {
        GameEngine var1 = GameEngine.getGameEngine();
        return var1.cP.b(this.xCord, this.yCord);
    }

    public strictfp void a(float var1) {
        this.t = class_340.a(this.t, var1);
        if (!(this.t > 0.0F)) {
            if (this.b) {
                this.c += var1;
                boolean var2 = false;
                if (this.c > this.f) {
                    this.d += var1;
                    if (this.d > this.g) {
                        this.d = 0.0F;
                        ++this.e;
                        if (this.e > this.h) {
                            this.c = 0.0F;
                            this.e = 0.0F;
                        }

                        if (this.u || this.c()) {
                            class_998 var3 = this.x.b(this.xCord, this.yCord, 0.0F, class_989.CUSTOM, false, this.s);
                            if (var3 != null) {
                                var3.a(this.i);
                                var3.P += class_340.c(-this.m, this.m);
                                var3.Q += class_340.c(-this.n, this.n);
                                var3.R += class_340.c(-this.o, this.o);
                                var3.Y = class_340.c(-this.r, this.r);
                                var3.I = this.xCord;
                                var3.J = this.yCord;
                                var3.I += class_340.c(-this.p, this.p);
                                var3.J += class_340.c(-this.q, this.q);
                                if (this.j != 0) {
                                    var3.x = this.j;
                                }

                                if (this.l >= 0) {
                                    var3.y = this.k;
                                    var3.z = (float)this.l;
                                }
                            }
                        }
                    }
                }
            }

            this.a -= var1;
            if (this.a < 0.0F) {
                this.a();
            }

        }
    }

    public strictfp boolean a(GameEngine var1) {
        return false;
    }

    public strictfp boolean c(float var1) {
        return false;
    }

    public strictfp void e(float var1) {
    }

    public strictfp void a(float var1, boolean var2) {
    }

    public strictfp void d(float var1) {
    }

    public strictfp boolean f(float var1) {
        return false;
    }
}
