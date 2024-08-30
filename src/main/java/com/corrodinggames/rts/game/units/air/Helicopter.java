package com.corrodinggames.rts.game.units.air;

import android.graphics.Color;
import android.graphics.Paint;
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
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;

// $FF: renamed from: com.corrodinggames.rts.game.units.b.f
public strictfp class Helicopter extends class_107 {
    static TeamImageCache a = null;
    static TeamImageCache b = null;
    static TeamImageCache c = null;
    static TeamImageCache d = null;
    static TeamImageCache e = null;
    static TeamImageCache[] f = new TeamImageCache[10];
    boolean g = false;
    float o;
    float p = 0.0F;
    float q;
    Rect r = new Rect();
    Rect s = new Rect();

    public strictfp void a(GameOutputStream var1) {
        var1.writeFloat(this.p);
        var1.writeFloat(this.o);
        super.a(var1);
    }

    public strictfp void a(GameInputStream var1) {
        if (var1.b() >= 9) {
            this.p = var1.readFloat();
            this.o = var1.readFloat();
            if (var1.b() == 8) {
                this.g = var1.readBoolean();
            }
        } else {
            this.o = 0.5F;
        }

        super.a(var1);
    }

    public strictfp UnitType b() {
        return UnitType.helicopter;
    }

    public static strictfp void f() {
        GameEngine var0 = GameEngine.getGameEngine();
        b = var0.bO.a(AssetsID$drawable.helicopter);
        c = var0.bO.a(AssetsID$drawable.helicopter_blades);
        d = var0.bO.a(AssetsID$drawable.helicopter_shadow);
        e = var0.bO.a(AssetsID$drawable.helicopter_shadow_blades);
        a = var0.bO.a(AssetsID$drawable.helicopter_dead);
        f = PlayerData.a(b);
    }

    public strictfp TeamImageCache d() {
        return this.bV ? a : f[this.bX.R()];
    }

    public strictfp TeamImageCache k() {
        return d;
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

    public Helicopter(boolean var1) {
        super(var1);
        this.T(26);
        this.U(46);
        this.cj = 13.0F;
        this.ck = this.cj + 2.0F;
        this.totalHealth = 150.0F;
        this.health = this.totalHealth;
        this.M = b;
        this.N = d;
        this.zCord = 0.0F;
        this.o = 0.14F;
        this.q = 0.0F;
        this.S(5);
    }

    public strictfp void n() {
        super.n();
        this.zCord = 20.0F;
        this.o = 0.5F;
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
            this.o = class_340.a(this.o, 0.5F, 0.003F * var1);
            this.q += 70.0F * this.o * var1;
            if (this.q >= 360.0F) {
                this.q -= 360.0F;
                this.q += (float)class_340.a(this, 0, 4);
            }

            if (this.o > 0.4F) {
                this.p += 2.0F * var1;
                if (this.p > 360.0F) {
                    this.p -= 360.0F;
                }

                this.zCord = class_340.a(this.zCord, 20.0F + class_340.j(this.p) * 1.5F, 0.1F * var1);
            }

        }
    }

    public strictfp void a(Unit var1, int var2) {
        PointF var3 = this.E(var2);
        Projectile var4 = Projectile.a(this, var3.x, var3.y, this.zCord, var2);
        PointF var5 = this.K(var2);
        var4.K = var5.x;
        var4.L = var5.y;
        var4.U = 17.0F;
        var4.l = var1;
        var4.h = 30.0F;
        var4.t = 8.0F;
        var4.S = false;
        var4.ar = Color.a(255, 180, 180, 0);
        var4.A = true;
        var4.aR = false;
        GameEngine var6 = GameEngine.getGameEngine();
        float var7 = 1.0F + class_340.c(-0.08F, 0.08F);
        var6.bM.a(class_648.s, 0.2F, var7, var3.x, var3.y);
        var6.bR.a(var3.x, var3.y, this.zCord, this.cL[var2].a);
        var6.bR.a(var3.x, var3.y, this.zCord, -1118720);
    }

    public strictfp float attackRange() {
        return 130.0F;
    }

    public strictfp float shootDelay(int var1) {
        return 60.0F;
    }

    public strictfp float speed() {
        return this.zCord < 15.0F ? 0.0F : 2.2F;
    }

    public strictfp float bc() {
        return 0.1F;
    }

    public strictfp float turnSpeed() {
        return 6.0F;
    }

    public strictfp float B() {
        return 0.4F;
    }

    public strictfp boolean bi() {
        return true;
    }

    public strictfp boolean bj() {
        return true;
    }

    public strictfp float c(int var1) {
        return 16.0F;
    }

    public strictfp Rect a_(boolean var1) {
        return super.a_(var1);
    }

    public strictfp boolean c(float var1) {
        if (!super.c(var1)) {
            return false;
        } else {
            if (!this.bV) {
                Paint var2 = this.aN();
                GameEngine var3 = GameEngine.getGameEngine();
                this.s.a(0, 0, c.m(), c.l());
                float var4 = this.q;
                if (this.co) {
                }

                var3.bO.a(c, this.s, this.xCord - GameEngine.getGameEngine().cw, this.yCord - GameEngine.getGameEngine().cx - this.zCord, var4, var2);
            }

            return true;
        }
    }

    public strictfp float C() {
        return 0.07F;
    }

    public strictfp float D() {
        return 0.1F;
    }

    public strictfp boolean l() {
        return true;
    }

    public strictfp float g(int var1) {
        return 7.0F;
    }

    // $FF: synthetic method
    public class_31 r() {
        return this.b();
    }
}
