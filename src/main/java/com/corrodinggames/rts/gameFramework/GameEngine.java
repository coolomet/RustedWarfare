package com.corrodinggames.rts.gameFramework;

import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.KeyEvent;
import com.corrodinggames.rts.appFramework.class_0;
import com.corrodinggames.rts.appFramework.class_200;
import com.corrodinggames.rts.appFramework.class_208;
import com.corrodinggames.rts.game.EngineLoad;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.maps.class_484;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.custom.class_388;
import com.corrodinggames.rts.game.units.p026f.UnitGeoIndex;
import com.corrodinggames.rts.gameFramework.a.class_648;
import com.corrodinggames.rts.gameFramework.d.class_986;
import com.corrodinggames.rts.gameFramework.e.class_697;
import com.corrodinggames.rts.gameFramework.f.InterfaceEngine;
import com.corrodinggames.rts.gameFramework.f.class_537;
import com.corrodinggames.rts.gameFramework.g.class_162;
import com.corrodinggames.rts.gameFramework.g.class_169;
import com.corrodinggames.rts.gameFramework.g.class_173;
import com.corrodinggames.rts.gameFramework.i.ModEngine;
import com.corrodinggames.rts.gameFramework.k.PathEngine;
import com.corrodinggames.rts.gameFramework.l.class_1039;
import com.corrodinggames.rts.gameFramework.m.class_28;
import com.corrodinggames.rts.gameFramework.n.class_70;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameNetEngine;
import com.corrodinggames.rts.gameFramework.net.MapType;
import com.corrodinggames.rts.gameFramework.utility.class_21;
import com.corrodinggames.rts.gameFramework.utility.class_680;
import com.corrodinggames.rts.gameFramework.utility.class_700;
import lombok.SneakyThrows;

import java.io.File;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract strictfp class GameEngine {
    public final Object aj = new Object();
    public final Object ak = new Object();
    protected static GameEngine gameEngine = null;
    public Context am = null;
    public Context an;
    public class_0 ao;
    public class_0 ap;
    public boolean aq;
    public boolean ar = false;
    public static boolean as = true;
    public static boolean at = false;
    public static boolean au = false;
    public static Throwable av;
    public static boolean aw = false;
    public static boolean ax = false;
    public static boolean ay;
    public static boolean az;
    public static boolean aA;
    public static boolean aB;
    public static boolean aC;
    public static boolean aD;
    public static boolean aE;
    public static boolean aF;
    public static boolean aG;
    public static boolean aH = false;
    public static boolean aI = false;
    public static boolean aJ;
    public static String aK = null;
    public static boolean aL = false;
    public static boolean aM = false;
    public static boolean aN = false;
    public static boolean aO = false;
    public static boolean aP = false;
    public static String aQ = null;
    public static boolean aR;
    public boolean aS;
    public static boolean aT = false;
    public static boolean isModsInSD = false;
    public static boolean aV = false;
    public static boolean aW = false;
    public static boolean aX = false;
    public static boolean aY = false;
    public static boolean aZ = false;
    public static String ba = null;
    public static boolean bb = false;
    public static boolean bc = true;
    public static boolean bd = true;
    public static boolean be = false;
    public static boolean bf = false;
    public static Class bg;
    public static class_28 bh;
    public boolean bi = false;
    public boolean bj;
    public boolean bk = false;
    public boolean bl = false;
    public boolean bm = false;
    public boolean bn = false;
    public boolean bo = false;
    public boolean bp;
    public boolean bq = false;
    public boolean br = false;
    public PlayerData playerTeam;
    public float bt = 1.0F;
    public float bu = -1.0F;
    public boolean bv;
    public boolean bw;
    public int tick = 0;
    public int by;
    public int bz;
    public int bA;
    public int bB;
    public int bC;
    public boolean bD;
    public boolean bE = false;
    public volatile boolean bF = false;
    public volatile boolean bG = false;
    public volatile boolean bH = false;
    public volatile boolean bI = false;
    public int bJ;
    public class_680 bK;
    public class_484 bL;
    public class_648 bM;
    public class_1001 bN;
    public class_28 bO;
    public CollisionEngine bP;
    public SettingsEngine settingsEngine;
    public class_986 bR;
    public InterfaceEngine bS;
    public class_985 bT;
    public PathEngine bU;
    public GroupController bV;
    public class_537 bW;
    public GameNetEngine netEngine;
    public StatsHandler stats;
    public ModEngine bZ;
    public GameSaver ca;
    public ReplayEngine replayEngine;
    public UnitGeoIndex cc;
    public com.corrodinggames.rts.gameFramework.Unit cd;
    public class_70 ce;
    public CommandController cf;
    public class_162 cg = new class_162();
    public boolean ch = false;
    public float ci;
    public float cj;
    public static Point ck;
    public float cl;
    public float cm;
    public float cn = 1.0F;
    public float co;
    public float cp;
    public float cq;
    public float cr;
    public float cs;
    public boolean ct;
    public int cu;
    public int cv;
    public float cw;
    public float cx;
    public float cy;
    public float cz;
    public float cA;
    public float cB;
    public float cC;
    public float cD;
    public float cE;
    public float cF;
    public float cG;
    public float cH;
    public float cI;
    public float cJ;
    public final Rect cK = new Rect();
    public final Rect cL = new Rect();
    public final RectF cM = new RectF();
    public final Rect cN = new Rect();
    public final RectF cO = new RectF();
    public final RectF cP = new RectF();
    public final Rect cQ = new Rect();
    public boolean cR;
    public boolean cS;
    public float cT;
    public boolean cU;
    public float cV = 1.0F;
    public boolean cW = false;
    public float cX = 1.0F;
    public float cY = 1.0F;
    public boolean cZ;
    public float da;
    public float db;
    public boolean dc = true;
    public boolean dd = true;
    public boolean de = true;
    public boolean df = true;
    public boolean dg = true;
    public float dh = 0.0F;
    public float di = 0.0F;
    public boolean dj = false;
    protected GameThread gameThread = null;
    public String dl;
    public GameInputStream dm;
    public Paint dn;
    public Paint doo;
    public Paint dp;
    public boolean dq = false;
    public boolean dr = false;
    public float ds = 0.0F;
    public boolean dt = false;
    public boolean du = false;
    public boolean dv = false;
    public int dw;
    public float dx = 0.0F;
    public static class_331 dy = new class_332();
    public static String dz;
    float dA;
    boolean dB = false;
    ArrayList dC = new ArrayList();
    final Handler dD = new Handler(Looper.b());
    public String dE;
    private Runnable a = new GameEngine$1(this);
    public String dF;
    public String dG;
    private Runnable b = new GameEngine$2(this);
    public class_359 dH = null;
    transient String dI = null;
    Object dJ = new Object();
    String dK;
    String dL;
    public boolean[] dM = new boolean[10];
    protected ConcurrentLinkedQueue dN = new ConcurrentLinkedQueue();
    private boolean[] c = new boolean[KeyEvent.a() + 1];
    private boolean[] d = new boolean[KeyEvent.a() + 1];
    private int e;
    public static boolean dO;
    static byte[] dP;
    static byte[] dQ;
    static byte[] dR;
    static class_700 dS;
    static boolean dT;
    static int dU;
    static boolean dV;
    static class_338 dW;
    static boolean dX;
    static boolean dY;
    public byte dZ = 42;
    public byte ea = 42;
    public final class_361 eb = new class_361();
    public final class_361 ec = new class_361();
    public final class_361 ed = new class_361();
    public boolean ee;
    public boolean ef;
    public String eg;
    public boolean eh;
    public boolean ei;
    static int ej;

    public static strictfp boolean b(Context var0) {
        String var1 = null;
        if (isModsInSD) {
            var1 = "dedicatedServer";
        } else {
            var1 = var0.g().h();
        }

        Log.d("RustedWarfare", "packageName:" + var1);
        return var1.contains("rtsdemo");
    }

    public strictfp boolean A() {
        return this.cS || this.cT > 0.0F || this.cU;
    }

    public static final strictfp GameEngine getGameEngine() {
        return gameEngine;
    }

    public static final strictfp boolean C() {
        return be;
    }

    public static final strictfp boolean D() {
        return bf;
    }

    public strictfp void c(Context var1) {
        class_208.a(var1);
        this.am = var1;
    }

    public static strictfp synchronized GameEngine a(Context var0, class_359 var1) {
        if (gameEngine != null) {
            if (var1 != null) {
                gameEngine.dH = var1;
            }

            gameEngine.c(var0);
            return gameEngine;
        } else {
            gameEngine = dy.a(var0);
            log("Created new gameEngine of:" + gameEngine.getClass().getName());
            if (var1 != null) {
                gameEngine.dH = var1;
            }

            gameEngine.a(var0);
            return gameEngine;
        }
    }

    public GameEngine(Context var1) {
        Log.d("RustedWarfare", "GameEngine:GameEngine()");
        if (gameEngine != null) {
            throw new RuntimeException("gameEngine already created");
        } else {
            this.c(var1);
            gameEngine = this;
        }
    }

    @SneakyThrows
    protected strictfp void finalize() {
        Log.d("RustedWarfare", "GameEngine:finalize()");
        super.finalize();
    }

    public strictfp boolean E() {
        return true;
    }

    public abstract void a(Context var1);

    public strictfp void F() {
    }

    public abstract boolean a();

    public abstract boolean a(boolean var1);

    public abstract void a(Activity var1, class_0 var2, boolean var3);

    public abstract void b(int var1, int var2);

    public abstract int c(boolean var1);

    public abstract boolean n();

    public abstract boolean p();

    public abstract String l();

    public abstract String m();

    public abstract String r();

    public abstract String t();

    public abstract String u();

    public abstract void s();

    public abstract String v();

    public strictfp String G() {
        if (av()) {
            return "PC";
        } else if (aZ) {
            String var1 = class_1039.a();
            return var1 != null ? "IOS - " + var1 : "IOS";
        } else {
            return isModsInSD ? "SERVER" : Build.MODEL;
        }
    }

    public strictfp String H() {
        return dz;
    }

    public abstract void a(boolean var1, boolean var2, class_337 var3);

    public abstract void a(boolean var1, class_337 var2);

    public abstract void e();

    public abstract void g();

    public abstract void x();

    public abstract void a(float var1, int var2);

    public strictfp boolean I() {
        return this.bH;
    }

    public strictfp synchronized void J() {
        log("--- setRunning ---");
        if (!av() && !aZ) {
            this.bN.h();
        }

        if (!aW && !bb && this.gameThread == null) {
            this.gameThread = new GameThread();
            this.gameThread.a(true);
            this.gameThread.start();
        }

    }

    public strictfp synchronized void K() {
        log("--- setStoppedIfNotInGameThread ---");
        if (Thread.currentThread() != this.gameThread) {
            this.L();
        }

    }

    public strictfp synchronized void L() {
        log("--- setStopped ---");
        if (this.gameThread == null) {
            Log.d("RustedWarfare", "gameThread already null");
        } else {
            if (!av()) {
                this.bN.f();
            }

            this.gameThread.a(false);
            if (Thread.currentThread() != this.gameThread) {
                boolean var1 = true;

                while(var1) {
                    try {
                        this.gameThread.join();
                        var1 = false;
                    } catch (InterruptedException var3) {
                    }
                }

                Log.d("RustedWarfare", "thread stop");
            } else {
                warn("currentThread is game thread");
            }

            this.gameThread = null;
            if (this.ao != null) {
                this.ao.l();
            }

            if (this.bE) {
                Debug.stopMethodTracing();
            }

        }
    }

    public strictfp boolean M() {
        if (this.netEngine == null) {
            return false;
        } else if (!this.netEngine.B) {
            return false;
        } else {
            return !this.netEngine.F && !this.replayEngine.j();
        }
    }

    public strictfp boolean N() {
        return this.netEngine == null ? false : this.netEngine.B;
    }

    public strictfp boolean O() {
        if (this.netEngine == null) {
            return false;
        } else if (this.netEngine.F) {
            return true;
        } else {
            return this.netEngine.B || this.replayEngine.j();
        }
    }

    public strictfp boolean P() {
        if (this.netEngine == null) {
            return true;
        } else if (this.netEngine.F) {
            return true;
        } else {
            return !this.netEngine.B && !this.replayEngine.j();
        }
    }

    public strictfp void Q() {
        this.ct = false;
        if (this.cy < 0.0F) {
            this.cy = 0.0F;
            this.ct = true;
        }

        if (this.cz < 0.0F) {
            this.cz = 0.0F;
            this.ct = true;
        }

        if (this.bL != null) {
            if (this.cy > this.bL.i() - this.cE) {
                this.cy = this.bL.i() - this.cE;
                this.ct = true;
            }

            if (this.cz > this.bL.j() - this.cB) {
                this.cz = this.bL.j() - this.cB;
                this.ct = true;
            }

            if (this.cE > this.bL.i()) {
                this.cy = this.bL.i() / 2.0F - this.cE / 2.0F;
                this.ct = true;
            }

            if (this.cB > this.bL.j()) {
                this.cz = this.bL.j() / 2.0F - this.cB / 2.0F;
                this.ct = true;
            }
        }

        this.a(this.cy, this.cz);
    }

    public strictfp void a(float var1, float var2) {
        this.cy = var1;
        this.cz = var2;
        this.cu = (int)this.cy;
        this.cv = (int)this.cz;
        this.cw = (float)((int)(this.cy * this.cX)) / this.cX;
        this.cx = (float)((int)(this.cz * this.cX)) / this.cX;
        short var3 = 90;
        if (C()) {
            var3 = 210;
        }

        this.cN.a((int)(this.cy - (float)var3), (int)(this.cz - (float)var3), (int)(this.cy + this.cA + (float)var3), (int)(this.cz + this.cB + (float)var3));
        this.cO.a(this.cN);
        this.cQ.a((int)this.cy, (int)this.cz, (int)(this.cy + this.cA), (int)(this.cz + this.cB));
        short var4 = 300;
        this.cP.a((float)((int)(this.cy - (float)var4)), (float)((int)(this.cz - (float)var4)), (float)((int)(this.cy + this.cA + (float)var4)), (float)((int)(this.cz + this.cB + (float)var4)));
    }

    public strictfp void b(float var1, float var2) {
        this.a(var1 - this.cE / 2.0F, var2 - this.cB / 2.0F);
    }

    public static strictfp boolean d(Context var0) {
        if (isModsInSD) {
            return false;
        } else {
            if (Build.MODEL.equals("GT-I9100") || Build.MODEL.equals("GT-I9300")) {
                try {
                    WifiManager var1 = (WifiManager)var0.c("wifi");
                    WifiInfo var2 = var1.getConnectionInfo();
                    if (var2 != null && "BlueStacks".equals(var2.getSSID())) {
                        return true;
                    }
                } catch (Exception var3) {
                    var3.printStackTrace();
                }
            }

            return false;
        }
    }

    public strictfp void R() {
        if (this.cX != 1.0F) {
            this.bO.a(this.cX, this.cX);
        }

    }

    public strictfp void S() {
        if (this.cX != 1.0F) {
            this.bO.a(1.0F / this.cX, 1.0F / this.cX);
        }

    }

    public static strictfp void a(String var0, Exception var1) {
        log(var0);
        var1.printStackTrace();
    }

    public static strictfp String a(String var0, String var1) {
        if (ax && !var0.contains("\u001b[0m")) {
            var0 = var1 + var0 + "\u001b[0m";
        }

        return var0;
    }

    public static strictfp void a(String var0) {
        log(a("--- ERROR: " + var0, "\u001b[31m"));
    }

    public static strictfp void print(String var0) {
        log(a(var0, "\u001b[33m"));
    }

    public static strictfp void a(String var0, Throwable var1) {
        print(var0);
        log("" + var1.toString());
        log("cause:" + var1.getCause());
        var1.printStackTrace();
    }

    public static strictfp void c(String var0) {
        if (aX) {
            Log.b("RustedWarfare", var0);
        } else {
            Log.b("RustedWarfare", var0);
        }
    }

    public static strictfp void d(String var0) {
        c(var0);
    }

    public static strictfp void log(String var0) {
        c(var0);
    }

    public static strictfp void b(String var0, String var1) {
        c(var0 + ":" + var1);
    }

    public static strictfp synchronized void f(String var0) {
        c(var0 + " (at " + System.nanoTime() + ")");
    }

    public static strictfp void T() {
        StackTraceElement[] var0 = (new Throwable()).getStackTrace();
        StackTraceElement[] var1 = var0;
        int var2 = var0.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            StackTraceElement var4 = var1[var3];
            log(var4.toString());
        }

    }

    public static strictfp String U() {
        String var0 = "";
        StackTraceElement[] var1 = (new Throwable()).getStackTrace();
        StackTraceElement[] var2 = var1;
        int var3 = var1.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            StackTraceElement var5 = var2[var4];
            var0 = var0 + var5.toString() + "\n";
        }

        return var0;
    }

    public static strictfp void warn(String var0) {
        print(var0);
        T();
    }

    public static strictfp long millis() {
        return System.currentTimeMillis();
    }

    public static final strictfp boolean a(long var0, long var2) {
        long var4 = millis();
        if (var0 + var2 < var4) {
            return true;
        } else {
            return var4 < var0 - 1000L;
        }
    }

    public strictfp float W() {
        float var1 = this.ci;
        if (this.settingsEngine != null) {
            var1 *= this.settingsEngine.renderDensity;
            var1 *= this.settingsEngine.uiRenderScale;
            if (this.settingsEngine.renderDoubleScale) {
                return var1 / 2.0F;
            }
        }

        return var1;
    }

    public strictfp int e(float var1) {
        int var2 = (int)(var1 * this.cj + 0.5F);
        return var2;
    }

    public strictfp int a(int var1) {
        return (int)((float)var1 * this.cj + 0.5F);
    }

    public strictfp void X() {
        if (this.dA != this.cj) {
            log("Density size changed now: " + this.cj + ", refreshing fonts");
            synchronized(this.dC) {
                Iterator var2 = this.dC.iterator();

                while(true) {
                    if (!var2.hasNext()) {
                        break;
                    }

                    class_365 var3 = (class_365)var2.next();
                    var3.a();
                }
            }

            this.dA = this.cj;
            if (this.bO != null) {
            }
        }

    }

    protected strictfp void Y() {
        Iterator var1 = this.dC.iterator();

        while(var1.hasNext()) {
            class_365 var2 = (class_365)var1.next();
            this.bO.a(var2.b);
        }

        this.dB = true;
    }

    public strictfp void a(Paint var1) {
        this.a(var1, 16.0F);
    }

    public strictfp void a(Paint var1, float var2) {
        class_365 var3 = new class_365(this);
        var3.a = var2;
        var3.b = var1;
        var3.a();
        synchronized(this.dC) {
            this.dC.add(var3);
        }

        if (this.dB) {
            this.bO.a(var3.b);
        }

    }

    public strictfp void b(Paint var1, float var2) {
        float var3 = (float)this.e(var2);
        if (var1.k() != var3) {
            var1.b(var3);
        }

    }

    public strictfp void h(String var1) {
        this.a(var1, true);
    }

    public strictfp void a(String var1, boolean var2) {
        this.dI = var1;
        if (this.dH != null) {
            this.dH.a(var1, var2);
        }

    }

    public strictfp void Z() {
        this.dI = null;
    }

    public strictfp void i(String var1) {
        this.log(var1, 1);
    }

    public strictfp void log(String var1, int var2) {
        if (isModsInSD) {
            log("alert:" + var1);
        } else if (var1 == null) {
            warn("Cannot show alert, no message text");
        } else {
            this.dE = var1;
            this.dD.a(this.a);
        }

        if (this.dH != null) {
            this.dH.a(var1, var2);
        }

    }

    public strictfp boolean aa() {
        return this.dH != null ? this.dH.c() : false;
    }

    public strictfp void a(String var1, class_388 var2) {
        String var3 = null;
        if (var2 != null) {
            var3 = var2.b();
        }

        this.c(var1, var3);
    }

    public strictfp void c(String var1, String var2) {
        if (this.dH != null) {
            this.dH.a(var1, var2);
        }

        if (isModsInSD) {
            if (this.dH == null) {
                print("showMessageBox: not showing due to non-android:" + var2);
            }

        } else {
            this.bp = true;
            this.dF = var1;
            this.dG = var2;
            this.dD.a(this.b);
        }
    }

    public strictfp void ab() {
        synchronized(this.dJ) {
            if (this.dK != null) {
                this.c(this.dL, this.dK);
                this.dK = null;
                this.dL = null;
            }

        }
    }

    public strictfp void d(String var1, String var2) {
        this.dL = var1;
        this.dK = var2;
        if (aW) {
            this.ab();
        } else {
            GameEngine$3 var3 = new GameEngine$3(this);
            var3.start();
        }
    }

    public strictfp boolean ac() {
        if (this.aq) {
            return false;
        } else {
            return this.ao.k() == null ? false : this.ao.k().b();
        }
    }

    public strictfp void ad() {
        if (this.ao.k() != null) {
            this.ao.k().c();
        }
    }

    public strictfp int ae() {
        return this.aq ? 0 : this.ao.k().a();
    }

    public strictfp float af() {
        return this.b(0);
    }

    public strictfp float ag() {
        return this.c(0);
    }

    public strictfp float b(int var1) {
        if (this.ao == null) {
            return 0.0F;
        } else {
            return this.settingsEngine.renderDoubleScale ? this.ao.k().d()[var1] / 2.0F : this.ao.k().d()[var1];
        }
    }

    public strictfp float c(int var1) {
        if (this.ao == null) {
            return 0.0F;
        } else {
            return this.settingsEngine.renderDoubleScale ? this.ao.k().f()[var1] / 2.0F : this.ao.k().f()[var1];
        }
    }

    public strictfp int d(int var1) {
        return this.ao.k().e()[var1];
    }

    public strictfp boolean e(int var1) {
        if (var1 != 1 && var1 != 2 && var1 != 3) {
            throw new RuntimeException("Unknown mouseButton:" + var1);
        } else {
            int var2 = this.f(var1);
            return var2 != -1;
        }
    }

    public strictfp int f(int var1) {
        if (var1 == 0) {
            throw new RuntimeException("finding state of 0 doesn't make sense");
        } else {
            int[] var2 = this.ao.k().e();

            for(int var3 = 0; var3 < var2.length; ++var3) {
                if (var2[var3] == var1) {
                    return var3;
                }
            }

            return -1;
        }
    }

    public strictfp boolean g(int var1) {
        if (var1 < this.c.length && var1 >= 0) {
            if (this.c[var1] && this.d[var1]) {
                this.d[var1] = false;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public strictfp boolean h(int var1) {
        return var1 < this.c.length && var1 >= 0 ? this.c[var1] : false;
    }

    public strictfp boolean a(int var1, boolean var2) {
        boolean var3 = true;
        boolean var4 = true;
        int var5 = this.ah();
        if ((var1 & 2) != 0) {
            if ((var5 & 2) == 0) {
                var3 = false;
            }
        } else if ((var5 & 2) != 0) {
            var4 = false;
        }

        if ((var1 & 1) != 0) {
            if ((var5 & 1) == 0) {
                var3 = false;
            }
        } else if ((var5 & 1) != 0) {
            var4 = false;
        }

        if ((var1 & 4) != 0) {
            if ((var5 & 4) == 0) {
                var3 = false;
            }
        } else if ((var5 & 4) != 0) {
            var4 = false;
        }

        if (var2) {
            return var3;
        } else {
            return var3 && var4;
        }
    }

    public strictfp boolean i(int var1) {
        boolean var2 = true;
        if (var1 != 59 && var1 != 60) {
            if (var1 != 113 && var1 != 114) {
                return var1 == 57 || var1 == 58;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    public static strictfp String j(int var0) {
        String var1 = "";
        if ((var0 & 2) != 0) {
            var1 = var1 + "shift+";
        }

        if ((var0 & 1) != 0) {
            var1 = var1 + "ctrl+";
        }

        if ((var0 & 4) != 0) {
            var1 = var1 + "alt+";
        }

        return var1;
    }

    public strictfp int ah() {
        int var1 = 0;
        if (this.h(59) || this.h(60)) {
            var1 += 2;
        }

        if (this.h(113) || this.h(114)) {
            ++var1;
        }

        if (this.h(57) || this.h(58)) {
            var1 += 4;
        }

        return var1;
    }

    public strictfp boolean c(int var1, int var2) {
        boolean var3 = false;
        boolean var4 = false;
        if (var1 >= 0 && var1 < this.c.length) {
            var3 = this.c[var1];
        }

        if (var2 >= 0 && var2 < this.c.length) {
            var4 = this.c[var2];
        }

        return var3 || var4;
    }

    public strictfp void b(int var1, boolean var2) {
        if (var1 >= 0 && var1 < this.c.length) {
            this.c[var1] = var2;
            if (var2) {
                this.d[var1] = var2;
            }
        } else {
            log("setKeyState: Key out of range:" + var1);
        }

    }

    public strictfp void k(int var1) {
        this.dN.add(new class_335(this, var1));
    }

    public strictfp int ai() {
        return this.e;
    }

    protected strictfp void aj() {
        this.e = 0;

        while(true) {
            while(true) {
                while(true) {
                    class_334 var1 = (class_334)this.dN.poll();
                    if (var1 == null) {
                        return;
                    }

                    if (var1 instanceof class_336) {
                        class_336 var3 = (class_336)var1;
                        if (var3.c < this.c.length && var3.c >= 0) {
                            this.c[var3.c] = !var3.d;
                            this.d[var3.c] = !var3.d;
                        } else {
                            b("updateKeyState", "keyCode (" + var3.c + ") is out of range");
                        }
                    } else if (var1 instanceof class_335) {
                        class_335 var2 = (class_335)var1;
                        this.e += var2.c;
                    }
                }
            }
        }
    }

    public static strictfp String j(String var0) {
        int var1 = var0.lastIndexOf("/");
        if (var1 == -1) {
            var1 = var0.length();
        }

        return var0.substring(0, var1);
    }

    public static strictfp String k(String var0) {
        int var1 = var0.lastIndexOf("/");
        if (var1 == -1) {
            var1 = 0;
        } else {
            ++var1;
        }

        return var0.substring(var1);
    }

    public static strictfp Integer l(String var0) {
        String var1 = k(var0);
        log("getMapLevel for :" + var0 + " file:" + var1);
        Pattern var2 = Pattern.compile("^l(\\d*);.*");
        Matcher var3 = var2.matcher(var1);
        if (var3.matches()) {
            log("getMapLevel:" + var0 + ":" + Integer.parseInt(var3.group(1)));
            return Integer.parseInt(var3.group(1));
        } else {
            return null;
        }
    }

    public static strictfp String m(String var0) {
        GameEngine var1 = getGameEngine();
        Integer var2 = l(var0);
        if (var2 == null) {
            return null;
        } else {
            int var3 = var0.lastIndexOf("/");
            if (var3 == -1) {
                var3 = var0.length();
            }

            String var4 = var0.substring(0, var3);
            String[] var5 = class_697.a(var4, true);
            if (var5 == null) {
                return null;
            } else {
                String[] var6 = var5;
                int var7 = var5.length;

                for(int var8 = 0; var8 < var7; ++var8) {
                    String var9 = var6[var8];
                    Integer var10 = l(var9);
                    if (var10 != null && var10 > var2 && (!var1.ar || class_200.a(var9, var4 + "/" + var9))) {
                        return var4 + "/" + var9;
                    }
                }

                return null;
            }
        }
    }

    public strictfp String ak() {
        return this.dl;
    }

    public strictfp String al() {
        String var1 = this.dl;
        if ((this.dl == null || "".equals(this.dl)) && this.N()) {
            var1 = this.netEngine.l();
        }

        return class_200.e(class_200.d(var1));
    }

    public strictfp String am() {
        return class_200.d(this.dl);
    }

    public strictfp MapType an() {
        return class_200.g(this.dl) ? MapType.customMap : MapType.skirmishMap;
    }

    public static strictfp String a(Throwable var0) {
        StringWriter var1 = new StringWriter();
        PrintWriter var2 = new PrintWriter(var1);
        var0.printStackTrace(var2);
        String var3 = var1.toString();
        var2.close();
        return var3;
    }

    public static strictfp String b(Throwable var0) {
        String var1 = var0.getMessage();
        if (var1 == null) {
            var1 = var0.getClass().getName();
        } else {
            var1 = var1.replace("java.lang.RuntimeException: ", "");
            var1 = var1.replace("java.lang.RuntimeException: ", "");
        }

        Throwable var2;
        Throwable var3;
        for(var2 = var0; var2 != null; var2 = var3) {
            var3 = var2.getCause();
            if (var3 == null || var3 == var0 || var3 == var2) {
                break;
            }
        }

        var3 = null;
        if (var2 != null && var2 != var0) {
            String var5 = var2.getMessage();
            if (var5 == null) {
                var5 = var2.getClass().getName();
            }

            if (!var5.equals(var1)) {
                var1 = var1 + " caused by (" + var5 + ")";
            }
        }

        return var1;
    }

    public static strictfp File ao() {
        class_697.d();
        String var0 = "/SD/rustedWarfare/crashes.txt";
        if (at()) {
            var0 = "/SD/rustedWarfare/crashes.txt";
        }

        String var1 = class_697.e(var0);
        File var2 = new File(var1);
        return var2;
    }

    public static strictfp void e(String var0, String var1) {
        File var2 = ao();

        try {
            OutputStream var3 = class_697.a(var2, true);
            PrintWriter var4 = new PrintWriter(var3);
            String var5 = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")).format(new Date());
            var4.write("\r\n" + var0 + " (at " + var5 + " - " + "1.15" + "" + ")\n");
            var4.write(var1 + "\r\n");
            var4.close();
        } catch (Throwable var6) {
            log("Exception in writeCrashToFile");
            var6.printStackTrace();
        }

    }

    public static strictfp void ap() {
        if (at) {
            if (!isModsInSD) {
                if (dS != null) {
                    print("setupANRWatchDog: activeANRWatchDog!=null");
                } else {
                    dS = new class_700(4000);
                    dS.a((class_21)(new GameEngine$4()));
                    dS.start();
                    print("setupANRWatchDog: running");
                }
            }
        }
    }

    public static strictfp void aq() {
        if (dP == null && av()) {
            dP = new byte[2500000];
            dP[0] = 2;
            dP[dP.length - 1] = 5;
        }

        Thread.UncaughtExceptionHandler var0;
        if (aA) {
            var0 = Thread.currentThread().getUncaughtExceptionHandler();
            if (!(var0 instanceof class_343)) {
                Thread.currentThread().setUncaughtExceptionHandler(new class_343(var0));
            }
        } else {
            var0 = Thread.getDefaultUncaughtExceptionHandler();
            if (!(var0 instanceof class_343)) {
                Thread.setDefaultUncaughtExceptionHandler(new class_343(var0));
            }
        }

    }

    public abstract int z();

    public strictfp boolean ar() {
        return true;
    }

    public strictfp boolean as() {
        return true;
    }

    public static strictfp void n(String var0) {
        GameEngine var1 = getGameEngine();
        if (var1 != null) {
            ++dU;
            if (dU < 1000) {
                print("reportProblem: " + var0);
            }

            if (dU < 10) {
                var1.log(var0, 1);
            }
        }

    }

    public static strictfp boolean at() {
        return !isModsInSD;
    }

    public static strictfp boolean au() {
        return !aW || aZ;
    }

    public static strictfp boolean av() {
        return aW && !aZ;
    }

    public static strictfp boolean aw() {
        return aW && !aZ;
    }

    public static strictfp boolean ax() {
        return isModsInSD && !aW;
    }

    public strictfp boolean ay() {
        return this.netEngine.B || this.replayEngine.j();
    }

    public strictfp void a(Unit var1, float var2) {
        this.bW.a((int)var1.xCord, (int)var1.yCord, var2, var1);
        this.bS.i.c(var1);
    }

    public static strictfp boolean az() {
        GameEngine var0 = getGameEngine();
        return var0 == null || !var0.settingsEngine.teamShaders || !var0.settingsEngine.newRender && at() ? aN : true;
    }

    public static strictfp boolean aA() {
        GameEngine var0 = getGameEngine();
        return var0 == null || !var0.settingsEngine.shaderEffects || !var0.settingsEngine.newRender && at() ? aM : true;
    }

    public static strictfp boolean aB() {
        GameEngine var0 = getGameEngine();
        return var0 == null || !var0.settingsEngine.shaderEffects || !var0.settingsEngine.newRender && at() ? aM : true;
    }

    public abstract int b();

    public static strictfp void aC() {
        System.out.println("Free memory (bytes): " + Runtime.getRuntime().freeMemory());
        long var0 = Runtime.getRuntime().maxMemory();
        System.out.println("Maximum memory (bytes): " + (var0 == Long.MAX_VALUE ? "no limit" : var0));
        System.out.println("Total memory (bytes): " + Runtime.getRuntime().totalMemory());
    }

    public strictfp Context aD() {
        return this.am;
    }

    public static strictfp void f(String var0, String var1) {
        GameEngine var2 = getGameEngine();
        if (var2 != null) {
            if (var2.bS != null && var2.bS.h != null) {
                var2.bS.h.a(var0, var1);
            } else {
                warn("addMessage: interfaceEngine/messageInterface==null");
            }

        }
    }

    public static strictfp void a(class_338 var0, Throwable var1) {
        dQ = null;
        log("reportCaughtOutOfMemory:" + dW);
        if (dW == null) {
            dW = var0;
            if (var1 != null) {
                c(var1);
            }

            aC();
        }
    }

    public static strictfp void c(Throwable var0) {
        try {
            var0.printStackTrace();
        } catch (Throwable var2) {
            log("Failed to print stacktrace");
        }

    }

    public strictfp void aE() {
        String var1;
        if (dX && !dY) {
            dY = true;
            var1 = "Warning game has less than 5mb of free space remaining. A larger battle might cause a crash. ";
            int var2 = this.bZ.h();
            if (var2 > 1) {
                var1 = var1 + "This is often caused by large mods, you currently have: " + var2 + " mods loaded. ";
            }

            this.c("Warning: Low memory detected", var1);
        }

        if (!dV && dW != null) {
            log("Showing out of memory message");
            dV = true;
            var1 = "";
            String var4 = "trying to load data";
            if (dW == class_338.GAME_IMAGE) {
                var4 = "trying to load game textures";
            } else if (dW == class_338.GAME_IMAGE_CREATE) {
                var4 = "trying to create a texture";
            } else if (dW == class_338.GAME_IMAGE_COLOR) {
                var4 = "trying to colour new texture";
            } else if (dW == class_338.GAME_IMAGE_FOG_BUFFER) {
                var4 = "trying to create texture buffer for on-screen fog fading";
            } else if (dW == class_338.GAME_FONT) {
                var4 = "trying to create game fonts";
            } else if (dW == class_338.GAME_SOUND) {
                var4 = "trying to load game sounds";
            } else if (dW == class_338.UI_IMAGE) {
                var4 = "trying to load UI textures";
            }

            var1 = "The game ran out of memory " + var4 + ". ";
            int var3 = this.bZ.h();
            if (var3 > 1) {
                var1 = var1 + "This is often caused by large mods, you currently have: " + var3 + " mods. ";
            }

            if (av() && !EngineLoad.b) {
                var1 = var1 + "You are also using the 32 bit version, switching to the 64 bit version might help. ";
            }

            this.c("Warning: Out Of Memory", var1);
        }

    }

    public strictfp void aF() {
        try {
            byte[] var1 = new byte[5000000];
            var1[0] = this.dZ;
            this.ea = var1[1];
            Object var3 = null;
        } catch (OutOfMemoryError var2) {
            System.gc();
            log("Low memory detected");
            var2.printStackTrace();
            dX = true;
        }

    }

    public strictfp void a(Runnable var1) {
        this.ec.a(var1);
    }

    public final strictfp boolean a(float var1, float var2, float var3) {
        return this.cM.a < var1 + var3 && var1 - var3 < this.cM.c && this.cM.b < var2 + var3 && var2 - var3 < this.cM.d;
    }

    public abstract boolean c();

    public abstract boolean d();

    public static strictfp boolean o(String var0) {
        return aQ == null ? false : aQ.contains(var0);
    }

    public static strictfp void p(String var0) {
        GameEngine var1 = getGameEngine();
        GameNetEngine var2 = var1.netEngine;
        String var3 = "" + var0;
        print(var3);
        T();
        ++ej;
        if (ej < 10 && var2 != null) {
            var2.m(var3);
        }

    }

    public strictfp void a(class_173 var1, class_169 var2) {
        this.cg = new class_162(var1, var2);
        this.cg.a();
    }

    static {
        dz = VERSION.RELEASE;
        dO = false;
        dQ = new byte[1000];
        dR = new byte[1000];
        dT = false;
        dU = 0;
        dW = null;
    }
}
