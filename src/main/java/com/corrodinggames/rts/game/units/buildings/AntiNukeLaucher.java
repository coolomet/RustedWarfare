package com.corrodinggames.rts.game.units.buildings;

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
import com.corrodinggames.rts.game.units.a.class_1059;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.a.class_648;
import com.corrodinggames.rts.gameFramework.d.class_998;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import com.corrodinggames.rts.gameFramework.utility.class_694;
import java.util.ArrayList;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.game.units.d.c
public strictfp class AntiNukeLaucher extends class_91 {
    static TeamImageCache[] a = new TeamImageCache[10];
    static TeamImageCache b = null;
    boolean c;
    int d;
    float e;
    static TeamImageCache f = null;
    static TeamImageCache[] g = new TeamImageCache[10];
    PointF h = new PointF();
    Rect i = new Rect();
    static class_226 j = new class_249(145);
    static class_226 k = new class_291(144);
    static ArrayList l = new ArrayList();

    public strictfp void a(GameOutputStream var1) {
        var1.writeBoolean(this.c);
        var1.writeInt(this.d);
        super.a(var1);
    }

    public strictfp void a(GameInputStream var1) {
        this.c = var1.readBoolean();
        if (var1.b() >= 30) {
            this.d = var1.readInt();
        }

        super.a(var1);
    }

    public strictfp TeamImageCache v() {
        return this.bX.site == -1 ? null : g[this.bX.R()];
    }

    public static strictfp void b() {
        GameEngine var0 = GameEngine.getGameEngine();
        b = var0.bO.a(AssetsID$drawable.antinuke_launcher_dead);
        TeamImageCache var1 = var0.bO.a(AssetsID$drawable.antinuke_launcher);
        a = PlayerData.a(var1);
        var1.n();
        f = var0.bO.a(AssetsID$drawable.unit_icon_building_turrent);
        g = PlayerData.a(f);
    }

    public strictfp boolean L() {
        GameEngine var1 = GameEngine.getGameEngine();
        this.M = b;
        this.S(0);
        this.bT = false;
        this.a((ExplodeType) ExplodeType.verylargeBuilding);
        return true;
    }

    public strictfp TeamImageCache d() {
        return this.bV ? b : a[this.bX.R()];
    }

    public strictfp TeamImageCache k() {
        return null;
    }

    public strictfp void a(int var1) {
    }

    public AntiNukeLaucher(boolean var1) {
        super(var1);
        this.M = a[a.length - 1];
        this.b(this.M);
        this.cj = 24.0F;
        this.ck = this.cj;
        this.totalHealth = 2800.0F;
        this.health = this.totalHealth;
        this.n.a(-1, -1, 1, 1);
        this.o.a(-1, -1, 1, 1);
    }

    public strictfp void a(float var1) {
        super.a(var1);
        if (this.bT() && !this.bV) {
            if (this.d > 0) {
                Projectile var2 = null;
                this.e = class_340.a(this.e, var1);
                if (this.e == 0.0F) {
                    this.e = 15.0F;
                    Iterator var3 = Projectile.a.iterator();

                    label56:
                    while(true) {
                        Projectile var4;
                        float var7;
                        do {
                            do {
                                float var5;
                                float var6;
                                do {
                                    do {
                                        do {
                                            if (!var3.hasNext()) {
                                                break label56;
                                            }

                                            var4 = (Projectile)var3.next();
                                        } while(!var4.D);
                                    } while(!(var4.zCord > 50.0F));

                                    var5 = 2200.0F;
                                    var6 = class_340.a(this.xCord, this.yCord, var4.xCord, var4.yCord);
                                } while(!(var6 < var5 * var5));

                                var7 = class_340.a(this.xCord, this.yCord, var4.n, var4.o);
                            } while(!(var7 < 1000000.0F));
                        } while(var4.j != null && (var4.j.bX.d(this.bX) || var4.j.bX == this.bX));

                        if (!this.a(var4)) {
                            var2 = var4;
                        }
                    }
                }

                if (var2 != null) {
                    this.b(var2);
                }
            }

        }
    }

    public strictfp boolean a(Projectile var1) {
        Object[] var2 = Projectile.a.a();
        int var3 = 0;

        for(int var4 = Projectile.a.a; var3 < var4; ++var3) {
            Projectile var5 = (Projectile)var2[var3];
            if (var5 != var1 && var5.q == var1) {
                return true;
            }
        }

        return false;
    }

    public strictfp void b(Projectile var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        if (this.d > 0) {
            --this.d;
            byte var3 = 0;
            PointF var4 = this.E(var3);
            Projectile var5 = Projectile.a(this, var4.x, var4.y);
            var5.S(10);
            var5.P = 10;
            var5.R = 0;
            var5.x = 1.0F;
            var5.aC = true;
            var5.q = var1;
            var5.h = 99999.0F;
            var5.t = 0.2F;
            var5.r = 6.5F;
            var5.ar = Color.a(255, 80, 60, 180);
            var5.U = 600.0F;
            var5.aH = true;
            var5.aM = true;
            var5.aQ = true;
            var5.C = true;
            var5.aI = 80.0F;
            var5.aJ = 100.0F;
            var5.aL = 2.0F;
            var2.bR.a(var4.x, var4.y, this.zCord, -1127220);
            class_998 var6 = var2.bR.d(var4.x, var4.y, 0.0F, -1);
            if (var6 != null) {
                var6.G = 0.5F;
                var6.F = 2.1F;
                var6.ar = 2;
                var6.V = 90.0F;
                var6.W = var6.V;
                var6.U = 0.0F;
            }

            float var7 = 1.5F;
            var2.bM.a(class_648.D, 0.15F, var7, var4.x, var4.y);
        }
    }

    public strictfp PointF E(int var1) {
        bg.setSite(this.xCord, this.yCord - 9.0F);
        return bg;
    }

    public strictfp void a(Unit var1, int var2) {
    }

    public strictfp float attackRange() {
        return 1000.0F;
    }

    public strictfp float c(int var1) {
        return 4.0F;
    }

    public strictfp boolean b(int var1, float var2) {
        return false;
    }

    public strictfp boolean c(float var1) {
        return super.c(var1);
    }

    public strictfp UnitType K() {
        return UnitType.AntiNukeLaucher;
    }

    public strictfp boolean l() {
        return false;
    }

    public strictfp float g(int var1) {
        return 1.0F;
    }

    public strictfp float bV() {
        return super.bV();
    }

    public strictfp void M() {
        ++this.d;
    }

    public strictfp void a(class_73 var1) {
        if (var1.j.equals(k.N())) {
            this.M();
        }

    }

    public strictfp class_1059 cm() {
        return this.d < 4 ? k.N() : class_226.i;
    }

    public strictfp boolean ck() {
        return false;
    }

    public strictfp ArrayList N() {
        return l;
    }

    public strictfp void e(float var1) {
        super.e(var1);
    }

    public strictfp void O() {
    }

    public strictfp void cb() {
        float var1 = 990.0F;
        boolean var2 = false;
        boolean var3 = true;
        class_694.a(this, var1, var2, var3);
    }

    public strictfp boolean a(GameEngine var1) {
        return this.cG ? true : super.a((GameEngine)var1);
    }

    public strictfp float a(Unit var1, float var2, Projectile var3) {
        if (var2 > 2600.0F) {
            var2 = 2600.0F;
        }

        return super.a(var1, var2, var3);
    }

    // $FF: synthetic method
    public class_31 r() {
        return this.K();
    }

    static {
        l.add(j);
        l.add(k);
    }
}
