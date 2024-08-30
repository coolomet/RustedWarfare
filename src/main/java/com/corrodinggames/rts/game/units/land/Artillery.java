package com.corrodinggames.rts.game.units.land;

import android.graphics.Color;
import android.graphics.PointF;
import com.corrodinggames.rts.AssetsID$drawable;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.Projectile;
import com.corrodinggames.rts.game.units.ExplodeType;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.a.class_648;
import com.corrodinggames.rts.gameFramework.d.class_998;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.utility.class_694;

// $FF: renamed from: com.corrodinggames.rts.game.units.e.a
public strictfp class Artillery extends class_120 {
    static TeamImageCache a = null;
    static TeamImageCache b = null;
    static TeamImageCache c = null;
    static TeamImageCache[] d = new TeamImageCache[10];

    public strictfp UnitType b() {
        return UnitType.artillery;
    }

    public static strictfp void f() {
        GameEngine var0 = GameEngine.getGameEngine();
        a = var0.bO.a(AssetsID$drawable.artillery2);
        b = var0.bO.a(AssetsID$drawable.artillery1_dead);
        d = PlayerData.a(a);
        c = a(a);
    }

    public strictfp TeamImageCache d() {
        return this.bV ? b : d[this.bX.R()];
    }

    public strictfp TeamImageCache k() {
        return c;
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
        return null;
    }

    public strictfp boolean e() {
        GameEngine var1 = GameEngine.getGameEngine();
        this.M = b;
        this.S(0);
        this.bT = false;
        this.a(ExplodeType.normal);
        return true;
    }

    public Artillery(boolean var1) {
        super(var1);
        this.T(28);
        this.U(50);
        this.cj = 18.0F;
        this.ck = this.cj;
        this.totalHealth = 140.0F;
        this.health = this.totalHealth;
        this.M = a;
    }

    public strictfp void a(float var1) {
        super.a(var1);
    }

    public strictfp void a(Unit var1, int var2) {
        PointF var3 = this.E(var2);
        Projectile var4 = Projectile.a(this, var3.x, var3.y);
        PointF var5 = this.K(var2);
        var4.K = var5.x;
        var4.L = var5.y;
        var4.h = 150.0F;
        var4.t = 4.0F;
        var4.aQ = true;
        var4.ar = Color.a(255, 190, 190, 80);
        var4.R = 2;
        var4.P = 1;
        var4.x = 0.9F;
        PointF var6 = var1.a(var3.x, var3.y, var4.t, var4.h, this.attackRange());
        var4.aC = true;
        var4.m = true;
        var4.n = var6.x;
        var4.o = var6.y;
        var4.Y = 80.0F;
        var4.Z = 45.0F;
        var4.aa = true;
        GameEngine var7 = GameEngine.getGameEngine();
        var7.bM.a(class_648.r, 0.3F, var3.x, var3.y);
        var7.bR.a(var3.x, var3.y, this.zCord, this.cL[var2].a);
        class_998 var8 = var7.bR.a(var3.x, var3.y, this.zCord, -1118482);
        if (var8 != null) {
            var8.V = 15.0F;
            var8.W = var8.V;
        }

    }

    public strictfp float bW() {
        return this.cL[0].e > 0.0F ? 1.0F - this.cL[0].e / this.shootDelay(0) : super.bW();
    }

    public strictfp float attackRange() {
        return 290.0F;
    }

    public strictfp float shootDelay(int var1) {
        return 240.0F;
    }

    public strictfp float speed() {
        return 0.9F;
    }

    public strictfp float turnSpeed() {
        return 1.7F;
    }

    public strictfp float B() {
        return 0.05F;
    }

    public strictfp float c(int var1) {
        return 99.0F;
    }

    public strictfp boolean l() {
        return true;
    }

    public strictfp boolean af() {
        return false;
    }

    public strictfp boolean E() {
        return true;
    }

    public strictfp float g(int var1) {
        return 20.0F;
    }

    public strictfp float C() {
        return 0.05F;
    }

    public strictfp float D() {
        return 0.12F;
    }

    public strictfp void e(float var1) {
        super.e(var1);
        float var2 = this.attackRange();
        class_694.a(this, var2);
    }

    public strictfp float mass() {
        return 14000.0F;
    }

    // $FF: synthetic method
    public class_31 r() {
        return this.b();
    }
}
