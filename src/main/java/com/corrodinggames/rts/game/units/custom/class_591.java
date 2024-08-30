package com.corrodinggames.rts.game.units.custom;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.ColoringMode;
import com.corrodinggames.rts.game.units.class_1040;
import com.corrodinggames.rts.game.units.MovementType;
import com.corrodinggames.rts.game.units.ExplodeType;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.AttackMovementType;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.a.class_1059;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.a.class_243;
import com.corrodinggames.rts.game.units.custom.a.class_1037;
import com.corrodinggames.rts.game.units.custom.a.class_283;
import com.corrodinggames.rts.game.units.custom.b.class_826;
import com.corrodinggames.rts.game.units.custom.b.class_827;
import com.corrodinggames.rts.game.units.custom.c.class_634;
import com.corrodinggames.rts.game.units.custom.d.class_447;
import com.corrodinggames.rts.game.units.custom.e.class_1068;
import com.corrodinggames.rts.game.units.custom.e.class_1069;
import com.corrodinggames.rts.game.units.custom.e.BuiltInResource;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope$CachedWriter;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope$VariableMapping;
import com.corrodinggames.rts.game.units.land.Hovercraft;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.h.class_1009;
import com.corrodinggames.rts.gameFramework.i.ModEngine;
import com.corrodinggames.rts.gameFramework.i.class_800;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import com.corrodinggames.rts.gameFramework.utility.UnitConfig;
import com.corrodinggames.rts.gameFramework.utility.class_669;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import com.corrodinggames.rts.gameFramework.utility.class_694;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.l
public final strictfp class class_591 implements class_31 {
    public static final Rect a = new Rect();
    public static class_591 b;
    public static final ArrayList c = new ArrayList();
    public static ArrayList d = new ArrayList();
    public static ArrayList e = null;
    public static final HashMap f = new HashMap();
    public static ArrayList g = new ArrayList();
    public final class_684 h = new class_684();
    public final class_684 i = new class_684();
    public final class_684 j = new class_684();
    final class_684 k = new class_684();
    public final class_684 l = new class_684();
    public final class_684 m = new class_684();
    public final class_684 n = new class_684();
    public final class_684 o = new class_684();
    final class_684 p = new class_684();
    public final class_684 q = new class_684();
    public final VariableScope$VariableMapping r = new VariableScope$VariableMapping();
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;
    public boolean A = true;
    public boolean B;
    public Rect C;
    public String D;
    public String E;
    public String F;
    public boolean G = true;
    public int H;
    public String I;
    public class_800 J;
    public String K;
    public String L;
    public String M;
    public class_684 N = new class_684();
    public class_588 O;
    public class_588 P;
    public String Q;
    public int R;
    public int S;
    public class_433 T;
    public int U = 1;
    public int V = Integer.MAX_VALUE;
    public int W = -1;
    public int X = -1;
    public int Y;
    public LogicBoolean Z;
    public boolean aa;
    public boolean ab;
    public ColoringMode ac;
    public TeamImageCache ad = null;
    public boolean ae = true;
    public int af;
    public int ag;
    public int ah;
    public int ai;
    public float aj;
    public boolean ak;
    public TeamImageCache al = null;
    public boolean am;
    public TeamImageCache an = null;
    public TeamImageCache ao = null;
    public TeamImageCache ap = null;
    public boolean aq;
    public TeamImageCache[] ar = new TeamImageCache[10];
    public TeamImageCache[] as;
    public TeamImageCache[] at = null;
    public TeamImageCache au = null;
    public boolean av = false;
    public TeamImageCache aw;
    public class_431[] ax = null;
    public boolean ay = false;
    public boolean az = false;
    public final class_684 aA = new class_684();
    public boolean aB;
    public class_388 aC;
    public class_388 aD;
    public String aE;
    public boolean aF;
    public float aG = 1.0F;
    public boolean aH;
    public boolean aI;
    public boolean aJ;
    public boolean aK;
    public float aL;
    public boolean aM;
    public boolean aN;
    public boolean aO;
    public boolean aP;
    public boolean aQ;
    public boolean aR;
    public class_588 aS;
    public boolean aT;
    public boolean aU;
    public boolean aV;
    public boolean aW;
    public int aX = -1;
    public boolean aY;
    public int aZ = -1;
    public boolean ba;
    public float bb;
    public float bc;
    public float bd = 1.0F;
    public float be;
    public float bf;
    public boolean bg;
    public float bh;
    public boolean bi;
    public boolean bj;
    public boolean bk;
    public boolean bl;
    public int bm;
    public boolean bn;
    public float bo;
    public float bp;
    public int bq;
    public boolean br;
    public boolean bs;
    public ExplodeType bt;
    public boolean bu;
    public boolean bv;
    public class_605 bw;
    public class_605 bx;
    public class_605 by;
    public class_392 bz;
    public int bA = -1;
    public int bB = -1;
    public class_395 bC;
    public boolean bD;
    public boolean bE;
    public boolean bF;
    public boolean bG;
    public float bH = 1.0F;
    public float bI = 1.0F;
    boolean bJ;
    boolean bK;
    boolean bL;
    boolean bM;
    boolean bN;
    class_605 bO;
    class_605 bP;
    boolean bQ;
    float bR;
    boolean bS;
    float bT;
    class_605 bU;
    class_605 bV;
    boolean bW;
    float bX;
    class_605 bY;
    class_605 bZ;
    public float ca = 60.0F;
    public CheckRate cb;
    public boolean cc;
    public boolean cd;
    public boolean ce;
    public boolean cf;
    public boolean cg;
    public class_447 ch;
    public class_447 ci;
    public class_447 cj;
    public float ck;
    public int cl;
    public boolean cm;
    public boolean cn;
    public class_447 co;
    public class_1069 cp;
    public class_1069 cq;
    public int cr;
    public float cs;
    public VariableScope$CachedWriter ct;
    public float cu;
    public class_447 cv;
    public class_447 cw;
    public LogicBoolean cx;
    public boolean cy;
    public boolean cz;
    public boolean cA;
    public boolean cB;
    public boolean cC;
    public boolean cD;
    public boolean cE;
    public float cF;
    public int cG;
    public class_588 cH;
    public int cI;
    public float cJ;
    public float cK;
    public class_398 cL;
    public boolean cM;
    public float cN;
    public boolean cO;
    public float cP;
    public float cQ;
    public boolean cR;
    public float cS;
    public class_388 cT;
    public boolean cU;
    public float cV;
    public int cW;
    public Rect cX;
    public Rect cY;
    public Rect cZ;
    public float da;
    public float db;
    public boolean dc;
    public int dd;
    public float de;
    public int df;
    public int dg;
    public int dh;
    public float di;
    public float dj;
    public Float dk;
    public float dl;
    public boolean dm;
    public Float dn;
    public class_392 doo;
    public class_392 dp;
    public class_392 dq;
    class_684 dr;
    class_586 ds;
    class_586 dt;
    class_586 du;
    class_586 dv;
    class_586 dw;
    class_586 dx;
    class_586 dy;
    class_586 dz;
    class_586 dA;
    public boolean dB;
    public boolean dC;
    public boolean dD;
    public boolean dE;
    public class_397 dF;
    public int dG;
    public float dH;
    class_590 dI;
    public float dJ;
    public Boolean dK;
    public boolean dL;
    public float dM;
    public float dN;
    public float dO;
    public boolean dP;
    public boolean dQ;
    public boolean dR;
    public float dS;
    public float dT;
    public float dU;
    public float dV;
    public float dW;
    public boolean dX;
    public boolean dY;
    public int dZ;
    public float ea;
    public float eb;
    public AttackMovementType ec;
    public float ed;
    public float ee;
    public boolean ef;
    public boolean eg;
    public boolean eh;
    public boolean ei;
    public float ej;
    public float ek;
    public float el;
    public int em;
    public int en;
    public float eo;
    public boolean ep;
    public LogicBoolean eq;
    public LogicBoolean er;
    public LogicBoolean es;
    public LogicBoolean et;
    public boolean eu;
    public class_588 ev;
    public class_588 ew;
    public boolean ex;
    public boolean ey;
    public float ez;
    public boolean eA;
    public int eB;
    public boolean eC;
    public boolean eD;
    public boolean eE;
    public boolean eF;
    public float eG;
    public boolean eH;
    public boolean eI;
    public boolean eJ;
    public boolean eK;
    public boolean eL;
    public int eM;
    public float eN;
    public boolean eO;
    public class_588 eP;
    public class_684 eQ;
    public boolean eR;
    public boolean eS;
    public boolean eT;
    public LogicBoolean eU;
    public LogicBoolean eV;
    public LogicBoolean eW;
    public boolean eX;
    public float eY;
    public int eZ;
    public static LogicBoolean fa = LogicBoolean.create((class_591)null, "if not self.isOverLiquid() and not self.isMoving()");
    public static LogicBoolean fb = LogicBoolean.create((class_591)null, "if not self.isOverLiquid()");
    public LogicBoolean fc;
    public LogicBoolean fd;
    public boolean fe;
    public class_387 ff;
    public MovementType fg;
    public MovementType fh;
    public boolean fi;
    public boolean fj;
    public boolean fk;
    public class_588 fl;
    public int fm;
    public class_588 fn;
    public class_588 fo;
    public boolean fp;
    public boolean fq;
    public boolean fr;
    public boolean fs;
    public boolean ft;
    public boolean fu;
    public class_588 fv;
    public boolean fw;
    public int fx;
    public int fy;
    public float fz;
    public int fA;
    public float fB;
    public float fC;
    public float fD;
    public int fE;
    public int fF;
    public boolean fG;
    public class_588 fH;
    public String fI;
    public boolean fJ;
    public float fK;
    public class_684 fL;
    public boolean fM;
    public boolean fN;
    public class_588 fO;
    public boolean fP;
    public class_397[] fQ;
    public class_164[] fR;
    ArrayList fS;
    ArrayList fT;
    boolean fU;
    class_397 fV;
    class_684 fW;
    boolean fX;
    class_597[] fY;
    class_597[] fZ;
    class_597[] ga;
    class_684 gb;
    ArrayList gc;
    ArrayList gd;
    static final class_429[] ge = new class_429[0];
    static final class_429[] gf = new class_429[0];
    ArrayList gg;
    ArrayList gh;
    public boolean gi;
    int gj;
    String gk;
    String gl;
    HashMap gm;
    class_1040[] gn;
    class_243 go;
    class_684 gp;
    class_684 gq;
    public boolean gr;
    public boolean gs;
    class_684 gt;

    public class_591() {
        this.cb = CheckRate.EVERY_FRAME;
        this.ck = 0.001F;
        this.co = class_447.a;
        this.cp = class_1069.a;
        this.cq = class_1069.a;
        this.ct = null;
        this.cu = 1.0F;
        this.cv = class_447.a;
        this.cw = class_447.a;
        this.cI = -2;
        this.cL = new class_398(true);
        this.cX = new Rect();
        this.cY = new Rect();
        this.cZ = new Rect();
        this.dr = new class_684();
        this.ds = new class_586("moving");
        this.dt = new class_586("idle");
        this.du = new class_586("attack");
        this.dS = 0.0F;
        this.dU = -1.0F;
        this.dV = 0.03F;
        this.dW = 0.06F;
        this.em = -1;
        this.en = -1;
        this.eJ = false;
        this.eK = false;
        this.eL = false;
        this.eM = 0;
        this.eQ = new class_684();
        this.eZ = 1;
        this.fe = true;
        this.fK = -1.0F;
        this.fL = new class_684();
        this.fQ = null;
        this.fS = new ArrayList();
        this.fT = new ArrayList();
        this.fU = false;
        this.fV = null;
        this.fW = new class_684();
        this.gb = new class_684();
        this.gc = new ArrayList();
        this.gd = new ArrayList();
        this.gg = new ArrayList();
        this.gh = new ArrayList();
        this.gj = -1;
        this.go = new class_243(this);
        this.gp = new class_684();
        this.gq = new class_684();
        this.gt = new class_684();
    }

    public strictfp String b() {
        String var1 = this.D;
        if (this.J != null) {
            String var2 = this.J.q;
            if (var1.startsWith(var2)) {
                var1 = var1.substring(var2.length());
                if (var1.startsWith("/")) {
                    var1 = var1.substring(1);
                }

                if (var1.startsWith("\\")) {
                    var1 = var1.substring(1);
                }
            }

            var1 = var1 + " (in mod " + this.J.modName() + ")";
        }

        return var1;
    }

    public strictfp class_592 a(String var1, class_592 var2) {
        class_592 var3;
        if (var1 != null) {
            var3 = new class_592(this);
            var3.a = var1;
            var3.a();
            return var3;
        } else if (var2 != null) {
            var3 = new class_592(this);
            var3.a = var2.a;
            var3.a();
            return var3;
        } else {
            return null;
        }
    }

    @SneakyThrows
    strictfp class_586 a(ActionType var1, class_586 var2, boolean var3) {
        class_586 var4 = this.a(var1);
        if (var4 != null) {
            if (var3 && var2 != null && var2.a()) {
                throw new CustomException("Cannot define animation " + var1.name() + " on graphics and with onAction at same time");
            } else {
                return var4;
            }
        } else {
            return var2;
        }
    }

    public static strictfp String a(String var0) {
        var0 = var0.toLowerCase(Locale.ROOT);
        var0 = var0.trim();
        if (var0.startsWith("arm_")) {
            var0 = "arm" + var0.substring("arm_".length());
        }

        if (var0.startsWith("leg_")) {
            var0 = "leg" + var0.substring("leg_".length());
        }

        return var0;
    }

    public strictfp int b(String var1) {
        var1 = a(var1);
        GameEngine.log("name:" + var1);

        for(int var2 = 0; var2 < this.ax.length; ++var2) {
            GameEngine.log("checking:" + this.ax[var2].b);
            if (var1.equals(this.ax[var2].b)) {
                GameEngine.log("got");
                return var2;
            }
        }

        return -1;
    }

    strictfp class_586 a(ActionType var1) {
        Iterator var2 = this.dr.iterator();

        class_586 var3;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            var3 = (class_586)var2.next();
        } while(!var3.a(var1));

        return var3;
    }

    public strictfp void a(class_599 var1) {
        this.gb.add(var1);
    }

    public strictfp class_605 a(String var1, class_605 var2) {
        if (var1 == null && var2 != null) {
            return var2;
        } else {
            class_605 var3 = new class_605(this, var1, (class_607)null);
            var3.c();
            return var3;
        }
    }

    public strictfp class_605 c(String var1) {
        class_605 var2 = new class_605(this, var1, (class_607)null);
        return var2;
    }

    @SneakyThrows
    public strictfp class_429 d(String var1) {
        boolean var2 = false;
        boolean var3 = false;
        String var4 = var1.toUpperCase();
        if (var4.startsWith("CUSTOM:")) {
            var1 = var1.substring("CUSTOM:".length());
            var1 = var1.trim();
            var2 = true;
        }

        if (var4.startsWith("CUSTOM|")) {
            var1 = var1.substring("CUSTOM|".length());
            var1 = var1.trim();
            var2 = true;
        }

        if (var4.startsWith("BUILTIN:") || var4.startsWith("BUILTIN|")) {
            var1 = var1.substring("BUILTIN:".length());
            var1 = var1.trim();
            var3 = true;
        }

        Iterator var5;
        class_429 var6;
        if (var2) {
            var5 = this.gd.iterator();

            do {
                if (!var5.hasNext()) {
                    throw new CustomException("Failed to find custom effect with the name:" + var1);
                }

                var6 = (class_429)var5.next();
            } while(!var1.equalsIgnoreCase(var6.name));

            return var6;
        } else if (var1.contains(":")) {
            throw new CustomException("Unknown effect format:" + var1 + " expected built-in effect or CUSTOM:");
        } else if (var1.contains("|")) {
            throw new CustomException("Unknown effect format:" + var1 + " expected built-in effect or CUSTOM|");
        } else {
            if (!var3) {
                var5 = this.gd.iterator();

                while(var5.hasNext()) {
                    var6 = (class_429)var5.next();
                    if (var1.equalsIgnoreCase(var6.name)) {
                        return var6;
                    }
                }
            }

            if ("small".equalsIgnoreCase(var1)) {
                return new class_429(EffectType.SMALL);
            } else if ("medium".equalsIgnoreCase(var1)) {
                return new class_429(EffectType.MEDIUM);
            } else if ("large".equalsIgnoreCase(var1)) {
                return new class_429(EffectType.LARGE);
            } else if ("smoke".equalsIgnoreCase(var1)) {
                return new class_429(EffectType.SMOKE);
            } else if ("shockwave".equalsIgnoreCase(var1)) {
                return new class_429(EffectType.SHOCKWAVE);
            } else if ("largeExplosion".equalsIgnoreCase(var1)) {
                return new class_429(EffectType.LARGE_EXPLOSION);
            } else if ("smallExplosion".equalsIgnoreCase(var1)) {
                return new class_429(EffectType.SMALL_EXPLOSION);
            } else if ("resourcePoolSmoke".equalsIgnoreCase(var1)) {
                return new class_429(EffectType.RESOURCE_POOL_SMOKE);
            } else if ("none".equalsIgnoreCase(var1)) {
                return new class_429(EffectType.NONE_EXPLOSION);
            } else {
                throw new CustomException("Failed to find built-in or custom effect with the name:" + var1);
            }
        }
    }

    public strictfp boolean C() {
        return this.ce;
    }

    public strictfp boolean w() {
        if (this.cg) {
            GameEngine var1 = GameEngine.getGameEngine();
            if (var1.O() && var1.netEngine.gameMapData.nukes) {
                return true;
            }
        }

        return this.cf;
    }

    public strictfp int price() {
        return this.ch.a();
    }

    public strictfp class_447 u() {
        return this.ch;
    }

    public strictfp class_447 B() {
        return this.cj;
    }

    public strictfp class_447 d(int var1) {
        return this.ch;
    }

    public strictfp float D() {
        return this.ck;
    }

    public strictfp int g() {
        return this.cl;
    }

    public strictfp Unit a() {
        return a(false, this);
    }

    public strictfp Unit a(boolean var1) {
        return a(var1, this);
    }

    public strictfp String e() {
        if (this.gj != class_1009.c || this.gk == null) {
            this.gj = class_1009.c;
            String var1 = this.aC != null ? this.aC.b() : this.M;
            String var2 = this.M;
            if (this.aE != null) {
                var2 = this.aE;
            }

            this.gk = class_1009.a("units." + var2 + ".name", var1);
        }

        return this.gk;
    }

    public strictfp String f() {
        if (this.gj != class_1009.c || this.gl == null) {
            this.gj = class_1009.c;
            String var1 = this.aD != null ? this.aD.b() : this.M;
            String var2 = this.M;
            if (this.aE != null) {
                var2 = this.aE;
            }

            this.gl = class_1009.a("units." + var2 + ".description", var1);
        }

        return this.gl;
    }

    public strictfp boolean j() {
        return this.aH;
    }

    public strictfp boolean k() {
        return this.aI;
    }

    public strictfp boolean m() {
        return this.fq;
    }

    public strictfp boolean n() {
        return this.fr;
    }

    public strictfp boolean l() {
        return this.fp;
    }

    public strictfp MovementType o() {
        return this.fg;
    }

    public strictfp boolean p() {
        return this.aJ;
    }

    public strictfp class_387 q() {
        return this.ff;
    }

    public strictfp void a(ArrayList var1, int var2) {
        if (this.eM != 0 && this.eT) {
            var1.add(Hovercraft.i);
            var1.add(Hovercraft.j);
        }

    }

    public strictfp void h() {
        this.gm = null;
        this.gn = new class_1040[3];

        for(int var1 = 1; var1 <= 3; ++var1) {
            class_1040 var2 = new class_1040();
            this.a(var2.a, var1);
            this.gn[var1 - 1] = var2;
        }

    }

    public strictfp ArrayList a(int var1) {
        if (this.gn == null) {
            GameEngine var2 = GameEngine.getGameEngine();
            boolean var3 = d.contains(this);
            throw new RuntimeException("specialActionLists==null for:" + this.M + " t:" + var1 + " networked:" + var2.N() + " replay:" + var2.replayEngine.j() + " sandbox:" + var2.bv + " active: " + var3);
        } else {
            return this.gn[var1 - 1].a;
        }
    }

    public strictfp void r() {
        ArrayList var1 = this.a(this.cl);
        if (var1.size() > 4) {
            this.gm = new HashMap();
            int var2 = 0;

            for(int var3 = var1.size(); var2 < var3; ++var2) {
                class_226 var4 = (class_226)var1.get(var2);
                if (this.gm.get(var4.N()) == null) {
                    this.gm.put(var4.N(), var4);
                }
            }
        }

    }

    public strictfp class_226 a(class_1059 var1) {
        if (this.gm != null) {
            return (class_226)this.gm.get(var1);
        } else {
            ArrayList var2 = this.a(this.cl);
            int var3 = 0;

            for(int var4 = var2.size(); var3 < var4; ++var3) {
                class_226 var5 = (class_226)var2.get(var3);
                if (var5.d(var1)) {
                    return var5;
                }
            }

            return null;
        }
    }

    public strictfp String i() {
        return this.M;
    }

    public strictfp String v() {
        return this.M;
    }

    public strictfp int b(int var1) {
        int var2 = this.price();
        return var2;
    }

    public strictfp class_243 d() {
        return this.go;
    }

    public strictfp class_601 a(String var1, String var2, String var3) {
        if (var1 == null) {
            return null;
        } else {
            class_601 var4 = new class_601();
            var4.a = var2;
            var4.b = var3;
            var4.c = var1;
            this.p.add(var4);
            return var4;
        }
    }

    public strictfp class_603 b(String var1, String var2, String var3) {
        class_603 var4 = new class_603();
        var4.a = var2;
        var4.b = var3;
        var4.c = "(known unit:)" + this.i();
        var4.d = this;
        var4.e = true;
        var4.g = var1;
        this.p.add(var4);
        return var4;
    }

    public strictfp class_598 c(String var1, String var2, String var3) {
        if (var1 != null && !var1.trim().equals("")) {
            class_598 var4 = new class_598();
            var4.c = var2;
            var4.d = var3;
            String[] var5 = class_340.c(var1, ',');
            int var6 = var5.length;

            for(int var7 = 0; var7 < var6; ++var7) {
                String var8 = var5[var7];
                var8 = var8.trim();
                var4.a.add(var8);
            }

            this.gp.add(var4);
            return var4;
        } else {
            return null;
        }
    }

    public static strictfp class_601 a(class_31 var0) {
        if (var0 == null) {
            return null;
        } else {
            class_601 var1 = new class_601();
            var1.a = "known";
            var1.d = var0;
            var1.e = true;
            return var1;
        }
    }

    public static strictfp class_591 c(int var0) {
        if (var0 >= 100) {
            int var1 = var0 - 100;
            if (var1 < g.size()) {
                class_591 var2 = (class_591)g.get(var1);
                return var2;
            }
        }

        return null;
    }

    public static strictfp ArrayList s() {
        ArrayList var0 = new ArrayList();
        int var1 = 100;

        for(Iterator var2 = g.iterator(); var2.hasNext(); ++var1) {
            class_591 var3 = (class_591)var2.next();
            var0.add(var1);
        }

        return var0;
    }

    public strictfp class_588 x() {
        return this.O;
    }

    public strictfp class_397 e(String var1) {
        Iterator var2 = this.fS.iterator();

        class_397 var3;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            var3 = (class_397)var2.next();
        } while(!var3.a.equalsIgnoreCase(var1));

        return var3;
    }

    public strictfp class_164 f(String var1) {
        Iterator var2 = this.fT.iterator();

        class_164 var3;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            var3 = (class_164)var2.next();
        } while(!var3.bh.equalsIgnoreCase(var1));

        return var3;
    }

    public strictfp class_1037 g(String var1) {
        Iterator var2 = this.gh.iterator();

        class_1037 var3;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            var3 = (class_1037)var2.next();
        } while(var3.c == null || !var3.c.equalsIgnoreCase(var1));

        return var3;
    }

    public strictfp class_226 h(String var1) {
        ArrayList var2 = this.a(this.cl);
        Iterator var3 = var2.iterator();

        while(var3.hasNext()) {
            class_226 var4 = (class_226)var3.next();
            if (var4 instanceof class_283) {
                class_283 var5 = (class_283)var4;
                if (var5.a.c.equalsIgnoreCase(var1)) {
                    return var5;
                }
            }
        }

        return null;
    }

    public strictfp void a(class_827 var1) {
        if (!this.h.contains(var1)) {
            this.h.add(var1);
        }

    }

    public strictfp void b(class_827 var1) {
        if (!this.i.contains(var1)) {
            this.i.add(var1);
        }

    }

    public strictfp void a(class_447 var1) {
        if (var1 != null && var1.b != 0) {
            if (this.gs) {
                GameEngine.warn("usesCreditResources:" + var1);
            }

            this.gr = true;
        }

    }

    public strictfp class_826 i(String var1) {
        Iterator var2 = this.aA.iterator();

        class_826 var3;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            var3 = (class_826)var2.next();
        } while(!var3.b().equalsIgnoreCase(var1));

        return var3;
    }

    public strictfp BuiltInResource j(String var1) {
        BuiltInResource var2 = BuiltInResource.a(var1);
        return var2 != null ? var2 : this.k(var1);
    }

    public strictfp BuiltInResource k(String var1) {
        Iterator var2 = this.j.iterator();

        class_1068 var3;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            var3 = (class_1068)var2.next();
        } while(!var3.a.equalsIgnoreCase(var1));

        return var3.b;
    }

    public strictfp class_1068 a(BuiltInResource var1) {
        Iterator var2 = this.j.iterator();

        class_1068 var3;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            var3 = (class_1068)var2.next();
        } while(var3.b != var1);

        return var3;
    }

    public strictfp class_634 a(class_585 var1) {
        Iterator var2 = this.l.iterator();

        class_634 var3;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            var3 = (class_634)var2.next();
        } while(var3.g != var1);

        return var3;
    }

    public strictfp class_634 l(String var1) {
        Iterator var2 = this.l.iterator();

        class_634 var3;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            var3 = (class_634)var2.next();
        } while(!var3.g.a.equals(var1));

        return var3;
    }

    public strictfp boolean y() {
        return this.gr;
    }

    public strictfp String t() {
        return this.J != null ? this.J.modName() : null;
    }

    public static strictfp void a(GameOutputStream var0) {
        var0.e("customUnits");
        var0.writeInt(1);
        var0.writeInt(d.size());
        Iterator var1 = d.iterator();

        while(var1.hasNext()) {
            class_591 var2 = (class_591)var1.next();
            var0.writeString(var2.M);
            var0.writeInt(var2.H);
            var0.writeBoolean(true);
            var0.writeIsString(var2.t());
            long var3 = 0L;
            if (var2.J != null && var2.J.k != 0L) {
                var3 = var2.J.k;
            }

            var0.writeLong(var3);
            long var5 = 0L;
            var0.writeLong(var5);
        }

        var0.endBlock("customUnits");
    }

    @SneakyThrows
    public static strictfp void a(class_435 var0, HashMap var1) {
        ArrayList var2 = new ArrayList();
        ArrayList var3 = new ArrayList();
        boolean var4 = var0.a == null;
        String var11;
        if (!var4) {
            Iterator var5 = var1.values().iterator();

            while(true) {
                while(var5.hasNext()) {
                    class_432 var6 = (class_432)var5.next();
                    if (var6.b == 0 && var6.d == 0 && var6.c > 0) {
                        var2.add(var6);
                    } else if (var6.c > 0 || var6.d > 0) {
                        var3.add(var6);
                    }
                }

                var11 = null;
                String var12 = "";
                String var7;
                boolean var8;
                Iterator var9;
                class_432 var10;
                if (var2.size() > 0) {
                    var7 = "";
                    var8 = true;

                    for(var9 = var2.iterator(); var9.hasNext(); var7 = var7 + "'" + var10.a + "'") {
                        var10 = (class_432)var9.next();
                        if (var8) {
                            var8 = false;
                        } else {
                            var7 = var7 + ", \n";
                        }
                    }

                    var7 = class_340.b(var7, (int)200);
                    if (var2.size() == 1) {
                        var11 = "Missing 1 mod.";
                        var12 = "Missing mod: '" + ((class_432)var2.get(0)).a + "'";
                    } else {
                        var11 = "Missing " + var2.size() + " mods";
                        var12 = "missing mods: " + var7;
                    }

                    var12 = var12 + "\n Required by this server.";
                    if (var3.size() > 0) {
                        var12 = var12 + "\n and " + var3.size() + " mods are different.";
                    }
                } else if (var3.size() <= 0) {
                    GameEngine.log("Skipping nice message: completelyMissedMods:" + var2.size() + " differentMods:" + var3.size());
                } else {
                    var7 = "";
                    var8 = true;

                    for(var9 = var3.iterator(); var9.hasNext(); var7 = var7 + "'" + var10.a + "'") {
                        var10 = (class_432)var9.next();
                        if (var8) {
                            var8 = false;
                        } else {
                            var7 = var7 + ", \n";
                        }
                    }

                    var7 = class_340.b(var7, (int)200);
                    var11 = "Different mod data.";
                    var12 = "Different mod data for: " + var7 + " \n Check these mods are the same version as the server you are connecting to.";
                }

                if (var11 != null) {
                    UnitException var14 = new UnitException(var12, "");
                    var14.a = var11;
                    throw var14;
                }
                break;
            }
        }

        var11 = "from internal units";
        if (var0.a != null) {
            var11 = "from mod:'" + var0.a + "'";
        }

        class_800 var13 = GameEngine.getGameEngine().bZ.f(var0.a);
        if (var13 != null) {
            if (!var13.m()) {
                var11 = var11 + " (You seem to have this mod but it is not enabled)";
            } else {
                var11 = var11 + " (You seem to have this mod but it might be a different version)";
            }
        }

        if (var0.d == -1) {
            throw new UnitException("The server requires the unit:" + var0.b + " that was not found " + var11, "");
        } else {
            throw new UnitException("Found unit:" + var0.b + " but it does not match the server's copy " + var11, "checksum c:" + var0.d + " s:" + var0.c);
        }
    }

    public static strictfp void a(GameInputStream var0) {
        var0.startBlock("customUnits");

        try {
            ArrayList var1 = new ArrayList();
            ArrayList var2 = new ArrayList();
            HashMap var3 = new HashMap();
            int var4 = var0.readInt();
            boolean var5 = false;
            if (var4 >= 2) {
                var5 = var0.readBoolean();
                var0.readBoolean();
            }

            int var6 = var0.readInt();

            for(int var7 = 0; var7 < var6; ++var7) {
                String var8 = var0.readString();
                int var9 = var0.readInt();
                boolean var10 = var0.readBoolean();
                String var11 = var0.isReadString();
                long var12 = var0.readLong();
                long var14 = var0.readLong();
                String var16 = null;
                if (var5) {
                    var16 = var0.isReadString();
                }

                class_591 var17 = null;
                int var18 = -1;
                class_591 var19 = null;
                synchronized(c) {
                    Iterator var21 = c.iterator();

                    while(var21.hasNext()) {
                        class_591 var22 = (class_591)var21.next();
                        if (var8.equals(var22.M)) {
                            if (var9 == var22.H) {
                                var17 = var22;
                            } else {
                                var19 = var22;
                                var18 = var22.H;
                            }
                        }
                    }
                }

                class_432 var20 = (class_432)var3.get(var11);
                if (var20 == null) {
                    var20 = new class_432(var11);
                    var3.put(var11, var20);
                }

                if (var17 == null) {
                    if (var19 != null) {
                        ++var20.d;
                    } else {
                        ++var20.c;
                    }

                    class_435 var29 = new class_435();
                    var29.a = var11;
                    var29.b = var8;
                    var29.d = var18;
                    var29.c = var9;
                    var29.f = var19;
                    var29.e = var16;
                    var2.add(var29);
                    GameEngine.print(var29.a());
                } else {
                    ++var20.b;
                    var1.add(var17);
                }
            }

            if (var2.size() > 0) {
                Iterator var30 = var2.iterator();

                while(var30.hasNext()) {
                    class_435 var31 = (class_435)var30.next();
                    if (var31.a == null) {
                        a(var31, var3);
                    }
                }

                a((class_435)var2.get(0), var3);
            }

            e = var1;
        } finally {
            var0.endBlock("customUnits");
        }

    }

    public strictfp void b(class_31 var1) {
        if (!this.fL.contains(var1) && var1 != this) {
            this.fL.add(var1);
        }

        if (var1 instanceof class_591) {
            Iterator var2 = ((class_591)var1).fL.iterator();

            while(var2.hasNext()) {
                class_31 var3 = (class_31)var2.next();
                if (!this.fL.contains(var3) && var1 != this) {
                    this.fL.add(var3);
                }
            }
        }

    }

    public static strictfp class_591 a(class_591 var0) {
        Iterator var1 = d.iterator();

        class_591 var2;
        do {
            if (!var1.hasNext()) {
                var1 = d.iterator();

                do {
                    if (!var1.hasNext()) {
                        return null;
                    }

                    var2 = (class_591)var1.next();
                } while(!var0.M.equals(var2.M));

                return var2;
            }

            var2 = (class_591)var1.next();
        } while(!var0.D.equals(var2.D));

        return var2;
    }

    public static strictfp void A() {
        Iterator var0 = Unit.bF().iterator();

        while(var0.hasNext()) {
            Unit var1 = (Unit)var0.next();
            if (var1 instanceof class_113) {
                class_113 var2 = (class_113)var1;
                class_591 var3 = var2.x;
                if (!d.contains(var3)) {
                    class_591 var4 = a(var3);
                    if (var4 == null) {
                        var4 = b;
                    }

                    if (var4 != null) {
                        var2.a(var4, false, true);
                    }
                }
            }
        }

    }

    public strictfp TeamImageCache[] a(TeamImageCache var1, ColoringMode var2) {
        boolean var3 = false;
        if ((this.J != null || this.eE) && !GameEngine.getGameEngine().settingsEngine.disableModLazyLoad) {
            var3 = true;
        }

        if (this.cy && this.cz || this.cE) {
            var3 = true;
        }

        TeamImageCache[] var4 = PlayerData.a(var1, var2, var3);

        for(int var5 = 0; var5 < var4.length; ++var5) {
            if (var3 && this.J != null && this.eE && var5 == 1) {
                var4[var5].w();
            }
        }

        class_436.a(var4);
        return var4;
    }

    public strictfp TeamImageCache a(UnitConfig var1, String var2, String var3) {
        return this.a(var1, var2, var3, this.ab);
    }

    public strictfp TeamImageCache a(UnitConfig var1, String var2, String var3, boolean var4) {
        String var5 = var1.getValueAsStaticString(var2, var3, (String)null);
        return this.a(this.F, var5, var4, var2, var3);
    }

    public strictfp TeamImageCache a(String var1, String var2, boolean var3, String var4, String var5) {
        TeamImageCache var6 = class_436.a(var1, var2, var3, this, var4, var5);
        return var6;
    }

    public static strictfp class_31 m(String var0) {
        Iterator var1 = f.keySet().iterator();

        class_31 var2;
        do {
            if (!var1.hasNext()) {
                return null;
            }

            var2 = (class_31)var1.next();
        } while(!var2.i().equals(var0));

        return (class_31)f.get(var2);
    }

    public static strictfp class_31 c(class_31 var0) {
        return (class_31)f.get(var0);
    }

    public static strictfp class_591 n(String var0) {
        Iterator var1 = d.iterator();

        class_591 var2;
        do {
            if (!var1.hasNext()) {
                var1 = d.iterator();

                do {
                    if (!var1.hasNext()) {
                        return null;
                    }

                    var2 = (class_591)var1.next();
                } while(!var2.N.contains(var0));

                return var2;
            }

            var2 = (class_591)var1.next();
        } while(!var0.equals(var2.M));

        return var2;
    }

    public static strictfp String E() {
        String var0 = "";

        Iterator var1;
        class_591 var2;
        for(var1 = d.iterator(); var1.hasNext(); var0 = var0 + var2.M + ", ") {
            var2 = (class_591)var1.next();
        }

        var1 = d.iterator();

        while(var1.hasNext()) {
            var2 = (class_591)var1.next();

            String var4;
            for(Iterator var3 = var2.N.iterator(); var3.hasNext(); var0 = var0 + var4 + ", ") {
                var4 = (String)var3.next();
            }
        }

        return var0;
    }

    public static strictfp class_113 a(boolean var0, class_591 var1) {
        class_113 var2 = new class_113(var0, var1);
        return var2;
    }

    public strictfp void o(String var1) {
        if (!class_669.i(var1)) {
            class_434 var2 = new class_434(var1);
            this.k.add(var2);
        }
    }

    public strictfp void p(String var1) {
        class_436.a((String)this.i(), (Exception)(new CustomException(var1)), (class_31)this);
    }

    public strictfp void q(String var1) {
        String var2 = "Warning (on " + this.b() + "): " + var1;
        GameEngine.print(var2);
        this.gt.add(var1);
        if (this.J == null) {
            GameEngine.getGameEngine().log(var2, 1);
            if (GameEngine.aT) {
                GameEngine.log("Crashing on allowed unit warning because automated testing is active");
                throw new RuntimeException(var2);
            }
        }

    }

    public strictfp void r(String var1) {
        String var2 = "Warning (on " + this.b() + "): " + var1;
        GameEngine.print(var2);
        this.gt.add(var1);
        if (this.J == null) {
            GameEngine.getGameEngine().log(var2, 1);
            if (GameEngine.aT) {
                GameEngine.log("Crashing on allowed unit warning because automated testing is active");
                throw new RuntimeException(var2);
            }
        } else {
            this.J.b(var2);
        }

    }

    public strictfp TeamImageCache z() {
        return this.aw;
    }

    public static strictfp void F() {
        GameEngine var0 = GameEngine.getGameEngine();
        Iterator var1 = d.iterator();

        while(true) {
            while(true) {
                while(true) {
                    label62:
                    while(true) {
                        class_591 var2;
                        class_433 var3;
                        do {
                            if (!var1.hasNext()) {
                                return;
                            }

                            var2 = (class_591)var1.next();
                            var3 = var2.T;
                        } while(var3 == null);

                        Iterator var4;
                        Unit var6;
                        if (var3 != class_433.a && var3 != class_433.b) {
                            PlayerData var9;
                            if (var3 != class_433.c && var3 != class_433.d) {
                                if (var3 == class_433.e) {
                                    var4 = PlayerData.c().iterator();

                                    while(var4.hasNext()) {
                                        var9 = (PlayerData)var4.next();
                                        if (var9.a(true, false) > 0) {
                                            PointF var10 = new PointF();
                                            class_694.a(var9, var10);
                                            Unit var11 = var2.a();
                                            var11.b(var9);
                                            var0.bL.b(var10.x, var10.y);
                                            var11.xCord = (float)var0.bL.T;
                                            var11.yCord = (float)var0.bL.U;
                                            var11.xCord += var11.cZ();
                                            var11.yCord += var11.da();
                                            PlayerData.c(var11);
                                        }
                                    }
                                } else {
                                    GameEngine.print("onNewMapSpawn unhandled: " + var2.T);
                                }
                            } else {
                                if (var3 == class_433.c) {
                                    Unit var8 = var2.a();
                                    var8.b(PlayerData.i);
                                    var0.bL.b(var0.bL.i() / 2.0F, var0.bL.j() / 2.0F);
                                    var8.xCord = (float)var0.bL.T;
                                    var8.yCord = (float)var0.bL.U;
                                    var8.xCord += var8.cZ();
                                    var8.yCord += var8.da();
                                    PlayerData.c(var8);
                                }

                                if (var3 == class_433.d) {
                                    var4 = PlayerData.c().iterator();

                                    while(var4.hasNext()) {
                                        var9 = (PlayerData)var4.next();
                                        if (var9.a(true, false) > 0) {
                                            var6 = var2.a();
                                            var6.b(var9);
                                            var0.bL.b(var0.bL.i() / 2.0F, var0.bL.j() / 2.0F);
                                            var6.xCord = (float)var0.bL.T;
                                            var6.yCord = (float)var0.bL.U;
                                            var6.xCord += var6.cZ();
                                            var6.yCord += var6.da();
                                            PlayerData.c(var6);
                                        }
                                    }
                                }
                            }
                        } else {
                            var4 = var0.bL.A.iterator();

                            while(true) {
                                while(true) {
                                    if (!var4.hasNext()) {
                                        continue label62;
                                    }

                                    Point var5 = (Point)var4.next();
                                    var6 = var2.a();
                                    var6.b(PlayerData.i);
                                    var0.bL.a(var5.a, var5.b);
                                    var6.xCord = (float)var0.bL.T;
                                    var6.yCord = (float)var0.bL.U;
                                    var6.xCord += var6.cZ();
                                    var6.yCord += var6.da();
                                    if (var3 == class_433.a && var6 instanceof OrderableUnit) {
                                        OrderableUnit var7 = (OrderableUnit)var6;
                                        if (var7.a((Unit)null, (PlayerData)null)) {
                                            var6.ci();
                                            continue;
                                        }
                                    }

                                    PlayerData.c(var6);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public strictfp int a(Unit var1) {
        int var2 = 0;
        if (this.aL > 0.0F) {
            return (int)this.aL;
        } else {
            if (this.aJ && this.aH && var1.y() < 20) {
                var2 += 17;
            }

            return var2;
        }
    }

    @SneakyThrows
    public strictfp void a(String var1, int var2, String var3, String var4) {
        if (this.J != null) {
            if (this.J.w < var2) {
                if (this.J.r) {
                    if (this.J.v == null) {
                        throw new CustomException("[" + var3 + "] minVersion of " + var1 + " is required to be set in mod-info.txt at the root of this mod to use " + var4);
                    } else {
                        try {
                            ModEngine.a(var1, this.J.v);
                        } catch (Exception var6) {
                            throw new CustomException("[" + var3 + "]" + var4 + " " + var6.getMessage() + " to be set as minVersion in mod-info.txt");
                        }

                        this.J.w = var2;
                    }
                }
            }
        }
    }

    public static strictfp class_31 s(String var0) {
        return a(var0, true);
    }

    public static strictfp class_31 a(String var0, boolean var1) {
        class_31 var2 = UnitType.a(var0, var1);
        return (class_31)(var2 == UnitType.editorOrBuilder ? UnitType.builder : var2);
    }
}
