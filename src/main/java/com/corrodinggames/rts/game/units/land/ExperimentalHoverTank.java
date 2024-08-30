package com.corrodinggames.rts.game.units.land;

import android.graphics.Paint;
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
import com.corrodinggames.rts.gameFramework.GameObject;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import com.corrodinggames.rts.gameFramework.utility.class_694;

// $FF: renamed from: com.corrodinggames.rts.game.units.e.c
public strictfp class ExperimentalHoverTank extends class_128 {
    static TeamImageCache a = null;
    static TeamImageCache b = null;
    static TeamImageCache c = null;
    public static TeamImageCache d = null;
    public static TeamImageCache e = null;
    static TeamImageCache[] f = new TeamImageCache[10];
    int g;
    float h = 0.0F;
    Projectile i;
    Rect j = new Rect();
    Paint k = class_694.a();

    public strictfp UnitType b() {
        return UnitType.experimentalHoverTank;
    }

    public static strictfp void f() {
        GameEngine var0 = GameEngine.getGameEngine();
        TeamImageCache var1 = var0.bO.a(AssetsID$drawable.experimental_hovertank);
        f = PlayerData.a(var1);
        a = var0.bO.a(AssetsID$drawable.experimental_hovertank_dead);
        b = var0.bO.a(AssetsID$drawable.experimental_hovertank_turret);
        c = a(var1, var1.m() / 1, var1.l());
        d = var0.bO.a(AssetsID$drawable.experimental_hovertank_shield);
        e = var0.bO.a(AssetsID$drawable.shield_mid);
    }

    public strictfp void a(GameOutputStream var1) {
        if (this.i != null && this.i.ej) {
            this.i = null;
        }

        var1.a((GameObject)this.i);
        super.a(var1);
    }

    public strictfp void a(GameInputStream var1) {
        this.i = (Projectile)var1.a(Projectile.class);
        super.a(var1);
    }

    public strictfp TeamImageCache d() {
        return this.bV ? a : f[this.bX.R()];
    }

    public strictfp TeamImageCache k() {
        return c;
    }

    public strictfp boolean F() {
        return GameEngine.getGameEngine().settingsEngine.renderExtraShadows && this.zCord > -2.0F;
    }

    public strictfp float G() {
        return 4.0F;
    }

    public strictfp float H() {
        return 4.0F;
    }

    public strictfp TeamImageCache d(int var1) {
        return b;
    }

    public strictfp TeamImageCache T() {
        return d;
    }

    public strictfp boolean e() {
        GameEngine var1 = GameEngine.getGameEngine();
        this.M = a;
        this.S(0);
        this.bT = false;
        this.a((ExplodeType) ExplodeType.largeUnit);
        return true;
    }

    public ExperimentalHoverTank(boolean var1) {
        super(var1);
        this.a(f[7], 1);
        this.cj = 30.0F;
        this.ck = this.cj + 1.0F;
        this.totalHealth = 3500.0F;
        this.health = this.totalHealth;
        this.cA = 5000.0F;
        this.cx = this.cA;
        this.M = f[7];
    }

    public strictfp float bW() {
        return this.cA > 0.0F && this.cx < this.cA ? this.cx / this.cA : super.bW();
    }

    public strictfp void a(float var1) {
        super.a(var1);
        if (!this.bV && this.bT()) {
            if (!this.bV) {
                if (this.cl != 0.0F) {
                    this.S(2);
                } else {
                    this.S(4);
                }
            }

            if (this.cK) {
            }

            this.h += 1.0F * var1;
            if (this.h > 360.0F) {
                this.h -= 360.0F;
            }

            this.zCord = class_340.a(this.zCord, 4.0F + class_340.j(this.h) * 2.0F, 0.1F * var1);
            this.cx = class_340.a(this.cx, this.cA, 0.25F * var1);
            this.cy = class_340.a(this.cy, 0.0F, 4.0F * var1);
            if (this.cy > 50.0F) {
                this.cy = 50.0F;
            }

            if (this.i != null) {
                PointF var2 = this.E(0);
                this.i.xCord = var2.x;
                this.i.yCord = var2.y;
                this.i.zCord = this.zCord;
                if (this.i.ej) {
                    this.i = null;
                }
            }

        }
    }

    public strictfp float mass() {
        return 80000.0F;
    }

    public strictfp float L(int var1) {
        return 0.0F;
    }

    public strictfp PointF K(int var1) {
        PointF var2 = super.K(var1);
        if (this.i != null) {
            var2.x += this.i.K;
            var2.y += this.i.L;
        }

        return var2;
    }

    public strictfp float q(int var1) {
        return 0.0F;
    }

    public strictfp void a(Unit var1, int var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        PointF var4 = this.E(var2);
        if (this.i != null) {
            boolean var5 = false;
            if (this.i.ej) {
                var5 = true;
            }

            if (this.i.l != var1) {
                var5 = true;
            }

            if (var5) {
                this.i = null;
            }
        }

        float var7 = this.shootDelay(var2) + this.e(var2) + 5.0F;
        if (this.i != null) {
            this.i.h = var7;
        } else {
            Projectile var6 = Projectile.a(this, var4.x, var4.y);
            var6.U = 380.0F;
            var6.l = var1;
            var6.h = var7;
            var6.B = true;
            var6.A = true;
            var6.aQ = true;
            var6.E = true;
            var6.J = 70.0F;
            var6.F = 230.0F;
            var6.ak = 0.75F;
            var6.em = this.em;
            this.i = var6;
        }

    }

    public strictfp float attackRange() {
        return 180.0F;
    }

    public strictfp float shootDelay(int var1) {
        return 8.0F;
    }

    public strictfp float e(int var1) {
        return 8.0F;
    }

    public strictfp float speed() {
        return 0.6F;
    }

    public strictfp float bc() {
        return 1.0F;
    }

    public strictfp float turnSpeed() {
        return 1.1F;
    }

    public strictfp float B() {
        return 0.03F;
    }

    public strictfp float c(int var1) {
        return 1.5F;
    }

    public strictfp float C() {
        return 0.02F;
    }

    public strictfp float D() {
        return 0.02F;
    }

    public strictfp Rect a_(boolean var1) {
        if (this.bV && !var1) {
            return super.a_(var1);
        } else if (var1) {
            return super.a_(var1);
        } else {
            int var2 = 0;
            byte var3 = 0;
            var2 += this.g * this.es;
            this.j.a(var2, var3, var2 + this.es, var3 + this.et);
            return this.j;
        }
    }

    public strictfp boolean c(float var1) {
        if (!super.c(var1)) {
            return false;
        } else {
            class_694.a((OrderableUnit)this);
            if (!this.bV) {
                float var2 = 0.0F;
                if (this.i != null) {
                    var2 = class_340.b(this.i.e(), 0.25F) * 3.0F;
                }

                class_694.a(this, MammothTank.e, var2, 0);
            }

            GameEngine var7 = GameEngine.getGameEngine();
            if (!this.bV && this.cx > 0.0F && this.cz == 0.0F) {
                TeamImageCache var3 = this.T();
                if (var3 != null) {
                    float var4 = 0.09F;
                    var4 += this.cx / this.cA * 0.4F;
                    var4 += class_340.b(this.cy, 50.0F) / 50.0F * 0.5F;
                    this.k.a((int)(var4 * 255.0F), 255, 255, 255);
                    float var5 = this.xCord - var7.cw;
                    float var6 = this.yCord - var7.cx - this.zCord;
                    var7.bO.a(var3, var5, var6, this.d(false) - 90.0F, this.k);
                }
            }

            return true;
        }
    }

    public strictfp boolean l() {
        return true;
    }

    public strictfp boolean af() {
        return true;
    }

    public strictfp float g(int var1) {
        return 8.0F;
    }

    public strictfp PointF G(int var1) {
        float var2 = this.xCord;
        float var3 = this.yCord;
        bh.setSite(var2, var3);
        return bh;
    }

    public strictfp int bl() {
        return 1;
    }

    public strictfp boolean bi() {
        return true;
    }

    public strictfp boolean bj() {
        return true;
    }

    public strictfp int cw() {
        return 5;
    }

    public strictfp boolean dd() {
        return true;
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
