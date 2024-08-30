package com.corrodinggames.rts.java;

import android.content.Context;
import android.content.ServerContext;
import android.graphics.Point;
import com.corrodinggames.librocket.class_790;
import com.corrodinggames.librocket.scripts.ScriptEngine;
import com.corrodinggames.rts.debug.ScriptServerSocket;
import com.corrodinggames.rts.game.EngineLoad;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.Unit;
import com.corrodinggames.rts.gameFramework.class_1001;
import com.corrodinggames.rts.gameFramework.class_359;
import com.corrodinggames.rts.gameFramework.class_375;
import com.corrodinggames.rts.gameFramework.class_985;
import com.corrodinggames.rts.gameFramework.a.class_350;
import com.corrodinggames.rts.gameFramework.a.class_648;
import com.corrodinggames.rts.gameFramework.h.class_1009;
import com.corrodinggames.rts.gameFramework.m.class_925;
import com.corrodinggames.rts.gameFramework.net.EnterPasswordCallback;
import com.corrodinggames.rts.gameFramework.net.GameNetAPIOperate;
import com.corrodinggames.rts.gameFramework.net.GameNetEngine;
import com.corrodinggames.rts.gameFramework.net.PlayerConnect;
import com.corrodinggames.rts.gameFramework.net.NetworkCallbacks;
import com.corrodinggames.rts.gameFramework.steam.SteamEngine;
import com.corrodinggames.rts.gameFramework.utility.class_665;
import com.corrodinggames.rts.gameFramework.utility.class_679;
import com.corrodinggames.rts.java.audio.lwjgl.OpenALAudio;
import com.corrodinggames.rts.java.b.CommonGuiEngine;
import com.corrodinggames.rts.java.librocket.SlickLibRocket;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Locale;
import java.util.concurrent.Semaphore;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.Input;
import org.newdawn.slick.ScalableGame;
import org.newdawn.slick.opengl.renderer.Renderer;
import org.newdawn.slick.opengl.renderer.SGL;
import org.newdawn.slick.opengl.renderer.VBORenderer;

public strictfp class Main extends NetworkCallbacks {
    public static boolean a = false;
    public static boolean b = true;
    public static String c = "Rusted Warfare";
    public class_367 d;
    public String e = "#28";
    class_665 f = new class_665();
    boolean g = true;
    public GameNetEngine h;
    CommonGuiEngine i;
    public RWBasicGame j;
    RWAppGameContainer k;
    String[] l;
    static Main m;
    int n;
    long o = System.nanoTime();
    SlickLibRocket p;
    class_359 q = new class_360(this);
    Thread r;
    boolean s = true;
    Object t = new Object();
    public boolean u;
    public int v;

    public static void main(String[] var0) {
        m = new Main();
        m.a(var0);
        new Main$1();
    }

    public static void a(String var0) {
        GameEngine.log(var0);
    }

    public void f() {
        class_679 var1 = new class_679(new InputStreamReader(System.in));

        while(this.g) {
            try {
                String var2 = var1.a();
                if (var2 == null) {
                    try {
                        Thread.sleep(200L);
                    } catch (InterruptedException var5) {
                        var5.printStackTrace();
                    }
                } else {
                    this.a((PlayerConnect)null, "ADMIN", var2, true);
                }
            } catch (Exception var7) {
                if (this.n < 3) {
                    GameEngine.log("Error while reading stdin: " + var7.toString());
                    ++this.n;
                    if (this.n == 3) {
                        GameEngine.log("Too many stdin errors, ignoring");
                    }
                }

                try {
                    Thread.sleep(700L);
                } catch (InterruptedException var6) {
                    var6.printStackTrace();
                }
            }
        }

    }

    public void g() {
        Semaphore var1 = new Semaphore(0);
        Thread var2 = new Thread(new Main$2(this, var1));
        var2.setDaemon(true);
        var2.start();

        try {
            var1.acquire();
        } catch (InterruptedException var4) {
            var4.printStackTrace();
        }

    }

    public synchronized void a(String[] var1) {
        this.l = var1;
        boolean var2 = false;
        boolean var3 = false;
        boolean var4 = false;
        boolean var5 = false;
        boolean var6 = false;
        boolean var7 = false;
        boolean var8 = false;
        boolean var9 = false;
        Integer var10 = null;
        Integer var11 = null;
        GameEngine.log("Reading args");
        String var12 = null;
        String var13 = null;

        int var14;
        String var15;
        for(var14 = 0; var14 < var1.length; ++var14) {
            var15 = var1[var14].trim().toLowerCase(Locale.ENGLISH);
            if (var12 != null) {
                if (var12.equals("+connect_lobby")) {
                    a("connect lobby:" + var15);
                    GameEngine.aK = var15;
                    var12 = null;
                } else if (var12.equals("-width")) {
                    var10 = Integer.parseInt(var15);
                    var12 = null;
                } else if (var12.equals("-height")) {
                    var11 = Integer.parseInt(var15);
                    var12 = null;
                } else {
                    a("Unknown two_part_arg: " + var12);
                    var12 = null;
                }
            } else {
                String var16;
                if (var15.equals("-debug")) {
                    ++var14;
                    if (var14 >= var1.length) {
                        a("-debug requires parameters");
                        System.exit(1);
                    }

                    var16 = var1[var14];
                    int var27 = Integer.parseInt(var16.split(":")[0]);
                    String var18 = var16.split(":")[1];
                    ScriptServerSocket.a(var27, var18);
                } else if (var15.equals("-debugscript")) {
                    ++var14;
                    if (var14 >= var1.length) {
                        a("-debugscript requires parameters");
                        System.exit(1);
                    }

                    var16 = var1[var14];
                    ScriptServerSocket.addScriptFilePath(var16);
                } else if (var15.equals("-log")) {
                    ++var14;
                    if (var14 >= var1.length) {
                        a("-log requires parameters");
                        System.exit(1);
                    }

                    var16 = var1[var14];

                    try {
                        PrintStream var17 = new PrintStream(var16);
                        System.setOut(var17);
                        System.setErr(var17);
                        GameEngine.log("File logging started");
                    } catch (FileNotFoundException var24) {
                        GameEngine.a("Cannot open log file:" + var16);
                        var24.printStackTrace();
                    }
                } else if (!var15.equals("-nologfile")) {
                    if (var15.equals("-lang")) {
                        ++var14;
                        if (var14 >= var1.length) {
                            a("-lang requires parameters");
                            System.exit(1);
                        }

                        var16 = var1[var14];
                        class_1009.d = var16;
                    } else if (var15.equals("-logcolor")) {
                        GameEngine.ax = true;
                    } else if (var15.equals("-nodisplay")) {
                        var2 = true;
                    } else if (var15.equals("-canvasgl")) {
                        GameEngine.aD = true;
                    } else if (var15.equals("-replay_debug")) {
                        GameEngine.aw = true;
                    } else if (var15.equals("-nopreferipv4")) {
                        var5 = true;
                    } else if (var15.equals("-noresources")) {
                        GameEngine.aB = true;
                    } else if (var15.equals("-nosound")) {
                        var3 = true;
                    } else if (var15.equals("-nomusic")) {
                        var4 = true;
                    } else if (var15.equals("-safemode")) {
                        GameEngine.aO = true;
                    } else if (var15.equals("-extrasafemode")) {
                        GameEngine.aP = true;
                    } else if (var15.equals("-disable_vbos")) {
                        var8 = true;
                    } else if (var15.equals("-disable_atlas")) {
                        GameEngine.aC = true;
                    } else if (var15.equals("-force_vbos")) {
                        var9 = true;
                    } else if (var15.equals("-allowsoftwarerender")) {
                        var6 = true;
                    } else if (var15.equals("-fullscreen")) {
                        var7 = true;
                    } else if (var15.equals("-nobackground")) {
                        GameEngine.ay = true;
                    } else if (var15.equals("-nomods")) {
                        GameEngine.aJ = true;
                    } else if (var15.equals("-printunits")) {
                        GameEngine.aE = true;
                    } else if (var15.equals("-outputunitimages")) {
                        GameEngine.aF = true;
                    } else if (var15.equals("-oldreplays")) {
                        GameEngine.aG = true;
                    } else if (var15.equals("-teamshaders")) {
                        GameEngine.aN = true;
                    } else if (var15.equals("-noteamshaders")) {
                        GameEngine.aN = false;
                    } else if (var15.equals("-devdebug")) {
                        ++var14;
                        if (var14 >= var1.length) {
                            a("-debugscript requires parameters");
                            System.exit(1);
                        }

                        var16 = var1[var14];
                        GameEngine.aQ = var16;
                    } else if (var15.equals("-postprocessing")) {
                        GameEngine.aM = true;
                    } else if (var15.equals("-nopostprocessing")) {
                        GameEngine.aM = false;
                    } else if (var15.equals("-disabletextureread")) {
                        LoadImage.F = false;
                    } else if (var15.equals("-sandbox")) {
                        GameEngine.aI = true;
                    } else if (var15.equals("-steam")) {
                        GameEngine.aH = true;
                    } else if (!var15.equals("-width") && !var15.equals("-height")) {
                        if (var15.startsWith("+")) {
                            if (var15.equals("+connect_lobby")) {
                                var12 = var15;
                            } else {
                                a("Unknown steam option: " + var15);
                            }
                        } else if (var15.trim().length() != 0) {
                            a("Unknown option: " + var15);
                            var13 = "Unknown option: " + var15;
                        }
                    } else {
                        var12 = var15;
                    }
                }
            }
        }

        GameEngine.log("Game arguments:");

        for(var14 = 0; var14 < var1.length; ++var14) {
            var15 = var1[var14].trim().toLowerCase(Locale.ENGLISH);
            a("arg: " + var15);
        }

        if (var13 != null) {
            if (GameEngine.aH) {
                a("Unknown options but running anyway due to being in steam");
            } else {
                a("Exiting due to unknown option: " + var13);
                System.exit(1);
            }
        }

        GameEngine.isModsInSD = true;
        GameEngine.aq();
        String var26 = System.getProperty("os.name");
        GameEngine.log("OS name: " + var26);
        GameEngine.log("OS version: " + System.getProperty("os.version"));
        GameEngine.log("LWJGL version: " + Sys.getVersion());
        GameEngine.log("Build Number: " + this.e);
        GameEngine.log("Game Version: 1.15");
        GameEngine.log("Game Code: 176");
        EngineLoad.b = Sys.is64Bit();
        GameEngine.log("Is 64bit: " + EngineLoad.b);
        GameEngine.log("JVM maxMemory:" + Runtime.getRuntime().maxMemory());
        GameEngine.log("JVM totalMemory:" + Runtime.getRuntime().totalMemory());
        GameEngine.log("JVM freeMemory:" + Runtime.getRuntime().freeMemory());
        if (var26 != null && var26.toLowerCase().contains("mac os")) {
            EngineLoad.c = true;
        }

        if (var5) {
            GameEngine.log("Skipping preferIPv4Stack=true");
        } else {
            System.setProperty("java.net.preferIPv4Stack", "true");
        }

        if (GameEngine.aH) {
            SteamEngine.steamEngine = new com.corrodinggames.rts.java.steam.SteamEngine();
            GameEngine.log("Early steam init");
            SteamEngine.getSteamEngine().b();
            GameEngine.log("Early steam init done.");
        } else {
            GameEngine.log("steam not requested");
        }

        this.g();
        var15 = c;
        if (var2) {
            var15 = "";
        }

        Input.disableControllers();
        if (a) {
            Renderer.setRenderer(2);
        }

        if (!var9 && EngineLoad.c) {
            GameEngine.log("Disabling vbo on mac (without force option)");
            var8 = true;
        }

        if (var8) {
            GameEngine.log("disable_vbos requested");
            SGL var28 = Renderer.get();
            if (var28 instanceof VBORenderer) {
                VBORenderer var29 = (VBORenderer)var28;
                var29.disableVBOs();
            } else {
                GameEngine.log("Failed to disable VBOs, wrong class");
            }
        }

        class_368.c();
        this.j = new RWBasicGame(var15);
        this.j.b = this;
        this.j.i = var2;
        this.j.j = var3;
        this.j.k = var4;
        float var30;
        float var31;
        if (var2) {
            GameEngine.a("Skipping display mode call");
            var30 = 800.0F;
            var31 = 600.0F;
        } else {
            try {
                DisplayMode var32 = Display.getDisplayMode();
                var30 = (float)var32.getHeight();
                var31 = (float)var32.getWidth();
            } catch (Exception var23) {
                GameEngine.a("Failed to get display mode, defaulting to min size");
                var23.printStackTrace();
                var30 = 800.0F;
                var31 = 600.0F;
            }
        }

        GameEngine.log("screenHeight:" + var30);
        GameEngine.log("screenWidth:" + var31);
        int var33 = 1000;
        int var19 = 733;
        if (var30 > 800.0F) {
            var33 = 1000;
            var19 = 800;
        }

        if (var30 > 900.0F) {
            var33 = 1600;
            var19 = 900;
        }

        if (var2) {
            var33 = 10;
            var19 = 10;
        }

        if (var10 != null) {
            GameEngine.log("Overriding width to:" + var10);
            var33 = var10;
        }

        if (var11 != null) {
            GameEngine.log("Overriding height to:" + var11);
            var19 = var11;
        }

        if (var6) {
            GameEngine.log("allowSoftwareOpenGL is now on");
            System.setProperty("org.lwjgl.opengl.Display.allowSoftwareOpenGL", "true");
        }

        this.j.l = false;
        boolean var20 = var7;

        try {
            if (this.j.l) {
                this.j.a(var33 * 2, var19 * 2);
                this.k = new RWAppGameContainer(new ScalableGame(this.j, var33, var19), var33, var19, var20);
            } else {
                this.k = new RWAppGameContainer(this.j, var33, var19, var20);
            }
        } catch (Exception var22) {
            throw new RuntimeException(var22);
        }

        this.j.c = this.k;
        Display.setResizable(true);
        StartLwjgl var25 = new StartLwjgl(this);
        this.r = new Thread(var25);
        this.r.setDaemon(false);
        this.r.start();
    }

    public void b(String var1) {
        this.q.a(var1, true);
    }

    public synchronized void h() {
        this.b("displayModes");
        this.b("starting controllers");
        this.o = System.nanoTime();
        GameEngine.isModsInSD = true;
        GameEngine.bb = true;
        if (!GameEngine.aB) {
            if (GameEngine.aD) {
                GameEngine.aX = true;
                GameEngine.aW = true;
                GameEngine.bg = class_925.class;
            } else {
                GameEngine.aX = true;
                GameEngine.aW = true;
                GameEngine.bg = class_368.class;
            }
        }

        if (this.j != null && !this.j.j) {
            byte var1 = 20;
            OpenALAudio var2 = new OpenALAudio(var1, 9, 512);
            GameEngine.log("openALAudio hasDevice:" + var2.hasDevice());
            class_648.c = new class_352(var2);
            if (this.j.k) {
                GameEngine.log("Music disabled");
                class_1001.a = new class_375();
            } else {
                class_1001.a = new class_376(var2);
            }
        } else {
            GameEngine.print("Disabling sound with NullSoundFactory");
            class_648.c = new class_350();
            class_1001.a = new class_375();
        }

        GameNetAPIOperate.d = new HTTP();
        class_985.b = new class_364();
        long var9 = Unit.loadAllUnitsTook();
        this.b("loading libRocket");
        GameEngine.log("start libRocket setup");
        this.d = new class_367();
        this.i = CommonGuiEngine.p();
        this.i.f = this;
        this.p = new SlickLibRocket();
        this.i.a(this.p, this.d);
        this.p.debug = false;
        this.p.setup();
        this.b("libRocket - fonts");
        this.p.loadFont("font/Delicious-Roman.otf");
        this.p.loadFont("font/Delicious-Italic.otf");
        this.p.loadFont("font/Delicious-Bold.otf");
        this.p.loadFont("font/Delicious-BoldItalic.otf");
        this.p.loadFont("font/Roboto-Regular.ttf");
        this.p.loadFont("font/Roboto-Bold.ttf");
        GameEngine.log("NotoSansCJKsc start");
        this.p.loadFont("font/NotoSansCJKsc-Regular.otf", "notoSans");
        this.p.loadFont("font/DroidSansFallback.ttf", "fallback");
        GameEngine.log("NotoSansCJKsc end");
        this.i.c();
        GameEngine.log("end libRocket setup");
        this.b("GuiEngine");
        Unit.a("libRocket setup took:", var9);
        GameEngine.dz = this.e;
        ServerContext var3 = new ServerContext();
        this.b("GameEngine");
        int var4 = this.j.a.getWidth();
        int var5 = this.j.a.getHeight();
        GameEngine.ck = new Point(var4, var5);
        GameEngine var6 = GameEngine.a((Context)var3, (class_359)this.q);
        this.b("GameEngine ready");
        GameEngine.log("version: " + var6.u() + " " + var6.c(false) + ":" + this.e);
        this.i.b();
        ScriptServerSocket.b();
        this.h = var6.netEngine;
        var6.settingsEngine.showZoomButton = false;
        var6.settingsEngine.showUnitGroups = false;
        this.j.a(this.d);
        this.j.a(1000, 800);
        long var7 = System.nanoTime();
        GameEngine.log("-----------------------------");
        GameEngine.log("----- Game init finished in:" + (double)(var7 - this.o) / 1000000.0 + " ms");
        var6.netEngine.d = this;
        var6.netEngine.y = "unset";
        if (!GameEngine.ay) {
        }

    }

    public void startGame() {
        Main$3 var1 = new Main$3(this);
        this.f.a(var1);
    }

    public void a(float var1) {
        this.f.a();
    }

    public void a(boolean var1) {
        this.g = false;
        GameEngine var2 = GameEngine.getGameEngine();
        if (!var1) {
            var2.netEngine.u();
        } else {
            var2.netEngine.closeServer("shutdownServer");
        }

        try {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException var4) {
                var4.printStackTrace();
            }

            System.exit(0);
        } catch (SecurityException var5) {
            var5.printStackTrace();
        }

    }

    Main() {
    }

    public synchronized boolean a(PlayerConnect var1, String var2, String var3) {
        return true;
    }

    public synchronized void b(PlayerConnect var1, String var2, String var3) {
        this.a(var1, var2, var3, false);
    }

    public void c() {
        GameEngine var1 = GameEngine.getGameEngine();
        if (!var1.netEngine.ingame) {
            ScriptEngine var2 = ScriptEngine.getInstance();
            if (var2 != null) {
                var2.addScriptToQueueIfNotAlreadyQueued("mp.refreshUI()");
            }
        }

    }

    public synchronized void a(int var1, String var2, String var3, PlayerConnect var4) {
        if (this.p != null && this.p.c != null) {
            this.p.c.addRunnableToQueue(new Main$4(this, var1, var2, var3, var4));
        } else {
            GameEngine.T();
        }

    }

    public synchronized void a(PlayerConnect var1, String var2, String var3, boolean var4) {
        if (!var4) {
            a(var2 + ": " + var3);
        }

        if (!this.s) {
            ;
        }
    }

    public String a(PlayerConnect var1, String var2) {
        return null;
    }

    public synchronized void c(PlayerConnect var1, String var2, String var3) {
    }

    public synchronized void b(PlayerConnect var1, String var2) {
    }

    public void i() {
        GameEngine var1 = GameEngine.getGameEngine();
        this.j.g();
    }

    public void d() {
        class_790.a().o();
    }

    public void a(EnterPasswordCallback var1) {
        class_790.a().a(var1);
    }
}
