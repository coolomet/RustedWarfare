package com.corrodinggames.rts.game.units.sea;

import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;
import com.corrodinggames.rts.AssetsID$drawable;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.Projectile;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.a.class_648;
import com.corrodinggames.rts.gameFramework.d.class_986;
import com.corrodinggames.rts.gameFramework.d.class_998;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.utility.class_694;

// $FF: renamed from: com.corrodinggames.rts.game.units.h.a
public strictfp class BattleShip extends class_114 {
    static TeamImageCache a = null;
    static TeamImageCache b = null;
    static TeamImageCache c = null;
    static TeamImageCache d = null;
    static TeamImageCache[] e = new TeamImageCache[10];
    Rect f = new Rect();

    public strictfp UnitType b() {
        return UnitType.battleShip;
    }

    public strictfp float mass() {
        return 9000.0F;
    }

    public static strictfp void f() {
        GameEngine var0 = GameEngine.getGameEngine();
        b = var0.bO.a(AssetsID$drawable.battle_ship_t2);
        a = var0.bO.a(AssetsID$drawable.battle_ship_t2_dead);
        c = var0.bO.a(AssetsID$drawable.battle_ship_t2_turret);
        e = PlayerData.a(b);
        d = a(b, b.m(), b.l());
    }

    public strictfp TeamImageCache d() {
        return this.bV ? a : e[this.bX.R()];
    }

    public strictfp TeamImageCache d(int var1) {
        return c;
    }

    public strictfp TeamImageCache k() {
        return d;
    }

    public strictfp boolean F() {
        return GameEngine.getGameEngine().settingsEngine.renderExtraShadows && this.zCord > -2.0F;
    }

    public strictfp float G() {
        return 3.0F;
    }

    public strictfp float H() {
        return 3.0F;
    }

    public strictfp boolean e() {
        GameEngine var1 = GameEngine.getGameEngine();
        var1.bR.b(this.xCord, this.yCord, this.zCord);
        this.M = a;
        this.S(0);
        this.bT = false;
        return true;
    }

    public BattleShip(boolean var1) {
        super(var1);
        this.b(b);
        this.cj = 20.0F;
        this.ck = this.cj;
        this.totalHealth = 1200.0F;
        this.health = this.totalHealth;
        this.M = b;
    }

    public strictfp void a(float var1) {
        super.a(var1);
    }

    public strictfp float q(int var1) {
        return 65.0F;
    }

    public strictfp void a(Unit var1, int var2) {
        PointF var3 = this.E(var2);
        Projectile var4 = Projectile.a(this, var3.x, var3.y, this.zCord, var2);
        PointF var5 = this.K(var2);
        var4.K = var5.x;
        var4.L = var5.y;
        var4.U = this.q(var2);
        var4.l = var1;
        var4.h = 80.0F;
        var4.x = 2.0F;
        var4.t = 4.0F;
        var4.S = true;
        var4.ar = Color.a(255, 180, 180, 0);
        var4.aQ = true;
        GameEngine var6 = GameEngine.getGameEngine();
        var6.bM.a(class_648.r, 0.2F, var3.x, var3.y);
        var6.bR.a(var4, -1118720);
        class_998 var7 = var6.bR.a(var3.x, var3.y, this.zCord, this.cL[var2].a);
        if (var7 != null) {
            class_986.a(var7, this);
        }

        var6.bR.a(var3.x, var3.y, this.zCord, -1118720);
    }

    public strictfp float attackRange() {
        return 240.0F;
    }

    public strictfp float speed() {
        return 0.8F;
    }

    public strictfp float bc() {
        return 1.0F;
    }

    public strictfp float C(int var1) {
        if (this.ci && (double)this.bc() > 0.95) {
            return var1 == 0 ? this.cg + 140.0F : this.cg - 140.0F;
        } else {
            return this.cg;
        }
    }

    public strictfp float turnSpeed() {
        return 1.8F;
    }

    public strictfp float B() {
        return 0.08F;
    }

    public strictfp float c(int var1) {
        return 2.5F;
    }

    public strictfp float w(int var1) {
        return 0.08F;
    }

    public strictfp float C() {
        return 0.03F;
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
        return false;
    }

    public strictfp float g(int var1) {
        return 15.0F;
    }

    public strictfp int bl() {
        return 2;
    }

    public strictfp PointF G(int var1) {
        PointF var2 = super.G(var1);
        float var3 = var2.x;
        float var4 = var2.y;
        float var5;
        if (var1 == 0) {
            var5 = 22.0F;
        } else {
            var5 = 4.0F;
        }

        var3 += class_340.k(this.cg) * var5;
        var4 += class_340.j(this.cg) * var5;
        bh.setSite(var3, var4);
        return bh;
    }

    public strictfp float shootDelay(int var1) {
        return (float)(120 - var1 * 28);
    }

    public strictfp float e(int var1) {
        return (float)(var1 * 30);
    }

    public strictfp void e(float var1) {
        super.e(var1);
        float var2 = this.attackRange();
        class_694.a(this, var2);
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
