package com.corrodinggames.rts.game.units.air;

import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;
import com.corrodinggames.rts.AssetsID$drawable;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.Projectile;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.class_32;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.a.class_1059;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.land.Hovercraft;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.a.class_648;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import com.corrodinggames.rts.gameFramework.utility.class_694;
import java.util.ArrayList;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.game.units.b.d
public strictfp class Dropship extends class_107 implements class_32 {
    static TeamImageCache a = null;
    static TeamImageCache b = null;
    static TeamImageCache c = null;
    static TeamImageCache[] d = new TeamImageCache[10];
    float e = 0.0F;
    float f;
    boolean g;
    class_684 o = new class_684();
    Rect p = new Rect();
    public static final class_226 q = new class_272(109);
    public static final class_226 r = new class_271(110);
    static ArrayList s = new ArrayList();

    public strictfp void a(GameOutputStream var1) {
        var1.writeFloat(this.e);
        var1.writeFloat(this.f);
        var1.writeBoolean(this.g);
        var1.writeInt(this.o.size());
        Iterator var2 = this.o.iterator();

        while(var2.hasNext()) {
            Unit var3 = (Unit)var2.next();
            var1.a(var3);
        }

        super.a(var1);
    }

    public strictfp void a(GameInputStream var1) {
        this.e = var1.readFloat();
        this.f = var1.readFloat();
        this.g = var1.readBoolean();
        this.o.clear();
        int var2 = var1.readInt();

        for(int var3 = 0; var3 < var2; ++var3) {
            Unit var4 = var1.o();
            if (var4 != null) {
                this.o.add(var4);
            }
        }

        super.a(var1);
    }

    public strictfp int bY() {
        return Hovercraft.a(this.o);
    }

    public strictfp int bZ() {
        return 4;
    }

    public strictfp UnitType b() {
        return UnitType.dropship;
    }

    public static strictfp void L() {
        GameEngine var0 = GameEngine.getGameEngine();
        b = var0.bO.a(AssetsID$drawable.dropship);
        c = var0.bO.a(AssetsID$drawable.dropship_shadow);
        a = var0.bO.a(AssetsID$drawable.dropship_dead);
        d = PlayerData.a(b);
    }

    public strictfp TeamImageCache d() {
        return this.bV ? a : d[this.bX.R()];
    }

    public strictfp TeamImageCache k() {
        return c;
    }

    public strictfp TeamImageCache d(int var1) {
        return null;
    }

    public strictfp boolean e() {
        GameEngine var1 = GameEngine.getGameEngine();
        var1.bR.b(this.xCord, this.yCord, this.zCord);
        this.M = a;
        this.S(0);
        this.bT = false;
        this.f(true);
        return true;
    }

    public Dropship(boolean var1) {
        super(var1);
        this.T(45);
        this.U(47);
        this.cj = 20.0F;
        this.ck = this.cj + 0.0F;
        this.totalHealth = 500.0F;
        this.health = this.totalHealth;
        this.M = b;
        this.N = c;
        this.zCord = 0.0F;
    }

    public strictfp boolean I() {
        return true;
    }

    public strictfp boolean i() {
        return this.zCord >= 4.0F;
    }

    public strictfp boolean ct() {
        return true;
    }

    public strictfp void a(float var1) {
        super.a(var1);
        if (!this.bV) {
            boolean var2 = this.cK();
            boolean var3;
            if (this.g && !var2 && !this.cK && this.zCord < 4.0F) {
                this.f = class_340.a(this.f, var1);
                if (this.f == 0.0F) {
                    this.f = 30.0F;
                    if (this.o.size() == 0) {
                        this.g = false;
                    } else {
                        var3 = this.o.size() % 2 == 0;
                        float var4 = this.xCord + class_340.k(this.cg) * -9.0F;
                        float var5 = this.yCord + class_340.j(this.cg) * -9.0F;
                        var4 += class_340.k(this.cg + 90.0F) * (float)(var3 ? -7 : 7);
                        var4 += class_340.j(this.cg + 90.0F) * (float)(var3 ? -7 : 7);
                        Unit var6 = (Unit)this.o.remove(this.o.size() - 1);
                        if (!class_694.a(var6, var4, var5)) {
                            var4 += 10.0F;
                        }

                        if (!class_694.a(var6, var4, var5)) {
                            var4 -= 20.0F;
                        }

                        if (!class_694.a(var6, var4, var5)) {
                            var4 -= 10.0F;
                            var5 += 10.0F;
                        }

                        if (!class_694.a(var6, var4, var5)) {
                            var5 -= 20.0F;
                        }

                        if (!class_694.a(var6, var4, var5)) {
                            this.o.add(var6);
                        } else {
                            var6.cN = null;
                            var6.xCord = var4;
                            var6.yCord = var5;
                            var6.bZ += 0.1F;
                            var6.cg = this.cg + 180.0F;
                            var6.bR = this;
                            var6.bS = 45.0F;
                            if (var6 instanceof OrderableUnit) {
                                OrderableUnit var7 = (OrderableUnit)var6;
                                var7.az();
                                var7.d(this.xCord + class_340.k(this.cg) * -66.0F, this.yCord + class_340.j(this.cg) * -66.0F);
                            }

                            if (this.o.size() == 0) {
                                this.g = false;
                            }
                        }
                    }
                }
            }

            this.e += 2.0F * var1;
            if (this.e > 360.0F) {
                this.e -= 360.0F;
            }

            var3 = this.i();
            if (this.bT()) {
                if (this.aq() && !var2) {
                    this.zCord = class_340.a(this.zCord, 2.0F, 0.4F * var1);
                } else {
                    this.zCord = class_340.a(this.zCord, 35.0F + class_340.j(this.e) * 1.5F, 0.35F * var1);
                }
            }

            if (var3 != this.i()) {
                this.ay = true;
                if (this.i()) {
                    this.S(5);
                } else {
                    this.S(2);
                }
            }

        }
    }

    public strictfp PointF E(int var1) {
        float var2 = this.g(var1);
        float var3 = this.cg;
        float var4 = this.xCord + class_340.k(var3) * var2;
        float var5 = this.yCord + class_340.j(var3) * var2;
        bg.setSite(var4, var5);
        return bg;
    }

    public strictfp void a(Unit var1, int var2) {
        PointF var3 = this.E(var2);
        Projectile var4 = Projectile.a(this, var3.x, var3.y, this.zCord, var2);
        var4.ar = Color.a(255, 150, 230, 40);
        var4.U = 35.0F;
        var4.l = var1;
        var4.h = 80.0F;
        var4.t = 4.0F;
        var4.x = 2.0F;
        GameEngine var5 = GameEngine.getGameEngine();
        var5.bR.a(var3.x, var3.y, this.zCord, -1127220);
        var5.bR.a(var3.x, var3.y, this.zCord, this.cL[var2].a);
        var5.bM.a(class_648.u, 0.3F, this.xCord, this.yCord);
    }

    public strictfp float attackRange() {
        return 140.0F;
    }

    public strictfp float shootDelay(int var1) {
        return 40.0F;
    }

    public strictfp float speed() {
        return 2.3F;
    }

    public strictfp float turnSpeed() {
        return 1.4F;
    }

    public strictfp float c(int var1) {
        return 99.0F;
    }

    public strictfp boolean E() {
        return false;
    }

    public strictfp float C() {
        return 0.03F;
    }

    public strictfp float D() {
        return 0.05F;
    }

    public strictfp boolean l() {
        return false;
    }

    public strictfp float g(int var1) {
        return 15.0F;
    }

    public strictfp void a() {
        this.f(true);
        super.a();
    }

    public strictfp void f(boolean var1) {
        Iterator var2 = this.o.iterator();

        while(var2.hasNext()) {
            Unit var3 = (Unit)var2.next();
            var3.cN = null;
            var3.xCord = this.xCord + class_340.k(this.cg) * -9.0F;
            var3.yCord = this.yCord + class_340.j(this.cg) * -9.0F;
            if (var1) {
                var3.cj();
            }
        }

        this.o.clear();
    }

    public strictfp boolean bA() {
        return this.g;
    }

    public strictfp void M() {
        this.g = true;
        this.f = 30.0F;
    }

    public strictfp void ds() {
        this.g = false;
    }

    public strictfp float mass() {
        return 16000.0F;
    }

    public strictfp boolean d(Unit var1, boolean var2) {
        if (this.g) {
            return false;
        } else if (!Hovercraft.a(this.o, 4, var1)) {
            return false;
        } else if (var1 == this) {
            return false;
        } else {
            return this.bX != var1.bX && !var2 ? false : class_694.a(var1, true, true);
        }
    }

    public strictfp boolean e(Unit var1, boolean var2) {
        if (!this.d(var1, var2)) {
            return false;
        } else {
            this.C(var1);
            return true;
        }
    }

    public strictfp void C(Unit var1) {
        var1.cN = this;
        this.o.add(var1);
        GameEngine var2 = GameEngine.getGameEngine();
        var2.bS.l(var1);
    }

    public strictfp void e(Unit var1) {
        if (var1.cN == this) {
            this.o.remove(var1);
            var1.cN = null;
        } else {
            GameEngine.warn("Unit is not being transported");
        }

    }

    public strictfp void a(class_226 var1, boolean var2) {
        if (var1 == q) {
            this.M();
        }

        if (var1 == r) {
            this.ds();
        }

    }

    public strictfp int bB() {
        return this.o.size();
    }

    public strictfp boolean cr() {
        return true;
    }

    public strictfp class_1059 cp() {
        return q.N();
    }

    public strictfp ArrayList N() {
        return s;
    }

    public strictfp boolean f() {
        return !this.cK();
    }

    public strictfp boolean j() {
        return true;
    }

    public strictfp class_684 bz() {
        return this.o;
    }

    // $FF: synthetic method
    public class_31 r() {
        return this.b();
    }

    static {
        s.add(q);
        s.add(r);
    }
}
