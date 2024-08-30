package com.corrodinggames.rts.game.units.land;

import android.graphics.Paint;
import android.graphics.Paint$Cap;
import android.graphics.PointF;
import com.corrodinggames.rts.AssetsID$drawable;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.ExplodeType;
import com.corrodinggames.rts.game.units.class_26;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.a.class_234;
import com.corrodinggames.rts.game.units.a.class_241;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.utility.Point3DF;
import java.util.ArrayList;

// $FF: renamed from: com.corrodinggames.rts.game.units.e.b
public strictfp class Builder extends class_120 implements class_26 {
    static TeamImageCache a = null;
    public static TeamImageCache b = null;
    static TeamImageCache c = null;
    public static TeamImageCache[] d = new TeamImageCache[10];
    public static TeamImageCache e = null;
    public static TeamImageCache f = null;
    static TeamImageCache g = null;
    public static TeamImageCache[] h = new TeamImageCache[10];
    PointF[] i = new PointF[6];
    PointF[] j;
    static Paint k;
    static Paint l;
    static Paint m;
    static class_226 n = new class_234(false);

    public strictfp UnitType f() {
        return UnitType.builder;
    }

    public strictfp PointF[] b() {
        return this.i;
    }

    public strictfp PointF[] e_() {
        return this.j;
    }

    public strictfp TeamImageCache v() {
        return this.bX.site == -1 ? null : h[this.bX.R()];
    }

    public static strictfp void K() {
        GameEngine var0 = GameEngine.getGameEngine();
        a = var0.bO.a(AssetsID$drawable.builder);
        b = var0.bO.a(AssetsID$drawable.builder_dead);
        c = a(a, a.m(), a.l());
        d = PlayerData.a(a);
        e = var0.bO.a(AssetsID$drawable.builder_charge);
        f = var0.bO.a(AssetsID$drawable.builder_decharge);
        g = var0.bO.a(AssetsID$drawable.unit_icon_builder);
        h = PlayerData.a(g);
    }

    public strictfp boolean a(Unit var1) {
        if (var1.q()) {
            return false;
        } else {
            return var1.bI();
        }
    }

    public strictfp TeamImageCache d() {
        return this.bV ? b : d[this.bX.R()];
    }

    public strictfp TeamImageCache k() {
        return c;
    }

    public strictfp TeamImageCache d(int var1) {
        return null;
    }

    public strictfp boolean e() {
        GameEngine var1 = GameEngine.getGameEngine();
        this.M = b;
        this.S(0);
        this.bT = false;
        this.a(ExplodeType.small);
        return true;
    }

    public Builder(boolean var1) {
        super(var1);
        this.j = new PointF[this.i.length];
        k = new Paint();
        k.a(40, 0, 255, 0);
        k.a(true);
        k.a(2.0F);
        k.a(Paint$Cap.b);
        l = new Paint();
        l.a(k);
        l.a(55, 255, 60, 60);
        m = new Paint();
        m.a(60, 255, 255, 255);
        this.T(20);
        this.U(20);
        this.cj = 10.0F;
        this.ck = this.cj + 2.0F;
        this.totalHealth = 170.0F;
        this.health = this.totalHealth;
        this.M = a;

        for(int var2 = 0; var2 < this.i.length; ++var2) {
            this.i[var2] = new PointF();
            this.j[var2] = new PointF();
        }

    }

    public static strictfp void a(float var0, class_26 var1) {
        OrderableUnit var2 = (OrderableUnit)var1;
        PointF[] var3 = var1.b();
        PointF[] var4 = var1.e_();
        Unit var5 = var2.X();
        var2.aN = var5 != null;
        int var6;
        PointF var7;
        PointF var8;
        if (var5 != null) {
            for(var6 = 0; var6 < var3.length; ++var6) {
                var7 = var3[var6];
                var8 = var4[var6];
                var7.x = class_340.a(var7.x, var8.x, 0.1F * var0);
                var7.y = class_340.a(var7.y, var8.y, 0.1F * var0);
                var7.x += (var8.x - var7.x) * 0.04F * var0;
                var7.y += (var8.y - var7.y) * 0.04F * var0;
                float var9 = var5.cj * 0.75F;
                if (class_340.c(var7.x - var8.x) < 1.0F) {
                    var8.x = class_340.d(-var9, var9);
                }

                if (class_340.c(var7.y - var8.y) < 1.0F) {
                    var8.y = class_340.d(-var9, var9);
                }
            }
        } else if (var3[0].x != 0.0F || var3[0].y != 0.0F) {
            for(var6 = 0; var6 < var3.length; ++var6) {
                var7 = var3[var6];
                var8 = var4[var6];
                var7.x = 0.0F;
                var7.y = 0.0F;
                var8.x = 0.0F;
                var8.y = 0.0F;
            }
        }

    }

    public static strictfp void b(float var0, class_26 var1) {
        OrderableUnit var2 = (OrderableUnit)var1;
        Unit var3 = var2.X();
        if (var3 != null) {
            boolean var4 = var2.Y();
            if (!var4 && var2.aO) {
                return;
            }

            GameEngine var5 = GameEngine.getGameEngine();
            PointF[] var6 = var1.b();
            Paint var7 = k;
            if (var4) {
                var7 = l;
            }

            Point3DF var8 = var2.bn();

            for(int var9 = 0; var9 < var6.length; ++var9) {
                PointF var10 = var6[var9];
                float var11 = var3.xCord + var10.x - var5.cw;
                float var12 = var3.yCord - var3.zCord + var10.y - var5.cx;
                var5.bO.a(var8.x + var10.x * 0.15F - var5.cw, var8.y - var8.z + var10.y * 0.15F - var5.cx - var2.zCord, var11, var12, var7);
                var5.bO.k();
                var5.bO.b(var11, var12);
                var5.bO.a(0.5F, 0.5F);
                if (var4) {
                    var5.bO.a(f, 0.0F, 0.0F, m);
                } else {
                    var5.bO.a(e, 0.0F, 0.0F, m);
                }

                var5.bO.l();
            }
        }

    }

    public strictfp void a(float var1) {
        super.a(var1);
        if (!this.bV) {
            a(var1, this);
        }

    }

    public strictfp void a(float var1, boolean var2) {
        super.a(var1, var2);
        if (!this.bV) {
            b(var1, this);
        }

    }

    public strictfp float e(int var1) {
        return 30.0F;
    }

    public strictfp float f(int var1) {
        return 1.3F;
    }

    public strictfp boolean c(float var1) {
        if (!super.c(var1)) {
            return false;
        } else {
            GameEngine var2 = GameEngine.getGameEngine();
            if (!this.bV) {
                float var3 = this.cL[0].f / this.e(0);
                if (var3 != 0.0F) {
                    Point3DF var4 = this.bn();
                    var2.bO.i();
                    var2.bO.b(var4.x - var2.cw, var4.y - var4.z - var2.cx);
                    var2.bO.a(var3, var3);
                    if (this.Y()) {
                        var2.bO.a((TeamImageCache)f, 0.0F, 0.0F, (Paint)null);
                    } else {
                        var2.bO.a((TeamImageCache)e, 0.0F, 0.0F, (Paint)null);
                    }

                    var2.bO.j();
                }
            }

            return true;
        }
    }

    public strictfp void a(Unit var1, int var2) {
    }

    public strictfp float attackRange() {
        return 30.0F;
    }

    public strictfp float shootDelay(int var1) {
        return 100.0F;
    }

    public strictfp float speed() {
        return this.cK() ? 0.6F : 0.8F;
    }

    public strictfp float turnSpeed() {
        return this.cK() ? 1.7F : 3.8F;
    }

    public strictfp float B() {
        return 0.35F;
    }

    public strictfp float c(int var1) {
        return 99.0F;
    }

    public strictfp boolean l() {
        return false;
    }

    public strictfp float C() {
        return 0.04F;
    }

    public strictfp float D() {
        return 0.1F;
    }

    public strictfp void a(class_226 var1, boolean var2) {
    }

    public static strictfp void a(ArrayList var0, int var1) {
        var0.add(n);
        var0.add(new class_241(UnitType.extractor, 1, 1));
        var0.add(new class_241(UnitType.turret, 1, 2));
        var0.add(new class_241(UnitType.antiAirTurret, 1, 3));
        var0.add(new class_241(UnitType.landFactory, 1, 4));
        var0.add(new class_241(UnitType.airFactory, 1, 5));
        var0.add(new class_241(UnitType.seaFactory, 1, 6));
        var0.add(new class_241(UnitType.laserDefence, 1, 7));
        var0.add(new class_241(UnitType.repairbay, 1, 8));
        var0.add(new class_241(UnitType.fabricator, 1, 9));
        var0.add(new class_241(UnitType.experimentalLandFactory, 1, 10));
        var0.add(new class_241(UnitType.NukeLaucher, 1, 14));
        var0.add(new class_241(UnitType.AntiNukeLaucher, 1, 15));
    }

    public strictfp ArrayList N() {
        return this.f().a(this.V());
    }

    public strictfp boolean E() {
        return true;
    }

    public strictfp float g(int var1) {
        return 10.0F;
    }

    public strictfp boolean F() {
        return GameEngine.getGameEngine().settingsEngine.renderExtraShadows && !this.bV;
    }

    public strictfp float G() {
        return 1.0F;
    }

    public strictfp float H() {
        return 1.0F;
    }

    public strictfp boolean g(Unit var1, boolean var2) {
        return true;
    }

    // $FF: synthetic method
    public class_31 r() {
        return this.f();
    }
}
