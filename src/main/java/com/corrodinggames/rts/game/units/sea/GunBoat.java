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
import com.corrodinggames.rts.gameFramework.a.class_648;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;

// $FF: renamed from: com.corrodinggames.rts.game.units.h.c
public strictfp class GunBoat extends class_114 {
    static TeamImageCache a = null;
    static TeamImageCache b = null;
    static TeamImageCache c = null;
    static TeamImageCache[] d = new TeamImageCache[10];
    Rect e = new Rect();

    public strictfp UnitType b() {
        return UnitType.gunBoat;
    }

    public strictfp float mass() {
        return 1500.0F;
    }

    public static strictfp void f() {
        GameEngine var0 = GameEngine.getGameEngine();
        b = var0.bO.a(AssetsID$drawable.gun_boat);
        a = var0.bO.a(AssetsID$drawable.gun_boat_dead);
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
        return 1.0F;
    }

    public strictfp float H() {
        return 1.0F;
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

    public GunBoat(boolean var1) {
        super(var1);
        this.T(15);
        this.U(27);
        this.cj = 12.0F;
        this.ck = this.cj - 2.0F;
        this.totalHealth = 170.0F;
        this.health = this.totalHealth;
        this.M = b;
    }

    public strictfp void a(float var1) {
        super.a(var1);
    }

    public strictfp float q(int var1) {
        return 12.0F;
    }

    public strictfp void a(Unit var1, int var2) {
        PointF var3 = this.E(var2);
        Projectile var4 = Projectile.a(this, var3.x, var3.y);
        PointF var5 = this.K(var2);
        var4.K = var5.x;
        var4.L = var5.y;
        var4.zCord = this.zCord;
        var4.U = this.q(var2);
        var4.l = var1;
        var4.h = 30.0F;
        var4.t = 8.0F;
        var4.S = false;
        var4.ar = Color.a(255, 180, 180, 0);
        GameEngine var6 = GameEngine.getGameEngine();
        var6.bM.a(class_648.s, 0.2F, var3.x, var3.y);
        var6.bR.a(var3.x, var3.y, this.zCord, this.cL[var2].a);
        var6.bR.a(var3.x, var3.y, this.zCord, -1118720);
    }

    public strictfp float attackRange() {
        return 120.0F;
    }

    public strictfp float shootDelay(int var1) {
        return 60.0F;
    }

    public strictfp float speed() {
        return 1.5F;
    }

    public strictfp float turnSpeed() {
        return 2.8F;
    }

    public strictfp float B() {
        return 0.35F;
    }

    public strictfp float c(int var1) {
        return 99.0F;
    }

    public strictfp float C() {
        return 0.06F;
    }

    public strictfp float D() {
        return 0.2F;
    }

    public strictfp boolean c(float var1) {
        return super.c(var1);
    }

    public strictfp boolean l() {
        return true;
    }

    public strictfp boolean af() {
        return false;
    }

    // $FF: synthetic method
    public class_31 r() {
        return this.b();
    }
}
