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
import com.corrodinggames.rts.gameFramework.d.Priority;
import com.corrodinggames.rts.gameFramework.d.class_998;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameNetEngine;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import com.corrodinggames.rts.gameFramework.utility.class_694;
import java.util.ArrayList;

// $FF: renamed from: com.corrodinggames.rts.game.units.d.q
public strictfp class NukeLaucher extends class_91 {
    static TeamImageCache[] a = new TeamImageCache[10];
    static TeamImageCache b = null;
    int c;
    static TeamImageCache d = null;
    static TeamImageCache[] e = new TeamImageCache[10];
    PointF f = new PointF();
    Rect g = new Rect();
    static class_226 h = new class_251(142);
    static class_226 i = new class_294(143);
    static ArrayList j = new ArrayList();

    public void a(GameOutputStream var1) {
        var1.writeInt(this.c);
        super.a(var1);
    }

    public void a(GameInputStream var1) {
        this.c = var1.readInt();
        super.a(var1);
    }

    public TeamImageCache v() {
        return this.bX.site == -1 ? null : e[this.bX.R()];
    }

    public static void b() {
        GameEngine var0 = GameEngine.getGameEngine();
        b = var0.bO.a(AssetsID$drawable.nuke_launcher_dead);
        TeamImageCache var1 = var0.bO.a(AssetsID$drawable.nuke_launcher);
        a = PlayerData.a(var1);
        var1.n();
        d = var0.bO.a(AssetsID$drawable.unit_icon_building);
        e = PlayerData.a(d);
    }

    public int bp() {
        return 20;
    }

    public boolean L() {
        GameEngine var1 = GameEngine.getGameEngine();
        this.M = b;
        this.S(0);
        this.bT = false;
        this.a((ExplodeType) ExplodeType.verylargeBuilding);
        float var2 = this.xCord;
        float var3 = this.yCord;
        float var4 = 0.0F;
        var1.bR.b(Priority.critical);
        class_998 var5 = var1.bR.a(var2, var3, this.zCord, Color.a(255, 255, 255, 255));
        if (var5 != null) {
            var5.G = 8.0F;
            var5.F = 5.0F;
            var5.E = 0.9F;
            var5.V = 20.0F;
            var5.W = var5.V;
            var5.r = true;
        }

        var1.bR.b(Priority.critical);
        var5 = var1.bR.c(var2, var3, var4, -1127220);
        if (var5 != null) {
            var5.G = 0.2F;
            var5.F = 2.0F;
            var5.ar = 2;
            var5.V = 45.0F;
            var5.W = var5.V;
            var5.U = 0.0F;
        }

        float var6 = 40.0F;
        float var7 = 120.0F;
        var1.bR.a(this.xCord, this.yCord, this.zCord, var6, var7);
        return true;
    }

    public TeamImageCache d() {
        return this.bV ? b : a[this.bX.R()];
    }

    public TeamImageCache k() {
        return null;
    }

    public void a(int var1) {
    }

    public NukeLaucher(boolean var1) {
        super(var1);
        this.M = a[a.length - 1];
        this.b(this.M);
        this.cj = 40.0F;
        this.ck = this.cj;
        this.totalHealth = 1500.0F;
        this.health = this.totalHealth;
        this.n.a(-2, -1, 2, 1);
        this.o.a(-2, -1, 2, 2);
    }

    public void a(float var1) {
        super.a(var1);
        if (!this.bT() || this.bV) {
            ;
        }
    }

    public PointF E(int var1) {
        bg.setSite(this.xCord, this.yCord - 3.0F);
        return bg;
    }

    public void a(Unit var1, int var2) {
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
        return UnitType.NukeLaucher;
    }

    public boolean l() {
        return false;
    }

    public float g(int var1) {
        return 1.0F;
    }

    public float bV() {
        return super.bV();
    }

    public void a(float var1, float var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        if (this.c > 0) {
            float var4 = class_340.a(this.xCord, this.yCord, var1, var2);
            if (var4 < 202500.0F) {
                if (this.bX == var3.playerTeam) {
                    var3.bS.b("Nuke target too close");
                }

            } else {
                --this.c;
                byte var5 = 0;
                PointF var6 = this.E(var5);
                float var7 = 5.0F;
                Projectile var8 = a(this, var6.x, var6.y, var1, var2);
                var8.i = var7;
                class_998 var9 = var3.bR.a(var6.x, var6.y, this.zCord, -1127220);
                if (var9 != null) {
                    var9.U = var7;
                    var9.G = 2.1F;
                    var9.F = 2.1F;
                    var9.ar = 2;
                    var9.s = true;
                    var9.t = 70.0F;
                    var9.V = 370.0F;
                    var9.W = var9.V;
                    var9.E = 1.0F;
                }

                class_998 var10 = var3.bR.d(var6.x, var6.y, 0.0F, -1);
                if (var10 != null) {
                    var10.G = 1.0F;
                    var10.F = 3.1F;
                    var10.ar = 2;
                    var10.V = 170.0F;
                    var10.W = var10.V;
                    var10.U = var7 + 20.0F;
                }

                float var11 = 0.8F;
                var3.bM.a(class_648.D, 0.27F, var11, var6.x, var6.y);
            }
        }
    }

    public static Projectile a(Unit var0, float var1, float var2, float var3, float var4) {
        Projectile var5 = Projectile.a(var0, var1, var2);
        var5.S(10);
        var5.P = 0;
        var5.Q = 1;
        var5.R = 1;
        var5.x = 1.0F;
        var5.aC = true;
        var5.m = true;
        var5.n = var3;
        var5.o = var4;
        var5.h = 99999.0F;
        var5.t = 0.1F;
        var5.r = 2.7F;
        var5.ar = Color.a(255, 225, 225, 225);
        var5.U = 300.0F;
        var5.aH = true;
        var5.aM = true;
        var5.aQ = true;
        var5.C = true;
        var5.D = true;
        var5.aI = 80.0F;
        var5.aJ = 100.0F;
        var5.aL = 1.1F;
        var5.Y = 5400.0F;
        var5.Z = 250.0F;
        var5.ad = true;
        var5.ae = false;
        var5.ao = true;
        var5.W = 75.0F;
        var5.X = var5.W;
        var5.aY = true;
        GameEngine var6 = GameEngine.getGameEngine();
        var6.bR.b(Priority.critical);
        class_998 var7 = var6.bR.a(var5, -1118720);
        if (var7 != null) {
            var7.V = 1300.0F;
            var7.W = var7.V;
            var7.E = 0.2F;
            var7.G = 1.0F;
        }

        return var5;
    }

    public void M() {
        ++this.c;
    }

    public void a(class_73 var1) {
        if (var1.j.equals(i.N())) {
            this.M();
        }

    }

    public class_1059 cm() {
        return class_226.i;
    }

    public void a(class_226 var1, boolean var2, PointF var3, Unit var4) {
        if (!var2) {
            if (var1 == h) {
                if (var3 == null) {
                    GameNetEngine.g("action:" + h.N() + " needs point but it is missing");
                } else {
                    this.a(var3.x, var3.y);
                }
            } else {
                super.a(var1, var2, var3, var4);
            }
        }
    }

    public ArrayList N() {
        return j;
    }

    public void e(float var1) {
        super.e(var1);
        class_694.b(this, 450.0F, false);
    }

    // $FF: synthetic method
    public class_31 r() {
        return this.K();
    }

    static {
        j.add(h);
        j.add(i);
    }
}
