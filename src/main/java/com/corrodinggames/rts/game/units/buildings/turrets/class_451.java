package com.corrodinggames.rts.game.units.buildings.turrets;

import android.graphics.Color;
import android.graphics.PointF;
import com.corrodinggames.rts.game.Projectile;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;

// $FF: renamed from: com.corrodinggames.rts.game.units.d.a.e
class class_451 extends class_449 {
    // $FF: synthetic field
    final Turret b;

    class_451(Turret var1) {
        super(var1);
        this.b = var1;
    }

    public strictfp String c() {
        return Turret.x;
    }

    public strictfp int d() {
        return UnitType.turret.price() + Turret.dO.c();
    }

    public strictfp TeamImageCache d(int var1) {
        return Turret.dH();
    }

    strictfp float a() {
        return 155.0F;
    }

    public strictfp float a(int var1) {
        return 5.0F;
    }

    public strictfp float b(int var1) {
        return 4.0F;
    }

    public strictfp void a(Unit var1, int var2) {
        PointF var3 = this.c(var2);
        Projectile var4 = Projectile.a(this.b, var3.x, var3.y);
        var4.h = 60.0F;
        var4.t = 3.0F + (float)(this.b.k * 13) % 2.0F;
        var4.aR = false;
        var4.G = true;
        var4.ar = Color.a(105, 255, 255, 255);
        var4.P = 3;
        var4.x = 1.3F;
        PointF var5 = var1.a(var3.x, var3.y, var4.t, var4.h, this.a());
        var4.aC = true;
        var4.m = true;
        var4.n = var5.x;
        var4.o = var5.y;
        var4.n += (float)(-15 + this.b.k * 13 % 30);
        var4.o += (float)(-15 + (63 + this.b.k * 33) % 30);
        var4.em = 3;
        var4.Y = this.b(var2);
        var4.Z = 65.0F;
        var4.aa = true;
        var4.C = true;
        GameEngine var6 = GameEngine.getGameEngine();
        ++this.b.k;
        if (this.b.k > 10) {
            this.b.k = 0;
            var6.bR.a(var3.x, var3.y, this.b.zCord, this.b.cL[var2].a);
        }

    }

    public strictfp int b() {
        return 2;
    }

    public strictfp void a(class_449 var1) {
        Turret var10000 = this.b;
        var10000.totalHealth += 900.0F;
        var10000 = this.b;
        var10000.health += 900.0F;
    }

    public strictfp void a(float var1) {
        if (this.b.health < this.b.totalHealth) {
            Turret var10000 = this.b;
            var10000.health += 0.15F * var1;
            if (this.b.health > this.b.totalHealth) {
                this.b.health = this.b.totalHealth;
            }
        }

    }

    public strictfp float e(int var1) {
        return 11.0F;
    }

    public strictfp float f(int var1) {
        return 2.0F;
    }

    public strictfp float g(int var1) {
        return 18.0F;
    }

    public strictfp float h(int var1) {
        return 0.0F;
    }
}
