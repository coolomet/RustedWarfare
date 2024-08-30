package com.corrodinggames.rts.game.units.land;

import android.graphics.PointF;
import android.graphics.Rect;
import com.corrodinggames.rts.AssetsID$drawable;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.Projectile;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.a.class_648;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;

// $FF: renamed from: com.corrodinggames.rts.game.units.e.o
public strictfp class TankDestroyer extends class_120 {
    static TeamImageCache a = null;
    static TeamImageCache b = null;
    static TeamImageCache c = null;
    static TeamImageCache[] d = new TeamImageCache[10];
    Rect e = new Rect();

    public strictfp UnitType b() {
        return UnitType.tankDestroyer;
    }

    public static strictfp void f() {
        GameEngine var0 = GameEngine.getGameEngine();
        b = var0.bO.a(AssetsID$drawable.tank2);
        a = var0.bO.a(AssetsID$drawable.tank2_dead);
        c = var0.bO.a(AssetsID$drawable.tank2_turret);
        d = PlayerData.a(b);
    }

    public strictfp TeamImageCache d() {
        return this.bV ? a : d[this.bX.R()];
    }

    public strictfp TeamImageCache k() {
        return null;
    }

    public strictfp TeamImageCache d(int var1) {
        return c;
    }

    public strictfp boolean e() {
        GameEngine var1 = GameEngine.getGameEngine();
        var1.bR.b(this.xCord, this.yCord, this.zCord);
        this.M = a;
        this.S(0);
        this.bT = false;
        var1.bM.a(class_648.o, 0.8F, this.xCord, this.yCord);
        this.bq();
        return true;
    }

    public TankDestroyer(boolean var1) {
        super(var1);
        this.T(16);
        this.U(30);
        this.cj = 11.0F;
        this.ck = this.cj + 2.0F;
        this.totalHealth = 350.0F;
        this.health = this.totalHealth;
        this.M = b;
    }

    public strictfp void a(float var1) {
        super.a(var1);
    }

    public strictfp void a(Unit var1, int var2) {
        PointF var3 = this.E(var2);
        Projectile var4 = Projectile.a(this, var3.x, var3.y);
        var4.U = 35.0F;
        var4.l = var1;
        var4.h = 60.0F;
        var4.t = 3.0F;
        GameEngine var5 = GameEngine.getGameEngine();
        var5.bR.a(var3.x, var3.y, this.zCord, -1127220);
        var5.bR.a(var3.x, var3.y, this.zCord, this.cL[var2].a);
        var5.bM.a(class_648.q, 0.3F, var3.x, var3.y);
    }

    public strictfp float attackRange() {
        return 150.0F;
    }

    public strictfp float shootDelay(int var1) {
        return 70.0F;
    }

    public strictfp float speed() {
        return 1.0F;
    }

    public strictfp float turnSpeed() {
        return 1.9F;
    }

    public strictfp float c(int var1) {
        return 3.0F;
    }

    public strictfp boolean c(float var1) {
        return super.c(var1);
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
        return false;
    }

    public strictfp float g(int var1) {
        return 10.0F;
    }

    // $FF: synthetic method
    public class_31 r() {
        return this.b();
    }
}
