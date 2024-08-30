package com.corrodinggames.rts.game.units.air;

import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;
import com.corrodinggames.rts.AssetsID$drawable;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.Projectile;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.a.class_648;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;

// $FF: renamed from: com.corrodinggames.rts.game.units.b.e
public strictfp class GunShip extends class_107 {
    static TeamImageCache a = null;
    static TeamImageCache b = null;
    static TeamImageCache c = null;
    static TeamImageCache d = null;
    static TeamImageCache[] e = new TeamImageCache[10];
    float f = 0.0F;
    Rect g = new Rect();

    public strictfp UnitType b() {
        return UnitType.gunShip;
    }

    public static strictfp void f() {
        GameEngine var0 = GameEngine.getGameEngine();
        b = var0.bO.a(AssetsID$drawable.gunship);
        c = var0.bO.a(AssetsID$drawable.gunship_shadow);
        a = var0.bO.a(AssetsID$drawable.gunship_dead);
        e = PlayerData.a(b);
    }

    public strictfp TeamImageCache d() {
        return this.bV ? a : e[this.bX.R()];
    }

    public strictfp TeamImageCache k() {
        return c;
    }

    public strictfp TeamImageCache d(int var1) {
        return null;
    }

    public strictfp boolean e() {
        GameEngine var1 = GameEngine.getGameEngine();
        var1.bR.b(this.xCord, this.yCord, this.zCord);
        this.M = a;
        this.S(0);
        this.bT = false;
        return true;
    }

    public GunShip(boolean var1) {
        super(var1);
        this.T(25);
        this.U(35);
        this.cj = 15.0F;
        this.ck = this.cj + 0.0F;
        this.totalHealth = 260.0F;
        this.health = this.totalHealth;
        this.M = b;
        this.N = c;
        this.zCord = 0.0F;
        this.S(5);
    }

    public strictfp boolean I() {
        return true;
    }

    public strictfp boolean i() {
        return true;
    }

    public strictfp void a(float var1) {
        super.a(var1);
        if (!this.bV) {
            this.f += 2.0F * var1;
            if (this.f > 360.0F) {
                this.f -= 360.0F;
            }

            this.zCord = class_340.a(this.zCord, 20.0F + class_340.j(this.f) * 1.5F, 0.1F * var1);
        }
    }

    public strictfp PointF E(int var1) {
        float var2 = this.g(var1);
        float var3 = this.cg;
        float var4 = this.xCord + class_340.k(var3) * var2;
        float var5 = this.yCord + class_340.j(var3) * var2;
        bg.setSite(var4, var5);
        return bg;
    }

    public strictfp float q(int var1) {
        return 35.0F;
    }

    public strictfp void a(Unit var1, int var2) {
        PointF var3 = this.E(var2);
        Projectile var4 = Projectile.a(this, var3.x, var3.y, this.zCord, var2);
        PointF var5 = this.K(var2);
        var4.K = var5.x;
        var4.L = var5.y;
        var4.ar = Color.a(255, 150, 230, 40);
        var4.U = this.q(var2);
        var4.l = var1;
        var4.h = 80.0F;
        var4.t = 4.0F;
        var4.x = 2.0F;
        GameEngine var6 = GameEngine.getGameEngine();
        var6.bR.a(var3.x, var3.y, this.zCord, -1127220);
        var6.bR.a(var3.x, var3.y, this.zCord, this.cL[var2].a);
        var6.bM.a(class_648.u, 0.3F, this.xCord, this.yCord);
    }

    public strictfp float attackRange() {
        return 140.0F;
    }

    public strictfp float shootDelay(int var1) {
        return 40.0F;
    }

    public strictfp float speed() {
        return this.zCord < 15.0F ? 0.0F : 1.4F;
    }

    public strictfp float turnSpeed() {
        return 4.0F;
    }

    public strictfp float B() {
        return 0.4F;
    }

    public strictfp boolean bi() {
        return true;
    }

    public strictfp float c(int var1) {
        return 99.0F;
    }

    public strictfp boolean E() {
        return false;
    }

    public strictfp float C() {
        return 0.2F;
    }

    public strictfp float D() {
        return 0.1F;
    }

    public strictfp boolean l() {
        return true;
    }

    public strictfp boolean af() {
        return false;
    }

    public strictfp float g(int var1) {
        return 15.0F;
    }

    // $FF: synthetic method
    public class_31 r() {
        return this.b();
    }
}
