package com.corrodinggames.rts.gameFramework.f;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Paint$Align;
import android.graphics.Paint$Style;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import com.corrodinggames.rts.AssetsID$drawable;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.a.class_138;
import com.corrodinggames.rts.game.units.WaypointType;
import com.corrodinggames.rts.game.units.class_1042;
import com.corrodinggames.rts.game.units.OrderType;
import com.corrodinggames.rts.game.units.class_1050;
import com.corrodinggames.rts.game.units.EditorOrBuilder;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.a.class_1052;
import com.corrodinggames.rts.game.units.a.class_1059;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.a.class_227;
import com.corrodinggames.rts.game.units.a.class_228;
import com.corrodinggames.rts.game.units.a.class_229;
import com.corrodinggames.rts.game.units.a.class_230;
import com.corrodinggames.rts.game.units.a.class_232;
import com.corrodinggames.rts.game.units.a.class_233;
import com.corrodinggames.rts.game.units.a.class_239;
import com.corrodinggames.rts.game.units.a.class_240;
import com.corrodinggames.rts.game.units.custom.class_388;
import com.corrodinggames.rts.game.units.custom.class_436;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.custom.a.class_283;
import com.corrodinggames.rts.game.units.custom.e.class_1067;
import com.corrodinggames.rts.game.units.custom.e.class_1069;
import com.corrodinggames.rts.game.units.custom.e.BuiltInResource;
import com.corrodinggames.rts.game.units.custom.e.a.CreditsResource;
import com.corrodinggames.rts.game.units.buildings.class_8;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.SettingsEngine;
import com.corrodinggames.rts.gameFramework.SyncPacket;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.class_62;
import com.corrodinggames.rts.gameFramework.GameObject;
import com.corrodinggames.rts.gameFramework.class_985;
import com.corrodinggames.rts.gameFramework.a.class_648;
import com.corrodinggames.rts.gameFramework.d.class_989;
import com.corrodinggames.rts.gameFramework.d.class_990;
import com.corrodinggames.rts.gameFramework.d.Priority;
import com.corrodinggames.rts.gameFramework.d.class_998;
import com.corrodinggames.rts.gameFramework.f.a.class_174;
import com.corrodinggames.rts.gameFramework.f.a.class_177;
import com.corrodinggames.rts.gameFramework.f.a.class_180;
import com.corrodinggames.rts.gameFramework.f.a.class_183;
import com.corrodinggames.rts.gameFramework.f.a.class_186;
import com.corrodinggames.rts.gameFramework.f.a.class_187;
import com.corrodinggames.rts.gameFramework.f.a.class_188;
import com.corrodinggames.rts.gameFramework.h.class_1009;
import com.corrodinggames.rts.gameFramework.i.class_800;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.m.class_525;
import com.corrodinggames.rts.gameFramework.n.class_70;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameNetEngine;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import com.corrodinggames.rts.gameFramework.utility.class_692;
import com.corrodinggames.rts.gameFramework.utility.class_694;
import java.util.ArrayList;
import java.util.Iterator;

public final strictfp class InterfaceEngine extends class_62 {
    public static boolean a = false;
    public boolean b = true;
    public boolean c = false;
    public float d = 0.0F;
    public boolean e = false;
    EditorOrBuilder f;
    public class_71 g;
    public class_531 h;
    public class_519 i;
    public class_533 j;
    public class_548 k;
    class_228 l = new class_228();
    class_229 m = new class_229();
    class_232 n = new class_232();
    class_227 o = new class_227();
    public class_233 p = new class_233();
    class_240 q = new class_240();
    class_239 r = new class_239();
    class_174 s = new class_180();
    boolean t = false;
    public boolean u = false;
    double v;
    float w = 0.0F;
    public float x = 0.0F;
    public float y = 0.0F;
    float z = 40.0F;
    float A = 40.0F;
    int B = 0;
    boolean C;
    boolean D;
    float E;
    public float F;
    public float G;
    boolean H = false;
    boolean I = false;
    boolean J = false;
    boolean K = false;
    boolean L = false;
    boolean M = false;
    float N = 0.0F;
    float O = 0.0F;
    float P = 0.0F;
    float Q = 0.0F;
    float R = 0.0F;
    float S = 0.0F;
    boolean T = false;
    boolean U = false;
    boolean V = false;
    public Unit W;
    public float X;
    public int Y;
    public float Z;
    public Unit aa;
    public final boolean ab = true;
    public class_226 ac;
    public int ad;
    public boolean ae;
    public float af;
    public float ag;
    public float ah;
    public boolean ai;
    public float aj;
    public float ak;
    public float al;
    public float am;
    public float an;
    public float ao;
    public boolean ap;
    public float aq;
    public float ar;
    public int as;
    public final Paint at = new Paint();
    public Paint au;
    public Paint av;
    public Paint aw;
    public Paint ax;
    public Paint ay;
    public Paint az;
    public Paint aA;
    public Paint aB;
    public Paint aC;
    public Paint aD;
    public Paint aE;
    public Paint aF;
    public Paint aG;
    public Paint aH;
    public Paint aI;
    public Paint aJ;
    Paint aK;
    Paint aL;
    Paint aM;
    Paint aN;
    Paint aO;
    Paint aP;
    class_525 aQ;
    class_525 aR;
    class_525 aS;
    public float aT;
    public float aU = 0.0F;
    public float aV = 0.0F;
    public float aW = 0.0F;
    int aX;
    public float aY = 0.0F;
    public boolean aZ;
    TeamImageCache ba = null;
    TeamImageCache bb = null;
    TeamImageCache bc = null;
    boolean bd;
    float be;
    Paint bf;
    Paint bg;
    TeamImageCache bh = null;
    TeamImageCache bi = null;
    public TeamImageCache bj = null;
    public TeamImageCache bk = null;
    public TeamImageCache bl = null;
    TeamImageCache bm = null;
    public TeamImageCache bn;
    public TeamImageCache bo;
    class_187 bp;
    class_187 bq;
    class_187 br;
    class_187 bs;
    class_187 bt;
    class_187 bu;
    final Rect bv = new Rect();
    final Rect bw = new Rect();
    final Rect bx = new Rect();
    final Rect by = new Rect();
    final Rect bz = new Rect();
    final Paint bA = new Paint();
    final Paint bB = new Paint();
    final Paint bC = new class_525();
    public final Paint bD = new class_525();
    final Paint bE = new class_525();
    final Paint bF = new Paint();
    String bG;
    String bH;
    class_388 bI;
    String bJ;
    String bK;
    String bL;
    public ArrayList bM = new ArrayList();
    private int cf;
    private int cg;
    private int ch;
    private float ci;
    private int cj;
    private int ck;
    private int cl;
    public boolean bN = false;
    public static boolean bO = false;
    public static boolean bP = false;
    public static boolean bQ = false;
    public static boolean bR;
    class_183 bS = class_183.b(-1, -1);
    class_1069 bT = new class_1069();
    long bU = -1L;
    long bV = -1L;
    long bW;
    boolean bX;
    public class_692 bY = new class_692();
    public class_692 bZ = new class_692();
    public static Unit ca;
    Paint cb = new Paint();
    Rect cc = new Rect();
    static int cd = 1;
    static boolean ce;

    public boolean a() {
        if (GameEngine.aw()) {
            return false;
        } else {
            GameEngine var1 = GameEngine.getGameEngine();
            return var1.settingsEngine.useCircleSelect;
        }
    }

    float b() {
        return Math.min(this.w * 2.5F, 290.0F) + 10.0F;
    }

    float c() {
        GameEngine var1 = GameEngine.getGameEngine();
        float var2 = 0.7F;
        if (GameEngine.av()) {
            var2 = 0.9F;
        }

        if (var1.cX < 1.0F) {
            float var3 = var1.cX;
            if ((double)var3 < 0.4) {
                var3 = 0.4F;
            }

            var2 *= var3;
        }

        return var2;
    }

    public void a(String var1, int var2) {
        this.g.a(var1, var2);
    }

    public void b(String var1, int var2) {
        this.g.b(var1, var2);
    }

    public void a(String var1) {
        this.g.a(var1);
    }

    public void b(String var1) {
        this.g.a(var1, 100);
    }

    public void c(String var1) {
        this.g.a(var1, 50);
    }

    public void d(String var1) {
        this.g.a(var1, 5);
    }

    public void d() {
        this.U = false;
        this.V = false;
        this.I = false;
    }

    public boolean a(float var1, float var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        if (bO && !this.g.ap) {
            return var3.bW.c(var1, var2) == null;
        } else {
            return var1 < var3.cl - var3.cq;
        }
    }

    public void e() {
        if (this.g != null) {
            this.g.a();
        }

    }

    public void a(boolean var1) {
        if (var1) {
            this.g.j();
        } else {
            GameEngine var2 = GameEngine.getGameEngine();
            this.g.k();
            this.l();
            this.u = false;
            this.c = false;
            this.d = 0.0F;
            this.bM.clear();
            if (!var1) {
                var2.bt = 1.0F;
                var2.bw = false;
                var2.bv = false;
                var2.bl = false;
                var2.bn = false;
            }

            if (var2.N() && var2.P()) {
                var2.bv = var2.netEngine.p;
            }

            class_517.a();
            K();
        }
    }

    public void f() {
        bO = false;
        bP = false;
        bQ = false;
        if (GameEngine.av()) {
            bO = true;
            bP = true;
            a = true;
            bQ = true;
        }

        if (GameEngine.aY) {
            bO = true;
            bP = true;
            bQ = true;
        }

        if (GameEngine.at() && !GameEngine.getGameEngine().settingsEngine.classicInterface) {
            bO = true;
            bP = true;
            bQ = true;
        }

    }

    public void a(Context var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        if (GameEngine.C()) {
            this.bN = true;
        }

        this.f();
        this.bG = class_1009.a("gui.notAvailableInDemoText");
        this.bH = "Locked";
        this.bI = class_388.b("gui.notEnoughResources");
        this.bJ = class_1009.a("gui.cannotPlace.general");
        this.bK = class_1009.a("gui.cannotPlace.needsResourcePool");
        this.bL = class_1009.a("gui.cannotPlace.needsWater");
        this.g = new class_71(var2, this);
        this.e();
        this.h = new class_531(var2, this);
        this.i = new class_519(var2);
        this.j = new class_533(var2, this);
        this.k = new class_548();
        if (GameEngine.au()) {
            this.b = true;
        }

        this.ba = var2.bO.a(AssetsID$drawable.button_no);
        this.bb = var2.bO.a(AssetsID$drawable.button_yes);
        this.bc = var2.bO.a(AssetsID$drawable.button_more);
        this.bf = new Paint();
        this.bf.d(true);
        this.bg = new Paint();
        this.bg.d(true);
        this.bg.a(40, 255, 255, 255);
        this.bh = var2.bO.a(AssetsID$drawable.button_add);
        this.bi = var2.bO.a(AssetsID$drawable.button_subtract);
        this.bj = var2.bO.a(AssetsID$drawable.icon_rally);
        this.bn = var2.bO.a(AssetsID$drawable.rounded_glow_button);
        this.bo = var2.bO.a(AssetsID$drawable.rounded_white_button);
        this.bp = new class_187(this.bn, 32, 27);
        this.bq = new class_187(var2.bO.a(AssetsID$drawable.rounded_glow_highlight_button), 32, 27);
        this.br = this.bp.a();
        this.br.v = this.bq;
        this.bs = new class_187(var2.bO.a(AssetsID$drawable.rounded_dark_box), 32, 27);
        this.bt = new class_187(var2.bO.a(AssetsID$drawable.rounded_dark_box_titled), 36, 36);
        this.bt.r = new class_187(var2.bO.a(AssetsID$drawable.rounded_shadow), 36, 36);
        this.bt.f = true;
        this.bu = new class_187(var2.bO.a(AssetsID$drawable.rounded_green), 36, 36);
        this.bu.r = this.bt.r;
        this.bu.u = 20;
        this.bk = var2.bO.a(AssetsID$drawable.icon_upgrade);
        this.bl = var2.bO.a(AssetsID$drawable.metal_dark, false);
        this.bm = var2.bO.a(AssetsID$drawable.touch_indicator, false);
        class_186.b();
        this.bE.a(145, 0, 175, 0);
        this.bE.a(6.0F);
        class_525.b(this.bE);
        this.bD.a(true);
        this.au = new Paint();
        this.av = new class_525();
        this.av.a(255, 0, 240, 0);
        this.av.a(true);
        this.av.c(true);
        this.av.a(Typeface.a((Typeface)Typeface.c, 1));
        var2.a(this.av, 20.0F);
        this.av.a(Paint$Align.a);
        this.ay = new class_525();
        this.ay.a(255, 0, 240, 0);
        this.ay.a(true);
        this.ay.c(true);
        this.ay.a(Typeface.a((Typeface)Typeface.c, 1));
        var2.a(this.ay, 18.0F);
        this.ay.a(Paint$Align.a);
        this.aw = new class_525();
        this.aw.a(this.av);
        this.aw.a(255, 240, 240, 0);
        this.ax = new class_525();
        this.ax.b(Color.a(100, 0, 0, 0));
        this.ax.a(Paint$Style.c);
        this.az = new class_525();
        this.az.a(100, 30, 240, 30);
        this.az.a(Paint$Align.a);
        this.az.c(true);
        this.az.a(true);
        var2.a(this.az, 12.0F);
        class_525.b(this.az);
        this.aC = new class_525();
        if (this.bN) {
            this.aC.a(255, 240, 240, 240);
        } else {
            this.aC.a(255, 30, 240, 30);
        }

        this.aC.a(Paint$Align.b);
        this.aC.c(true);
        this.aC.a(true);
        var2.a(this.aC, 12.0F);
        class_525.b(this.aC);
        GameEngine.log("smallTextPaint size: " + this.aC.k());
        this.aB = new class_525();
        this.aB.a(this.aC);
        var2.a(this.aB, 10.0F);
        class_525.b(this.aB);
        this.aA = new class_525();
        this.aA.a(this.aC);
        var2.a(this.aA, 8.0F);
        class_525.b(this.aA);
        this.aD = new class_525();
        if (this.bN) {
            this.aD.a(255, 240, 240, 240);
        } else {
            this.aD.a(255, 30, 240, 30);
        }

        this.aD.a(Paint$Align.b);
        this.aD.c(true);
        this.aD.a(true);
        var2.a(this.aD, 20.0F);
        class_525.b(this.aD);
        this.aE = new class_525();
        this.aE.a(255, 30, 240, 30);
        this.aE.a(Paint$Align.b);
        this.aE.c(true);
        this.aE.a(true);
        var2.a(this.aE, 20.0F);
        class_525.b(this.aE);
        this.aI = new class_525();
        this.aI.a(150, 20, 20, 20);
        var2.a(this.aI);
        class_525.b(this.aI);
        this.aF = new class_525();
        this.aF.a(this.aD);
        this.aF.a(255, 128, 0, 0);
        var2.a(this.aF, 14.0F);
        this.aF.a(Paint$Align.b);
        class_525.b(this.aF);
        this.aG = new class_525();
        this.aG.a(this.aF);
        this.aG.a(255, 220, 222, 49);
        this.aH = new class_525();
        this.aH.a(this.aD);
        var2.a(this.aH, 12.0F);
        this.aH.a(125, 230, 230, 230);
        this.aH.a(Paint$Align.b);
        class_525.b(this.aH);
        this.aQ = new class_525();
        this.aQ.b(-16777216);
        this.aQ.a(true);
        this.aQ.c(true);
        this.aQ.a(Typeface.a((Typeface)Typeface.c, 0));
        var2.a((Paint)this.aQ, 14.0F);
        this.aR = new class_525();
        this.aR.a((Paint)this.aQ);
        this.aR.a(Typeface.a((Typeface)Typeface.c, 1));
        var2.a((Paint)this.aR, 16.0F);
        this.aS = new class_525();
        this.aS.a((Paint)this.aR);
        this.aS.b(Color.a(232, 63, 80));
        var2.a((Paint)this.aS, 16.0F);
        this.aK = new class_525();
        this.aK.b(-16777216);
        this.aK.a(Paint$Align.b);
        this.aK.a(true);
        this.aK.c(true);
        this.aK.a(Typeface.a((Typeface)Typeface.c, 0));
        var2.a(this.aK, 20.0F);
        this.aL = new class_525();
        this.aL.b(-1);
        this.aL.c(160);
        if (GameEngine.av()) {
            this.aL.c(140);
        }

        var2.a(this.aL);
        this.aM = new class_525();
        this.aM.b(-16777216);
        this.aM.c(210);
        var2.a(this.aM);
        this.aP = new class_525();
        this.aP.b(-7829368);
        this.aP.c(240);
        this.aP.a(Paint$Style.b);
        this.aP.a(1.0F);
        var2.a(this.aP);
        this.aN = new class_525();
        this.aN.b(-16711936);
        this.aN.c(80);
        this.aN.a(Paint$Style.a);
        this.aN.a(4.0F);
        var2.a(this.aN);
        this.aO = new class_525();
        this.aO.b(Color.a(120, 235, 167, 49));
        this.aO.a(Paint$Style.a);
        this.aO.a(8.0F);
        var2.a(this.aO);
        this.aJ = new class_525();
        this.aJ.c(true);
        this.aJ.a(true);
        var2.a(this.aJ, 12.0F);
        class_525.b(this.aJ);
    }

    public void g() {
        this.h.b();
        this.i.b();
        this.bX = false;
    }

    public void a(float var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        this.v += (double)var1;
        this.aU = class_340.a(this.aU, var1);
        this.aV = class_340.a(this.aV, var1);
        this.aY = class_340.a(this.aY, 0.08F * var1);
        this.aW = class_340.a(this.aW, var1);
        this.E += var1;
        this.aT += 0.05F * var1;
        if (this.aT > 1.0F) {
            --this.aT;
            if (this.aT > 1.0F) {
                this.aT = 0.0F;
            }
        }

        var2.dx = 4.0F * this.aY;
        float var3 = 1.0F * var1;
        float var4;
        float var5;
        if (!this.I) {
            var4 = this.R * var1;
            var5 = this.S * var1;
            var4 = class_340.g(80.0F, var4);
            var5 = class_340.g(80.0F, var5);
            var2.cy += var4;
            var2.cz += var5;
        } else {
            var3 *= 4.0F;
        }

        var4 = class_340.b(0.0F, 0.0F, this.R, this.S);
        var5 = class_340.d(0.0F, 0.0F, this.R, this.S);
        if (var4 > 30.0F) {
            var4 = 30.0F;
        }

        var4 = class_340.a(var4, var3);
        this.R = class_340.k(var5) * var4;
        this.S = class_340.j(var5) * var4;
        this.aZ = false;
        this.I = var2.ac() && var2.dM[0] && this.aU == 0.0F;
        if (this.aV != 0.0F) {
            if (!this.I) {
                this.aV = 0.0F;
            }

            this.I = false;
            this.H = false;
        }

        boolean var6 = false;
        if (this.aW > 0.0F) {
            var6 = true;
        }

        if (var2.ac() && var2.ae() > 1) {
            var6 = true;
            this.aW = 4.0F;
        }

        if (var6) {
            this.I = false;
            this.H = false;
            this.T = false;
            this.w = 0.0F;
        }

        this.M = false;
        this.L = var2.af() > var2.cF;
        this.U = !this.I && this.H;
        this.V = this.I && !this.H;
        if (GameEngine.av() && var2.settingsEngine.mouseSupport) {
            this.z = var2.af();
            this.A = var2.ag();
        }

        if (!this.I && !this.U) {
            this.D = false;
        }

        float var8;
        float var9;
        if (this.I) {
            this.w += var1;
            this.x = var2.b(0);
            this.y = var2.c(0);
            this.z = this.x;
            this.A = this.y;
            this.B = var2.d(0);
            this.C = this.a(this.x, this.y);
            boolean var7 = false;
            if (this.C && !this.H) {
                if (this.E < 30.0F) {
                    var8 = class_340.a(this.F, this.G, this.x, this.y);
                    var9 = 10.0F * var2.cj;
                    if (GameEngine.au()) {
                        var9 = (float)((double)var9 * 1.5);
                    }

                    if (var8 < var9 * var9) {
                        var7 = true;
                    }
                }

                this.E = 0.0F;
                this.F = this.x;
                this.G = this.y;
            }

            if (var7) {
                this.D = true;
            }

            if (!this.H) {
                this.T = false;
                this.N = this.x;
                this.O = this.y;
                this.P = this.x;
                this.Q = this.y;
                this.J = var2.bW.c(this.x, this.y) != null;
                this.K = false;
                if (!this.J) {
                    this.K = this.x > var2.cF;
                }
            }

            this.H = true;
        }

        float var16;
        boolean var18;
        if (this.I && (this.w <= 20.0F || !this.a())) {
            var16 = class_340.a(this.N, this.O, this.x, this.y);
            if (!this.J) {
                var8 = 30.0F * var2.cj;
                if (GameEngine.av() && var2.settingsEngine.mouseSupport && var2.e(3)) {
                    var8 = 0.0F;
                }

                if (!this.T && var16 > var8 * var8) {
                    var18 = false;
                    byte var10 = 1;
                    if (var2.settingsEngine.mouseOrders == 2) {
                        var10 = 2;
                    }

                    if ((!var2.settingsEngine.mouseSupport || this.B != var10) && !this.c(var2)) {
                        var18 = true;
                    }

                    if (var18) {
                        this.T = true;
                    }

                    this.P = this.x;
                    this.Q = this.y;
                }
            }
        }

        if (GameEngine.av() && !var2.aq && var2.ao != null && (var2.ao.f() || GameEngine.aR) && (!this.I || this.g.c)) {
            var16 = 24.0F * var2.settingsEngine.edgeScrollSpeed / var2.cX;
            var8 = var2.cy;
            var9 = var2.cz;
            float var21 = 0.0F;
            float var11 = 0.0F;
            if (this.z <= 1.0F) {
                var21 -= var16 * var1;
            }

            if (this.z >= var2.cl - 1.0F) {
                var21 += var16 * var1;
            }

            if (this.A <= 1.0F) {
                var11 -= var16 * var1;
            }

            if (this.A >= var2.cm - 1.0F) {
                var11 += var16 * var1;
            }

            var2.cy += var21;
            var2.cz += var11;
            var2.Q();
            RectF var10000 = this.g.y;
            var10000.a -= (var2.cy - var8) * var2.cX;
            var10000 = this.g.y;
            var10000.b -= (var2.cz - var9) * var2.cX;
        }

        class_985 var17 = var2.bT;
        if (var2.settingsEngine.keyboardSupport) {
            if (var2.E()) {
                var8 = 12.0F * var2.settingsEngine.scrollSpeed;
                if (var17.p.b()) {
                    var2.cy -= var8 * var1;
                }

                if (var17.q.b()) {
                    var2.cy += var8 * var1;
                }

                if (var17.n.b()) {
                    var2.cz -= var8 * var1;
                }

                if (var17.o.b()) {
                    var2.cz += var8 * var1;
                }

                if (var17.r.b()) {
                    var2.cV += 0.1F;
                }

                if (var17.s.b()) {
                    var2.cV -= 0.1F;
                }
            }

            if (var17.y.a()) {
                this.l();
                this.y();
            }

            if (var17.z.a()) {
                this.i.d();
            }

            Iterator var19;
            GameObject var22;
            OrderableUnit var25;
            if (var17.A.a()) {
                this.l();
                this.y();
                var19 = GameObject.er.iterator();

                while(var19.hasNext()) {
                    var22 = (GameObject)var19.next();
                    if (var22 instanceof OrderableUnit) {
                        var25 = (OrderableUnit)var22;
                        if (!var25.bV && var25.bX == var2.playerTeam && var25.l() && !var25.ak() && var25.aS() && var25.cN == null) {
                            this.j(var25);
                        }
                    }
                }
            }

            if (var17.B.a()) {
                this.l();
                this.y();
                var19 = GameObject.er.iterator();

                while(var19.hasNext()) {
                    var22 = (GameObject)var19.next();
                    if (var22 instanceof OrderableUnit) {
                        var25 = (OrderableUnit)var22;
                        if (var25.bX == var2.playerTeam && var25.r() == UnitType.commandCenter && !var25.bV && var25.cN == null) {
                            this.j(var25);
                            var2.b(var25.xCord, var25.yCord);
                        }
                    }
                }
            }

            if (var17.C.a()) {
                class_501.a(this.bM, class_501.a, class_501.b);
            }

            if (var17.D.a()) {
                class_501.a(this.bM, class_501.c, (class_501)null);
            }

            if (var17.E.a()) {
                class_501.a(this.bM, class_501.d, (class_501)null);
            }

            if (var17.F.a()) {
                class_501.a(this.bM, class_501.e, (class_501)null);
            }

            if (var17.G.a()) {
                class_501.a(this.bM, class_501.f, (class_501)null);
            }

            if (var17.x.a()) {
                this.g.a(12);
            }

            if (var17.N.a() && this.B() && this.C()) {
                this.l();
                this.aa = null;
                this.ac = this.l;
                return;
            }

            if (var17.P.a() && this.A()) {
                this.l();
                this.aa = null;
                this.ac = this.m;
                return;
            }

            if (var17.Q.a() && this.C()) {
                this.l();
                this.aa = null;
                this.ac = this.n;
                return;
            }

            if (var17.O.a()) {
                this.v();
            }

            if (var17.v.a()) {
                this.I();
            }

            if (var17.t.a() && var2.N()) {
                GameEngine.log("showing send chat");
                this.g.a(13);
            }

            if (var17.u.a() && var2.N()) {
                GameEngine.log("showing send team chat");
                this.g.a(16);
            }

            if (!var2.P() && !var2.replayEngine.j()) {
                if (var17.L.a() && var2.netEngine.isServer && var2.netEngine.ingame) {
                    var2.netEngine.e(!var2.netEngine.al);
                }
            } else {
                if (var17.L.a()) {
                    if (var2.bt != 0.0F) {
                        if (!var2.replayEngine.j()) {
                            GameNetEngine.a((String)null, (String)"Game paused");
                        }

                        var2.bt = 0.0F;
                    } else {
                        var2.bt = 1.0F;
                    }
                }

                boolean var20 = var17.J.a();
                var18 = var17.K.a();
                if (var20 || var18) {
                    boolean var27;
                    if (var20) {
                        var27 = var2.bt > 1.0F;
                        if (var2.bt < 2.0F) {
                            var2.bt = (float)((double)var2.bt - 0.25);
                        } else if (var2.bt < 6.0F) {
                            var2.bt = (float)((double)var2.bt - 0.5);
                        } else if (var2.bt < 16.0F) {
                            var2.bt -= 2.0F;
                        } else {
                            var2.bt -= 4.0F;
                        }

                        if (var2.bt < 0.0F) {
                            var2.bt = 0.0F;
                        }

                        if (var27 && var2.bt < 1.0F) {
                            var2.bt = 1.0F;
                        }
                    } else if (var18) {
                        var27 = var2.bt < 1.0F;
                        if (var2.bt < 2.0F) {
                            var2.bt = (float)((double)var2.bt + 0.25);
                        } else if (var2.bt < 6.0F) {
                            var2.bt = (float)((double)var2.bt + 0.5);
                        } else if (var2.bt < 16.0F) {
                            var2.bt += 2.0F;
                        } else {
                            var2.bt += 4.0F;
                        }

                        if (var2.replayEngine.j()) {
                            if (var2.bt > 64.0F) {
                                var2.bt = 64.0F;
                            }
                        } else if (var2.bt > 5.0F) {
                            var2.bt = 5.0F;
                        }

                        if (var27 && var2.bt > 1.0F) {
                            var2.bt = 1.0F;
                        }
                    }

                    if (!var2.replayEngine.j()) {
                        GameNetEngine.a((String)null, (String)("Game speed now: " + var2.bt));
                    }
                }
            }

            var2.cT = class_340.a(var2.cT, var1);
            if (var17.Y.a()) {
                var2.cT = 180.0F;
            }

            if (var2.bv && var17.ab.a()) {
                var2.bl = !var2.bl;
                GameEngine.log("debugTempMode now: " + var2.bl);
                this.b("debug: " + var2.bl);
            }

            if (var2.bv && var2.bl && var17.ac.a()) {
                class_138.as = !class_138.as;
                this.b("AI debug view: " + class_138.as);
            }

            if (var2.bv && var2.bl && var17.ad.a()) {
                class_70.a = !class_70.a;
                this.b("Map debug: " + class_70.a);
            }

            if (var2.P() || var2.replayEngine.j()) {
                if (var2.bv) {
                    if (var17.V.a()) {
                        var2.bp = !var2.bp;
                    }

                    if (var17.W.a()) {
                        if (var2.bt == 1.0F) {
                            var2.bt = 0.1F;
                        } else {
                            var2.bt = 1.0F;
                        }
                    }

                    if (var17.X.a()) {
                        GameEngine.log("Adding test popup");
                        var2.netEngine.U();
                    }

                    if (var17.Z.a()) {
                        var2.bw = !var2.bw;
                    }

                    if (var17.aa.a()) {
                        var19 = GameObject.er.iterator();

                        while(var19.hasNext()) {
                            var22 = (GameObject)var19.next();
                            if (var22 instanceof OrderableUnit) {
                                var25 = (OrderableUnit)var22;
                                if (var25.cG) {
                                    var25.U();
                                }
                            }
                        }
                    }
                }

                if (var17.U.a()) {
                    var2.bv = !var2.bv;
                    if (var2.bv) {
                        this.y();
                    }
                }
            }
        }

        if (var2.bv && !var2.P() && !var2.replayEngine.j()) {
            var2.bv = false;
        }

        if (var2.bv) {
            if (this.f != null && (this.f.ej || this.f.bV)) {
                this.f = null;
            }

            if (this.f == null) {
                GameEngine.log("Creating new debug editor");
                this.f = new EditorOrBuilder(false);
                this.f.b(var2.playerTeam);
            }

            if (this.q() == 0) {
                this.y();
                this.j(this.f);
            }

            if (var2.settingsEngine.liveReloading && var2.tick % 100 == 0 && !var2.replayEngine.i()) {
                class_436.c();
            }
        } else {
            if (this.f != null && (this.f.ej || this.f.bV)) {
                this.f = null;
            }

            if (this.f != null && !var2.replayEngine.j()) {
                this.h();
            }
        }

        if (this.T) {
            if (this.K) {
                this.g.ao = this.Q - this.y;
            } else {
                byte var23 = 1;
                if (var2.settingsEngine.mouseOrders == 2) {
                    var23 = 2;
                }

                if ((!var2.settingsEngine.mouseSupport || this.B != var23) && !this.c(var2)) {
                    SettingsEngine var26 = var2.settingsEngine;
                    double var28 = (double)(this.P - this.x);
                    double var12 = (double)(this.Q - this.y);
                    float var14 = class_340.b(0.0F, 0.0F, (float)var28, (float)var12);
                    var28 = var28 * (double)var26.scrollSpeed / (double)var2.cX;
                    var12 = var12 * (double)var26.scrollSpeed / (double)var2.cX;
                    if (var1 != 0.0F && (double)var14 > 50.0 * (double)var1) {
                        float var15 = 0.7F;
                        if (GameEngine.av()) {
                            var15 = 1.7F;
                        }

                        this.R = (float)(var28 * (double)var15);
                        this.S = (float)(var12 * (double)var15);
                    }

                    var2.cy = (float)((double)var2.cy + var28 * 2.0);
                    var2.cz = (float)((double)var2.cz + var12 * 2.0);
                }
            }

            this.P = this.x;
            this.Q = this.y;
        }

        if (var2.settingsEngine.mouseSupport && (this.bS.a != (int)var2.af() || this.bS.b != (int)var2.ag())) {
            this.bS.a = (int)var2.af();
            this.bS.b = (int)var2.ag();
            this.s.b(this.bS);
        }

        if (this.U && this.J()) {
            class_183 var24 = class_183.a((int)this.z, (int)this.A);
            this.s.b(var24);
        }

        this.s.b(var1);
        this.k.a(var1);
    }

    public void h() {
        if (this.f != null) {
            this.l(this.f);
            this.f.ci();
            this.f = null;
        }

    }

    public EditorOrBuilder i() {
        return this.f;
    }

    public void a(EditorOrBuilder var1) {
        this.f = var1;
    }

    public boolean a(GameEngine var1) {
        return !var1.settingsEngine.keyboardSupport ? false : var1.c(59, 60);
    }

    public boolean b(GameEngine var1) {
        return !var1.settingsEngine.keyboardSupport ? false : var1.c(113, 114);
    }

    public boolean c(GameEngine var1) {
        return !var1.settingsEngine.keyboardSupport ? false : var1.c(57, 58);
    }

    public void b(float var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        this.Z += 0.2F * var1;
        if (this.Z > 360.0F) {
            this.Z -= 360.0F;
        }

        this.bx.a((int)(var2.cl - var2.cq), 0, (int)var2.cl, (int)var2.cm);
        if (!bO) {
            if (this.bN) {
                this.bA.a();
                this.bA.b(Color.a(255, 33, 40, 52));
                this.bA.a(Paint$Style.a);
                var2.bO.b(this.bx, this.bA);
            } else {
                var2.bO.a(this.bl, this.bx, (Paint)null);
            }

            this.bA.a();
            this.bA.b(Color.a(255, 0, 0, 0));
            this.bA.a(Paint$Style.b);
            var2.bO.b(this.bx, this.bA);
        }

        this.cf = 0;
        this.ch = 0;
        this.cg = 0;
        this.ck = this.cl;
        this.cl = 0;
        OrderableUnit var3;
        if (var2.replayEngine.j() || var2.playerTeam != null && var2.playerTeam.b()) {
            var3 = this.s();
            if (var3 != null) {
                this.a(var2, var3.bX, false, true);
            }
        } else {
            var3 = this.t();
            if (var2.playerTeam != null && var2.playerTeam != PlayerData.i && !var2.playerTeam.b() && !var2.replayEngine.j()) {
                this.a(var2, var2.playerTeam, false, true);
            }

            if (var3 != null && var2.playerTeam != var3.bX && this.m(var3)) {
                this.a(var2, var3.bX, true, true);
            }
        }

        if (var2.bv && !var2.replayEngine.j()) {
            String var8 = "";
            if (var2.bv) {
                var8 = var8 + "Editor Active\n";
            }

            if (var2.bt != 1.0F) {
                var8 = var8 + "Game Speed: " + var2.bt + "x\n";
            }

            if (var2.bw) {
                var8 = var8 + "Invincible Units\n";
            }

            boolean var4 = false;
            Iterator var5 = PlayerData.c().iterator();

            while(var5.hasNext()) {
                PlayerData var6 = (PlayerData)var5.next();
                if (var6 instanceof class_138) {
                    class_138 var7 = (class_138)var6;
                    var4 = var7.bG > 0.0F;
                }
            }

            if (var4) {
                var8 = var8 + "AIs frozen\n";
            }

            this.bA.a();
            this.bA.b(Color.a(0, 0, 0, 0));
            this.bA.a(Paint$Style.a);
            float var9 = 70.0F * var2.cj;
            float var10 = 40.0F;
            if (var2.cl < 600.0F && var2.cm > 650.0F) {
                var9 = 10.0F;
                var10 = 60.0F * var2.cj;
            }

            var2.bO.a(var8, var9, var10, this.ay, this.bA, 6.0F);
        }

        this.j();
        this.s.f();
    }

    public void j() {
        GameEngine var1 = GameEngine.getGameEngine();
    }

    public void a(GameEngine var1, PlayerData var2, boolean var3, boolean var4) {
        if (var2.n) {
            this.a(var1, var2, var3, CreditsResource.D, var2.aa(), (class_1069)null, 0, (BuiltInResource)null);
        }

        if (var4) {
            this.bT.g(var2.ab());
            ArrayList var5 = BuiltInResource.f();
            Iterator var6 = var5.iterator();

            while(true) {
                BuiltInResource var7;
                do {
                    do {
                        if (!var6.hasNext()) {
                            this.bT.e();
                            this.a(var1, var2, var3, this.bT);
                            return;
                        }

                        var7 = (BuiltInResource)var6.next();
                    } while(!var7.d());
                } while(!var7.p && !var7.j);

                this.bT.c(var7);
            }
        }
    }

    public void a(GameEngine var1, PlayerData var2, boolean var3, class_1069 var4) {
        Iterator var5 = var4.b.iterator();

        while(var5.hasNext()) {
            class_1067 var6 = (class_1067)var5.next();
            if (!var6.a.a()) {
                BuiltInResource var7 = var6.a;
                double var8 = var6.b;
                this.a(var1, var2, var3, var7, var8, var4, 0, (BuiltInResource)null);
            }
        }

    }

    public boolean a(GameEngine var1, PlayerData var2, boolean var3, BuiltInResource var4, double var5, class_1069 var7, int var8, BuiltInResource var9) {
        if (var8 == 0) {
            this.cj = 0;
        }

        boolean var10 = false;
        if (var8 < 6 && var7 != null) {
            BuiltInResource var11 = var4.i;
            if (var11 != null && (var4.j || var5 != 0.0)) {
                double var12 = var7.a(var11);
                boolean var14 = this.a(var1, var2, var3, var11, var12, var7, var8 + 1, var4);
                if (var14) {
                    var10 = true;
                }
            }
        }

        if ((var5 != 0.0 || var4.p) && (var8 != 0 || var4.l)) {
            byte var35 = 6;
            String var36 = var4.a(var5, true);
            int var13 = var2.b(var4);
            int var37 = var2.a(var4);
            if (var37 != 0) {
                var36 = var36 + "(+" + var13 + ")(-" + var37 + ")";
            } else if (var13 != 0) {
                if (var13 >= 0) {
                    var36 = var36 + "(+" + var13 + ")";
                } else {
                    var36 = var36 + "(" + var13 + ")";
                }
            }

            int var15 = (int)(var1.cl - var1.cq);
            var15 -= this.cj;
            Paint var16 = this.av;
            if (var3) {
                var16 = this.aw;
            } else {
                Integer var17 = var4.h();
                if (var17 != null) {
                    this.at.a(var16);
                    var16 = this.at;
                    var16.b(var17);
                }
            }

            float var38 = (float)var1.bO.b(var36, var16);
            float var18 = (float)var1.bO.a(var36, var16);
            this.ci = var18 + (float)var35;
            if ((float)this.cl < var38) {
                this.cl = (int)var38;
            }

            int var19 = this.ch;
            if (var4.w) {
                var19 = 0;
            }

            int var20 = 0;
            int var21 = 0;
            if (var19 == 0) {
                var20 = this.cg;
            } else {
                var21 = this.cf;
            }

            int var22 = 0;
            byte var23 = var35;
            int var24 = var35;
            byte var25 = var35;
            boolean var27 = false;
            float var28 = var38 + (float)var35 + (float)var35;
            if (var4.k) {
                var28 += 80.0F;
            }

            if ((float)var15 < var28 && var4.i != null) {
                var27 = true;
                this.cf = (int)((float)this.cf + this.ci);
                var21 = this.cf;
                var15 += this.cj;
                this.cj = 0;
            }

            if (var19 != 0) {
                var23 = 0;
            }

            if (var9 != null && !var9.k) {
                var24 = 0;
            }

            if (var10 && !var4.k) {
                var15 += var35;
                var25 = 0;
            }

            if (var10 && var4.k && !var27) {
                var22 = var1.bO.b("AA", var16);
            }

            var15 -= var22;
            TeamImageCache var29 = var4.k();
            float var30 = 1.0F;
            float var31;
            float var32;
            if (var29 != null) {
                var32 = var18 - 3.0F;
                if (var32 < 3.0F) {
                    var32 = 3.0F;
                }

                var30 = class_550.a(var29, var18 * 3.0F, var32);
                var31 = (float)var29.p * var30 + 3.0F;
                var24 += (int)var31;
            } else {
                var31 = 0.0F;
            }

            var32 = (float)var15 - var38 - (float)var20;
            class_550.a(var36, var32 - (float)var35, (float)(var21 + var35), var16, this.ax, (float)var24, (float)var23, (float)var25, (float)var35);
            if (var29 != null) {
                int var33 = (int)(var32 - var31 / 2.0F - (float)var29.r * var30 - 3.0F);
                int var34 = (int)((float)(var21 + var35) + var18 / 2.0F - (float)var29.s * var30);
                var1.bO.a(var29, (float)var33, (float)var34, this.bD, 0.0F, var30);
            }

            if (var8 == 0) {
                if (var19 == 0) {
                    this.cg = (int)((float)this.cg + var38 + (float)var25 + (float)var24);
                }

                if (this.ch == var19) {
                    this.cf = (int)((float)this.cf + this.ci);
                    ++this.ch;
                }
            }

            this.cj = (int)((float)this.cj + var38 + (float)var25 + (float)var24 + (float)var22);
            return true;
        } else {
            return var10;
        }
    }

    public boolean k() {
        return this.a(class_553.b, true);
    }

    public boolean b(boolean var1) {
        return this.a(var1 ? class_553.a : class_553.b, false);
    }

    public boolean a(class_553 var1) {
        return this.a(var1, false);
    }

    public boolean a(class_553 var1, boolean var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        if (GameEngine.av() && !var2) {
            return false;
        } else {
            boolean var4 = false;
            this.bd = true;
            float var5 = var3.cj * 0.6F;
            int var6 = (int)(100.0F * var5);
            int var7 = (int)(10.0F * var5);
            int var8 = (int)(var3.cm - (float)((int)(9.0F * var5)) - (float)var6 * this.be);
            if (bR) {
                var8 = (int)((float)var8 - var3.bW.d);
            }

            int var9;
            if (var1 == class_553.c) {
                var9 = (int)(20.0F * var5) + var6;
                var9 += (int)(20.0F * var5) + var6;
                this.by.a(var7 + var9, var8, var7 + var9 + var6, var8 + var6);
                var3.bO.a(this.bc, (float)this.by.a, (float)this.by.b, this.bf, 0.0F, var5);
            } else if (var1 == class_553.a) {
                this.by.a(var7, var8, var7 + var6, var8 + var6);
                var3.bO.a(this.bb, (float)this.by.a, (float)this.by.b, this.bf, 0.0F, var5);
            } else {
                var9 = (int)(20.0F * var5) + var6;
                this.by.a(var7 + var9, var8, var7 + var9 + var6, var8 + var6);
                var3.bO.a(this.ba, (float)this.by.a, (float)this.by.b, this.bf, 0.0F, var5);
            }

            boolean var10 = false;
            class_340.a(this.by, 10.0F * var5);
            if (this.U && !this.T && this.by.b((int)this.x, (int)this.y)) {
                var10 = true;
            }

            this.a((float)this.by.a, (float)this.by.b, (float)this.by.b(), (float)this.by.c());
            return var10;
        }
    }

    public boolean l() {
        GameEngine var1 = GameEngine.getGameEngine();
        if (this.ac != null) {
            if (this.ac.e() == class_1052.placeBuilding) {
                this.ac = null;
                this.ae = false;
                this.ai = false;
                this.aa = null;
                this.ap = false;
                ++this.ad;
            } else {
                this.ac = null;
            }

            this.as = 0;
            return true;
        } else {
            return false;
        }
    }

    public void c(float var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        Point var3 = var2.bW.c(this.x, this.y);
        float var4;
        float var5;
        if (var3 != null) {
            var4 = (float)var3.a;
            var5 = (float)var3.b;
        } else {
            var4 = this.x / var2.cX + var2.cw;
            var5 = this.y / var2.cX + var2.cx;
        }

        this.af = class_340.a(this.af, var1);
        this.bx.a((int)(var2.cl - var2.cq), 0, (int)var2.cl, (int)var2.cm);
        if (!bO && (this.U || this.I) && this.bx.b((int)this.x, (int)this.y)) {
            this.aZ = true;
        }

        this.g.a(var1);
        this.g.b(var1);
        this.X += var1;
        if (!var2.A()) {
            int var6 = this.g.d(var1);
            this.g.a(var1, var6);
            this.g.e(var1);
            this.h.a(var1, class_531.a);
            this.i.a(var1);
            int var7 = Math.max((int)((float)this.cf + this.ci * 2.0F), 130);
            this.j.a(var1, var7);
            if (this.u) {
                this.g.c(var1);
            }

            this.k.b(var1);
            this.g.a(var1, true);
        }

        this.a(var1, var4, var5, var3);
        if (!var2.A() && !this.u) {
            this.g.c(var1);
        }

        boolean var14 = false;
        if (!this.T) {
            boolean var15 = true;
            boolean var8 = true;
            boolean var9 = true;
            if (GameEngine.av() && var2.settingsEngine.mouseSupport) {
                if (var2.settingsEngine.mouseOrders == 0) {
                    var15 = true;
                } else {
                    var15 = false;
                    var8 = false;
                    var9 = false;
                    if (var2.settingsEngine.mouseOrders == 1) {
                        if (var2.e(1)) {
                            var8 = true;
                        } else if (var2.e(2)) {
                            var9 = true;
                        }
                    } else if (var2.e(2)) {
                        var8 = true;
                    } else if (var2.e(1)) {
                        var9 = true;
                    }
                }
            }

            if (this.I && var3 != null && this.J) {
                boolean var12 = false;
                if (!var15 && !var9) {
                    var12 = true;
                }

                if (this.q() == 0 || !this.C()) {
                    var12 = true;
                }

                if (var15 && this.w > 20.0F) {
                    var12 = true;
                }

                if (var12) {
                    var2.b(var4, var5);
                    var14 = true;
                }
            }

            if ((this.C || var3 != null && (var15 || var9)) && !var14 && this.ac == null && this.U) {
                if (this.w > 30.0F) {
                    if (this.a() && var3 == null) {
                        float var19 = this.b();
                        var19 /= var2.cX;
                        this.y();
                        this.b(var4, var5, var19);
                        this.E();
                    }
                } else {
                    var2.cU = false;
                    Unit var21;
                    if (!var15) {
                        if (var8) {
                            var21 = null;
                            if (var3 == null) {
                                var21 = this.a(var4, var5, true);
                            }

                            this.a(var21);
                        } else if (var9) {
                            var21 = null;
                            if (var3 == null) {
                                var21 = this.a(var4, var5, false);
                            }

                            boolean var13 = false;
                            if (var21 == null) {
                                var13 = true;
                            } else if (!this.a(var21, false, var4, var5, var3)) {
                                var13 = true;
                            }

                            if (var13) {
                                this.c(var4, var5, var3);
                            }
                        }
                    } else {
                        var21 = null;
                        Unit var20 = null;
                        if (var3 == null) {
                            var21 = this.a(var4, var5, true);
                            var20 = this.a(var4, var5, false);
                        }

                        if (var21 == null && var20 == null) {
                            this.c(var4, var5, var3);
                        } else if (var20 != null) {
                            if (!this.a(var20, true, var4, var5, var3)) {
                                if (!var20.t()) {
                                    this.a(var20);
                                } else if (var21 != null) {
                                    this.a(var21);
                                }
                            }
                        } else {
                            this.a(var21);
                        }
                    }
                }
            }
        }

        if (this.ac == null && this.I && !this.T && !this.J && !this.aZ) {
            this.au.a(Paint$Style.a);
            this.au.a(1.0F);
            if (this.w > 20.0F && this.a()) {
                float var16 = this.b();
                this.au.a(100, 0, 255, 0);
                var2.bO.a(this.x, this.y, var16, this.au);
                this.au.a(Paint$Style.b);
                this.au.a(1.0F);
                this.au.a(200, 0, 255, 0);
                var2.bO.a(this.x, this.y, var16, this.au);
            }
        }

        if (var2.bk && var2.ac() && var2.ae() > 0) {
            Paint var17 = new Paint();
            var17.c(100);

            for(int var18 = 0; var18 < var2.ae(); ++var18) {
                var2.bO.i();
                var2.bO.a(0.7F, 0.7F, var2.b(var18), var2.c(var18));
                var2.bO.a(this.bm, var2.b(var18), var2.c(var18), var17);
                var2.bO.j();
            }
        }

        if (!this.I) {
            this.w = 0.0F;
            this.T = false;
        }

        this.H = this.I;
        var2.ad();
        if (ce) {
            K();
            ce = false;
        }

    }

    public void a(float var1, float var2, float var3, Point var4) {
        GameEngine var5 = GameEngine.getGameEngine();
        Object var6 = this.g.f();
        if (this.bd) {
            this.be = class_340.a(this.be, 1.0F, 0.05F * var1);
            this.be = (float)((double)this.be + 0.08 * (double)(1.0F - this.be));
        } else {
            this.be = class_340.a(this.be, 0.0F, 0.3F * var1);
        }

        this.bd = false;
        if (this.ac != null) {
            if (this.ac instanceof class_230) {
                class_230 var7 = (class_230)this.ac;
                if (var7.b != null) {
                    var6 = var7.b;
                }
            }

            Unit var14;
            if (this.ac.e() == class_1052.reclaimTarget) {
                this.a(this.ac, false, (Unit)var6, false, true);
                if (!this.b(false) && !this.n()) {
                    if (this.U && !this.T && !this.m()) {
                        var14 = this.a(var2, var3, false);
                        if (var14 != null && this.ac.o(var14)) {
                            this.b(var14);
                            if (!this.a(var5)) {
                                this.l();
                            }
                        } else {
                            this.a(var2, var3, 0.0F);
                        }

                        this.U = false;
                    }
                } else {
                    this.l();
                    this.U = false;
                }
            } else if (this.ac.e() == class_1052.repairTarget) {
                this.a(this.ac, false, (Unit)var6, false, true);
                if (!this.b(false) && !this.n()) {
                    if (this.U && !this.T && !this.m()) {
                        var14 = this.a(var2, var3, true);
                        if (var14 != null && this.ac.o(var14)) {
                            this.d(var14);
                            if (!this.a(var5)) {
                                this.l();
                            }
                        } else {
                            this.a(var2, var3, 0.0F);
                        }

                        this.U = false;
                    }
                } else {
                    this.l();
                    this.U = false;
                }
            } else if (this.ac.e() == class_1052.setRally) {
                this.a(this.ac, false, (Unit)var6, false, true);
                if (!this.b(false) && !this.n()) {
                    if (this.U && !this.T && !this.m()) {
                        this.b(var2, var3);
                        this.l();
                        this.U = false;
                    }
                } else {
                    this.l();
                    this.U = false;
                }
            } else if (this.ac.e() == class_1052.targetGround) {
                this.a(this.ac, false, (Unit)var6, false, true);
                Object var15 = this.g.f();
                class_226 var8 = this.ac;
                if (this.ac instanceof class_230) {
                    class_230 var9 = (class_230)var8;
                    if (var9.b != null) {
                        var15 = var9.b;
                    }

                    var8 = var9.a;
                }

                boolean var16 = this.k();
                boolean var10 = this.U && !this.M && this.C && !this.T && !this.m();
                if (this.ac.p()) {
                    if (GameEngine.aw()) {
                        var10 = this.o() && !this.M && this.C && !this.K && this.J();
                    } else {
                        var10 = this.I && !this.M && this.C && !this.K && this.J();
                    }
                }

                boolean var11;
                if (var15 != null && var15 instanceof OrderableUnit) {
                    var5.bO.i();
                    var5.R();
                    var11 = this.I && !this.T && !this.M && !this.K && var4 == null;
                    float var12 = var2;
                    float var13 = var3;
                    if (GameEngine.aw() && var5.settingsEngine.mouseSupport) {
                        var12 = var5.af() / var5.cX + var5.cw;
                        var13 = var5.ag() / var5.cX + var5.cx;
                        var11 = true;
                        if (this.M) {
                            var11 = false;
                        }
                    }

                    if (!this.a(this.z, this.A)) {
                        var11 = false;
                    }

                    ((OrderableUnit)var15).a(var8, var11, var12, var13);
                    var5.bO.j();
                }

                if (!var16 && !this.n()) {
                    if (var10 && var4 == null) {
                        var11 = false;
                        if (this.a(this.ac, var2, var3)) {
                            var11 = true;
                        }

                        if (!var11) {
                            this.b(this.ac, var2, var3);
                            if (!this.a(var5) && !this.ac.o()) {
                                this.l();
                            }
                        } else {
                            this.a(var2, var3, 0.0F);
                        }

                        this.U = false;
                    }
                } else {
                    this.l();
                    this.U = false;
                }
            } else if (this.ac.e() == class_1052.attackMove) {
                this.a(this.ac, false, (Unit)var6, false, true);
                if (!this.b(false) && !this.n()) {
                    if (this.U && !this.T && !this.m()) {
                        this.d(var2, var3, var4);
                        if (!this.a(var5)) {
                            this.l();
                            this.U = false;
                        }
                    }
                } else {
                    this.l();
                    this.U = false;
                }
            } else if (this.ac.e() == class_1052.guardUnit) {
                this.a(this.ac, false, (Unit)var6, false, true);
                if (!this.b(false) && !this.n()) {
                    if (this.U && !this.T && !this.m()) {
                        var14 = this.a(var2, var3, true);
                        if (var14 != null && this.ac.o(var14)) {
                            this.e(var14);
                            this.l();
                        } else {
                            this.a(var2, var3, 0.0F);
                        }

                        this.U = false;
                    }
                } else {
                    this.l();
                    this.U = false;
                }
            } else if (this.ac.e() == class_1052.patrol) {
                this.a(this.ac, false, (Unit)var6, false, true);
                if (!this.a(class_553.a, true) && !this.n()) {
                    if (this.U && !this.T && !this.m()) {
                        this.a(var2, var3, var4, this.as == 0);
                        ++this.as;
                    }
                } else {
                    this.l();
                    this.U = false;
                }
            } else if (this.ac.e() == class_1052.pingMap) {
                this.a(this.ac, false, (Unit)var6, false, true);
                if (!this.k() && !this.n()) {
                    if (this.U && !this.T && !this.m() && var4 == null) {
                        if (this.ac instanceof class_233) {
                            this.a(var2, var3, var4, (class_233)this.ac);
                        } else {
                            GameEngine.print("orderBuildingSpecialAction is not a PingMapAction, it is: " + this.ac.getClass().getName());
                        }

                        this.l();
                        this.U = false;
                    }
                } else {
                    this.l();
                    this.U = false;
                }
            } else if (this.ac.i() != null && this.ac.e() == class_1052.placeBuilding) {
                this.a(var2, var3, var4);
            }
        }

    }

    public strictfp void a(float var1, float var2, Point var3) {
        GameEngine var4 = GameEngine.getGameEngine();
        Unit var5 = this.g.f();
        boolean var6 = false;
        if (var5 != null) {
            class_226 var7 = var5.a(this.ac.N());
            if (var7 != null) {
                var6 = this.ac.a(var5, true) && !class_71.a(this.ac);
                if (!this.ac.b(var5)) {
                    var6 = false;
                }
            }
        }

        this.a(this.ac, false, var5, !var6, true);
        float var57 = this.z / var4.cX;
        float var8 = this.A / var4.cX;
        float var9 = var57;
        float var10 = var8;
        boolean var11 = false;
        boolean var12 = false;
        boolean var13 = false;
        boolean var14 = false;
        if (GameEngine.aw() && var4.settingsEngine.mouseSupport) {
            var11 = true;
            var14 = this.L;
        }

        if (var11) {
            if (this.o()) {
                if (!this.ap) {
                    this.ap = true;
                    this.an = var57 + var4.cw;
                    this.ao = var8 + var4.cx;
                }
            } else {
                this.ap = false;
            }

            if (this.ap) {
                float var15 = var57 - (this.an - var4.cw);
                float var16 = var8 - (this.ao - var4.cx);
                if (class_340.c(var15) > 4.0F || class_340.c(var16) > 4.0F) {
                    var12 = true;
                }
            }
        }

        boolean var58 = false;
        boolean var59 = false;
        boolean var17 = false;
        boolean var18 = false;
        boolean var19 = true;
        boolean var20 = false;
        if (GameEngine.av() && var4.settingsEngine.mouseSupport) {
            var20 = true;
        }

        if (this.ae && !var20) {
            if (var6) {
                if (!this.ai && this.a(class_553.a)) {
                    var4.bM.b(class_648.h, 0.5F);
                    this.U = false;
                    var58 = true;
                }

                if (this.a(class_553.c)) {
                    var4.bM.b(class_648.h, 0.5F);
                    this.U = false;
                    var17 = true;
                }
            }

            if (this.a(class_553.b)) {
                var4.bM.b(class_648.i, 0.7F);
                this.U = false;
                var59 = true;
            }
        }

        boolean var21 = false;
        if (GameEngine.aw() && var4.settingsEngine.mouseSupport) {
            var21 = true;
        }

        if (this.U && !this.T) {
            var21 = true;
        }

        float var22;
        float var23;
        if (GameEngine.au()) {
            var13 = true;
            if (var4.ae() == 2) {
                var21 = true;
                var9 = var4.b(0) / var4.cX;
                var10 = var4.c(0) / var4.cX;
                var22 = var4.b(1) / var4.cX;
                var23 = var4.c(1) / var4.cX;
                this.ap = true;
                this.an = var22;
                this.ao = var23;
            } else if (this.U && !this.T) {
                this.ap = false;
            }

            if (this.ap) {
                var12 = true;
            }
        }

        if (var21) {
            this.ae = true;
            this.ag = var9 * var4.cX;
            this.ah = var10 * var4.cX;
            if (!this.a(var4.af(), var4.ag())) {
                this.ae = false;
                var19 = false;
            }
        }

        var22 = this.an;
        var23 = this.ao;
        if (var13) {
            var22 += var4.cw + var4.cr;
            var23 += var4.cx + var4.cs;
        }

        class_31 var24 = this.ac.i();
        int var25 = this.ac.t();
        boolean var26 = false;
        if (GameEngine.aw() && var4.settingsEngine.mouseSupport && !var4.cK.b((int)this.z, (int)this.A)) {
            var26 = true;
        }

        Unit var27 = Unit.c(var24);
        if ((var27 == null || !(var27 instanceof OrderableUnit)) && class_591.b != null) {
            var27 = Unit.c((class_31)class_591.b);
        }

        if (this.ae && !var26) {
            OrderableUnit var28 = (OrderableUnit)var27;
            var4.bL.b(this.ag / var4.cX + var4.cw, this.ah / var4.cX + var4.cx);
            var28.xCord = (float)var4.bL.T;
            var28.yCord = (float)var4.bL.U;
            if (var24.p()) {
                var12 = false;
                Point var29 = class_552.a((int)var28.xCord, (int)var28.yCord, 3);
                if (var29 != null) {
                    var28.xCord = (float)var29.a;
                    var28.yCord = (float)var29.b;
                }
            }

            if (!var28.bI()) {
                var28.cg = 0.0F;
            } else {
                var28.cg = -90.0F;
            }

            var28.xCord += var28.cZ();
            var28.yCord += var28.da();
            var28.b(this.aa.bX);
            var28.a(var25);
            var28.cp = true;
            String var60 = var28.b(false, var4.playerTeam);
            if (class_990.a(var4.playerTeam, var28, this.ad)) {
                var60 = "{0}";
            }

            float var31;
            float var32;
            if (this.q() == 1 && var5 != null && var5 instanceof OrderableUnit) {
                OrderableUnit var30 = (OrderableUnit)var5;
                if (!var30.aR()) {
                    var31 = class_340.a(var30.xCord, var30.yCord, var28.xCord, var28.yCord);
                    var32 = var30.f(var28.r());
                    boolean var33;
                    if (var32 > 800000.0F) {
                        var33 = true;
                    } else {
                        var33 = var31 <= var32 * var32;
                    }

                    if (!var33) {
                        var60 = "{0}";
                    }
                }
            }

            if (var12) {
            }

            Unit var61 = null;
            if (this.q() == 1) {
                var61 = var5;
            }

            if (var6) {
                if (!var12) {
                    this.a(var28, var28.xCord, var28.yCord, true, var14, var61);
                } else {
                    if (GameEngine.av() || GameEngine.au() && var4.ae() == 2) {
                        var4.bO.a(var9 * var4.cX, var10 * var4.cX, (var22 - var4.cw) * var4.cX, (var23 - var4.cx) * var4.cX, this.bE);
                    } else {
                        var4.bO.a((var28.xCord - var4.cw) * var4.cX, (var28.yCord - var4.cx) * var4.cX, (var22 - var4.cw) * var4.cX, (var23 - var4.cx) * var4.cX, this.bE);
                    }

                    boolean var62 = true;
                    var60 = null;
                    this.a(var28, var22, var23, var28.xCord, var28.yCord, var62, (ArrayList)null, var61);
                }
            }

            var28.a((int)1);
            if (var19 && this.p()) {
                this.U = false;
                if (this.a(var4)) {
                    var17 = true;
                    var18 = true;
                } else {
                    var58 = true;
                }
            }

            if (this.n()) {
                this.U = false;
                var59 = true;
            }

            if (this.U && !this.T) {
                float var65 = this.aq;
                float var34 = this.ar;
                float var35 = 15.0F;
                if (class_340.c(var65 - var9) < var35 && class_340.c(var34 - var10) < var35 && this.af != 0.0F) {
                    this.U = false;
                    var4.bM.b(class_648.h, 0.5F);
                    if (this.ai) {
                        var17 = true;
                    } else {
                        var58 = true;
                    }
                }

                this.af = 80.0F;
                this.aq = var9;
                this.ar = var10;
            }

            if (var58 || var17) {
                if (!var6) {
                    var4.bM.b(class_648.l, 0.7F);
                    if (var60 == null && var5 != null && this.ac != null) {
                        class_226 var66 = var5.a(this.ac.N());
                        if (var66 != null) {
                            var60 = this.ac.j(var5);
                            if (var60 == null) {
                                String var64 = this.f(this.ac);
                                if (var64 != null) {
                                    var60 = this.bI.b();
                                }
                            }
                        }
                    }

                    if (var60 != "{0}") {
                        this.c(var60);
                    }
                } else if (var60 != null) {
                    var4.bM.b(class_648.l, 0.7F);
                    if (var60 != "{0}") {
                        String var63 = var60;
                        if (var60 == "{2}") {
                            var63 = this.bK;
                        }

                        if (var63 == "{3}") {
                            var63 = this.bL;
                        }

                        if (var63 == "{1}") {
                            var63 = this.bJ;
                        }

                        this.c(var63);
                    }
                } else {
                    var31 = var28.xCord;
                    var32 = var28.yCord;
                    ArrayList var67 = new ArrayList();
                    if (var12) {
                        boolean var68 = false;
                        this.a(var28, var22, var23, var28.xCord, var28.yCord, var68, var67, (Unit)null);
                    } else {
                        var67.add(new PointF(var31, var32));
                    }

                    int var69 = 0;
                    boolean var70 = true;
                    Iterator var36 = var67.iterator();

                    while(var36.hasNext()) {
                        PointF var37 = (PointF)var36.next();
                        SyncPacket var38;
                        if (this.ac.A()) {
                            var38 = this.x();
                            this.a(var38);
                            var38.a(this.ac.N(), var37, (Unit)null);
                        } else {
                            var38 = this.x();
                            if (var70) {
                                var70 = false;
                                if (var17) {
                                    if (!var38.e) {
                                        var38.f = true;
                                    }

                                    this.ai = true;
                                }
                            } else {
                                var38.e = true;
                            }

                            OrderableUnit var39 = this.t();
                            if (this.ac instanceof class_230) {
                                OrderableUnit var40 = ((class_230)this.ac).b;
                                var38.a(var40);
                                var39 = var40;
                            } else {
                                this.a(var38);
                            }

                            var38.a(var37.x, var37.y, var24, var25);
                            if (var39 != null) {
                                class_990 var76 = new class_990();
                                var76.d = var24;
                                var76.g = var37.x;
                                var76.h = var37.y;
                                var76.n = true;
                                var76.o = var39;
                                var76.e = var4.playerTeam;
                                var76.f = var25;
                                var76.j = var4.playerTeam;
                                var76.r = this.ad;
                                var76.s = 1.0F + 0.15F * (float)var69;
                                if (var39.av() >= 29) {
                                    var76.q = true;
                                }
                            }

                            ++var69;
                        }
                    }

                    this.aU = 5.0F;
                    if (GameEngine.aw()) {
                        this.aU = 1.0F;
                    }

                    this.ap = false;
                    if (!var17) {
                        if (var69 > 0) {
                            boolean var71 = true;
                            if (var28 != null && !this.p(var28)) {
                                var71 = false;
                            }

                            this.ac = null;
                            this.ae = false;
                            this.ai = false;
                            this.aa = null;
                            if (var71) {
                                this.y();
                            }

                            ++this.ad;
                        }
                    } else if (!var18) {
                        float var72 = var28.xCord;
                        float var73 = var28.yCord;
                        boolean var74 = false;
                        if (class_340.c(var72 - this.aj) < (float)(var28.cd().b() * var4.bL.n) * 2.0F + (float)(3 * var4.bL.n) && class_340.c(var73 - this.ak) < (float)(var28.cd().c() * var4.bL.o) * 2.0F + (float)(3 * var4.bL.o)) {
                            this.al = var72 - this.aj;
                            this.am = var73 - this.ak;
                            if (class_340.c(this.al) > class_340.c(this.am)) {
                                this.am = 0.0F;
                            } else {
                                this.al = 0.0F;
                            }
                        }

                        if (var28.cd().c() > var28.cd().b() + 1) {
                            this.am = 0.0F;
                        }

                        this.aj = var72;
                        this.ak = var73;
                        float var75 = 0.0F;
                        float var77 = 0.0F;
                        if (this.am < 0.0F) {
                            var75 = -1.0F;
                        }

                        if (this.al < 0.0F) {
                            var77 = -1.0F;
                        }

                        if (this.am > 0.0F) {
                            var75 = 1.0F;
                        }

                        if (this.al > 0.0F) {
                            var77 = 1.0F;
                        }

                        if (var77 == 0.0F && var75 == 0.0F) {
                            var77 = 1.0F;
                        }

                        ArrayList var41 = new ArrayList();
                        float var42 = var72 + 200.0F * var77;
                        float var43 = var73 + 200.0F * var75;
                        float var44 = -var28.cZ() + 1.0F;
                        float var45 = -var28.da() + 1.0F;
                        boolean var46 = false;
                        this.a(var28, var72 + var44, var73 + var45, var42 + var44, var43 + var45, var46, var41, (Unit)null);
                        if (var41.size() > 0) {
                            var28.xCord = ((PointF)var41.get(0)).x;
                            var28.yCord = ((PointF)var41.get(0)).y;
                            var74 = true;
                        }

                        if (!var74) {
                            var42 = var72 + 200.0F * -var77;
                            var43 = var73 + 200.0F * -var75;
                            this.a(var28, var72 + var44, var73 + var45, var42 + var44, var43 + var45, var46, var41, (Unit)null);
                            if (var41.size() > 0) {
                                var28.xCord = ((PointF)var41.get(0)).x;
                                var28.yCord = ((PointF)var41.get(0)).y;
                                var74 = true;
                            }
                        }

                        if (!var74) {
                            var28.xCord += (float)(3 * var4.bL.n);
                            var28.yCord += (float)var4.bL.n;
                        }

                        if (var74) {
                            float var47 = var28.xCord - var72;
                            float var48 = var28.yCord - var73;
                            float var49 = var4.cy;
                            float var50 = var4.cz;
                            var4.cr += var47;
                            var4.cs += var48;
                            var4.cy += var4.cr;
                            var4.cz += var4.cs;
                            float var51 = var4.cy;
                            float var52 = var4.cz;
                            var4.Q();
                            float var53 = var4.cy - var51;
                            float var54 = var4.cz - var52;
                            var4.cr += var53;
                            var4.cs += var54;
                            float var55 = var49 + var47 - var4.cy;
                            float var56 = var50 + var48 - var4.cz;
                            if (class_340.c(var55) > 1.0F) {
                                this.ag += var55 * var4.cX;
                            }

                            if (class_340.c(var56) > 1.0F) {
                                this.ah += var56 * var4.cX;
                            }

                            var4.cy -= var4.cr;
                            var4.cz -= var4.cs;
                        }
                    }
                }
            }

            if (var59) {
                this.l();
                if (this.ai) {
                    this.y();
                }
            }
        }

    }

    public boolean m() {
        GameEngine var1 = GameEngine.getGameEngine();
        return GameEngine.aw() && var1.settingsEngine.mouseSupport && !this.n() && !this.p();
    }

    public boolean n() {
        GameEngine var1 = GameEngine.getGameEngine();
        if (GameEngine.aw() && var1.settingsEngine.mouseSupport && this.U && !this.T && !this.aZ) {
            byte var2 = 1;
            byte var3 = 2;
            if (var1.settingsEngine.mousePlacement == 2) {
                var2 = 2;
                var3 = 1;
            }

            if (var1.e(var2)) {
            }

            if (var1.e(var3)) {
                return true;
            }
        }

        return false;
    }

    public boolean o() {
        GameEngine var1 = GameEngine.getGameEngine();
        if (GameEngine.av() && var1.settingsEngine.mouseSupport && (this.U || this.I)) {
            byte var2 = 1;
            byte var3 = 2;
            if (var1.settingsEngine.mousePlacement == 2) {
                var2 = 2;
                var3 = 1;
            }

            if (var1.e(var2)) {
                return true;
            }

            if (var1.e(var3)) {
            }
        }

        return false;
    }

    public boolean p() {
        return this.U && !this.T && !this.aZ ? this.o() : false;
    }

    public void a(Unit var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        if (var1 != null && this.W == var1 && this.X < 40.0F && !this.b(var2)) {
            if (!this.a(var2)) {
                this.y();
            }

            this.h(var1);
        } else if (var1 != null) {
            if (!this.a(var2) && !this.b(var2)) {
                this.y();
            }

            this.a(var1, this.b(var2));
            this.W = var1;
            this.X = 0.0F;
        }

    }

    public boolean a(Unit var1, boolean var2, float var3, float var4, Point var5) {
        GameEngine var6 = GameEngine.getGameEngine();
        PlayerData var7 = this.r();
        boolean var8 = var7.c(var1.bX);
        if (var8 && this.B() && this.q(var1)) {
            this.c(var1);
            return true;
        } else {
            boolean var9;
            if (var7.d(var1.bX) && (var1.health < var1.totalHealth || var1.cm < 1.0F) && this.q() != 0) {
                var9 = true;
                boolean var10 = false;
                boolean var11 = false;
                boolean var12 = false;
                if (var1.cr() && this.n(var1)) {
                    var10 = true;
                }

                Iterator var13 = this.bZ.iterator();

                while(true) {
                    if (var13.hasNext()) {
                        GameObject var14 = (GameObject)var13.next();
                        if (!(var14 instanceof OrderableUnit)) {
                            continue;
                        }

                        OrderableUnit var15 = (OrderableUnit)var14;
                        if (!var15.cG) {
                            continue;
                        }

                        if (!this.m(var15)) {
                            var9 = false;
                        } else {
                            if (var15.a(var1)) {
                                if (var15.aS()) {
                                    var12 = true;
                                }

                                class_1042 var16 = var15.ar();
                                if (var16 != null && var16.d() == WaypointType.repair) {
                                    var11 = true;
                                }
                                continue;
                            }

                            var9 = false;
                        }
                    }

                    if (var9 && (!var11 || !var10)) {
                        if (var12) {
                            this.d(var1);
                        } else {
                            this.d(var1);
                        }

                        return true;
                    }
                    break;
                }
            }

            if (var1.g() > 0.0F && this.q() != 0) {
                var9 = true;
                Iterator var17 = GameObject.er.iterator();

                while(var17.hasNext()) {
                    GameObject var18 = (GameObject)var17.next();
                    if (var18 instanceof OrderableUnit) {
                        OrderableUnit var19 = (OrderableUnit)var18;
                        if (var19.cG) {
                            if (!this.m(var19)) {
                                var9 = false;
                                break;
                            }

                            if (!var19.h(var1, true)) {
                                var9 = false;
                                break;
                            }
                        }
                    }
                }

                if (var9) {
                    this.b(var1);
                    return true;
                }
            }

            if (var1.cr() && this.n(var1)) {
                this.f(var1);
                return true;
            } else if (GameEngine.av() && this.C() && this.o(var1)) {
                this.g(var1);
                return true;
            } else {
                var9 = false;
                if ((!var2 || var1.t()) && !var7.c(var1.bX)) {
                    if (var1.bI()) {
                        if (var1.cc().a()) {
                            var9 = true;
                        }
                    } else if (!var1.bT) {
                        var9 = true;
                    }

                    if (!var9 && !var1.i() && this.D()) {
                        var9 = true;
                    }
                }

                if (var9) {
                    return false;
                } else if (var8 && this.B()) {
                    this.a(var1.xCord, var1.yCord, var1.zCord);
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    public int q() {
        return this.aX;
    }

    void a(SyncPacket var1) {
        Iterator var2 = GameObject.er.iterator();

        while(var2.hasNext()) {
            GameObject var3 = (GameObject)var2.next();
            if (var3 instanceof OrderableUnit) {
                OrderableUnit var4 = (OrderableUnit)var3;
                if (var4.cG && this.m(var4)) {
                    var1.a(var4);
                }
            }
        }

    }

    public PlayerData r() {
        GameEngine var1 = GameEngine.getGameEngine();
        Iterator var2 = this.bZ.iterator();

        Unit var3;
        OrderableUnit var4;
        while(var2.hasNext()) {
            var3 = (Unit)var2.next();
            if (var3 instanceof OrderableUnit) {
                var4 = (OrderableUnit)var3;
                if (var4.bX == var1.playerTeam) {
                    return var4.bX;
                }
            }
        }

        var2 = this.bZ.iterator();

        while(var2.hasNext()) {
            var3 = (Unit)var2.next();
            if (var3 instanceof OrderableUnit) {
                var4 = (OrderableUnit)var3;
                if (this.m(var4)) {
                    return var4.bX;
                }
            }
        }

        return var1.playerTeam;
    }

    public OrderableUnit s() {
        Iterator var1 = this.bZ.iterator();

        Unit var2;
        do {
            if (!var1.hasNext()) {
                return null;
            }

            var2 = (Unit)var1.next();
        } while(!(var2 instanceof OrderableUnit));

        OrderableUnit var3 = (OrderableUnit)var2;
        return var3;
    }

    public OrderableUnit t() {
        Iterator var1 = this.bZ.iterator();

        while(var1.hasNext()) {
            Unit var2 = (Unit)var1.next();
            if (var2 instanceof OrderableUnit) {
                OrderableUnit var3 = (OrderableUnit)var2;
                if (this.m(var3)) {
                    return var3;
                }
            }
        }

        return null;
    }

    void a(SyncPacket var1, class_226 var2, boolean var3) {
        if (var2 instanceof class_230) {
            class_230 var13 = (class_230)var2;
            var1.a(var13.b);
        } else {
            class_1059 var4 = var2.N();
            OrderableUnit var5 = null;
            int var6 = -99;
            Iterator var7 = GameObject.er.iterator();

            while(var7.hasNext()) {
                GameObject var8 = (GameObject)var7.next();
                if (var8 instanceof OrderableUnit) {
                    OrderableUnit var9 = (OrderableUnit)var8;
                    if (var9.cG && this.m(var9)) {
                        class_226 var10 = var9.a((class_1059)var4);
                        if (var10 != null && var10.b((Unit)var9) && (var10.a(var9, true) || var3)) {
                            int var11 = 0;
                            if (var9 instanceof class_8) {
                                boolean var12 = true;
                                var11 = ((class_8)var9).a(var4, true);
                                if (var5 != null) {
                                    if (!var3) {
                                        if (var11 >= var6) {
                                            break;
                                        }
                                    } else if (var11 <= var6) {
                                        break;
                                    }
                                }
                            }

                            var5 = var9;
                            var6 = var11;
                        }
                    }
                }
            }

            if (var5 != null) {
                var1.a(var5);
            }

        }
    }

    boolean a(class_226 var1, float var2, float var3) {
        if (var1 instanceof class_230) {
            class_230 var9 = (class_230)var1;
            OrderableUnit var10 = var9.b;
            class_226 var11 = var9.p_();
            boolean var12 = false;
            if (var11.b((Unit)var10) && var11.a(var10, true) && !var10.a(var11, var2, var3)) {
                var12 = true;
            }

            return var12;
        } else {
            boolean var4 = false;
            Iterator var5 = GameObject.er.iterator();

            while(var5.hasNext()) {
                GameObject var6 = (GameObject)var5.next();
                if (var6 instanceof OrderableUnit) {
                    OrderableUnit var7 = (OrderableUnit)var6;
                    if (var7.cG && this.m(var7)) {
                        class_226 var8 = var7.a((class_1059)var1.N());
                        if (var8 != null && var8.b((Unit)var7) && var8.a(var7, true)) {
                            if (var7.a(var8, var2, var3)) {
                                return false;
                            }

                            var4 = true;
                        }
                    }
                }
            }

            if (!var4) {
                return false;
            } else {
                return true;
            }
        }
    }

    void a(SyncPacket var1, class_226 var2) {
        if (var2 instanceof class_230) {
            class_230 var8 = (class_230)var2;
            var1.a(var8.b);
        } else {
            class_1059 var3 = var2.N();
            Iterator var4 = GameObject.er.iterator();

            while(var4.hasNext()) {
                GameObject var5 = (GameObject)var4.next();
                if (var5 instanceof OrderableUnit) {
                    OrderableUnit var6 = (OrderableUnit)var5;
                    if (var6.cG && this.m(var6)) {
                        class_226 var7 = var6.a((class_1059)var3);
                        if (var7 != null && var7.b((Unit)var6)) {
                            var1.a(var6);
                        }
                    }
                }
            }

        }
    }

    public boolean a(class_226 var1, boolean var2) {
        if (var1 instanceof class_230) {
            class_230 var8 = (class_230)var1;
            return var8.a(var8.b, true);
        } else {
            class_1059 var3 = var1.N();
            Iterator var4 = this.bZ.iterator();

            while(var4.hasNext()) {
                Unit var5 = (Unit)var4.next();
                if (var5 instanceof OrderableUnit) {
                    OrderableUnit var6 = (OrderableUnit)var5;
                    if (var6.cG && this.m(var6)) {
                        class_226 var7 = var6.a((class_1059)var3);
                        if (var7 != null && var7.a(var6, var2)) {
                            return true;
                        }
                    }
                }
            }

            return false;
        }
    }

    public boolean a(class_226 var1) {
        class_1059 var2 = var1.N();
        if (var1.o_()) {
            return false;
        } else if (var1 instanceof class_230) {
            class_230 var7 = (class_230)var1;
            return var7.a((Unit)var7.b);
        } else {
            Iterator var3 = this.bZ.iterator();

            while(var3.hasNext()) {
                Unit var4 = (Unit)var3.next();
                if (var4 instanceof OrderableUnit) {
                    OrderableUnit var5 = (OrderableUnit)var4;
                    if (var5.cG && this.m(var5)) {
                        class_226 var6 = var5.a((class_1059)var2);
                        if (var6 != null && var6.a((Unit)var5)) {
                            return true;
                        }
                    }
                }
            }

            return false;
        }
    }

    public boolean b(class_226 var1) {
        if (var1 instanceof class_230) {
            class_230 var7 = (class_230)var1;
            return var7.b(var7.b);
        } else {
            class_1059 var2 = var1.N();
            Iterator var3 = this.bZ.iterator();

            while(var3.hasNext()) {
                Unit var4 = (Unit)var3.next();
                if (var4 instanceof OrderableUnit) {
                    OrderableUnit var5 = (OrderableUnit)var4;
                    if (var5.cG && this.m(var5)) {
                        class_226 var6 = var5.a((class_1059)var2);
                        if (var6 != null && var6.b((Unit)var5)) {
                            return true;
                        }
                    }
                }
            }

            return false;
        }
    }

    public boolean c(class_226 var1) {
        boolean var2 = false;
        if (var1 instanceof class_230) {
            class_230 var8 = (class_230)var1;
            return var8.g(var8.b);
        } else {
            class_1059 var3 = var1.N();
            Iterator var4 = this.bZ.iterator();

            while(var4.hasNext()) {
                Unit var5 = (Unit)var4.next();
                if (var5 instanceof OrderableUnit) {
                    OrderableUnit var6 = (OrderableUnit)var5;
                    if (var6.cG && this.m(var6)) {
                        class_226 var7 = var6.a((class_1059)var3);
                        if (var7 != null) {
                            if (!var7.g(var6)) {
                                return false;
                            }

                            var2 = true;
                        }
                    }
                }
            }

            if (!var2) {
                return false;
            } else {
                return true;
            }
        }
    }

    public String d(class_226 var1) {
        if (var1 instanceof class_230) {
            class_230 var8 = (class_230)var1;
            return var8.j(var8.b);
        } else {
            class_1059 var2 = var1.N();
            Iterator var3 = this.bZ.iterator();

            while(var3.hasNext()) {
                Unit var4 = (Unit)var3.next();
                if (var4 instanceof OrderableUnit) {
                    OrderableUnit var5 = (OrderableUnit)var4;
                    if (var5.cG && this.m(var5)) {
                        class_226 var6 = var5.a((class_1059)var2);
                        if (var6 != null && var6.g(var5)) {
                            String var7 = var6.j(var5);
                            if (var7 != null) {
                                return var7;
                            }
                        }
                    }
                }
            }

            return null;
        }
    }

    public class_692 e(class_226 var1) {
        if (var1 instanceof class_230) {
            class_230 var2 = (class_230)var1;
            this.bY.clear();
            if (var2.b != null) {
                this.bY.a((Unit)var2.b);
            }

            return this.bY;
        } else {
            return this.bZ;
        }
    }

    public String f(class_226 var1) {
        class_692 var2 = this.e(var1);
        class_1059 var3 = var1.N();
        String var4 = null;
        boolean var5 = false;
        Iterator var6 = var2.iterator();

        while(true) {
            while(true) {
                OrderableUnit var8;
                class_226 var9;
                do {
                    do {
                        Unit var7;
                        do {
                            if (!var6.hasNext()) {
                                if (var5) {
                                    return null;
                                }

                                return var4;
                            }

                            var7 = (Unit)var6.next();
                        } while(!(var7 instanceof OrderableUnit));

                        var8 = (OrderableUnit)var7;
                    } while(!this.m(var8));

                    var9 = var8.a((class_1059)var3);
                } while(var9 == null);

                if (var9.B() != null && !var9.B().b((Unit)var8)) {
                    String var10 = var9.B().a(var8, 4, true);
                    if (var10 != null) {
                        var4 = var10;
                    }
                } else {
                    var5 = true;
                }
            }
        }
    }

    public boolean u() {
        if (this.aX == 0) {
            return false;
        } else {
            Iterator var1 = this.bZ.iterator();

            boolean var5;
            do {
                OrderableUnit var3;
                do {
                    Unit var2;
                    do {
                        if (!var1.hasNext()) {
                            return true;
                        }

                        var2 = (Unit)var1.next();
                    } while(!(var2 instanceof OrderableUnit));

                    var3 = (OrderableUnit)var2;
                } while(!var3.cG);

                if (!this.m(var3)) {
                    return false;
                }

                ArrayList var4 = var3.N();
                var5 = false;
                if (var4 != null) {
                    Iterator var6 = var4.iterator();

                    while(var6.hasNext()) {
                        class_226 var7 = (class_226)var6.next();
                        if (var7.e() == class_1052.setRally) {
                            var5 = true;
                        }
                    }
                }
            } while(var5);

            return false;
        }
    }

    public boolean a(OrderType var1) {
        Iterator var2 = this.bZ.iterator();

        while(var2.hasNext()) {
            Unit var3 = (Unit)var2.next();
            if (var3 instanceof OrderableUnit) {
                OrderableUnit var4 = (OrderableUnit)var3;
                if (this.m(var4) && this.a((OrderType)var1, (Unit)var4)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean a(OrderType var1, Unit var2) {
        if (var2 instanceof OrderableUnit) {
            OrderableUnit var3 = (OrderableUnit)var2;
            if ((var1 == OrderType.ATTACK || var1 == OrderType.MOVE) && !GameEngine.a(this.bU, 1000L)) {
                return true;
            }

            if (var1 == OrderType.NEW_SELECTION) {
                if (GameEngine.getGameEngine().tick < 10) {
                    return false;
                }

                if (!GameEngine.a(this.bV, 1000L)) {
                    return true;
                }
            }

            if (var3.a(var1)) {
                if (var1 == OrderType.ATTACK || var1 == OrderType.MOVE) {
                    this.bU = GameEngine.millis();
                }

                if (var1 == OrderType.NEW_SELECTION) {
                    this.bV = GameEngine.millis();
                }

                return true;
            }
        }

        return false;
    }

    public void b(float var1, float var2, Point var3) {
        GameEngine var4 = GameEngine.getGameEngine();
        if (!this.C()) {
            if (var4.settingsEngine.quickRally && this.u()) {
                this.b(var1, var2);
            }
        } else {
            SyncPacket var5 = this.x();
            var5.h = true;
            var5.a(var1, var2);
            this.a(var5);
            if (!this.a(OrderType.MOVE)) {
                var4.bM.b(class_648.f, 0.2F);
            }

            class_998 var6 = var4.bR.a(var1, var2, 0.0F, class_989.CUSTOM, true, Priority.critical);
            if (var6 != null) {
                var6.ap = 8;
                var6.V = 30.0F;
                var6.W = var6.V;
                var6.r = true;
                var6.E = 2.0F;
                var6.G = 2.8F * this.c();
                var6.F = 1.6F * this.c();
                var6.H = true;
            }

            if (var3 != null) {
                Point var7 = var4.bW.b((float)var3.a, (float)var3.b);
                class_998 var8 = var4.bR.a((float)var7.a, (float)var7.b, 0.0F, class_989.CUSTOM, true, Priority.critical);
                if (var8 != null) {
                    var8.ar = 4;
                    var8.ap = 8;
                    var8.V = 35.0F;
                    var8.W = var6.V;
                    var8.r = true;
                    var8.E = 2.0F;
                    var8.G = 1.3F;
                    var8.F = 0.6F;
                }
            }

        }
    }

    public void c(float var1, float var2, Point var3) {
        GameEngine var4 = GameEngine.getGameEngine();
        if (this.D && var4.settingsEngine.doubleClickToAttackMove && this.B() && this.C()) {
            this.d(var1, var2, var3);
        } else {
            this.b(var1, var2, var3);
        }

    }

    public void d(float var1, float var2, Point var3) {
        GameEngine var4 = GameEngine.getGameEngine();
        SyncPacket var5 = this.x();
        var5.h = true;
        var5.b(var1, var2);
        this.a(var5);
        if (!this.a(OrderType.MOVE)) {
            var4.bM.b(class_648.f, 0.2F);
        }

        class_998 var6 = var4.bR.a(var1, var2, 0.0F, class_989.CUSTOM, true, Priority.critical);
        if (var6 != null) {
            var6.aq = 17;
            var6.ap = 2;
            var6.V = 30.0F;
            var6.W = var6.V;
            var6.r = true;
            var6.E = 2.0F;
            var6.Z = 1.0F;
            var6.G = 1.9F * this.c();
            var6.F = 3.5F * this.c();
            var6.H = true;
        }

        if (var3 != null) {
            Point var7 = var4.bW.b((float)var3.a, (float)var3.b);
            class_998 var8 = var4.bR.a((float)var7.a, (float)var7.b, 0.0F, class_989.CUSTOM, true, Priority.critical);
            if (var8 != null) {
                var8.ar = 4;
                var8.ap = 9;
                var8.V = 35.0F;
                var8.W = var6.V;
                var8.r = true;
                var8.E = 2.0F;
                var8.G = 1.3F;
                var8.F = 0.6F;
            }
        }

    }

    public void v() {
        GameEngine var1 = GameEngine.getGameEngine();
        SyncPacket var2 = this.x();
        var2.h();
        this.a(var2);
        var1.bM.b(class_648.f, 0.2F);
    }

    public void a(class_226 var1, PointF var2, Unit var3, SyncPacket var4) {
        if (var1 instanceof class_283) {
            class_283 var5 = (class_283)var1;
            GameEngine var6 = GameEngine.getGameEngine();
        }

    }

    public void b(class_226 var1, float var2, float var3) {
        GameEngine var4 = GameEngine.getGameEngine();
        PointF var5 = new PointF(var2, var3);
        SyncPacket var6 = this.x();
        if (!var1.I()) {
            this.a(var6, var1);
        } else {
            this.a(var6, var1, false);
        }

        var6.a(var1.N(), var5, (Unit)null);
        this.a((class_226)var1, (PointF)var5, (Unit)null, (SyncPacket)var6);
        if (!var1.a(var2, var3)) {
            var4.bM.b(class_648.f, 0.2F);
            class_998 var7 = var4.bR.a(var2, var3, 0.0F, class_989.CUSTOM, true, Priority.critical);
            if (var7 != null) {
                var7.ap = 9;
                var7.V = 60.0F;
                var7.W = var7.V;
                var7.r = true;
                var7.E = 2.0F;
                var7.G = 3.8F * this.c();
                var7.F = 2.0F * this.c();
                var7.H = true;
                var7.Z = 1.5F;
            }
        }

    }

    public void b(Unit var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        SyncPacket var3 = this.x();
        this.a(var3);
        var3.d(var1);
        var2.bM.b(class_648.f, 0.2F);
        class_998 var4 = var2.bR.a(var1.xCord, var1.yCord, var1.zCord, class_989.CUSTOM, true, Priority.critical);
        if (var4 != null) {
            var4.ap = 12;
            var4.V = 25.0F;
            var4.W = var4.V;
            var4.r = true;
            var4.E = 2.0F;
            var4.H = true;
            var4.G = 1.2F * this.c();
            var4.F = 1.8F * this.c();
        }

    }

    public void b(float var1, float var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        SyncPacket var4 = this.w();
        this.a(var4);
        PointF var5 = new PointF(var1, var2);
        var4.a(var5);
        var3.bM.b(class_648.f, 0.2F);
        class_998 var6 = var3.bR.a(var1, var2, 0.0F, class_989.CUSTOM, true, Priority.critical);
        if (var6 != null) {
            var6.ap = 8;
            var6.V = 65.0F;
            var6.W = var6.V;
            var6.r = true;
            var6.E = 2.0F;
            var6.H = true;
            var6.Z = 2.0F;
            var6.G = 2.0F * this.c();
            var6.F = 1.5F * this.c();
        }

    }

    public void a(float var1, float var2, Point var3, class_233 var4) {
        GameEngine var5 = GameEngine.getGameEngine();
        if (!var5.settingsEngine.showMapPingsOnBattlefield && !var5.settingsEngine.showMapPingsOnMinimap) {
            this.b("Cannot send map ping, you have disabled both battlefield and minimap pings in your settings");
        } else {
            SyncPacket var6 = this.x();
            PointF var7 = new PointF(var1, var2);
            var6.a(var4.N(), var7, (Unit)null);
            if (this.bW == 0L || this.bW + 15000L < System.currentTimeMillis()) {
                this.bW = System.currentTimeMillis();
                String var8 = "MAP PING - [i:" + var4.K() + "]";
                var5.netEngine.l(var8);
            }

        }
    }

    public void a(float var1, float var2, PlayerData var3, class_233 var4) {
        GameEngine var5 = GameEngine.getGameEngine();
        float var7 = 1.0F;
        int var8 = 7 + var4.a.ordinal();
        if (!var5.settingsEngine.showMapPingsOnBattlefield && !var5.settingsEngine.showMapPingsOnMinimap) {
            if (!this.bX && !var5.replayEngine.j()) {
                this.bX = true;
                this.h.a((String)null, "[WARNING: A player send a map ping, but you have disabled both battlefield and minimap pings in your settings]");
            }

        } else {
            if (var5.settingsEngine.showMapPingsOnBattlefield) {
                class_998 var6 = var5.bR.a(var1, var2, 0.0F, class_989.CUSTOM, true, Priority.critical);
                if (var6 != null) {
                    var6.aq = 9;
                    var6.ap = 6;
                    var6.E = 0.7F;
                    var6.V = 490.0F;
                    var6.W = var6.V;
                    var6.r = true;
                    var6.S = 6.0F;
                    var6.T = 60.0F;
                    var6.J -= var6.S;
                    var6.G = 2.0F * var7;
                    var6.F = var6.G;
                    var6.ao = -0.5F;
                    var6.H = true;
                    if (var3 != null) {
                        var6.x = var3.K();
                        if (GameEngine.at()) {
                            var6.B = new LightingColorFilter(var6.x, 0);
                        }
                    }
                }

                if (var8 != -1) {
                    var6 = var5.bR.a(var1, var2, 0.0F, class_989.CUSTOM, true, Priority.critical);
                    if (var6 != null) {
                        var6.aq = 9;
                        var6.ap = var8;
                        var6.V = 490.0F;
                        var6.W = var6.V;
                        var6.r = true;
                        var6.E = 1.2F;
                        var6.S = 6.0F;
                        var6.T = 60.0F;
                        var6.J -= var6.S;
                        var6.G = 2.0F * var7;
                        var6.F = var6.G;
                        var6.ao = -0.7F;
                        var6.H = true;
                    }
                }
            }

            if (var5.settingsEngine.showMapPingsOnMinimap) {
                Point var9 = var5.bW.b(var1, var2);
                class_998 var10 = var5.bR.a((float)var9.a, (float)var9.b, 0.0F, class_989.CUSTOM, true, Priority.critical);
                if (var10 != null) {
                    var10.ar = 4;
                    var10.aq = 9;
                    var10.ap = 6;
                    var10.E = 0.8F;
                    var10.V = 470.0F;
                    var10.W = var10.V;
                    var10.r = true;
                    var10.J -= 2.0F;
                    var10.S = 2.0F;
                    var10.T = 60.0F;
                    var10.ao = -0.5F;
                    if (var3 != null) {
                        var10.x = var3.K();
                        if (GameEngine.at()) {
                            var10.B = new LightingColorFilter(var10.x, 0);
                        }
                    }

                    var10.G = 1.0F;
                    var10.F = 1.0F;
                }

                var10 = var5.bR.a((float)var9.a, (float)var9.b, 0.0F, class_989.CUSTOM, true, Priority.critical);
                if (var10 != null) {
                    var10.ar = 4;
                    var10.aq = 9;
                    var10.ap = var8;
                    var10.V = 470.0F;
                    var10.W = var10.V;
                    var10.r = true;
                    var10.E = 0.8F;
                    var10.J -= 2.0F;
                    var10.S = 2.0F;
                    var10.T = 60.0F;
                    if (var3 != null) {
                    }

                    var10.G = 1.0F;
                    var10.F = 1.0F;
                    var10.ao = -0.7F;
                }
            }

        }
    }

    public SyncPacket w() {
        GameEngine var1 = GameEngine.getGameEngine();
        SyncPacket var2 = var1.cf.b(var1.playerTeam);
        if (var1.netEngine.B) {
            var2.p = var1.playerTeam;
        }

        return var2;
    }

    public SyncPacket x() {
        GameEngine var1 = GameEngine.getGameEngine();
        SyncPacket var2 = this.w();
        if (this.a(var1)) {
            var2.e = true;
        }

        return var2;
    }

    public void c(Unit var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        SyncPacket var3 = this.x();
        var3.a(var1);
        this.a(var3);
        if (!this.a(OrderType.ATTACK)) {
            var2.bM.b(class_648.d, 1.0F);
        }

        class_998 var4 = var2.bR.a(var1.xCord, var1.yCord, var1.zCord, class_989.CUSTOM, true, Priority.critical);
        if (var4 != null) {
            var4.b = var1;
            var4.I = 0.0F;
            var4.J = 0.0F;
            var4.K = 0.0F;
            var4.ap = 9;
            var4.V = 35.0F;
            var4.W = var4.V;
            var4.r = true;
            var4.E = 1.5F;
            var4.H = true;
            var4.Z = 0.8F;
            var4.G = 1.9F * this.c();
            var4.F = 3.3F * this.c();
        }

        var4 = var2.bR.a(var1.xCord, var1.yCord, var1.zCord, class_989.CUSTOM, true, Priority.critical);
        if (var4 != null) {
            var4.b = var1;
            var4.I = 0.0F;
            var4.J = 0.0F;
            var4.K = 0.0F;
            var4.aq = 17;
            var4.ap = 0;
            var4.V = 25.0F;
            var4.W = var4.V;
            var4.r = true;
            var4.E = 1.0F;
            var4.H = true;
            var4.Z = 0.8F;
            var4.G = 2.2F * this.c();
            var4.F = 1.1F * this.c();
        }

    }

    public void d(Unit var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        SyncPacket var3 = this.x();
        this.a(var3);
        var3.b(var1);
        var2.bM.b(class_648.d, 1.0F);
        class_998 var4 = var2.bR.a(var1.xCord, var1.yCord, var1.zCord, class_989.CUSTOM, true, Priority.critical);
        if (var4 != null) {
            var4.ap = 10;
            var4.V = 35.0F;
            var4.W = var4.V;
            var4.r = true;
            var4.E = 2.0F;
            var4.H = true;
            var4.G = 1.5F * this.c();
            var4.F = 2.2F * this.c();
        }

    }

    public void e(Unit var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        SyncPacket var3 = this.x();
        this.a(var3);
        var3.c(var1);
        var2.bM.b(class_648.d, 1.0F);
        class_998 var4 = var2.bR.a(var1.xCord, var1.yCord, var1.zCord, class_989.CUSTOM, true, Priority.critical);
        if (var4 != null) {
            var4.aq = 17;
            var4.ap = 1;
            var4.V = 40.0F;
            var4.W = var4.V;
            var4.r = true;
            var4.E = 1.0F;
            var4.H = true;
            var4.Z = 0.0F;
            var4.G = 1.2F * this.c();
            var4.F = 1.9F * this.c();
        }

    }

    public void a(float var1, float var2, float var3) {
        GameEngine var4 = GameEngine.getGameEngine();
        var4.bM.b(class_648.l, 0.2F);
        class_998 var5 = var4.bR.a(var1, var2, var3, class_989.CUSTOM, true, Priority.critical);
        if (var5 != null) {
            var5.aq = 9;
            var5.ap = 14;
            var5.V = 10.0F;
            var5.W = var5.V;
            var5.r = true;
            var5.E = 2.0F;
            var5.Z = 0.0F;
            var5.G = 1.1F * this.c();
            var5.F = 1.6F * this.c();
            var5.H = true;
        }

    }

    public void a(float var1, float var2, Point var3, boolean var4) {
        GameEngine var5 = GameEngine.getGameEngine();
        SyncPacket var6 = this.x();
        this.a(var6);
        var6.c(var1, var2);
        if (!var4) {
            var6.e = true;
        }

        var5.bM.b(class_648.f, 0.2F);
        class_998 var7 = var5.bR.a(var1, var2, 0.0F, class_989.CUSTOM, true, Priority.critical);
        if (var7 != null) {
            var7.aq = 17;
            var7.ap = 0;
            var7.V = 40.0F;
            var7.W = var7.V;
            var7.r = true;
            var7.E = 2.0F;
            var7.Z = 8.0F;
            var7.G = 1.1F * this.c();
            var7.F = 1.9F * this.c();
            var7.H = true;
        }

        if (var3 != null) {
            Point var8 = var5.bW.b((float)var3.a, (float)var3.b);
            class_998 var9 = var5.bR.a((float)var8.a, (float)var8.b, 0.0F, class_989.CUSTOM, true, Priority.critical);
            if (var9 != null) {
                var9.ar = 4;
                var9.ap = 9;
                var9.V = 35.0F;
                var9.W = var7.V;
                var9.r = true;
                var9.E = 2.0F;
                var9.G = 1.3F;
                var9.F = 0.6F;
            }
        }

    }

    public void f(Unit var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        SyncPacket var3 = this.x();
        this.a(var3);
        var3.e(var1);
        var2.bM.b(class_648.d, 1.0F);
        class_998 var4 = var2.bR.a(var1.xCord, var1.yCord, var1.zCord, class_989.CUSTOM, true, Priority.critical);
        if (var4 != null) {
            var4.ap = 11;
            var4.V = 25.0F;
            var4.W = var4.V;
            var4.r = true;
            var4.E = 2.0F;
            var4.H = true;
            var4.G = 1.8F * this.c();
            var4.F = 1.6F * this.c();
        }

    }

    public void g(Unit var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        SyncPacket var3 = this.x();
        this.a(var3);
        var3.f(var1);
        var2.bM.b(class_648.d, 1.0F);
        class_998 var4 = var2.bR.a(var1.xCord, var1.yCord, var1.zCord, class_989.CUSTOM, true, Priority.critical);
        if (var4 != null) {
            var4.ap = 11;
            var4.V = 25.0F;
            var4.W = var4.V;
            var4.r = true;
            var4.E = 2.0F;
            var4.H = true;
            var4.G = 1.8F * this.c();
            var4.F = 1.6F * this.c();
        }

    }

    public Unit a(float var1, float var2, boolean var3) {
        GameEngine var4 = GameEngine.getGameEngine();
        Unit var5 = null;
        float var6 = -1.0F;
        float var7 = 10.0F / var4.cX;
        float var8 = 5.0F / var4.cX;
        float var9 = 5.0F / var4.cX;
        PlayerData var10 = this.r();
        Iterator var11 = Unit.bE.iterator();

        while(true) {
            Unit var12;
            float var13;
            boolean var15;
            do {
                float var14;
                do {
                    do {
                        do {
                            label49:
                            do {
                                while(var11.hasNext()) {
                                    var12 = (Unit)var11.next();
                                    if (var3) {
                                        if (var12.t()) {
                                            continue;
                                        }
                                    } else if (var12.cV()) {
                                        continue;
                                    }
                                    continue label49;
                                }

                                if (var5 != null && var5.bX != var4.playerTeam && !var5.cf()) {
                                    return null;
                                }

                                return var5;
                            } while(var12.bV);
                        } while(var12.cN != null);

                        var13 = class_340.a(var1, var2, var12.xCord, var12.yCord - var12.zCord);
                        var14 = var12.doo();
                        if (!var12.cG) {
                            var14 += var7;
                        } else {
                            var14 += var8;
                        }

                        var15 = var10.c(var12.bX);
                        if (var15) {
                            var14 += var9;
                        }
                    } while(!(var13 < var14 * var14));
                } while(var15 && !var12.cg());
            } while(var5 != null && !(var13 < var6));

            var5 = var12;
            var6 = var13;
        }
    }

    public void b(float var1, float var2, float var3) {
        GameEngine var4 = GameEngine.getGameEngine();
        Iterator var5 = GameObject.er.iterator();

        while(var5.hasNext()) {
            GameObject var6 = (GameObject)var5.next();
            if (var6 instanceof Unit) {
                Unit var7 = (Unit)var6;
                if (!var7.bV && var7.cN == null && var7.bX == var4.playerTeam) {
                    float var8 = class_340.a(var1, var2, var7.xCord, var7.yCord - var7.zCord);
                    if (var8 < var3 * var3) {
                        this.j(var7);
                    }
                }
            }
        }

    }

    public void h(Unit var1) {
        this.W = null;
        GameEngine var2 = GameEngine.getGameEngine();
        Iterator var3 = GameObject.er.iterator();

        while(true) {
            Unit var5;
            do {
                do {
                    do {
                        do {
                            do {
                                do {
                                    GameObject var4;
                                    do {
                                        if (!var3.hasNext()) {
                                            return;
                                        }

                                        var4 = (GameObject)var3.next();
                                    } while(!(var4 instanceof Unit));

                                    var5 = (Unit)var4;
                                } while(var5.bV);
                            } while(var5.cN != null);
                        } while(var5.bX != var1.bX);
                    } while(!var5.s_());
                } while(!class_71.a(var5, var1));
            } while(var5.bX != var2.playerTeam && !var5.cf());

            this.j(var5);
        }
    }

    public void y() {
        this.W = null;
        Iterator var1 = GameObject.er.iterator();

        while(var1.hasNext()) {
            GameObject var2 = (GameObject)var1.next();
            if (var2 instanceof Unit) {
                Unit var3 = (Unit)var2;
                var3.cG = false;
            }
        }

        this.aX = 0;
        ++this.Y;
        this.bZ.clear();
        K();
    }

    public boolean i(Unit var1) {
        if (var1.t()) {
            return false;
        } else {
            PlayerData var2 = GameEngine.getGameEngine().playerTeam;
            if (var2 != null) {
                boolean var3 = var2.c(var1.bX);
                if (var3 && !var1.cg()) {
                    return false;
                }
            }

            return true;
        }
    }

    public boolean j(Unit var1) {
        if (var1.cG) {
            return true;
        } else if (!this.i(var1)) {
            return false;
        } else {
            this.k(var1);
            this.a(OrderType.NEW_SELECTION, var1);
            return true;
        }
    }

    public void k(Unit var1) {
        if (!var1.cG) {
            if (!this.i(var1)) {
                return;
            }

            var1.cG = true;
            var1.cH = GameEngine.getGameEngine().bA;
            ++this.aX;
            if (!(var1 instanceof EditorOrBuilder)) {
                ca = var1;
            }

            ++this.Y;
            this.bZ.a(var1);
            K();
        }

    }

    public static class_800 z() {
        Unit var0 = ca;
        if (var0 == null) {
            return null;
        } else {
            class_31 var1 = var0.r();
            if (var1 != null && var1 instanceof class_591) {
                class_591 var2 = (class_591)var1;
                return var2.J;
            } else {
                return null;
            }
        }
    }

    public void a(Unit var1, boolean var2) {
        if (!var2) {
            this.j(var1);
        } else {
            if (var1.cG) {
                this.l(var1);
            } else {
                this.j(var1);
            }

        }
    }

    public void l(Unit var1) {
        if (var1.cG) {
            var1.cG = false;
            --this.aX;
            this.bZ.remove(var1);
            ++this.Y;
            K();
        }

    }

    public boolean A() {
        if (this.q() == 0) {
            return false;
        } else {
            Iterator var1 = this.bZ.iterator();

            while(var1.hasNext()) {
                Unit var2 = (Unit)var1.next();
                if (var2 instanceof OrderableUnit) {
                    OrderableUnit var3 = (OrderableUnit)var2;
                    if (var3.cG && this.m(var3)) {
                        return true;
                    }
                }
            }

            return false;
        }
    }

    public boolean B() {
        if (this.q() == 0) {
            return false;
        } else {
            Iterator var1 = this.bZ.iterator();

            while(var1.hasNext()) {
                Unit var2 = (Unit)var1.next();
                if (var2 instanceof OrderableUnit) {
                    OrderableUnit var3 = (OrderableUnit)var2;
                    if (var3.cG && this.m(var3) && var3.l()) {
                        return true;
                    }
                }
            }

            return false;
        }
    }

    public boolean C() {
        if (this.q() == 0) {
            return false;
        } else {
            Iterator var1 = this.bZ.iterator();

            while(var1.hasNext()) {
                Unit var2 = (Unit)var1.next();
                if (var2 instanceof OrderableUnit) {
                    OrderableUnit var3 = (OrderableUnit)var2;
                    if (var3.cG && var3.aS() && this.m(var3)) {
                        return true;
                    }
                }
            }

            return false;
        }
    }

    public boolean D() {
        if (this.q() == 0) {
            return true;
        } else {
            Iterator var1 = this.bZ.iterator();

            while(var1.hasNext()) {
                Unit var2 = (Unit)var1.next();
                if (var2 instanceof OrderableUnit) {
                    OrderableUnit var3 = (OrderableUnit)var2;
                    if (var3.cG && !var3.i()) {
                        return false;
                    }
                }
            }

            return true;
        }
    }

    public boolean m(Unit var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        if (var1.cW()) {
            return false;
        } else if (var1.bX == var2.playerTeam) {
            return true;
        } else if (var1.bX != null && var1.bX.b(var2.playerTeam)) {
            return true;
        } else {
            return var2.bv || var2.replayEngine.j();
        }
    }

    public boolean n(Unit var1) {
        if (this.q() == 0) {
            return false;
        } else {
            Iterator var2 = this.bZ.iterator();

            while(var2.hasNext()) {
                Unit var3 = (Unit)var2.next();
                if (var3 instanceof OrderableUnit) {
                    OrderableUnit var4 = (OrderableUnit)var3;
                    if (var4.cG && var4 != var1 && this.m(var4) && var1.d(var4, false)) {
                        return true;
                    }
                }
            }

            return false;
        }
    }

    public boolean o(Unit var1) {
        if (this.q() == 0) {
            return false;
        } else {
            Iterator var2 = this.bZ.iterator();

            while(var2.hasNext()) {
                Unit var3 = (Unit)var2.next();
                if (var3 instanceof OrderableUnit) {
                    OrderableUnit var4 = (OrderableUnit)var3;
                    if (var4.cG && var4 != var1 && this.m(var4) && var4.d(var1, false)) {
                        return true;
                    }
                }
            }

            return false;
        }
    }

    public boolean p(Unit var1) {
        if (this.q() == 0) {
            return false;
        } else {
            Iterator var2 = this.bZ.iterator();

            while(var2.hasNext()) {
                Unit var3 = (Unit)var2.next();
                if (var3 instanceof OrderableUnit) {
                    OrderableUnit var4 = (OrderableUnit)var3;
                    if (var4.cG && var4 != var1 && this.m(var4) && var4.a(var1)) {
                        return true;
                    }
                }
            }

            return false;
        }
    }

    public boolean q(Unit var1) {
        if (this.q() == 0) {
            return false;
        } else {
            Iterator var2 = this.bZ.iterator();

            while(var2.hasNext()) {
                Unit var3 = (Unit)var2.next();
                if (var3 instanceof OrderableUnit) {
                    OrderableUnit var4 = (OrderableUnit)var3;
                    if (var4.cG && var4 != var1 && this.m(var4) && class_1050.a(var4, var1)) {
                        return true;
                    }
                }
            }

            return false;
        }
    }

    public void E() {
    }

    public boolean F() {
        return false;
    }

    public void a(GameOutputStream var1) {
        this.g.a(var1);
        var1.writeByte(1);
        var1.writeInt(this.ad);
    }

    public void a(GameInputStream var1, boolean var2) {
        this.g.a(var1, var2);
        byte var3 = var1.readByte();
        if (var3 >= 1) {
            this.ad = var1.readInt();
        }

    }

    public strictfp void a(OrderableUnit var1, float var2, float var3, float var4, float var5, boolean var6, ArrayList var7, Unit var8) {
        GameEngine var9 = GameEngine.getGameEngine();
        float var10 = var1.xCord;
        float var11 = var1.yCord;
        OrderableUnit var12 = null;
        Unit var13 = Unit.d(var1.r());
        if (!(var13 instanceof OrderableUnit)) {
            GameEngine.log("buildingBlockoutUnit not OrderableUnit is: " + var13.getClass().getName());
        } else {
            var12 = (OrderableUnit)var13;
        }

        boolean var14 = false;
        var9.bL.b(var2, var3);
        var2 = (float)var9.bL.T;
        var3 = (float)var9.bL.U;
        var2 += var1.cZ();
        var3 += var1.da();
        var4 += var1.cZ();
        var5 += var1.da();
        float var15 = class_340.b(var2, var3, var4, var5);
        float var16 = class_340.d(var2, var3, var4, var5);
        int var17 = 0;

        for(float var18 = 0.0F; var18 <= var15; var18 += (float)var9.bL.p) {
            float var19 = var2 + class_340.k(var16) * var18;
            float var20 = var3 + class_340.j(var16) * var18;
            var19 -= var1.cZ();
            var20 -= var1.da();
            var9.bL.b(var19, var20);
            var19 = (float)var9.bL.T;
            var20 = (float)var9.bL.U;
            var19 += var1.cZ();
            var20 += var1.da();
            var1.xCord = var19;
            var1.yCord = var20;
            boolean var21 = false;
            if ((!var14 || var12 == null || !class_990.a(var1, var12) && !var1.r(var12)) && !var21) {
                boolean var22 = this.a(var1, var19, var20, var6, false, var8);
                if (var7 != null && var22) {
                    var7.add(new PointF(var19, var20));
                }

                if (var22) {
                    ++var17;
                    if (var17 >= 29) {
                        return;
                    }
                }

                var14 = true;
                if (var12 != null) {
                    var12.xCord = var19;
                    var12.yCord = var20;
                }
            }
        }

        var1.xCord = var10;
        var1.yCord = var11;
    }

    public strictfp boolean a(OrderableUnit var1, float var2, float var3, boolean var4, boolean var5, Unit var6) {
        GameEngine var7 = GameEngine.getGameEngine();
        float var8 = var1.xCord;
        float var9 = var1.yCord;
        var1.xCord = var2;
        var1.yCord = var3;
        boolean var10 = var1.c(var7.playerTeam);
        if (class_990.a(var7.playerTeam, var1, this.ad)) {
            var10 = false;
        }

        float var12;
        if (var6 != null && var6 != null && var6 instanceof OrderableUnit) {
            OrderableUnit var11 = (OrderableUnit)var6;
            if (!var11.aR()) {
                var12 = class_340.a(var11.xCord, var11.yCord, var1.xCord, var1.yCord);
                float var13 = var11.f(var1.r());
                boolean var14;
                if (var13 > 800000.0F) {
                    var14 = true;
                } else {
                    var14 = var12 <= var13 * var13;
                }

                if (!var14) {
                    var10 = false;
                }
            }
        }

        boolean var15 = var1.cp;
        var1.cp = true;
        var1.cs = var10;
        var1.ct = !var10;
        var1.cr = var5;
        if (var4) {
            var7.bO.k();
            var7.R();
            var1.d(0.0F);
            var1.c(0.0F);
            var1.a(0.0F, false);
            var12 = var1.attackRange();
            if (var12 > 30.0F) {
                class_694.a(var1, var12, true, true);
            }

            var1.cb();
            if (!var5) {
                var1.N(-1);
            }

            var7.bO.l();
        }

        var1.xCord = var8;
        var1.yCord = var9;
        var1.cr = false;
        var1.cp = var15;
        return var10;
    }

    public void G() {
        this.l();
        GameEngine var1 = GameEngine.getGameEngine();
        var1.dq = true;
        var1.stats.c();
        if (var1.by < 1500 && var1.bS.f != null) {
            var1.dr = true;
        }

        this.k.a(0.0F);
        this.k.c();
    }

    public void H() {
        this.l();
        GameEngine var1 = GameEngine.getGameEngine();
        var1.dt = true;
        var1.stats.c();
        this.k.a(0.0F);
        this.k.c();
    }

    public void I() {
        this.l();
        this.aa = null;
        this.ac = this.p;
    }

    public void a(String var1, Rect var2, Paint var3, Paint var4) {
        GameEngine var5 = GameEngine.getGameEngine();
        String[] var6 = class_340.c(var1, '\n');
        int var7 = 0;
        String[] var8 = var6;
        int var9 = var6.length;

        for(int var10 = 0; var10 < var9; ++var10) {
            String var11 = var8[var10];
            Paint var12;
            if (var7 == 0) {
                var12 = var3;
            } else {
                var12 = var4;
            }

            int var13 = class_550.a(var12);
            var5.bO.a(var11, (float)var2.d(), (float)(var2.b + var13 / 2 + var7 * var13), var12);
            ++var7;
        }

    }

    public boolean a(class_226 var1, boolean var2, Unit var3, boolean var4, boolean var5) {
        return this.a(var1, var2, var3, var4, false, -1.0F, var5);
    }

    public boolean a(class_226 var1, boolean var2, Unit var3, boolean var4, boolean var5, float var6, boolean var7) {
        GameEngine var8 = GameEngine.getGameEngine();
        String var9 = null;
        boolean var10 = false;
        boolean var11 = true;
        if (GameEngine.aw()) {
            var11 = false;
        }

        if (var3 != null && var1.l(var3)) {
            var11 = false;
        }

        if (var7) {
            var11 = false;
        }

        boolean var12 = false;
        boolean var13 = false;
        if (class_71.a(var1)) {
            var12 = true;
            var13 = true;
        }

        String var14;
        if (this.c(var1)) {
            var12 = true;
            var9 = this.bH;
            var14 = this.d(var1);
            if (var14 != null) {
                var9 = var14;
            }
        }

        if (!var12 && var4) {
            var14 = this.d(var1);
            if (var14 != null) {
                var9 = var14;
            }
        }

        if (var9 == null) {
            float var45 = this.g.b(var1);
            if (var45 > 0.0F) {
                var9 = class_340.h(var45 / 1000.0F);
            }
        }

        var14 = this.f(var1);
        boolean var15 = var14 != null;
        if (var14 != null) {
        }

        if (var4 && var9 == null && var14 != null) {
            var9 = this.bI.b();
        }

        class_523 var16 = new class_523();
        var16.d = this.aQ;
        var16.e = this.aR;
        Object var17 = null;
        class_525 var18 = null;
        if (var15) {
            var18 = this.aS;
        }

        var16.a(true);
        var1.a(var3, var16, (Paint)var17, var18);
        if (var9 != null) {
            var16.a("\n" + var9, this.aS);
        }

        var16.a(false);
        var1.a(var3, var16);
        if (var13) {
            var16.b();
            var16.a(this.bG, this.aR);
        }

        byte var19 = 20;
        this.bv.a = var19;
        int var20 = (int)(var8.cl - var8.cq - (float)var19);
        this.bv.c = var20;
        boolean var22 = var8.settingsEngine.showActionInfoHoverNearMouse;
        int var21;
        if (var2) {
            var21 = (int)(var8.cp - 40.0F);
        } else {
            var21 = 40;
        }

        if (GameEngine.au() && var6 > 0.0F) {
            var21 = (int)var6;
            var10 = true;
        }

        if (GameEngine.av() && var22 && var5) {
            var21 = (int)(var8.ag() - 40.0F);
        }

        this.bv.b = var21;
        this.bv.d = this.bv.b;
        boolean var23 = true;
        boolean var24 = true;
        boolean var25 = false;
        byte var26 = 7;
        if (GameEngine.av()) {
            if (!var22) {
                var23 = false;
                var24 = false;
            } else if (!var5) {
                var24 = false;
                var23 = true;
                var26 = 20;
            }
        } else if (!var2) {
            var24 = false;
        }

        if (GameEngine.av() && !var2 && var22 && !var5) {
        }

        if (var9 != null) {
        }

        class_525 var27 = this.aR;
        if (var4) {
            var27 = this.aS;
        }

        class_499 var28 = var16.a(this.bv.b(), var23);
        float var29 = (float)this.bv.d();
        this.bv.a = (int)(var29 - (float)(var28.b.b() / 2));
        this.bv.c = (int)(var29 + (float)(var28.b.b() / 2));
        this.bv.d = this.bv.b + var28.b.c();
        Rect var10000;
        if (var23) {
            var10000 = this.bv;
            var10000.a = (int)((float)var10000.a - (float)var26 * var8.cj);
            var10000 = this.bv;
            var10000.c = (int)((float)var10000.c + (float)var26 * var8.cj);
        }

        int var30;
        if (var24) {
            var30 = (int)((float)var20 - 7.0F * var8.cj - (float)this.bv.c);
            this.bv.a(var30, 0);
        }

        this.bw.a(this.bv);
        var10000 = this.bw;
        var10000.b -= 20;
        var10000 = this.bw;
        var10000.d += 15;
        var30 = -1;
        if (var3 != null) {
            var30 = var1.b(var3, true);
        }

        if (var3 != null && var11 && var30 != -1) {
            var10000 = this.bw;
            var10000.d = (int)((float)var10000.d + 55.0F * var8.cj);
        }

        if ((float)this.bw.d > var8.cm) {
            int var31 = (int)(var8.cm - (float)this.bw.d);
            this.bv.a(0, var31);
            this.bw.a(0, var31);
        }

        class_31 var46 = var1.i();
        if (!var1.D()) {
            var46 = null;
        }

        if (var46 != null && var3 != null) {
            var10000 = this.bw;
            var10000.b = (int)((float)var10000.b - 40.0F * var8.cj);
        }

        int var32;
        if (var10) {
            var32 = -this.bv.c();
            this.bv.a(0, var32);
            this.bw.a(0, var32);
        }

        int var33;
        float var47;
        if (var25) {
            var47 = var8.cm - 30.0F;
            var33 = (int)(var47 - (float)this.bw.d);
            this.bw.a(0, var33);
            this.bv.a(0, var33);
        }

        if (this.bw.b < 0) {
            var32 = 0 - this.bw.b;
            this.bw.a(0, var32);
            this.bv.a(0, var32);
        }

        if ((float)this.bw.d > var8.cm - 20.0F) {
            var47 = var8.cm - 20.0F;
            var33 = (int)(var47 - (float)this.bw.d);
            this.bw.a(0, var33);
            this.bv.a(0, var33);
        }

        var8.bO.b(this.bw, this.aP);
        var8.bO.b(this.bw, this.aL);
        if (var12) {
        }

        if (var46 != null && var3 != null) {
            var47 = 30.0F * var8.cj;
            float var48 = 100.0F * var8.cj;
            UnitType.a(var46, (float)this.bw.d(), (float)this.bw.b + 22.0F * var8.cj, this.Z, 0.0F, var3.bX, var47, var48, false, false, var1.t(), (Unit)null);
        }

        var28.a((float)this.bv.d(), (float)this.bv.b);
        if (var3 != null && var30 != -1 && var11) {
            var47 = var8.cj * 0.5F;
            var33 = (int)(60.0F * var47);
            float var34 = class_549.b(var3, var1, true);
            if (!var12 || var30 > 0) {
                this.aK.b(-16777216);
                float var35;
                if (var34 != 0.0F) {
                    var35 = class_340.c(var34) * 0.5F - 0.4F;
                    var35 = class_340.b(var35, 0.0F, 1.0F);
                    int var36;
                    if (var34 > 0.0F) {
                        var36 = Color.a(110, 30, 240, 30);
                    } else {
                        var36 = Color.a(110, 240, 30, 30);
                    }

                    class_340.a(var36, this.aK.e(), var35);
                }

                var35 = (float)this.bw.d - 65.0F * var47 / 2.0F + (float)(class_550.b(this.aK) / 2);
                if ((double)var34 > 0.5) {
                    ++var35;
                }

                if ((double)var34 < -0.5) {
                    var35 += -1.0F;
                }

                var8.bO.a("" + var30, (float)this.bw.d(), var35, this.aK);
            }

            boolean var50 = false;
            boolean var49 = false;
            boolean var37 = !var12 && this.a(var1, true);
            boolean var38 = var30 > 0 && var1.d(var3, true);
            int var39 = (int)((float)this.bw.d() + 60.0F * var47);
            int var40 = (int)((float)this.bw.d - 65.0F * var47);
            this.by.a(var39, var40, var39 + var33, var40 + var33);
            Paint var41;
            if (var37) {
                var41 = this.bf;
            } else {
                var41 = this.bg;
            }

            float var42;
            int var43;
            int var44;
            if (var34 > 0.0F) {
                var42 = class_340.c(var34) * 0.7F - 0.3F;
                var42 = class_340.b(var42, 0.0F, 1.0F);
                if (var34 > 0.0F) {
                    var43 = Color.a(110, 210, 210, 210);
                } else {
                    var43 = Color.a(110, 210, 110, 110);
                }

                var44 = class_340.a(var43, var41.e(), var42);
                var41 = this.bA;
                var41.b(var44);
            }

            if ((double)var34 > 0.5) {
                this.by.a(0, 1);
            }

            var8.bO.a(this.bh, (float)this.by.a, (float)this.by.b, var41, 0.0F, var47);
            class_340.a(this.by, (float)this.by.b() * 0.8F);
            if (this.U && !this.T && !var13 && this.by.b((int)this.x, (int)this.y)) {
                this.U = false;
                var50 = true;
            }

            var39 = (int)((float)(this.bw.d() - var33) - 60.0F * var47);
            var40 = (int)((float)this.bw.d - 65.0F * var47);
            this.by.a(var39, var40, var39 + var33, var40 + var33);
            if (var38) {
                var41 = this.bf;
            } else {
                var41 = this.bg;
            }

            if (var34 < 0.0F) {
                var42 = class_340.c(var34) * 0.7F - 0.3F;
                var42 = class_340.b(var42, 0.0F, 1.0F);
                if (var34 > 0.0F) {
                    var43 = Color.a(110, 210, 210, 210);
                } else {
                    var43 = Color.a(110, 210, 110, 110);
                }

                var44 = class_340.a(var43, var41.e(), var42);
                var41 = this.bA;
                var41.b(var44);
            }

            if ((double)var34 < -0.5) {
                this.by.a(0, 1);
            }

            var8.bO.a(this.bi, (float)this.by.a, (float)this.by.b, var41, 0.0F, var47);
            class_340.a(this.by, (float)this.by.b() * 0.8F);
            if (this.U && !this.T && this.by.b((int)this.x, (int)this.y)) {
                this.U = false;
                var49 = true;
            }

            byte var51 = 1;
            if ((var50 || var49) && var1.g()) {
                if (this.a(var8)) {
                    var51 = 5;
                }

                if (this.b(var8)) {
                    var51 = 10;
                }
            }

            SyncPacket var52;
            if (var50) {
                if (var1.g() && var8.playerTeam.x() <= var8.playerTeam.w()) {
                    this.b(this.g.al);
                }

                if (var37) {
                    var8.bM.b(class_648.h, 0.5F);
                    class_549.a(var3, var1, false, true);
                }

                for(var40 = 0; var40 < var51; ++var40) {
                    var52 = this.w();
                    if (this.a(var8)) {
                        var52.e = true;
                    }

                    this.a(var52, var1);
                    var52.a(var1.z());
                    this.a((class_226)var1, (PointF)null, (Unit)null, (SyncPacket)var52);
                }
            }

            if (var49) {
                if (var38) {
                    class_549.a(var3, var1, true, true);
                    var8.bM.b(class_648.i, 0.5F);
                }

                for(var40 = 0; var40 < var51; ++var40) {
                    var52 = this.w();
                    this.a(var52, var1);
                    var52.g = true;
                    var52.a(var1.z());
                }
            }

            if (!var50 && !var49 && this.U && !this.T && !this.bw.b((int)this.x, (int)this.y)) {
                return true;
            }
        }

        return !var11 && GameEngine.au() && this.U && !this.T && !this.bw.b((int)this.x, (int)this.y);
    }

    public void a(Rect var1, Paint var2, Paint var3) {
        GameEngine var4 = GameEngine.getGameEngine();
        if (bO) {
            var4.bO.a(this.bl, var1, var3, var1.a, var1.b, 0, 0);
            if (var2 != null) {
                int var5 = var2.f() + 0;
                if (var5 > 255) {
                    var5 = 255;
                }

                var2.c(var5);
            }
        }

        if (var2 != null) {
            var4.bO.b(var1, var2);
        }

    }

    public void a(Rect var1, int var2, boolean var3) {
        GameEngine var4 = GameEngine.getGameEngine();
        this.bF.b(var2);
        this.bF.a(Paint$Style.b);
        this.bF.a(1.0F);
        var4.bO.b(var1, this.bF);
        if (this.bN) {
            this.bF.b(Color.a(255, 116, 136, 160));
            byte var5 = 1;
            if (var3 && var1.b() > 100) {
                var5 = 2;
            }

            this.bF.a((float)var5);
            this.bz.a(var1);
            Rect var10000 = this.bz;
            var10000.d -= var5;
            var10000 = this.bz;
            var10000.b += var5;
            var10000 = this.bz;
            var10000.a += var5;
            var10000 = this.bz;
            var10000.c -= var5;
            var4.bO.b(this.bz, this.bF);
        }

    }

    public void a(int var1, int var2, int var3, int var4, String var5, int var6, Paint var7, boolean var8, class_186 var9, class_188 var10) {
        GameEngine var11 = GameEngine.getGameEngine();
        this.bx.a(var1, var2, var1 + var3, var2 + var4);
        this.bF.b(var6);
        if (var9 != null) {
            var9.a(var11.bO, this.bx, var10);
        } else if (!var8) {
            this.bF.a(Paint$Style.a);
            var11.bO.b(this.bx, this.bF);
        } else {
            this.a(this.bx, (Paint)null, this.bF);
        }

        if (var9 == null) {
            int var12 = Color.a(255, 0, 0, 0);
            if (bO) {
                var12 = Color.a(100, 0, 0, 0);
            }

            this.a(this.bx, var12, false);
        }

        this.a(var1, var2, var3, var4, var5, var6, var7);
    }

    public void a(int var1, int var2, int var3, int var4, String var5, int var6, Paint var7) {
        GameEngine var8 = GameEngine.getGameEngine();
        this.bx.a(var1, var2, var1 + var3, var2 + var4);
        if (GameEngine.aW) {
            var8.bO.a(var5, (float)this.bx.d(), (float)(this.bx.e() + var8.bO.a(var5, var7) / 2), var7);
        } else {
            var8.bO.a(var5, (float)this.bx.d(), (float)this.bx.e() - (var7.l() + var7.m()) / 2.0F, var7);
        }

    }

    public boolean J() {
        return !this.T;
    }

    public boolean a(int var1, int var2, int var3, int var4, String var5, class_551 var6, boolean var7, int var8) {
        return this.a(var1, var2, var3, var4, var5, var6, var7, var8, this.aC, false, (class_186)null);
    }

    public boolean b(int var1, int var2, int var3, int var4, String var5, class_551 var6, boolean var7, int var8) {
        return this.a(var1, var2, var3, var4, var5, var6, var7, var8, this.aC, true, (class_186)null);
    }

    public boolean a(int var1, int var2, int var3, int var4, String var5, class_551 var6, boolean var7, int var8, Paint var9, class_186 var10) {
        return this.a(var1, var2, var3, var4, var5, var6, var7, var8, var9, false, var10);
    }

    public boolean a(int var1, int var2, int var3, int var4, String var5, class_551 var6, boolean var7, int var8, Paint var9, boolean var10, class_186 var11) {
        boolean var12 = this.a(var1, var2, var3, var4, var6);
        boolean var13 = this.a(var1, var2, var3, var4, var6, var7);
        class_188 var14 = class_188.NORMAL;
        if (var12) {
            var14 = class_188.HOVERED;
        }

        this.a(var1, var2, var3, var4, var5, var8, var9, var10, var11, var14);
        return var13;
    }

    public void a(Rect var1) {
        if (var1.b((int)this.z, (int)this.A)) {
            this.L = true;
            this.M = true;
            if (this.V) {
                this.K = true;
            }
        }

    }

    public void a(float var1, float var2, float var3, float var4) {
        this.cc.a((int)var1, (int)var2, (int)(var1 + var3), (int)(var2 + var4));
        this.a(this.cc);
    }

    public boolean a(int var1, int var2, int var3, int var4, class_551 var5, boolean var6) {
        this.a((float)var1, (float)var2, (float)var3, (float)var4);
        this.bx.a(var1, var2, var1 + var3, var2 + var4);
        return (var6 && this.I || this.U) && this.bx.b((int)this.x, (int)this.y);
    }

    public boolean a(int var1, int var2, int var3, int var4, class_551 var5) {
        this.bx.a(var1, var2, var1 + var3, var2 + var4);
        GameEngine var6 = GameEngine.getGameEngine();
        return GameEngine.aw() && var6.settingsEngine.mouseSupport && this.bx.b((int)var6.af(), (int)var6.ag());
    }

    public boolean b(int var1, int var2, int var3, int var4, class_551 var5) {
        this.bx.a(var1, var2, var1 + var3, var2 + var4);
        return this.V && this.bx.b((int)this.x, (int)this.y);
    }

    public float r(Unit var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        if (var1.cH < var2.bA && var1.cH + 200 > var2.bA) {
            float var3 = 1.0F - (float)(var2.bA - var1.cH) / 200.0F;
            return var3 * 6.0F;
        } else {
            return GameEngine.getGameEngine().dx;
        }
    }

    public void a(class_177 var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        var1.u_();
        var1.c(var2.co);
        var1.d(var2.cp);
        this.s.a((class_174)var1);
    }

    public static void K() {
        ++cd;
        ce = true;
    }
}
