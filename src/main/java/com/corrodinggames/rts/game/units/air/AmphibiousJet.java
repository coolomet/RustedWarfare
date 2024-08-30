package com.corrodinggames.rts.game.units.air;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import com.corrodinggames.rts.AssetsID$drawable;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.Projectile;
import com.corrodinggames.rts.game.units.MovementType;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.land.MammothTank;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.a.class_648;
import com.corrodinggames.rts.gameFramework.d.class_998;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.m.class_525;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import com.corrodinggames.rts.gameFramework.utility.class_694;
import java.util.ArrayList;

// $FF: renamed from: com.corrodinggames.rts.game.units.b.c
public strictfp class AmphibiousJet extends class_107 {
    static TeamImageCache a = null;
    static TeamImageCache b = null;
    static TeamImageCache c = null;
    static TeamImageCache d = null;
    static TeamImageCache[] e = new TeamImageCache[10];
    static TeamImageCache[] f = new TeamImageCache[10];
    static TeamImageCache[] g = new TeamImageCache[10];
    static TeamImageCache o = null;
    static TeamImageCache p = null;
    float q;
    boolean r = true;
    boolean s = true;
    float t = 0.0F;
    float u = 0.0F;
    protected Paint v = new class_525();
    PointF w = new PointF();
    Rect x = new Rect();
    public static final class_226 y = new class_263(151);
    public static final class_226 z = new class_262(152);
    static ArrayList A = new ArrayList();

    public strictfp void a(GameOutputStream var1) {
        var1.writeBoolean(this.r);
        var1.writeFloat(this.t);
        var1.writeFloat(this.u);
        super.a(var1);
    }

    public strictfp void a(GameInputStream var1) {
        this.r = var1.readBoolean();
        this.s = !this.Q();
        if (var1.b() >= 21) {
            this.t = var1.readFloat();
        }

        if (var1.b() >= 22) {
            this.u = var1.readFloat();
        }

        this.M();
        super.a(var1);
    }

    public strictfp boolean Q() {
        return this.zCord < -1.0F;
    }

    public strictfp boolean b() {
        return !this.r || this.zCord < 0.0F;
    }

    public strictfp MovementType h() {
        if (this.cp) {
            return MovementType.AIR;
        } else {
            return this.b() ? MovementType.WATER : MovementType.AIR;
        }
    }

    public strictfp UnitType f() {
        return UnitType.amphibiousJet;
    }

    public static strictfp void L() {
        GameEngine var0 = GameEngine.getGameEngine();
        b = var0.bO.a(AssetsID$drawable.amphibious_jet);
        c = var0.bO.a(AssetsID$drawable.amphibious_jet_shadow);
        a = var0.bO.a(AssetsID$drawable.amphibious_jet_dead);
        e = PlayerData.a(b);
        TeamImageCache var1 = var0.bO.a(AssetsID$drawable.amphibious_jet_p1);
        TeamImageCache var2 = var0.bO.a(AssetsID$drawable.amphibious_jet_p2);
        f = PlayerData.a(var1);
        g = PlayerData.a(var2);
        o = a((TeamImageCache)var1);
        p = a((TeamImageCache)var2);
    }

    public strictfp boolean aQ() {
        if (super.aQ()) {
            this.f(true);
            return true;
        } else {
            return false;
        }
    }

    public strictfp boolean c(float var1) {
        if (!super.c(var1)) {
            return false;
        } else if (this.bV) {
            return true;
        } else {
            this.f(false);
            if (!this.bV) {
                for(int var2 = 0; var2 < this.bl(); ++var2) {
                    if (var2 != this.ds()) {
                        float var3 = this.cL[var2].f / this.e(var2);
                        if (var3 != 0.0F) {
                            GameEngine var4 = GameEngine.getGameEngine();
                            PointF var5 = this.E(var2);
                            var4.bO.i();
                            var4.bO.b(var5.x - var4.cw, var5.y - var4.cx - this.zCord);
                            var4.bO.a(var3 * 0.7F, var3 * 0.7F);
                            var4.bO.a((TeamImageCache) MammothTank.e, 0.0F, 0.0F, (Paint)null);
                            var4.bO.j();
                        }
                    }
                }
            }

            return true;
        }
    }

    public strictfp void f(boolean var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        Paint var3;
        if (!var1) {
            var3 = this.aN();
        } else {
            this.v.a(50, 255, 255, 255);
            var3 = this.v;
        }

        for(int var5 = 0; var5 <= 1; ++var5) {
            PointF var6 = this.a(var5, var1);
            float var7 = var6.x - var2.cw;
            float var8 = var6.y - var2.cx;
            float var9 = this.d(false) - 90.0F;
            if (!var1) {
                var8 -= this.zCord;
            }

            TeamImageCache var4;
            if (var5 == 0) {
                if (var1) {
                    var4 = p;
                } else {
                    var4 = g[this.bX.R()];
                }

                var9 += 0.0F;
            } else {
                if (var1) {
                    var4 = o;
                } else {
                    var4 = f[this.bX.R()];
                }

                var9 -= 0.0F;
            }

            var2.bO.a(var4, var7, var8, var9, var3);
        }

    }

    public strictfp int bl() {
        return 3;
    }

    public strictfp PointF G(int var1) {
        if (var1 == this.ds()) {
            return super.G(var1);
        } else {
            float var2 = this.d(false) - 90.0F;
            PointF var3 = this.a(var1, false);
            float var4 = var3.x;
            float var5 = var3.y;
            var4 += class_340.k(var2) * 5.0F;
            var5 += class_340.j(var2) * 5.0F;
            bh.setSite(var4, var5);
            return bh;
        }
    }

    public strictfp PointF a(int var1, boolean var2) {
        float var3 = this.d(false) - 90.0F;
        if (var1 == this.ds()) {
            throw new RuntimeException("index==2 is for base");
        } else {
            float var4 = this.xCord;
            float var5 = this.yCord;
            float var6 = this.u * 4.0F;
            var6 = class_340.b(var6, 0.0F, 1.0F);
            float var7 = this.u * 2.0F - 1.0F;
            var7 = class_340.b(var7, 0.0F, 1.0F);
            var4 += class_340.k(var3) * (7.0F - 5.0F * var6);
            var5 += class_340.j(var3) * (7.0F - 5.0F * var6);
            float var8 = (float)(-90 + 180 * var1);
            var4 += class_340.k(var3 + var8) * (12.0F - 5.0F * var7);
            var5 += class_340.j(var3 + var8) * (12.0F - 5.0F * var7);
            this.w.setSite(var4, var5);
            return this.w;
        }
    }

    public strictfp TeamImageCache d() {
        return this.bV ? a : e[this.bX.R()];
    }

    public strictfp TeamImageCache k() {
        return c;
    }

    public strictfp TeamImageCache d(int var1) {
        return d;
    }

    public strictfp boolean e() {
        GameEngine var1 = GameEngine.getGameEngine();
        var1.bR.b(this.xCord, this.yCord, this.zCord);
        this.M = a;
        this.S(0);
        this.bT = false;
        return true;
    }

    public AmphibiousJet(boolean var1) {
        super(var1);
        this.b(b);
        this.cj = 12.0F;
        this.ck = this.cj + 1.0F;
        this.totalHealth = 530.0F;
        this.health = this.totalHealth;
        this.M = b;
        this.N = c;
        this.zCord = 0.0F;
        this.S(5);
    }

    public strictfp boolean i() {
        return !this.b();
    }

    public strictfp void M() {
        if (!this.s) {
            this.S(1);
        } else {
            this.S(5);
        }

    }

    public strictfp void a(float var1) {
        super.a(var1);
        if (this.bT() && !this.bV) {
            GameEngine var2 = GameEngine.getGameEngine();
            this.q += 2.0F * var1;
            if (this.q > 360.0F) {
                this.q -= 360.0F;
            }

            float var3;
            if (this.r) {
                var3 = 20.0F + class_340.j(this.q) * 1.5F;
            } else {
                var3 = -8.0F;
            }

            if (this.r && !this.Q()) {
                this.u = class_340.a(this.u, 0.0F, 0.018F * var1);
            } else {
                this.u = class_340.a(this.u, 1.0F, 0.018F * var1);
            }

            if (class_340.c(this.zCord - var3) > 3.0F) {
                float var4 = 0.6F;
                if (this.Q()) {
                    var4 /= 6.0F;
                }

                this.t = class_340.b(this.t, var4);
                this.t = class_340.a(this.t, var4, 0.006F * var1);
            } else {
                this.t = class_340.a(this.t, 0.07F, 0.006F * var1);
            }

            this.zCord = class_340.a(this.zCord, var3, this.t * var1);
            boolean var10 = false;
            if (this.s && this.Q()) {
                if (!this.cJ()) {
                    this.r = true;
                } else {
                    this.s = false;
                    this.M();
                    var10 = true;
                }
            }

            if (!this.s && !this.Q()) {
                this.s = true;
                this.M();
                var10 = true;
            }

            if (var10) {
                var2.bR.a(this.xCord, this.yCord, 0.0F, 0, 0.0F, 0.0F);

                for(int var5 = -180; var5 < 180; var5 += 45) {
                    float var6 = this.cg + (float)var5;
                    float var7 = (float)((double)this.xCord + Math.cos(Math.toRadians((double)var6)) * -5.0);
                    float var8 = (float)((double)this.yCord + Math.sin(Math.toRadians((double)var6)) * -5.0);
                    class_998 var9 = var2.bR.b(var7, var8, 0.0F, var6);
                    if (var9 != null) {
                        var9.ar = 2;
                        var9.s = true;
                        var9.t = 7.0F;
                    }
                }
            }

        }
    }

    public strictfp float q(int var1) {
        return var1 == this.ds() ? 0.0F : 45.0F;
    }

    public strictfp void a(Unit var1, int var2) {
        if (var2 != this.ds()) {
            PointF var3 = this.E(var2);
            Projectile var4 = Projectile.a(this, var3.x, var3.y, this.zCord, var2);
            var4.ar = Color.a(255, 247, 212, 129);
            var4.U = this.q(var2);
            var4.l = var1;
            var4.h = 10.0F;
            var4.t = 4.0F;
            var4.x = 2.0F;
            var4.aQ = false;
            var4.A = true;
            var4.M = true;
            var4.ai = 0.5F;
            var4.ak = 1.0F;
            var4.al = 0.1F;
            GameEngine var5 = GameEngine.getGameEngine();
            var5.bR.a(var3.x, var3.y, this.zCord, -1118482);
            var5.bM.a(class_648.x, 0.2F, this.xCord, this.yCord);
        }
    }

    public strictfp float attackRange() {
        return this.b() ? 100.0F : 170.0F;
    }

    public strictfp float shootDelay(int var1) {
        return 110.0F;
    }

    public strictfp float e(int var1) {
        return (float)(25 + var1 * 10);
    }

    public strictfp float f(int var1) {
        return 0.2F;
    }

    public strictfp float speed() {
        return !this.Q() ? 1.4F : 0.4F;
    }

    public strictfp float turnSpeed() {
        return !this.Q() ? 3.8F : 1.5F;
    }

    public strictfp float B() {
        return 0.3F;
    }

    public strictfp float c(int var1) {
        return 4.0F;
    }

    public strictfp float w(int var1) {
        return 0.35F;
    }

    public strictfp float y(int var1) {
        return 0.38F;
    }

    public strictfp boolean E() {
        return false;
    }

    public strictfp float C() {
        return 0.03F;
    }

    public strictfp float D() {
        return 0.1F;
    }

    public strictfp boolean l() {
        return true;
    }

    public strictfp boolean bi() {
        return true;
    }

    public strictfp boolean bj() {
        return true;
    }

    public strictfp void i(float var1) {
        if (!this.Z()) {
            super.i(var1);
        } else {
            this.cg += var1;
            if (this.cg > 180.0F) {
                this.cg -= 360.0F;
            }

            if (this.cg < -180.0F) {
                this.cg += 360.0F;
            }

        }
    }

    public strictfp int ds() {
        return 2;
    }

    public strictfp float d(boolean var1) {
        return this.cL[this.ds()].a + 90.0F;
    }

    public strictfp boolean ah() {
        return !this.Q();
    }

    public strictfp boolean ae() {
        return this.Q();
    }

    public strictfp boolean af() {
        return !this.Q();
    }

    public strictfp boolean ag() {
        return !this.Q() ? true : true;
    }

    public strictfp void a(class_226 var1, boolean var2) {
        if (var1 == y) {
            this.r = true;
        }

        if (var1 == z) {
            this.r = false;
        }

    }

    public strictfp ArrayList N() {
        return A;
    }

    public strictfp void e(float var1) {
        super.e(var1);
        float var2 = this.attackRange();
        class_694.a(this, var2);
    }

    // $FF: synthetic method
    public class_31 r() {
        return this.f();
    }

    static {
        A.add(y);
        A.add(z);
    }
}
