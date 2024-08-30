package com.corrodinggames.rts.game.units;

import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.PorterDuff.Mode;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.ScorchMark;
import com.corrodinggames.rts.game.a.class_65;
import com.corrodinggames.rts.game.a.class_69;
import com.corrodinggames.rts.game.maps.class_482;
import com.corrodinggames.rts.game.maps.class_484;
import com.corrodinggames.rts.game.units.a.class_1059;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.a.class_231;
import com.corrodinggames.rts.game.units.custom.class_387;
import com.corrodinggames.rts.game.units.custom.class_436;
import com.corrodinggames.rts.game.units.custom.GameEvent;
import com.corrodinggames.rts.game.units.custom.class_588;
import com.corrodinggames.rts.game.units.custom.b.class_826;
import com.corrodinggames.rts.game.units.custom.d.class_447;
import com.corrodinggames.rts.game.units.buildings.class_88;
import com.corrodinggames.rts.game.units.buildings.RepairBay;
import com.corrodinggames.rts.game.units.f.class_302;
import com.corrodinggames.rts.game.units.g.class_795;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_324;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.class_353;
import com.corrodinggames.rts.gameFramework.GameObject;
import com.corrodinggames.rts.gameFramework.class_984;
import com.corrodinggames.rts.gameFramework.a.class_648;
import com.corrodinggames.rts.gameFramework.d.Emitter;
import com.corrodinggames.rts.gameFramework.d.class_989;
import com.corrodinggames.rts.gameFramework.d.class_990;
import com.corrodinggames.rts.gameFramework.d.Priority;
import com.corrodinggames.rts.gameFramework.d.class_998;
import com.corrodinggames.rts.gameFramework.k.PathEngine;
import com.corrodinggames.rts.gameFramework.k.class_221;
import com.corrodinggames.rts.gameFramework.k.class_224;
import com.corrodinggames.rts.gameFramework.k.class_319;
import com.corrodinggames.rts.gameFramework.m.class_28;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.m.class_525;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import com.corrodinggames.rts.gameFramework.utility.Point3DF;
import com.corrodinggames.rts.gameFramework.utility.class_682;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import com.corrodinggames.rts.gameFramework.utility.class_692;
import com.corrodinggames.rts.gameFramework.utility.class_694;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

// $FF: renamed from: com.corrodinggames.rts.game.units.y
// class_82
public abstract strictfp class OrderableUnit extends class_81 {
    public static boolean L = false;
    protected TeamImageCache M;
    protected TeamImageCache N;
    private int a;
    private float b;
    private float c;
    private float d;
    private float e;
    private int f = 0;
    public static final class_1042[] O = new class_1042[0];
    private class_1042[] g;
    public AttackMode P;
    int Q;
    public Unit R;
    public float S;
    public float T;
    public float U;
    private boolean h;
    private int i;
    public float V;
    public float W;
    public float X;
    public float Y;
    private boolean j;
    private boolean k;
    private float l;
    private float m;
    private int n;
    private float o;
    private float p;
    private byte q;
    private int r;
    private float s;
    private boolean t;
    public Unit Z;
    public int aa;
    public float ab;
    public int ac;
    public OrderableUnit ad;
    public boolean ae;
    public boolean af;
    public int ag;
    public short ah;
    public float ai;
    public boolean aj;
    public float ak;
    public float al;
    public float am;
    public int an;
    public float ao;
    public boolean ap;
    public float aq;
    public boolean ar;
    public boolean as;
    public static final class_1045[] at = new class_1045[0];
    public class_221 au;
    protected class_1045[] av;
    protected int aw;
    private boolean u;
    private int v;
    private int w;
    public boolean ax;
    public boolean ay;
    public float az;
    public float aA;
    public class_65 aB;
    public class_69 aC;
    public boolean aD;
    public static final class_525 aE = new class_525();
    public static final class_525 aF;
    public static final PointF aG;
    private class_525 x;
    private int y;
    private class_525 z;
    private int A;
    private static final Paint B;
    private static int C;
    private static final class_525 D;
    private static final class_525 E;
    public static class_302 aH;
    public byte aI;
    public Unit[] aJ;
    public float[] aK;
    public int aL;
    public static final class_692 aM;
    public boolean aN;
    public boolean aO;
    static final class_1044 aP;
    public static class_307 aQ;
    public static class_307 aR;
    public static class_306 aS;
    public static class_306 aT;
    class_224 aU;
    static class_684 aV;
    public static final class_1045 aW;
    protected static PorterDuffColorFilter aX;
    protected static PorterDuffColorFilter aY;
    protected static PorterDuffColorFilter aZ;
    protected static PorterDuffColorFilter ba;
    protected static Paint bb;
    protected static Paint bc;
    protected static Paint bd;
    static final PointF be;
    protected static final Point3DF bf;
    protected static final PointF bg;
    protected static final PointF bh;
    protected static final Point3DF bi;
    protected static final PointF bj;
    static final Point bk;
    static final Point bl;
    static final PointF bm;
    static final class_810 bn;
    public static final class_308 bo;
    public class_684 bp;
    static class_684 bq;

    public strictfp void b(float var1) {
        if (this.az < var1) {
            this.az = var1;
        }

    }

    public strictfp Paint R() {
        boolean var1 = this.aO();
        return var1 ? aF : aE;
    }

    public static strictfp void a(OrderableUnit var0, OrderableUnit var1) {
        try {
            GameOutputStream var2 = new GameOutputStream();
            int var3 = var0.f;

            for(int var4 = 0; var4 < var3; ++var4) {
                var0.g[var4].a(var2);
            }

            GameInputStream var8 = new GameInputStream(var2.toByteArray());
            var1.f = var3;

            for(int var5 = 0; var5 < var3; ++var5) {
                int var6 = var5;
                var1.m(var5);
                if (var5 >= var1.g.length) {
                    GameEngine.print("Too many waypoints:" + var5);
                    var6 = var1.g.length - 1;
                }

                if (var1.g[var6] == null) {
                    var1.g[var6] = new class_1042();
                }

                var1.g[var6].a(var8);
                var1.g[var6].convertUnitIds();
            }

        } catch (Exception var7) {
            throw new RuntimeException(var7);
        }
    }

    public strictfp void a(GameOutputStream var1) {
        var1.writeFloat(this.b);
        var1.writeFloat(this.c);
        var1.writeFloat(this.cL[0].e);
        var1.writeInt(this.f);
        int var2 = this.f;
        var1.writeInt(var2);

        for(int var3 = 0; var3 < var2; ++var3) {
            this.g[var3].a(var1);
        }

        var1.writeEnum(this.P);
        Unit var5 = this.R;
        if (var5 != null && var5.bV) {
            var5 = null;
        }

        var1.a(var5);
        var1.writeFloat(this.S);
        var1.writeFloat(this.U);
        var1.writeFloat(this.V);
        var1.d("pathing_active:");
        var1.writeBoolean(this.k);
        var1.writeFloat(this.l);
        var1.writeFloat(this.m);
        var1.writeFloat(this.s);
        var1.a(this.ad);
        var1.writeBoolean(this.ae);
        var1.writeBoolean(this.af);
        var1.writeBoolean(this.aj);
        var1.writeFloat(this.ak);
        var1.writeFloat(this.al);
        var1.writeFloat(this.am);
        var1.writeInt(this.an);
        var1.writeInt(this.ac);
        var1.d("activePathCount:");
        var1.writeInt(this.aw);

        for(int var4 = 0; var4 < this.aw; ++var4) {
            this.av[var4].a(var1);
        }

        var1.writeInt(this.aw);
        var1.writeInt(this.v);
        if (var1.f()) {
        }

        var1.writeByte(12);
        var1.writeFloat(this.o);
        var1.writeFloat(this.p);
        var1.writeFloat(this.d);
        var1.writeFloat(this.e);
        var1.writeBoolean(this.u);
        var1.writeFloat(this.ai);
        var1.writeInt(this.n);
        var1.writeFloat(this.W);
        var1.writeFloat(this.aq);
        var1.writeBoolean(this.ar);
        var1.writeBoolean(this.as);
        var1.a(this.ah);
        var1.writeFloat(this.ab);
        var1.writeInt(this.w);
        var1.writeFloat(this.X);
        var1.writeFloat(this.az);
        var1.writeFloat(this.aA);
        class_795.a(this, var1);
        super.a(var1);
    }

    public strictfp void a(GameInputStream var1) {
        this.b = var1.readFloat();
        this.c = var1.readFloat();
        this.cL[0].e = var1.readFloat();
        this.f = var1.readInt();
        if (this.f > 0) {
            this.m(class_340.c(this.f - 1, 29));
        }

        int var2 = 30;
        if (var1.b() >= 42) {
            var2 = var1.readInt();
        }

        for(int var3 = 0; var3 < var2; ++var3) {
            int var4 = var3;
            this.m(var3);
            if (var3 >= this.g.length) {
                GameEngine.print("Too many waypoints:" + var3);
                var4 = this.g.length - 1;
            }

            if (this.g[var4] == null) {
                this.g[var4] = new class_1042();
            }

            this.g[var4].a(var1);
        }

        this.P = (AttackMode)var1.readEnum(AttackMode.class);
        if (this.P == AttackMode.outOfRange) {
            if (!this.I()) {
                this.P = AttackMode.onlyInRange;
            }

            if (var1.b() < 74) {
                this.P = AttackMode.onlyInRange;
            }
        }

        long var7 = var1.m5452n();
        this.S = var1.readFloat();
        this.U = var1.readFloat();
        this.V = var1.readFloat();
        this.k = var1.readBoolean();
        this.l = var1.readFloat();
        this.m = var1.readFloat();
        this.s = var1.readFloat();
        this.a(var1.p());
        this.ae = var1.readBoolean();
        this.af = var1.readBoolean();
        this.aj = var1.readBoolean();
        this.ak = var1.readFloat();
        this.al = var1.readFloat();
        this.am = var1.readFloat();
        this.an = var1.readInt();
        if (var1.b() >= 18) {
            this.ac = var1.readInt();
        }

        int var6;
        if (var1.b() >= 21) {
            int var5 = var1.readInt();

            for(var6 = 0; var6 < var5; ++var6) {
                this.l(var6);
                if (this.av[var6] == null) {
                    this.av[var6] = new class_1045();
                }

                this.av[var6].a(var1);
            }
        } else {
            boolean var8 = true;

            for(var6 = 0; var6 < 60; ++var6) {
                this.l(var6);
                if (this.av[var6] == null) {
                    this.av[var6] = new class_1045();
                }

                this.av[var6].a(var1);
            }
        }

        this.aw = var1.readInt();
        this.v = var1.readInt();
        byte var9 = var1.readByte();
        if (var9 >= 1) {
            this.o = var1.readFloat();
            this.p = var1.readFloat();
        }

        if (var9 >= 2) {
            this.d = var1.readFloat();
            this.e = var1.readFloat();
        }

        if (var9 >= 3) {
            this.u = var1.readBoolean();
        }

        if (var9 >= 4) {
            this.ai = var1.readFloat();
            this.n = var1.readInt();
        }

        if (var9 >= 5) {
            this.W = var1.readFloat();
        }

        if (var9 >= 6) {
            this.aq = var1.readFloat();
            this.ar = var1.readBoolean();
            this.as = var1.readBoolean();
        }

        if (var9 >= 7) {
            this.ah = var1.readShort();
        }

        if (var9 >= 8) {
            this.ab = var1.readFloat();
        }

        if (var9 >= 9) {
            this.w = var1.readInt();
        }

        if (var9 >= 10) {
            this.X = var1.readFloat();
        }

        if (var9 >= 11) {
            this.az = var1.readFloat();
            this.aA = var1.readFloat();
        }

        if (var9 >= 12) {
            class_795.a(this, var1);
        }

        super.a(var1);
        if (!this.bV) {
            this.R = GameObject.a(var7, false);

            for(var6 = 0; var6 < this.f; ++var6) {
                if (this.g[var6] == null) {
                    GameEngine.log("readIn: convertUnitIds is null: " + var6 + " waypointsCount:" + this.f);
                } else {
                    this.g[var6].convertUnitIds();
                }
            }
        }

        this.S();
        if (this.bV) {
            this.ew = true;
        }

    }

    public strictfp void b(PlayerData var1) {
        super.b(var1);
        this.S();
    }

    public strictfp void S() {
        this.M = this.d();
        this.N = this.k();
    }

    public abstract TeamImageCache d();

    public abstract TeamImageCache k();

    public abstract TeamImageCache d(int var1);

    public strictfp float h(int var1) {
        return 0.0F;
    }

    public strictfp float i(int var1) {
        return 0.0F;
    }

    public strictfp TeamImageCache T() {
        return null;
    }

    public strictfp Paint a(int var1, ColorFilter var2, boolean var3) {
        if (var1 == -1 && var2 == null) {
            return var3 ? E : D;
        } else {
            Object var4;
            int var5;
            if (this.cp) {
                if (var2 == null) {
                    var4 = B;
                    var5 = C;
                    C = var1;
                } else {
                    var4 = B;
                    var5 = -1;
                    if (var2 == aZ) {
                        var4 = bc;
                    }

                    if (var2 == aY) {
                        var4 = bb;
                    }

                    if (var2 == ba) {
                        var4 = bd;
                    }
                }
            } else if (var3) {
                if (this.z == null) {
                    this.z = a(true);
                }

                var4 = this.z;
                var5 = this.A;
                this.A = var1;
            } else {
                if (this.x == null) {
                    this.x = a(false);
                }

                var4 = this.x;
                var5 = this.y;
                this.y = var1;
            }

            if (var5 != var1) {
                ((Paint)var4).b(var1);
            }

            if (((Paint)var4).h() != var2) {
                ((Paint)var4).a(var2);
            }

            return (Paint)var4;
        }
    }

    public static strictfp class_525 a(boolean var0) {
        class_525 var1 = new class_525();
        if (var0) {
            var1.a(true);
            var1.d(true);
            var1.b(true);
        } else {
            var1.a(false);
            var1.d(false);
            var1.b(false);
        }

        return var1;
    }

    public OrderableUnit(boolean var1) {
        super(var1);
        this.g = O;
        this.P = AttackMode.onlyInRange;
        this.Q = -9999;
        this.i = -9999;
        this.l = 3.0F;
        this.m = 3.0F;
        this.aj = false;
        this.ak = 0.0F;
        this.al = 0.0F;
        this.am = 0.0F;
        this.an = 0;
        this.ao = 0.0F;
        this.aq = -999.0F;
        this.ar = false;
        this.as = false;
        this.av = at;
        this.aw = 0;
        this.v = 0;
        this.ax = true;
        this.x = null;
        this.z = null;
        this.aI = 0;
        this.aL = -9999;
        this.aU = null;
    }

    public final strictfp void j(int var1) {
        int var2 = this.bl();

        for(int var3 = 0; var3 < var2; ++var3) {
            this.cL[var3].a(var1);
        }

    }

    public strictfp void a(String var1) {
        String var2;
        if (this.r() != null) {
            var2 = this.r().i();
        } else {
            var2 = "<NO UNIT TYPE>";
        }

        GameEngine.log("(Unit log:" + var2 + " id:" + this.id + "): " + var1);
    }

    public strictfp void U() {
        String var1;
        if (this.r() != null) {
            var1 = this.r().i();
        } else {
            var1 = "<NO UNIT TYPE>";
        }

        GameEngine.log("---- Debug for:" + var1 + " id:" + this.id + "---");
    }

    public strictfp void a(float var1) {
        super.a(var1);
        if (this.ay) {
            this.ay = false;
        }

        if (this.cl != 0.0F) {
            this.cl = class_340.a(this.cl, var1);
        }

        if (!this.bV && this.bT()) {
            GameEngine var2 = GameEngine.getGameEngine();
            if (this.az > 0.0F) {
                this.az = class_340.a(this.az, var1);
            }

            if (this.aA > 0.0F) {
                this.aA = class_340.a(this.aA, var1);
            }

            if (this.bp != null) {
                class_795.a(this, var1);
            }

            float var3 = this.xCord;
            float var4 = this.yCord;
            int var5 = this.bl();

            int var6;
            class_1048 var7;
            float var8;
            float var9;
            for(var6 = 0; var6 < var5; ++var6) {
                var7 = this.cL[var6];
                if (var7.d == 0.0F) {
                    var8 = this.C(var6);
                    if (this.b(var6, var1) && var7.a != var8) {
                        var9 = class_340.c(var7.a, var8, 360.0F);
                        if (class_340.c(var9) < 0.5F) {
                            var7.d = 20.0F;
                            var7.c = 0.0F;
                        } else {
                            this.a(var1, var8, var6);
                        }
                    }
                } else {
                    var7.d = class_340.a(var7.d, var1);
                }
            }

            if (!this.bk()) {
                this.k(var1);
            }

            for(var6 = 0; var6 < var5; ++var6) {
                var7 = this.cL[var6];
                if (var7.e != 0.0F) {
                    var7.e = class_340.a(var7.e, var1);
                }
            }

            boolean var16 = this.bi();
            boolean var17 = false;
            var17 = this.cc != 0.0F || this.cd != 0.0F;
            if ((this.cf != 0.0F || var17) && this.I()) {
                var8 = this.cg;
                var9 = this.speed();
                if (this.bj()) {
                    var8 = this.ch;
                }

                float var10;
                float var11;
                if (!var16) {
                    var10 = var9 * this.cf * var1;
                    var3 += class_340.k(var8) * var10;
                    var4 += class_340.j(var8) * var10 * this.aZ();
                    if (var17) {
                        var3 += this.cc * var1;
                        var4 += this.cd * var1 * this.aZ();
                        var11 = class_340.a(0.0F, 0.0F, this.cc, this.cd);
                        if (var11 > var9 * var9) {
                            this.cc = (float)((double)this.cc - (double)this.cc * 0.05 * (double)var1);
                            this.cd = (float)((double)this.cd - (double)this.cd * 0.05 * (double)var1);
                        }

                        this.cc = class_340.a(this.cc, 0.0F, 0.5F * var9 * var1);
                        this.cd = class_340.a(this.cd, 0.0F, 0.5F * var9 * var1);
                    }
                } else {
                    float var12;
                    if (this.cf != 0.0F) {
                        var10 = this.C() * 1.41F;
                        var11 = class_340.k(var8) * var9 * this.cf;
                        var12 = class_340.j(var8) * var9 * this.cf;
                    } else {
                        var10 = this.D() * 1.41F;
                        var11 = 0.0F;
                        var12 = 0.0F;
                    }

                    float var13 = class_340.a(this.cc, this.cd, var11, var12);
                    if (var13 > var9 * var9) {
                        this.cc = (float)((double)this.cc - (double)this.cc * 0.05 * (double)var1);
                        this.cd = (float)((double)this.cd - (double)this.cd * 0.05 * (double)var1);
                    }

                    float var14 = var10 * var1;
                    if (var13 < var14 * var14) {
                        this.cc = var11;
                        this.cd = var12;
                    } else {
                        float var15 = class_340.d(this.cc, this.cd, var11, var12);
                        this.cc += class_340.k(var15) * var14;
                        this.cd += class_340.j(var15) * var14;
                    }

                    var3 += this.cc * var1;
                    var4 += this.cd * var1 * this.aZ();
                }

                this.ay = true;
            }

            if (this.bZ != 0.0F || this.ca != 0.0F) {
                this.bZ = class_340.b(this.bZ, -9.0F, 9.0F);
                this.ca = class_340.b(this.ca, -9.0F, 9.0F);
                var3 += this.bZ;
                var4 += this.ca;
                this.ca = 0.0F;
                this.bZ = 0.0F;
                this.ay = true;
            }

            if (this.ay && this.I() && this.cO == null) {
                this.a(var1, var2, var3, var4);
            }

            if (this.ax) {
                this.ax = false;
                this.c(false);
                this.ay = true;
            }
        }

    }

    private strictfp void a(float var1, GameEngine var2, float var3, float var4) {
        class_484 var5 = var2.bL;
        float var6 = var5.r;
        float var7 = var5.s;
        float var8 = this.xCord * var6;
        float var9 = this.yCord * var7;
        float var10 = var3 * var6;
        float var11 = var4 * var7;
        PointF var12 = null;
        boolean var13 = false;
        int var14 = class_340.f(var8);
        int var15 = class_340.f(var9);
        int var16 = class_340.f(var10);
        int var17 = class_340.f(var11);
        boolean var18;
        boolean var19;
        if ((var14 != var16 || var15 != var17) && this.cl == 0.0F && var2.bU.a(this.h(), var16, var17)) {
            if (var14 != var16 && var15 != var17) {
                var18 = var2.bU.a(this.h(), var14, var17);
                var19 = var2.bU.a(this.h(), var16, var15);
                if (var18 && var19) {
                    var13 = true;
                    aG.setSite(var8, var9);
                    var12 = aG;
                }

                if (var12 == null && var18) {
                    var12 = class_1050.a(this.h(), var8, var9, var10, var11, var14, var17, false);
                }

                if (var12 == null && var19) {
                    var12 = class_1050.a(this.h(), var8, var9, var10, var11, var16, var15, false);
                }
            }

            if (var12 == null) {
                var12 = class_1050.a(this.h(), var8, var9, var10, var11, var16, var17, false);
            }

            if (var12 == null) {
                var13 = true;
                aG.setSite(var8, var9);
                var12 = aG;
            }
        }

        var18 = false;
        if (var12 != null) {
            var19 = false;
            boolean var20 = var2.bU.a(this.h(), var14, var15);
            if (var20 && !var2.bU.b(this.h(), var16, var17)) {
                var19 = true;
            }

            if (!var19) {
                var3 = var12.x * (float)var5.n;
                var4 = var12.y * (float)var5.o;
                var18 = true;
            } else {
                var13 = false;
            }
        }

        if (var18) {
            this.b += var1;
            this.a = 0;
        } else if (this.b != 0.0F && var1 > 0.0F) {
            ++this.a;
            if (this.a >= 3) {
                this.b = 0.0F;
            }
        }

        if (!var13) {
            int var21 = class_340.f(var3 * var6);
            int var22 = class_340.f(var4 * var7);
            this.xCord = var3;
            this.yCord = var4;
            if (var14 != var21 || var15 != var22) {
                this.c(true);
            }
        }

    }

    public strictfp void b(float var1, float var2) {
        class_484 var3 = GameEngine.getGameEngine().bL;
        float var4 = var3.r;
        float var5 = var3.s;
        int var6 = class_340.f(this.xCord * var4);
        int var7 = class_340.f(this.yCord * var5);
        int var8 = class_340.f(var1 * var4);
        int var9 = class_340.f(var2 * var5);
        this.xCord = var1;
        this.yCord = var2;
        if (var6 != var8 || var7 != var9) {
            this.c(true);
        }

    }

    public static strictfp void g(float var0) {
        GameEngine var1 = GameEngine.getGameEngine();
        var1.cd.a(class_324.j);
        int var2 = var1.by;
        class_692 var3 = aM;
        Unit[] var4 = Unit.bE.a();
        int var5 = Unit.bE.size();

        int var6;
        for(var6 = 0; var6 < var5; ++var6) {
            var4[var6].bR();
        }

        OrderableUnit var7;
        for(var6 = 0; var6 < var5; ++var6) {
            if (var4[var6] instanceof OrderableUnit) {
                var7 = (OrderableUnit)var4[var6];
                if ((var7.ay || var7.cb) && var7.I() && var7.aL <= var2) {
                    var7.cb = false;
                    var7.ay = true;
                    float var8;
                    if (var7.cK) {
                        var8 = var7.cj + 7.0F;
                        if (var7.aI > 9) {
                            var7.aL = var2 + 200 + var6 % 50;
                        } else {
                            var7.aL = var2 + 50 + var6 % 50;
                        }
                    } else {
                        var8 = var7.cj + 5.0F;
                        var7.aL = var2 + 250 + var6 % 50;
                    }

                    var7.aI = 0;
                    var3.clear();
                    var1.cc.b(var7.xCord, var7.yCord, var8, var3);
                    Unit[] var9 = var3.a();
                    int var10 = 0;

                    for(int var11 = var3.b; var10 < var11; ++var10) {
                        Unit var12 = var9[var10];
                        var7.a(var12, var0, true);
                    }

                    if (var7.aI > 9 && var7.bz > var2 - 400) {
                        var7.aL = var1.by + 5 + var6 % 5;
                        var7.cb = true;
                    }
                }
            }
        }

        var1.cd.b(class_324.j);
        var1.cd.a(class_324.k);

        for(var6 = 0; var6 < var5; ++var6) {
            if (var4[var6] instanceof OrderableUnit) {
                var7 = (OrderableUnit)var4[var6];
                if (var7.ay) {
                    byte var13 = var7.aI;
                    if (var13 > 0 && var7.I()) {
                        if (!var7.cb) {
                            var7.cb = true;
                        }

                        for(int var14 = 0; var14 < var13; ++var14) {
                            Unit var15 = var7.aJ[var14];
                            var7.a(var15, var0, false);
                        }
                    }
                }
            }
        }

        var1.cd.b(class_324.k);
    }

    private final strictfp void a(Unit var1, float var2, boolean var3) {
        if (var1 != this) {
            int var5 = this.bU;
            if (var5 != -1 && var5 == var1.bU) {
                if (this.bQ != var1 && var1.bQ != this) {
                    float var6 = this.xCord + this.bZ;
                    float var7 = this.yCord + this.ca;
                    float var8 = var1.xCord + var1.bZ;
                    float var9 = var1.yCord + var1.ca;
                    float var10 = class_340.a(var6, var7, var8, var9);
                    float var11 = this.cj + var1.cj;
                    float var12;
                    int var15;
                    int var16;
                    if (var3) {
                        var12 = var10;
                        if (var10 < var11 * var11) {
                            var12 = 0.0F;
                        }

                        if (var1 instanceof OrderableUnit) {
                            OrderableUnit var30 = (OrderableUnit)var1;
                            byte var32 = var30.aI;

                            for(var15 = 0; var15 < var32; ++var15) {
                                if (var30.aJ[var15] == this) {
                                    return;
                                }
                            }
                        }

                        if (this.aJ == null) {
                            this.aJ = new Unit[10];
                            this.aK = new float[10];
                        }

                        Unit[] var31 = this.aJ;
                        float[] var33 = this.aK;
                        var15 = -1;

                        for(var16 = 0; var16 < this.aI; ++var16) {
                            if (var12 < var33[var16]) {
                                var15 = var16;
                                break;
                            }
                        }

                        if (var15 == -1) {
                            if (this.aI >= var31.length) {
                                return;
                            }

                            var15 = this.aI;
                        }

                        if (this.aI < var31.length) {
                            ++this.aI;
                        }

                        for(var16 = this.aI - 1; var16 > var15; --var16) {
                            var31[var16] = var31[var16 - 1];
                        }

                        var31[var15] = var1;
                        var33[var15] = var12;
                    } else {
                        if (var10 < var11 * var11 && !var1.a(this, var2) && !this.a(var1, var2)) {
                            var12 = class_340.d(var6, var7, var8, var9);
                            float var13 = (float)Math.sqrt((double)var10);
                            float var14 = var11 - var13 + 0.001F;
                            if (var14 <= 0.0F) {
                                return;
                            }

                            var15 = this.s(var1);
                            var16 = var1.s(this);
                            int var17 = var15 > var16 ? var15 : var16;
                            float var18;
                            if (var17 != 0) {
                                var18 = var14 / (float)var17 * var2;
                                if (var18 > var14) {
                                    var18 = var14;
                                }

                                var14 = var18;
                            }

                            var14 *= 0.95F;
                            if (var14 > 1.0F) {
                                var14 *= 0.7F;
                            }

                            if (var14 > 3.0F) {
                                var14 = 3.0F + (var14 - 3.0F) * 0.7F;
                            }

                            if (var14 > 6.0F) {
                                var14 = 6.0F + (var14 - 6.0F) * 0.7F;
                            }

                            if (var14 > 10.0F) {
                                var14 = 10.0F + (var14 - 10.0F) * 0.7F;
                            }

                            var18 = 0.0F;
                            float var19 = this.mass();
                            float var20 = var1.mass();
                            OrderableUnit var21 = null;
                            if (var1 instanceof OrderableUnit) {
                                var21 = (OrderableUnit)var1;
                            }

                            float var23;
                            if (this.bX == var1.bX) {
                                boolean var22 = false;
                                var23 = 1.7F;
                                if (var21 != null) {
                                    if (this.W > 200.0F || var21.W > 200.0F) {
                                        var23 = 5.0F;
                                    }

                                    if (this.ad == var21) {
                                        var20 *= var23;
                                        var22 = true;
                                    }

                                    if (var21.ad == this) {
                                        var19 *= var23;
                                        var22 = true;
                                    }

                                    if (!var22) {
                                        if (this.ae && var21.ad != null) {
                                            var19 *= var23;
                                        } else if (var21.ae && this.ad != null) {
                                            var20 *= var23;
                                        } else if (this.c == 0.0F && var21.c != 0.0F) {
                                            var19 *= var23;
                                        } else if (var21.c == 0.0F && this.c != 0.0F) {
                                            var20 *= var23;
                                        }
                                    }
                                }
                            }

                            if (var1 instanceof class_106) {
                                var18 = var19 / (var19 + var20);
                            }

                            float var34 = 1.0F - var18;
                            var23 = class_340.k(var12);
                            float var24 = class_340.j(var12);
                            float var25;
                            if (var1 instanceof class_106) {
                                var25 = var14 * var18;
                                var1.bZ += var23 * var25;
                                var1.ca += var24 * var25;
                            }

                            var25 = var14 * var34;
                            this.bZ -= var23 * var25;
                            this.ca -= var24 * var25;
                            GameEngine var26 = GameEngine.getGameEngine();
                            int var27 = var26.tick;
                            this.Z = var1;
                            this.aa = var27;
                            if (var21 != null) {
                                var21.Z = this;
                                var21.aa = var27;
                                if (this.ac != 0 && this.ac == var21.ac) {
                                    class_1042 var29;
                                    if (this.ar() == null) {
                                        var29 = var21.ar();
                                        if (var29 != null && (var29.a == WaypointType.move || var29.a == WaypointType.attackMove)) {
                                            var21.ay();
                                        }
                                    }

                                    if (var21.ar() == null) {
                                        var29 = this.ar();
                                        if (var29 != null && (var29.a == WaypointType.move || var29.a == WaypointType.attackMove)) {
                                            this.ay();
                                        }
                                    }
                                }
                            }
                        }

                    }
                }
            }
        }
    }

    public strictfp int V() {
        return 1;
    }

    public strictfp void a(int var1) {
    }

    protected strictfp void W() {
        GameEngine var1 = GameEngine.getGameEngine();
        if (this.bX == var1.playerTeam) {
            var1.bS.i.b(this);
        }

    }

    public strictfp float b(float var1, float var2, float var3) {
        if (this.E()) {
            if (this.bI()) {
                return 0.0F;
            } else {
                float var8 = class_340.d(this.xCord, this.yCord, var2, var3);
                return this.c(var1, var8);
            }
        } else if (this.bl() < 1) {
            return 0.0F;
        } else {
            int var4 = this.aT();
            if (var4 == -1) {
                var4 = 0;
            }

            PointF var5 = this.G(var4);
            float var6 = class_340.d(var5.x, var5.y, var2, var3);
            class_1048 var7 = this.cL[var4];
            var7.a(70);
            return this.a(var1, var6, var4);
        }
    }

    public strictfp float c(float var1, float var2) {
        boolean var3 = false;
        boolean var4 = false;
        if (this.ci && this.bb()) {
            var3 = true;
            var4 = true;
        }

        return this.a(var1, var2, var3, var4);
    }

    public strictfp void h(float var1) {
        float var2 = class_340.c(this.cg, var1, 360.0F);
        if ((double)class_340.c(var2) > 0.01) {
            this.i(var2);
        }

    }

    public strictfp float a(float var1, float var2, boolean var3, boolean var4) {
        this.ch = var2;
        if (class_340.c(this.cg - var2) < 0.01F) {
            if (var3 && this.ci) {
                this.j(25);
                this.ci = false;
            }

            return 0.0F;
        } else {
            float var5 = class_340.c(this.cg, var2, 360.0F);
            if (var3) {
                if (var4 && class_340.c(var5) > 100.0F) {
                    var5 = class_340.c(this.cg, var2 + 180.0F, 360.0F);
                    if (!this.ci) {
                        this.j(25);
                        this.ci = true;
                    }
                } else if (this.ci) {
                    this.j(25);
                    this.ci = false;
                }
            }

            if (class_340.c(var5) < 0.01F) {
                return 0.0F;
            } else {
                if (this.az <= 0.0F) {
                    float var6 = this.B();
                    float var7;
                    float var8;
                    if (var6 <= 0.0F) {
                        var7 = var5 > 0.0F ? 1.0F : -1.0F;
                        var8 = var7 * this.turnSpeed() * var1;
                        if (class_340.c(var8) > class_340.c(var5)) {
                            var8 = var5;
                        }

                        this.i(var8);
                    } else {
                        var7 = var5 > 0.0F ? 1.0F : -1.0F;
                        var8 = class_340.c(this.ce) / var6;
                        if (class_340.c(var5) < var8) {
                            this.ce = class_340.a(this.ce, var7 * var6, var6 * var1);
                        } else {
                            this.ce = class_340.a(this.ce, var7 * this.turnSpeed(), var6 * var1);
                        }

                        float var9 = this.ce * var1;
                        if (class_340.c(var9) > class_340.c(var5)) {
                            this.ce = 0.0F;
                            var9 = var5;
                        }

                        this.i(var9);
                    }
                }

                return var5;
            }
        }
    }

    public strictfp void i(float var1) {
        this.cg += var1;
        if (this.cg > 180.0F) {
            this.cg -= 360.0F;
        }

        if (this.cg < -180.0F) {
            this.cg += 360.0F;
        }

        if (this.bm()) {
            int var2 = this.bl();

            for(int var3 = 0; var3 < var2; ++var3) {
                class_1048 var4 = this.cL[var3];
                var4.a += var1;
                if (var4.a > 180.0F) {
                    var4.a -= 360.0F;
                }

                if (var4.a < -180.0F) {
                    var4.a += 360.0F;
                }
            }
        }

    }

    public strictfp void j(float var1) {
        int var2 = this.bl();

        for(int var3 = 0; var3 < var2; ++var3) {
            class_1048 var4 = this.cL[var3];
            var4.a = var1 + this.B(var3);
        }

    }

    public strictfp void a(int var1, float var2) {
        class_1048 var3 = this.cL[var1];
        var3.a += var2;
    }

    public strictfp float a(float var1, float var2, int var3) {
        class_1048 var4 = this.cL[var3];
        float var5 = var4.a;
        float var6 = class_340.c(var5, var2, 360.0F);
        if (var6 == 0.0F) {
            return var6;
        } else {
            float var7 = this.w(var3);
            float var8;
            if (var7 <= 0.0F) {
                var8 = class_340.c(var4.a, var2, this.c(var3) * var1);
                this.a(var3, var8);
                var6 -= var8;
            } else {
                var8 = this.y(var3);
                float var9 = var6 > 0.0F ? 1.0F : -1.0F;
                float var10 = class_340.c(var4.c) / var8;
                boolean var11 = var6 > 0.0F == var4.c > 0.0F;
                if (class_340.c(var6) < var10 && var11) {
                    var4.c = class_340.a(var4.c, var9 * var8, var8 * var1);
                } else {
                    var4.c = class_340.a(var4.c, var9 * this.c(var3), var7 * var1);
                }

                float var12 = var4.c * var1;
                if (class_340.c(var12) > class_340.c(var6)) {
                    var4.c = 0.0F;
                    var12 = var6;
                }

                this.a(var3, var12);
                var6 -= var12;
            }

            return var6;
        }
    }

    public strictfp Unit X() {
        if (this.h) {
            class_1042 var1 = this.ar();
            if (var1 != null && (var1.a == WaypointType.repair || var1.a == WaypointType.reclaim) && var1.h != null && !var1.h.bV) {
                return var1.h;
            }
        }

        return null;
    }

    public strictfp boolean Y() {
        class_1042 var1 = this.ar();
        return var1 != null && var1.a == WaypointType.reclaim;
    }

    private strictfp void a(float var1, class_1042 var2, class_1044 var3) {
        if (var2.c == null) {
            this.ay();
            var2 = null;
        }

        if (var2 != null) {
            boolean var4 = true;
            if (var2.a == WaypointType.triggerActionWhenInRange) {
            }

            if (var4) {
                class_226 var5 = this.a((class_1059)var2.c);
                this.U();
                if (var5 == null) {
                    this.a("Failed to find action:" + var2.c.a());
                } else {
                    PointF var6 = new PointF(var2.e, var2.f);
                    this.a(var5, false, var6, var2.h);
                }

                this.ay();
                var2 = null;
            }
        }

    }

    private strictfp void b(float var1, class_1042 var2, class_1044 var3) {
        Unit var4 = var2.i();
        if (var4 != null) {
            this.R = var4;
            if (this.T > 5.0F) {
                this.T = 5.0F;
            }
        }

        this.ay();
        var2 = null;
    }

    private strictfp void c(float var1, class_1042 var2, class_1044 var3) {
        float var4 = var2.g();
        float var5 = var2.h();
        float var6 = class_340.a(this.xCord, this.yCord, var4, var5);
        boolean var7 = var2.a == WaypointType.guard || var2.a == WaypointType.follow;
        boolean var8 = var2.a == WaypointType.guard;
        Unit var9 = var2.h;
        if (var7) {
            if (var9 == null || var9.bV) {
                this.ay();
                var2 = null;
            }

            if (var2 != null && var9 != null && !var9.cg() && this.bX.c(var9.bX)) {
                this.ay();
                var2 = null;
            }
        }

        if (var2 != null) {
            boolean var10 = false;
            float var11 = this.cj;
            if (var7) {
                var11 += var9.cj;
            }

            if (var2.a == WaypointType.follow) {
                if (this.cK) {
                    var11 += 30.0F;
                } else {
                    var11 += 50.0F;
                }
            } else if (this.cK) {
                var11 += 80.0F;
            } else {
                var11 += 100.0F;
            }

            if (var6 > var11 * var11) {
                this.k = true;
                this.l = var4;
                this.m = var5;
                this.n = 2;
                if (this.s > 90.0F) {
                    this.s = 90.0F;
                }

                this.r = 18;
                if (this.ad != null && !this.ad.bT()) {
                    var3.d = false;
                }
            } else {
                this.w = 0;
            }

            var3.d = false;
            if (!var10 && this.R != null && !this.R.bV) {
                boolean var12 = false;
                if (this.b(this.R, false)) {
                    var12 = true;
                }

                if (var12) {
                    float var13 = class_340.a(this.xCord, this.yCord, this.R.xCord, this.R.yCord);
                    float var14 = this.o(this.R);
                    boolean var15 = false;
                    boolean var16 = false;
                    if (var13 < var14 * var14) {
                        var16 = true;
                    }

                    if (var16 && !this.aa()) {
                        var16 = false;
                    }

                    if (var6 < 22500.0F) {
                        this.w = 0;
                    }

                    if (!var16 && (this.w == 1 || var6 > 122500.0F)) {
                        var15 = true;
                        this.w = 1;
                    }

                    if (var6 > 302500.0F || this.w == 1 && var6 > 202500.0F) {
                        var15 = true;
                        this.w = 1;
                    }

                    if (!var15) {
                        var10 = true;
                        this.w = 0;
                        if (var16) {
                            this.k = false;
                        } else {
                            if (this.s > 90.0F) {
                                this.s = 90.0F;
                            }

                            this.k = true;
                            this.l = this.R.xCord;
                            this.m = this.R.yCord;
                            this.n = 0;
                            this.j = true;
                        }
                    }
                }
            }

            if (var8 && !var10) {
                Unit var17 = var9.q(2.0F);
                if (var17 != null && !this.b(var17, true)) {
                    var17 = null;
                }

                if (var17 == null && this.w != 1) {
                    var17 = this.q(2.0F);
                    if (var17 != null && !this.b(var17, true)) {
                        var17 = null;
                    }
                }

                if (var17 != null) {
                    var10 = true;
                    if (this.s > 90.0F) {
                        this.s = 90.0F;
                    }

                    this.k = true;
                    this.l = var17.xCord;
                    this.m = var17.yCord;
                    this.n = 0;
                    this.j = true;
                }
            }

            if (var8 && !var10 && this.a(var9) && (var9.health < var9.totalHealth || var9.cm < 1.0F) && this.a(var9)) {
                class_1042 var20 = this.ao();
                if (var20 != null) {
                    var20.b(var9);
                    var20.m = true;
                    var10 = true;
                    if (this.s > 20.0F) {
                        this.s = 20.0F;
                    }
                }
            }

            if (var8 && !var10 && this.ak() && var9 instanceof OrderableUnit) {
                OrderableUnit var21 = (OrderableUnit)var9;
                Unit var18 = var21.X();
                if (var18 != null && this.a(var18)) {
                    class_1042 var19 = this.ao();
                    if (var19 != null) {
                        var19.b(var18);
                        var19.m = true;
                        var10 = true;
                        if (this.s > 20.0F) {
                            this.s = 20.0F;
                        }
                    }
                }
            }
        }

    }

    private strictfp void d(float var1, class_1042 var2, class_1044 var3) {
        float var4 = var2.g();
        float var5 = var2.h();
        float var6 = class_340.a(this.xCord, this.yCord, var4, var5);
        if (var2.h == null || var2.h.bV) {
            this.ay();
            var2 = null;
        }

        if (var2 != null) {
            boolean var7 = false;
            float var8;
            if (var2.h.bI()) {
                if (var6 < 961.0F) {
                    this.Y += var1;
                }

                if (this.Y > 240.0F) {
                    var7 = true;
                }

                var8 = 21.0F;
                if (var2.h.cc().a()) {
                    var8 = 11.0F;
                }

                if (this.b > 0.0F) {
                    var8 = var2.h.cj + this.cj + 31.0F;
                }

                if (var6 < var8 * var8) {
                    var7 = true;
                }
            } else {
                var8 = var2.h.cj + this.cj + 5.0F;
                if (var6 < var8 * var8) {
                    var7 = true;
                }
            }

            if (!var7) {
                this.k = true;
                this.l = var4;
                this.m = var5;
                this.n = 0;
                if (var2.h.bI()) {
                    Rect var10 = var2.h.cc();
                    int var9 = class_340.c(var10.c() / 2, var10.b() / 2);
                    this.n = var9 + 1;
                }

                if (this.s > 90.0F) {
                    this.s = 90.0F;
                }

                this.r = 18;
                if (var6 < 48400.0F) {
                    var3.d = false;
                    if (this.s > 0.0F && this.aE() == null) {
                        this.j = true;
                    }
                }

                if (this.ad != null && !this.ad.bT()) {
                    var3.d = false;
                }
            }

            if (var7) {
                Unit var11 = var2.h;
                this.a((GameEvent) GameEvent.touchTargetSuccess, (Unit)var11);
                this.ay();
            }
        }

    }

    private strictfp void e(float var1, class_1042 var2, class_1044 var3) {
        float var4 = var2.g();
        float var5 = var2.h();
        float var6 = class_340.a(this.xCord, this.yCord, var4, var5);
        if (var2.h == null || var2.h.bV || !var2.h.bT()) {
            this.ay();
            var2 = null;
        }

        if (var2 != null && !this.d(var2.h, false)) {
            this.ay();
        }

        if (var2 != null) {
            this.bQ = var2.h;
            float var7 = this.cs();
            if (var6 > var7 * var7) {
                this.k = true;
                this.l = var4;
                this.m = var5;
                if (this.s > 90.0F) {
                    this.s = 90.0F;
                }

                this.r = 18;
                if (var6 < 72900.0F) {
                    var3.d = false;
                    if (this.s > 0.0F && this.aU == null) {
                        this.j = true;
                    }
                }

                if (this.ad != null && !this.ad.bT()) {
                    var3.d = false;
                }
            } else {
                this.e(var2.h, false);
                this.ay();
            }
        }

    }

    private strictfp void a(float var1, class_1042 var2, class_1044 var3, boolean var4) {
        float var5 = var2.g();
        float var6 = var2.h();
        float var7 = class_340.a(this.xCord, this.yCord, var5, var6);
        GameEngine var8 = GameEngine.getGameEngine();
        if (!this.aR()) {
            boolean var9 = false;
            class_826 var10 = this.dn();
            if (var10 != null && var10.H) {
                this.bx();
                var9 = true;
            }

            if (!var9) {
                this.ax();
                var2 = null;
            }
        }

        float var11 = 7.0F;
        if (var7 < 1681.0F) {
            this.Y += var1;
        }

        if (this.Y > 240.0F) {
            var11 = 16.0F;
        }

        if (this.Y > 340.0F) {
            var11 = 36.0F;
        }

        if (var2 != null && var2.a == WaypointType.patrol) {
            if (this.av() != 1) {
                var11 = 20.0F;
                float var12 = 30.0F;
                if (!var4 || this.aa == var8.tick || this.aa == var8.tick - 1) {
                    var12 = 70.0F;
                }

                if (var7 < var12 * var12) {
                    this.d(var2);
                    this.ax();
                    var2 = null;
                }
            } else {
                var11 = 30.0F;
                if (!var4 || this.aa == var8.tick || this.aa == var8.tick - 1) {
                    var11 = 80.0F;
                }
            }
        }

        if (var2 != null) {
            if (var7 < var11 * var11) {
                if (var2.a == WaypointType.patrol) {
                    if (this.av() == 1) {
                    }
                } else if (var2.a == WaypointType.attackMove) {
                    boolean var13 = false;
                    if (this.R != null && !this.R.bV && this.a(this.R, false)) {
                        var13 = true;
                    }

                    if (!var13) {
                        this.ax();
                        var2 = null;
                    }
                } else {
                    this.ax();
                    var2 = null;
                }
            } else {
                this.k = true;
                this.l = var5;
                this.m = var6;
                this.n = 0;
                if (var2.a == WaypointType.patrol) {
                    this.t = true;
                    this.aB();
                }
            }
        }

        if (var2 != null) {
            if (var2.a == WaypointType.attackMove || var2.a == WaypointType.patrol) {
                if (this.R != null && !this.R.bV && this.a(this.R, false)) {
                    this.a(var1, this.R, var3, true);
                }

                if (this.ad != null && this.ad.R != null) {
                    var3.d = false;
                }
            }

            if (var2.a == WaypointType.patrol) {
                if (this.R == null) {
                    Unit var14 = this.q(3.0F);
                    if (var14 != null && this.b(var14, true)) {
                        if (this.s > 90.0F) {
                            this.s = 90.0F;
                        }

                        this.k = true;
                        this.l = var14.xCord;
                        this.m = var14.yCord;
                        this.n = 0;
                        this.j = true;
                    }
                }

                if (this.ak() && (long)(var8.tick % 10) == this.id % 10L) {
                    class_1042 var15 = RepairBay.a(this, var1, 150.0F, true);
                    if (var15 != null) {
                        var15.m = false;
                        var15.k = 200.0F;
                        this.k = false;
                        this.aH();
                    }
                }
            }
        }

    }

    private strictfp void f(float var1, class_1042 var2, class_1044 var3) {
        float var4 = var2.g();
        float var5 = var2.h();
        float var6 = class_340.a(this.xCord, this.yCord, var4, var5);
        GameEngine var7 = GameEngine.getGameEngine();
        class_31 var8 = var2.b;
        if (var8 == null) {
            this.a("activeBuildingType==null, removing waypoint");
            this.ay();
            var2 = null;
        }

        if (var2 != null) {
            float var9 = this.f(var8);
            boolean var10 = true;
            boolean var11 = false;
            if (var9 <= 30.0F) {
                var10 = true;
            }

            if (var9 <= 25.0F && this.zCord > 4.0F) {
                var11 = true;
            }

            if (this.ad != null) {
                class_1042 var12 = this.ad.ar();
                if (var12 == null || var12.a != WaypointType.build) {
                    var3.d = false;
                }

                if (var12 != null && !var2.b(var12)) {
                    var3.d = false;
                }
            }

            boolean var16 = false;
            if (!class_694.a(this.Q, 200)) {
                var16 = true;
            }

            boolean var13;
            if (var9 > 800000.0F) {
                var13 = true;
            } else {
                var13 = var6 <= var9 * var9;
            }

            if (var13 && !var11) {
                if (!var16 && (!this.b_() || !(class_340.c(this.b(var1, var4, var5)) > 30.0F))) {
                    class_810 var14 = this.a(var2, var2.b, var2.d, var2.e, var2.f);
                    Unit var15 = null;
                    if (var14.a != null) {
                        var15 = var14.a;
                    } else if (var14.b != null) {
                        var15 = var14.b;
                    }

                    if (var15 != null) {
                        var14.d.a((Unit)this, (Unit)var15);
                        if (this.a(var15)) {
                            if (this.b((Unit)var15) > 10000.0F) {
                                var15.r(1.0F);
                                this.ax();
                            } else {
                                var2.e();
                                var2.a = WaypointType.repair;
                                var2.h = var15;
                                this.aH();
                            }
                        } else {
                            this.ay();
                        }

                        this.Q = -9999;
                    } else {
                        if (var2.b == null) {
                            GameEngine.log("active.build==null");
                        }

                        if (!var14.c) {
                            this.ay();
                        }
                    }
                }
            } else if (!this.aR()) {
                this.ay();
                var2 = null;
            } else {
                this.k = true;
                this.l = var4;
                this.m = var5;
                if (var9 > 58.0F) {
                    this.n = (int)((var9 - 41.0F) / ((float)var7.bL.n * 1.414F));
                }

                if (this.s > 90.0F) {
                    this.s = 90.0F;
                }

                if (this.q > 3) {
                    this.ay();
                    var2 = null;
                    return;
                }
            }
        }

    }

    private strictfp void a(float var1, Unit var2, class_1044 var3, boolean var4) {
        AttackMovementType var5 = this.be();
        float var6 = var2.xCord;
        float var7 = var2.yCord;
        float var8 = class_340.a(this.xCord, this.yCord, var6, var7);
        float var9;
        if (this.ad != null) {
            if (var8 < 490000.0F) {
                if (var8 < 48400.0F) {
                    var3.d = false;
                }

                var9 = class_340.a(this.ad.xCord, this.ad.yCord, var6, var7);
                if (var9 < 48400.0F) {
                    var3.d = false;
                }

                if (var9 < 270400.0F && this.aV()) {
                    var3.d = false;
                }
            }

            if (this.ad.R == var2) {
                var3.d = false;
            }

            if (var3.d) {
                this.ai = 0.0F;
            } else {
                this.ai += var1;
            }
        } else {
            this.ai = 500.0F;
        }

        var9 = this.o(var2);
        boolean var10 = true;
        if (var8 < var9 * var9) {
            if (this.R != var2) {
                if (class_1050.a(this, var2)) {
                    this.R = var2;
                    this.S = 10.0F;
                    this.M(-1);
                }
            } else {
                this.S = 10.0F;
            }

            float var11 = var9;
            if (!this.E()) {
                var11 = var9 - 1.0F;
                if (this.aV()) {
                    var11 -= 2.0F;
                }

                if (this.e(0) > 5.0F) {
                    var11 -= 3.0F;
                }
            }

            if (var8 < var11 * var11 && this.be() != AttackMovementType.BOMBER) {
                if (var2 == null) {
                    var10 = false;
                } else if (this.i(var2)) {
                    var10 = false;
                    if (var4) {
                        this.k = false;
                    }
                } else if (!this.j(var2)) {
                    var10 = false;
                }
            }
        }

        if (var10) {
            this.k = true;
            this.l = var6;
            this.m = var7;
            this.n = 0;
            if (var5 == AttackMovementType.BOMBER) {
                this.a(var8, var6, var7);
            }

            this.n = this.q(var2);
            if (this.s > 90.0F) {
                this.s = 90.0F;
            }

            if (var8 < 810000.0F) {
                if (this.ct() || this.aV()) {
                    this.j = true;
                }

                if (!var3.d && this.ai < 120.0F) {
                    this.s = 0.1F;
                    this.j = true;
                }
            }
        }

    }

    private strictfp void g(float var1, class_1042 var2, class_1044 var3) {
        GameEngine var4 = GameEngine.getGameEngine();
        AttackMovementType var5 = this.be();
        if (var5 == AttackMovementType.BOMBER) {
            if (var2 != null && (var2.h == null || var2.h.bV || var2.h.bX == this.bX) && !this.as) {
                if (this.R != null && this.R.bV) {
                    this.R = null;
                }

                float var6 = this.b(true) + 200.0F;
                this.a(var4, var1, var6);
                if (this.R != null) {
                    var2.h = this.R;
                    this.aB();
                    this.aH();
                } else {
                    this.as = true;
                    this.ar = true;
                }
            }

            if (var2 != null && (var2.h == null || var2.h.bV || var2.h.bX == this.bX)) {
                if (var2.h == null) {
                    this.ay();
                    var2 = null;
                } else if (!this.ar) {
                    this.ay();
                    var2 = null;
                }
            }
        } else if (var2.h == null || var2.h.bV || var2.h.bX == this.bX) {
            boolean var8 = true;
            if (this.av() > 1) {
                var8 = false;
            }

            var2.h = null;
            if (var8) {
                if (this.R != null && this.R.bV) {
                    this.R = null;
                }

                float var7 = this.b(true);
                this.a(var4, var1, var7);
                if (this.R != null) {
                    var2.h = this.R;
                    this.aB();
                    this.aH();
                }
            }

            if (var2.h == null) {
                this.ay();
                var2 = null;
            }
        }

        if (var2 != null && var2.h != null && !var2.h.bV && !var2.h.cg() && this.bX.c(var2.h.bX) && !class_1050.b(this, var2.h)) {
            this.ay();
            var2 = null;
        } else {
            if (var2 != null && !this.aR() && !this.l()) {
                this.ay();
                var2 = null;
            }

            if (var2 != null) {
                this.a(var1, var2.h, var3, false);
            }

        }
    }

    private strictfp void h(float var1, class_1042 var2, class_1044 var3) {
        float var4 = var2.g();
        float var5 = var2.h();
        float var6 = class_340.a(this.xCord, this.yCord, var4, var5);
        if (var2.h == null || var2.h.bV) {
            this.ay();
            var2 = null;
        }

        if (var2 != null && !var2.h.d(this, false)) {
            this.ay();
        }

        if (var2 != null) {
            Unit var7 = var2.h;
            this.bQ = var7;
            boolean var8 = false;
            float var9;
            if (var7.bI()) {
                var9 = var7.cs();
                float var10 = var9 + 10.0F;
                if (var6 < var10 * var10) {
                    this.Y += var1;
                }

                if (this.Y > 240.0F) {
                    var8 = true;
                }

                float var11 = 21.0F;
                if (var7.cc().a()) {
                    var11 = 11.0F;
                }

                if (this.b > 0.0F) {
                    var11 = var7.cj + 31.0F;
                }

                if (var6 < var11 * var11) {
                    var8 = true;
                }
            } else {
                var9 = var7.cs();
                if (var6 < var9 * var9) {
                    var8 = true;
                }
            }

            if (!var8) {
                this.k = true;
                this.l = var4;
                this.m = var5;
                if (this.s > 90.0F) {
                    this.s = 90.0F;
                }

                this.r = 18;
                if (var6 < 48400.0F) {
                    var3.d = false;
                    if (this.s > 0.0F && this.aU == null) {
                        this.j = true;
                    }
                }

                if (this.ad != null && !this.ad.bT()) {
                    var3.d = false;
                }
            }

            if (var8) {
                Unit var12 = var2.h;
                var12.e(this, false);
                this.ay();
            }
        }

    }

    public strictfp float a_(Unit var1) {
        float var2 = var1.r().D();
        if (var1.V() == 2) {
            var2 *= 0.5F;
        }

        if (var1.V() == 3) {
            var2 *= 0.25F;
        }

        var2 *= this.b((Unit)var1);
        return var2;
    }

    public strictfp float f(Unit var1) {
        float var2 = 5.1F;
        return 0.001F * var2;
    }

    public strictfp class_447 g(Unit var1) {
        return var1.by != null ? var1.by : var1.r().B();
    }

    private strictfp void i(float var1, class_1042 var2, class_1044 var3) {
        GameEngine var4 = GameEngine.getGameEngine();
        boolean var5 = false;
        boolean var6 = false;
        if (var2 != null) {
            float var7 = var2.g();
            float var8 = var2.h();
            float var9 = class_340.a(this.xCord, this.yCord, var7, var8);
            if (var2 != null && var2.a == WaypointType.reclaim && var2.h != null && var2.h.g() > 0.0F) {
                var6 = true;
            }

            if (var2 != null && (var2.h == null || var2.h.bV || var2.h.cN != null)) {
                if (var6) {
                    var5 = true;
                } else {
                    this.ax();
                    var2 = null;
                }
            }

            boolean var10;
            if (var2 != null && !var5 && var6 && var2.h != null) {
                var10 = true;
                if (this.i < var4.by - 100) {
                    var10 = false;
                }

                if (!this.g(var2.h, var10)) {
                    var5 = true;
                }

                if (!var5) {
                    this.i = var4.by;
                }
            }

            if (var2 != null && var5) {
                class_588 var30 = null;
                if (var2.h != null) {
                    var30 = var2.h.cR();
                }

                int var11 = this.cS();
                Unit var12 = a(this, var2.h.xCord, var2.h.yCord, (float)var11, var30);
                if (var12 != null) {
                    var2.h = var12;
                    var7 = var2.g();
                    var8 = var2.h();
                    var9 = class_340.a(this.xCord, this.yCord, var7, var8);
                    this.aB();
                } else {
                    this.ax();
                    var2 = null;
                }
            }

            if (var2 != null) {
                if (var2.a == WaypointType.repair) {
                    if (!this.a(var2.h)) {
                        this.ay();
                        var2 = null;
                    }
                } else if (!var6 && !this.l(var2.h)) {
                    this.ay();
                    var2 = null;
                }
            }

            if (var2 != null && var2.a == WaypointType.repair && var2.h != null && var2.h.health >= var2.h.totalHealth && var2.h.cm >= 1.0F) {
                this.ax();
                var2 = null;
            }

            if (var2 != null && var2.h == this) {
                this.ay();
                var2 = null;
            }

            if (var2 != null && var2 != null && var2.h != null && var2.h.g() != 0.0F) {
                var10 = false;
                if (var2.a == WaypointType.repair) {
                    var10 = true;
                }

                if (var10) {
                    this.ay();
                    var2 = null;
                }
            }

            if (var2 != null && var2.a == WaypointType.reclaim && var2.h.bX != this.bX && var2.h.g() == 0.0F) {
                var10 = true;
                if (var4.P() && this.bX.d(var2.h.bX)) {
                    var10 = false;
                }

                if (var10) {
                    this.ay();
                    var2 = null;
                }
            }

            if (var2 != null) {
                boolean var31;
                int var34;
                if (var2.a == WaypointType.reclaim) {
                    var34 = this.v(var2.h);
                    var31 = this.w(var2.h);
                } else {
                    var34 = this.u(var2.h);
                    var31 = this.x(var2.h);
                }

                float var32;
                if (this.ad != null) {
                    var32 = class_340.a(this.ad.xCord, this.ad.yCord, var7, var8);
                    int var13 = var34 + 80;
                    if (var32 < (float)(var13 * var13)) {
                        var3.d = false;
                    }

                    class_1042 var14 = this.ad.ar();
                    if (var14 == null) {
                        var3.d = false;
                    }

                    if (var14 != null && !var2.b(var14)) {
                        var3.d = false;
                    }
                }

                var32 = (float)var34;
                if (this.h) {
                    var32 += 5.0F;
                }

                boolean var33 = true;
                if (var34 <= 30) {
                    var33 = true;
                }

                float var15;
                if (var9 > var32 * var32) {
                    if (this.aR() && var2.k != 0.0F) {
                        boolean var35 = false;
                        if (var2.k >= 0.0F) {
                            var15 = (float)class_340.a((int)var9) - var32;
                            if (var2.k < var15) {
                                var35 = true;
                            }
                        }

                        if (var35) {
                            this.ay();
                        } else {
                            this.k = true;
                            this.l = var7;
                            this.m = var8;
                            if (var34 > 58) {
                                this.n = (int)(((float)var34 - 41.0F) / ((float)var4.bL.n * 1.414F));
                            } else {
                                this.n = 0;
                            }

                            if (var34 < 30 || var31) {
                                if (var9 < 841.0F) {
                                    this.j = true;
                                }

                                var15 = (float)(var34 + 14);
                                if (var9 < var15 * var15 && this.s > 0.0F && this.aU == null) {
                                    this.j = true;
                                }
                            }

                            this.r = this.n;
                            if (this.s > 90.0F) {
                                this.s = 90.0F;
                            }
                        }
                    } else {
                        this.ay();
                    }
                } else {
                    int var36 = this.aT();
                    if (var36 == -1) {
                        var36 = 0;
                    }

                    var15 = 0.0F;
                    if (this.b_()) {
                        var15 = this.b(var1, var7, var8);
                    }

                    boolean var16 = false;
                    if (class_340.c(var15) < 30.0F || !this.b_()) {
                        this.h = true;
                        var3.a = true;
                        class_1048 var17 = this.cL[var36];
                        if (var17.f < this.e(var36)) {
                            var17.f += var1;
                        } else {
                            var17.f = this.e(var36);
                            var16 = true;
                        }
                    }

                    if (var16) {
                        Unit var37 = var2.h;
                        boolean var21;
                        class_447 var22;
                        if (var2.a != WaypointType.reclaim) {
                            if (var37.cm < 1.0F) {
                                this.bC();
                                float var18 = this.a_(var37);
                                float var19 = var18 * var1;
                                boolean var20 = false;
                                var21 = false;
                                var22 = this.g(var37);
                                if (var22 != null) {
                                    if (var37.cm + var19 > 1.0F) {
                                        var19 = 1.0F - var37.cm;
                                        var20 = true;
                                    }

                                    double var23 = (double)(var37.cm + var19 - var37.cn);
                                    double var25 = 0.0;
                                    if (var20) {
                                        var25 = (double)(1.0F - var37.cn);
                                    } else {
                                        double var27 = 0.0010000000474974513;
                                        if (var23 >= var27) {
                                            int var29 = (int)(var23 / var27);
                                            var25 = (double)var29 * var27;
                                        }
                                    }

                                    boolean var45 = false;
                                    if (var25 > 0.0 && this.bX.am.a(var22)) {
                                        var45 = true;
                                    }

                                    if (var45 || !(var25 <= 0.0) && !var22.c(this, var25)) {
                                        if (!var45) {
                                            this.bX.am.a((class_447)var22, this, var25);
                                        }

                                        var19 = 0.0F;
                                        var20 = false;
                                        var21 = true;
                                    } else {
                                        var37.cn = (float)((double)var37.cn + var25);
                                    }
                                }

                                if (!var21) {
                                    this.a(var37, var1, var36);
                                    float var41 = var37.cm + var19;
                                    if (var20) {
                                        var41 = 1.0F;
                                    }

                                    var37.r(var41);
                                    if (var41 >= 1.0F && (double)var18 < 0.3 && var37.bX == var4.playerTeam) {
                                        var4.bS.i.a(var37);
                                    }

                                    this.aO = false;
                                } else {
                                    this.aO = true;
                                }
                            } else {
                                this.a(var37, var1, var36);
                                var37.health += this.c((Unit)var37) * var1;
                                if (var37.health > var37.totalHealth) {
                                    var37.health = var37.totalHealth;
                                    this.ay();
                                }

                                this.aO = false;
                            }
                        } else {
                            this.b(var37, var1, var36);
                            this.aO = false;
                            this.bC();
                            boolean var38 = false;
                            boolean var39 = this.y(var37);
                            float var40 = this.z(var37);
                            var21 = var2.h.g() > 0.0F;
                            var22 = this.g(var37);
                            if (!var21 && var22 != null) {
                            }

                            boolean var42 = false;
                            if (!var21 && this.V < 100.0F && !var21) {
                                if ((double)var37.cm < 0.5) {
                                    if (var22 == null) {
                                        var42 = true;
                                    }
                                } else if ((double)(var37.health / var37.totalHealth) < 0.5) {
                                    var42 = true;
                                }
                            }

                            if (!var42) {
                                float var24;
                                if (var37.cm < 1.0F) {
                                    var24 = this.f(var37) * var1;
                                    if (var24 >= var37.cm) {
                                        var24 = var37.cm;
                                        var37.cm = 0.0F;
                                    } else {
                                        var37.cm -= var24;
                                    }

                                    var37.cn = var37.cm;
                                    if (var22 != null) {
                                        var22.a(this, (double)var24, true);
                                    }

                                    if (var37.cm <= 0.0F) {
                                        var38 = true;
                                    }
                                } else {
                                    var24 = var40 * var1;
                                    if (var24 >= var37.health) {
                                        var24 = var37.health;
                                        var37.health = -1.0F;
                                    } else {
                                        var37.health -= var24;
                                    }

                                    var37.dp = 1000.0F;
                                    if (var39) {
                                        float var44 = var24 / var37.totalHealth;
                                        class_447 var26 = var37.cM();
                                        class_447 var46 = var37.cN();
                                        if (var46 != null) {
                                            var26 = var46;
                                        }

                                        if (!var21 && var22 != null) {
                                        }

                                        if (var26.a() > 0) {
                                            this.ab += var44 * (float)var26.a();
                                            if (this.ab > 1.0F) {
                                                PlayerData var10000 = this.bX;
                                                var10000.credits += (double)((int)this.ab);
                                                this.ab -= (float)((int)this.ab);
                                            }

                                            var26.a(this, (double)var44, false);
                                        } else {
                                            var26.a(this, (double)var44, true);
                                        }
                                    }

                                    if (var37.health <= 0.0F) {
                                        var38 = true;
                                    }
                                }
                            }

                            if (var38 && !var37.bV) {
                                if (!var39) {
                                    class_447 var43 = var37.cN();
                                    if (var43 != null) {
                                        GameEngine.log("refund: " + var43.a(false, true, 10, true));
                                        var43.a(this, 1.0, true);
                                    } else {
                                        var43 = var37.cM();
                                        if (var37.bx != null) {
                                            var43 = var37.bx;
                                            GameEngine.log("refund==null overridePriceBuildCost: " + var43.a(false, true, 10, true));
                                        }

                                        var43.a(this, 0.800000011920929, true);
                                        if (var37.cm >= 1.0F && var22 != null) {
                                            var22.a(this, 0.800000011920929, true);
                                        }
                                    }
                                }

                                var37.bV = true;
                                var37.bW = (long)var4.by;
                                var37.ci();
                                if (var37 instanceof OrderableUnit && var37.bI()) {
                                    var4.bU.a((OrderableUnit)var37);
                                }
                            }
                        }
                    }
                }
            }

        }
    }

    public strictfp void k(float var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        if (this.bQ != null) {
            this.bQ = null;
        }

        if (this.bR != null) {
            this.bS = class_340.a(this.bS, var1);
            this.bQ = this.bR;
            if (this.bS == 0.0F) {
                this.bR = null;
            }
        }

        if (this.s != 0.0F) {
            this.s = class_340.a(this.s, var1);
        }

        if (this.cf != 0.0F) {
            this.c = class_340.a(this.c, var1);
        }

        class_1042 var3 = this.ar();
        this.j = false;
        boolean var4 = this.k;
        this.k = false;
        this.t = false;
        this.r = 150;
        if (var3 != null && var3.l > 0.0F && var3.l < this.V) {
            this.ax();
            var3 = null;
        }

        class_1044 var5 = aP;
        var5.a();
        if (var3 != null) {
            this.V += var1;
            WaypointType var6 = var3.a;
            if (var6 != WaypointType.move && var6 != WaypointType.attackMove && var6 != WaypointType.patrol) {
                if (var6 == WaypointType.attack) {
                    this.g(var1, var3, var5);
                } else if (var6 == WaypointType.build) {
                    this.f(var1, var3, var5);
                } else if (var6 != WaypointType.repair && var6 != WaypointType.reclaim) {
                    if (var6 == WaypointType.loadInto) {
                        this.h(var1, var3, var5);
                    } else if (var6 == WaypointType.loadUp) {
                        this.e(var1, var3, var5);
                    } else if (var6 == WaypointType.touchTarget) {
                        this.d(var1, var3, var5);
                    } else if (var6 != WaypointType.guard && var6 != WaypointType.guardAt && var6 != WaypointType.follow) {
                        if (var6 != WaypointType.triggerAction && var6 != WaypointType.triggerActionWhenInRange) {
                            if (var6 == WaypointType.setPassiveTarget) {
                                this.b(var1, var3, var5);
                            }
                        } else {
                            this.a(var1, var3, var5);
                        }
                    } else {
                        this.c(var1, var3, var5);
                    }
                } else {
                    this.i(var1, var3, var5);
                }
            } else {
                this.a(var1, var3, var5, var4);
            }

            if (var3 != this.ar()) {
                var3 = null;
            }
        }

        this.h = var5.a;
        if (var3 != null && var3.m && this.f > 1) {
            boolean var8 = true;
            class_1042 var7 = this.k(1);
            if (var7 != null && (var7.a == WaypointType.guard || var7.a == WaypointType.patrol)) {
                var8 = false;
            }

            if (var8) {
                this.ay();
                var3 = null;
            }
        }

        if (var3 == null) {
            this.k = false;
        }

        if (this.k) {
            class_826 var9 = this.dn();
            if (var9 != null && var9.H) {
                this.bx();
            }
        } else if (this.q != 0) {
            this.q = 0;
        }

        this.b(var2, var1);
        this.a(var2, var1, var3, var5);
    }

    private strictfp void a(float var1, float var2, float var3) {
        if (this.aq < -900.0F) {
            float var4 = class_340.d(this.xCord, this.yCord, var2, var3);
            this.aq = var4;
        }

        if (var1 < 10000.0F && this.bX()) {
            this.ar = true;
        }

        if (this.ar) {
            if (!((double)this.cB < (double)this.bd() * 0.6) && (!(var1 < 40000.0F) || !(this.cB < this.bd()))) {
                this.ar = false;
                this.aq = -999.0F;
                this.aH();
            } else {
                this.l += class_340.k(this.aq + 180.0F) * 600.0F;
                this.m += class_340.j(this.aq + 180.0F) * 600.0F;
            }
        }

    }

    private strictfp void a(float var1, class_1045 var2, class_1044 var3, class_1042 var4) {
        GameEngine var5 = GameEngine.getGameEngine();
        OrderableUnit var6 = this.ad;
        float var7 = var6.xCord + this.ak;
        float var8 = var6.yCord + this.al;
        boolean var9 = false;
        int var10 = var5.by - var6.an;
        float var11 = class_340.a(this.xCord, this.yCord, var7, var8);
        if (var10 > 300 || this.b > 1.0F) {
            this.d += var1;
        }

        boolean var12 = false;
        if (this.d > 300.0F) {
            var12 = true;
        }

        if (var10 > 300 && var11 > 250000.0F) {
            var12 = true;
        }

        if (this.b > 1.0F) {
            if (this.c != 0.0F) {
                var12 = true;
            }

            if (this.d > 10.0F) {
                var12 = true;
            }
        }

        if (var12) {
            this.c = 90.0F;
        }

        class_1045 var13;
        float var15;
        float var16;
        float var17;
        float var18;
        boolean var31;
        if (this.c == 0.0F) {
            this.aH();
            var3.e = var7;
            var3.f = var8;
            var13 = null;
            if (var10 < 3000 && var13 == null && var6.v > 2 && var6.v - var6.aw <= 2) {
                var13 = var6.o(2);
            }

            class_1045 var14;
            if (var10 < 1500 && var13 == null && var6.v > 0 && var6.aw + 0 >= var6.v) {
                var14 = var6.o(0);
                var13 = aW;
                var15 = class_340.d(var6.xCord, var6.yCord, var14.a, var14.b);
                var16 = 80.0F;
                if (var10 > 300) {
                    var17 = 0.06666667F;
                    var16 -= (float)(var10 - 300) * 0.06666667F;
                }

                var13.a = var6.xCord + class_340.k(var15) * var16;
                var13.b = var6.yCord + class_340.j(var15) * var16;
            }

            float var19;
            if (var13 != null) {
                var3.c = true;
                var3.e = var13.a + this.ak;
                var3.f = var13.b + this.al;
            } else if (var6.v >= 2 && var6.aw >= 1) {
                class_1045 var24;
                if (var6.aw >= 2) {
                    var14 = var6.o(0);
                    var24 = var6.o(1);
                } else {
                    var14 = var6.o(0);
                    var24 = var6.o(0);
                }

                if (var14 != null && var24 != null) {
                    var16 = (float)class_340.c(var6.xCord, var6.yCord, var14.a, var14.b);
                    var17 = 1.0F - (var16 - 15.0F) * 0.05F;
                    if (var17 > 2.0F) {
                        var17 = 2.0F;
                    }

                    if (var17 < 0.0F) {
                        var17 = 0.0F;
                    }

                    float var21;
                    if (var17 > 1.0F) {
                        if (var6.aw >= 3) {
                            class_1045 var20 = var6.o(2);
                            var18 = var24.a - var14.a;
                            var19 = var24.b - var14.b;
                            var21 = var20.a - var24.a;
                            float var22 = var20.b - var24.b;
                            var18 += var21 * (var17 - 1.0F);
                            var19 += var22 * (var17 - 1.0F);
                        } else {
                            var18 = var24.a - var14.a;
                            var19 = var24.b - var14.b;
                        }
                    } else {
                        float var30 = var24.a - var14.a;
                        var21 = var24.b - var14.b;
                        var18 = var30 * var17;
                        var19 = var21 * var17;
                    }

                    var7 = var14.a + this.ak + var18;
                    var8 = var14.b + this.al + var19;
                    var3.e = var7;
                    var3.f = var8;
                }
            }

            float var23 = 45.0F;
            if (this.b <= 1.0F) {
                var23 = 60.0F;
            } else if (var10 < 500 && this.b <= 1.0F) {
                var23 = 110.0F;
            }

            if (var11 < var23 * var23) {
                this.d = 0.0F;
            }

            boolean var25 = false;
            class_1042 var27 = var6.ar();
            boolean var28 = false;
            if (var27 != null && var4 != null) {
            }

            boolean var29;
            if (var27 == null || var28) {
                this.e += var1;
                var29 = false;
                if (var4 != null && (var4.a == WaypointType.move || var4.a == WaypointType.attackMove || var4.a == WaypointType.patrol)) {
                    var29 = true;
                }

                if (var29 && this.e > 600.0F) {
                    var19 = 260.0F;
                } else if (var29 && this.e > 360.0F) {
                    var19 = 140.0F;
                } else if (var29 && this.e > 180.0F) {
                    var19 = 70.0F;
                } else if (var29 && this.e > 120.0F) {
                    var19 = 50.0F;
                } else {
                    var19 = 16.0F;
                }

                if (var11 < var19 * var19) {
                    var25 = true;
                }

                if (var9) {
                    var25 = true;
                }
            }

            if (var25) {
                var29 = false;
                if (var27 == null) {
                    var29 = true;
                }

                if (var28) {
                    var29 = true;
                }

                if (var29) {
                    var19 = this.c(var1, this.am);
                    if (class_340.c(var19) < 3.0F && var4 != null && (var4.a == WaypointType.move || var4.a == WaypointType.attackMove)) {
                        this.ay();
                        if (var6 != null) {
                            var31 = false;
                            class_1042 var32 = this.ar();
                            class_1042 var33 = var6.ar();
                            if (var32 != null && var33 != null && var32.b(var33)) {
                                var31 = true;
                            }

                            if (!var31) {
                                this.a((OrderableUnit)null);
                            }
                        }
                    }
                }
            } else if (!var9) {
                var3.b = true;
            }
        } else {
            var13 = null;
            byte var26 = 8;
            if (var13 == null && var6.v > 2 && var26 < var6.aw) {
                var13 = var6.o(var26);
            }

            if (var13 == null) {
                var13 = aW;
                var13.a = var6.xCord;
                var13.b = var6.yCord;
            }

            var15 = class_340.a(this.xCord, this.yCord, var13.a, var13.b);
            var16 = this.cj + var6.cj + 15.0F;
            var17 = this.cj + var6.cj + 100.0F;
            if (var15 < var16 * var16) {
                this.d = 0.0F;
                this.c = 0.0F;
            } else if (var15 < var17 * var17) {
            }

            var18 = 300.0F;
            boolean var34 = true;
            if (this.aU == null && var2 != null && (class_340.c(this.o - var13.a) > 300.0F || class_340.c(this.p - var13.b) > 300.0F) && this.s > 30.0F) {
                this.s = 30.0F;
            }

            if (this.s == 0.0F && this.aU == null) {
                this.s = 700.0F;
                var31 = false;
                this.a(var13.a, var13.b, 0, false, var31);
            }

            if (var2 != null) {
                var3.e = var2.a;
                var3.f = var2.b;
                if (!var9) {
                    var3.b = true;
                }
            }
        }

    }

    private strictfp void a(GameEngine var1, float var2, class_1042 var3, class_1044 var4) {
        boolean var5 = this.I();
        if (this.aU != null) {
            this.b(var1);
        }

        if (this.ad != null && (this.ad.bV || !this.ad.bT())) {
            this.a((OrderableUnit)null);
        }

        if (this.k) {
            class_1045 var6 = this.aE();
            class_1042 var7 = this.ar();
            if (var7 == null) {
                var4.d = false;
            }

            if (L) {
                var4.d = false;
            }

            if (this.ae && this.ag > 0 && this.aG()) {
                this.an = var1.by;
            }

            if (var7 != null && this.ad != null && var4.d) {
                class_1042 var8 = this.ad.ar();
                if (var8 != null && !var8.b(var7)) {
                    var4.d = false;
                }
            }

            if (this.ad != null && var4.d) {
                this.a(var2, var6, var4, var3);
            } else if (this.cl != 0.0F) {
                var4.e = this.l;
                var4.f = this.m;
                var4.b = true;
            } else {
                boolean var12 = false;
                if (this.aU == null) {
                    if (var6 == null) {
                        if (this.u && this.s < 450.0F && this.aU == null) {
                            var12 = true;
                        }

                        if (this.s == 0.0F) {
                            var12 = true;
                        }
                    }

                    float var9;
                    if (this.s == 0.0F && (this.ct() || this.aV())) {
                        var9 = this.attackRange() - 1.0F;
                        if (class_340.c(this.o - this.l) > var9 || class_340.c(this.p - this.m) > var9) {
                            var12 = true;
                        }
                    }

                    if (var3 != null && this.s == 0.0F && (var3.a == WaypointType.loadInto || var3.a == WaypointType.loadUp)) {
                        var9 = 12.0F;
                        if (class_340.c(this.o - this.l) > var9 || class_340.c(this.p - this.m) > var9) {
                            var12 = true;
                        }
                    }

                    if (var3 != null) {
                        var9 = (float)this.r;
                        if (class_340.c(this.o - this.l) > var9 || class_340.c(this.p - this.m) > var9) {
                            if (this.s > 30.0F) {
                                this.s = 30.0F;
                            }

                            if (this.s == 0.0F) {
                                var12 = true;
                            }
                        }
                    }
                }

                if (var12) {
                    this.s = 500.0F;
                    boolean var13 = this.ae && this.ah > 1;
                    this.a(this.l, this.m, this.n, var13, this.t);
                }

                if (var6 != null && this.au == null && this.aw >= 2 && this.speed() > 5.0F) {
                    class_1045 var14 = this.av[1];
                    float var10 = class_340.a(this.xCord, this.yCord, var6.a, var6.b);
                    float var11 = class_340.a(this.xCord, this.yCord, var14.a, var14.b);
                    if (var10 < 36.0F) {
                        this.aJ();
                        var6 = this.aE();
                    } else if (var11 < 361.0F) {
                        this.aJ();
                        var6 = this.aE();
                    }
                }

                if (var6 != null) {
                    var4.e = var6.a;
                    var4.f = var6.b;
                    var4.b = true;
                } else if (this.j) {
                    var4.e = this.l;
                    var4.f = this.m;
                    var4.b = true;
                }
            }
        }

        this.a(var2, var4, var3, var5);
    }

    private strictfp void a(float var1, class_1044 var2, class_1042 var3, boolean var4) {
        float var5 = 0.0F;
        GameEngine var6 = GameEngine.getGameEngine();
        if (this.k && var2.b && var4) {
            float var7 = var2.e;
            float var8 = var2.f;
            float var9 = this.speed();
            float var10 = class_340.a(this.xCord, this.yCord, var7, var8);
            float var11 = class_340.d(this.xCord, this.yCord, var7, (var8 - this.yCord) * this.ba() + this.yCord);
            boolean var12 = false;
            float var13 = this.bc();
            if (var13 > 0.95F) {
                var12 = true;
            } else if ((double)var13 > 0.87) {
                if (this.ah <= 1 && this.aw > 0 && this.aw <= 9 && this.ae && var10 < 250000.0F) {
                    var12 = true;
                }
            } else if ((double)var13 > 0.7) {
                if (this.ah <= 1 && this.aw > 0 && this.aw <= 4 && this.ae && var10 < 40000.0F) {
                    var12 = true;
                }
            } else if ((double)var13 > 0.4 && this.ah <= 1 && this.aw > 0 && this.aw <= 2 && this.ae && var10 < 10000.0F) {
                var12 = true;
            }

            boolean var14 = true;
            float var15 = 179.0F;
            if (this.R != null && this.E() && this.bj() && !this.aV()) {
                this.ch = var11;
            } else if (this.az <= 0.0F) {
                var15 = this.a(var1, var11, var14, var12);
            }

            float var16 = 20.0F;
            if (var10 > 361.0F) {
                var16 = 46.0F;
            }

            if (var10 > 3600.0F) {
                var16 = 89.0F;
            }

            float var17 = this.turnSpeed();
            if ((double)var17 < 1.4) {
                if (var10 > 6400.0F) {
                    var16 *= 0.5F;
                } else {
                    var16 = 17.0F;
                }
            }

            if (var9 > 5.0F && (double)this.cf < 0.01 && (double)this.cf > -0.01) {
                var16 = 1.0F;
            }

            if ((double)var17 < 1.1) {
                var16 *= 0.7F;
            }

            if ((double)this.cf > 0.4 && var10 > 16900.0F) {
                var16 = 180.0F;
            }

            if (this.aY() && this.v == this.aw) {
                var16 = 1.0F;
            }

            if (this.bj()) {
                var16 = 181.0F;
            }

            float var18 = 4.0F;
            boolean var19 = this.aw == 1;
            if ((!var19 || var10 >= var18 * var18) && class_340.c(var15) <= var16) {
                var5 = 1.0F;
                if (var2.c) {
                    if (var10 < 2500.0F) {
                        var5 -= 0.15F;
                    }

                    if (var10 < 900.0F) {
                        var5 -= 0.15F;
                    }

                    if (var10 < 225.0F) {
                        var5 -= 0.3F;
                    }
                } else if (this.ad != null) {
                    if (var10 > 400.0F) {
                        var5 += 0.2F;
                    }

                    if (var10 < 49.0F) {
                        var5 -= 0.15F;
                    }

                    if (var10 < 9.0F) {
                        var5 -= 0.15F;
                    }
                }

                if (var10 < 9.0F) {
                    var5 = 0.0F;
                }
            }

            if (var19 && var5 != 0.0F) {
                if (var10 < 324.0F && this.D() < 0.13F && this.speed() > 1.0F) {
                    var5 = 0.5F * var5;
                }

                if (var10 < 169.0F && this.D() < 0.15F && this.speed() > 0.9F) {
                    var5 = 0.5F * var5;
                }

                if (var9 > 5.0F) {
                    if (var10 < 324.0F && var5 > 0.5F) {
                        var5 = 0.5F;
                    }

                    if (var10 < 81.0F && var5 > 0.25F) {
                        var5 = 0.25F;
                    }
                }
            }

            boolean var20 = false;
            if (!var19 && var10 < 256.0F) {
                var20 = true;
            }

            if (var19 && var10 < var18 * var18) {
                var20 = true;
            }

            if ((this.aa == var6.tick || this.aa == var6.tick - 1) && this.Z != null && this.Z.c(var7, var8, 2.0F)) {
                var20 = true;
            }

            if (var5 > 0.0F) {
                this.W += var1;
                if (this.W > 200.0F && var10 < 3600.0F && this.aw >= 2) {
                    float var21 = this.W;
                    this.aJ();
                    this.W = var21;
                }

                if (this.W > 600.0F && this.aw >= 2 && this.au == null) {
                    this.aH();
                }

                if (this.W > 80.0F && this.b > 30.0F) {
                    this.aH();
                }

                if (this.W > 40.0F && this.aw >= 2 && this.au == null) {
                    class_1045 var24 = this.av[1];
                    float var22 = class_340.a(this.xCord, this.yCord, var24.a, var24.b);
                    if (var22 < var10) {
                        float var23 = this.W;
                        this.aJ();
                        this.W = var23;
                    }
                }
            }

            if (var20) {
                this.aJ();
                if (var19) {
                    this.d = 0.0F;
                    this.c = 0.0F;
                    if (!this.u && this.ad == null && var3 != null && var3.a == WaypointType.move) {
                        this.ax();
                    }
                }
            }
        }

        if (this.ci && !this.bj()) {
            var5 = -var5 * this.bc();
        }

        if (this.az > 0.0F) {
            var5 = 0.0F;
        }

        if (!this.bi()) {
            if (this.cf < var5) {
                this.cf = class_340.a(this.cf, var5, this.C() * var1);
            }

            if (this.cf > var5) {
                this.cf = class_340.a(this.cf, var5, this.D() * var1);
            }
        } else {
            this.cf = var5;
        }

        this.cK = var2.b && var4;
    }

    @Deprecated
    public strictfp boolean Z() {
        return this.R != null;
    }

    public strictfp boolean aa() {
        if (this.R != null && !this.R.bV) {
            int var1 = this.bl();

            for(int var2 = 0; var2 < var1; ++var2) {
                if (this.cL[var2].j != null && this.r(var2)) {
                    return true;
                }
            }
        }

        return false;
    }

    public strictfp Unit ab() {
        if (this.R != null && !this.R.bV) {
            return this.R;
        } else {
            class_1042 var1 = this.ar();
            return var1 != null && var1.h != null && !var1.h.bV ? var1.h : null;
        }
    }

    private strictfp void a(GameEngine var1, float var2, float var3) {
        aQ.a(var3);
        var1.cc.a(this.xCord, this.yCord, var3, this, var2, aQ);
        if (aQ.a != 0 && (this.R == null || !this.h(this.R))) {
            aR.a(var3);
            var1.cc.a(this.xCord, this.yCord, var3, this, var2, aR);
        }

    }

    public strictfp boolean ac() {
        return this.bl() > 1;
    }

    private strictfp void a(GameEngine var1, float var2) {
        int var3 = this.bl();
        if (this.ac()) {
            boolean var9 = false;

            int var5;
            for(var5 = 0; var5 < var3; ++var5) {
                class_1048 var6 = this.cL[var5];
                if (this.v(var5) == -1) {
                    boolean var7 = false;
                    boolean var8 = false;
                    if (this.a(var5, this.R, false, false)) {
                        var6.j = this.R;
                    } else {
                        var9 = true;
                        if (var6.j == this.R) {
                            var6.j = null;
                        }
                    }
                }
            }

            if (var9) {
                float var10 = this.b(false);
                aT.a(this);
                var1.cc.a(this.xCord, this.yCord, var10, this, var2, aT);
            }

            for(var5 = 0; var5 < var3; ++var5) {
                int var11 = this.v(var5);
                if (var11 != -1) {
                    this.cL[var5].j = this.cL[var11].j;
                }
            }

        } else {
            for(int var4 = 0; var4 < var3; ++var4) {
                this.cL[var4].j = this.R;
            }

        }
    }

    public strictfp boolean ad() {
        if (!this.l()) {
            return false;
        } else {
            class_826 var1 = this.dn();
            return var1 == null || var1.M;
        }
    }

    private strictfp void b(GameEngine var1, float var2) {
        int var3 = this.bl();
        boolean var4 = false;
        if (this.ad()) {
            boolean var5 = false;
            boolean var6 = false;
            if (this.R != null) {
                class_826 var7 = this.dn();
                if (var7 != null && this.cO != null && var7.L && this.cO.R == this.R) {
                    var5 = true;
                }

                if (!this.a(this.R, false) && !var5) {
                    boolean var8 = true;
                    if (var8) {
                        this.R = null;
                    }
                }
            }

            if (this.R != null && !var5) {
                var6 = !this.h(this.R);
            }

            this.S = class_340.a(this.S, var2);
            this.T = class_340.a(this.T, var2);
            float var24;
            if ((this.R == null || var6) && this.S == 0.0F && this.bf()) {
                this.S = 20.0F + this.xCord % 5.0F + this.yCord % 5.0F;
                var24 = this.b(false);
                this.a(var1, var2, var24);
                if (this.R != null) {
                    this.T = 0.0F;
                }
            }

            if (this.R != null && this.T == 0.0F) {
                this.T = 20.0F + this.xCord % 5.0F + this.yCord % 5.0F;
                this.a(var1, var2);
            }

            for(int var25 = 0; var25 < var3; ++var25) {
                this.cL[var25].g = false;
            }

            if (this.R != null) {
                var24 = class_340.a(this.xCord, this.yCord, this.R.xCord, this.R.yCord);
                float var26 = this.o(this.R);
                if (!(var24 < var26 * var26) && !var5) {
                    if (!this.k && this.an()) {
                        this.j = true;
                        this.k = true;
                        this.l = this.R.xCord;
                        this.m = this.R.yCord;
                        this.n = 0;
                    }
                } else {
                    int var9 = this.aT();

                    int var10;
                    class_1048 var11;
                    Unit var12;
                    for(var10 = 0; var10 < var3; ++var10) {
                        var11 = this.cL[var10];
                        var12 = var11.j;
                        if (var12 != null) {
                            boolean var13 = var12 == this.R;
                            if (!var13 && !this.b(var12, true)) {
                                var11.j = null;
                            } else {
                                boolean var14 = false;
                                boolean var15 = !var13;
                                if (!this.a(var10, var12, false, var15)) {
                                    var11.j = null;
                                } else {
                                    PointF var16 = this.G(var10);
                                    PointF var17 = this.K(var10);
                                    var17.x += var12.xCord;
                                    var17.y += var12.yCord;
                                    float var18 = class_340.d(var16.x, var16.y, var17.x, var17.y);
                                    if (this.v(var10) == -1 && var10 != var9) {
                                        if (!this.E()) {
                                            var11.a(70);
                                            var11.b = var11.a;
                                            float var27 = 179.0F;
                                            if (!var11.b()) {
                                                var27 = this.a(var2, var18, var10);
                                            }

                                            if (class_340.c(var27) < this.x(var10)) {
                                                var11.g = true;
                                            }
                                        } else {
                                            boolean var19 = false;
                                            class_1042 var20 = this.ar();
                                            if (var20 != null && (var20.a == WaypointType.build || var20.a == WaypointType.repair || var20.a == WaypointType.reclaim)) {
                                                var19 = true;
                                            }

                                            if (!var19 && (!this.k || this.bj())) {
                                                float var21 = this.c(var2, var18);
                                                var11.b = var11.a;
                                                if (class_340.c(var21) < this.x(var10)) {
                                                    var11.g = true;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    for(var10 = 0; var10 < var3; ++var10) {
                        var11 = this.cL[var10];
                        var12 = var11.j;
                        if (var12 != null) {
                            if (this.u(var10) && var11.e == 0.0F) {
                                var4 = true;
                            }

                            if (this.u(var10)) {
                                this.a(var2, var12, var10);
                            }
                        }
                    }
                }
            }
        }

        if (this.aN && this.X() != null) {
            var4 = true;
        }

        for(int var22 = 0; var22 < var3; ++var22) {
            class_1048 var23 = this.cL[var22];
            if (!var4 && var23.f != 0.0F) {
                var23.f = class_340.a(var23.f, this.f(var22) * var2);
            }
        }

    }

    public strictfp void b(Unit var1, int var2) {
    }

    public strictfp boolean a(float var1, Unit var2, int var3) {
        class_1048 var4 = this.cL[var3];
        int var5 = this.v(var3);
        if (var5 != -1) {
            var4.a = this.cL[var5].a;
        }

        boolean var6 = this.s(var3);
        boolean var7 = false;
        if (var6) {
            if (var4.f < this.e(var3)) {
                if (var4.f == 0.0F) {
                    this.b(var2, var3);
                }

                var4.f += var1;
            } else {
                var4.f = this.e(var3);
            }

            var7 = true;
        }

        if (var4.e == 0.0F && this.r(var3)) {
            boolean var8 = false;
            boolean var9 = false;
            if (!this.a(var3, var2, false, false)) {
                var4.e = -10.0F;
            } else {
                if (!var6) {
                    if (var4.f < this.e(var3)) {
                        if (var4.f == 0.0F) {
                            this.b(var2, var3);
                        }

                        var4.f += var1;
                    } else {
                        var7 = true;
                    }
                }

                if (var7) {
                    var4.e = this.shootDelay(var3) + this.t(var3);
                    if (!var6) {
                        var4.f = 0.0F;
                    }

                    this.a(var2, var3);
                    this.M(var3);
                    var4.m = !var4.m;
                    return true;
                }
            }
        }

        return false;
    }

    public strictfp boolean h(Unit var1) {
        float var2 = class_340.a(this.xCord, this.yCord, var1.xCord, var1.yCord);
        float var3 = this.o(var1);
        return var2 < var3 * var3;
    }

    public strictfp boolean ae() {
        return false;
    }

    public strictfp boolean af() {
        return true;
    }

    public strictfp boolean ag() {
        return true;
    }

    public strictfp boolean ah() {
        return true;
    }

    public strictfp boolean i(Unit var1) {
        int var2 = this.bl();

        for(int var3 = 0; var3 < var2; ++var3) {
            boolean var4 = false;
            boolean var5 = false;
            if (this.r(var3) && this.a(var3, var1, false, false)) {
                int var6 = this.v(var3);
                if (var6 == -1 || this.a(var6, var1, false, false)) {
                    return true;
                }
            }
        }

        return false;
    }

    public strictfp boolean j(Unit var1) {
        int var2 = this.bl();

        for(int var3 = 0; var3 < var2; ++var3) {
            boolean var4 = true;
            boolean var5 = false;
            if (this.r(var3) && this.a(var3, var1, true, false)) {
                int var6 = this.v(var3);
                if (var6 == -1 || this.a(var6, var1, true, false)) {
                    return true;
                }
            }
        }

        return false;
    }

    public strictfp boolean a(int var1, Unit var2, boolean var3, boolean var4) {
        return var3 || !var4 || this.h(var2);
    }

    public strictfp boolean k(Unit var1) {
        if (var1.i()) {
            return this.af();
        } else if (var1.Q()) {
            return this.ae();
        } else {
            return !this.ah() && !var1.cH() ? false : this.ag();
        }
    }

    public strictfp boolean a(Unit var1) {
        return false;
    }

    public strictfp boolean l(Unit var1) {
        return var1.g() != 0.0F && this.h(var1, true) ? true : this.a(var1);
    }

    public strictfp class_226 a(class_31 var1, boolean var2) {
        return this.a(var1, -1, var2);
    }

    public strictfp boolean ai() {
        Iterator var1 = this.N().iterator();

        class_226 var2;
        do {
            if (!var1.hasNext()) {
                return false;
            }

            var2 = (class_226)var1.next();
        } while(!var2.g());

        return true;
    }

    public strictfp class_226 a(class_31 var1, int var2, boolean var3) {
        ArrayList var4 = this.N();
        class_226 var5 = null;
        if (var4.size() > 0) {
            Iterator var6 = var4.iterator();

            class_226 var7;
            do {
                class_31 var8;
                do {
                    do {
                        if (!var6.hasNext()) {
                            return var5;
                        }

                        var7 = (class_226)var6.next();
                        var8 = var7.y();
                        if (var3) {
                            class_31 var9 = var7.E();
                            if (var9 != null) {
                                var8 = var9;
                            }
                        }
                    } while(var8 != var1);
                } while(var2 != -1 && var2 != var7.t());

                var5 = var7;
            } while(!var7.b((Unit)this) || !var7.a(this, false));

            return var7;
        } else {
            return var5;
        }
    }

    public strictfp boolean b(class_31 var1, boolean var2) {
        class_226 var3 = this.a(var1, var2);
        if (var3 != null) {
            if (var3.g(this)) {
                return false;
            } else {
                return var3.b((Unit)this);
            }
        } else {
            return false;
        }
    }

    public strictfp boolean aj() {
        return this.r().m();
    }

    public strictfp boolean ak() {
        return this.r().l();
    }

    public strictfp void m(Unit var1) {
    }

    public strictfp boolean al() {
        return false;
    }

    public final strictfp boolean a(Unit var1, boolean var2) {
        if (this.bX != var1.bX && !var1.bV && this.bX.c(var1.bX)) {
            if (this.P == AttackMode.holdFire) {
                return false;
            } else if (this.P == AttackMode.returnFire) {
                return false;
            } else if (var1.cN != null) {
                return false;
            } else if (!this.k(var1)) {
                return false;
            } else if (!var1.d((Unit)this)) {
                return false;
            } else if (!var2) {
                float var3 = class_340.a(this.xCord, this.yCord, var1.xCord, var1.yCord);
                float var5 = this.b(false);
                float var4 = var5 * var5;
                return var3 < var4;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public final strictfp boolean b(Unit var1, boolean var2) {
        return var1.cu() ? false : this.a(var1, var2);
    }

    public strictfp float am() {
        return 0.0F;
    }

    public strictfp boolean an() {
        return this.P == AttackMode.outOfRange || this.P == AttackMode.guardArea || this.P == AttackMode.aggressive;
    }

    public strictfp float b(boolean var1) {
        float var2 = this.attackRange();
        class_1042 var3 = this.ar();
        if (var3 != null && (var3.a == WaypointType.attackMove || var3.a == WaypointType.patrol || var3.a == WaypointType.guard)) {
            if (var3.a == WaypointType.patrol) {
                var2 += 110.0F;
            } else if (var3.a == WaypointType.guard) {
                var2 += 90.0F;
            } else {
                var2 += 20.0F;
            }

            if (var2 < 190.0F) {
                var2 = 190.0F;
            }
        }

        if (this.P == AttackMode.outOfRange) {
            var2 += 250.0F;
        } else if (this.P == AttackMode.guardArea) {
            var2 += 150.0F;
        } else if (this.P == AttackMode.aggressive) {
            var2 += 180.0F;
        } else {
            var2 += this.am();
            if (var1) {
                var2 += 110.0F;
            }
        }

        return var2;
    }

    public strictfp class_1042 ao() {
        this.m(29);
        if (this.f > 0) {
            this.b(this.g[0]);
        }

        class_1042 var1 = this.g[29];

        for(int var2 = 29; var2 >= 1; --var2) {
            this.g[var2] = this.g[var2 - 1];
        }

        this.g[0] = var1;
        if (this.f < 29) {
            ++this.f;
        }

        if (this.g[0] == null) {
            this.g[0] = new class_1042();
        }

        class_1042 var3 = this.g[0];
        var3.e();
        this.V = 0.0F;
        this.Y = 0.0F;
        this.W = 0.0F;
        this.c(var3);
        this.aH();
        return var3;
    }

    public strictfp void a(class_1042 var1) {
    }

    public final strictfp void b(class_1042 var1) {
        this.h = false;
    }

    public strictfp void c(class_1042 var1) {
        this.bC();
        this.i = -9999;
        if (this.R != null && this.R.cu()) {
            this.R = null;
        }

    }

    public strictfp class_1042 ap() {
        this.m(this.f);
        if (this.g[this.f] == null) {
            this.g[this.f] = new class_1042();
        }

        class_1042 var1 = this.g[this.f];
        var1.e();
        if (this.f < 29) {
            ++this.f;
        }

        if (this.f > 0) {
            this.c(this.g[0]);
        }

        return var1;
    }

    public strictfp class_1042 d(float var1, float var2) {
        class_1042 var3 = this.ap();
        var3.a(var1, var2);
        return var3;
    }

    public strictfp class_1042 n(Unit var1) {
        class_1042 var2 = this.ap();
        var2.a(var1);
        return var2;
    }

    public strictfp class_1042 e(float var1, float var2) {
        class_1042 var3 = this.ap();
        var3.b(var1, var2);
        return var3;
    }

    public strictfp boolean a(class_1042 var1, boolean var2) {
        if (var1 == null) {
            if (var2) {
                GameEngine.print("isValidNewWaypoint: Skipping null waypoint");
            }

            return false;
        } else {
            if (var1.d() == WaypointType.build) {
                if (var1.b == null) {
                    if (var2) {
                        GameEngine.print("isValidNewWaypoint: Skipping build waypoint with no buildType");
                    }

                    return false;
                }

                class_226 var3 = this.a(var1.b, var1.d, false);
                if (var3 == null) {
                    if (var2) {
                        GameEngine.print("Unit '" + this.r().i() + "' can not queue build:" + var1.b.i());
                    }

                    return false;
                }

                if (!var1.n) {
                    if (var3.g(this)) {
                        if (var2) {
                            GameEngine.print("Builder '" + this.r().i() + "' tried to queue a locked building:" + var3.O());
                        }

                        return false;
                    }

                    if (!var3.b((Unit)this)) {
                        if (var2) {
                            GameEngine.print("Builder '" + this.r().i() + "' tried to queue a unavailable building:" + var3.O());
                        }

                        return false;
                    }
                }
            }

            return true;
        }
    }

    public strictfp class_1042 d(class_1042 var1) {
        class_1042 var2 = this.ap();
        var2.c(var1);
        return var2;
    }

    public strictfp boolean aq() {
        return this.ar() == null;
    }

    public strictfp class_1042 ar() {
        return this.f == 0 ? null : this.g[0];
    }

    public strictfp class_1042 as() {
        return this.f <= 1 ? null : this.g[1];
    }

    public strictfp class_1042 at() {
        return this.f == 0 ? null : this.g[this.f - 1];
    }

    public strictfp void au() {
        if (this.f != 0) {
            if (this.f == 1) {
                this.ay();
            } else {
                --this.f;
            }

        }
    }

    public strictfp class_1042 k(int var1) {
        return this.g[var1];
    }

    public strictfp int av() {
        return this.f;
    }

    public strictfp boolean aw() {
        class_1042 var1 = this.ar();
        return var1 != null && var1.a == WaypointType.attack;
    }

    public strictfp boolean a(class_31 var1, float var2, float var3) {
        for(int var4 = 0; var4 < this.f; ++var4) {
            class_1042 var5 = this.g[var4];
            if (var5.a == WaypointType.build && var5.b == var1 && class_340.c(var5.e - var2) < 10.0F && class_340.c(var5.f - var3) < 10.0F) {
                return true;
            }
        }

        return false;
    }

    public strictfp void l(int var1) {
        if (var1 >= 120) {
            throw new RuntimeException("PathNode index:" + var1 + " too large");
        } else {
            if (this.av == at) {
                this.av = new class_1045[120];
            }

        }
    }

    public strictfp void m(int var1) {
        if (var1 >= 30) {
            throw new RuntimeException("Waypoint index:" + var1 + " too large");
        } else {
            if (this.g == O) {
                this.g = new class_1042[30];
            }

        }
    }

    public strictfp void n(int var1) {
        if (this.f <= var1) {
            throw new IndexOutOfBoundsException("completeWaypoint: waypointsCount:" + this.f + ", waypointIndex:" + var1);
        } else if (var1 == 0) {
            this.ay();
        } else {
            if (this.g.length > 0) {
                class_1042 var2 = this.g[var1];

                for(int var3 = var1; var3 < this.f - 1; ++var3) {
                    this.g[var3] = this.g[var3 + 1];
                }

                this.g[this.f - 1] = var2;
            }

            --this.f;
        }
    }

    public strictfp void ax() {
        this.aC();
        this.ay();
    }

    public strictfp void ay() {
        this.V = 0.0F;
        this.Y = 0.0F;
        this.W = 0.0F;
        this.ar = false;
        this.aq = -999.0F;
        this.as = false;
        this.w = 0;
        if (this.f == 0) {
            this.aH();
            this.e = 0.0F;
            this.d = 0.0F;
            this.c = 0.0F;
        } else if (this.f == 1) {
            this.b(this.g[0]);
            this.f = 0;
            this.aH();
            this.e = 0.0F;
            this.d = 0.0F;
            this.c = 0.0F;
            this.c((class_1042)null);
        } else {
            if (this.g.length > 0) {
                class_1042 var1 = this.g[0];
                this.b(var1);

                for(int var2 = 0; var2 < this.f - 1; ++var2) {
                    this.g[var2] = this.g[var2 + 1];
                }

                this.g[this.f - 1] = var1;
            }

            --this.f;
            if (this.f > 0) {
                this.c(this.g[0]);
            } else {
                this.c((class_1042)null);
            }

            this.aH();
        }
    }

    public strictfp void az() {
        int var1 = this.f;
        if (this.f > 0) {
            this.b(this.g[0]);
        }

        this.V = 0.0F;
        this.Y = 0.0F;
        this.ar = false;
        this.aq = -999.0F;
        this.as = false;
        this.f = 0;
        this.aH();
        this.aD();
        this.a((OrderableUnit)null);
        this.e = 0.0F;
        this.d = 0.0F;
        this.c = 0.0F;
        this.w = 0;
        if (var1 > 0) {
            this.c((class_1042)null);
        }

    }

    public strictfp void aA() {
        for(int var1 = 0; var1 < this.f; ++var1) {
            class_1042 var2 = this.g[var1];
            if (var2 != null && var2.a != WaypointType.build && var2.a != WaypointType.repair) {
                this.n(var1);
            }
        }

    }

    public strictfp void a(OrderableUnit var1) {
        if (this.ad != null) {
            --this.ad.ag;
        }

        this.ad = var1;
        if (var1 != null) {
            ++this.ad.ag;
        }

    }

    public strictfp void aB() {
        this.a((OrderableUnit)null);
        this.ae = false;
        this.aj = false;
        this.ak = 0.0F;
        this.al = 0.0F;
        this.ac = 0;
        this.c = 0.0F;
    }

    public strictfp void aC() {
        if (this.ag != 0) {
            class_1042 var1 = this.as();
            Unit[] var2 = Unit.bE.a();
            int var3 = 0;

            for(int var4 = Unit.bE.size(); var3 < var4; ++var3) {
                Unit var5 = var2[var3];
                if (var5 instanceof OrderableUnit) {
                    OrderableUnit var6 = (OrderableUnit)var5;
                    if (var6.ad == this) {
                        float var7 = class_340.a(this.xCord, this.yCord, var6.xCord, var6.yCord);
                        boolean var8 = var7 < 108900.0F;
                        boolean var9 = false;
                        boolean var10 = false;
                        class_1042 var11 = var6.as();
                        if (var1 != null && var11 != null) {
                            if (var1.b(var11)) {
                                var9 = true;
                            }
                        } else if (var1 == null && var11 == null) {
                            var10 = true;
                        }

                        if (var9 && var8) {
                            var6.ay();
                        } else if (!var10) {
                            var6.a((OrderableUnit)null);
                        }
                    }
                }
            }

        }
    }

    public strictfp void aD() {
        OrderableUnit var1 = null;
        if (this.ag != 0) {
            Unit[] var2 = Unit.bE.a();
            int var3 = 0;

            for(int var4 = Unit.bE.size(); var3 < var4; ++var3) {
                Unit var5 = var2[var3];
                if (var5 instanceof OrderableUnit) {
                    OrderableUnit var6 = (OrderableUnit)var5;
                    if (var6.ad == this) {
                        var6.a((OrderableUnit)null);
                        var1 = var6;
                    }
                }
            }

            if (this.ag != 0) {
                this.ag = 0;
            }

            if (var1 != null) {
                class_1042 var7 = var1.ar();
                if (var7 != null) {
                    class_984 var8 = var7.i;
                    if (var8 != null) {
                        var8.c();
                    }
                }
            }

        }
    }

    public strictfp class_1045 aE() {
        if (this.aw == 0) {
            return null;
        } else {
            return this.au != null ? this.au.a(this) : this.av[0];
        }
    }

    public strictfp class_1045 aF() {
        if (this.aw < 2) {
            return null;
        } else {
            return this.au != null ? this.au.b(this) : this.av[1];
        }
    }

    public strictfp void a(int var1, float var2, float var3) {
        this.l(var1);
        if (this.av[var1] == null) {
            this.av[var1] = new class_1045();
        }

        this.av[var1].a = var2;
        this.av[var1].b = var3;
    }

    public strictfp boolean aG() {
        if (this.au != null) {
            return false;
        } else {
            if (this.aw >= 2) {
                if ((double)this.speed() > 0.5) {
                    if (this.W > 150.0F || this.X > 150.0F) {
                        return true;
                    }
                } else if (this.W > 300.0F || this.X > 300.0F) {
                    return true;
                }
            }

            return false;
        }
    }

    public strictfp void aH() {
        this.aw = 0;
        this.u = false;
        this.v = 0;
        this.s = 0.0F;
        this.W = 0.0F;
        this.X = 0.0F;
        this.q = 0;
    }

    public strictfp void aI() {
        this.aH();
        this.av = at;
        this.aI = 0;
        this.aJ = null;
        this.aK = null;
    }

    public strictfp void aJ() {
        this.X = this.W;
        this.W = 0.0F;
        if (this.au != null) {
            this.au.c(this);
        } else if (this.aw != 0) {
            if (this.aw == 1) {
                this.aw = 0;
            } else {
                class_1045 var1 = this.av[0];

                for(int var2 = 0; var2 < this.aw - 1; ++var2) {
                    this.av[var2] = this.av[var2 + 1];
                }

                this.av[this.aw - 1] = var1;
                --this.aw;
            }
        }
    }

    public strictfp boolean aK() {
        GameEngine var1 = GameEngine.getGameEngine();
        boolean var2 = false;
        boolean var3 = false;
        if (this.ct()) {
            var2 = true;
        }

        var1.bL.a(this.xCord, this.yCord);
        int var4 = var1.bL.T;
        int var5 = var1.bL.U;
        if (var1.bU.a(this.h(), var4, var5) && !var1.bU.b(this.h(), var4, var5)) {
            var2 = true;
            var3 = true;
        }

        return var2;
    }

    public strictfp void a(float var1, float var2, int var3, boolean var4, boolean var5) {
        GameEngine var6 = GameEngine.getGameEngine();
        PathEngine var7 = var6.bU;
        class_484 var8 = var6.bL;
        this.cK = true;
        boolean var9 = false;
        boolean var10 = false;
        if (this.ct()) {
            var9 = true;
        }

        var8.a(this.xCord, this.yCord);
        int var11 = var8.T;
        int var12 = var8.U;
        if (var7.a(this.h(), var11, var12) && !var7.b(this.h(), var11, var12)) {
            var9 = true;
            var10 = true;
        }

        if (var1 != this.o || this.p != var2) {
            this.q = 0;
        }

        this.o = var1;
        this.p = var2;
        if (var9) {
            this.u = false;
            this.aw = 0;
            this.au = null;
            float var30 = var8.a(var1);
            float var31 = var8.b(var2);
            if (var10) {
                float var32 = class_340.d(this.xCord, this.yCord, var30, var31);
                float var33 = class_340.b(this.xCord, this.yCord, var30, var31);
                if (var33 > 60.0F) {
                    var33 = 60.0F;
                    this.u = true;
                    if (this.s > 10.0F) {
                        this.s = 10.0F;
                    }
                }

                var30 = this.xCord + class_340.k(var32) * var33;
                var31 = this.yCord + class_340.j(var32) * var33;
            }

            this.a(this.aw, var30, var31);
            ++this.aw;
            this.v = this.aw;
        } else {
            byte var13 = 1;
            byte var14 = 80;
            byte var15 = 0;
            if (var4) {
                var15 = 3;
            }

            boolean var16 = class_1050.a(this.h(), this.xCord, this.yCord, var1, var2, var14, var15, var13);
            float var21;
            float var24;
            if (var16) {
                this.u = false;
                this.aw = 0;
                this.au = null;
                float var34 = var8.a(var1);
                float var35 = var8.b(var2);
                float var36 = this.xCord;
                float var38 = this.yCord;
                var21 = class_340.d(this.xCord, this.yCord, var34, var35);
                float var39 = class_340.b(this.xCord, this.yCord, var34, var35);
                float var40 = class_340.k(var21);
                var24 = class_340.j(var21);
                float var25 = 20.0F;
                float var26 = 0.05F;
                int var27 = (int)(var39 * 0.05F - 1.0F);
                int var28 = 1;
                if (var27 < 4) {
                    var28 = 0;
                }

                for(int var29 = 0; var29 < var27; ++var29) {
                    var36 += var40 * 20.0F;
                    var38 += var24 * 20.0F;
                    if (var28 > 0) {
                        --var28;
                    } else {
                        this.a(this.aw, var36, var38);
                        ++this.aw;
                        if (this.aw >= 119) {
                            this.u = true;
                            break;
                        }
                    }
                }

                if (!this.u) {
                    if (this.aw < 119) {
                        this.a(this.aw, var34, var35);
                        ++this.aw;
                    } else {
                        this.u = true;
                    }
                }

                this.v = this.aw;
            } else {
                class_984 var17 = null;
                boolean var18 = false;
                class_1042 var19 = this.ar();
                if (var19 != null) {
                    var17 = var19.i;
                    if (var17 == null) {
                    }
                }

                if (var17 != null && var17.g != null) {
                    class_353 var20 = null;
                    var21 = 3600.0F;
                    Iterator var22 = var17.g.iterator();

                    while(var22.hasNext()) {
                        class_353 var23 = (class_353)var22.next();
                        var18 = true;
                        if (var23.a != null && var23.a.a() != null && !(class_340.c(var23.e - var1) > 10.0F) && !(class_340.c(var23.f - var2) > 10.0F) && var23.g + 180 >= var6.tick && var23.h == this.h()) {
                            var24 = class_340.a(this.xCord, this.yCord, var23.c, var23.d);
                            if (var24 < var21) {
                                var20 = var23;
                            }
                        }
                    }

                    if (var20 != null) {
                        this.aU = var20.a;
                        return;
                    }
                }

                if (L && var3 > 2) {
                    var3 = 2;
                }

                boolean var37 = true;
                this.aU = this.a(var1, var2, var3, var4, var37, var5);
            }
        }
    }

    public strictfp class_224 a(float var1, float var2, int var3, boolean var4, boolean var5, boolean var6) {
        GameEngine var7 = GameEngine.getGameEngine();
        PathEngine var8 = var7.bU;
        class_484 var9 = var7.bL;
        class_224 var10 = var8.a(var5);
        var9.a(this.xCord, this.yCord);
        boolean var11 = false;
        if (this.bb() || this.ci) {
            var11 = true;
        }

        var10.a(this.h(), (short)var9.T, (short)var9.U, this.cg, var11);
        var9.a(var1, var2);
        var10.a((short)var9.T, (short)var9.U, (short)var3);
        var10.p = var4;
        var10.q = this.bh();
        var10.r = var6;
        boolean var12 = this.cK;
        this.cK = true;
        if (var5 && var10.b()) {
            Iterator var13 = aV.iterator();

            while(var13.hasNext()) {
                class_224 var14 = (class_224)var13.next();
                if (var14.g + 60 < var7.tick) {
                    var13.remove();
                } else if (var14.a(var10)) {
                    return var14;
                }
            }
        }

        var8.a(var10, var5);
        this.cK = var12;
        if (var5 && var10.b()) {
            aV.add(var10);
        }

        return var10;
    }

    strictfp void b(GameEngine var1) {
        if (this.aU != null) {
            class_484 var2 = var1.bL;
            LinkedList var3 = this.aU.a();
            if (var3 != null) {
                this.au = this.aU.a((Unit)this);
                class_224 var4 = this.aU;
                this.aw = 0;
                this.u = false;
                Iterator var5 = var3.iterator();

                while(var5.hasNext()) {
                    class_319 var6 = (class_319)var5.next();
                    var2.a(var6.a, var6.b);
                    float var7 = (float)(var2.T + var2.p);
                    float var8 = (float)(var2.U + var2.q);
                    this.a(this.aw, var7, var8);
                    ++this.aw;
                    if (this.aw >= 120) {
                        this.u = true;
                        break;
                    }
                }

                if (this.aw == 1) {
                    ++this.q;
                }

                boolean var9 = true;
                boolean var10 = false;
                if (var3.size() != 0) {
                    var2.a(this.o, this.p);
                    if (!this.u && ((class_319)var3.getLast()).a == var2.T && ((class_319)var3.getLast()).b == var2.U) {
                        var10 = true;
                    }
                }

                if (var10) {
                    if (!var9) {
                        if (this.aw < 120) {
                            this.a(this.aw, this.o, this.p);
                            ++this.aw;
                        }
                    } else {
                        if (this.aw == 0) {
                            ++this.aw;
                        }

                        this.a(this.aw - 1, this.o, this.p);
                    }
                }

                this.aU = null;
                if (this.aw > 120) {
                    GameEngine.print("activePathCount>maxPathNodes: activePathCount:" + this.aw);
                    this.aw = 120;
                }

                this.v = this.aw;
            }
        }

    }

    public strictfp long aL() {
        long var1 = 0L;

        for(int var3 = 0; var3 < this.aw; ++var3) {
            class_1045 var4 = this.av[var3];
            if (var4 != null) {
                var1 += (long)Float.floatToRawIntBits(var4.a);
                var1 += (long)Float.floatToRawIntBits(var4.b);
            }
        }

        return var1;
    }

    strictfp class_1045 o(int var1) {
        if (this.au != null) {
            return var1 == 0 ? this.aE() : this.aF();
        } else {
            return var1 >= this.aw ? null : this.av[var1];
        }
    }

    public strictfp void d(float var1) {
        super.d(var1);
    }

    public strictfp float aM() {
        return 1.0F;
    }

    public strictfp int l(float var1) {
        if (var1 < -0.3F) {
            int var2 = (int)((1.0F - -var1 / 10.0F) * 130.0F + 45.0F);
            if (var2 < 45) {
                var2 = 45;
            }

            return var2;
        } else {
            return 255;
        }
    }

    public strictfp Paint aN() {
        PorterDuffColorFilter var1 = null;
        boolean var2 = true;
        int var4;
        if (this.zCord < -0.3F) {
            int var3 = this.l(this.zCord);
            var4 = Color.a(var3, 255, 255, 255);
        } else {
            var4 = -1;
        }

        if (this.cm < 1.0F && this.cm < this.aM()) {
            float var5 = this.cm / this.aM() * 220.0F;
            var4 = Color.a((int)(20.0F + var5), 140, 255, 140);
            var1 = aX;
        }

        if (this.cp) {
            if (this.cs) {
                var4 = Color.a(200, 20, 255, 20);
                var1 = aY;
            }

            if (this.ct) {
                var4 = Color.a(200, 255, 20, 20);
                var1 = aZ;
            }

            if (this.cq) {
                var4 = Color.a(50, 70, 70, 245);
                var1 = ba;
                if (this.ct) {
                    var4 = Color.a(50, 255, 20, 20);
                    var1 = aZ;
                }
            }

            if (this.cr) {
                var4 = Color.a(150, 100, 100, 100);
            }
        }

        boolean var6 = this.aO();
        return this.a(var4, var1, var6);
    }

    public strictfp boolean aO() {
        GameEngine var1 = GameEngine.getGameEngine();
        boolean var2 = var1.settingsEngine.renderAntiAlias;
        if (!this.dk()) {
            var2 = false;
            float var3 = var1.cX;
            if (var3 < 1.0F) {
                var2 = true;
            }
        }

        if (this.co) {
            var2 = UnitType.ag;
        }

        return var2;
    }

    public strictfp float p(int var1) {
        return 1.0F;
    }

    public strictfp boolean c(float var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        class_28 var3 = var2.bO;
        Paint var4 = this.aN();
        float var5 = this.cD();
        PointF var6;
        float var8;
        if (this.ew) {
            var6 = this.cY();
            float var7 = this.xCord + var6.x - var2.cw;
            var8 = this.yCord + var6.y - var2.cx - this.zCord;
            this.aQ();
            if (var5 != 1.0F) {
                var3.k();
                var3.a(var5, var5, var7, var8);
            }

            var3.a(this.M, var7, var8, this.d(false) - 90.0F, var4);
            if (var5 != 1.0F) {
                var3.l();
            }
        } else {
            var6 = this.cY();
            RectF var13 = this.cF();
            var8 = var6.x;
            float var9 = var6.y - this.zCord;
            var13.a += var8;
            var13.b += var9;
            var13.c += var8;
            var13.d += var9;
            Rect var10 = this.a_(false);
            float var11 = (var13.a + var13.c) * 0.5F;
            float var12 = (var13.b + var13.d) * 0.5F;
            var3.k();
            this.aQ();
            if (var5 != 1.0F) {
                var3.a(var5, var5, var11, var12);
            }

            var3.a(this.d(false), var11, var12);
            var3.a(this.M, var10, var13, var4);
            var3.l();
        }

        return true;
    }

    public strictfp boolean F() {
        return this.zCord > 0.0F && this.cm >= 1.0F && !this.cq;
    }

    public strictfp PointF aP() {
        be.setSite(this.G(), this.H());
        return be;
    }

    public strictfp float G() {
        return 0.0F;
    }

    public strictfp float H() {
        return 0.0F;
    }

    public strictfp boolean aQ() {
        if (this.N != null && this.F()) {
            GameEngine var1 = GameEngine.getGameEngine();
            if (!var1.de && this.cj < 18.0F && (double)this.zCord < 0.5) {
                return true;
            } else if (!var1.df && this.cj < 28.0F && this.zCord < 5.0F) {
                return true;
            } else {
                PointF var2 = this.aP();
                float var3 = this.xCord + var2.x - var1.cw;
                float var4 = this.yCord + var2.y - var1.cx;
                float var5 = this.cD();
                class_28 var6 = var1.bO;
                if (var5 != 1.0F) {
                    var6.k();
                    var6.a(var5, var5, var3, var4);
                }

                if (this.cG()) {
                    Rect var7 = this.a_(true);
                    RectF var8 = dB;
                    var8.a(var3 - this.eu, var4 - this.ev, var3 + this.eu, var4 + this.ev);
                    var6.k();
                    var6.a(this.d(true), var3, var4);
                    var6.a(this.N, var7, var8, this.R());
                    var6.l();
                } else {
                    var6.a(this.N, var3, var4, this.d(true) - 90.0F, this.R());
                }

                if (var5 != 1.0F) {
                    var6.l();
                }

                return true;
            }
        } else {
            return false;
        }
    }

    public strictfp boolean s_() {
        GameEngine var1 = GameEngine.getGameEngine();
        return RectF.a(var1.cM, this.cE());
    }

    public abstract boolean I();

    public strictfp boolean aR() {
        class_826 var1 = this.dn();
        return var1 != null && !var1.O ? false : this.I();
    }

    public strictfp boolean aS() {
        return this.aR();
    }

    public strictfp boolean b_() {
        return true;
    }

    public strictfp int aT() {
        return -1;
    }

    public strictfp float o(Unit var1) {
        return this.aV() && var1 != null ? this.attackRange() + this.cj + var1.cj : this.attackRange();
    }

    public strictfp float p(Unit var1) {
        return this.aV() && var1 != null ? this.aU() + this.cj + var1.cj : this.aU();
    }

    public strictfp float aU() {
        return this.attackRange();
    }

    public strictfp int q(Unit var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        int var3 = 0;
        float var4 = this.p(var1);
        if (var4 > 58.0F) {
            var3 = (int)((var4 - 41.0F) / ((float)var2.bL.n * 1.414F));
        }

        return var3;
    }

    public abstract float attackRange();

    public strictfp boolean aV() {
        return false;
    }

    public abstract float shootDelay(int var1);

    public strictfp float q(int var1) {
        return 0.0F;
    }

    public strictfp void aW() {
        int var1 = this.bl();

        for(int var2 = 0; var2 < var1; ++var2) {
            if (var2 < this.cL.length) {
                class_1048 var3 = this.cL[var2];
                if (var3.e > this.shootDelay(var2)) {
                    var3.e = this.shootDelay(var2);
                }
            }
        }

    }

    public strictfp ArrayList aX() {
        ArrayList var1 = new ArrayList();
        if (this.l()) {
            int var2 = this.bl();

            for(int var3 = 0; var3 < var2; ++var3) {
                float var4 = this.q(var3);
                if (var4 != 0.0F) {
                    float var5 = this.shootDelay(var3);
                    if (var5 == 9000.0F) {
                        var5 = 0.0F;
                    }

                    boolean var6 = false;
                    Iterator var7 = var1.iterator();

                    while(var7.hasNext()) {
                        class_1057 var8 = (class_1057)var7.next();
                        if (var8.a == var4 && (var8.b == var5 || var5 == 0.0F || var8.b == 0.0F)) {
                            ++var8.d;
                            if (var8.b == 0.0F) {
                                var8.b = var5;
                            }

                            var6 = true;
                            break;
                        }
                    }

                    if (!var6) {
                        class_1057 var9 = new class_1057();
                        var9.a = var4;
                        var9.b = var5;
                        var9.c = this.e(var3);
                        var1.add(var9);
                    }
                }
            }
        }

        return var1;
    }

    public strictfp boolean r(int var1) {
        return true;
    }

    public strictfp float e(int var1) {
        return 0.0F;
    }

    public strictfp boolean s(int var1) {
        return false;
    }

    public strictfp float t(int var1) {
        return 0.0F;
    }

    public strictfp float f(int var1) {
        return 4.0F;
    }

    public strictfp boolean u(int var1) {
        int var2 = this.v(var1);
        return var2 == -1 ? this.cL[var1].g : this.cL[var2].g;
    }

    public strictfp int v(int var1) {
        return -1;
    }

    public abstract float turnSpeed();

    public strictfp float B() {
        return -1.0F;
    }

    public abstract float c(int var1);

    public strictfp float w(int var1) {
        return -1.0F;
    }

    public strictfp float x(int var1) {
        return 5.0F;
    }

    public strictfp float y(int var1) {
        return this.w(var1);
    }

    public strictfp boolean E() {
        return false;
    }

    public strictfp boolean aY() {
        return false;
    }

    public abstract float speed();

    public strictfp float aZ() {
        return 1.0F;
    }

    public strictfp float ba() {
        return 1.0F;
    }

    public strictfp boolean bb() {
        return this.bc() > 0.95F;
    }

    public strictfp float bc() {
        return 0.6F;
    }

    public strictfp float bd() {
        return 0.0F;
    }

    public strictfp AttackMovementType be() {
        return AttackMovementType.NORMAL;
    }

    public strictfp boolean bf() {
        return true;
    }

    public strictfp boolean bg() {
        return true;
    }

    public strictfp int bh() {
        return 0;
    }

    public strictfp float C() {
        return 99.0F;
    }

    public strictfp float D() {
        return 99.0F;
    }

    public strictfp boolean bi() {
        return false;
    }

    public strictfp boolean bj() {
        return false;
    }

    public strictfp boolean b(int var1, float var2) {
        return true;
    }

    public abstract void a(Unit var1, int var2);

    public strictfp boolean bk() {
        return false;
    }

    public strictfp int bl() {
        return 1;
    }

    public strictfp boolean bm() {
        return true;
    }

    public strictfp float g(int var1) {
        return 0.0F;
    }

    public strictfp float z(int var1) {
        return 99999.0F;
    }

    public strictfp float A(int var1) {
        return -1.0F;
    }

    public strictfp float B(int var1) {
        return 0.0F;
    }

    public strictfp float C(int var1) {
        return this.ci && this.bb() ? this.cg + 180.0F : this.cg;
    }

    public strictfp Point3DF bn() {
        int var1 = this.aT();
        return var1 == -1 ? this.D(0) : this.D(var1);
    }

    public strictfp Point3DF D(int var1) {
        bf.a(this.E(var1));
        return bf;
    }

    public strictfp PointF E(int var1) {
        class_1048 var2 = this.cL[var1];
        float var3 = this.g(var1);
        float var4 = this.E() ? this.cg : var2.a;
        PointF var5 = this.G(var1);
        float var6 = var5.x + class_340.k(var4) * var3;
        float var7 = var5.y + class_340.j(var4) * var3;
        bg.setSite(var6, var7);
        return bg;
    }

    public strictfp Point3DF F(int var1) {
        bi.a(this.G(var1));
        bi.z = 0.0F;
        return bi;
    }

    public strictfp PointF G(int var1) {
        class_1048 var2 = this.cL[var1];
        float var3 = this.xCord;
        float var4 = this.yCord;
        float var5 = this.H(var1);
        if (var2.e != 0.0F && var5 != 0.0F) {
            float var6 = this.I(var1);
            float var7 = this.J(var1);
            float var8 = 0.0F;
            float var9 = this.shootDelay(var1) - var2.e;
            if (var9 < var6) {
                var8 = var9 / var6 * var5;
            } else if (var9 < var7 + var6) {
                var8 = var5 - (var9 - var6) / var7 * var5;
            }

            if (var8 != 0.0F) {
                var3 += class_340.k(var2.a) * var8;
                var4 += class_340.j(var2.a) * var8;
            }
        }

        bh.setSite(var3, var4);
        return bh;
    }

    public strictfp float H(int var1) {
        return 0.0F;
    }

    public strictfp float I(int var1) {
        return 4.0F;
    }

    public strictfp float J(int var1) {
        return 6.0F;
    }

    public strictfp PointF K(int var1) {
        PointF var2 = bj;
        var2.setSite(0.0F, 0.0F);
        class_1048 var3 = this.cL[var1];
        var2.x += var3.h;
        var2.y += var3.i;
        return var2;
    }

    public strictfp float L(int var1) {
        return 0.6F;
    }

    public strictfp void M(int var1) {
        if (var1 != -1) {
            class_1048 var4 = this.cL[var1];
            var4.h = 0.0F;
            var4.i = 0.0F;
            if (this.R != null && this.L(var1) != 0.0F) {
                float var5 = this.R.cj * this.L(var1);
                var4.h += class_340.a(this, (-var5), (int)var5, 1 + var1);
                var4.i += class_340.a(this, (-var5), (int)var5, 2 + var1);
            }

        } else {
            int var2 = this.bl();

            for(int var3 = 0; var3 < var2; ++var3) {
                this.M(var3);
            }

        }
    }

    public strictfp void a(ExplodeType var1) {
        this.a(var1, true);
    }

    public strictfp void a(ExplodeType var1, boolean var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        class_998 var4;
        if (var1 == ExplodeType.verylargeBuilding) {
            var3.bM.a(class_648.p, 0.8F, this.xCord, this.yCord);
            var3.bR.a(this.xCord, this.yCord, this.zCord);
            var3.bR.b(Priority.critical);
            var4 = var3.bR.c(this.xCord, this.yCord, this.zCord, -1127220);
            if (var4 != null) {
                var4.G = 0.2F;
                var4.F = 2.0F;
                var4.ar = 2;
                var4.V = 45.0F;
                var4.W = var4.V;
                var4.U = 0.0F;
            }
        } else if (var1 != ExplodeType.large && var1 != ExplodeType.building && var1 != ExplodeType.buildingNoShockwaveOrSmoke) {
            float var6;
            if (var1 == ExplodeType.verysmall) {
                var6 = 1.0F + class_340.c(-0.07F, 0.07F);
                var3.bM.a(class_648.o, 0.4F, var6, this.xCord, this.yCord);
                var3.bR.b(this.xCord, this.yCord, this.zCord);
            } else if (var1 == ExplodeType.largeUnit) {
                var6 = 1.0F + class_340.c(-0.07F, 0.07F);
                var3.bM.a(class_648.o, 0.8F, var6, this.xCord, this.yCord);
                var3.bR.b(this.xCord, this.yCord, this.zCord);
                var3.bR.b(Priority.critical);
                class_998 var5 = var3.bR.c(this.xCord, this.yCord, this.zCord, -1127220);
                if (var5 != null) {
                    var5.G = 0.2F;
                    var5.F = 2.0F;
                    var5.ar = 2;
                    var5.V = 45.0F;
                    var5.W = var5.V;
                    var5.U = 0.0F;
                }
            } else {
                var6 = 1.0F + class_340.c(-0.07F, 0.07F);
                var3.bM.a(class_648.o, 0.8F, var6, this.xCord, this.yCord);
                var3.bR.b(this.xCord, this.yCord, this.zCord);
            }
        } else {
            var3.bM.a(class_648.p, 0.8F, this.xCord, this.yCord);
            var3.bR.a(this.xCord, this.yCord, this.zCord);
        }

        if (var1 != ExplodeType.verysmall) {
            if (var1 != ExplodeType.buildingNoShockwaveOrSmoke) {
                var4 = var3.bR.d(this.xCord, this.yCord, this.zCord, 0);
                if (var4 != null) {
                    var4.E = 0.9F;
                }
            }

            if (var2) {
                if (!this.bO()) {
                    this.bo();
                }

                if (var1 != ExplodeType.buildingNoShockwaveOrSmoke && !this.cK()) {
                    Emitter.a(this.xCord, this.yCord);
                    Emitter.b(this.xCord, this.yCord);
                    this.bq();
                }
            }
        }

    }

    public strictfp void bo() {
        GameEngine var1 = GameEngine.getGameEngine();
        float var2 = 1.0F;
        float var3 = 1.0F;
        int var4 = this.bp();
        if (var4 >= 10) {
            var2 = 1.2F;
            var3 = 1.4F;
        }

        if (var4 >= 20) {
            var2 = 1.5F;
            var3 = 1.7F;
        }

        if (this.zCord > -1.0F) {
            for(int var5 = 0; var5 < var4; ++var5) {
                var1.bR.b(this.xCord, this.yCord, this.zCord, var2, var3);
            }
        }

    }

    public strictfp int bp() {
        if (this.dd()) {
            return 8;
        } else {
            return this.bI() ? 7 : 4;
        }
    }

    public strictfp void bq() {
        if (!this.cK()) {
            ScorchMark.a(this.xCord, this.yCord);
        }

    }

    public strictfp int s() {
        return 15;
    }

    public strictfp void c(boolean var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        if (this.cN == null && this.cO == null) {
            int var3 = this.s();
            if (var3 > 0) {
                var2.bL.a(this.xCord, this.yCord, var3, this.bX, var1);
            }

        }
    }

    public strictfp void br() {
        GameEngine var1 = GameEngine.getGameEngine();
        RectF var2 = new RectF();
        var2.a(this.cd());
        var2.b *= (float)var1.bL.o;
        var2.d *= (float)var1.bL.o;
        var2.a *= (float)var1.bL.n;
        var2.c *= (float)var1.bL.n;
        var2.a(this.xCord, this.yCord);
        var2.a(-this.cZ(), -this.da());
        float var3 = 10.0F;
        var2.b -= var3;
        var2.d += var3;
        var2.a -= var3;
        var2.c += var3;
        class_682 var4 = Unit.bF();
        Iterator var5 = var4.iterator();

        while(var5.hasNext()) {
            Unit var6 = (Unit)var5.next();
            if (var6 instanceof Unit && var6 != this && var6.a(var2)) {
                if (var6 instanceof OrderableUnit && var6.bV) {
                    var6.a();
                }

                if (var6 instanceof Tree) {
                    ((Tree)var6).k();
                }
            }
        }

    }

    public strictfp boolean c(PlayerData var1) {
        return this.b(false, var1) == null;
    }

    public strictfp boolean a(boolean var1, PlayerData var2) {
        return this.b(var1, var2) == null;
    }

    public strictfp String b(boolean var1, PlayerData var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        class_387 var4 = this.r().q();
        if (var4 != null) {
            String var5 = var4.a(this, this.xCord, this.yCord);
            if (var5 != null) {
                return var5;
            }
        }

        if (this.r().p()) {
            var3.bL.a(this.xCord, this.yCord);
            class_482 var14 = var3.bL.e(var3.bL.T, var3.bL.U);
            if (var14 == null || !var14.i) {
                return "{2}";
            }
        }

        if (!var1 && this.a((Unit)null, (PlayerData)var2)) {
            return "{0}";
        } else {
            if (!this.r().p()) {
                Rect var15 = this.cd();
                Point var6 = this.a((class_484)var3.bL, (Point)bk);
                int var7 = var6.a;
                int var8 = var6.b;
                class_31 var9 = this.r();
                MovementType var10 = var9.o();

                for(int var11 = var7 + var15.a; var11 <= var7 + var15.c; ++var11) {
                    for(int var12 = var8 + var15.b; var12 <= var8 + var15.d; ++var12) {
                        String var13 = class_88.a(this, var9, var10, var11, var12, false, var2);
                        if (var13 != null) {
                            return var13;
                        }
                    }
                }
            }

            return null;
        }
    }

    public strictfp void N(int var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        if (!this.r().p()) {
            Rect var3 = this.cd();
            Point var4 = this.a((class_484)var2.bL, (Point)bl);
            int var5 = var4.a;
            int var6 = var4.b;
            class_31 var7 = this.r();
            int var8 = var5 + var3.a;
            int var9 = var6 + var3.b;
            int var10 = var5 + var3.c;
            int var11 = var6 + var3.d;
            if (var1 != -2) {
                var2.bL.a(this, var8, var9, var10, var11, (int)var2.cw, (int)var2.cx, var2.bO, true, var1);
            }
        }

    }

    public strictfp boolean r(Unit var1) {
        float var2 = class_340.a(this.xCord, this.yCord, var1.xCord, var1.yCord);
        float var3 = 9.0F;
        if (!var1.bI()) {
            var3 = this.cj + var1.cj;
            if (var3 < 11.0F) {
                var3 = 11.0F;
            }
        }

        return var2 < var3 * var3;
    }

    public strictfp boolean a(Unit var1, PlayerData var2) {
        boolean var3 = false;
        if (!this.bI()) {
            var3 = true;
        }

        float var4 = this.cj + class_436.p + 10.0F;
        float var5 = this.xCord - var4;
        float var6 = this.xCord + var4;
        float var7 = this.yCord - var4;
        float var8 = this.yCord + var4;
        Unit[] var9 = Unit.bE.a();
        int var10 = 0;

        for(int var11 = Unit.bE.size(); var10 < var11; ++var10) {
            Unit var12 = var9[var10];
            float var13 = var12.xCord;
            float var14 = var12.yCord;
            if (var5 <= var13 && var13 <= var6 && var7 <= var14 && var14 <= var8 && var12 != this && (var3 || var12.bI()) && !var12.bV && this.r(var12) && var12 != var1 && (var2 == null || var12.d(var2))) {
                return true;
            }
        }

        return false;
    }

    public strictfp OrderableUnit bs() {
        Iterator var1 = Unit.bE.iterator();

        while(var1.hasNext()) {
            Unit var2 = (Unit)var1.next();
            if (var2 != this && var2 instanceof OrderableUnit) {
                OrderableUnit var3 = (OrderableUnit)var2;
                if (!var3.bV && var3.bX == this.bX && var3.r() == this.r() && this.t(var3)) {
                    return var3;
                }
            }
        }

        return null;
    }

    public strictfp void a() {
        if (this.cO != null) {
            this.bx();
        }

        this.az();
        this.aI();
        super.a();
    }

    public strictfp void bt() {
        this.a((OrderableUnit)null);
        this.R = null;
        this.az();
        this.aI();
    }

    public strictfp void bu() {
        if (this.cO != null) {
            this.bx();
        }

        super.bu();
    }

    public strictfp void bv() {
        super.bv();
    }

    public strictfp int bw() {
        int var1 = 0;
        var1 = var1 * 31 + super.bw();
        var1 = var1 * 31 + (int)(this.speed() * 100.0F);
        var1 = var1 * 31 + (int)(this.turnSpeed() * 100.0F);
        var1 = var1 * 31 + (int)(this.attackRange() * 100.0F);
        var1 = var1 * 31 + (int)this.shootDelay(0);
        var1 = var1 * 31 + (int)(this.C() * 100.0F);
        return var1;
    }

    strictfp PointF m(float var1) {
        PointF var2 = this.n(var1);
        dE.setSite(this.xCord + var2.x, this.yCord + var2.y);
        return dE;
    }

    public strictfp PointF n(float var1) {
        float var2 = 0.0F;
        float var3 = 0.0F;
        if (this.I() && this.b == 0.0F) {
            if (this.bi()) {
                var2 = this.cc * var1;
                var3 = this.cd * var1;
            } else if (this.cf != 0.0F) {
                float var4 = this.cg;
                if (this.bj()) {
                    var4 = this.ch;
                }

                float var5 = this.speed() * this.cf * var1;
                var2 = class_340.k(var4) * var5;
                var3 = class_340.j(var4) * var5;
            }
        }

        bm.setSite(var2, var3);
        return bm;
    }

    public strictfp boolean a(OrderType var1) {
        return false;
    }

    public strictfp void a(class_226 var1, boolean var2, float var3, float var4) {
    }

    public strictfp boolean a(class_226 var1, float var2, float var3) {
        return true;
    }

    public strictfp void a(Unit var1, float var2, int var3) {
        this.U = class_340.a(this.U, var2);
        if (this.U == 0.0F) {
            this.U = 5.0F;
            if (this.s_()) {
                Point3DF var4 = this.bn();
                GameEngine var5 = GameEngine.getGameEngine();
                class_998 var6 = var5.bR.b(var4.x, var4.y, this.zCord + var4.z, class_989.CUSTOM, false, Priority.low);
                if (var6 != null) {
                    float var7 = (float)((double)var1.xCord + -8.0 + Math.random() * 16.0);
                    float var8 = (float)((double)var1.yCord + -8.0 + Math.random() * 16.0);
                    float var9 = class_340.d(var4.x, var4.y, var7, var8);
                    var6.P = class_340.k(var9) * class_340.c(2.0F, 4.0F);
                    var6.Q = class_340.j(var9) * class_340.c(2.0F, 4.0F);
                    var6.ap = 6;
                    var6.V = 20.0F;
                    var6.W = var6.V;
                    var6.r = true;
                    var6.E = 0.8F;
                    var6.G = 0.2F;
                    var6.F = 1.0F;
                }
            }
        }

    }

    public strictfp void b(Unit var1, float var2, int var3) {
        this.U = class_340.a(this.U, var2);
        if (this.U == 0.0F) {
            this.U = 5.0F;
            if (this.s_()) {
                PointF var4 = this.E(0);
                GameEngine var5 = GameEngine.getGameEngine();
                class_998 var6 = var5.bR.b(var1.xCord, var1.yCord, var1.zCord, class_989.CUSTOM, false, Priority.low);
                if (var6 != null) {
                    float var7 = (float)((double)var4.x + -8.0 + Math.random() * 16.0);
                    float var8 = (float)((double)var4.y + -8.0 + Math.random() * 16.0);
                    float var9 = class_340.d(var1.xCord, var1.yCord - var1.zCord, var7, var8);
                    var6.P = class_340.k(var9) * class_340.c(2.0F, 4.0F);
                    var6.Q = class_340.j(var9) * class_340.c(2.0F, 4.0F);
                    var6.ap = 5;
                    var6.V = 20.0F;
                    var6.W = var6.V;
                    var6.r = true;
                    var6.E = 0.8F;
                    var6.G = 0.2F;
                    var6.F = 1.0F;
                }
            }
        }

    }

    public strictfp class_810 a(class_1042 var1, class_31 var2, int var3, float var4, float var5) {
        GameEngine var6 = GameEngine.getGameEngine();
        class_226 var7 = this.a(var2, var3, false);
        if (var7 == null) {
            GameEngine.print("Unit '" + this.r().i() + "' can not build:" + var2.i());
            return bn.a();
        } else {
            if (!var1.n) {
                if (var7.g(this)) {
                    GameEngine.print("Builder '" + this.r().i() + "' tried to build a locked building:" + var7.O());
                    return bn.a();
                }

                if (!var7.b((Unit)this) && !var7.u(this)) {
                    GameEngine.print("Builder '" + this.r().i() + "' tried to build a unavailable building:" + var7.O() + " (add isLocked:false to fix)");
                    return bn.a();
                }
            }

            if (!var2.k() && !var7.x() && this.bX.w() >= this.bX.x()) {
                if (this.bX == var6.playerTeam) {
                    var6.bS.b(var6.bS.g.al);
                }

                return bn.a();
            } else {
                Unit var8 = Unit.a(var2);
                if (var8 == null) {
                    String var15 = "{build is null}";
                    if (var1.b != null) {
                        var15 = var1.b.i();
                    }

                    GameEngine.log("Build unit type missing: " + var15);
                    return bn.a();
                } else {
                    Unit var9 = class_88.g(var2);
                    if (!class_447.b(var2.u(), var7.B()) || !class_447.b(var2.B(), var7.r_())) {
                        var9.bx = var7.B();
                        var9.by = var7.r_();
                    }

                    if (var7 instanceof class_231) {
                        var9.bx = null;
                        var9.by = null;
                    }

                    var9.cm = 0.0F;
                    var9.cn = 0.0F;
                    var6.bL.b(var4 - var9.cZ() + 1.0F, var5 - var9.da() + 1.0F);
                    var9.xCord = (float)var6.bL.T + var9.cZ();
                    var9.yCord = (float)var6.bL.U + var9.da();
                    var9.f(this.bX);
                    var9.B(this);
                    if (var3 != 1 && var9 instanceof OrderableUnit) {
                        ((OrderableUnit)var9).a(var3);
                    }

                    var9.cP();
                    if (var9 instanceof OrderableUnit) {
                        OrderableUnit var10 = (OrderableUnit)var9;
                        boolean var11 = false;
                        OrderableUnit var12 = null;
                        if (this.al()) {
                            var12 = this;
                        } else if (!this.bT && !this.bI()) {
                            var12 = this;
                        }

                        if (var10.a((Unit)var12, (PlayerData)null)) {
                            var11 = true;
                        }

                        if (!var11 && !var10.a(true, (PlayerData)null)) {
                            var11 = true;
                        }

                        if (var11) {
                            var9.a();
                            class_810 var13 = bn.a();
                            OrderableUnit var14 = ((OrderableUnit)var9).bs();
                            var13.b = var14;
                            var13.d = var7;
                            if (var14 == null) {
                            }

                            return var13;
                        }
                    }

                    class_447 var16 = var7.B();
                    if (var1.n) {
                        var16 = class_447.a;
                    }

                    class_810 var18;
                    if (!var16.c(this)) {
                        var9.a();
                        var18 = bn.a();
                        this.Q = var6.by;
                        if (this.V < 1000.0F) {
                            var18.c = true;
                            class_990 var19 = class_990.a(this.bX, var9.xCord, var9.yCord);
                            if (var19 != null) {
                                var19.i = true;
                            }
                        }

                        return var18;
                    } else {
                        this.m(var9);
                        if (var9 instanceof OrderableUnit) {
                            OrderableUnit var17 = (OrderableUnit)var9;
                            var17.br();
                            if (var9.bI()) {
                                var6.bU.a(var17);
                            }
                        }

                        PlayerData.c(var9);
                        var18 = bn.a();
                        var18.a = var9;
                        var18.d = var7;
                        return var18;
                    }
                }
            }
        }
    }

    public strictfp boolean a(OrderableUnit var1, class_826 var2) {
        return false;
    }

    public strictfp boolean b(OrderableUnit var1) {
        return false;
    }

    public strictfp void bx() {
        if (this.cO != null) {
            if (this.cO.bV) {
            }

            if (!this.cO.b(this)) {
                GameEngine.print("Deattach failed, forcing deattach. Child:" + this.cB() + " Parent:" + this.cO.cB());
                this.cO = null;
                this.cP = null;
            }

        }
    }

    public strictfp class_826 a(short var1) {
        return null;
    }

    public static strictfp Unit a(OrderableUnit var0, float var1, float var2, float var3, class_588 var4) {
        if (var3 <= 0.0F) {
            return null;
        } else {
            bo.f = true;
            bo.g = false;
            bo.e = null;
            bo.d = var3 * var3;
            bo.c = var4;
            bo.a = var1;
            bo.b = var2;
            GameEngine var5 = GameEngine.getGameEngine();
            var5.cc.a(var1, var2, var3, var0, 0.0F, bo);
            return bo.e;
        }
    }

    public strictfp class_447 by() {
        return class_447.a;
    }

    public strictfp class_684 bz() {
        return bq;
    }

    public strictfp boolean bA() {
        return false;
    }

    public strictfp int bB() {
        return 0;
    }

    public strictfp void bC() {
        class_447 var1 = this.bE();
        class_447 var2 = this.bD();
        class_447 var3;
        if (var1 == null) {
            var3 = var2;
        } else if (var2 == null) {
            var3 = var1;
        } else {
            var3 = class_447.a(var1, var2);
        }

        if (this.dJ != null || var3 != null) {
            if (this.dJ == null || var3 == null || !this.dJ.b(var3)) {
                PlayerData.b((Unit)this);
                this.dJ = var3;
                PlayerData.c((Unit)this);
            }
        }
    }

    public strictfp class_447 bD() {
        return null;
    }

    public strictfp class_447 bE() {
        Unit var1 = this.X();
        if (var1 != null) {
            class_1042 var2 = this.ar();
            if (var2 != null) {
                class_447 var3;
                float var4;
                if (var2.a == WaypointType.repair && var1.cm < 1.0F) {
                    var3 = this.g(var1);
                    var4 = this.a_(var1) * 60.0F;
                    if (var3 != null) {
                        return class_447.a(var3, -var4);
                    }
                }

                if (var2.a == WaypointType.reclaim) {
                    if (var1.cm < 1.0F) {
                        var3 = this.g(var1);
                        var4 = this.f(var1) * 60.0F;
                        if (var3 != null) {
                            return class_447.a(var3, var4);
                        }
                    } else {
                        boolean var9 = this.y(var1);
                        if (var9) {
                            var4 = this.z(var1);
                            class_447 var5 = var1.cM();
                            class_447 var6 = var1.cN();
                            if (var6 != null) {
                                var5 = var6;
                            }

                            float var7 = var4 * 60.0F;
                            float var8 = var7 / var1.totalHealth;
                            return class_447.a(var5, var8);
                        }
                    }
                }
            }
        }

        return null;
    }

    // $FF: synthetic method
    static void a(OrderableUnit var0, Unit var1, float var2, boolean var3) {
        var0.a(var1, var2, var3);
    }

    static {
        aE.a(128, 255, 255, 255);
        aE.o();
        aF = new class_525();
        aF.a((Paint)aE);
        aF.a(true);
        aF.d(true);
        aF.b(true);
        aF.o();
        aG = new PointF();
        B = new Paint();
        D = a(false);
        E = a(true);
        aH = new class_303();
        aM = new class_692();
        aP = new class_1044();
        aQ = new class_307(true);
        aR = new class_307(false);
        aS = new class_306(true);
        aT = new class_306(false);
        aV = new class_684();
        aW = new class_1045();
        aX = new PorterDuffColorFilter(Color.a(200, 255, 200), Mode.MULTIPLY);
        aY = new PorterDuffColorFilter(Color.a(70, 255, 70), Mode.MULTIPLY);
        aZ = new PorterDuffColorFilter(Color.a(255, 40, 40), Mode.MULTIPLY);
        ba = new PorterDuffColorFilter(Color.a(120, 120, 255), Mode.MULTIPLY);
        bb = class_694.b();
        bc = class_694.b();
        bd = class_694.b();
        be = new PointF();
        bf = new Point3DF();
        bg = new PointF();
        bh = new PointF();
        bi = new Point3DF();
        bj = new PointF();
        bk = new Point();
        bl = new Point();
        bm = new PointF();
        bn = new class_810();
        bo = new class_308();
        bq = new class_684();
    }
}
