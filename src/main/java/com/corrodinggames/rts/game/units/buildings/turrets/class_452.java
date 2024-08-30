package com.corrodinggames.rts.game.units.buildings.turrets;

import android.graphics.Color;
import android.graphics.PointF;
import com.corrodinggames.rts.game.Projectile;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.a.class_648;
import com.corrodinggames.rts.gameFramework.d.class_998;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;

// $FF: renamed from: com.corrodinggames.rts.game.units.d.a.d
class class_452 extends class_449 {
    // $FF: synthetic field
    final Turret b;

    class_452(Turret var1) {
        super(var1);
        this.b = var1;
    }

    public strictfp String c() {
        return Turret.w;
    }

    public strictfp int d() {
        return UnitType.turret.price() + Turret.dN.c();
    }

    public strictfp TeamImageCache d(int var1) {
        return Turret.dG();
    }

    strictfp float a() {
        return 350.0F;
    }

    public strictfp float a(int var1) {
        return 220.0F;
    }

    public strictfp float b(int var1) {
        return 100.0F;
    }

    public strictfp void a(Unit var1, int var2) {
        PointF var3 = this.c(var2);
        Projectile var4 = Projectile.a(this.b, var3.x, var3.y);
        PointF var5 = this.b.K(var2);
        var4.K = var5.x;
        var4.L = var5.y;
        var4.h = 150.0F;
        var4.t = 4.0F;
        var4.aQ = true;
        var4.ar = Color.a(255, 190, 190, 80);
        var4.R = 2;
        var4.P = 0;
        var4.x = 0.9F;
        PointF var6 = var1.a(var3.x, var3.y, var4.t, var4.h, this.a());
        var4.aC = true;
        var4.m = true;
        var4.n = var6.x;
        var4.o = var6.y;
        var4.Y = this.b(var2);
        var4.Z = 55.0F;
        var4.aa = true;
        GameEngine var7 = GameEngine.getGameEngine();
        var7.bM.a(class_648.r, 0.3F, var3.x, var3.y);
        var7.bR.a(var3.x, var3.y, this.b.zCord, this.b.cL[var2].a);
        var7.bR.a(var4, -1118482);
        class_998 var8 = var7.bR.a(var3.x, var3.y, this.b.zCord, -1118482);
        if (var8 != null) {
            var8.V = 15.0F;
            var8.W = var8.V;
        }

    }

    public strictfp int b() {
        return 2;
    }

    public strictfp void a(class_449 var1) {
        Turret var10000 = this.b;
        var10000.totalHealth += 300.0F;
        var10000 = this.b;
        var10000.health += 300.0F;
    }

    public strictfp float e(int var1) {
        return 2.5F;
    }

    public strictfp float f(int var1) {
        return 0.2F;
    }

    public strictfp float h(int var1) {
        return -2.0F;
    }
}
