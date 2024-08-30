package com.corrodinggames.rts.game.units.land;

import android.graphics.Color;
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
import com.corrodinggames.rts.gameFramework.a.class_648;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.utility.class_694;

// $FF: renamed from: com.corrodinggames.rts.game.units.e.k
public strictfp class LaserTank extends class_120 {
    static TeamImageCache a = null;
    static TeamImageCache b = null;
    static TeamImageCache c = null;
    static TeamImageCache d = null;
    static TeamImageCache[] e = new TeamImageCache[10];
    static TeamImageCache f = null;
    Rect g = new Rect();

    public strictfp UnitType b() {
        return UnitType.laserTank;
    }

    public static strictfp void f() {
        GameEngine var0 = GameEngine.getGameEngine();
        b = var0.bO.a(AssetsID$drawable.laser_tank_base);
        a = var0.bO.a(AssetsID$drawable.laser_tank_dead);
        c = var0.bO.a(AssetsID$drawable.laser_tank_turrent);
        d = var0.bO.a(AssetsID$drawable.laser_tank_charge);
        e = PlayerData.a(b);
        f = a(b, b.m(), b.l());
    }

    public strictfp TeamImageCache d() {
        return this.bV ? a : e[this.bX.R()];
    }

    public strictfp TeamImageCache k() {
        return f;
    }

    public strictfp boolean F() {
        return GameEngine.getGameEngine().settingsEngine.renderExtraShadows && !this.bV;
    }

    public strictfp float G() {
        return 2.0F;
    }

    public strictfp float H() {
        return 2.0F;
    }

    public strictfp TeamImageCache d(int var1) {
        return c;
    }

    public strictfp boolean e() {
        GameEngine var1 = GameEngine.getGameEngine();
        this.M = a;
        this.S(0);
        this.bT = false;
        this.a(ExplodeType.small);
        return true;
    }

    public LaserTank(boolean var1) {
        super(var1);
        this.a(b, 1);
        this.cj = 14.0F;
        this.ck = this.cj + 2.0F;
        this.totalHealth = 300.0F;
        this.health = this.totalHealth;
        this.M = b;
    }

    public strictfp void a(float var1) {
        super.a(var1);
    }

    public strictfp float q(int var1) {
        return 450.0F;
    }

    public strictfp void a(Unit var1, int var2) {
        PointF var3 = this.E(var2);
        Projectile var4 = Projectile.a(this, var3.x, var3.y);
        var4.U = this.q(var2);
        var4.l = var1;
        var4.h = 8.0F;
        var4.B = true;
        var4.A = true;
        var4.aQ = true;
        var4.ar = Color.a(80, 255, 0, 0);
        GameEngine var5 = GameEngine.getGameEngine();
        var5.bR.a(var3.x, var3.y, this.zCord, -1127220);
        var5.bR.a(var3.x, var3.y, this.zCord, this.cL[var2].a);
        var5.bM.a(class_648.y, 0.3F, var3.x, var3.y);
    }

    public strictfp float bW() {
        if (this.cL[0].e > 0.0F) {
            return 1.0F - this.cL[0].e / this.shootDelay(0);
        } else {
            return this.cL[0].f != 0.0F ? this.cL[0].f / this.e(0) : super.bW();
        }
    }

    public strictfp boolean bX() {
        return this.cL[0].e > 0.0F;
    }

    public strictfp float attackRange() {
        return 190.0F;
    }

    public strictfp float shootDelay(int var1) {
        return 450.0F;
    }

    public strictfp float e(int var1) {
        return 80.0F;
    }

    public strictfp float speed() {
        return 0.7F;
    }

    public strictfp float turnSpeed() {
        return 1.5F;
    }

    public strictfp float B() {
        return 0.1F;
    }

    public strictfp float c(int var1) {
        return 3.0F;
    }

    public strictfp boolean c(float var1) {
        if (!super.c(var1)) {
            return false;
        } else {
            GameEngine var2 = GameEngine.getGameEngine();
            class_694.a((OrderableUnit)this);
            if (!this.bV) {
                float var3 = this.cL[0].f / this.e(0);
                if (var3 != 0.0F) {
                    PointF var4 = this.E(0);
                    var2.bO.i();
                    var2.bO.b(var4.x - var2.cw, var4.y - var2.cx);
                    var2.bO.a(var3, var3);
                    var2.bO.a((TeamImageCache)d, 0.0F, 0.0F, (Paint)null);
                    var2.bO.j();
                }
            }

            return true;
        }
    }

    public strictfp float C() {
        return 0.07F;
    }

    public strictfp float D() {
        return 0.12F;
    }

    public strictfp boolean l() {
        return true;
    }

    public strictfp boolean af() {
        return true;
    }

    public strictfp float g(int var1) {
        return 19.0F;
    }

    // $FF: synthetic method
    public class_31 r() {
        return this.b();
    }
}
