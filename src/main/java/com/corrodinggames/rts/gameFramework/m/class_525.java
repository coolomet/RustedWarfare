package com.corrodinggames.rts.gameFramework.m;

import android.graphics.Paint;
import android.graphics.Typeface;
import com.corrodinggames.rts.gameFramework.GameEngine;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.m.ag
public strictfp class class_525 extends Paint {
    public static final class_525 r = new class_525();
    boolean s = false;
    Shader t;
    boolean u = false;

    public void o() {
        this.u = true;
    }

    public void c(float var1) {
        super.b(var1);
    }

    public void b(float var1) {
        if (this.u) {
            GameEngine.print("UniquePaint changed when locked down:");
            GameEngine.print("from:" + this.k() + " to: " + var1);
            GameEngine.T();
        }

        super.b(var1);
    }

    public Typeface a(Typeface var1) {
        if (this.u) {
            GameEngine.print("UniquePaint changed when locked down:");
            GameEngine.T();
        }

        return super.a(var1);
    }

    public static void b(Paint var0) {
        ((class_525)var0).o();
    }

    public boolean p() {
        return this.s;
    }

    public void a(boolean var1) {
        this.s = var1;
        super.a(var1);
    }

    public Shader q() {
        return this.t;
    }

    public void a(Shader var1) {
        this.t = var1;
    }

    static {
        r.b(-1);
        r.o();
    }
}
