package com.corrodinggames.rts.gameFramework.f;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint$Style;
import android.graphics.Point;
import android.graphics.Rect;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.Projectile;
import com.corrodinggames.rts.game.maps.class_484;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.d.class_990;
import com.corrodinggames.rts.gameFramework.m.class_28;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.m.class_525;
import com.corrodinggames.rts.gameFramework.m.class_526;
import java.util.ArrayList;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.f.o
public strictfp class class_537 {
    float a;
    float b;
    public float c = 120.0F;
    public float d = 120.0F;
    public boolean e;
    public boolean f;
    public int g;
    public int h;
    public float i;
    public float j;
    int k;
    int l;
    boolean m;
    final Paint n = new Paint();
    final Paint o = new Paint();
    final Paint p = new Paint();
    float q = 0.0F;
    float r = 0.0F;
    final Paint s = new class_525();
    final Paint t = new Paint();
    final Paint u = new Paint();
    final Paint v = new Paint();
    public final Rect w = new Rect();
    final Paint x = new class_525();
    final Paint y = new class_525();
    final Paint z = new class_525();
    final Paint A = new class_525();
    final Paint B = new class_525();
    final Paint C = new class_525();
    final Paint D = new class_525();
    final Rect E = new Rect();
    TeamImageCache F;
    class_28 G;
    TeamImageCache H;
    class_28 I;
    public TeamImageCache J;
    class_28 K;
    float L = 0.0F;
    float M;
    float N;
    public boolean O = false;
    public boolean P = false;
    public float Q = 0.0F;
    int R = 30;
    int S = -1;
    public TeamImageCache T;
    public TeamImageCache U;
    final Rect V = new Rect();
    class_525[] W;
    class_525 X;
    float Y;
    public final ArrayList Z = new ArrayList();
    public final ArrayList aa = new ArrayList();
    private final ArrayList ag = new ArrayList();
    Rect ab = new Rect();
    static ArrayList ac = new ArrayList();
    Point ad = new Point();
    class_526 ae = new class_528(this);
    ArrayList af = new ArrayList();

    public void a(int var1, int var2, float var3, Unit var4) {
        boolean var5 = var4 != null && var4.bI();
        Iterator var6 = this.Z.iterator();

        class_535 var7;
        do {
            if (!var6.hasNext()) {
                class_535 var8 = new class_535(this, var3, var1, var2, var5);
                this.Z.add(var8);
                return;
            }

            var7 = (class_535)var6.next();
        } while(var7.a != var5 || class_340.d(var1 - var7.b) >= 40 || class_340.d(var2 - var7.c) >= 40);

        var7.d += var3;
    }

    public void a(Context var1) {
        this.o.a(Paint$Style.b);
        this.o.a(1.0F);
        this.s.a(255, 255, 255, 255);
        this.s.a(Paint$Style.b);
        this.s.a(1.0F);
        this.W = new class_525[11];

        for(int var2 = 0; var2 <= 10; ++var2) {
            this.W[var2] = new class_525();
            this.W[var2].b(-16777216);
            this.W[var2].a((Paint$Style)Paint$Style.a);
            this.W[var2].c(var2 * 25);
        }

        this.X = new class_525();
        this.X.b(-16777216);
        this.X.a((Paint$Style)Paint$Style.a);
        this.t.a(255, 255, 0, 0);
        this.t.a(Paint$Style.b);
        this.t.a(2.0F);
        this.u.a(155, 255, 0, 0);
        this.u.a(Paint$Style.b);
        this.u.a(2.0F);
        this.v.a(200, 12, 227, 219);
        this.v.a(Paint$Style.b);
        this.v.a(2.0F);
        this.x.b(-16711936);
        this.y.b(-256);
        this.z.b(-65536);
        this.A.b(a(this.x.e()));
        this.B.b(a(this.y.e()));
        this.C.b(a(this.z.e()));
        this.D.a(210, 255, 255, 255);
    }

    public static int a(int var0) {
        int var1 = Color.a(Color.a(var0), (int)((float)Color.b(var0) * 0.5F), (int)((float)Color.c(var0) * 0.5F), (int)((float)Color.d(var0) * 0.5F));
        return var1;
    }

    public void a() {
        GameEngine var1 = GameEngine.getGameEngine();
        if (!InterfaceEngine.bR) {
            this.a = (float)((int)(var1.cl - (this.c + 0.0F)));
            this.b = 0.0F;
        } else {
            this.a = 0.0F;
            this.b = (float)((int)(var1.cm - (this.d + 0.0F)));
        }

    }

    public int b() {
        return (int)(this.b + this.d);
    }

    public void a(class_484 var1, boolean var2) {
        this.af.clear();
        if (var2) {
            this.m = true;
        } else {
            this.g = 1;
            this.h = 1;
            this.i = 1.0F;
            this.j = 1.0F;
            this.f = false;
            this.e = false;
        }
    }

    public void c() {
        if (this.J != null) {
            this.J.o();
            this.J = null;
        }

        if (this.F != null) {
            this.F.o();
            this.F = null;
        }

        if (this.T != null) {
            this.T.o();
            this.T = null;
        }

        if (this.U != null) {
            this.U.o();
            this.U = null;
        }

        if (this.I != null) {
            this.I.q();
            this.I = null;
        }

        if (this.H != null) {
            this.H.o();
            this.H = null;
        }

        this.K = null;
        this.e = false;
    }

    public float d() {
        GameEngine var1 = GameEngine.getGameEngine();
        return var1.cq;
    }

    public void e() {
        GameEngine var1 = GameEngine.getGameEngine();
        this.f();
        GameEngine.log("Creating minimap image buffers..");
        if (this.F == null) {
            this.F = var1.bO.a((int)this.c, (int)this.d, false);
            this.G = var1.bO.b(this.F);
        }

        if (this.J == null) {
            this.J = var1.bO.a((int)this.c, (int)this.d, false);
            this.K = var1.bO.b(this.J);
        }

        if (this.H == null) {
            this.H = var1.bO.a((int)this.c, (int)this.d, false);
            this.I = var1.bO.b(this.H);
        }

    }

    public void f() {
        this.c = this.d();
        this.d = this.c;
        this.a();
    }

    public void g() {
        boolean var1 = true;
        long var2 = com.corrodinggames.rts.gameFramework.Unit.loadAllUnitsTook();
        GameEngine.log("--setting up minimap--");
        GameEngine var4 = GameEngine.getGameEngine();
        this.f();
        this.g = var4.bL.width * var4.bL.n;
        this.h = var4.bL.height * var4.bL.o;
        if (this.g <= 0) {
            this.g = 1;
        }

        if (this.h <= 0) {
            this.h = 1;
        }

        this.i = 1.0F / (float)this.g;
        this.j = 1.0F / (float)this.h;
        this.f = true;
        this.e();
        this.Z.clear();
        this.aa.clear();
        this.ag.clear();
        Iterator var5 = var4.bL.A.iterator();

        while(var5.hasNext()) {
            Point var6 = (Point)var5.next();
            this.ag.add(new class_541(this, var6.a, var6.b));
        }

        this.G.b(-16777216);
        this.K.b(-16777216);
        boolean var18 = false;
        boolean var19 = false;
        boolean var7 = false;
        if (!var1) {
            Rect var8 = new Rect(0, 0, (int)this.c, (int)this.d);
            var4.bL.u.a(this.G, 0.0F, 0.0F, 0.0F, 0.0F, (float)this.g, (float)this.h, this.c / (float)this.g, this.d / (float)this.h, false, false, false);
            Paint var9 = new Paint();
            var9.a(50, 0, 0, 0);
            this.G.b(var8, var9);
        } else {
            byte var20 = 2;

            for(int var22 = 0; var22 < var20; ++var22) {
                for(int var10 = 0; var10 < var20; ++var10) {
                    this.I.b(-16777216);
                    int var11 = (int)this.c / var20;
                    int var12 = (int)this.d / var20;
                    int var13 = this.g / var20;
                    int var14 = this.h / var20;
                    var4.bL.u.a(this.I, (float)(var13 * var22), (float)(var14 * var10), (float)(var13 * var22), (float)(var14 * var10), (float)var13, (float)var14, this.c / (float)var13, this.d / (float)var14, false, false, false);
                    Rect var15 = new Rect(0, 0, (int)this.c, (int)this.d);
                    Rect var16 = new Rect(var11 * var22, var12 * var10, var11 * (var22 + 1), var12 * (var10 + 1));
                    Paint var17 = new Paint();
                    var17.a(true);
                    var17.d(true);
                    var17.b(true);
                    this.K.a(this.H, var15, var16, var17);
                }
            }

            Rect var23 = new Rect(0, 0, (int)this.c, (int)this.d);
            this.G.b(-16777216);
            Paint var24 = new Paint();
            var24.a(true);
            var24.d(true);
            var24.b(true);
            var24.a(200, 255, 255, 255);
            this.G.a(this.J, var23, var23, var24);
        }

        this.I.b(-16777216);
        this.K.b(-16777216);
        this.M = 50.0F;
        this.a(0.0F, 1.0F);
        this.e = true;
        double var21 = (double) com.corrodinggames.rts.gameFramework.Unit.a(var2);
        GameEngine.log("Minimap map render took:" + com.corrodinggames.rts.gameFramework.Unit.a(var21));
    }

    void a(float var1, float var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        this.ab.a(0, (int)(var1 * this.d), (int)this.c, (int)(var2 * this.d));
        this.I.a(this.F, this.ab, (Rect)this.ab, (Paint)null);
        class_484 var4 = var3.bL;
        if (var4.E) {
            boolean var5 = var4.G;
            class_525 var6 = this.W[5];
            class_525 var7 = this.W[10];
            class_525 var8 = this.X;
            var8.c(255);
            float var9;
            if (var5) {
                var7 = this.W[7];
                var9 = 1.0F - (1.0F - (float)var6.f() / 255.0F) * (1.0F - (float)var7.f() / 255.0F);
                var8.c((int)(var9 * 255.0F));
            }

            var9 = this.c / (float)var4.width;
            float var10 = this.d / (float)var4.height;
            byte var11 = 0;
            byte var12 = 0;
            int var13 = (int)(var1 * (float)var4.height) - 1;
            int var14 = (int)(var2 * (float)var4.height) + 1;
            if (var13 < 0) {
                var13 = 0;
            }

            if (var14 < 0) {
                var14 = 0;
            }

            if (var13 > var3.bL.height) {
                var13 = var4.height;
            }

            if (var14 > var3.bL.height) {
                var14 = var4.height;
            }

            int var15 = 0;
            byte[][] var16 = var3.playerTeam.N;
            if (var16 != null) {
                int var17 = var4.width;
                Rect var18 = this.V;

                for(int var19 = var13; var19 < var14; ++var19) {
                    for(int var20 = 0; var20 < var17; ++var20) {
                        byte var21 = var16[var20][var19];
                        if (var21 != 0) {
                            int var22 = var20;

                            int var23;
                            for(var23 = var20; var23 < var17 - 1 && var16[var23][var19] == var21; ++var23) {
                            }

                            var20 = var23;
                            var18.a(var11 + (int)((float)var22 * var9), var12 + (int)((float)var19 * var10), var11 + (int)((float)(var23 + 1) * var9), var12 + (int)((float)(var19 + 1) * var10));
                            class_525 var24;
                            if (var21 == 10) {
                                var24 = var8;
                            } else {
                                var24 = var6;
                            }

                            this.I.b((Rect)var18, var24);
                            ++var15;
                            if (var15 > 2) {
                                var15 = 0;
                            }
                        }
                    }
                }
            }
        }

        this.K.a(this.H, this.ab, (Rect)this.ab, (Paint)null);
        this.J.p();
        if (GameEngine.aY) {
        }

    }

    static class_527 a(int var0, Paint var1) {
        synchronized(ac) {
            class_527 var3 = null;
            Iterator var4 = ac.iterator();

            while(true) {
                class_527 var5;
                do {
                    do {
                        if (!var4.hasNext()) {
                            if (var3 != null) {
                                ac.remove(var3);
                                var3.c = var1;
                                return var3;
                            }

                            return new class_527(var0 + 15, var1);
                        }

                        var5 = (class_527)var4.next();
                    } while(var5.d < var0);
                } while(var3 != null && var5.d >= var3.d);

                var3 = var5;
            }
        }
    }

    static void a(class_527 var0) {
        var0.c = null;
        var0.b = 0;
        synchronized(ac) {
            if (ac.size() < 20) {
                ac.add(var0);
            } else {
                Iterator var2 = ac.iterator();

                class_527 var3;
                do {
                    if (!var2.hasNext()) {
                        return;
                    }

                    var3 = (class_527)var2.next();
                } while(var3.d >= var0.d);

                var2.remove();
                ac.add(var0);
            }
        }
    }

    void a(class_28 var1, int var2, int var3, float var4, float var5) {
        GameEngine var6 = GameEngine.getGameEngine();
        boolean var11 = true;
        byte var7;
        byte var8;
        byte var9;
        byte var10;
        byte var24;
        if (this.c < 50.0F) {
            var8 = 0;
            var7 = 0;
            var10 = 1;
            var9 = 1;
            var24 = 1;
        } else if (this.c < 120.0F) {
            var8 = 0;
            var7 = 0;
            var10 = 2;
            var9 = 2;
            var24 = 2;
        } else {
            var8 = -1;
            var7 = -1;
            var10 = 2;
            var9 = 2;
            var24 = 3;
        }

        int var10000 = var7 + var2;
        var10000 = var10 + var2;
        var10000 = var9 + var3;
        var10000 = var8 + var3;
        boolean var12 = false;
        if (var6.playerTeam.b() || var6.replayEngine.j()) {
            var12 = true;
        }

        for(int var13 = -1; var13 < PlayerData.c; ++var13) {
            PlayerData var14 = PlayerData.getPlayerData(var13);
            if (var14 != null) {
                Paint var15 = var14.ae;
                if (var6.settingsEngine.useMinimapAllyColors) {
                    if (var12) {
                        this.p.b(PlayerData.i(var14.team));
                        var15 = this.p;
                    } else if (var6.playerTeam == var14) {
                        var15 = this.x;
                    } else if (var6.playerTeam.d(var14)) {
                        var15 = this.y;
                    } else if (var6.playerTeam.c(var14)) {
                        var15 = this.z;
                    }
                }

                int var16 = 0;
                int var18;
                int var19;
                if (var14.a(true, false) > 0) {
                    Unit[] var17 = Unit.bE.a();
                    var18 = 0;

                    for(var19 = Unit.bE.size(); var18 < var19; ++var18) {
                        Unit var20 = var17[var18];
                        if (var20.bX == var14 && var20.cR) {
                            ++var16;
                        }
                    }
                }

                int var29;
                if (var16 > 0) {
                    var15.a((float)var24);
                    class_527 var25 = a(var16, var15);
                    var25.e = !var6.settingsEngine.renderWithLineWidth;
                    Unit[] var27 = Unit.bE.a();
                    var19 = 0;

                    for(var29 = Unit.bE.size(); var19 < var29; ++var19) {
                        Unit var21 = var27[var19];
                        if (var21.bX == var14 && var21.cR) {
                            var25.a((float)var21.cS, (float)var21.cT);
                        }
                    }

                    if (var25.b != 0) {
                        var6.bO.a((class_526)var25);
                    }
                }

                Paint var26 = var14.af;
                if (var6.settingsEngine.useMinimapAllyColors) {
                    if (var12) {
                        this.p.b(PlayerData.i(var14.team));
                        var15 = this.p;
                    } else if (var6.playerTeam == var14) {
                        var26 = this.A;
                    } else if (var6.playerTeam.d(var14)) {
                        var26 = this.B;
                    } else if (var6.playerTeam.c(var14)) {
                        var26 = this.C;
                    }
                }

                var18 = 0;
                Object[] var28 = class_990.w.b();
                var29 = 0;

                int var31;
                for(var31 = class_990.w.size(); var29 < var31; ++var29) {
                    class_990 var22 = (class_990)var28[var29];
                    if (var22.e == var14 && var22.k) {
                        ++var18;
                    }
                }

                if (var18 > 0) {
                    var26.a((float)var24);
                    class_527 var30 = a(var18, var26);
                    Object[] var32 = class_990.w.b();
                    var31 = 0;

                    for(int var33 = class_990.w.size(); var31 < var33; ++var31) {
                        class_990 var23 = (class_990)var32[var31];
                        if (var23.e == var14 && var23.k) {
                            var30.a((float)var23.l, (float)var23.m);
                        }
                    }

                    if (var30.b != 0) {
                        var6.bO.a((class_526)var30);
                    }
                }
            }
        }

    }

    public void a(int var1, int var2, class_536 var3) {
        class_538 var4 = new class_538(this);
        var4.a = var1;
        var4.b = var2;
        var4.e = var3;
        var4.c = 0.9F;
        var4.d = 0.9F;
        this.aa.add(var4);
    }

    public void h() {
        GameEngine var1 = GameEngine.getGameEngine();
        this.m = false;
        this.k = (int)this.a;
        this.l = (int)this.b;
        Unit[] var2 = Unit.bE.a();
        int var3 = 0;

        int var4;
        for(var4 = Unit.bE.size(); var3 < var4; ++var3) {
            Unit var5 = var2[var3];
            if (!var5.bV && var5.cN == null && var5.cf() && var5.c_() && !var5.u()) {
                Point var6 = this.b(var5.xCord, var5.yCord);
                var5.cS = var6.a;
                var5.cT = var6.b;
                var5.cR = true;
            } else {
                var5.cR = false;
            }
        }

        Object[] var8 = class_990.w.b();
        var4 = 0;

        Point var7;
        for(int var10 = class_990.w.size(); var4 < var10; ++var4) {
            class_990 var12 = (class_990)var8[var4];
            if (!var12.n && var12.u) {
                var7 = this.b(var12.g, var12.h);
                var12.l = var7.a;
                var12.m = var7.b;
                var12.k = true;
            }
        }

        PlayerData var9 = var1.playerTeam;
        Iterator var11 = this.ag.iterator();

        while(var11.hasNext()) {
            class_541 var13 = (class_541)var11.next();
            var13.e = false;
            if (var1.bL.a(var9, var13.a, var13.b)) {
                var13.e = true;
                var7 = this.b((float)(var13.a * var1.bL.n), (float)(var13.b * var1.bL.o));
                var13.c = var7.a;
                var13.d = var7.b;
            }
        }

    }

    public void a(float var1) {
        if (!GameEngine.isModsInSD || GameEngine.aW) {
            GameEngine var2 = GameEngine.getGameEngine();
            this.L = class_340.a(this.L, var1);
            if (this.L == 0.0F) {
                this.L = 15.0F;
                this.h();
            }

            this.Y += var1;
            if (this.Y > 15.0F) {
                class_535 var3 = null;
                Iterator var4 = this.Z.iterator();

                while(var4.hasNext()) {
                    class_535 var5 = (class_535)var4.next();
                    if (var5.e != 0.0F) {
                        var5.d = 0.0F;
                    } else if (var5.d > 15.0F) {
                        var5.d = 0.0F;
                        var5.e = 300.0F;
                        class_538 var6 = new class_538(this);
                        var6.a = var5.b;
                        var6.b = var5.c;
                        if (var5.a) {
                            var6.e = class_536.BASE;
                        } else {
                            var6.e = class_536.UNIT;
                            var6.c = 0.4F;
                            var6.d = 0.8F;
                        }

                        this.aa.add(var6);
                    }

                    var5.d = class_340.a(var5.d, 2.0F * this.Y);
                    var5.e = class_340.a(var5.e, this.Y);
                    if (var5.d == 0.0F && var5.e == 0.0F) {
                        var3 = var5;
                    }
                }

                if (var3 != null) {
                    this.Z.remove(var3);
                }

                var4 = this.aa.iterator();

                while(var4.hasNext()) {
                    class_538 var7 = (class_538)var4.next();
                    if (var7.e != class_536.MESSAGE && var2.cQ.b(var7.a, var7.b)) {
                        var7.c = 0.0F;
                        var7.d = 0.0F;
                    }
                }

                this.Y = 0.0F;
            }

        }
    }

    public float b(float var1) {
        return var1 * this.i * this.c;
    }

    public Point b(float var1, float var2) {
        if (!this.f) {
            this.ad.a(-1, -1);
            return this.ad;
        } else {
            int var3 = (int)(var1 * this.i * this.c + this.a);
            int var4 = (int)(var2 * this.j * this.d + this.b);
            this.ad.a(var3, var4);
            return this.ad;
        }
    }

    public Point c(float var1, float var2) {
        if (!(var1 < this.a) && !(var2 < this.b) && !(var1 > this.a + this.c) && !(var2 > this.b + this.d)) {
            int var3 = (int)((var1 - this.a) / this.c * (float)this.g);
            int var4 = (int)((var2 - this.b) / this.d * (float)this.h);
            this.ad.a(var3, var4);
            return this.ad;
        } else {
            return null;
        }
    }

    public float c(float var1) {
        if (var1 < this.a) {
            return this.a;
        } else {
            return var1 > this.a + this.c ? this.a + this.c : var1;
        }
    }

    public float d(float var1) {
        if (var1 < this.b) {
            return this.b;
        } else {
            return var1 > this.b + this.d ? this.b + this.d : var1;
        }
    }

    public void e(float var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        class_28 var3 = var2.bO;
        this.a();
        if (this.J != null && !class_340.e(this.c, this.d(), 5.0F)) {
            GameEngine.b("minimap", "minimap size has changed, reseting");
            this.c();
        }

        if (!this.e || this.J == null) {
            this.g();
        }

        if (this.k != (int)this.a || this.l != (int)this.b || this.m) {
            this.h();
        }

        if (var2.bL.E) {
            if (this.O && !this.P) {
                this.M = class_340.a(this.M, 1.0F);
                if (this.M == 0.0F) {
                    this.M = 40.0F;
                    this.O = false;
                    this.Q = 0.0F;
                    this.P = true;
                }
            }

            if (this.P) {
                this.N = class_340.a(this.N, 1.0F);
                if (this.N == 0.0F) {
                    this.N = 3.0F;
                    if (this.J != null) {
                        float var4 = this.Q - 0.005F;
                        this.Q = (float)((double)this.Q + 0.04);
                        if (var4 < 0.0F) {
                            var4 = 0.0F;
                        }

                        if (this.Q >= 1.0F) {
                            this.Q = 1.0F;
                            this.P = false;
                        }

                        this.a(var4, this.Q);
                    }
                }
            }
        }

        var3.b(this.J, this.a, this.b, this.n);
        this.w.a((int)this.a, (int)this.b, (int)(this.a + this.c), (int)((double)(this.b + this.d) - 0.4));
        boolean var16 = false;
        boolean var5 = false;
        boolean var6 = false;
        Object[] var7 = Projectile.a.a();
        int var8 = 0;

        int var9;
        Projectile var10;
        for(var9 = Projectile.a.a; var8 < var9; ++var8) {
            var10 = (Projectile)var7[var8];
            if (var10.D) {
                var6 = true;
                var5 = true;
            }
        }

        Iterator var17 = this.aa.iterator();

        class_538 var19;
        while(var17.hasNext()) {
            var19 = (class_538)var17.next();
            if (var19.e != class_536.UNIT) {
                var16 = true;
                if (var19.e != class_536.MESSAGE) {
                    var5 = true;
                }
            }
        }

        if (!var16 && !var6) {
            this.o.a(255, 100, 100, 100);
            this.o.a(1.0F);
            if (InterfaceEngine.bO) {
                this.o.a(115, 0, 0, 0);
                this.o.a(2.0F);
            }
        } else {
            this.q += 5.0F * var1;
            if (this.q > 180.0F) {
                this.q -= 180.0F;
            }

            float var18 = class_340.j(this.q);
            if (var6) {
                this.o.a(255, 0, (int)(0.0F + var18 * 230.0F), 0);
            } else if (!var5) {
                this.o.a(255, 12, (int)(0.0F + var18 * 220.0F), (int)(0.0F + var18 * 220.0F));
            } else {
                this.o.a(255, (int)(0.0F + var18 * 230.0F), 0, 0);
            }

            this.o.a(2.0F);
        }

        var3.b(this.w, this.o);
        var17 = this.ag.iterator();

        while(var17.hasNext()) {
            class_541 var20 = (class_541)var17.next();
            if (var20.e) {
                this.V.a(var20.c, var20.d, var20.c + 2, var20.d + 2);
                var3.b(this.V, this.D);
            }
        }

        this.a(var3, 0, 0, 0.0F, 1.0F);
        Point var11;
        if (this.af.size() != 0) {
            var17 = this.af.iterator();

            while(var17.hasNext()) {
                class_539 var21 = (class_539)var17.next();
                if (var21.a.bV) {
                    var17.remove();
                } else {
                    Unit var22 = var21.a;
                    var11 = this.b(var22.xCord, var22.yCord);
                    if (!var22.a(var11.a, var11.b)) {
                        var3.a((float)var11.a, (float)var11.b, 4.0F, var22.bX.ae);
                    }
                }
            }
        }

        var8 = 0;

        float var12;
        for(var9 = Projectile.a.a; var8 < var9; ++var8) {
            var10 = (Projectile)var7[var8];
            if ((var10.D || var10.q != null && var10.q.D) && var10.j != null) {
                var11 = this.b(var10.xCord, var10.yCord);
                var12 = 2.0F;
                if (var10.D) {
                    var12 = 4.0F;
                }

                var3.a((float)var11.a, (float)var11.b, var12, var10.j.bX.ae);
            }
        }

        Point var23 = this.b(var2.cw, var2.cx);
        this.E.a = var23.a;
        this.E.b = var23.b;
        var23 = this.b(var2.cw + var2.cA, var2.cx + var2.cB);
        this.E.c = var23.a;
        this.E.d = var23.b;
        if (this.E.a < this.w.a) {
            this.E.a = this.w.a;
        }

        if (this.E.c > this.w.c) {
            this.E.c = this.w.c;
        }

        if (this.E.b < this.w.b) {
            this.E.b = this.w.b;
        }

        if (this.E.d > this.w.d) {
            this.E.d = this.w.d;
        }

        var3.b(this.E, this.s);
        this.r += 6.0F * var1;
        if (this.r > 180.0F) {
            this.r -= 180.0F;
        }

        var17 = this.aa.iterator();

        while(var17.hasNext()) {
            var19 = (class_538)var17.next();
            Point var24 = this.b((float)var19.a, (float)var19.b);
            float var25 = var19.c;
            var12 = 0.05F;
            Paint var13;
            float var14;
            if (var19.e == class_536.UNIT) {
                var13 = this.u;
                var12 = 0.03F;
                var14 = class_340.j(this.r);
                var13.a((int)(50.0F + var14 * 190.0F), (int)(50.0F + var14 * 190.0F), 0, 0);
            } else if (var19.e == class_536.MESSAGE) {
                var13 = this.v;
            } else {
                var13 = this.t;
                var14 = class_340.j(this.r);
                var13.a((int)(50.0F + var14 * 190.0F), (int)(50.0F + var14 * 190.0F), 0, 0);
            }

            var25 = class_340.b(var25, var12, 1.0F);
            if (var19.e == class_536.UNIT) {
                var14 = this.c * var25;
                float var15 = this.d * var25;
                var3.a(this.c((float)var24.a - var14), this.d((float)var24.b - var15), this.c((float)var24.a + var14), this.d((float)var24.b + var15), var13);
                var3.a(this.c((float)var24.a + var14), this.d((float)var24.b - var15), this.c((float)var24.a - var14), this.d((float)var24.b + var15), var13);
            } else {
                var3.a(this.c((float)var24.a - this.c * var25), this.d((float)var24.b), this.c((float)var24.a + this.c * var25), this.d((float)var24.b), var13);
                var3.a(this.c((float)var24.a), this.d((float)var24.b - this.d * var25), this.c((float)var24.a), this.d((float)var24.b + this.d * var25), var13);
            }

            var19.c = class_340.a(var19.c, 0.04F * var1);
            if (var19.c == 0.0F) {
                var19.d = class_340.a(var19.d, 0.005F * var1);
                if (var19.d == 0.0F) {
                    var17.remove();
                }
            }
        }

    }

    public void a(Unit var1) {
        if (!this.af.contains(var1)) {
            class_539 var2 = new class_539(this);
            var2.a = var1;
            this.af.add(var2);
        }
    }
}
