package com.corrodinggames.rts.game.units.land;

import android.graphics.PointF;
import android.graphics.Rect;
import com.corrodinggames.rts.AssetsID$drawable;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.Projectile;
import com.corrodinggames.rts.game.units.ExplodeType;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.a.class_648;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.utility.class_694;

// $FF: renamed from: com.corrodinggames.rts.game.units.e.n
public strictfp class Tank extends class_120 {
    static TeamImageCache a = null;
    static TeamImageCache b = null;
    static TeamImageCache c = null;
    static TeamImageCache d = null;
    static TeamImageCache[] e = new TeamImageCache[10];
    int f;
    float g;
    float h;
    Rect i = new Rect();

    public strictfp UnitType b() {
        return UnitType.tank;
    }

    public static strictfp void f() {
        GameEngine var0 = GameEngine.getGameEngine();
        b = var0.bO.a(AssetsID$drawable.tank2);
        a = var0.bO.a(AssetsID$drawable.tank2_dead);
        c = var0.bO.a(AssetsID$drawable.tank2_turret);
        d = var0.bO.a(AssetsID$drawable.tank2_shadow);
        e = PlayerData.a(b);
    }

    public strictfp TeamImageCache d() {
        return this.bV ? a : e[this.bX.R()];
    }

    public strictfp TeamImageCache k() {
        return d;
    }

    public strictfp boolean F() {
        return GameEngine.getGameEngine().settingsEngine.renderExtraShadows && !this.bV;
    }

    public strictfp float G() {
        return 3.0F;
    }

    public strictfp float H() {
        return 3.0F;
    }

    public strictfp TeamImageCache d(int var1) {
        return c;
    }

    public strictfp boolean e() {
        this.M = a;
        this.S(0);
        this.bT = false;
        this.a(ExplodeType.small);
        return true;
    }

    public Tank(boolean var1) {
        super(var1);
        this.a(b, 3);
        this.cj = 11.0F;
        this.ck = this.cj + 1.0F;
        this.totalHealth = 210.0F;
        this.health = this.totalHealth;
        this.M = b;
    }

    public strictfp void a(float var1) {
        super.a(var1);
        if (!this.bV) {
            if (this.cf != 0.0F) {
                this.g += var1;
                if (this.g > 1.0F) {
                    this.g = 0.0F;
                    ++this.f;
                    if (this.f > 2) {
                        this.f = 0;
                    }
                }

                if (this.cf > 0.0F && this.el) {
                    this.h += var1;
                    if (this.h > 9.0F) {
                        this.h = 0.0F;
                        this.K();
                    }
                }
            }

        }
    }

    public strictfp void K() {
        GameEngine var1 = GameEngine.getGameEngine();

        for(int var2 = 0; var2 <= 1; ++var2) {
            float var3 = (float)(var2 == 0 ? -20 : 20);
            float var4 = this.xCord + class_340.k(this.cg + 180.0F + var3) * this.cj;
            float var5 = this.yCord + class_340.j(this.cg + 180.0F + var3) * this.cj;
            var1.bR.c(var4, var5, this.zCord, this.cg + 180.0F, 0);
        }

    }

    public strictfp void a(Unit var1, int var2) {
        PointF var3 = this.E(var2);
        Projectile var4 = Projectile.a(this, var3.x, var3.y);
        PointF var5 = this.K(var2);
        var4.K = var5.x;
        var4.L = var5.y;
        var4.U = 30.0F;
        var4.l = var1;
        var4.h = 60.0F;
        var4.t = 3.0F;
        var4.P = 1;
        var4.x = 1.0F;
        GameEngine var6 = GameEngine.getGameEngine();
        var6.bR.a(var3.x, var3.y, this.zCord, -1127220);
        var6.bR.a(var3.x, var3.y, this.zCord, this.cL[var2].a);
        float var7 = 1.0F + class_340.c(-0.07F, 0.07F);
        var6.bM.a(class_648.q, 0.3F, var7, var3.x, var3.y);
    }

    public strictfp float attackRange() {
        return 130.0F;
    }

    public strictfp float shootDelay(int var1) {
        return 75.0F;
    }

    public strictfp float speed() {
        return 1.0F;
    }

    public strictfp float turnSpeed() {
        return 4.1F;
    }

    public strictfp float c(int var1) {
        return 4.0F;
    }

    public strictfp float B() {
        return 0.25F;
    }

    public strictfp boolean c(float var1) {
        if (!super.c(var1)) {
            return false;
        } else {
            class_694.a((OrderableUnit)this);
            if (!this.bV) {
            }

            return true;
        }
    }

    public strictfp float C() {
        return 0.07F;
    }

    public strictfp float D() {
        return 0.17F;
    }

    public strictfp boolean l() {
        return true;
    }

    public strictfp boolean af() {
        return false;
    }

    public strictfp float g(int var1) {
        return 20.0F;
    }

    public strictfp Rect a_(boolean var1) {
        if (var1) {
            return super.a_(var1);
        } else {
            return this.bV ? super.a_(var1) : super.a(var1, this.f);
        }
    }

    // $FF: synthetic method
    public class_31 r() {
        return this.b();
    }
}
