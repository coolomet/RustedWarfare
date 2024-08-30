package com.corrodinggames.rts.gameFramework.b;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Paint$Style;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import lombok.SneakyThrows;

import java.util.Iterator;
import java.util.Map;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.b.f
public strictfp class class_476 {
    // maybe error
    class_13 a;
    private Map b;
    private class_474 c;
    private class_475 d;
    private class_30 e;

    public void a(class_468 var1) {
        this.a.c(var1);
    }

    public void a() {
        this.a.d();
    }

    public class_13 b() {
        return this.a;
    }

    public class_468 a(Bitmap var1, TeamImageCache var2, class_30 var3) {
        this.e = var3;
        class_468 var4 = this.a(var1, var2);
        if (var3 instanceof class_478) {
            class_478 var5 = (class_478)var3;
            var4 = var5.a(var4, this.a, new class_640(this));
        }

        return var4;
    }

    public void a(Bitmap var1) {
        class_468 var2 = (class_468)this.b.get(var1);
        if (var2 != null && var2 instanceof class_471) {
            ((class_471)var2).l();
        }

        this.b().a(var1);
    }

    public class_468 a(Bitmap var1, TeamImageCache var2) {
        Object var3 = (class_468)this.b.get(var1);
        if (var3 == null) {
            this.a.e();
            this.c();
            var3 = new class_472(var1);
            ((class_468)var3).c(this.b());
            ((class_468)var3).j = var2.d();
            class_480.b(((class_468)var3).e, ((class_468)var3).f);
            this.b.put(var1, var3);
            this.d();
        }

        return (class_468)var3;
    }

    public void a(float var1, float var2, float var3, class_460 var4) {
        if (var4.c() == Paint$Style.a) {
            this.d.a(0.5F);
        } else {
            float var5 = var4.b();
            if (var5 == 0.0F) {
                var5 = 1.0F;
            }

            this.d.a(var5 / (2.0F * var3));
        }

        this.a.a(var1 - var3, var2 - var3, var3, var4, this.d);
    }

    public void a(float var1, float var2, float var3, float var4, class_460 var5) {
        this.a.a(var1, var2, var3, var4, var5, this.c);
    }

    public void c() {
        this.a.b();
    }

    public void d() {
        this.a.c();
    }

    public void e() {
        Iterator var1 = this.b.values().iterator();

        while(var1.hasNext()) {
            class_468 var2 = (class_468)var1.next();
            var2.j();
        }

        this.b.clear();
    }

    @SneakyThrows
    protected void finalize() {
        super.finalize();
        this.e();
    }

    public void a(int var1, int var2, int var3, int var4) {
        this.a.a(var1, var2, var3, var4);
    }

    public void a(String var1, float var2, float var3, Paint var4) {
        this.a.a(var1, var2, var3, var4);
    }

    public void a(float[] var1, int var2, int var3, class_460 var4) {
        this.a.a(var1, var2, var3, var4, this.c);
    }
}
