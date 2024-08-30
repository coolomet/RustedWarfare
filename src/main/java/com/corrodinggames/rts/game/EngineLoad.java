package com.corrodinggames.rts.game;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint$Align;
import android.graphics.Paint$Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Debug;
import android.util.DisplayMetrics;
import android.util.Log;
import com.corrodinggames.rts.AssetsID$drawable;
import com.corrodinggames.rts.appFramework.class_0;
import com.corrodinggames.rts.appFramework.class_198;
import com.corrodinggames.rts.game.a.class_138;
import com.corrodinggames.rts.game.maps.class_484;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.Tree;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.class_113;
import com.corrodinggames.rts.game.units.custom.class_436;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.p026f.UnitGeoIndex;
import com.corrodinggames.rts.gameFramework.CollisionEngine;
import com.corrodinggames.rts.gameFramework.CommandController;
import com.corrodinggames.rts.gameFramework.FileChangeEngine;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.GameSaver;
import com.corrodinggames.rts.gameFramework.GroupController;
import com.corrodinggames.rts.gameFramework.ReplayEngine;
import com.corrodinggames.rts.gameFramework.SettingsEngine;
import com.corrodinggames.rts.gameFramework.StatsHandler;
import com.corrodinggames.rts.gameFramework.class_1001;
import com.corrodinggames.rts.gameFramework.class_324;
import com.corrodinggames.rts.gameFramework.class_337;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.GameObject;
import com.corrodinggames.rts.gameFramework.class_968;
import com.corrodinggames.rts.gameFramework.class_969;
import com.corrodinggames.rts.gameFramework.class_985;
import com.corrodinggames.rts.gameFramework.a.class_648;
import com.corrodinggames.rts.gameFramework.c.class_39;
import com.corrodinggames.rts.gameFramework.d.Emitter;
import com.corrodinggames.rts.gameFramework.d.class_986;
import com.corrodinggames.rts.gameFramework.d.class_990;
import com.corrodinggames.rts.gameFramework.d.class_995;
import com.corrodinggames.rts.gameFramework.e.class_697;
import com.corrodinggames.rts.gameFramework.f.InterfaceEngine;
import com.corrodinggames.rts.gameFramework.f.class_537;
import com.corrodinggames.rts.gameFramework.g.class_169;
import com.corrodinggames.rts.gameFramework.g.class_173;
import com.corrodinggames.rts.gameFramework.h.class_1009;
import com.corrodinggames.rts.gameFramework.i.ModEngine;
import com.corrodinggames.rts.gameFramework.k.PathEngine;
import com.corrodinggames.rts.gameFramework.m.class_27;
import com.corrodinggames.rts.gameFramework.m.class_28;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.m.class_371;
import com.corrodinggames.rts.gameFramework.m.class_924;
import com.corrodinggames.rts.gameFramework.m.class_925;
import com.corrodinggames.rts.gameFramework.net.GameNetEngine;
import com.corrodinggames.rts.gameFramework.steam.SteamEngine;
import com.corrodinggames.rts.gameFramework.utility.class_680;
import com.corrodinggames.rts.gameFramework.utility.class_682;
import com.corrodinggames.rts.gameFramework.utility.class_686;
import com.corrodinggames.rts.gameFramework.utility.class_688;
import com.corrodinggames.rts.gameFramework.utility.class_689;
import com.corrodinggames.rts.gameFramework.utility.class_694;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Timer;
import java.util.concurrent.ConcurrentLinkedQueue;

public strictfp class EngineLoad extends GameEngine {
    public static String a;
    public static boolean b;
    public static boolean c;
    int d;
    public float e = 1.0F;
    public static String f = null;
    class_170[] g = new class_170[6];
    String h;
    public boolean i = false;
    public int j = 0;
    public ConcurrentLinkedQueue k = new ConcurrentLinkedQueue();
    Paint l;
    Paint m;
    Paint n;
    Paint o;
    Paint p;
    int q = 0;
    int r = 0;
    int s = 0;
    float t = 16.0F;
    public String u = "0fps";
    Rect v = new Rect();
    public ArrayList w = new ArrayList();
    Paint x;
    Paint y;
    Paint z;
    public Paint A = new Paint();
    public class_969 B;
    public class_968 C;
    public class_995 D = new class_995();
    class_160 E;
    boolean F;
    float G = 0.0F;
    public float H = 1.0F;
    public float I;
    public float J;
    class_171 K;
    class_171 L;
    boolean M;
    class_28 N;
    TeamImageCache O;
    TeamImageCache P;
    TeamImageCache Q;
    float R = 0.0F;
    Rect S = new Rect();
    RectF T = new RectF();
    public TeamImageCache U = null;
    public TeamImageCache V = null;
    class_686 W = new class_686("allOnScreenObjects");
    class_686 X = new class_686("allOnScreenObjectsDirty");
    Matrix Y = new Matrix();
    public ArrayList Z = new ArrayList();
    public ArrayList aa = new ArrayList();
    Timer ab;
    boolean ac;
    Object ad = new Object();
    int ae = 0;
    Unit af;
    Unit ag;
    float ah;
    boolean ai;

    public EngineLoad(Context var1) {
        super(var1);
    }

    public strictfp boolean a() {
        if (this.bS.u) {
            return true;
        } else {
            return this.dH != null && this.dH.b();
        }
    }

    public strictfp boolean a(boolean var1) {
        if (!var1 || this.replayEngine.j()) {
            if (this.bS.u) {
                return true;
            }

            if (this.bp) {
                return true;
            }

            if (this.aq && !this.bH) {
                return true;
            }

            if (this.bF && this.dH != null && this.dH.b()) {
                return true;
            }
        }

        if (var1 && !this.netEngine.ingame) {
            return true;
        } else {
            return this.netEngine.I();
        }
    }

    public strictfp int b() {
        return this.s;
    }

    public strictfp boolean c() {
        return this.eh;
    }

    public strictfp boolean d() {
        return this.ei;
    }

    public strictfp synchronized void a(Context var1) {
        Log.d("RustedWarfare", "--- ----------------- ----");
        Log.d("RustedWarfare", "--- GameEngine:init() ----");
        Log.d("RustedWarfare", "--- ----------------- ----");
        if (this.bi) {
            Log.d("RustedWarfare", "GameEngine init has already been called");
        } else {
            GameEngine.log("Version:" + this.r());
            if (C() && this.getClass().equals(EngineLoad.class)) {
                throw new RuntimeException("inSpace but class is:" + this.getClass());
            } else {
                System.gc();
                this.h("Asset Index");
                this.bK = new class_680(var1);
                long var2 = com.corrodinggames.rts.gameFramework.Unit.loadAllUnitsTook();
                this.cd = new com.corrodinggames.rts.gameFramework.Unit(this);
                this.cd.a(class_324.C);
                if (isModsInSD) {
                    this.ci = 1.0F;
                } else {
                    DisplayMetrics var4 = var1.e().getDisplayMetrics();
                    this.ci = var1.e().getDisplayMetrics().density;
                    GameEngine.log("densityScaleRaw: " + this.ci);
                    this.a(var4.widthPixels, var4.heightPixels);
                }

                this.ci *= this.e;
                GameEngine.log("densityScaleRaw*densityScaleMultiplier: " + this.ci);
                if (GameEngine.b(var1)) {
                    this.ar = true;
                }

                this.E = new class_161();
                this.bo = false;
                this.h("InputController");
                this.bT = new class_985();
                this.bT.a();
                this.h("SettingsEngine");
                this.settingsEngine = SettingsEngine.getInstance(var1);
                this.settingsEngine.loadMainExternalFolder(true);
                class_697.b();
                byte var20 = 3;
                if (aZ) {
                    var20 = 1;
                }

                if (this.settingsEngine.numIncompleteLoadAttempts > 1 || this.settingsEngine.numLoadsSinceRunningGameOrNormalExit > var20) {
                    this.ee = true;
                    if (this.settingsEngine.numIncompleteLoadAttempts > 2 || this.settingsEngine.numLoadsSinceRunningGameOrNormalExit > 4) {
                        this.settingsEngine.forceEnglish = true;
                        this.ef = true;
                    }

                    if (this.settingsEngine.numIncompleteLoadAttempts > 3) {
                        this.settingsEngine.newRender = false;
                    }

                    if (this.settingsEngine.numIncompleteLoadAttempts > 4 || this.settingsEngine.numLoadsSinceRunningGameOrNormalExit > 5) {
                        GameEngine.log("Extra safe mode");
                        this.eh = true;
                    }

                    if (this.settingsEngine.numIncompleteLoadAttempts > 5) {
                        GameEngine.log("Extra safe mode x2");
                        this.ei = true;
                    }

                    if (this.settingsEngine.numIncompleteLoadAttempts > 6) {
                        GameEngine.log("Extra safe mode x3");
                        this.settingsEngine.newRender = false;
                        this.settingsEngine.shaderEffects = false;
                        this.settingsEngine.teamShaders = false;
                    }

                    if (this.settingsEngine.newRender && this.settingsEngine.numLoadsSinceRunningGameOrNormalExit > 15) {
                        GameEngine.log("Disabling opengl mode");
                        this.settingsEngine.newRender = false;
                    }

                    GameEngine.log("starting game in safe mode, numIncompleteLoadAttempts:" + this.settingsEngine.numIncompleteLoadAttempts + " numLoadsSinceRunningGameOrNormalExit:" + this.settingsEngine.numLoadsSinceRunningGameOrNormalExit);
                }

                if (aO) {
                    this.ee = true;
                    this.eg = "<forced by command line>";
                }

                if (aP) {
                    this.ee = true;
                    this.eh = true;
                    this.ei = true;
                    this.eg = "<forced by command line>";
                }

                ++this.settingsEngine.numLoadsSinceRunningGameOrNormalExit;
                ++this.settingsEngine.numIncompleteLoadAttempts;
                boolean var5 = this.settingsEngine.save();
                if (!var5 && aZ) {
                    GameEngine.log("starting game in safe mode, failed to save settings");
                    this.eg = "failing to write preferences data";
                    this.ee = true;
                }

                class_39.a();
                this.cj = this.W();
                GameEngine.log("densityScale(): " + this.cj);
                long var6 = com.corrodinggames.rts.gameFramework.Unit.loadAllUnitsTook();
                class_1009.a();
                com.corrodinggames.rts.gameFramework.Unit.a("Locale.init took:", var6);
                PlayerData.L();
                this.l = new Paint();
                this.m = new Paint();
                this.m.a(255, 255, 255, 255);
                this.m.a(true);
                this.a(this.m, 16.0F);
                this.n = new Paint();
                this.n.a(255, 255, 255, 255);
                this.n.a(true);
                this.a(this.n, 16.0F);
                this.o = new Paint();
                this.o.a(100, 255, 0, 0);
                this.a(this.o, 16.0F);
                this.p = new Paint();
                this.p.a(100, 0, 255, 0);
                this.a(this.p, 16.0F);
                this.dn = new Paint();
                this.doo = new Paint();
                this.doo.a(Paint$Align.b);
                this.doo.a(true);
                this.doo.a(Typeface.a((Typeface)Typeface.c, 0));
                this.a(this.doo, 16.0F);
                this.dp = new Paint();
                this.dp.a(255, 230, 255, 230);
                this.dp.a(true);
                this.dp.a(Paint$Align.b);
                this.a(this.dp, 18.0F);
                this.x = new Paint();
                this.x.b(-1);
                this.x.c(100);
                this.y = new Paint();
                this.y.b(-7829368);
                this.y.c(240);
                this.y.a(Paint$Style.b);
                this.y.a(1.0F);
                long var8 = com.corrodinggames.rts.gameFramework.Unit.loadAllUnitsTook();
                this.h("AudioEngine");
                class_648.b();
                this.bM = new class_648();
                this.bM.a(var1);
                com.corrodinggames.rts.gameFramework.Unit.a("AudioEngine took:", var8);
                this.h("MusicController");
                this.bN = new class_1001();
                this.bN.a(var1);
                if (bh != null) {
                    log("init(): using Graphics instance");
                    this.bO = bh;
                } else if (bg != null) {
                    log("init(): using GraphicsSlick2d");

                    try {
                        this.bO = (class_28)bg.newInstance();
                    } catch (InstantiationException var18) {
                        throw new RuntimeException(var18);
                    } catch (IllegalAccessException var19) {
                        throw new RuntimeException(var19);
                    }
                } else if (isModsInSD) {
                    this.bO = new class_924();
                } else {
                    this.bO = new class_925();
                }

                this.h("graphics.init");
                this.bO.a(var1);
                this.bO.b();
                FileChangeEngine.a();
                this.h("Fonts");
                this.Y();
                this.h("effects.init");
                this.bR = new class_986();
                this.bR.a(var1);
                this.h("minimapHandler");
                this.bW = new class_537();
                this.bW.a(var1);
                if (ck != null) {
                    GameEngine.log("We have an initial screen size, can do early setup of image buffers");
                    this.h("Map Buffers");
                    this.b(ck.a, ck.b);
                    this.k();
                    class_484.d();
                    class_484.f();
                    this.bW.e();
                    boolean var10 = GameEngine.aA();
                    if (var10) {
                        this.h("Setting up postprocessing");
                        boolean var11 = this.i();
                        if (!var11) {
                            GameEngine.log("Failed to setup postprocessing");
                        }
                    }
                }

                this.h("PathEngine");
                this.bU = new PathEngine();
                this.h("GroupController");
                this.bV = new GroupController();
                this.h("CollisionEngine");
                this.bP = new CollisionEngine();
                this.h("InterfaceEngine");
                this.bS = new InterfaceEngine();
                this.bS.a(var1);
                this.C = class_968.c(var1);
                this.h("NetworkEngine");
                this.netEngine = new GameNetEngine();
                this.netEngine.F();
                this.h("StatsHandler");
                this.stats = new StatsHandler();
                this.h("ModEngine");
                this.bZ = new ModEngine();
                this.bZ.a();
                if (this.ee) {
                    this.bZ.g();
                }

                this.h("CommandController");
                this.cf = new CommandController();
                this.h("GameSaver");
                this.ca = new GameSaver();
                this.h("ReplayEngine");
                this.replayEngine = new ReplayEngine();
                this.replayEngine.a(var1);
                this.h("UnitGeoIndex");
                this.cc = new UnitGeoIndex();
                this.h("Precalculating map fog");
                class_484.c();
                this.h("ScorchMark.load");
                ScorchMark.load();
                this.h("Projectile.load");
                Projectile.load();
                this.h("Emitter.load");
                Emitter.load();
                this.h("Unit.loadAllUnits");
                long var21 = com.corrodinggames.rts.gameFramework.Unit.loadAllUnitsTook();
                Unit.bH();
                com.corrodinggames.rts.gameFramework.Unit.a("loadAllUnits took:", var21);
                this.h("Loading custom unit data");
                long var12 = com.corrodinggames.rts.gameFramework.Unit.loadAllUnitsTook();
                class_436.h();
                this.h("getAllUnitsChecksum");
                com.corrodinggames.rts.gameFramework.Unit.a("CustomUnits took:", var12);
                long var14 = com.corrodinggames.rts.gameFramework.Unit.loadAllUnitsTook();
                this.d = Unit.bM();
                com.corrodinggames.rts.gameFramework.Unit.a("allUnitsChecksum took:", var14);
                this.z = new Paint();
                this.z.a(50, 255, 255, 255);
                this.F();
                System.gc();
                this.bi = true;
                GameEngine.log("Init completed");
                com.corrodinggames.rts.gameFramework.Unit.a("Loading took:", var2);
                this.cd.b(class_324.C);
                this.cd.a(true, true);
                long var16 = com.corrodinggames.rts.gameFramework.Unit.loadAllUnitsTook();
                this.h("Loading map data");
                if (!GameEngine.ay) {
                    this.x();
                }

                com.corrodinggames.rts.gameFramework.Unit.a("loadAMenuMap took:", var16);
                this.h("Last setup");
                ap();
                this.netEngine.m();
                this.h("init complete");
                if (aE) {
                    UnitType.printForHelp();
                    System.exit(0);
                }

                if (aF) {
                    UnitType.r();
                    System.exit(0);
                }

                this.bj = true;
            }
        }
    }

    public strictfp void a(int var1, int var2) {
        float var3 = 1.0F;
        float var4 = class_340.b(0.0F, 0.0F, (float)var1, (float)var2);
        float var5 = 1131.0F;
        var3 = var4 / var5;
        GameEngine.log("defaultViewpointZoomDensity: " + var3);
        if (var3 < 0.5F) {
            var3 = 0.5F;
        }

        if (var3 > 3.0F) {
            var3 = 3.0F;
        }

        GameEngine.log("defaultViewpointZoomDensity after limit: " + var3);
        this.cY = 1.0F;
        if ((double)class_340.c(var3 - 1.0F) > 0.1) {
            this.cY = var3;
            if (this.cY > 2.0F) {
                this.cY = 2.0F;
            }

            if (this.cY < 0.5F) {
                this.cY = 0.5F;
            }

            this.cX = this.cV * this.cY;
        }

    }

    public strictfp void e() {
        this.K();
        this.f();
    }

    public strictfp void f() {
        this.b(false);
        this.bG = false;
        this.bH = false;
        this.bF = false;
        this.bp = false;
        this.bS.u = false;
    }

    public strictfp synchronized void a(boolean var1, class_337 var2) {
        this.K();
        this.a(var1, false, var2);
    }

    public strictfp void a(boolean var1, boolean var2, class_337 var3) {
        this.bC = this.settingsEngine.teamUnitCapSinglePlayer;
        if (this.bC < 1) {
            this.bC = 1;
        }

        this.bB = this.bC;
        this.b(var2);
        PlayerData.X();
        this.bo = false;
        System.gc();
        this.bI = true;
        this.bG = false;
        this.bp = false;
        this.bF = false;
        this.by = 0;
        this.ch = false;
        this.netEngine.a(1L);
        this.tick = 0;
        this.bJ = 0;
        class_340.a();
        this.netEngine.t();
        if (!var2) {
            this.dq = false;
            this.dr = false;
            this.ds = 0.0F;
            this.du = false;
            this.dt = false;
        }

        this.j = 0;
        if (!var2) {
            this.cV = 1.0F;
        }

        this.dx = 0.0F;
        if (!this.replayEngine.j()) {
            if (!this.netEngine.B) {
                class_436.b(true);
            } else {
                class_436.d();
            }
        }

        int var4;
        if (!this.netEngine.B) {
            if (!this.replayEngine.j() && var1) {
                this.playerTeam = new Player(0);
                this.playerTeam.name = "Player";

                for(var4 = 1; var4 < 8; ++var4) {
                    new class_138(var4);
                }

                this.netEngine.aq();
            }
        } else {
            this.playerTeam = this.netEngine.z;
            if (this.playerTeam == null) {
                throw new RuntimeException("cannot find player's team");
            }

            if (this.playerTeam != PlayerData.getPlayerData(this.playerTeam.site)) {
                GameEngine.warn("Stale playerTeam");
            }
        }

        this.ce = null;
        this.bL = new class_484();

        try {
            if (this.dm != null) {
                InputStream var24 = this.dm.getUseStream();

                try {
                    var24.reset();
                } catch (IOException var22) {
                    var22.printStackTrace();
                }

                this.bL.a(var24, var2);
            } else {
                this.bL.a(this.ak(), var2);
            }
        } catch (Exception var23) {
            var23.printStackTrace();
            this.log("Error loading map: " + var23.getMessage(), 1);
            if (aT) {
                GameEngine.log("Crashing on allowed map error because automated testing is active");
                throw new RuntimeException(var23);
            }

            if (!this.netEngine.B && this.ao != null) {
                class_198 var5 = this.ao.i();
                if (var5 != null) {
                    var5.m();
                }
            }

            String var25 = a((Throwable)var23);
            e("Map Load Warning", var25);
            this.bI = false;
            return;
        }

        if (!this.bL.W) {
            log("map did not load, returning");
            this.bI = false;
        } else {
            this.bL.G = false;
            PlayerData.e();

            for(var4 = 0; var4 < PlayerData.c; ++var4) {
                PlayerData var26 = PlayerData.getPlayerData(var4);
                if (var26 != null) {
                    var26.J();
                }
            }

            if (!var2) {
                class_591.F();
            }

            if (!this.netEngine.B && !this.replayEngine.j()) {
                this.netEngine.gameMapData.income = 1.0F;
                this.netEngine.gameMapData.q = class_340.rand(1, 1000000000);
            }

            this.bJ = this.netEngine.gameMapData.q;
            log("global Seed: " + this.bJ);
            int var28;
            if (this.netEngine.B || this.replayEngine.j()) {
                if (!this.netEngine.F) {
                    this.bB = this.netEngine.aw;
                    this.bC = this.netEngine.ax;
                }

                GameEngine.log("Unit cap is now: " + this.bC);
                if (this.netEngine.gameMapData.fog == 0) {
                    this.bL.E = false;
                    this.bL.F = false;
                } else if (this.netEngine.gameMapData.fog == 1) {
                    this.bL.E = true;
                    this.bL.F = false;
                } else if (this.netEngine.gameMapData.fog == 2) {
                    this.bL.E = true;
                    this.bL.F = true;
                }

                this.bL.G = this.netEngine.gameMapData.e;
                byte var27 = 10;
                if (this.netEngine.gameMapData.e) {
                    var27 = 10;
                }

                for(var28 = 0; var28 < PlayerData.c; ++var28) {
                    PlayerData var6 = PlayerData.getPlayerData(var28);
                    if (var6 != null) {
                        if (var6.N == null) {
                            GameEngine.log("Fog null for team: " + var6.site);
                        } else {
                            for(int var7 = 0; var7 < this.bL.width; ++var7) {
                                for(int var8 = 0; var8 < this.bL.height; ++var8) {
                                    var6.N[var7][var8] = var27;
                                }
                            }
                        }
                    }
                }

                var28 = this.netEngine.k();

                label399:
                for(int var29 = 0; var29 < PlayerData.c; ++var29) {
                    PlayerData var33 = PlayerData.getPlayerData(var29);
                    if (var33 != null) {
                        var33.credits = (double)var28;
                        if (var33.w) {
                            if (!var33.y) {
                                if (var33.aiDifficulty != null) {
                                    var33.x = var33.aiDifficulty;
                                } else {
                                    var33.x = this.netEngine.gameMapData.aidiff;
                                }
                            } else {
                                var33.c("aiDifficulty is locked");
                            }
                        }

                        var33.sharedControl_1 = this.netEngine.gameMapData.sharedControl;
                        boolean var36 = false;
                        boolean var9 = false;
                        int var10 = this.netEngine.gameMapData.initUnit;
                        if (var33.startUnit != null) {
                            var10 = var33.startUnit;
                        }

                        if (var10 != 1) {
                            boolean var11 = true;
                            boolean var12 = true;
                            Float var13 = null;
                            Float var14 = null;
                            Float var15 = null;
                            Float var16 = null;
                            if (var10 == 5 || var10 == 4 || var10 > 10) {
                                var12 = false;
                            }

                            if (var10 == 5 || var10 == 4 || var10 == 3 || var10 > 10) {
                                var11 = false;
                            }

                            if (var10 == 9) {
                                var12 = false;
                                var11 = false;
                            }

                            Iterator var17 = Unit.bF().iterator();

                            while(true) {
                                while(true) {
                                    Unit var18;
                                    do {
                                        do {
                                            do {
                                                if (!var17.hasNext()) {
                                                    if (var13 == null) {
                                                        var13 = var15;
                                                        var14 = var16;
                                                    }

                                                    if (var13 == null) {
                                                        GameEngine.log("placementLocation==null for team:" + var33.site);
                                                        continue label399;
                                                    }

                                                    float var38 = var13;
                                                    float var39 = var14;
                                                    int var19;
                                                    Unit var20;
                                                    if (var10 != 2) {
                                                        if (var10 != 3 && var10 != 4) {
                                                            if (var10 == 5) {
                                                                class_31 var41 = UnitType.a("experimentalSpider");
                                                                if (var41 == null) {
                                                                    GameNetEngine.g("Could not find: experimentalSpider on network.setup.startingUnits==5");
                                                                } else {
                                                                    var20 = var41.a();
                                                                    var20.b(var33);
                                                                    var20.xCord = var38;
                                                                    var20.yCord = var39;
                                                                    var20.cg = 90.0F;
                                                                    var20.zCord = 2.0F;
                                                                    var20.dc();
                                                                    PlayerData.c(var20);
                                                                }
                                                            } else if (var10 != 9 && var10 > 10) {
                                                                class_591 var42 = class_591.c(var10);
                                                                if (var42 == null) {
                                                                    GameNetEngine.g("Could not find starting unit on startingUnits==" + var10);
                                                                } else {
                                                                    var20 = var42.a();
                                                                    var20.b(var33);
                                                                    var20.xCord = var38;
                                                                    var20.yCord = var39;
                                                                    if (!var20.bI()) {
                                                                        var20.cg = 90.0F;
                                                                    }

                                                                    if (var42.eI) {
                                                                        var20.dc();
                                                                        if (var20 instanceof class_113) {
                                                                            ((class_113)var20).dB();
                                                                        }
                                                                    }

                                                                    PlayerData.c(var20);
                                                                }
                                                            }
                                                            continue label399;
                                                        }

                                                        var19 = 0;

                                                        while(true) {
                                                            if (var19 > 2) {
                                                                continue label399;
                                                            }

                                                            class_31 var40 = UnitType.a("combatEngineer");
                                                            if (var40 == null) {
                                                                GameNetEngine.g("Could not find: combatEngineer on network.setup.startingUnits==3");
                                                            } else {
                                                                Unit var21 = var40.a();
                                                                var21.b(var33);
                                                                var21.xCord = var38 - 50.0F + (float)(var19 * 50);
                                                                var21.yCord = var39 + 50.0F;
                                                                PlayerData.c(var21);
                                                            }

                                                            ++var19;
                                                        }
                                                    }

                                                    for(var19 = 0; var19 <= 2; ++var19) {
                                                        if (var19 != 1) {
                                                            var20 = UnitType.builder.a();
                                                            var20.b(var33);
                                                            var20.xCord = var38 - 50.0F + (float)(var19 * 50);
                                                            var20.yCord = var39;
                                                            PlayerData.c(var20);
                                                        }
                                                    }

                                                    var19 = 0;

                                                    while(true) {
                                                        if (var19 > 2) {
                                                            continue label399;
                                                        }

                                                        var20 = UnitType.heavyTank.a();
                                                        var20.b(var33);
                                                        var20.xCord = var38 - 50.0F + (float)(var19 * 50);
                                                        var20.yCord = var39 + 50.0F;
                                                        PlayerData.c(var20);
                                                        ++var19;
                                                    }
                                                }

                                                var18 = (Unit)var17.next();
                                            } while(!(var18 instanceof Unit));
                                        } while(var18.bV);
                                    } while(var18.bX != var33);

                                    if (var18.bO && !var36) {
                                        var36 = true;
                                        var13 = var18.xCord;
                                        var14 = var18.yCord;
                                        if (!var11) {
                                            var18.ci();
                                            continue;
                                        }
                                    }

                                    if (var18.bP && !var9) {
                                        var9 = true;
                                        var15 = var18.xCord;
                                        var16 = var18.yCord;
                                        if (!var12) {
                                            var18.ci();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if (!var2 && (this.ce == null || !this.ce.q)) {
                this.a(0.0F, 0.0F);
                var4 = 0;
                var28 = 0;
                boolean var30 = false;
                Iterator var35 = Unit.bE.iterator();

                Unit var37;
                while(var35.hasNext()) {
                    var37 = (Unit)var35.next();
                    if (var37 instanceof Tree) {
                        ++var28;
                    } else {
                        ++var4;
                    }

                    if (var37.bX == this.playerTeam && var37.bP) {
                        this.b(var37.xCord, var37.yCord);
                        var30 = true;
                    }
                }

                if (!var30) {
                    var35 = Unit.bE.iterator();

                    while(var35.hasNext()) {
                        var37 = (Unit)var35.next();
                        if (var37.bX == this.playerTeam && !var37.t() && !var37.u()) {
                            this.b(var37.xCord, var37.yCord);
                        }
                    }
                }

                log("there are " + var4 + " units on this map and " + var28 + " trees");
            }

            this.B = class_968.c(this.am).b(this.ak());
            this.bU.a(this.bL, var2);
            this.bW.a(this.bL, var2);
            this.cf.a();
            this.bV.a();
            if (!var2) {
                class_990.a();
            }

            this.ca.a(var2);
            this.bS.a(var2);
            if (!var2) {
                this.bS.y();
                this.aG();
                if (this.bv) {
                    this.bS.y();
                }
            } else {
                this.bS.y();
            }

            this.cc.a(this.bL);
            if (!var2) {
                this.bN.c();
            }

            this.stats.a();
            Iterator var31 = Unit.bE.iterator();

            while(var31.hasNext()) {
                Unit var32 = (Unit)var31.next();
                if (var32 instanceof OrderableUnit) {
                    OrderableUnit var34 = (OrderableUnit)var32;
                    var34.c(false);
                }
            }

            this.B.e = true;
            this.C.a(this.am);
            this.bG = true;
            this.bH = false;
            this.bI = false;
            if (var3 != class_337.MENU && !this.settingsEngine.hasPlayedGameOrSeenHelp) {
                this.settingsEngine.hasPlayedGameOrSeenHelp = true;
                this.settingsEngine.save();
            }

            for(var4 = 0; var4 < 5; ++var4) {
                System.gc();
            }

            if (!GameEngine.isModsInSD) {
                Log.a("RustedWarfare", "getNativeHeapSize" + String.valueOf(Debug.getNativeHeapSize()));
                Log.a("RustedWarfare", "getNativeHeapAllocatedSize" + String.valueOf(Debug.getNativeHeapAllocatedSize()));
                Log.a("RustedWarfare", "getNativeHeapFreeSize" + String.valueOf(Debug.getNativeHeapFreeSize()));
                Log.a("RustedWarfare", "Runtime.getRuntime().maxMemory()" + String.valueOf(Runtime.getRuntime().maxMemory()));
            }

            if (this.gameThread != null) {
                this.gameThread.a();
            }

            this.G = 0.0F;
            if (this.netEngine.F && this.netEngine.B) {
                GameEngine.log("Disabling network for singleplayer");
                this.netEngine.B = false;
            }

            if (!ax()) {
                if (var3 == class_337.NORMAL_SAVE) {
                    GameEngine.log("Not starting replay recording as we are loading a save");
                } else {
                    this.replayEngine.a(var2);
                }
            }

            if (PathEngine.m) {
            }

        }
    }

    private strictfp void aG() {
        this.bS.y();
        Iterator var1 = Unit.bE.iterator();

        Unit var2;
        do {
            if (!var1.hasNext()) {
                GameEngine.log("selectAnyOnScreenBuilder: no builder found");
                return;
            }

            var2 = (Unit)var1.next();
        } while(var2.bX != this.playerTeam || !(var2 instanceof OrderableUnit) || !var2.ak() || !var2.s_() || !var2.bT() || var2.u() || var2.t());

        GameEngine.log("selectAnyOnScreenBuilder: found builder");
        this.bS.j(var2);
    }

    public strictfp void g() {
        class_682 var1 = GameObject.dK();
        Iterator var2 = var1.iterator();

        while(var2.hasNext()) {
            GameObject var3 = (GameObject)var2.next();
            var3.a();
        }

        Unit.bF();
        GameObject.dK();
        int var6 = var1.size();
        if (var6 != 0) {
            GameEngine.a("SHOULD_NOT_HAPPEN: we still had " + var6 + " objects in gameObjectListForLogic after removeAll");

            String var5;
            for(Iterator var7 = var1.iterator(); var7.hasNext(); GameEngine.a("Remaining object: " + var5)) {
                GameObject var4 = (GameObject)var7.next();
                var5 = "Object: " + var4.id;
                if (var4 instanceof Unit) {
                    var5 = ((Unit)var4).c();
                }
            }

            if (GameEngine.getGameEngine().aa()) {
                throw new RuntimeException("We still had " + var6 + " objects in gameObjectListForLogic after removeAll");
            }
        }

        Unit.bF().clear();
        GameObject.dK().clear();
        class_113.dD();
        this.W.clear();
    }

    public strictfp void b(boolean var1) {
        synchronized(this.aj) {
            if (this.ao != null) {
                this.ao.l();
            }

            this.bq = false;
            if (!var1) {
                this.replayEngine.g();
            }

            this.bU.c();
            this.g();
            if (!av()) {
                this.bN.f();
            }

            this.bR.a(var1);
            if (this.bL != null) {
                this.bL.h();
                this.bL = null;
            }

            if (this.ce != null) {
                this.ce = null;
            }

            if (this.cc != null) {
                this.cc.b();
            }

            this.af = null;
            this.ag = null;
            this.j = 0;
            PlayerData.Y();
            this.a(class_173.none, class_169.PLAYER);
        }
    }

    public strictfp void a(float var1, int var2) {
        synchronized(this.aj) {
            this.b(var1, var2);
        }
    }

    public strictfp void b(float var1, int var2) {
        if (this.tick == 2) {
            this.aF();
        } else if (this.tick % 10000 == 0 && this.tick != 0) {
            this.aF();
        }

        if (aL && !this.aS && at() && Debug.getNativeHeapAllocatedSize() > 209715200L) {
            GameEngine.log("getNativeHeapAllocatedSize: " + class_340.g((int)Debug.getNativeHeapAllocatedSize()));
            this.aS = true;
        }

        this.aE();
        this.eb.a();
        this.ec.b();
        this.cd.a(class_324.a);
        this.netEngine.b(var1);
        this.ao = this.ap;
        if (this.ao.b()) {
            this.cd.a(class_324.b);

            while(this.k.peek() != null) {
                Runnable var3 = (Runnable)this.k.poll();
                var3.run();
            }

            if (!this.bG) {
                if (!this.aq) {
                    Log.d("RustedWarfare", "game running without a loaded level!!!");
                    this.h();

                    try {
                        Thread.sleep(10L);
                    } catch (InterruptedException var21) {
                        var21.printStackTrace();
                    }

                }
            } else {
                this.bq = true;
                if (!this.F && this.tick > 5) {
                    this.F = true;
                    boolean var25 = false;
                    if (this.settingsEngine.numIncompleteLoadAttempts > 1) {
                        var25 = true;
                    }

                    this.settingsEngine.numIncompleteLoadAttempts = 0;
                    if (this.ee) {
                        this.settingsEngine.numLoadsSinceRunningGameOrNormalExit = 0;
                    }

                    this.settingsEngine.save();
                    if (this.ee && (this.ef || this.bZ.c() > 0)) {
                        if (this.eg != null) {
                            this.c("Safe mode", "Started game in safe mode due to " + this.eg + ". Mods have been disabled.");
                        } else if (var25) {
                            this.c("Safe mode", "Started game in safe mode due to failed loading attempts. Mods have been disabled.");
                        } else {
                            this.c("Safe mode", "Started game in safe mode due to multiple loads without starting a game or exiting. Mods have been disabled.");
                        }
                    }
                }

                if (!this.bH && this.bG && this.settingsEngine.numLoadsSinceRunningGameOrNormalExit != 0) {
                    this.settingsEngine.numLoadsSinceRunningGameOrNormalExit = 0;
                    this.settingsEngine.save();
                }

                this.ca.b();
                float var26 = this.cV * this.cY;
                float var4;
                float var5;
                float var6;
                if (var26 != this.cX) {
                    var4 = this.da / this.cX + this.cy;
                    var5 = this.db / this.cX + this.cz;
                    this.cX = var26;
                    this.k();
                    if (this.cZ) {
                        var6 = this.da / this.cX + this.cy;
                        float var7 = this.db / this.cX + this.cz;
                        this.a(this.cy - (var6 - var4), this.cz - (var7 - var5));
                        this.cZ = false;
                    }
                }

                if (this.cr != 0.0F || this.cs != 0.0F) {
                    var4 = 3.0F * var1;
                    var5 = 0.0F;
                    if (this.cr > 0.0F) {
                        var5 = class_340.g(this.cr, var4);
                    }

                    if (this.cr < 0.0F) {
                        var5 = class_340.f(this.cr, -var4);
                    }

                    var5 += 0.15F * this.cr;
                    var6 = 0.0F;
                    if (this.cs > 0.0F) {
                        var6 = class_340.g(this.cs, var4);
                    }

                    if (this.cs < 0.0F) {
                        var6 = class_340.f(this.cs, -var4);
                    }

                    var6 += 0.15F * this.cs;
                    if (class_340.c(this.cr) <= var4) {
                        var5 = this.cr;
                        this.cr = 0.0F;
                    } else {
                        this.cr -= var5;
                    }

                    if (class_340.c(this.cs) <= var4) {
                        var6 = this.cs;
                        this.cs = 0.0F;
                    } else {
                        this.cs -= var6;
                    }

                    this.cy += var5;
                    this.cz += var6;
                    this.a(this.cy, this.cz);
                    this.Q();
                }

                if (this.cR != this.cS) {
                    this.k();
                }

                if (var1 > 3.0F) {
                    var1 = 3.0F;
                }

                if (var1 < 0.0F) {
                    var1 = 0.0F;
                }

                if (this.bu >= 0.0F) {
                    var1 = this.bu;
                }

                this.bA = (int)((float)this.bA + var1 * 16.666666F);
                this.d(var1);
                this.q += var2;
                ++this.r;
                if (this.r >= 40) {
                    if (this.q == 0) {
                        this.q = 1;
                    }

                    this.s = (int)((float)(this.r * 1000 / this.q) + 0.5F);
                    this.t = (float)this.q / (float)this.r;
                    this.q = 0;
                    this.r = 0;
                    if (this.settingsEngine.showFps) {
                        this.u = this.s + "fps";
                    }
                }

                this.aj();

                for(int var27 = 0; var27 < this.dM.length; ++var27) {
                    this.dM[var27] = true;
                }

                this.dh = class_340.a(this.dh, 0.1F * var1);
                this.di = class_340.a(this.di, 0.1F * var1);
                this.dh = class_340.b(this.dh, 5.0F);
                this.di = class_340.b(this.di, 5.0F);
                this.bS.a(var1);
                this.Q();
                class_484.f();
                if (this.netEngine.B) {
                    var4 = var1;
                    if (this.replayEngine.v != 1) {
                        var4 = var1 * (float)this.replayEngine.v;
                    }

                    this.netEngine.a(var4);
                    if (!this.a(true) && !this.netEngine.Y) {
                        this.G += var4;

                        while(this.G > this.netEngine.getCurrentStepRate()) {
                            if (this.netEngine.I()) {
                                this.netEngine.Y = true;
                                break;
                            }

                            this.G -= this.netEngine.getCurrentStepRate();
                            this.netEngine.a(this.netEngine.getCurrentStepRate(), false);
                            if (this.netEngine.Y) {
                                break;
                            }

                            this.a(this.netEngine.getCurrentStepRate());
                        }

                        if (!this.netEngine.isServer) {
                            if (this.netEngine.af || this.netEngine.ad) {
                                if (this.netEngine.af && this.netEngine.ad && this.tick < this.netEngine.loaclTick - this.netEngine.Q - 5) {
                                    this.netEngine.printLog("nearly within frame range");
                                    this.netEngine.af = false;
                                }

                                if (this.tick > this.netEngine.loaclTick - 6) {
                                    this.netEngine.printLog("we have back within frame range");
                                    this.netEngine.af = false;
                                    this.netEngine.ad = false;
                                }
                            }

                            if (!this.netEngine.ad && this.tick < this.netEngine.loaclTick - this.netEngine.Q - 10) {
                                this.netEngine.printLog("we are slightly out of frame range, speeding up");
                                this.netEngine.ad = true;
                            }

                            if (!this.netEngine.af && this.tick < this.netEngine.loaclTick - this.netEngine.Q - 30) {
                                this.netEngine.printLog("we are out of frame range, fast forwarding (" + this.tick + "->" + this.netEngine.loaclTick + ")");
                                this.netEngine.af = true;
                            }

                            if (!this.netEngine.af && this.netEngine.ad) {
                                GameNetEngine var10000 = this.netEngine;
                                var10000.ae += var1;
                                if (this.netEngine.ae > this.netEngine.getCurrentStepRate() * 3.0F) {
                                    this.netEngine.ae = 0.0F;
                                    this.netEngine.a(this.netEngine.getCurrentStepRate(), true);
                                    if (!this.netEngine.Y) {
                                        this.a(this.netEngine.getCurrentStepRate());
                                    }
                                }
                            }

                            if (this.netEngine.af) {
                                this.netEngine.a(this.netEngine.getCurrentStepRate(), true);
                                if (!this.netEngine.Y) {
                                    this.a(this.netEngine.getCurrentStepRate());
                                }
                            }

                            if (this.tick < this.netEngine.loaclTick - 90) {
                                this.netEngine.a(this.netEngine.getCurrentStepRate(), true);
                                if (!this.netEngine.Y) {
                                    this.a(this.netEngine.getCurrentStepRate());
                                }
                            }

                            if (this.tick < this.netEngine.loaclTick - 120) {
                                this.netEngine.a(this.netEngine.getCurrentStepRate(), true);
                                if (!this.netEngine.Y) {
                                    this.a(this.netEngine.getCurrentStepRate());
                                }
                            }

                            if (this.tick < this.netEngine.loaclTick - 600) {
                                this.netEngine.a(this.netEngine.getCurrentStepRate(), true);
                                if (!this.netEngine.Y) {
                                    this.a(this.netEngine.getCurrentStepRate());
                                }
                            }
                        }
                    }
                } else if (this.replayEngine.i()) {
                    var4 = var1;
                    if (this.replayEngine.v != 1) {
                        var4 = var1 * (float)this.replayEngine.v;
                    }

                    if (this.bt != 1.0F) {
                        var4 *= this.bt;
                    }

                    if (!this.a(false)) {
                        this.G += var4;

                        while(this.G > this.netEngine.getCurrentStepRate()) {
                            this.G -= this.netEngine.getCurrentStepRate();
                            if (this.netEngine.I()) {
                                break;
                            }

                            this.a(this.netEngine.getCurrentStepRate());
                        }
                    }

                    if (this.G > 100.0F) {
                        this.G = 100.0F;
                    }

                    if (this.G < 0.0F) {
                        this.G = 0.0F;
                    }
                } else if (!this.a(false)) {
                    this.a(var1);
                }

                if (this.a(false)) {
                    try {
                        Thread.sleep(2L);
                    } catch (Exception var22) {
                    }
                }

                this.bU.a(var1);
                this.bM.b(var1);
                this.bN.a(var1);
                this.bT.b();
                SteamEngine.getSteamEngine().a(var1);
                this.cd.b(class_324.b);
                this.cd.a(class_324.c);
                if (!this.dv) {
                    if (this.bO.a()) {
                        this.a((class_27)null, var1);
                    } else if (this.ao.n()) {
                        class_27 var29 = this.ao.b(true);
                        this.a(var29, var1);
                    } else {
                        class_0 var30 = this.ao;
                        this.ao.a(var1, var2);
                        if (var30.c() && !var30.e()) {
                            synchronized(var30.g()) {
                                if (var30.c() && !var30.e()) {
                                    this.cd.a(class_324.w);
                                    class_27 var32 = var30.b(true);
                                    this.cd.b(class_324.w);

                                    try {
                                        if (!var30.e()) {
                                            if (var32 != null) {
                                                if (var32.c()) {
                                                    GameEngine.log("gameengine draw: bufferedCanvas drawn on");
                                                }

                                                var32.a(true);
                                            }

                                            if (var32 == null) {
                                                GameEngine.f("GameEngine gameViewCanvas is null after lockCanvas - " + var30.hashCode());
                                            }

                                            this.a(var32, var1);
                                            this.bO.a((class_27)null);
                                        }
                                    } finally {
                                        if (var32 != null) {
                                            try {
                                                var30.a(var32, true);
                                            } catch (IllegalArgumentException var19) {
                                                var19.printStackTrace();
                                                GameEngine.f("GameEngine catch currentGameView - " + var30.hashCode());
                                                GameEngine.f("GameEngine catch currentGameView.gameThreadSync - " + var30.g().hashCode());
                                                var30.h();
                                            } catch (IllegalStateException var20) {
                                                var20.printStackTrace();
                                                GameEngine.f("GameEngine catch currentGameView - " + var30.hashCode());
                                                GameEngine.f("GameEngine catch currentGameView.gameThreadSync - " + var30.g().hashCode());
                                            }
                                        }

                                    }
                                }
                            }
                        }

                        this.ao.b(var1, var2);
                    }
                }

                this.dv = false;
                this.Z();
                this.cd.b(class_324.c);
                if (this.du) {
                    this.du = false;
                    Integer var31 = l(this.dl);
                    String var28 = null;
                    if (var31 != null) {
                        var28 = m(this.dl);
                    }

                    if (this.netEngine.B) {
                        var28 = null;
                        (new EngineLoad$a(this)).start();
                    }

                    if (var28 != null) {
                        GameEngine.log("gotoNextLevel: Loading next level: " + var28);
                        this.dl = var28;
                        this.bS.h.b();
                        this.a(true, false, class_337.NORMAL);
                    } else {
                        GameEngine.log("gotoNextLevel: No next level, finishing");
                        this.bG = false;
                        class_198 var33 = this.ao.i();
                        if (var33 != null) {
                            var33.b();
                            var33.m();
                        } else {
                            GameEngine.log("gotoNextLevel: Error getInGameActivity==null");
                        }
                    }
                }

                if (!this.aq && this.bE && !this.i) {
                    log("starting method trace");
                    Debug.startMethodTracing("lukeTrace", 110000000);
                    this.i = true;
                }

                this.bF = true;
                this.ed.a();
                this.cd.b(class_324.a);
                this.cd.b();
            }
        }
    }

    public strictfp void h() {
        class_198 var1 = this.ao.i();
        if (var1 != null) {
            if (!var1.c()) {
                var1.b();
            } else {
                GameEngine.print("stopAndClose: inGameActivity is isFinishing");
            }
        } else {
            GameEngine.print("stopAndClose: Error getInGameActivity==null");
        }

    }

    public strictfp void a(float var1) {
        if (this.ay() && var1 < 0.1F) {
            GameNetEngine.g("updateAllGame1: deltaSpeed:" + var1 + " frame:" + this.tick + " network.currentStepRate:" + this.netEngine.getCurrentStepRate());
        }

        if (this.bt != 1.0F && !this.netEngine.B && !this.replayEngine.i()) {
            var1 *= this.bt;
        }

        var1 *= this.H;
        this.I = var1 + 2.0F;
        this.J = var1;
        this.netEngine.c(var1);
        this.by = (int)((float)this.by + var1 * 16.666666F);
        this.cf.c();
        this.replayEngine.updateGameFrame(var1);
        ++this.tick;
        PlayerData.g(var1);
        if (this.bL != null) {
            this.bL.e(var1);
        }

        if (this.ay() && var1 < 0.1F) {
            GameNetEngine.g("updateAllGame2: deltaSpeed:" + var1 + " frame:" + this.tick);
        }

        Unit.bF();
        class_682 var2 = GameObject.dK();
        Object[] var3 = var2.b();
        int var4 = var2.size();
        boolean var5 = this.ay();

        int var6;
        for(var6 = 0; var6 < var4; ++var6) {
            GameObject var7 = (GameObject)var3[var6];
            if (var5 && var1 != this.J) {
                GameNetEngine.h("JIT bug detected, attempting to correct. before object:" + var7.id + " frame:" + this.tick + " deltaSpeed:" + var1);
                var1 = this.J;
            }

            var7.a(var1);
        }

        if (this.ay() && var1 < 0.1F) {
            GameNetEngine.g("updateAllGame3: deltaSpeed:" + var1 + " frame:" + this.tick);
        }

        var6 = var2.a.size();

        int var13;
        for(var13 = 0; var13 < var6; ++var13) {
            class_689 var8 = (class_689)var2.a.get(var13);
            if (var8.a == class_688.ADD) {
                GameObject var9 = (GameObject)var8.b;
                if (!var9.ej) {
                    var9.a(var1);
                }
            }
        }

        this.cd.a(class_324.m);
        this.cc.a();
        this.cd.b(class_324.m);
        OrderableUnit.g(var1);
        class_113.s(var1);
        class_113.a(var1, 0);
        ++this.j;
        if (this.j >= 1000) {
            this.j = 0;
            var13 = 0;
            Iterator var14 = Unit.bF().iterator();

            while(var14.hasNext()) {
                Unit var16 = (Unit)var14.next();
                if (var16.bV && !(var16 instanceof Tree)) {
                    ++var13;
                }
            }

            boolean var15 = true;
            if (var13 > 70) {
                class_682 var17 = Unit.bF();
                Iterator var10 = var17.iterator();

                while(var10.hasNext()) {
                    Unit var11 = (Unit)var10.next();
                    if (var11 instanceof Unit && var11.bV && !(var11 instanceof Tree) && var11.bW < (long)(this.by - 30000) && var13 > 70) {
                        var11.a();
                        --var13;
                    }
                }
            }
        }

        this.cd.a(class_324.l);
        PlayerData.f(var1);
        this.cd.b(class_324.l);
        class_990.a(var1);
        this.bR.a(var1);
        this.D.a(var1);
        class_694.a(var1);
        if (this.ce != null) {
            this.ce.c(var1);
        }

        this.cd.a(class_324.o);
        this.bV.a(var1);
        this.cd.b(class_324.o);
        this.cd.a(class_324.n);
        this.bW.a(var1);
        this.cd.b(class_324.n);
        this.bU.b(var1);
        if (this.cg != null) {
            this.cg.b();
        }

        this.stats.b();
    }

    public strictfp void a(class_27 var1, float var2) {
        synchronized(this.ak) {
            this.b(var1, var2);
        }
    }

    public strictfp boolean i() {
        if (this.K == null) {
            this.K = new class_171("assets/shaders/post_base.frag");
        }

        if (this.L == null) {
            this.L = new class_171("assets/shaders/post_displacement.frag");
        }

        this.K.a(this.bO);
        this.L.a(this.bO);
        if (!this.K.g && !this.L.g) {
            return true;
        } else {
            if (!this.M) {
                this.M = true;
                GameEngine.log("setupPostprocessing: failed");
            }

            return false;
        }
    }

    public strictfp void a(class_171 var1) {
        if (this.N != null) {
            throw new RuntimeException("Layer already enabled");
        } else {
            this.N = this.bO;
            this.bO = var1.b;
            this.bO.i();
            this.bO.a(new Rect(0, 0, this.bO.m(), this.bO.n()));
            this.bO.b(var1.f, var1.e);
        }
    }

    public strictfp void b(class_171 var1) {
        if (this.N == null) {
            throw new RuntimeException("Layer not enabled");
        } else {
            this.bO.j();
            this.bO.p();
            this.bO = this.N;
            this.N = null;
            this.bO.b(var1.f, var1.e);
        }
    }

    public strictfp void b(class_27 var1, float var2) {
        if (var1 == null) {
            b("drawAll", "canvas is null, not may not be available yet");
        } else if (!aB) {
            this.bO.a(var1);
            this.bO.a(this.ao.d());
            this.bO.g();
            ++this.bz;
            class_371.G = 0.0F;
            if (this.du) {
                this.bO.b(Color.a(0, 0, 0));
                this.bO.a("Loading..", this.co, this.cp, this.dp);
            } else {
                float var3 = this.cn;
                if (var3 != 1.0F) {
                    this.bO.i();
                    this.bO.a(var3, var3);
                }

                boolean var4 = GameEngine.aA();
                if (var4 && this.h(113) && this.h(44)) {
                    var4 = false;
                }

                if (var4) {
                    boolean var5 = this.i();
                    if (!var5) {
                        var4 = false;
                    }
                }

                if (var4) {
                    this.a(this.K);

                    try {
                        this.bO.b(Color.a(0, 0, 0));
                        this.cd.a(class_324.d);
                        this.c((class_27)null, var2);
                        this.cd.b(class_324.d);
                    } finally {
                        this.b(this.K);
                    }

                    this.K.b();
                    if (!this.L.a()) {
                        this.a(this.L);

                        int var14;
                        try {
                            this.bO.b(Color.a(128, 128, 255));
                            this.R();
                            var14 = this.bR.a(var2, 3);
                            this.bR.l = null;
                        } finally {
                            this.b(this.L);
                        }

                        if (var14 > 0) {
                            float var6 = this.bO.s();
                            this.L.d.a("screenBase", this.K.a);
                            this.L.d.b("screenBaseSize", this.K.a);
                            this.L.d.a("u_resolution", this.cl, this.cm);
                            this.L.d.a("u_offsetBy", 0.2F * this.cX);
                            this.L.d.a("u_uiScaling", var6);
                            this.L.b();
                        }
                    }
                } else {
                    this.cd.a(class_324.d);
                    this.c(var1, var2);
                    this.cd.b(class_324.d);
                }

                if (!this.A()) {
                    this.cd.a(class_324.f);
                    this.d(var1, var2);
                    this.cd.b(class_324.f);
                }

                if (this.settingsEngine.showFps && this.cT == 0.0F && !this.cU && !this.cS) {
                    this.bO.a(this.u, 100.0F, 35.0F, this.m);
                }

                if (f != null) {
                    this.bO.a(f, 100.0F, 85.0F, this.m);
                }

                if (!this.aq && (this.bO.d() != null || GameEngine.aW)) {
                    this.bS.c(var2);
                }

                if (!this.A()) {
                    this.bR.a(var2, 4);
                }

                class_113.dE();
                this.bO.h();
                if (var3 != 1.0F) {
                    var1.a();
                }

            }
        }
    }

    public strictfp boolean j() {
        if (!this.settingsEngine.showUnitIcons) {
            return false;
        } else if ((double)this.cX < 0.7 && this.cE >= this.bL.i() - 5.0F && this.cB >= this.bL.j() - 5.0F) {
            return true;
        } else if (C()) {
            return (double)this.cX < 0.1;
        } else if (av()) {
            return (double)this.cX < 0.27;
        } else {
            return (double)this.cX < 0.4;
        }
    }

    public strictfp void b(float var1) {
        boolean var2 = false;
        if (this.cQ.a < 0 || this.cQ.b < 0 || (float)this.cQ.c > this.bL.i() || (float)this.cQ.d > this.bL.j()) {
            var2 = true;
        }

        if (var2) {
            this.bO.b(Color.a(0, 0, 0));
        }

    }

    public strictfp void c(float var1) {
    }

    public strictfp void c(class_27 var1, float var2) {
        if (this.bG) {
            this.cd.a(class_324.h);
            this.X.b();
            this.dw = 0;
            boolean var3 = false;
            GameObject[] var4 = Unit.er.a();
            int var5 = GameObject.er.size();

            for(int var6 = 0; var6 < var5; ++var6) {
                GameObject var7 = var4[var6];
                boolean var8 = var7.el;
                boolean var9 = var7.a((GameEngine)this);
                var7.el = var9;
                if (var8 != var9) {
                    var3 = true;
                }

                if (var9) {
                    this.X.a(var7);
                }
            }

            if (this.W.size() != this.X.size()) {
                var3 = true;
            }

            this.cd.b(class_324.h);
            this.cd.a(class_324.i);
            if (var3) {
                class_686 var12 = this.W;
                this.W = this.X;
                this.X = var12;
            }

            if (!this.j()) {
                Collections.sort(this.W, GameObject.ei);
            }

            this.cd.b(class_324.i);
            this.cd.a(class_324.q);
            this.cd.a(class_324.s);
            this.bO.i();
            this.bO.a(this.cK);
            this.cd.b(class_324.s);
            this.cd.a(class_324.r);
            this.b(var2);
            this.cd.b(class_324.r);
            if (this.settingsEngine.renderFancyWater) {
                if (this.O == null) {
                    this.O = this.bO.a(AssetsID$drawable.water_cloud);
                }

                if (this.P == null) {
                    this.P = this.bO.a(AssetsID$drawable.water_layer1);
                }

                if (this.Q == null) {
                    this.Q = this.bO.a(AssetsID$drawable.water_layer2);
                }

                this.S.a(this.cK);
                this.R += 0.05F * var2;
                if (this.R > 100.0F) {
                    this.R -= 100.0F;
                }

                this.bO.a(this.O, this.S, (Paint)null, this.cu / 6, this.cv / 6, 1, 1);
                this.S.a(this.cL);
                this.T.a(this.cL);
                this.bO.i();
                this.R();
                this.bO.a(this.Q, this.T, (Paint)null, (float)this.cu + this.R, (float)this.cv + this.R, 0, 0);
                this.bO.a(this.P, this.T, (Paint)null, (float)this.cu, (float)this.cv, 0, 0);
                this.bO.j();
            }

            this.cd.a(class_324.t);
            if (this.bL != null && this.ar()) {
                this.bL.d(var2);
            }

            this.cd.b(class_324.t);
            this.R();
            this.bO.a(this.cL);
            boolean var13 = this.j();
            this.bU.c(var2);
            this.cd.b(class_324.q);
            GameObject[] var14 = this.W.a();
            int var15 = this.W.size();
            this.dc = true;
            this.dd = true;
            this.de = true;
            this.df = true;
            this.dg = true;
            if ((double)this.cX < 0.45) {
                this.de = false;
                this.dc = false;
                this.dg = false;
            }

            if ((double)this.cX < 0.3) {
                this.df = false;
                this.dd = false;
            }

            GameObject var10;
            int var16;
            if (!var13) {
                for(var16 = 0; var16 < var15; ++var16) {
                    var10 = var14[var16];
                    if (var10.em == 0) {
                        var10.c(var2);
                    }
                }
            }

            class_990.b(var2);
            this.cd.a(class_324.g);
            this.bR.b(var2);
            this.bR.a(var2, 1);
            this.cd.b(class_324.g);
            this.cd.a(class_324.p);
            if (var13) {
                if (this.bS.q() == 0) {
                    Unit.bI.a(255, 195, 195, 195);
                    Unit.bJ.a(255, 255, 255, 255);
                } else {
                    Unit.bI.a(175, 175, 175, 175);
                    Unit.bJ.a(255, 255, 255, 255);
                }

                for(var16 = 0; var16 < var15; ++var16) {
                    var10 = var14[var16];
                    if (!var10.f(var2)) {
                        var10.c(var2);
                    }
                }

                for(var16 = 0; var16 < var15; ++var16) {
                    var10 = var14[var16];
                    var10.a(var2, true);
                    var10.p(var2);
                }
            } else {
                for(var16 = 0; var16 < var15; ++var16) {
                    var10 = var14[var16];
                    var10.d(var2);
                }

                for(var16 = 0; var16 < var5; ++var16) {
                    var10 = var4[var16];
                    if (!var10.el) {
                        if (!(var10 instanceof Unit)) {
                            continue;
                        }

                        Unit var11 = (Unit)var10;
                        if (!var11.cG || var11.bX != this.playerTeam && !var11.cf()) {
                            continue;
                        }
                    }

                    var10.e(var2);
                    if (!var10.el) {
                        var10.p(var2);
                    }
                }

                for(var16 = 0; var16 < var15; ++var16) {
                    var10 = var14[var16];
                    if (var10.em != 0 && var10.em != 10) {
                        var10.c(var2);
                    }
                }

                for(var16 = 0; var16 < var15; ++var16) {
                    var10 = var14[var16];
                    var10.a(var2, false);
                    var10.p(var2);
                }

                PlayerData.h(var2);
            }

            this.de = true;
            this.df = true;
            this.cd.b(class_324.p);
            this.cd.a(class_324.g);
            this.bR.a(var2, 2);
            this.cd.b(class_324.g);

            for(var16 = 0; var16 < var15; ++var16) {
                var10 = var14[var16];
                if (var10.em == 10) {
                    var10.c(var2);
                }
            }

            this.D.b(var2);
            if (this.ce != null) {
                this.ce.a(var2);
            }

            this.c(var2);
            class_694.b(var2);
            this.cc.c(var2);
            this.cd.a(class_324.e);
            this.bO.j();
            this.cd.b(class_324.e);
        }
    }

    public strictfp void d(class_27 var1, float var2) {
        this.bS.b(var2);
        if (this.ce != null) {
            this.ce.b(var2);
        }

        this.bW.e(var2);
        if (this.settingsEngine.showFps && this.cT == 0.0F) {
            this.cd.c();
        }

        if (this.ch) {
            this.bO.a("Look Mode", this.co, this.cp, this.dp);
        }

        if (this.bm) {
            int var3 = 20;

            for(int var4 = 0; var4 < PlayerData.c; ++var4) {
                PlayerData var5 = PlayerData.getPlayerData(var4);
                if (var5 != null && var5 instanceof class_138) {
                    class_138 var6 = (class_138)var5;
                    this.bO.a(var6.site + "| c:" + var6.credits, 20.0F, (float)var3, this.dn);
                    var3 += 20;
                }
            }
        }

    }

    public strictfp void k() {
        this.cj = this.W();
        this.X();
        this.co = this.cl / 2.0F;
        this.cp = this.cm / 2.0F;
        this.cq = (float)((int)(this.cm / 3.0F));
        if (av()) {
            this.cq = (float)((int)(this.cm / 2.5F));
        }

        float var1 = (float)((int)(this.cl / 3.0F));
        if (this.cq > var1) {
            this.cq = var1;
        }

        int var2 = (int)(250.0F * this.cj);
        this.cq = class_340.b(this.cq, 60.0F, (float)var2);
        float var3 = this.cy + this.cI;
        float var4 = this.cz + this.cJ;
        if (this.cS) {
            this.cF = this.cl;
            this.cG = this.cl;
        } else {
            this.cG = this.cl - this.cq + 1.0F;
            if (InterfaceEngine.bO) {
                this.cF = this.cl;
            } else {
                this.cF = this.cG;
            }
        }

        if (this.cF < 1.0F) {
            this.cF = 1.0F;
        }

        if (this.cG < 1.0F) {
            this.cG = 1.0F;
        }

        if (this.cR != this.cS) {
            if (!this.cS) {
                var3 -= this.cq / 2.0F / this.cX;
            } else {
                var3 += this.cq / 2.0F / this.cX;
            }
        }

        this.cR = this.cS;
        this.cH = this.cm;
        this.cA = this.cF / this.cX;
        this.cB = this.cH / this.cX;
        this.cE = this.cG / this.cX;
        this.cI = this.cA / 2.0F;
        this.cJ = this.cB / 2.0F;
        this.cK.a(0, 0, (int)this.cF, (int)this.cH);
        this.cL.a(0, 0, (int)this.cA + 1, (int)this.cB + 1);
        this.cM.a(0.0F, 0.0F, this.cA + 1.0F, this.cB + 1.0F);
        this.a(var3 - this.cI, var4 - this.cJ);
    }

    public strictfp void b(int var1, int var2) {
        this.a(var1, var2, 1.0F);
    }

    public strictfp void a(int var1, int var2, float var3) {
        this.cl = (float)var1;
        this.cm = (float)var2;
        this.cn = var3;
        this.k();
    }

    public strictfp String l() {
        if (GameEngine.aX) {
            return "com.corrodinggames.rts.java";
        } else if (GameEngine.aY) {
            return "com.corrodinggames.rts.gdx";
        } else if (isModsInSD) {
            return "com.corrodinggames.rts.server";
        } else {
            return this.am == null ? "<null context>" : this.am.h();
        }
    }

    public strictfp String m() {
        if (GameEngine.aX) {
            return "java";
        } else if (GameEngine.aY) {
            return "java-gdx";
        } else if (isModsInSD) {
            return "dedicatedServer";
        } else if (this.am == null) {
            return "<null context>";
        } else {
            try {
                PackageManager var1 = this.am.f();
                String var2 = var1.getInstallerPackageName(this.l());
                return var2;
            } catch (IllegalArgumentException var3) {
                return "IllegalArgumentException: " + var3.getMessage();
            }
        }
    }

    public strictfp boolean n() {
        return this.v().contains("p");
    }

    public strictfp int c(boolean var1) {
        if (!isModsInSD && !var1) {
            try {
                PackageInfo var2 = this.am.f().getPackageInfo(this.am.h(), 0);
                int var3 = var2.versionCode;
                return var3;
            } catch (PackageManager.NameNotFoundException var4) {
                throw new RuntimeException(var4);
            }
        } else {
            return 176;
        }
    }

    public strictfp String o() {
        if (!at()) {
            return null;
        } else {
            try {
                PackageInfo var1 = this.am.f().getPackageInfo(this.am.h(), 64);
                Signature[] var2 = var1.signatures;
                int var3 = var2.length;
                byte var4 = 0;
                if (var4 < var3) {
                    Signature var5 = var2[var4];
                    String var6 = class_340.b(var5.toByteArray());
                    return var6;
                } else {
                    return null;
                }
            } catch (PackageManager.NameNotFoundException var7) {
                throw new RuntimeException(var7);
            }
        }
    }

    public strictfp boolean p() {
        if (!GameEngine.aZ) {
            if (this.q()) {
                return true;
            }

            if (aV) {
                return true;
            }
        }

        return false;
    }

    public strictfp boolean q() {
        return OrderableUnit.class.getSimpleName().equals("OrderableUnit");
    }

    public strictfp String r() {
        String var1 = this.t();
        if ("" != null && !"".equals("")) {
            var1 = var1 + "-";
        }

        return var1;
    }

    public strictfp void s() {
        a = null;
        this.t();
    }

    public strictfp String t() {
        if (a != null) {
            return a;
        } else {
            String var1 = "v" + this.u();
            if (GameEngine.as && !aV) {
                if (GameEngine.at) {
                    var1 = "TESTING BUILD - " + var1;
                } else if (var1.contains("p")) {
                    var1 = "BETA VERSION - " + var1;
                }
            } else {
                var1 = "DEBUG BUILD - " + var1;
            }

            if (!GameEngine.aZ && this.q()) {
                var1 = "RAW - " + var1;
            }

            a = var1;
            return a;
        }
    }

    public strictfp String u() {
        return "1.15";
    }

    public strictfp String v() {
        return "1.15";
    }

    public strictfp synchronized void w() {
        this.ac = false;
        if (this.ab != null) {
            this.ab.cancel();
            this.ab = null;
        }

    }

    public strictfp synchronized void a(Activity var1, class_0 var2, boolean var3) {
        synchronized(this.ad) {
            if (!isModsInSD) {
                var2.a();
            }

            this.an = var1;
            this.aq = var3;
            this.cS = this.aq;
            if (var3 && !this.bG && !this.bI && !GameEngine.ay && !this.netEngine.B) {
                this.x();
            }

            class_0 var5 = this.ap;
            if (this.ao == null) {
                this.ao = var2;
            }

            this.ap = var2;
            if (var5 != null && var5 != var2) {
                var5.j();
            }

            if (var2 != null) {
                var2.m();
            }

            if (this.bS != null) {
                this.bS.e();
            }

            this.w();
            this.J();
        }
    }

    public strictfp synchronized void x() {
        if (this.ae <= 20) {
            boolean var1 = true;
            int var2 = this.settingsEngine.nextBackgroundMap++;
            if (this.settingsEngine.nextBackgroundMap > 3) {
                this.settingsEngine.nextBackgroundMap = 1;
            }

            this.settingsEngine.save();
            var2 = class_340.b(var2, 1, 3);
            this.dm = null;
            this.dl = "maps/menu_background/menu" + var2 + ".tmx";

            try {
                PlayerData.b(10, true);
            } catch (Exception var5) {
                throw new RuntimeException(var5);
            }

            for(int var3 = 0; var3 < PlayerData.c; ++var3) {
                class_138 var4 = new class_138(var3);
                if (var3 == 0) {
                    this.playerTeam = var4;
                }
            }

            this.a(false, class_337.MENU);
            this.bH = true;
            this.bS.y();
            if (!this.bG) {
                GameEngine.warn("Menu load failed");
                ++this.ae;
            }

        }
    }

    strictfp void d(float var1) {
        if (this.aq && !this.bH) {
            if (this.ag == null) {
                this.ag = this.y();
                if (this.af == this.ag) {
                    this.ag = null;
                }
            }

            if (this.af == null) {
                this.af = this.ag;
                this.ag = null;
            }

            if (this.ah != 0.0F && this.ag != null) {
                this.a(var1, this.ag.xCord, this.ag.yCord, this.ah * 0.5F);
            }

            if (this.af != null) {
                boolean var2 = this.a(var1, this.af.xCord, this.af.yCord, (1.0F - this.ah) * 0.5F);
                float var3 = class_340.a(this.cy + this.cI, this.cz + this.cJ, this.af.xCord, this.af.yCord);
                if (var3 < 6400.0F) {
                    var2 = true;
                }

                if (var2) {
                    this.ai = true;
                }
            }

            if (this.ai) {
                this.ah += 0.01F * var1;
                if (this.ah >= 1.0F) {
                    this.ah = 0.0F;
                    this.af = null;
                    this.ai = false;
                }
            }
        }

    }

    strictfp Unit a(PlayerData var1) {
        int var2 = 0;
        Iterator var3 = Unit.bE.iterator();

        while(true) {
            Unit var4;
            do {
                do {
                    if (!var3.hasNext()) {
                        if (var2 > 0) {
                            int var7 = class_340.rand(0, var2 - 1);
                            int var8 = 0;
                            Iterator var5 = Unit.bE.iterator();

                            while(true) {
                                Unit var6;
                                do {
                                    do {
                                        if (!var5.hasNext()) {
                                            return null;
                                        }

                                        var6 = (Unit)var5.next();
                                    } while(var6.u());
                                } while(var6.bX != var1 && var1 != null);

                                if (var8 == var7) {
                                    return var6;
                                }

                                ++var8;
                            }
                        }

                        return null;
                    }

                    var4 = (Unit)var3.next();
                } while(var4.u());
            } while(var4.bX != var1 && var1 != null);

            ++var2;
        }
    }

    strictfp Unit y() {
        Unit var1 = this.a(this.playerTeam);
        return var1 != null ? var1 : this.a((PlayerData)null);
    }

    public strictfp boolean a(float var1, float var2, float var3, float var4) {
        float var5 = class_340.d(this.cy + this.cI, this.cz + this.cJ, var2, var3);
        float var6 = class_340.a(this.cy + this.cI, this.cz + this.cJ, var2, var3);
        float var7 = var4 * var1;
        float var8 = 15.0F;
        if (var8 < var7 + 1.0F) {
            var8 = var7 + 1.0F;
        }

        if (!(var6 < var8 * var8) && !this.ct) {
            this.cC += class_340.k(var5) * var7;
            this.cD += class_340.j(var5) * var7;
            if (class_340.c(this.cC) >= 1.0F || class_340.c(this.cD) >= 1.0F) {
                this.cy += this.cC;
                this.cz += this.cD;
                this.cC = 0.0F;
                this.cD = 0.0F;
                this.a(this.cy, this.cz);
            }

            return false;
        } else {
            return true;
        }
    }

    public strictfp int z() {
        return this.d;
    }
}
