package com.corrodinggames.rts.gameFramework.b;

import android.graphics.RectF;
import com.corrodinggames.rts.gameFramework.GameEngine;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.b.ae
public strictfp class class_469 extends class_468 {
    class_470 l;
    public float m;
    public float n;
    public int o;
    public int p;

    protected boolean c(class_13 var1) {
        return false;
    }

    protected int g() {
        return 3553;
    }

    public void b(int var1) {
        this.l.b(var1);
    }

    public int h() {
        return this.l.h();
    }

    public void a(RectF var1) {
        float var2 = this.g;
        float var3 = this.h;
        var1.a = var1.a * var2 + this.m;
        var1.c = var1.c * var2 + this.m;
        var1.b = var1.b * var3 + this.n;
        var1.d = var1.d * var3 + this.n;
    }

    public void a(RectF var1, RectF var2) {
    }

    public void b(class_13 var1) {
        GameEngine.log("SubTexture prepare TODO");
    }
}
