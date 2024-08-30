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
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.a.class_648;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.utility.class_694;

// $FF: renamed from: com.corrodinggames.rts.game.units.e.d
public strictfp class ExperimentalTank extends class_120 {
    static TeamImageCache a = null;
    static TeamImageCache b = null;
    static TeamImageCache c = null;
    static TeamImageCache[] d = new TeamImageCache[10];
    int e;
    float f;
    Rect g = new Rect();

    public strictfp UnitType b() {
        return UnitType.experimentalTank;
    }

    public static strictfp void f() {
        GameEngine var0 = GameEngine.getGameEngine();
        TeamImageCache var1 = var0.bO.a(AssetsID$drawable.experimental_tank);
        d = PlayerData.a(var1);
        a = var0.bO.a(AssetsID$drawable.experimental_tank_dead);
        b = var0.bO.a(AssetsID$drawable.experimental_tank_turret);
        c = a(var1, var1.m() / 2, var1.l());
    }

    public strictfp TeamImageCache d() {
        return this.bV ? a : d[this.bX.R()];
    }

    public strictfp TeamImageCache k() {
        return c;
    }

    public strictfp boolean F() {
        return GameEngine.getGameEngine().settingsEngine.renderExtraShadows && this.zCord > -2.0F && this.cm >= 1.0F;
    }

    public strictfp float G() {
        return 4.0F;
    }

    public strictfp float H() {
        return 4.0F;
    }

    public strictfp TeamImageCache d(int var1) {
        return this.R(var1) ? null : b;
    }

    public strictfp boolean e() {
        GameEngine var1 = GameEngine.getGameEngine();
        this.a(ExplodeType.largeUnit);
        this.M = a;
        this.S(0);
        this.bT = false;
        return true;
    }

    public ExperimentalTank(boolean var1) {
        super(var1);
        this.a(d[7], 2);
        this.cj = 37.0F;
        this.ck = this.cj + 1.0F;
        this.totalHealth = 6000.0F;
        this.health = this.totalHealth;
        this.M = d[7];
    }

    public strictfp void a(float var1) {
        super.a(var1);
        if (!this.bV) {
            if (this.cl != 0.0F) {
                this.S(2);
            } else {
                this.S(4);
            }
        }

        if (this.cK) {
            this.f += var1;
            if (this.f > 5.0F) {
                this.f = 0.0F;
                this.e = 1 - this.e;
            }
        }

    }

    public strictfp float mass() {
        return 80000.0F;
    }

    public strictfp void a(Unit var1, int var2) {
        PointF var3;
        Projectile var4;
        if (!this.R(var2)) {
            var3 = this.E(var2);
            var4 = Projectile.a(this, var3.x, var3.y);
            PointF var5 = this.K(var2);
            var4.K = var5.x;
            var4.L = var5.y;
            var4.ar = Color.a(255, 247, 212, 129);
            var4.h = 120.0F;
            var4.t = 5.0F;
            var4.l = var1;
            var4.Y = 60.0F;
            var4.U = 40.0F;
            var4.Z = 45.0F;
            var4.aa = true;
            var4.x = 2.0F;
            var4.aQ = true;
            var4.P = 9;
            var4.x = 1.0F;
            var4.em = this.em;
            GameEngine var6 = GameEngine.getGameEngine();
            var6.bR.a(var3.x, var3.y, this.zCord, 16745216);
            var6.bR.a(var3.x, var3.y, this.zCord, this.cL[var2].a);
            var6.bR.a(var4, -1127220);
            var6.bM.a(class_648.v, 0.3F, this.xCord, this.yCord);
        } else {
            var3 = this.E(var2);
            var3.setSite(this.xCord, this.yCord);
            var4 = Projectile.a(this, this.xCord, this.yCord);
            var4.ar = Color.a(255, 230, 230, 50);
            var4.U = 60.0F;
            var4.l = var1;
            var4.h = 190.0F;
            var4.t = 3.0F;
            var4.r = 6.0F;
            var4.aH = true;
            var4.aI = 10.0F;
            var4.aJ = 15.0F;
            var4.aM = true;
            var4.aQ = true;
            var4.aG = true;
            var4.em = this.em;
            GameEngine var7 = GameEngine.getGameEngine();
            var7.bM.a(class_648.m, 0.2F, this.xCord, this.yCord);
            var7.bR.a(var4, -1118720);
            var7.bR.a(var3.x, var3.y, this.zCord, -1127220);
        }

    }

    public strictfp boolean a(int var1, Unit var2, boolean var3, boolean var4) {
        if (!var3 && var4 && !this.h(var2)) {
            return false;
        } else {
            if (this.R(var1)) {
                if (!var2.i()) {
                    return false;
                }
            } else if (var2.i()) {
                return false;
            }

            return true;
        }
    }

    public strictfp float attackRange() {
        return 310.0F;
    }

    public strictfp float shootDelay(int var1) {
        if (this.R(var1)) {
            var1 -= 4;
        }

        return (float)(110 - var1 * 20);
    }

    public strictfp float e(int var1) {
        if (this.R(var1)) {
            var1 -= 4;
        }

        return (float)(var1 * 20);
    }

    public strictfp float speed() {
        return 0.4F;
    }

    public strictfp float bc() {
        return 1.0F;
    }

    public strictfp int bh() {
        return 1;
    }

    public strictfp float turnSpeed() {
        return 0.8F;
    }

    public strictfp float B() {
        return 0.04F;
    }

    public strictfp float w(int var1) {
        return this.R(var1) ? 1.0F : 0.08F;
    }

    public strictfp float c(int var1) {
        return this.R(var1) ? 4.5F : 2.5F;
    }

    public strictfp float C() {
        return 0.03F;
    }

    public strictfp float D() {
        return 0.08F;
    }

    public strictfp Rect a_(boolean var1) {
        if (this.bV && !var1) {
            return super.a_(var1);
        } else if (var1) {
            return super.a_(var1);
        } else {
            int var2 = 0;
            byte var3 = 0;
            var2 += this.e * this.es;
            this.g.a(var2, var3, var2 + this.es, var3 + this.et);
            return this.g;
        }
    }

    public strictfp boolean c(float var1) {
        if (!super.c(var1)) {
            return false;
        } else {
            class_694.a((OrderableUnit)this);
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
        return 20.0F;
    }

    public strictfp PointF G(int var1) {
        PointF var2 = super.G(var1);
        float var3 = var2.x;
        float var4 = var2.y;
        if (!this.R(var1)) {
            if (var1 <= 1) {
                var3 += class_340.k(this.cg) * 5.0F;
                var4 += class_340.j(this.cg) * 5.0F;
            }

            float var5 = (float)(-45 + 90 * var1);
            var3 += class_340.k(this.cg + var5) * 18.0F;
            var4 += class_340.j(this.cg + var5) * 18.0F;
        }

        bh.setSite(var3, var4);
        return bh;
    }

    public strictfp boolean R(int var1) {
        return var1 >= 4;
    }

    public strictfp int bl() {
        return 6;
    }

    public strictfp void e(float var1) {
        super.e(var1);
        float var2 = this.attackRange();
        class_694.a(this, var2);
    }

    public strictfp int cw() {
        return 5;
    }

    public strictfp boolean dd() {
        return true;
    }

    public strictfp float H(int var1) {
        return -2.0F;
    }

    public strictfp float I(int var1) {
        return 4.0F;
    }

    public strictfp float J(int var1) {
        return 12.0F;
    }

    // $FF: synthetic method
    public class_31 r() {
        return this.b();
    }
}
