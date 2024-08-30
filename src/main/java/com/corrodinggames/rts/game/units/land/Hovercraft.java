package com.corrodinggames.rts.game.units.land;

import com.corrodinggames.rts.AssetsID$drawable;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.ExplodeType;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.class_32;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.a.class_1059;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import com.corrodinggames.rts.gameFramework.utility.class_694;
import java.util.ArrayList;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.game.units.e.i
public strictfp class Hovercraft extends class_128 implements class_32 {
    static TeamImageCache a = null;
    static TeamImageCache b = null;
    static TeamImageCache c = null;
    static TeamImageCache[] d = new TeamImageCache[10];
    float e = 0.0F;
    float f;
    boolean g;
    class_684 h = new class_684();
    public static final class_226 i = new class_255(109);
    public static final class_226 j = new class_254(110);
    static ArrayList k = new ArrayList();

    public strictfp void a(GameOutputStream var1) {
        var1.writeFloat(this.e);
        var1.writeFloat(this.f);
        var1.writeBoolean(this.g);
        var1.writeInt(this.h.size());
        Iterator var2 = this.h.iterator();

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
        this.h.clear();
        int var2 = var1.readInt();

        for(int var3 = 0; var3 < var2; ++var3) {
            Unit var4 = var1.o();
            if (var4 != null) {
                this.h.add(var4);
            }
        }

        super.a(var1);
    }

    public strictfp UnitType b() {
        return UnitType.hovercraft;
    }

    public static strictfp void L() {
        GameEngine var0 = GameEngine.getGameEngine();
        a = var0.bO.a(AssetsID$drawable.hovercraft);
        c = var0.bO.a(AssetsID$drawable.hovercraft_shadow);
        b = var0.bO.a(AssetsID$drawable.hovercraft_dead);
        d = PlayerData.a(a);
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
        this.M = b;
        this.S(0);
        this.bT = false;
        this.f(true);
        this.a((ExplodeType) ExplodeType.small);
        return true;
    }

    public strictfp void a() {
        this.f(true);
        super.a();
    }

    public strictfp void f(boolean var1) {
        Iterator var2 = this.h.iterator();

        while(var2.hasNext()) {
            Unit var3 = (Unit)var2.next();
            var3.cN = null;
            var3.xCord = this.xCord + class_340.k(this.cg) * -9.0F;
            var3.yCord = this.yCord + class_340.j(this.cg) * -9.0F;
            if (var1) {
                var3.cj();
            }
        }

        this.h.clear();
    }

    public Hovercraft(boolean var1) {
        super(var1);
        this.T(20);
        this.U(32);
        this.cj = 15.0F;
        this.ck = this.cj;
        this.totalHealth = 450.0F;
        this.health = this.totalHealth;
        this.M = a;
        this.N = c;
    }

    public static strictfp int a(class_684 var0) {
        int var1 = 0;

        Unit var3;
        for(Iterator var2 = var0.iterator(); var2.hasNext(); var1 += var3.cw()) {
            var3 = (Unit)var2.next();
        }

        return var1;
    }

    public static strictfp boolean a(class_684 var0, int var1, Unit var2) {
        int var3 = a(var0);
        return var3 + var2.cw() <= var1;
    }

    public strictfp int bY() {
        return a(this.h);
    }

    public strictfp int bZ() {
        return 4;
    }

    public static strictfp boolean a(Unit var0, Unit var1, boolean var2) {
        float var3 = 9.0F;
        float var4 = -180.0F;
        float var5 = 70.0F;
        float var6 = 0.0F;
        float var7 = 7.0F;
        return a(var0, var1, var2, var3, var4, var5, var6, var7);
    }

    public static strictfp boolean a(Unit var0, Unit var1, boolean var2, float var3, float var4, float var5, float var6, float var7) {
        float var8 = var0.xCord + class_340.k(var0.cg + var4) * var7 - class_340.j(var0.cg + var4) * var6;
        float var9 = var0.yCord + class_340.j(var0.cg + var4) * var7 + class_340.k(var0.cg + var4) * var6;
        var8 += class_340.k(var0.cg + 90.0F) * (var2 ? -var3 : var3);
        var9 += class_340.j(var0.cg + 90.0F) * (var2 ? -var3 : var3);
        if (!class_694.a(var1, var8, var9)) {
            var8 += 10.0F;
        }

        if (!class_694.a(var1, var8, var9)) {
            var8 -= 20.0F;
        }

        if (!class_694.a(var1, var8, var9)) {
            var8 -= 10.0F;
            var9 += 10.0F;
        }

        if (!class_694.a(var1, var8, var9)) {
            var9 -= 20.0F;
        }

        if (!class_694.a(var1, var8, var9)) {
            return false;
        } else {
            var1.cN = null;
            var1.xCord = var8;
            var1.yCord = var9;
            var1.bZ += 0.1F;
            var1.cg = var0.cg + var4;
            var1.bR = var0;
            var1.bS = 45.0F;
            if (var1 instanceof OrderableUnit) {
                OrderableUnit var10 = (OrderableUnit)var1;
                var10.j(var1.cg);
                var10.az();
                var10.d(var1.xCord + class_340.k(var1.cg + (var2 ? -var3 : var3)) * var5, var1.yCord + class_340.j(var1.cg + (var2 ? -var3 : var3)) * var5);
                var10.ac = 0;
            }

            return true;
        }
    }

    public strictfp void a(float var1) {
        super.a(var1);
        if (!this.bV && this.bT()) {
            if (this.cl == 0.0F && this.em != 3) {
                this.S(3);
            }

            if (this.g && !this.cK() && !this.cK) {
                this.f = class_340.a(this.f, var1);
                if (this.f == 0.0F) {
                    this.f = 30.0F;
                    if (this.h.size() == 0) {
                        this.g = false;
                    } else {
                        boolean var2 = this.h.size() % 2 == 0;
                        Unit var3 = (Unit)this.h.remove(this.h.size() - 1);
                        boolean var4 = a(this, var3, var2);
                        if (!var4) {
                            this.h.add(var3);
                        }

                        if (this.h.size() == 0) {
                            this.g = false;
                        }
                    }
                }
            }

            this.e += 4.0F * var1;
            if (this.e > 360.0F) {
                this.e -= 360.0F;
            }

            if (!this.g) {
                this.zCord = class_340.a(this.zCord, 3.0F + class_340.j(this.e) * 1.5F, 0.1F * var1);
            } else {
                this.zCord = class_340.a(this.zCord, 0.0F, 0.1F * var1);
            }

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
        return this.cK() ? 1.2F : 0.9F;
    }

    public strictfp float turnSpeed() {
        return this.cK() ? 1.8F : 1.4F;
    }

    public strictfp float B() {
        return 0.1F;
    }

    public strictfp float C() {
        return 0.03F;
    }

    public strictfp float D() {
        return 0.05F;
    }

    public strictfp float c(int var1) {
        return 99.0F;
    }

    public strictfp boolean l() {
        return false;
    }

    public strictfp boolean d(Unit var1, boolean var2) {
        if (this.g) {
            return false;
        } else if (!a(this.h, 4, var1)) {
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
        this.h.add(var1);
        GameEngine var2 = GameEngine.getGameEngine();
        var2.bS.l(var1);
    }

    public strictfp void e(Unit var1) {
        if (var1.cN == this) {
            this.h.remove(var1);
            var1.cN = null;
        } else {
            GameEngine.warn("Unit is not being transported");
        }

    }

    public strictfp float mass() {
        return 12000.0F;
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

    public strictfp void a(class_226 var1, boolean var2) {
        if (var1 == i) {
            this.M();
        }

        if (var1 == j) {
            this.ds();
        }

    }

    public strictfp boolean cr() {
        return true;
    }

    public strictfp int bB() {
        return this.h.size();
    }

    public strictfp class_1059 cp() {
        return i.N();
    }

    public strictfp ArrayList N() {
        return k;
    }

    public strictfp boolean f() {
        return !this.cK();
    }

    public strictfp boolean j() {
        return true;
    }

    public strictfp class_684 bz() {
        return this.h;
    }

    // $FF: synthetic method
    public class_31 r() {
        return this.b();
    }

    static {
        k.add(i);
        k.add(j);
    }
}
