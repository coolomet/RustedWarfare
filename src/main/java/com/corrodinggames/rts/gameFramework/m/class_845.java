package com.corrodinggames.rts.gameFramework.m;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import java.util.concurrent.locks.Lock;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.m.o
public final strictfp class class_845 extends class_844 {
    class_27 a = new class_839((Canvas)null);
    int b;
    final class_684 c = new class_684();
    final class_921 d = new class_921(Paint.class);
    final class_921 e = new class_921(Rect.class);
    final class_921 f = new class_921(RectF.class);
    final class_921 g = new class_921(Matrix.class);
    final class_921 h = new class_921(class_846.class);
    final class_923 i = new class_923(200);
    int j = 0;
    volatile boolean k = false;

    public class_845() {
        this.c.add(this.d);
        this.c.add(this.e);
        this.c.add(this.f);
        this.c.add(this.g);
        this.c.add(this.h);
    }

    public final class_847 a(class_848 var1, Object var2, Object var3, Object var4, Object var5, Object var6, Object var7, Object var8, Object var9) {
        class_923 var10 = this.i;
        int var11 = this.j;
        if (var11 >= var10.a) {
            var10.a(new class_847(this));
        }

        class_847 var12 = var10.b[var11];
        var12.a = var1;
        Object[] var13 = var12.b;
        var13[0] = var2;
        var13[1] = var3;
        var13[2] = var4;
        var13[3] = var5;
        var13[4] = var6;
        var13[5] = var7;
        var13[6] = var8;
        var13[7] = var9;
        ++this.j;
        return var12;
    }

    public final void a(class_848 var1, Object var2, Object var3, Object var4, Object var5) {
        class_923 var6 = this.i;
        int var7 = this.j;
        if (var7 >= var6.a) {
            var6.a(new class_847(this));
        }

        class_847 var8 = var6.b[var7];
        var8.a = var1;
        Object[] var9 = var8.b;
        var9[0] = var2;
        var9[1] = var3;
        var9[2] = var4;
        var9[3] = var5;
        ++this.j;
    }

    public final void a(class_848 var1, Object var2, Object var3) {
        class_923 var4 = this.i;
        int var5 = this.j;
        if (var5 >= var4.a) {
            var4.a(new class_847(this));
        }

        class_847 var6 = var4.b[var5];
        var6.a = var1;
        Object[] var7 = var6.b;
        var7[0] = var2;
        var7[1] = var3;
        ++this.j;
    }

    public final class_847 a(class_848 var1) {
        class_923 var2 = this.i;
        int var3 = this.j;
        if (var3 >= var2.a) {
            var2.a(new class_847(this));
        }

        class_847 var4 = var2.b[var3];
        var4.a = var1;
        ++this.j;
        return var4;
    }

    public void a(boolean var1) {
        this.k = var1;
    }

    public boolean c() {
        return this.k;
    }

    public void a(Rect var1) {
        var1 = this.e.a(var1);
        this.a(class_848.g, var1, (Object)null, (Object)null, (Object)null, (Object)null, (Object)null, (Object)null, (Object)null);
    }

    public void a(RectF var1) {
        var1 = this.f.a(var1);
        this.a(class_848.i, var1, (Object)null, (Object)null, (Object)null, (Object)null, (Object)null, (Object)null, (Object)null);
    }

    public void a(TeamImageCache var1, float var2, float var3, Paint var4) {
        if (!(var4 instanceof class_525)) {
            var4 = this.d.a(var4);
        }

        class_847 var5 = this.a(class_848.m);
        var5.b[0] = var1;
        var5.b[1] = var4;
        var5.c = var2;
        var5.d = var3;
    }

    public void a(TeamImageCache var1, Rect var2, Rect var3, Paint var4) {
        var2 = this.e.a(var2);
        var3 = this.e.a(var3);
        if (!(var4 instanceof class_525)) {
            var4 = this.d.a(var4);
        }

        this.a(class_848.o, var1, var2, var3, var4);
    }

    public void a(TeamImageCache var1, Rect var2, RectF var3, Paint var4) {
        var2 = this.e.a(var2);
        var3 = this.f.a(var3);
        if (!(var4 instanceof class_525)) {
            var4 = this.d.a(var4);
        }

        this.a(class_848.p, var1, var2, var3, var4);
    }

    public void a(float var1, float var2, float var3, Paint var4) {
        if (!(var4 instanceof class_525)) {
            var4 = this.d.a(var4);
        }

        this.a(class_848.t, var1, var2, var3, var4);
    }

    public void a(int var1, PorterDuff.Mode var2) {
        this.a(class_848.u, var1, var2);
    }

    public void a(int var1) {
        this.a(class_848.v, var1, (Object)null, (Object)null, (Object)null, (Object)null, (Object)null, (Object)null, (Object)null);
    }

    public void a(float var1, float var2, float var3, float var4, Paint var5) {
        if (!(var5 instanceof class_525)) {
            var5 = this.d.a(var5);
        }

        class_847 var6 = this.a(class_848.w);
        var6.c = var1;
        var6.d = var2;
        var6.e = var3;
        var6.f = var4;
        var6.b[0] = var5;
    }

    public void a(float[] var1, int var2, int var3, Paint var4) {
        if (!(var4 instanceof class_525)) {
            var4 = this.d.a(var4);
        }

        this.a(class_848.G, var1, var2, var3, var4, (Object)null, (Object)null, (Object)null, (Object)null);
    }

    public void a(Rect var1, Paint var2) {
        var1 = this.e.a(var1);
        if (!(var2 instanceof class_525)) {
            var2 = this.d.a(var2);
        }

        this.a(class_848.M, var1, var2);
    }

    public void a(RectF var1, Paint var2) {
        var1 = this.f.a(var1);
        if (!(var2 instanceof class_525)) {
            var2 = this.d.a(var2);
        }

        this.a(class_848.N, var1, var2);
    }

    public void a(String var1, float var2, float var3, Paint var4) {
        if (!(var4 instanceof class_525)) {
            var4 = this.d.a(var4);
        }

        this.a(class_848.R, var1, var2, var3, var4, (Object)null, (Object)null, (Object)null, (Object)null);
    }

    public void a() {
        this.a(class_848.W);
        --this.b;
        if (this.b < 0) {
            GameEngine.warn("saveStackSize: " + this.b);
        }

    }

    public void a(float var1, float var2, float var3) {
        class_847 var4 = this.a(class_848.Z);
        var4.c = var1;
        var4.d = var2;
        var4.e = var3;
    }

    public void b() {
        this.a(class_848.aa);
        ++this.b;
        if (this.b <= 0) {
            GameEngine.warn("saveStackSize (on save): " + this.b);
        }

    }

    public void a(float var1, float var2) {
        class_847 var3 = this.a(class_848.af);
        var3.c = var1;
        var3.d = var2;
    }

    public void a(float var1, float var2, float var3, float var4) {
        class_847 var5 = this.a(class_848.ag);
        var5.c = var1;
        var5.d = var2;
        var5.e = var3;
        var5.f = var4;
    }

    public void a(TeamImageCache var1) {
        this.a(class_848.ah, var1, (Object)null, (Object)null, (Object)null, (Object)null, (Object)null, (Object)null, (Object)null);
    }

    public void b(float var1, float var2) {
        class_847 var3 = this.a(class_848.am);
        var3.c = var1;
        var3.d = var2;
    }

    public void a(class_526 var1) {
        this.a(class_848.an, this, var1);
    }

    public void a(Bitmap var1) {
        this.a(class_848.ap, var1, (Object)null);
    }

    public void a(Lock var1) {
        this.a(class_848.aq, var1, (Object)null);
    }

    public void b(Lock var1) {
        this.a(class_848.ar, var1, (Object)null);
    }

    public boolean a(Shader var1) {
        this.a(class_848.as, var1, (Object)null);
        return true;
    }
}
