package com.corrodinggames.rts.gameFramework;

import android.graphics.Paint;
import android.graphics.Rect;

public final strictfp class Unit {
    GameEngine a;
    public int b = 0;
    public static int c = 40;
    public int d = 0;
    class_965 e = new class_965(this);
    Paint f = new Paint();
    Rect g = new Rect();
    int h = -1;

    public Unit(GameEngine var1) {
        this.a = var1;
    }

    public static final long loadAllUnitsTook() {
        return System.nanoTime();
    }

    public static final float a(long var0) {
        return (float)(System.nanoTime() - var0) / 1000000.0F;
    }

    public static final double a(long var0, long var2) {
        return (double)(var2 - var0) / 1000000.0;
    }

    public static final void a(String var0, long var1) {
        GameEngine.log(var0 + "" + a((double)a(var1)));
    }

    public final void a(class_324 var1) {
    }

    public final void b(class_324 var1) {
    }

    public static final String a(double var0) {
        return "" + class_340.a(var0, 3) + "ms";
    }

    public static final String b(double var0) {
        return "" + var0 / 1000000.0 + "ms";
    }

    public final void b() {
    }

    public final void c() {
    }

    public final void a(boolean var1, boolean var2) {
    }
}
