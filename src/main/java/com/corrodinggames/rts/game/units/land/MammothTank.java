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
import com.corrodinggames.rts.gameFramework.a.class_648;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.utility.class_694;

// $FF: renamed from: com.corrodinggames.rts.game.units.e.l
public strictfp class MammothTank extends class_120 {
    static TeamImageCache a = null;
    static TeamImageCache b = null;
    static TeamImageCache[] c = new TeamImageCache[10];
    static TeamImageCache d = null;
    public static TeamImageCache e = null;
    int f;
    float g;
    Rect h = new Rect();

    public strictfp UnitType b() {
        return UnitType.mammothTank;
    }

    public static strictfp void f() {
        GameEngine var0 = GameEngine.getGameEngine();
        TeamImageCache var1 = var0.bO.a(AssetsID$drawable.mammoth_tank);
        c = PlayerData.a(var1);
        a = var0.bO.a(AssetsID$drawable.mammoth_tank_dead);
        b = var0.bO.a(AssetsID$drawable.mammoth_tank_turret);
        e = var0.bO.a(AssetsID$drawable.lighting_charge);
        d = a(var1, var1.m() / 2, var1.l());
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
        return GameEngine.getGameEngine().settingsEngine.renderExtraShadows && this.zCord > -2.0F && !this.bV;
    }

    public strictfp float G() {
        return 3.0F;
    }

    public strictfp float H() {
        return 3.0F;
    }

    public strictfp boolean e() {
        GameEngine var1 = GameEngine.getGameEngine();
        this.M = a;
        this.S(0);
        this.bT = false;
        this.a(ExplodeType.largeUnit);
        return true;
    }

    public MammothTank(boolean var1) {
        super(var1);
        this.a(c[7], 2);
        this.cj = 21.0F;
        this.ck = this.cj + 1.0F;
        this.totalHealth = 2900.0F;
        this.health = this.totalHealth;
        this.M = c[7];
    }

    public strictfp void a(float var1) {
        super.a(var1);
        if (this.cK) {
            this.g += var1;
            if (this.g > 3.0F) {
                this.g = 0.0F;
                this.f = 1 - this.f;
            }
        }

    }

    public strictfp float mass() {
        return 14000.0F;
    }

    public strictfp void a(Unit var1, int var2) {
        PointF var3 = this.E(var2);
        Projectile var4 = Projectile.a(this, var3.x, var3.y);
        var4.ar = Color.a(255, 247, 212, 129);
        var4.U = 260.0F;
        var4.l = var1;
        var4.h = 20.0F;
        var4.t = 4.0F;
        var4.x = 2.0F;
        var4.aQ = true;
        var4.A = true;
        var4.M = true;
        var4.ai = 0.5F;
        var4.ak = 1.0F;
        var4.al = 0.0F;
        GameEngine var5 = GameEngine.getGameEngine();
        var5.bR.a(var3.x, var3.y, this.zCord, -1118482);
        var5.bM.a(class_648.x, 0.2F, this.xCord, this.yCord);
    }

    public strictfp float attackRange() {
        return 210.0F;
    }

    public strictfp float shootDelay(int var1) {
        return 140.0F;
    }

    public strictfp float speed() {
        return 0.5F;
    }

    public strictfp float bc() {
        return 1.0F;
    }

    public strictfp float turnSpeed() {
        return 1.0F;
    }

    public strictfp float B() {
        return 0.5F;
    }

    public strictfp float w(int var1) {
        return 0.08F;
    }

    public strictfp float c(int var1) {
        return 2.5F;
    }

    public strictfp float C() {
        return 0.04F;
    }

    public strictfp float D() {
        return 0.08F;
    }

    public strictfp Rect a_(boolean var1) {
        return this.bV && !var1 ? super.a_(var1) : super.a(var1, this.f);
    }

    public strictfp boolean c(float var1) {
        if (!super.c(var1)) {
            return false;
        } else {
            class_694.a((OrderableUnit)this);
            float var2 = this.cL[0].f / this.e(0);
            class_694.a(this, e, var2, 0);
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
        return 22.0F;
    }

    public strictfp float e(int var1) {
        return 60.0F;
    }

    // $FF: synthetic method
    public class_31 r() {
        return this.b();
    }
}
