package com.corrodinggames.rts.game.units;

import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import com.corrodinggames.rts.AssetsID$drawable;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.Projectile;
import com.corrodinggames.rts.game.maps.class_482;
import com.corrodinggames.rts.game.maps.class_484;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.GameObject;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;

// $FF: renamed from: com.corrodinggames.rts.game.units.ai
public strictfp class SpreadingFire extends class_78 {
    static TeamImageCache[] a = new TeamImageCache[2];
    TeamImageCache b;
    int c;
    int d = 0;
    float e;
    float f;
    int g = 0;
    int h = 0;
    float i;
    float j;
    boolean k = false;
    float l;
    float m;
    float n;
    float o;
    float p;
    float q;
    boolean r;
    static Point s = new Point();
    public static class_305 t = new class_305();
    Rect u = new Rect();

    public static void b() {
        GameEngine var0 = GameEngine.getGameEngine();
        a[0] = var0.bO.a(AssetsID$drawable.fire);
    }

    public void a(GameOutputStream var1) {
        var1.writeInt(this.c);
        var1.writeInt(this.d);
        var1.writeFloat(this.e);
        var1.writeByte(0);
        super.a(var1);
    }

    public void a(GameInputStream var1) {
        this.c = var1.readInt();
        this.d = var1.readInt();
        this.e = var1.readFloat();
        var1.readByte();
        super.a(var1);
    }

    public TeamImageCache d() {
        return this.b;
    }

    public boolean e() {
        return false;
    }

    public SpreadingFire(boolean var1) {
        super(var1);
        this.a(0);
        this.cj = 20.0F;
        this.ck = this.cj + 1.0F;
        this.totalHealth = 100.0F;
        this.health = this.totalHealth;
        this.cg = -90.0F;
        this.bT = false;
        this.o = 0.05F;
        this.p = 120.0F;
        this.S(3);
    }

    public void f_() {
        this.bT = false;
    }

    public void a(int var1) {
        this.c = var1;
        if (this.c == 0) {
            this.T(20);
            this.U(20);
            this.g = 0;
            this.h = 0;
            this.b = a[0];
        } else {
            throw new RuntimeException("Fire type:" + this.c + " is not supported");
        }
    }

    public void f() {
        this.k = true;
        this.i = (float)class_340.a((GameObject)this, -5, 5, 1);
        this.j = (float)class_340.a((GameObject)this, -5, 5, 2);
        this.e = (float)class_340.a((GameObject)this, 1, 10, 3);
        this.d = class_340.a((GameObject)this, 0, 2, 4);
        this.f = (float)class_340.a((GameObject)this, 7, 13, 5);
        GameEngine var1 = GameEngine.getGameEngine();
        class_484 var2 = var1.bL;
        var1.bL.a(this.xCord, this.yCord);
        int var3 = var1.bL.T;
        int var4 = var1.bL.U;
        if (!var2.c(var3, var4)) {
            this.l = 0.0F;
            this.m = 0.0F;
            this.n = 2.0F;
        } else {
            class_482 var5 = var1.bL.u.a(var3, var4);
            boolean var6 = false;
            if (var5.e || var5.h || var5.k || var5.f) {
                var6 = true;
            }

            if (var6) {
                this.l = 0.0F;
                this.m = 0.0F;
                this.n = 2.0F;
            } else {
                this.l = 5.0E-4F;
                this.m = 1.0F;
                this.n = 0.3F;
                this.o += (float)class_340.a((GameObject)this, 0, 10, 10) / 1000.0F;
            }
        }
    }

    public void a(float var1) {
        super.a(var1);
        if (!this.k) {
            this.f();
        }

        if (this.o < this.m) {
            this.o += this.l * var1;
            if (this.o > this.m) {
                this.o = this.m;
            }
        }

        if (this.o > this.n) {
            this.q = (float)((double)this.q + 0.01 * (double)var1);
            if (!this.r && this.q > 1.0F || this.q > 8.0F) {
                this.q = (float)class_340.a((GameObject)this, 0, 10, 10) / 1000.0F;
                this.k();
            }
        }

        this.e += var1;
        if (this.e > 10.0F) {
            this.e = 0.0F;
            ++this.d;
            if (this.d > 3) {
                this.d = 0;
            }
        }

        if (this.o < 0.0F) {
            this.bv();
        }

    }

    public void k() {
        this.r = true;
        this.b(-1, -1);
        this.b(0, -1);
        this.b(1, -1);
        this.b(-1, 0);
        this.b(1, 0);
        this.b(-1, 1);
        this.b(0, 1);
        this.b(1, 1);
    }

    public void b(int var1, int var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        float var4 = (float)((int)(this.xCord + (float)(var1 * var3.bL.n)));
        float var5 = (float)((int)(this.yCord + (float)(var2 * var3.bL.o)));
        SpreadingFire var6 = a(var4, var5);
        if (var6 == null) {
            SpreadingFire var7 = new SpreadingFire(false);
            var7.xCord = var4;
            var7.yCord = var5;
            var7.b(this.bX);
            var3.cc.a((Unit)var7);
            PlayerData.c((Unit)var7);
            this.r = false;
        }

    }

    public static SpreadingFire a(float var0, float var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        t.a(var0, var1);
        var2.cc.a(var0, var1, 30.0F, (OrderableUnit)null, 1.0F, t);
        return t.c;
    }

    public Rect a_(boolean var1) {
        int var2 = this.g;
        int var3 = this.h;
        var2 += this.d * this.es;
        dC.a(var2, var3, var2 + this.es, var3 + this.et);
        return dC;
    }

    public boolean c(float var1) {
        TeamImageCache var2 = this.d();
        GameEngine var3 = GameEngine.getGameEngine();
        du.a(this.cF());
        du.a(0.0F, (float)((int)(-this.zCord)));
        du.a(this.i, this.j);
        dv.a(this.a_(false));
        var3.bO.k();
        float var4 = du.d();
        float var5 = du.e();
        var3.bO.a(this.d(false), var4, var5);
        var3.bO.a(this.o * 2.7F, this.o * 2.7F, var4, var5);
        var3.bO.a(var2, dv, (RectF)du, (Paint)null);
        var3.bO.l();
        return true;
    }

    public MovementType h() {
        return MovementType.NONE;
    }

    public boolean i() {
        return false;
    }

    public boolean Q() {
        return false;
    }

    public boolean ak() {
        return false;
    }

    public boolean aj() {
        return false;
    }

    public boolean s_() {
        return true;
    }

    public boolean c_() {
        return false;
    }

    public UnitType s() {
        return UnitType.spreadingFire;
    }

    public void n() {
        super.n();
    }

    public float x() {
        return -1.0F;
    }

    public boolean l() {
        return false;
    }

    public boolean P() {
        return true;
    }

    public float a(Unit var1, float var2, Projectile var3) {
        this.o -= var2 / 100.0F;
        var2 = 0.0F;
        return super.a(var1, var2, var3);
    }

    // $FF: synthetic method
    public class_31 r() {
        return this.s();
    }
}
