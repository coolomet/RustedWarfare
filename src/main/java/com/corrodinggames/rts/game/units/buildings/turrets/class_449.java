package com.corrodinggames.rts.game.units.buildings.turrets;

import android.graphics.PointF;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;

// $FF: renamed from: com.corrodinggames.rts.game.units.d.a.c
abstract class class_449 {
    // $FF: synthetic field
    final Turret a;

    class_449(Turret var1) {
        this.a = var1;
    }

    abstract float a();

    public abstract float a(int var1);

    public abstract float b(int var1);

    public strictfp PointF c(int var1) {
        return Turret.a(this.a, var1);
    }

    public abstract void a(Unit var1, int var2);

    public abstract TeamImageCache d(int var1);

    public abstract int b();

    public abstract String c();

    public abstract void a(class_449 var1);

    public strictfp boolean a(String var1) {
        return this.c().equals(var1);
    }

    public strictfp void a(float var1) {
    }

    public strictfp float e(int var1) {
        return 5.0F;
    }

    public strictfp float f(int var1) {
        return 0.5F;
    }

    public strictfp float g(int var1) {
        return 23.0F;
    }

    public strictfp float h(int var1) {
        return -1.0F;
    }

    public abstract int d();
}
