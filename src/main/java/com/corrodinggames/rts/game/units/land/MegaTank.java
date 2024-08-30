package com.corrodinggames.rts.game.units.land;

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
import com.corrodinggames.rts.gameFramework.a.class_648;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.utility.class_694;

// $FF: renamed from: com.corrodinggames.rts.game.units.e.m
public strictfp class MegaTank extends class_120 {
    static TeamImageCache a = null;
    static TeamImageCache b = null;
    static TeamImageCache c = null;
    static TeamImageCache[] d = new TeamImageCache[10];
    Rect e = new Rect();

    public strictfp UnitType b() {
        return UnitType.megaTank;
    }

    public static strictfp void f() {
        GameEngine var0 = GameEngine.getGameEngine();
        b = var0.bO.a(AssetsID$drawable.mega_tank);
        a = var0.bO.a(AssetsID$drawable.mega_tank_dead);
        c = var0.bO.a(AssetsID$drawable.mega_tank_turret);
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

    public MegaTank(boolean var1) {
        super(var1);
        this.T(20);
        this.U(25);
        this.cj = 12.0F;
        this.ck = this.cj + 1.0F;
        this.totalHealth = 550.0F;
        this.health = this.totalHealth;
        this.M = b;
    }

    public strictfp void a(float var1) {
        super.a(var1);
    }

    public strictfp float mass() {
        return 7000.0F;
    }

    public strictfp void a(Unit var1, int var2) {
        if (!var1.i()) {
            PointF var3 = this.E(var2);
            Projectile var4 = Projectile.a(this, var3.x, var3.y);
            var4.ar = Color.a(255, 150, 230, 40);
            var4.U = 50.0F;
            var4.l = var1;
            var4.h = 60.0F;
            var4.t = 3.0F;
            var4.x = 2.0F;
            var4.aQ = true;
            GameEngine var5 = GameEngine.getGameEngine();
            var5.bR.a(var3.x, var3.y, this.zCord, -1127220);
            var5.bR.a(var3.x, var3.y, this.zCord, this.cL[var2].a);
            var5.bM.a(class_648.u, 0.3F, this.xCord, this.yCord);
        } else {
            Projectile var6 = Projectile.a(this, this.xCord, this.yCord);
            var6.ar = Color.a(255, 230, 230, 50);
            var6.U = 40.0F;
            var6.l = var1;
            var6.h = 190.0F;
            var6.t = 4.0F;
            var6.aH = true;
            var6.aI = 10.0F;
            var6.aJ = 15.0F;
            var6.aM = true;
            var6.aQ = true;
            GameEngine var7 = GameEngine.getGameEngine();
            var7.bM.a(class_648.m, 0.2F, this.xCord, this.yCord);
        }

    }

    public strictfp float attackRange() {
        return 140.0F;
    }

    public strictfp float shootDelay(int var1) {
        return 70.0F;
    }

    public strictfp float speed() {
        return 0.8F;
    }

    public strictfp float turnSpeed() {
        return 1.2F;
    }

    public strictfp float c(int var1) {
        return 2.0F;
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
        return 12.0F;
    }

    // $FF: synthetic method
    public class_31 r() {
        return this.b();
    }
}
