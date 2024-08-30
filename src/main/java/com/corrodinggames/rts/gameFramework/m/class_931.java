package com.corrodinggames.rts.gameFramework.m;

import android.graphics.Rect;
import android.graphics.RectF;
import javax.microedition.khronos.opengles.GL10;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.m.b
public strictfp class class_931 {
    class_838 a;
    TeamImageCache b;
    float c;
    float d;
    Rect e;
    RectF f;
    // $FF: synthetic field
    // maybe error maybe
    class_933 g;

    void a(GL10 var1) {
        if (this.g.i != this.b.h) {
            var1.glBindTexture(3553, this.b.h);
            this.g.i = this.b.h;
        }

        var1.glPushMatrix();
        var1.glLoadIdentity();
        if (this.a != class_838.RECT) {
            var1.glTranslatef(this.c, this.g.c - this.d - (float)this.b.l(), 0.0F);
            throw new RuntimeException("Not supported");
        } else {
            var1.glTranslatef(this.f.a, this.g.c - this.f.b - (float)this.e.c(), 0.0F);
            class_934 var2 = this.g.h;
            float var3 = (float)this.e.a / (float)this.b.m();
            float var4 = (float)this.e.c / (float)this.b.m();
            float var5 = (float)this.e.b / (float)this.b.l();
            float var6 = (float)this.e.d / (float)this.b.l();
            if (this.g.j == this.e.c() && this.g.k == this.e.b()) {
                var2.a(0, 0, var3, var6);
                var2.a(1, 0, var4, var6);
                var2.a(0, 1, var3, var5);
                var2.a(1, 1, var4, var5);
            } else {
                this.g.j = this.e.c();
                this.g.k = this.e.b();
                var2.a(0, 0, 0.0F, 0.0F, 0.0F, var3, var6, (float[])null);
                var2.a(1, 0, (float)this.e.b(), 0.0F, 0.0F, var4, var6, (float[])null);
                var2.a(0, 1, 0.0F, (float)this.e.c(), 0.0F, var3, var5, (float[])null);
                var2.a(1, 1, (float)this.e.b(), (float)this.e.c(), 0.0F, var4, var5, (float[])null);
            }

            var2.b(var1, true, false);
            var1.glPopMatrix();
        }
    }
}
