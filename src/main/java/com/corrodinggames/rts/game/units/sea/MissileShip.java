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
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.a.class_648;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.utility.class_694;

// $FF: renamed from: com.corrodinggames.rts.game.units.h.d
public strictfp class MissileShip extends class_114 {
    static TeamImageCache a = null;
    static TeamImageCache b = null;
    static TeamImageCache c = null;
    static TeamImageCache[] d = new TeamImageCache[10];
    static PointF e = new PointF();
    Rect f = new Rect();

    public strictfp UnitType b() {
        return UnitType.missileShip;
    }

    public static strictfp void f() {
        GameEngine var0 = GameEngine.getGameEngine();
        b = var0.bO.a(AssetsID$drawable.scout_ship);
        a = var0.bO.a(AssetsID$drawable.scout_ship_dead);
        c = a(b, b.m(), b.l());
        d = PlayerData.a(b);
    }

    public strictfp TeamImageCache d() {
        return this.bV ? a : d[this.bX.R()];
    }

    public strictfp TeamImageCache k() {
        return c;
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

    public MissileShip(boolean var1) {
        super(var1);
        this.T(17);
        this.U(31);
        this.cj = 15.0F;
        this.ck = this.cj - 2.0F;
        this.totalHealth = 350.0F;
        this.health = this.totalHealth;
        this.M = b;
    }

    public strictfp void a(float var1) {
        super.a(var1);
    }

    public strictfp PointF E(int var1) {
        float var2 = 6.0F;
        float var3 = this.cg;
        float var4 = this.xCord + class_340.k(var3) * var2;
        float var5 = this.yCord + class_340.j(var3) * var2;
        e.setSite(var4, var5);
        return e;
    }

    public strictfp float q(int var1) {
        return 62.0F;
    }

    public strictfp void a(Unit var1, int var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        PointF var4 = this.E(var2);
        Projectile var5;
        if (!var1.Q()) {
            var5 = Projectile.a(this, var4.x, var4.y, this.zCord, var2);
            PointF var6 = this.K(var2);
            var5.K = var6.x;
            var5.L = var6.y;
            var5.ar = Color.a(255, 230, 230, 50);
            var5.U = 62.0F;
            var5.l = var1;
            var5.h = 190.0F;
            var5.t = 2.0F;
            var5.aH = true;
            var5.aM = true;
            var5.aQ = true;
            var3.bM.a(class_648.m, 0.8F, this.xCord, this.yCord);
            var3.bR.a(this.xCord, this.yCord, this.zCord, -1118720);
            var3.bR.a(var5, -1118720);
        } else {
            var5 = Projectile.a(this, var4.x, var4.y, this.zCord - 1.0F, var2);
            var5.ar = Color.a(255, 0, 0, 150);
            var5.x = 1.0F;
            var5.U = 42.0F;
            var5.l = var1;
            var5.h = 220.0F;
            var5.t = 1.9F;
            var5.aM = true;
            var5.aQ = true;
            var3.bM.a(class_648.m, 0.8F, this.xCord, this.yCord);
            var3.bR.a(this.xCord, this.yCord, this.zCord, -1118720);
        }

    }

    public strictfp float attackRange() {
        return 200.0F;
    }

    public strictfp float shootDelay(int var1) {
        return 170.0F;
    }

    public strictfp float speed() {
        return 1.2F;
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

    public strictfp float c(int var1) {
        return 99.0F;
    }

    public strictfp float C() {
        return 0.05F;
    }

    public strictfp float D() {
        return 0.1F;
    }

    public strictfp boolean c(float var1) {
        return super.c(var1);
    }

    public strictfp boolean l() {
        return true;
    }

    public strictfp boolean ae() {
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
