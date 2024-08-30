package com.corrodinggames.rts.game.units.buildings.turrets;

import android.graphics.Color;
import android.graphics.PointF;
import com.corrodinggames.rts.AssetsID$drawable;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.Projectile;
import com.corrodinggames.rts.game.units.class_1048;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.a.class_1059;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.buildings.class_73;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.a.class_648;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import java.util.ArrayList;

// $FF: renamed from: com.corrodinggames.rts.game.units.d.a.a
public strictfp class AntiAirTurret extends Turret {
    static TeamImageCache a = null;
    static TeamImageCache b = null;
    static TeamImageCache c = null;
    static TeamImageCache[] d = new TeamImageCache[10];
    public static class_226 e = new class_298(102);
    static ArrayList f = new ArrayList();

    public strictfp TeamImageCache v() {
        return this.bX.site == -1 ? null : d[this.bX.R()];
    }

    public static strictfp void b() {
        GameEngine var0 = GameEngine.getGameEngine();
        a = var0.bO.a(AssetsID$drawable.anti_air_top);
        b = var0.bO.a(AssetsID$drawable.anti_air_top_l2);
        c = var0.bO.a(AssetsID$drawable.unit_icon_building_air_turrent);
        d = PlayerData.a(c);
    }

    public AntiAirTurret(boolean var1) {
        super(var1);
        this.totalHealth = 800.0F;
        this.health = this.totalHealth;
    }

    public strictfp float attackRange() {
        return !this.j ? 250.0F : 320.0F;
    }

    public strictfp float shootDelay(int var1) {
        return !this.j ? 80.0F : 70.0F;
    }

    public strictfp float e(int var1) {
        if (!this.j) {
            return super.e(var1);
        } else {
            return var1 == 2 ? 25.0F : super.e(var1);
        }
    }

    public strictfp PointF E(int var1) {
        if (this.j && var1 != 0) {
            float var2 = this.E() ? this.cg : this.cL[var1].a;
            PointF var3 = this.G(var1);
            var2 += var1 == 1 ? -30.0F : 30.0F;
            float var4 = var3.x + class_340.k(var2) * 10.0F;
            float var5 = var3.y + class_340.j(var2) * 10.0F;
            bg.setSite(var4, var5);
            return bg;
        } else {
            return super.E(var1);
        }
    }

    public strictfp void a(Unit var1, int var2) {
        PointF var3 = this.E(var2);
        Projectile var4 = Projectile.a(this, var3.x, var3.y);
        PointF var5 = this.K(var2);
        var4.K = var5.x;
        var4.L = var5.y;
        var4.t = 0.3F;
        var4.r = 6.0F;
        if (!this.j) {
            var4.ar = Color.a(255, 230, 230, 50);
            var4.U = 60.0F;
            var4.h = 220.0F;
        } else {
            var4.ar = Color.a(255, 230, 50, 50);
            var4.U = 60.0F;
            var4.h = 250.0F;
            var4.t = 0.5F;
            var4.r = 7.0F;
        }

        var4.P = 4;
        var4.x = 1.0F;
        var4.l = var1;
        var4.aH = false;
        var4.aI = 0.0F;
        var4.aJ = 0.0F;
        var4.aM = true;
        var4.aQ = true;
        var4.aG = true;
        GameEngine var6 = GameEngine.getGameEngine();
        float var7 = 1.0F + class_340.c(-0.07F, 0.07F);
        var6.bM.a(class_648.m, 0.3F, var7, var3.x, var3.y);
        var6.bR.a(var4, -1118720);
        var6.bR.a(var3.x, var3.y, this.zCord, -1127220);
    }

    public strictfp UnitType K() {
        return this.j ? UnitType.antiAirTurretT2 : UnitType.antiAirTurret;
    }

    public strictfp TeamImageCache d(int var1) {
        return !this.j ? a : b;
    }

    public strictfp boolean af() {
        return true;
    }

    public strictfp boolean ag() {
        return false;
    }

    public strictfp void s(float var1) {
        byte var2 = 0;
        if (this.cL[var2].a()) {
            class_1048 var10000 = this.cL[var2];
            var10000.a += this.c(var2) * var1 * 0.1F;
        }

    }

    public strictfp float g(int var1) {
        return 9.0F;
    }

    public strictfp float c(int var1) {
        return 6.0F;
    }

    public strictfp float B() {
        return 1.0F;
    }

    public strictfp boolean u(int var1) {
        if (!this.j) {
            return super.u(var1);
        } else {
            return var1 == 0 ? false : super.u(var1);
        }
    }

    public strictfp int v(int var1) {
        if (!this.j) {
            return -1;
        } else if (var1 == 1) {
            return 0;
        } else {
            return var1 == 2 ? 0 : -1;
        }
    }

    public strictfp int bl() {
        return 3;
    }

    public strictfp boolean r(int var1) {
        return this.j || var1 <= 1;
    }

    public strictfp void a(class_73 var1) {
        if (var1.j.equals(e.N())) {
            this.a(2);
            this.W();
        }

    }

    public strictfp class_1059 cm() {
        return !this.j ? e.N() : class_226.i;
    }

    public strictfp void a(ArrayList var1) {
        var1.clear();
    }

    public strictfp void a(int var1) {
        if (var1 == 1) {
            this.j = false;
        } else if (var1 == 2 && !this.j) {
            this.j = true;
            this.totalHealth += 600.0F;
            this.health += 600.0F;
        }

    }

    public strictfp ArrayList N() {
        return f;
    }

    // $FF: synthetic method
    public class_31 r() {
        return this.K();
    }

    static {
        f.add(e);
    }
}
