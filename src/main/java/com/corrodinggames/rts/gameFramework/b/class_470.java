package com.corrodinggames.rts.gameFramework.b;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.corrodinggames.rts.gameFramework.GameEngine;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.b.ad
public strictfp class class_470 extends class_468 {
    int l = 9729;

    public class_470(class_13 var1, int var2, int var3) {
        this.a(var2, var3);
        this.a = var1.a().a();
        var1.d(this);
        var1.a(this, 6408, 5121, 6408);
    }

    public void a(class_13 var1, Bitmap var2, int var3, int var4) {
        var1.f();
        int var5 = this.g();
        var1.b(this);
        class_480.q();
        GLUtils.texSubImage2D(var5, 0, var3, var4, var2, 6408, 5121);
    }

    protected boolean c(class_13 var1) {
        return false;
    }

    public void b(class_13 var1) {
        GameEngine.log("BackingTexture prepare TODO");
    }

    protected int g() {
        return 3553;
    }

    public void b(int var1) {
        if (this.l != var1) {
            int var2 = this.g();
            GLES20.glTexParameterf(var2, 10241, (float)var1);
            GLES20.glTexParameterf(var2, 10240, (float)var1);
            this.l = var1;
        }

    }

    public int h() {
        return this.l;
    }
}
