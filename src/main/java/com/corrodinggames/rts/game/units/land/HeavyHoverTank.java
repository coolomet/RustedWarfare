package com.corrodinggames.rts.game.units.land;

import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;
import com.corrodinggames.rts.AssetsID$drawable;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.Projectile;
import com.corrodinggames.rts.game.units.ExplodeType;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.a.class_648;
import com.corrodinggames.rts.gameFramework.d.class_986;
import com.corrodinggames.rts.gameFramework.d.class_998;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.utility.class_694;

// $FF: renamed from: com.corrodinggames.rts.game.units.e.e
public strictfp class HeavyHoverTank extends class_128 {
    float a = 0.0F;
    static TeamImageCache b = null;
    static TeamImageCache c = null;
    static TeamImageCache d = null;
    static TeamImageCache[] e = new TeamImageCache[10];
    Rect f = new Rect();

    public strictfp UnitType b() {
        return UnitType.heavyHoverTank;
    }

    public static strictfp void f() {
        GameEngine var0 = GameEngine.getGameEngine();
        c = var0.bO.a(AssetsID$drawable.heavy_hover_tank);
        b = var0.bO.a(AssetsID$drawable.heavy_hover_tank_dead);
        d = var0.bO.a(AssetsID$drawable.heavy_hover_tank_shadow);
        e = PlayerData.a(c);
    }

    public strictfp TeamImageCache d() {
        return this.bV ? b : e[this.bX.R()];
    }

    public strictfp TeamImageCache k() {
        return d;
    }

    public strictfp TeamImageCache d(int var1) {
        return null;
    }

    public strictfp boolean e() {
        GameEngine var1 = GameEngine.getGameEngine();
        this.M = b;
        this.S(0);
        this.bT = false;
        this.a(ExplodeType.normal);
        return true;
    }

    public HeavyHoverTank(boolean var1) {
        super(var1);
        this.T(24);
        this.U(36);
        this.cj = 11.0F;
        this.ck = this.cj + 2.0F;
        this.totalHealth = 450.0F;
        this.health = this.totalHealth;
        this.M = c;
        this.N = d;
    }

    public strictfp void a(float var1) {
        super.a(var1);
        if (!this.bV && this.bT()) {
            this.a += 3.0F * var1;
            if (this.a > 360.0F) {
                this.a -= 360.0F;
            }

            this.zCord = class_340.a(this.zCord, 4.0F + class_340.j(this.a) * 1.5F, 0.1F * var1);
        }
    }

    public strictfp float q(int var1) {
        return 40.0F;
    }

    public strictfp void a(Unit var1, int var2) {
        PointF var3 = this.E(var2);
        Projectile var4 = Projectile.a(this, var3.x, var3.y, this.zCord, var2);
        PointF var5 = this.K(var2);
        var4.K = var5.x;
        var4.L = var5.y;
        var4.ar = Color.a(255, 230, 0, 50);
        var4.U = this.q(var2);
        var4.l = var1;
        var4.h = 95.0F;
        var4.t = 1.0F;
        var4.r = 7.0F;
        var4.s = 0.2F;
        var4.P = 7;
        var4.x = 1.0F;
        GameEngine var6 = GameEngine.getGameEngine();
        class_998 var7 = var6.bR.a(var3.x, var3.y, this.zCord, -56798);
        if (var7 != null) {
            var7.E = 0.7F;
            var7.V = 30.0F;
            var7.W = var7.V;
            class_986.a(var7, this);
        }

        var6.bR.a(var4, -1179648);
        var6.bM.a(class_648.z, 0.3F, var3.x, var3.y);
    }

    public strictfp boolean E() {
        return false;
    }

    public strictfp float attackRange() {
        return 160.0F;
    }

    public strictfp float shootDelay(int var1) {
        return 75.0F;
    }

    public strictfp float speed() {
        return 0.7F;
    }

    public strictfp float turnSpeed() {
        return 20.0F;
    }

    public strictfp void i(float var1) {
        this.cg += var1;
        if (this.cg > 180.0F) {
            this.cg -= 360.0F;
        }

        if (this.cg < -180.0F) {
            this.cg += 360.0F;
        }

    }

    public strictfp float C() {
        return 0.06F;
    }

    public strictfp float D() {
        return 0.09F;
    }

    public strictfp float c(int var1) {
        return 2.4F;
    }

    public strictfp boolean bi() {
        return true;
    }

    public strictfp boolean bj() {
        return true;
    }

    public strictfp float d(boolean var1) {
        return this.cL[0].a + 90.0F;
    }

    public strictfp boolean c(float var1) {
        return super.c(var1);
    }

    public strictfp boolean l() {
        return true;
    }

    public strictfp boolean af() {
        return true;
    }

    public strictfp float g(int var1) {
        return 16.0F;
    }

    public strictfp void e(float var1) {
        super.e(var1);
        float var2 = this.attackRange();
        class_694.a(this, var2);
    }

    // $FF: synthetic method
    public class_31 r() {
        return this.b();
    }
}
