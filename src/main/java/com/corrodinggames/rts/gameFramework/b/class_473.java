package com.corrodinggames.rts.gameFramework.b;

import android.util.Log;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.b.x
public strictfp class class_473 extends class_468 {
    private final boolean m;
    private int n;
    protected boolean l;

    public class_473(int var1, int var2, boolean var3) {
        this(var1, var2, var3, 3553);
    }

    public class_473(int var1, int var2, boolean var3, int var4) {
        this.n = 3553;
        this.m = var3;
        this.a(var1, var2);
        this.n = var4;
    }

    public void b(class_13 var1) {
        class_9 var2 = var1.a();
        this.a = var2.a();
        if (this.n == 3553) {
            var1.a(this, 6408, 5121, 6408);
        }

        var1.d(this);
        this.b = 1;
        this.a(var1);
    }

    protected boolean c(class_13 var1) {
        if (this.i()) {
            return true;
        } else {
            Log.c("RawTexture", "lost the content due to context change");
            return false;
        }
    }

    public int g() {
        return this.n;
    }

    public boolean k() {
        return this.l;
    }

    public void b(int var1) {
    }

    public int h() {
        return 9729;
    }
}
