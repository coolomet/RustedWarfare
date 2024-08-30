package com.corrodinggames.rts.game.units.buildings;

import android.graphics.PointF;
import android.graphics.Rect;
import com.corrodinggames.rts.AssetsID$drawable;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.Projectile;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.a.class_1059;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.a.class_648;
import com.corrodinggames.rts.gameFramework.d.class_989;
import com.corrodinggames.rts.gameFramework.d.Priority;
import com.corrodinggames.rts.gameFramework.d.class_998;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import com.corrodinggames.rts.gameFramework.utility.class_694;
import java.util.ArrayList;

// $FF: renamed from: com.corrodinggames.rts.game.units.d.p
public strictfp class LaserDefence extends class_91 {
    static TeamImageCache[] a = new TeamImageCache[10];
    static TeamImageCache[] b = new TeamImageCache[10];
    static TeamImageCache c = null;
    boolean d;
    boolean e;
    float f;
    static TeamImageCache g = null;
    static TeamImageCache[] h = new TeamImageCache[10];
    PointF i = new PointF();
    Rect j = new Rect();
    static class_226 k = new class_286(102);
    static ArrayList l = new ArrayList();

    public void a(GameOutputStream var1) {
        var1.writeBoolean(this.d);
        var1.writeFloat(this.cB);
        var1.writeBoolean(this.e);
        var1.writeFloat(this.f);
        super.a(var1);
    }

    public void a(GameInputStream var1) {
        this.d = var1.readBoolean();
        this.cB = var1.readFloat();
        this.e = var1.readBoolean();
        if (var1.b() >= 38) {
            this.f = var1.readFloat();
        }

        super.a(var1);
    }

    public TeamImageCache v() {
        return this.bX.site == -1 ? null : h[this.bX.R()];
    }

    public static void b() {
        GameEngine var0 = GameEngine.getGameEngine();
        c = var0.bO.a(AssetsID$drawable.laser_defence_dead);
        TeamImageCache var1 = var0.bO.a(AssetsID$drawable.laser_defence);
        TeamImageCache var2 = var0.bO.a(AssetsID$drawable.laser_defence_t2);
        a = PlayerData.a(var1);
        b = PlayerData.a(var2);
        var1.n();
        var1 = null;
        var2.n();
        var2 = null;
        g = var0.bO.a(AssetsID$drawable.unit_icon_building_turrent);
        h = PlayerData.a(g);
    }

    public boolean L() {
        GameEngine var1 = GameEngine.getGameEngine();
        var1.bR.a(this.xCord, this.yCord, this.zCord);
        this.M = c;
        this.S(0);
        this.bT = false;
        var1.bM.a(class_648.p, 0.8F, this.xCord, this.yCord);
        return true;
    }

    public TeamImageCache d() {
        if (this.bV) {
            return c;
        } else if (this.bX == null) {
            return a[a.length - 1];
        } else {
            return !this.d ? a[this.bX.R()] : b[this.bX.R()];
        }
    }

    public TeamImageCache k() {
        return null;
    }

    public LaserDefence(boolean var1) {
        super(var1);
        this.a(a[0], 2);
        this.cB = 1.0F;
        this.cj = 19.0F;
        this.ck = this.cj;
        this.totalHealth = 500.0F;
        this.health = this.totalHealth;
        this.M = a[a.length - 1];
        this.n.a(0, 0, 1, 1);
        this.o.a(0, 0, 1, 1);
    }

    public void a(float var1) {
        super.a(var1);
        if (this.bT() && !this.bV) {
            GameEngine var2 = GameEngine.getGameEngine();
            float var3 = 4.0E-4F * var1;
            if (this.d) {
                var3 += 2.0E-4F * var1;
            }

            this.cB = class_340.a(this.cB, 1.0F, var3);
            if (this.cB >= 1.0F) {
                this.e = false;
            }

            this.f -= var1;
            this.i.setSite(this.E(0));
            if (this.cB > 0.0F && !this.e) {
                float var4;
                if (!this.d) {
                    var4 = 0.11F;
                } else {
                    var4 = 0.05F;
                }

                if (a(this, this.i.x, this.i.y, this.zCord, this.attackRange(), var4)) {
                    this.f = 3.0F;
                }

                if (this.cB < 0.0F) {
                    this.cB = 0.0F;
                    this.e = true;
                }
            }

            if (this.e) {
                this.s = 1;
            } else {
                this.s = 0;
            }

        }
    }

    public static boolean a(OrderableUnit var0, float var1, float var2, float var3, float var4, float var5) {
        GameEngine var6 = GameEngine.getGameEngine();
        float var7 = var4 * var4;
        Object[] var8 = Projectile.a.a();
        int var9 = 0;

        for(int var10 = Projectile.a.a; var9 < var10; ++var9) {
            Projectile var11 = (Projectile)var8[var9];
            if (!var11.A && !var11.C && (var11.J > 7.0F || var11.J > 2.0F && var11.t > 8.0F) && !var11.aS) {
                float var12 = (var11.xCord - var1) * (var11.xCord - var1) + (var11.yCord - var2) * (var11.yCord - var2);
                if (var12 < var7 && !(var11.zCord < -1.0F)) {
                    boolean var13 = false;
                    if (var11.l != null && var0.bX.d(var11.l.bX)) {
                        var13 = true;
                    }

                    if (!var13 && var11.j != null && var0.bX.c(var11.j.bX)) {
                        var13 = true;
                    }

                    if (var13) {
                        class_998 var14 = var6.bR.a(var1, var2, var3, var11.xCord, var11.yCord, var11.zCord);
                        if (var14 != null) {
                            var14.V = 10.0F;
                            var14.W = var14.V;
                        }

                        class_998 var15 = var6.bR.b(var1, var2, var3, class_989.CUSTOM, false, Priority.high);
                        if (var15 != null) {
                            var15.P = 0.0F;
                            var15.Q = 0.0F;
                            var15.ap = 4;
                            var15.V = 39.0F;
                            var15.W = var15.V;
                            var15.r = true;
                            var15.E = 1.3F;
                            var15.G = 1.1F;
                            var15.F = 0.7F;
                        }

                        --var11.H;
                        if (var11.H <= 0.0F) {
                            var11.d();
                            var15 = var6.bR.b(var11.xCord, var11.yCord, var11.zCord, class_989.CUSTOM, false, Priority.high);
                            if (var15 != null) {
                                var15.P = 0.0F;
                                var15.Q = 0.0F;
                                var15.ap = 4;
                                var15.V = 23.0F;
                                var15.W = var15.V;
                                var15.r = true;
                                var15.E = 0.9F;
                                var15.G = 0.5F;
                                var15.F = 0.2F;
                            }

                            float var16 = 1.0F + class_340.c(-0.07F, 0.07F);
                            var6.bM.a(class_648.F, 0.2F, var16, var11.xCord, var11.yCord);
                        }

                        var0.cB -= var5;
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public PointF E(int var1) {
        bg.setSite(this.xCord, this.yCord - 13.0F);
        return bg;
    }

    public void a(Unit var1, int var2) {
    }

    public float attackRange() {
        return !this.d ? 160.0F : 210.0F;
    }

    public float c(int var1) {
        return 4.0F;
    }

    public boolean b(int var1, float var2) {
        return false;
    }

    public boolean c(float var1) {
        return super.c(var1);
    }

    public UnitType K() {
        return UnitType.laserDefence;
    }

    public boolean l() {
        return false;
    }

    public float g(int var1) {
        return 1.0F;
    }

    public float bW() {
        return this.cB != 1.0F ? this.cB : super.bW();
    }

    public boolean bX() {
        return this.e;
    }

    public float bd() {
        return 1.0F;
    }

    public void a(class_73 var1) {
        if (var1.j.equals(k.N())) {
            PlayerData.b((Unit)this);
            this.a(2);
            PlayerData.c((Unit)this);
            this.W();
        }

    }

    public class_1059 cm() {
        return !this.d ? k.N() : class_226.i;
    }

    public int V() {
        return this.d ? 2 : 1;
    }

    public void a(int var1) {
        if (var1 == 1) {
            this.d = false;
        } else if (var1 == 2 && !this.d) {
            this.d = true;
            this.totalHealth += 900.0F;
            this.health += 900.0F;
        }

        this.S();
    }

    public ArrayList N() {
        return l;
    }

    public void e(float var1) {
        super.e(var1);
        float var2 = this.attackRange();
        class_694.a(this, var2);
    }

    public float cZ() {
        return (float)GameEngine.getGameEngine().bL.n;
    }

    public float da() {
        return (float)GameEngine.getGameEngine().bL.o;
    }

    public float db() {
        return super.db() - 8.0F;
    }

    // $FF: synthetic method
    public class_31 r() {
        return this.K();
    }

    static {
        l.add(k);
    }
}
