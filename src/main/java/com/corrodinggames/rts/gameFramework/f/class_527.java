package com.corrodinggames.rts.gameFramework.f;

import android.graphics.Paint;
import android.graphics.RectF;
import com.corrodinggames.rts.gameFramework.m.class_28;
import com.corrodinggames.rts.gameFramework.m.class_526;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.f.s
public strictfp class class_527 extends class_526 {
    float[] a;
    int b = 0;
    Paint c;
    int d;
    boolean e;
    private final RectF f = new RectF();

    class_527(int var1, Paint var2) {
        this.d = var1;
        this.a = new float[var1 * 2];
        this.c = var2;
    }

    public final void a(float var1, float var2) {
        this.a[this.b] = var1;
        this.a[this.b + 1] = var2;
        this.b += 2;
    }

    public void a(class_28 var1) {
        if (!this.e) {
            var1.a(this.a, 0, this.b, this.c);
        } else {
            RectF var2 = this.f;
            float var3 = this.c.g();

            for(int var4 = 0; var4 < this.b; ++var4) {
                float var5 = this.a[var4];
                float var6 = this.a[var4 + 1];
                var2.a = var5;
                var2.b = var6;
                var2.c = var5 + var3;
                var2.d = var6 + var3;
                var1.a(var2, this.c);
            }
        }

        class_537.a(this);
    }
}
