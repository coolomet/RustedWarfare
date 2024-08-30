package com.corrodinggames.rts.game.units.buildings.turrets;

import android.graphics.PointF;
import android.graphics.Rect;
import com.corrodinggames.rts.AssetsID$drawable;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.ExplodeType;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.a.class_1059;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.buildings.class_73;
import com.corrodinggames.rts.game.units.buildings.class_91;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameNetEngine;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import com.corrodinggames.rts.gameFramework.utility.class_694;
import java.util.ArrayList;

// $FF: renamed from: com.corrodinggames.rts.game.units.d.a.b
public strictfp class Turret extends class_91 {
    static TeamImageCache g = null;
    private static TeamImageCache a = null;
    private static TeamImageCache b = null;
    private static TeamImageCache c = null;
    private static TeamImageCache d = null;
    private static TeamImageCache e = null;
    static TeamImageCache[] h = new TeamImageCache[10];
    static TeamImageCache i = null;
    boolean j;
    int k;
    class_449 l = new class_453(this);
    static String t = "gun";
    static String u = "gunT2";
    static String v = "gunT3";
    static String w = "artillery";
    static String x = "flamethrower";
    static String C = "aa_t1";
    static String D = "aa_t2";
    static String E = "aa_flak";
    static TeamImageCache F = null;
    static TeamImageCache[] G = new TeamImageCache[10];
    boolean H = true;
    float I;
    float J;
    boolean K;
    Rect dK = new Rect();
    public static class_226 dL = new class_288(101);
    public static class_226 dM = new class_287(104);
    public static class_226 dN = new class_290(102);
    public static class_226 dO = new class_289(103);
    static ArrayList dP = new ArrayList();

    public strictfp int M() {
        return this.l.b();
    }

    public strictfp float H(int var1) {
        return this.l.h(var1);
    }

    public strictfp void a_(String var1) {
        this.b(var1);
    }

    public strictfp void b(String var1) {
        if (!this.l.a(var1)) {
            class_449 var2 = this.l;
            this.l = this.c(var1);
            this.l.a(var2);
        }

    }

    public strictfp class_449 c(String var1) {
        if (var1.equals(t)) {
            return new class_453(this);
        } else if (var1.equals(u)) {
            return new class_450(this);
        } else if (var1.equals(v)) {
            return new class_454(this);
        } else if (var1.equals(w)) {
            return new class_452(this);
        } else {
            return var1.equals(x) ? new class_451(this) : null;
        }
    }

    public strictfp void a(GameOutputStream var1) {
        var1.writeBoolean(this.j);
        var1.writeBoolean(this.k == 1);
        var1.writeString(this.l.c());
        var1.writeInt(this.k);
        super.a(var1);
    }

    public strictfp void a(GameInputStream var1) {
        boolean var2 = var1.readBoolean();
        if (var2) {
            this.a(2);
        }

        if (var1.b() >= 27) {
            this.k = var1.readBoolean() ? 1 : 0;
        }

        if (var1.b() >= 35) {
            String var3 = var1.readString();
            if (!this.l.a(var3)) {
                this.b(var3);
            }

            this.k = var1.readInt();
        } else if (var2 && !(this instanceof AntiAirTurret)) {
            this.b(u);
        }

        super.a(var1);
    }

    public strictfp TeamImageCache v() {
        return this.bX.site == -1 ? null : G[this.bX.R()];
    }

    public static strictfp void dB() {
        GameEngine var0 = GameEngine.getGameEngine();
        g = var0.bO.a(AssetsID$drawable.turret_base);
        i = var0.bO.a(AssetsID$drawable.turret_base_dead);
        a = var0.bO.a(AssetsID$drawable.turret_top);
        b = var0.bO.a(AssetsID$drawable.turret_top_l2);
        c = var0.bO.a(AssetsID$drawable.turret_top_l3);
        d = var0.bO.a(AssetsID$drawable.turret_top_artillery);
        e = var0.bO.a(AssetsID$drawable.turret_top_flame);
        h = PlayerData.a(g);
        F = var0.bO.a(AssetsID$drawable.unit_icon_building_turrent);
        G = PlayerData.a(F);
    }

    public strictfp boolean L() {
        this.M = i;
        this.S(0);
        this.bT = false;
        this.a((ExplodeType) ExplodeType.large);
        return true;
    }

    public strictfp TeamImageCache d() {
        if (this.bV) {
            return i;
        } else {
            return this.bX == null ? h[h.length - 1] : h[this.bX.R()];
        }
    }

    public strictfp TeamImageCache k() {
        return null;
    }

    public strictfp TeamImageCache d(int var1) {
        return this.l.d(var1);
    }

    public Turret(boolean var1) {
        super(var1);
        this.T(35);
        this.U(42);
        this.cj = 16.0F;
        this.ck = this.cj;
        this.totalHealth = 700.0F;
        this.health = this.totalHealth;
        this.M = g;
        this.cL[0].a = (float)class_340.a(this, -180, 180);
        this.n.a(0, 0, 1, 1);
        this.o.a(0, 0, 1, 1);
    }

    public strictfp void s(float var1) {
        byte var2 = 0;
        if (this.cL[var2].a()) {
            if (this.H) {
                this.I = this.cL[var2].a;
                this.H = false;
                this.J = (float)class_340.a(this, 0, 120);
            }

            this.J += var1;
            if (this.J > 450.0F) {
                this.J = (float)class_340.a(this, 0, 30);
                this.K = !this.K;
            }

            if (this.J < 120.0F) {
                if (this.K) {
                    this.a(var1 * 0.3F, this.I - 20.0F, var2);
                } else {
                    this.a(var1 * 0.3F, this.I + 20.0F, var2);
                }
            }
        } else {
            this.H = true;
        }

    }

    public strictfp void a(float var1) {
        super.a(var1);
        if (this.bT()) {
            this.l.a(var1);
        }

    }

    public strictfp void a(Unit var1, int var2) {
        this.l.a(var1, var2);
    }

    public strictfp float attackRange() {
        return this.l.a();
    }

    public strictfp float shootDelay(int var1) {
        return this.l.a(var1);
    }

    public strictfp float c(int var1) {
        return this.l.e(var1);
    }

    public strictfp float w(int var1) {
        return this.l.f(var1);
    }

    public strictfp boolean b(int var1, float var2) {
        return false;
    }

    public strictfp boolean c(float var1) {
        if (!super.c(var1)) {
            return false;
        } else {
            if (!this.bV) {
                this.dC();
            }

            return true;
        }
    }

    strictfp void dC() {
        GameEngine var1 = GameEngine.getGameEngine();
        TeamImageCache var2 = null;
        byte var3 = 0;
        var2 = this.d(var3);
        PointF var4 = this.G(var3);
        var1.bO.a(var2, var4.x - GameEngine.getGameEngine().cw, var4.y - GameEngine.getGameEngine().cx, this.cL[var3].a, this.f());
    }

    public strictfp UnitType K() {
        return UnitType.turret;
    }

    public strictfp boolean l() {
        return true;
    }

    public strictfp boolean af() {
        return false;
    }

    public strictfp float g(int var1) {
        return this.l.g(var1);
    }

    public strictfp void M(int var1) {
        if (!(this.shootDelay(var1) < 10.0F)) {
            super.M(var1);
        }
    }

    public strictfp void a(class_73 var1) {
        class_226 var2 = this.a((class_1059)var1.j);
        if (var2 != null) {
            var2.f(this);
        } else {
            GameNetEngine.a("specialAction=null on completeQueueItem(turret) for item.uIndex:" + var1.j + " id:" + this.id, true);
        }

    }

    public strictfp class_1059 cm() {
        if (this.M() == 1) {
            return dL.N();
        } else {
            return this.l instanceof class_450 ? dM.N() : class_226.i;
        }
    }

    public strictfp void a(ArrayList var1) {
        var1.clear();
        if (this.M() == 1) {
            var1.add(dN.N());
            var1.add(dO.N());
        }

    }

    public strictfp void a(int var1) {
        if (var1 == 1) {
            this.j = false;
        } else if (var1 == 2 && !this.j) {
            this.j = true;
        }

    }

    public strictfp PointF E(int var1) {
        return this.l.c(var1);
    }

    public strictfp float bV() {
        return this.cL[0].e > 0.0F && this.l.a(w) ? 1.0F - this.cL[0].e / this.shootDelay(0) : super.bV();
    }

    public strictfp PointF G(int var1) {
        bh.setSite(super.G(var1));
        bh.moveAdd(0.0F, -5.0F);
        return bh;
    }

    public strictfp ArrayList N() {
        return dP;
    }

    public strictfp void e(float var1) {
        super.e(var1);
        float var2 = this.attackRange();
        class_694.a(this, var2);
    }

    public strictfp float cZ() {
        return (float)GameEngine.getGameEngine().bL.n;
    }

    public strictfp float da() {
        return (float)GameEngine.getGameEngine().bL.o;
    }

    public strictfp float db() {
        return super.db() - 8.0F;
    }

    public strictfp int cL() {
        return this.l.d();
    }

    public strictfp float q(int var1) {
        return this.l.b(var1);
    }

    // $FF: synthetic method
    public class_31 r() {
        return this.K();
    }

    // $FF: synthetic method
    static PointF a(Turret var0, int var1) {
        return var0.E(var1);
    }

    // $FF: synthetic method
    static TeamImageCache dD() {
        return a;
    }

    // $FF: synthetic method
    static TeamImageCache dE() {
        return b;
    }

    // $FF: synthetic method
    static PointF b(Turret var0, int var1) {
        return var0.E(var1);
    }

    // $FF: synthetic method
    static TeamImageCache dF() {
        return c;
    }

    // $FF: synthetic method
    static PointF c(Turret var0, int var1) {
        return var0.E(var1);
    }

    // $FF: synthetic method
    static TeamImageCache dG() {
        return d;
    }

    // $FF: synthetic method
    static TeamImageCache dH() {
        return e;
    }

    // $FF: synthetic method
    static void a(Turret var0) {
        var0.W();
    }

    // $FF: synthetic method
    static void b(Turret var0) {
        var0.W();
    }

    // $FF: synthetic method
    static void c(Turret var0) {
        var0.W();
    }

    // $FF: synthetic method
    static void d(Turret var0) {
        var0.W();
    }

    static {
        dP.add(dL);
        dP.add(dM);
        dP.add(dN);
        dP.add(dO);
    }
}
