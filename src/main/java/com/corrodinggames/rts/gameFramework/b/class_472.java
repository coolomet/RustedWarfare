package com.corrodinggames.rts.gameFramework.b;

import android.graphics.Bitmap;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.b.e
public strictfp class class_472 extends class_471 {
    protected Bitmap l;

    public class_472(Bitmap var1) {
        this(var1, false);
    }

    public class_472(Bitmap var1, boolean var2) {
        super(var2);
        this.l = var1;
        this.m = this.k();
        int var3 = this.m.b() + 0;
        int var4 = this.m.c() + 0;
        this.a(var3, var4);
    }

    protected void a(Bitmap var1) {
    }

    protected Bitmap k() {
        return this.l;
    }
}
