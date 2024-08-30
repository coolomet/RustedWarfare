package com.corrodinggames.rts.gameFramework.b;

import android.graphics.RectF;
import android.opengl.GLES20;
import com.corrodinggames.rts.gameFramework.m.Shader;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.b.y
public strictfp class class_465 {
    class_946 a;
    float[] b;
    int c;
    int d;
    int e;
    class_480 f;
    int g;
    class_479 h;
    // maybe error maybe
    class_466 i;
    public class_466 j;
    class_468 k;
    Shader l;
    boolean m;
    int n;
    float o;
    float p;
    float q;
    float r;

    public void a(Shader var1) {
        this.e = 0;
        this.c = 0;
        this.k = null;
        this.b(var1);
        this.a();
        class_480.q();
        this.a.d();
    }

    public void a() {
        this.j.d.a(this.f.d);
    }

    public void b() {
        this.m = true;
    }

    void b(Shader var1) {
        if (var1 != null) {
            this.f.a(var1.n);
            this.f.c(var1);
            this.m = false;
        } else {
            this.f.a(this.g);
        }

        this.l = var1;
    }

    void a(class_468 var1) {
        if (this.k != var1) {
            if (this.k != null) {
                int var2 = this.k.a();
                if (var2 == var1.a() && var2 != -1) {
                    return;
                }
            }

            this.c();
            GLES20.glActiveTexture(33984);
            class_480.q();
            var1.c(this.f);
            GLES20.glBindTexture(var1.g(), var1.a());
            class_480.q();
            GLES20.glUniform1i(this.j.e.a, 0);
            class_480.q();
            this.k = var1;
        }
    }

    public void c() {
        if (this.e > 0) {
            class_480.q();
            this.a.a(this.b, 0, this.c);
            this.a.b();
            class_480.q();
            this.a.a(4, 0, this.e * 6);
            this.a.c();
            class_480.q();
            this.e = 0;
            this.c = 0;
        }

    }

    public void d() {
        this.c();
        this.k = null;
        this.a.e();
    }

    public void a(int var1) {
        if (this.n != var1) {
            this.n = var1;
            float var2 = (float)(var1 >>> 24 & 255) * 0.003921569F * 1.0F;
            float var3 = (float)(var1 >>> 16 & 255) * 0.003921569F * var2;
            float var4 = (float)(var1 >>> 8 & 255) * 0.003921569F * var2;
            float var5 = (float)(var1 & 255) * 0.003921569F * var2;
            this.o = var3;
            this.p = var4;
            this.q = var5;
            this.r = var2;
        }
    }

    public void a(class_468 var1, RectF var2, RectF var3, float[] var4) {
        if (this.e == this.d) {
            this.c();
        }

        this.a(var1);
        if (this.m && this.l != null) {
            this.f.c(this.l);
            this.m = false;
        }

        float var5 = var3.a;
        float var6 = var3.d;
        float var7 = var3.c;
        float var8 = var3.b;
        float var9 = var2.a;
        float var10 = var2.b;
        float var11 = var2.c;
        float var12 = var2.d;
        float var13 = this.o;
        float var14 = this.p;
        float var15 = this.q;
        float var16 = this.r;
        float var17 = var4[0];
        float var18 = var4[4];
        float var19 = var4[1];
        float var20 = var4[5];
        float var21 = var4[12];
        float var22 = var4[13];
        float var23 = var5 * var17;
        float var24 = var7 * var17;
        float var25 = var5 * var19;
        float var26 = var7 * var19;
        float var27 = var6 * var18;
        float var28 = var6 * var20;
        float var29 = var8 * var18;
        float var30 = var8 * var20;
        int var31 = this.c;
        this.b[var31++] = var23 + var27 + var21;
        this.b[var31++] = var25 + var28 + var22;
        this.b[var31++] = var9;
        this.b[var31++] = var12;
        this.b[var31++] = var13;
        this.b[var31++] = var14;
        this.b[var31++] = var15;
        this.b[var31++] = var16;
        this.b[var31++] = var24 + var27 + var21;
        this.b[var31++] = var26 + var28 + var22;
        this.b[var31++] = var11;
        this.b[var31++] = var12;
        this.b[var31++] = var13;
        this.b[var31++] = var14;
        this.b[var31++] = var15;
        this.b[var31++] = var16;
        this.b[var31++] = var24 + var29 + var21;
        this.b[var31++] = var26 + var30 + var22;
        this.b[var31++] = var11;
        this.b[var31++] = var10;
        this.b[var31++] = var13;
        this.b[var31++] = var14;
        this.b[var31++] = var15;
        this.b[var31++] = var16;
        this.b[var31++] = var23 + var29 + var21;
        this.b[var31++] = var25 + var30 + var22;
        this.b[var31++] = var9;
        this.b[var31++] = var10;
        this.b[var31++] = var13;
        this.b[var31++] = var14;
        this.b[var31++] = var15;
        this.b[var31++] = var16;
        this.c = var31;
        ++this.e;
    }
}
