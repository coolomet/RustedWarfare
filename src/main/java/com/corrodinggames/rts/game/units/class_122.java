package com.corrodinggames.rts.game.units;

import android.graphics.Paint;
import android.graphics.Paint$Cap;
import android.graphics.PointF;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.Projectile;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.land.class_120;
import com.corrodinggames.rts.game.units.land.Builder;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.GameObject;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.a.class_648;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;

// $FF: renamed from: com.corrodinggames.rts.game.units.g
public strictfp class class_122 extends class_120 implements class_26 {
    public boolean a;
    PointF[] b = new PointF[6];
    PointF[] c;
    static Paint d;
    static Paint e;
    static Paint f;
    int g;
    float h;
    float i;
    int j;

    public strictfp UnitType f() {
        return UnitType.builder;
    }

    public strictfp PointF[] b() {
        return this.b;
    }

    public strictfp PointF[] e_() {
        return this.c;
    }

    public strictfp TeamImageCache v() {
        return this.bX.site == -1 ? null : dN[this.bX.R()];
    }

    public strictfp boolean a(Unit var1) {
        return true;
    }

    public strictfp TeamImageCache d() {
        return this.bV ? Builder.b : Builder.d[this.bX.R()];
    }

    public strictfp TeamImageCache k() {
        return null;
    }

    public strictfp TeamImageCache d(int var1) {
        return null;
    }

    public strictfp boolean e() {
        GameEngine var1 = GameEngine.getGameEngine();
        var1.bR.b(this.xCord, this.yCord, this.zCord);
        this.M = Builder.b;
        this.S(0);
        this.bT = false;
        var1.bM.a(class_648.o, 0.8F, this.xCord, this.yCord);
        this.bq();
        return true;
    }

    public class_122(boolean var1) {
        super(var1);
        this.c = new PointF[this.b.length];
        d = new Paint();
        d.a(40, 0, 255, 0);
        d.a(true);
        d.a(2.0F);
        d.a(Paint$Cap.b);
        e = new Paint();
        e.a(d);
        e.a(55, 255, 60, 60);
        f = new Paint();
        f.a(60, 255, 255, 255);
        this.T(20);
        this.U(20);
        this.cj = 10.0F;
        this.xCord = -1000.0F;
        this.yCord = -1000.0F;
        this.ck = this.cj;
        this.totalHealth = 170000.0F;
        this.health = this.totalHealth;
        this.M = Builder.b;

        for(int var2 = 0; var2 < this.b.length; ++var2) {
            this.b[var2] = new PointF();
            this.c[var2] = new PointF();
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

    public strictfp void a(float var1) {
        super.a(var1);
        if (!this.bV) {
            a(var1, this);
        }

        this.health = this.totalHealth;
        ++this.g;
        this.h += var1;
        this.i += var1;
        GameEngine var2 = GameEngine.getGameEngine();
        if (!this.a) {
            if (this.i > 3.0F) {
                this.i = 0.0F;
                this.w();
            }

        } else {
            GameEngine.log("Stress test active");

            for(int var3 = 0; var3 < 6000; ++var3) {
                this.w();
            }

            this.ci();
        }
    }

    public strictfp void w() {
        GameEngine var1 = GameEngine.getGameEngine();
        ++this.j;
        int var2 = UnitType.ae.size();
        int var3 = class_340.a((GameObject) this, 0, var2 - 1, 1 + this.j);
        class_31 var4 = (class_31) UnitType.ae.get(var3);
        boolean var5 = true;
        if (class_591.b == var4) {
            var5 = false;
        }

        if (var4 == UnitType.spreadingFire) {
            var5 = false;
        }

        if (var5) {
            Unit var6 = var4.a();
            var6.xCord = (float)class_340.a((GameObject) this, 200, (int)var1.bL.i() - 200, 2 + this.g + this.j);
            var6.yCord = (float)class_340.a((GameObject)this, 200, (int)var1.bL.j() - 200, 3 + this.g + this.j + this.j * 9);

            try {
                var6.Q(class_340.a((GameObject)this, 0, 3, 4 + this.g + this.j + this.j * 9));
            } catch (Exception var8) {
                throw new RuntimeException(var8);
            }

            PlayerData.c(var6);
            if (var6.u()) {
                var6.a();
            }

            if (var6.bO()) {
                var6.a();
            }
        }

    }

    public strictfp void a(float var1, boolean var2) {
        if (!this.bV) {
        }

    }

    public strictfp float e(int var1) {
        return 0.0F;
    }

    public strictfp float f(int var1) {
        return 0.0F;
    }

    public strictfp boolean c(float var1) {
        if (!super.c(var1)) {
            return false;
        } else {
            GameEngine var2 = GameEngine.getGameEngine();
            return true;
        }
    }

    public strictfp void a(Unit var1, int var2) {
    }

    public strictfp boolean b_() {
        return false;
    }

    public strictfp int y() {
        return 850000;
    }

    public strictfp float b(Unit var1) {
        return 1.0E7F;
    }

    public strictfp float c(Unit var1) {
        return 1.0E7F;
    }

    public strictfp float attackRange() {
        return 30.0F;
    }

    public strictfp float shootDelay(int var1) {
        return 100.0F;
    }

    public strictfp float speed() {
        return 0.0F;
    }

    public strictfp float turnSpeed() {
        return this.cK() ? 4.7F : 4.8F;
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

    public strictfp boolean u() {
        return true;
    }

    public strictfp boolean I() {
        return false;
    }

    public strictfp boolean d(Unit var1) {
        return false;
    }

    public strictfp boolean J() {
        return true;
    }

    public strictfp float a(Unit var1, float var2, Projectile var3) {
        var2 = 0.0F;
        return super.a(var1, var2, var3);
    }

    // $FF: synthetic method
    public class_31 r() {
        return this.f();
    }
}
