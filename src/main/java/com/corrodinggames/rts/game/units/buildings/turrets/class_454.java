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

// $FF: renamed from: com.corrodinggames.rts.game.units.d.a.g
class class_454 extends class_449 {
    // $FF: synthetic field
    final Turret b;

    class_454(Turret var1) {
        super(var1);
        this.b = var1;
    }

    public strictfp String c() {
        return Turret.v;
    }

    public strictfp int d() {
        return UnitType.turret.price() + Turret.dL.c() + Turret.dM.c();
    }

    public strictfp TeamImageCache d(int var1) {
        return Turret.dF();
    }

    strictfp float a() {
        return 320.0F;
    }

    public strictfp float a(int var1) {
        return 13.0F;
    }

    public strictfp float b(int var1) {
        return 40.0F;
    }

    public strictfp PointF c(int var1) {
        PointF var2 = Turret.c(this.b, var1);
        float var3 = this.b.E() ? this.b.cg : this.b.cL[var1].a;
        var3 += (float)(this.b.k == 1 ? -90 : 90);
        var2.x += class_340.k(var3) * 4.0F;
        var2.y += class_340.j(var3) * 4.0F;
        return var2;
    }

    public strictfp void a(Unit var1, int var2) {
        PointF var3 = this.c(var2);
        Projectile var4 = Projectile.a(this.b, var3.x, var3.y);
        PointF var5 = this.b.K(var2);
        var4.K = var5.x;
        var4.L = var5.y;
        var4.l = var1;
        var4.h = 60.0F;
        var4.t = 9.0F;
        var4.ar = Color.a(255, 180, 30, 30);
        var4.U = this.b(var2);
        var4.P = 5;
        var4.x = 1.0F;
        GameEngine var6 = GameEngine.getGameEngine();
        var6.bR.a(var3.x, var3.y, this.b.zCord, -1127220);
        var6.bR.a(var3.x, var3.y, this.b.zCord, this.b.cL[var2].a);
        float var7 = 1.0F + class_340.c(-0.07F, 0.07F);
        var6.bM.a(class_648.t, 0.15F, var7, var3.x, var3.y);
        this.b.k = this.b.k == 1 ? 0 : 1;
    }

    public strictfp void a(float var1) {
        if (this.b.health < this.b.totalHealth) {
            Turret var10000 = this.b;
            var10000.health += 0.1F * var1;
            if (this.b.health > this.b.totalHealth) {
                this.b.health = this.b.totalHealth;
            }
        }

        this.b.s(var1);
    }

    public strictfp int b() {
        return 3;
    }

    public strictfp void a(class_449 var1) {
        Turret var10000;
        if (!(var1 instanceof class_450)) {
            var10000 = this.b;
            var10000.totalHealth += 400.0F;
            var10000 = this.b;
            var10000.health += 400.0F;
        }

        var10000 = this.b;
        var10000.totalHealth += 2800.0F;
        var10000 = this.b;
        var10000.health += 2800.0F;
    }
}
