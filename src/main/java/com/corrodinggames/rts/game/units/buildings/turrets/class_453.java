package com.corrodinggames.rts.game.units.buildings.turrets;

import android.graphics.Color;
import android.graphics.PointF;
import com.corrodinggames.rts.game.Projectile;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.a.class_648;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;

// $FF: renamed from: com.corrodinggames.rts.game.units.d.a.h
class class_453 extends class_449 {
    // $FF: synthetic field
    final Turret b;

    class_453(Turret var1) {
        super(var1);
        this.b = var1;
    }

    public strictfp String c() {
        return Turret.t;
    }

    public strictfp int d() {
        return UnitType.turret.price();
    }

    public strictfp TeamImageCache d(int var1) {
        return Turret.dD();
    }

    strictfp float a() {
        return 165.0F;
    }

    public strictfp float b(int var1) {
        return 41.0F;
    }

    public strictfp float a(int var1) {
        return 30.0F;
    }

    public strictfp float g(int var1) {
        return 21.0F;
    }

    public strictfp void a(Unit var1, int var2) {
        PointF var3 = this.c(var2);
        Projectile var4 = Projectile.a(this.b, var3.x, var3.y);
        PointF var5 = this.b.K(var2);
        var4.K = var5.x;
        var4.L = var5.y;
        var4.l = var1;
        var4.h = 60.0F;
        var4.t = 5.0F;
        var4.ar = Color.a(255, 100, 30, 30);
        var4.U = this.b(var2);
        var4.P = 5;
        var4.x = 1.0F;
        GameEngine var6 = GameEngine.getGameEngine();
        var6.bR.a(var3.x, var3.y, this.b.zCord, -1127220);
        var6.bR.a(var3.x, var3.y, this.b.zCord, this.b.cL[var2].a);
        float var7 = 1.0F + class_340.c(-0.07F, 0.07F);
        var6.bM.a(class_648.t, 0.3F, var7, var3.x, var3.y);
    }

    public strictfp int b() {
        return 1;
    }

    public strictfp void a(class_449 var1) {
    }

    public strictfp void a(float var1) {
        this.b.s(var1);
    }
}
