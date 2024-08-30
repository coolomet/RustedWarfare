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
import com.corrodinggames.rts.gameFramework.d.class_998;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;

// $FF: renamed from: com.corrodinggames.rts.game.units.b.a
public strictfp class AirShip extends class_107 {
    static TeamImageCache a = null;
    static TeamImageCache b = null;
    static TeamImageCache c = null;
    static TeamImageCache d = null;
    static TeamImageCache[] e = new TeamImageCache[10];
    float f;
    Rect g = new Rect();

    public strictfp UnitType b() {
        return UnitType.airShip;
    }

    public static strictfp void f() {
        GameEngine var0 = GameEngine.getGameEngine();
        b = var0.bO.a(AssetsID$drawable.ship);
        c = var0.bO.a(AssetsID$drawable.ship_shadow);
        a = var0.bO.a(AssetsID$drawable.ship_dead);
        e = PlayerData.a(b);
    }

    public strictfp TeamImageCache d() {
        return this.bV ? a : e[this.bX.R()];
    }

    public strictfp TeamImageCache k() {
        return c;
    }

    public strictfp TeamImageCache d(int var1) {
        return d;
    }

    public strictfp boolean e() {
        GameEngine var1 = GameEngine.getGameEngine();
        var1.bR.b(this.xCord, this.yCord, this.zCord);
        this.M = a;
        this.S(0);
        this.bT = false;
        return true;
    }

    public AirShip(boolean var1) {
        super(var1);
        this.T(24);
        this.U(22);
        this.cj = 11.0F;
        this.ck = this.cj + 0.0F;
        this.totalHealth = 250.0F;
        this.health = this.totalHealth;
        this.M = b;
        this.N = c;
        this.zCord = 0.0F;
        this.f = 0.18F;
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
            this.zCord = class_340.a(this.zCord, 20.0F, 0.3F * var1);
        }
    }

    public strictfp void a(Unit var1, int var2) {
        PointF var3 = this.E(var2);
        Projectile var4 = Projectile.a(this, var3.x, var3.y, this.zCord, var2);
        PointF var5 = this.K(var2);
        var4.K = var5.x;
        var4.L = var5.y;
        var4.U = 30.0F;
        var4.l = var1;
        var4.h = 75.0F;
        var4.t = 6.0F;
        var4.x = 2.0F;
        var4.y = 4.0F;
        var4.ar = Color.a(250, 74, 232, 255);
        GameEngine var6 = GameEngine.getGameEngine();
        class_998 var7 = var6.bR.a(var3.x, var3.y, this.zCord, this.cL[var2].a);
        if (var7 != null) {
            var7.aq = 10;
        }

        float var8 = 1.0F + class_340.c(-0.1F, 0.1F);
        var6.bM.a(class_648.y, 0.14F, var8, var3.x, var3.y);
    }

    public strictfp float attackRange() {
        return 170.0F;
    }

    public strictfp float shootDelay(int var1) {
        return 40.0F;
    }

    public strictfp float speed() {
        return this.zCord < 15.0F ? 0.0F : 2.4F;
    }

    public strictfp float turnSpeed() {
        return 3.7F;
    }

    public strictfp float B() {
        return 0.4F;
    }

    public strictfp float c(int var1) {
        return 3.7F;
    }

    public strictfp boolean bm() {
        return false;
    }

    public strictfp float w(int var1) {
        return 0.4F;
    }

    public strictfp boolean E() {
        return false;
    }

    public strictfp float g(int var1) {
        return 10.0F;
    }

    public strictfp float C() {
        return 0.1F;
    }

    public strictfp float D() {
        return 0.16F;
    }

    public strictfp boolean l() {
        return true;
    }

    public strictfp boolean af() {
        return true;
    }

    public strictfp boolean ag() {
        return false;
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

    // $FF: synthetic method
    public class_31 r() {
        return this.b();
    }
}
