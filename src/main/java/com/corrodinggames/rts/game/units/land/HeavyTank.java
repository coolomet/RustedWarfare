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

// $FF: renamed from: com.corrodinggames.rts.game.units.e.f
public strictfp class HeavyTank extends class_120 {
    static TeamImageCache a = null;
    static TeamImageCache b = null;
    static TeamImageCache[] c = new TeamImageCache[10];
    static TeamImageCache d = null;
    int e;
    float f;
    float g;
    Rect h = new Rect();

    public strictfp UnitType b() {
        return UnitType.heavyTank;
    }

    public static strictfp void f() {
        GameEngine var0 = GameEngine.getGameEngine();
        TeamImageCache var1 = var0.bO.a(AssetsID$drawable.heavy_tank);
        c = PlayerData.a(var1);
        a = var0.bO.a(AssetsID$drawable.heavy_tank_dead);
        b = var0.bO.a(AssetsID$drawable.heavy_tank_turret);
        d = a(var1, var1.m() / 3, var1.l());
    }

    public strictfp TeamImageCache d() {
        return this.bV ? a : c[this.bX.R()];
    }

    public strictfp TeamImageCache k() {
        return d;
    }

    public strictfp TeamImageCache d(int var1) {
        return b;
    }

    public strictfp boolean F() {
        return GameEngine.getGameEngine().settingsEngine.renderExtraShadows && !this.bV && this.cm >= 1.0F && !this.cq;
    }

    public strictfp float G() {
        return 2.0F;
    }

    public strictfp float H() {
        return 2.0F;
    }

    public strictfp boolean e() {
        this.M = a;
        this.S(0);
        this.bT = false;
        this.a(ExplodeType.normal);
        return true;
    }

    public HeavyTank(boolean var1) {
        super(var1);
        this.a(c[7], 3);
        this.cj = 15.0F;
        this.ck = this.cj + 1.0F;
        this.totalHealth = 600.0F;
        this.health = this.totalHealth;
        this.M = c[7];
    }

    public strictfp void a(float var1) {
        super.a(var1);
        if (!this.bV) {
            if (this.cf != 0.0F) {
                this.f += var1;
                if ((double)this.f > 1.4) {
                    this.f = 0.0F;
                    ++this.e;
                    if (this.e > 2) {
                        this.e = 0;
                    }
                }

                if (this.el) {
                    this.g += var1;
                    if (this.g > 9.0F) {
                        this.g = 0.0F;
                        this.K();
                    }
                }
            }

        }
    }

    public strictfp void K() {
        GameEngine var1 = GameEngine.getGameEngine();
        float var2 = this.cg;
        if (this.cf < 0.0F) {
            var2 += 180.0F;
        }

        for(int var3 = 0; var3 <= 1; ++var3) {
            float var4 = (float)(var3 == 0 ? -20 : 20);
            float var5 = this.xCord + class_340.k(var2 + 180.0F + var4) * this.cj;
            float var6 = this.yCord + class_340.j(var2 + 180.0F + var4) * this.cj;
            var1.bR.c(var5, var6, this.zCord, var2 + 180.0F, 0);
        }

    }

    public strictfp float mass() {
        return 7000.0F;
    }

    public strictfp float q(int var1) {
        return 50.0F;
    }

    public strictfp void a(Unit var1, int var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        PointF var4;
        Projectile var5;
        if (!var1.i()) {
            var4 = this.E(var2);
            var5 = Projectile.a(this, var4.x, var4.y);
            PointF var6 = this.K(var2);
            var5.K = var6.x;
            var5.L = var6.y;
            var5.ar = Color.a(235, 150, 230, 40);
            var5.U = this.q(var2);
            var5.l = var1;
            var5.h = 60.0F;
            var5.t = 4.0F;
            var5.x = 2.0F;
            var5.aQ = true;
            var5.z = true;
            var3.bR.a(var5, -16716288);
            var3.bR.a(var4.x, var4.y, this.zCord, -1127220);
            var3.bR.a(var4.x, var4.y, this.zCord, this.cL[var2].a);
            var3.bM.a(class_648.u, 0.3F, this.xCord, this.yCord);
        } else {
            var4 = this.E(var2);
            var4.setSite(this.xCord, this.yCord);
            var5 = Projectile.a(this, this.xCord, this.yCord);
            var5.ar = Color.a(255, 230, 230, 50);
            var5.U = this.q(var2);
            var5.l = var1;
            var5.h = 190.0F;
            var5.t = 0.5F;
            var5.r = 5.0F;
            var5.aH = true;
            var5.aI = 10.0F;
            var5.aJ = 15.0F;
            var5.aM = true;
            var5.aQ = true;
            var5.aG = true;
            var3.bM.a(class_648.m, 0.2F, this.xCord, this.yCord);
            var3.bR.a(var5, -1118720);
            var3.bR.a(var4.x, var4.y, this.zCord, -1127220);
        }

    }

    public strictfp float attackRange() {
        return 160.0F;
    }

    public strictfp float shootDelay(int var1) {
        return 70.0F;
    }

    public strictfp float speed() {
        return 0.8F;
    }

    public strictfp float bc() {
        return 1.0F;
    }

    public strictfp float turnSpeed() {
        return 1.9F;
    }

    public strictfp float B() {
        return 0.2F;
    }

    public strictfp float w(int var1) {
        return 0.12F;
    }

    public strictfp float c(int var1) {
        return 3.0F;
    }

    public strictfp float C() {
        return 0.05F;
    }

    public strictfp float D() {
        return 0.1F;
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
        return 21.0F;
    }

    public strictfp Rect a_(boolean var1) {
        if (var1) {
            return super.a_(var1);
        } else {
            return this.bV ? super.a_(var1) : super.a(var1, this.e);
        }
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
