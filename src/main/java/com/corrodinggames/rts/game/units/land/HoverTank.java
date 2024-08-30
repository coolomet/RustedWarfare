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
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;

// $FF: renamed from: com.corrodinggames.rts.game.units.e.g
public strictfp class HoverTank extends class_128 {
    float a = 0.0F;
    static TeamImageCache b = null;
    static TeamImageCache c = null;
    static TeamImageCache d = null;
    static TeamImageCache[] e = new TeamImageCache[10];
    Rect f = new Rect();

    public strictfp UnitType b() {
        return UnitType.hoverTank;
    }

    public static strictfp void f() {
        GameEngine var0 = GameEngine.getGameEngine();
        c = var0.bO.a(AssetsID$drawable.hover_tank);
        b = var0.bO.a(AssetsID$drawable.hover_tank_dead);
        d = var0.bO.a(AssetsID$drawable.hover_tank_shadow);
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
        this.M = b;
        this.S(0);
        this.bT = false;
        this.a(ExplodeType.small);
        return true;
    }

    public HoverTank(boolean var1) {
        super(var1);
        this.b(c);
        this.cj = 7.0F;
        this.ck = this.cj + 2.0F;
        this.totalHealth = 150.0F;
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
        return 23.0F;
    }

    public strictfp void a(Unit var1, int var2) {
        PointF var3 = this.E(var2);
        Projectile var4 = Projectile.a(this, var3.x, var3.y, this.zCord, var2);
        PointF var5 = this.K(var2);
        var4.K = var5.x;
        var4.L = var5.y;
        var4.ar = Color.a(255, 50, 230, 50);
        var4.U = this.q(var2);
        var4.l = var1;
        var4.h = 85.0F;
        var4.t = 2.0F;
        var4.r = 6.0F;
        var4.s = 0.2F;
        var4.P = 6;
        var4.x = 1.0F;
        GameEngine var6 = GameEngine.getGameEngine();
        var6.bR.a(var3.x, var3.y, this.zCord, -14483678);
        var6.bR.a(var4, -16716288);
        float var7 = 1.3F + class_340.c(-0.07F, 0.07F);
        var6.bM.a(class_648.z, 0.3F, var7, var3.x, var3.y);
    }

    public strictfp boolean E() {
        return false;
    }

    public strictfp float attackRange() {
        return 140.0F;
    }

    public strictfp float shootDelay(int var1) {
        return 90.0F;
    }

    public strictfp float speed() {
        return 1.0F;
    }

    public strictfp float turnSpeed() {
        return 180.0F;
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
        return 0.04F;
    }

    public strictfp float D() {
        return 0.09F;
    }

    public strictfp boolean bi() {
        return true;
    }

    public strictfp boolean bj() {
        return true;
    }

    public strictfp float c(int var1) {
        return 4.0F;
    }

    public strictfp float w(int var1) {
        return 0.2F;
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
        return 2.0F;
    }

    public strictfp float B() {
        return 0.5F;
    }

    // $FF: synthetic method
    public class_31 r() {
        return this.b();
    }
}
