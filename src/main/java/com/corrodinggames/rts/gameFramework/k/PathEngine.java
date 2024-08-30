package com.corrodinggames.rts.gameFramework.k;

import android.graphics.Paint;
import android.graphics.Rect;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.maps.Layer;
import com.corrodinggames.rts.game.maps.class_482;
import com.corrodinggames.rts.game.maps.class_484;
import com.corrodinggames.rts.game.units.MovementType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final strictfp class PathEngine {
    static final boolean a = false;
    static boolean b;
    static boolean c;
    static boolean d;
    public static class_225 e;
    static boolean f;
    static boolean g;
    static boolean h;
    static int i;
    static boolean j;
    static ArrayList k;
    static boolean l;
    public static final boolean m;
    public boolean n = true;
    class_323 o = new class_323(this);
    boolean p = true;
    class_484 q;
    int r;
    short s;
    short t;
    ArrayList u = new ArrayList();
    class_223[] v = new class_223[0];
    public Paint w = new Paint();
    public class_223 x;
    public class_223 y;
    public class_223 z;
    public class_223 A;
    public class_223 B;
    public class_223 C;
    public class_223 D;
    public class_223 E;
    Paint F = new Paint();
    Object G = new Object();
    ArrayList H = new ArrayList();
    LinkedList I = new LinkedList();
    LinkedList J = new LinkedList();
    Object K = new Object();

    public strictfp class_223 a(MovementType var1) {
        class_223[] var2 = this.v;
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            class_223 var5 = var2[var4];
            if (var5.a == var1) {
                return var5;
            }
        }

        return null;
    }

    public strictfp boolean a(MovementType var1, int var2, int var3) {
        class_223 var4 = this.a(var1);
        return this.a(var4, var2, var3);
    }

    public strictfp boolean b(MovementType var1, int var2, int var3) {
        class_223 var4 = this.a(var1);
        return this.a(var4, var2, var3, true);
    }

    public strictfp boolean a(class_223 var1, int var2, int var3) {
        return this.a(var1, var2, var3, false);
    }

    public strictfp boolean a(class_223 var1, int var2, int var3, boolean var4) {
        if (!this.q.c(var2, var3)) {
            return true;
        } else if (var1.a == MovementType.AIR) {
            return false;
        } else {
            int var5 = var2 * this.t + var3;
            if (!var4 && var1.e[var5] == -1) {
                return true;
            } else {
                return var1.d[var5] == -1 || var1.f[var5] == -1;
            }
        }
    }

    public final strictfp int b(class_223 var1, int var2, int var3) {
        if (!this.q.c(var2, var3)) {
            return -1;
        } else if (var1.a == MovementType.AIR) {
            return 0;
        } else {
            int var4 = var2 * this.t + var3;
            return var1.d[var4] != -1 && var1.e[var4] != -1 && var1.f[var4] != -1 ? var1.d[var4] + var1.e[var4] + var1.f[var4] * 10 : -1;
        }
    }

    public final strictfp int c(class_223 var1, int var2, int var3) {
        if (!this.q.c(var2, var3)) {
            return -1;
        } else if (var1.a == MovementType.AIR) {
            return 4;
        } else if (var1.j == null) {
            return -1;
        } else {
            int var4 = var2 * this.t + var3;
            return var1.j[var4];
        }
    }

    public strictfp boolean a(int var1, int var2) {
        if (!this.q.c(var1, var2)) {
            return true;
        } else {
            int var3 = var1 * this.t + var2;
            if (this.D.d[var3] != -1) {
                return false;
            } else {
                return this.A.d[var3] != -1;
            }
        }
    }

    public strictfp boolean b(int var1, int var2) {
        if (!this.q.c(var1, var2)) {
            return true;
        } else {
            int var3 = var1 * this.t + var2;
            if (this.C.d[var3] != -1) {
                return false;
            } else {
                return this.E.d[var3] != -1;
            }
        }
    }

    public strictfp synchronized void a(class_484 var1, boolean var2) {
        this.d();
        GameEngine.log("PathEngine: Setting up map costs");
        boolean var3 = false;
        if (var2 && this.q != null && this.q == var1 && this.s == var1.u.n && this.t == var1.u.o) {
            if (this.r == class_223.a(var1)) {
                GameEngine.log("PathEngine: Keeping existing map costs");
                var3 = true;
            } else {
                GameEngine.log("PathEngine: Error: Map checksum does not match!!!");
            }
        }

        if (var3) {
        }

        this.q = var1;
        this.r = class_223.a(var1);
        this.s = (short)var1.u.n;
        this.t = (short)var1.u.o;
        e = null;
        this.u.clear();
        this.v = new class_223[0];
        this.x = new class_223(this, MovementType.NONE, this.s, this.t);
        this.y = new class_223(this, MovementType.LAND, this.s, this.t);
        this.y.b();
        this.y.a((OrderableUnit)null);
        this.z = new class_223(this, MovementType.BUILDING, this.s, this.t);
        this.A = new class_223(this, MovementType.WATER, this.s, this.t);
        this.A.b();
        this.A.a((OrderableUnit)null);
        this.B = new class_223(this, MovementType.AIR, this.s, this.t);
        this.C = new class_223(this, MovementType.HOVER, this.s, this.t);
        this.C.b();
        this.C.a((OrderableUnit)null);
        this.D = new class_223(this, MovementType.OVER_CLIFF, this.s, this.t);
        this.D.b();
        this.D.a((OrderableUnit)null);
        this.E = new class_223(this, MovementType.OVER_CLIFF_WATER, this.s, this.t);
        this.E.b();
        this.E.a((OrderableUnit)null);
        Iterator var4 = this.H.iterator();

        while(var4.hasNext()) {
            class_323 var5 = (class_323)var4.next();
            var5.a(var1);
        }

        this.o.a(var1);
        GameEngine.log("PathEngine: Ready");
    }

    public strictfp void a() {
        GameEngine var1 = GameEngine.getGameEngine();
        class_223 var2 = this.y;
        Rect var3 = new Rect();
        float var4 = var1.cw;
        float var5 = var1.cx;
        float var6 = var1.cA;
        float var7 = var1.cB;
        Layer var8 = var1.bL.u;
        int var9 = (int)(var4 * this.q.r - 1.0F);
        if (var9 < 0) {
            var9 = 0;
        }

        int var10 = (int)(var5 * this.q.s - 1.0F);
        if (var10 < 0) {
            var10 = 0;
        }

        int var11 = (int)((var4 + var6) * this.q.r + 1.0F);
        if (var11 > this.s - 1) {
            var11 = this.s - 1;
        }

        int var12 = (int)((var5 + var7) * this.q.s + 1.0F);
        if (var12 > this.t - 1) {
            var12 = this.t - 1;
        }

        for(int var13 = var9; var13 < var11 + 1; ++var13) {
            for(int var14 = var10; var14 < var12 + 1; ++var14) {
                class_482 var15 = var8.a(var13, var14);
                if (var15 != null) {
                    int var16 = var13 * this.q.n;
                    int var17 = var14 * this.q.o;
                    var3.a(var16, var17, var16 + this.q.n, var17 + this.q.o);
                    var3.a((int)(-var4), (int)(-var5));
                    boolean var18 = var3.b((int)(var1.bS.x / var1.cX), (int)(var1.bS.y / var1.cX));
                    if (!g || var18) {
                        int var19 = var2.d[var13 * this.t + var14];
                        int var20 = var2.e[var13 * this.t + var14];
                        int var21 = var2.f[var13 * this.t + var14];
                        if (var19 == -1) {
                            var19 = 255;
                        } else {
                            var19 *= 2;
                        }

                        if (var20 == -1) {
                            var20 = 255;
                        } else {
                            var20 *= 2;
                        }

                        if (var21 == -1) {
                            var21 = 255;
                        } else {
                            if (var21 != 0) {
                                var21 += 30;
                            }

                            var21 *= 2;
                        }

                        this.F.a(128, var19, var20, var21);
                        var1.bO.b(var3, this.F);
                        if (var18 && var2.f != null) {
                            var1.bO.a("o:" + var2.f[var13 * this.t + var14], (float)var3.d(), (float)var3.e(), var1.dp);
                        }
                    }
                }
            }
        }

    }

    public strictfp void a(OrderableUnit var1) {
        if (var1 != null) {
            PlayerData.b(var1);
        }

        class_223[] var2 = this.v;
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            class_223 var5 = var2[var4];
            var5.c(var1);
        }

        this.y.a(var1);
        this.C.a(var1);
        this.D.a(var1);
        this.E.a(var1);
    }

    public strictfp void b() {
        class_223[] var1 = this.v;
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            class_223 var4 = var1[var3];
            var4.e();
        }

    }

    public PathEngine() {
        this.H.add(new class_323(this));
        int var1 = class_340.c();
        if (var1 > 1) {
            GameEngine.b("PathEngine", "We have " + var1 + " cores, creating extra solvers");
            this.H.add(new class_323(this));
        } else {
            GameEngine.b("PathEngine", "We only have one core, using single solver");
        }

        Iterator var2 = this.H.iterator();

        while(var2.hasNext()) {
            class_323 var3 = (class_323)var2.next();
            var3.c();
        }

    }

    public strictfp void c() {
        class_224 var2;
        for(Iterator var1 = this.I.iterator(); var1.hasNext(); var2.w = true) {
            var2 = (class_224)var1.next();
        }

        this.I.clear();
        this.h();
    }

    public strictfp void d() {
        Iterator var1 = this.I.iterator();

        while(var1.hasNext()) {
            class_224 var2 = (class_224)var1.next();
            this.a(var2);
        }

        this.I.clear();
        this.h();
    }

    public strictfp void a(class_223 var1, boolean var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        if (!var2) {
            if (var1.k + 50 < var3.tick) {
                var1.k = var3.tick - 40;
                var1.e();
            }

            var1.a(var2);
        } else {
            if (var1.k + 30 < var3.tick) {
                var1.k = var3.tick;
                var1.e();
            }

            var1.a(var2);
        }

    }

    public strictfp class_224 a(boolean var1) {
        Object var2;
        if (OrderableUnit.L) {
            var2 = new class_225(this, var1);
        } else {
            var2 = new class_224(this, var1);
        }

        return (class_224)var2;
    }

    public strictfp void a(class_224 var1, boolean var2) {
        this.a(var1, var2, false);
    }

    public strictfp void a(class_224 var1, boolean var2, boolean var3) {
        if (!this.p) {
            GameEngine.b("PathEngine", "Cannot start new path, not running");
        } else {
            GameEngine var4 = GameEngine.getGameEngine();
            class_223 var5 = this.a(var1.o);
            this.a(var5, var2);
            var1.e();
            var1.t = 300.0F;
            int var6 = class_340.d(var1.h - var1.l);
            int var7 = class_340.d(var1.i - var1.m);
            if (var6 < 15 && var7 < 15) {
                var1.t = 12.0F;
            } else if (var6 < 50 && var7 < 50) {
                var1.t = 16.0F;
            } else if (var6 < 200 && var7 < 200) {
                var1.t = 24.0F;
            } else if (var6 < 400 && var7 < 400) {
                var1.t = 50.0F;
            } else if (var6 < 1000 && var7 < 1000) {
                var1.t = 100.0F;
            } else if (var6 < 2000 && var7 < 2000) {
                var1.t = 200.0F;
            }

            if (!var4.netEngine.B && !var4.replayEngine.i()) {
                if (var6 < 1000 && var7 < 1000) {
                    var1.t = 180.0F;
                } else {
                    var1.t = 360.0F;
                }
            }

            if (var1.r) {
                var1.t *= 2.0F;
                var1.t += 50.0F;
            }

            var1.s = var1.t;
            if (this.n && !var3) {
                this.b(var1);
                this.I.add(var1);
            } else {
                this.o.a(var1);
                this.o.b();
                this.I.add(var1);
            }

        }
    }

    public strictfp void a(float var1) {
        this.i();
    }

    public strictfp void b(float var1) {
        class_223[] var2 = this.v;
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            class_223 var5 = var2[var4];
            var5.p = 0;
            if (var5.o) {
                var5.o = false;
                var5.c((OrderableUnit)null);
            }
        }

        this.i();
        this.d(var1);
    }

    public strictfp void c(float var1) {
        if (j) {
            Iterator var2 = k.iterator();

            while(var2.hasNext()) {
                class_224 var3 = (class_224)var2.next();
                var3.h();
                var3.g();
            }
        }

        if (d) {
            boolean var6 = true;
            GameEngine var7 = GameEngine.getGameEngine();
            if (var7.bS.bZ.b > 0) {
                Unit var4 = var7.bS.bZ.a(0);
                if (var4 instanceof OrderableUnit) {
                    OrderableUnit var5 = (OrderableUnit)var4;
                    if (var5.au != null) {
                        var5.au.d(var5);
                        var6 = false;
                    }
                }
            }

            if (var6) {
            }
        }

        if (f) {
            this.a();
        }

        if (h) {
        }

    }

    public strictfp boolean e() {
        Iterator var1 = this.I.iterator();

        class_224 var2;
        do {
            if (!var1.hasNext()) {
                return false;
            }

            var2 = (class_224)var1.next();
        } while(!(var2.t <= 0.0F) || var2.c());

        return true;
    }

    public strictfp String f() {
        Iterator var1 = this.I.iterator();
        String var2 = null;
        int var3 = 0;

        while(var1.hasNext()) {
            class_224 var4 = (class_224)var1.next();
            if (var4.t <= 0.0F && !var4.c()) {
                if (var2 == null) {
                    float var5 = class_340.b((float)var4.h, (float)var4.i, (float)var4.l, (float)var4.m);
                    var2 = "[distance:" + var5 + ", allowedDelay:" + var4.s + " lowPriority:" + var4.r + "]";
                }

                ++var3;
            }
        }

        String var6 = "(total:" + var3 + ") ";
        if (var2 != null) {
            var6 = var6 + var2;
        }

        return var6;
    }

    private strictfp void d(float var1) {
        Iterator var2 = this.I.iterator();

        while(var2.hasNext()) {
            class_224 var3 = (class_224)var2.next();
            if (var3.t <= 0.0F) {
                var3.t = 0.0F;
                var3.u = true;
                if (j) {
                    k.add(var3);
                    if (k.size() > 10) {
                        k.remove(0);
                    }
                }

                if (!var3.c()) {
                    if (GameEngine.getGameEngine().ay()) {
                        GameEngine.b("PathEngine", "updateUnfinishedPaths: path wasn't solved, isGoingToBlockThisFrame did not protect");
                    }

                    this.a(var3);
                }

                if (var3.c()) {
                    var2.remove();
                }
            } else {
                var3.t -= var1;
            }
        }

    }

    private strictfp class_224 g() {
        class_224 var1 = null;
        Iterator var2 = this.J.iterator();

        while(true) {
            class_224 var3;
            do {
                if (!var2.hasNext()) {
                    if (var1 == null) {
                        throw new RuntimeException("Failed to find any paths");
                    }

                    if (!this.J.remove(var1)) {
                        throw new RuntimeException("Failed remove found path");
                    }

                    return var1;
                }

                var3 = (class_224)var2.next();
            } while(var1 != null && !(var1.t > var3.t));

            var1 = var3;
        }
    }

    private strictfp void b(class_224 var1) {
        synchronized(this.K) {
            this.J.add(var1);
        }
    }

    private strictfp void h() {
        synchronized(this.K) {
            this.J.clear();
        }
    }

    private strictfp void i() {
        LinkedList var1 = this.J;
        if (var1.size() > 0) {
            synchronized(this.K) {
                while(var1.size() > 0) {
                    class_323 var3 = this.j();
                    if (var3 == null) {
                        break;
                    }

                    class_224 var4 = this.g();
                    if (!var4.v) {
                        this.a(var3, var4);
                    }
                }
            }
        }

    }

    private strictfp class_323 j() {
        Iterator var1 = this.H.iterator();

        class_323 var2;
        do {
            if (!var1.hasNext()) {
                return null;
            }

            var2 = (class_323)var1.next();
        } while(!var2.s);

        return var2;
    }

    public strictfp void a(class_224 var1) {
        if (!var1.v) {
            while(true) {
                synchronized(this.G) {
                    class_323 var3 = this.j();
                    if (var3 != null) {
                        this.a(var3, var1);
                        break;
                    }

                    try {
                        this.G.wait(2000L);
                    } catch (InterruptedException var9) {
                    }
                }
            }
        }

        boolean var2 = false;
        long var12 = GameEngine.millis();

        while(true) {
            synchronized(this.G) {
                if (var1.c()) {
                    break;
                }

                var2 = true;
                this.i();

                try {
                    this.G.wait(2000L);
                } catch (InterruptedException var8) {
                }
            }
        }

        if (var2 && b) {
            GameEngine.b("PathEngine", "We were blocked path(" + var1.e + ") for:" + (GameEngine.millis() - var12));
        }

    }

    private strictfp void a(class_323 var1, class_224 var2) {
        synchronized(var2) {
            if (!var2.v) {
                var1.a(var2);
                var1.a();
            }

        }
    }

    static {
        b = !GameEngine.as;
        c = false;
        d = false;
        f = false;
        g = false;
        h = false;
        i = 20;
        j = false;
        k = new ArrayList();
        l = false;
        m = false;
    }
}
