package com.corrodinggames.rts.gameFramework.net;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.util.Log;
import com.corrodinggames.rts.AssetsID$drawable;
import com.corrodinggames.rts.appFramework.class_193;
import com.corrodinggames.rts.appFramework.class_0;
import com.corrodinggames.rts.appFramework.class_195;
import com.corrodinggames.rts.appFramework.class_196;
import com.corrodinggames.rts.appFramework.class_200;
import com.corrodinggames.rts.appFramework.class_208;
import com.corrodinggames.rts.game.Player;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.a.class_138;
import com.corrodinggames.rts.game.maps.class_484;
import com.corrodinggames.rts.game.units.custom.UnitException;
import com.corrodinggames.rts.game.units.custom.class_436;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.SyncPacket;
import com.corrodinggames.rts.gameFramework.Unit;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.e.class_697;
import com.corrodinggames.rts.gameFramework.f.a.class_177;
import com.corrodinggames.rts.gameFramework.h.class_1009;
import com.corrodinggames.rts.gameFramework.i.class_800;
import com.corrodinggames.rts.gameFramework.steam.SteamEngine;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Locale;
import java.util.Timer;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

import lombok.SneakyThrows;
import net.rudp.ReliableSocket;

public final strictfp class GameNetEngine {
    public static final boolean a = false;
    public static boolean b = true;
    public static boolean c = false;
    public NetworkCallbacks d = new NetworkCallbacks();
    public int e;
    ArrayList f;
    public boolean debug;
    public int h = 25;
    public boolean i;
    public float j;
    public float k;
    public boolean l = false;
    public int port;
    public String passwd;
    public boolean useMods;
    public boolean p;
    public boolean publicRoom;
    public static boolean r = true;
    public boolean s;
    public int t = 5005;
    public String u;
    public boolean v = false;
    public long w = 1L;
    public boolean x = false;
    public String y;
    private boolean bG;
    public PlayerData z;
    public boolean A;
    private boolean bH = false;
    public volatile boolean B = false;
    public boolean isServer;
    public boolean D;
    public String E;
    public boolean F = false;
    public boolean G;
    public boolean H;
    public int I = 0;
    private volatile float currentStepRate = 1.0F;
    public volatile float J = 1.0F;
    public Float K;
    public String L;
    public ArrayList M = new ArrayList();
    public boolean N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public String S;
    public int T = -1;
    public int U = -1;
    public int V = -1;
    public int W = class_340.rand(1, 9000000);
    public int loaclTick = 0;
    public boolean Y;
    public float Z;
    boolean aa;
    public float ab;
    public float ac;
    public boolean ad;
    public float ae;
    public boolean af;
    public boolean ag;
    public int ah = -1;
    public int ai = 300;
    public boolean aj;
    public boolean ak;
    public boolean al;
    public CheckSumData checkSumData = new CheckSumData();
    public boolean an;
    public boolean ao = true;
    public int ap;
    public int aq;
    public int ar;
    public static boolean as;
    float at = 0.0F;
    long au;
    public boolean av;
    public int aw = 5;
    public int ax = 5;
    public GameMapData gameMapData = new GameMapData();
    public String az = null;
    public GameInputStream aA;
    public GameInputStream aB;
    public class_204 aC = new class_204();
    Thread tcpThread;
    ServerAcceptRunnable tcpAccept;
    Thread udpThread;
    ServerAcceptRunnable udpAccept;
    Timer PingTaskTimer;
    PingTask pingTask;
    Thread aJ;
    class_981 aK;
    PlayerConnect aL;
    public ConcurrentLinkedQueue socketList = new ConcurrentLinkedQueue();
    ConcurrentLinkedQueue aN = new ConcurrentLinkedQueue();
    boolean aO;
    volatile int connectIndex = 1;
    Object indexSync = new Object();
    String aR;
    String aS;
    public String aT;
    public Boolean aU;
    public Boolean aV;
    public boolean ingame;
    public boolean aX = false;
    boolean aY = false;
    boolean aZ = false;
    public float ba;
    public boolean bb;
    public boolean bc;
    public boolean bd;
    public boolean be;
    public boolean bf;
    public String bg;
    public String bh = null;
    public ConcurrentLinkedQueue bi = new ConcurrentLinkedQueue();
    public Player bj;
    public Player bk;
    public final Object bl = new Object();
    public boolean bm = false;
    float playerTick;
    float bo;
    int bp;
    int lastSyncTick;
    boolean br = false;
    public long bs;
    public long bt;
    boolean bu = false;
    public Socket bv = null;
    public String bw = null;
    public boolean bx;
    boolean by = false;
    boolean bz = false;
    static ArrayList bA;
    boolean bB = false;
    final Object bC = new Object();
    Timer bD;
    public static EnterPasswordCallback bE = new EnterPasswordCallback();
    class_1016 bF;

    public strictfp class_983 a(PlayerConnect var1) {
        String var2 = var1.f();
        long var3 = System.currentTimeMillis();
        if (var2 == null) {
            var1.b("Is banned: No target");
            return null;
        } else {
            synchronized(this.M) {
                Iterator var6 = this.M.iterator();

                class_983 var7;
                do {
                    if (!var6.hasNext()) {
                        return null;
                    }

                    var7 = (class_983)var6.next();
                } while(!var2.equals(var7.a) || var7.b <= var3);

                return var7;
            }
        }
    }

    public strictfp boolean a(PlayerConnect var1, String var2, int var3) {
        if (var1 == null) {
            GameEngine.print("Ban failed: No connection");
            return false;
        } else {
            String var4 = var1.f();
            if (var4 == null) {
                var1.b("Ban failed: No target");
                return false;
            } else {
                class_983 var5 = new class_983();
                var5.a = var1.f();
                var5.b = System.currentTimeMillis() + (long)(var3 * 1000);
                var5.c = var2;
                synchronized(this.M) {
                    this.b();
                    this.M.add(var5);
                }

                var1.c("Banned " + var4 + " for " + var3 + "s");
                return true;
            }
        }
    }

    public strictfp void a() {
        synchronized(this.M) {
            this.M.clear();
        }
    }

    public strictfp void b() {
        synchronized(this.M) {
            int var2 = 0;
            long var3 = System.currentTimeMillis();
            Iterator var5 = this.M.iterator();

            while(var5.hasNext()) {
                ++var2;
                class_983 var6 = (class_983)var5.next();
                boolean var7 = false;
                if (var6.b < var3) {
                    var7 = true;
                }

                if (var2 > 1000) {
                    var7 = true;
                }

                if (var7) {
                    var5.remove();
                }
            }

        }
    }

    public strictfp String a(String var1) {
        var1 = var1.trim();
        var1 = var1.replace(" ", "_");
        this.y = var1;
        GameEngine var2 = GameEngine.getGameEngine();
        if (this.y != null && !this.y.equals(var2.settingsEngine.lastNetworkPlayerName)) {
            var2.settingsEngine.lastNetworkPlayerName = this.y;
            var2.settingsEngine.save();
        }

        return var1;
    }

    public strictfp void setCurrentStepRate(float var1, String var2) {
        if ((double)var1 < 0.1) {
            a("setCurrentStepRate:" + var1 + " is too small, source:" + var2, true);
        } else {
            this.currentStepRate = var1;
        }
    }

    public strictfp float getCurrentStepRate() {
        return this.currentStepRate;
    }

    public strictfp void d() {
        GameEngine var1 = GameEngine.getGameEngine();
        this.ah = var1.tick;
        this.checkSumData.b();
        this.an = false;
    }

    public strictfp void a(GameOutputStream var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        var1.writeByte(0);
        this.gameMapData.a(var1);
        var1.writeInt(var2.bB);
        var1.writeInt(var2.bC);
    }

    public strictfp void a(GameInputStream var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        var1.readByte();
        this.gameMapData.a(var1);
        var2.bB = var1.readInt();
        var2.bC = var1.readInt();
    }

    public strictfp GameMapData e() {
        GameMapData var1;
        if (this.isServer) {
            var1 = this.gameMapData;
        } else if (this.H) {
            var1 = this.gameMapData.c();
        } else {
            var1 = null;
            GameEngine.b("getChangeableSetup", "Clicked but not server or proxy controller");
        }

        return var1;
    }

    public strictfp void f() {
        if (this.F) {
            GameEngine.getGameEngine().settingsEngine.aiDifficulty = this.gameMapData.aidiff;
        }

        if (this.isServer || this.F) {
            if (this.ingame) {
                GameEngine.warn("updateAIDifficulty with gameHasBeenStarted=true");
            } else {
                for(int var1 = 0; var1 < PlayerData.c; ++var1) {
                    PlayerData var2 = PlayerData.getPlayerData(var1);
                    if (var2 != null) {
                        this.a(var2);
                    }
                }
            }

            this.aq();
        }
    }

    public strictfp void a(PlayerData var1) {
        if (var1.w) {
            var1.c("aiDifficultyOverride=" + var1.aiDifficulty);
            if (var1.aiDifficulty != null) {
                var1.x = var1.aiDifficulty;
            } else {
                var1.x = this.gameMapData.aidiff;
            }
        }

    }

    public strictfp boolean b(PlayerData var1) {
        boolean var2 = false;
        if (var1.w) {
            String var3 = "AI - " + this.b(var1.C());
            if (!var3.equals(var1.name)) {
                var1.name = var3;
                var2 = true;
            }
        }

        return var2;
    }

    public strictfp void a(GameMapData var1) {
        if (this.isServer) {
            this.f();
            this.P();
            this.L();
            class_195.o();
        } else if (this.H) {
            this.b(var1);
        } else {
            GameEngine.log("applyChangedSetup but not server or proxy controller");
        }

    }

    private strictfp void b(GameMapData var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        GameEngine.log("applyProxyControl");
        GameMapData var3 = this.gameMapData;
        String var4;
        if (!var3.mapName.equals(var1.mapName)) {
            var4 = class_200.e(var1.mapName);
            var4 = class_697.o(var4);
            var2.netEngine.k("-map '" + var4 + "'");
        }

        if (var3.e != var1.e) {
            var4 = !var1.e ? "true" : "false";
            var2.netEngine.k("-revealedmap " + var4);
        }

        if (var3.fog != var1.fog) {
            var4 = var2.netEngine.a(var1.fog);
            var2.netEngine.k("-fog " + var4);
        }

        if (var3.credits != var1.credits) {
            int var5 = var2.netEngine.e(var1.credits);
            var2.netEngine.k("-credits " + var5);
        }

        if (!class_340.k(var3.income, var1.income)) {
            var2.netEngine.k("-income " + class_340.a(var1.income, 1));
        }

        if (var3.nukes != var1.nukes) {
            var4 = !var1.nukes ? "true" : "false";
            var2.netEngine.k("-nukes " + var4);
        }

        if (var3.aidiff != var1.aidiff) {
            var2.netEngine.k("-ai " + var1.aidiff);
        }

        if (var3.initUnit != var1.initUnit) {
            var2.netEngine.k("-startingunits " + var1.initUnit);
        }

        if (var3.sharedControl != var1.sharedControl) {
            var4 = var1.sharedControl ? "true" : "false";
            var2.netEngine.k("-sharedControl " + var4);
        }

    }

    public strictfp String g() {
        if (this.gameMapData.fog == 0) {
            return "No fog";
        } else if (this.gameMapData.fog == 1) {
            return "Basic fog";
        } else {
            return this.gameMapData.fog == 2 ? "Line of Sight" : "Unknown";
        }
    }

    public strictfp String a(int var1) {
        if (var1 == 0) {
            return "off";
        } else if (var1 == 1) {
            return "basic";
        } else {
            return var1 == 2 ? "los" : "Unknown";
        }
    }

    public strictfp String b(int var1) {
        return this.c(var1);
    }

    public strictfp String c(int var1) {
        if (var1 == -2) {
            return "Very Easy";
        } else if (var1 == -1) {
            return "Easy";
        } else if (var1 == 0) {
            return "Medium";
        } else if (var1 == 1) {
            return "Hard";
        } else if (var1 == 2) {
            return "Very Hard";
        } else {
            return var1 == 3 ? "Impossible" : "Unknown";
        }
    }

    public strictfp String h() {
        return this.d(this.gameMapData.initUnit);
    }

    public strictfp ArrayList i() {
        ArrayList var1 = new ArrayList();

        for(int var2 = 1; var2 <= 4; ++var2) {
            var1.add(var2);
        }

        var1.addAll(class_591.s());
        return var1;
    }

    public strictfp String d(int var1) {
        if (var1 == 1) {
            return "Normal (1 builder)";
        } else if (var1 == 2) {
            return "Small Army";
        } else if (var1 == 3) {
            return "3 Engineers";
        } else if (var1 == 4) {
            return "3 Engineers (No Command Center)";
        } else if (var1 == 5) {
            return "Experimental Spider";
        } else if (var1 == 9) {
            return "Custom";
        } else {
            class_591 var2 = class_591.c(var1);
            return var2 != null ? var2.e() : "Unknown";
        }
    }

    public strictfp String j() {
        return this.gameMapData.credits == 0 ? "Default ($" + this.k() + ")" : "$" + this.k();
    }

    public final strictfp int k() {
        return this.e(this.gameMapData.credits);
    }

    public strictfp int e(int var1) {
        if (var1 == 0) {
            return 4000;
        } else if (var1 == 1) {
            return 0;
        } else if (var1 == 2) {
            return 1000;
        } else if (var1 == 3) {
            return 2000;
        } else if (var1 == 4) {
            return 5000;
        } else if (var1 == 5) {
            return 10000;
        } else if (var1 == 6) {
            return 50000;
        } else if (var1 == 7) {
            return 100000;
        } else {
            return var1 == 8 ? 200000 : 999;
        }
    }

    public strictfp String l() {
        return class_697.o(this.az);
    }

    public strictfp void m() {
        new class_684();
        class_340.b(256);
        APIEncryption.a(5.0F, 6.0F, 7.0F);
        class_1017.a(5);
        this.bg = class_1017.a();
        this.bf = true;
    }

    public strictfp boolean n() {
        return this.ingame;
    }

    public strictfp boolean o() {
        return this.d.e();
    }

    public strictfp synchronized void a(boolean var1, String var2, Boolean var3) {
        this.aV = var1;
        this.aT = var2;
        this.aU = var3;
        class_195.o();
    }

    strictfp void a(ListRoomInfo var1) {
        Iterator var2 = this.bi.iterator();

        while(var2.hasNext()) {
            ListRoomInfo var3 = (ListRoomInfo)var2.next();
            if (var3.a && var3.c.equals(var1.c) && var3.g == var1.g) {
                var3.o = this.p();
            }
        }

        var1.o = this.p();
        this.bi.add(var1);
        class_196.l();
    }

    public strictfp long p() {
        return System.currentTimeMillis();
    }

    public GameNetEngine() {
        GameEngine var1 = GameEngine.getGameEngine();
        this.e = var1.c(true);
        this.aR = class_340.e(40);
        this.aL = new PlayerConnect(this, (Socket)null);
        this.aL.p = true;
        this.bj = new Player(-3, false);
        this.bj.name = "SPECTATOR";
        this.bk = new Player(-1, false);
        this.bk.name = "ADMIN";
    }

    public strictfp void q() {
        this.a(false);
    }

    public strictfp void r() {
        this.a(true);
    }

    public strictfp void s() {
        this.bH = false;
        this.bG = false;
        this.z = null;
        this.p = false;
        this.bs = System.currentTimeMillis();
        this.loaclTick = 0;
        this.I = 0;
        this.w = 1L;
        this.setCurrentStepRate(1.0F, "new");
        this.Z = 10.0F;
        this.N = false;
        this.Q = 10;
        this.R = 0;
        this.Y = false;
        this.aa = false;
        this.al = false;
        this.ak = false;
        this.ab = 0.0F;
        this.ac = 0.0F;
        this.ad = false;
        this.af = false;
        this.ingame = false;
        this.aY = false;
        this.aZ = false;
        this.ba = 0.0F;
        this.aX = false;
        this.bb = false;
        this.bc = false;
        this.bd = false;
        this.be = false;
        this.ag = false;
        this.ah = -1;
        this.checkSumData.allSum = 0L;
        this.br = false;
        this.checkSumData.a();
        this.an = false;
        this.ao = true;
        this.ap = 0;
        this.aq = 0;
        this.ar = 0;
        this.at = 0.0F;
        this.playerTick = 0.0F;
        this.bo = 0.0F;
        this.bp = 0;
        this.lastSyncTick = -1000;
        APIEncryption.i = 55;
        APIEncryption.j = 66;
    }

    public strictfp void a(boolean var1) {
        this.B = false;
        this.isServer = false;
        this.f = null;
        this.F = false;
        this.D = false;
        this.E = null;
        this.x = false;
        this.H = false;
        this.G = false;
        this.av = false;
        this.A = false;
        this.s();
        this.S = null;
        this.port = 0;
        this.i = false;
        this.j = 0.0F;
        this.k = 0.0F;
        this.bz = false;
        this.aB = null;
        this.ax = GameEngine.getGameEngine().settingsEngine.teamUnitCapHostedGame;
        if (this.ax < 1) {
            this.ax = 1;
        }

        this.aw = this.ax;
        this.gameMapData.initUnit = 1;
        this.gameMapData.income = 1.0F;
        this.gameMapData.nukes = false;
        this.gameMapData.j = false;
        this.gameMapData.sharedControl = false;
        this.gameMapData.credits = 0;
        this.gameMapData.m = false;
        this.gameMapData.n = false;
        this.gameMapData.spectators = true;
        this.gameMapData.p = false;
        this.gameMapData.q = 0;
        this.a();
        this.aC.c();
        GameEngine.getGameEngine().bS.g();
        if ("<CHAT ONLY>".equals(this.gameMapData.mapName)) {
            GameEngine.log("Chat only map selection - restarting");
            this.gameMapData.a();
        }

        if (!var1) {
            PlayerData.F();
        }

        String var2 = class_436.b(this.useMods);
    }

    public strictfp void t() {
    }

    public strictfp synchronized void closeServer(String var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        GameEngine.log("Disconnect: " + var1);
        if (this.isServer) {
            this.ar();
            GameNetAPIOperate.d();
            if (this.tcpAccept != null) {
                this.tcpAccept.b();

                try {
                    if (this.tcpThread != null) {
                        this.tcpThread.join();
                    }
                } catch (InterruptedException var9) {
                }

                this.tcpAccept = null;
                this.tcpThread = null;
            }

            if (this.udpAccept != null) {
                this.udpAccept.b();

                try {
                    if (this.udpThread != null) {
                        this.udpThread.join();
                    }
                } catch (InterruptedException var8) {
                }

                this.udpAccept = null;
                this.udpThread = null;
            }

            if (this.PingTaskTimer != null) {
                this.PingTaskTimer.cancel();
                this.PingTaskTimer = null;
                this.pingTask = null;
            }

            if (this.aK != null) {
                this.aK.b();
                this.aK = null;
                this.aJ = null;
            }
        }

        this.q(var1);
        SteamEngine.getSteamEngine().j();
        synchronized(this.bl) {
            this.B = false;
            this.isServer = false;
            this.F = false;
            this.f = null;

            try {
                this.wait(50L);
            } catch (InterruptedException var6) {
                var6.printStackTrace();
            }

            this.ingame = false;
            var2.replayEngine.close();
            var2.e();
            this.am();
            this.bm = false;
            this.bl.notifyAll();
        }
    }

    public strictfp void u() {
        synchronized(this.bl) {
            if (this.B) {
                this.bm = true;

                try {
                    this.bl.wait();
                } catch (InterruptedException var4) {
                    var4.printStackTrace();
                }

            }
        }
    }

    public strictfp void b(PlayerConnect var1) {
        this.socketList.remove(var1);
    }

    private strictfp synchronized void ay() {
        Iterator var1 = this.socketList.iterator();

        while(var1.hasNext()) {
            PlayerConnect var2 = (PlayerConnect)var1.next();
            if (var2.a) {
                var1.remove();
            }
        }

    }

    strictfp void updateDeSync(byte[] var1, PlayerConnect var2) {
        if (!GameEngine.ax()) {
            Log.d("RustedWarfare", "Ignoring incoming resync tagged as debug only");
        } else {
            if (var2.u) {
                Log.d("RustedWarfare", "Ignoring desync client save, as past desync was already saved");
                return;
            }

            var2.u = true;
            Log.d("RustedWarfare", "Saving client save for debugging");
            String var3 = "desyncs/";
            String var4 = "desync_" + class_340.a("d MMM yyyy HH.mm.ss") + "_" + var2.connectIndex;
            File var5 = new File(var3 + var4);
            var5.getParentFile().mkdirs();

            try {
                FileOutputStream var6 = new FileOutputStream(var5);
                var6.write(var1);
                var6.close();
            } catch (IOException var8) {
                var8.printStackTrace();
            }
        }

    }

    public strictfp void fasySync() {
        if (!this.br) {
            GameEngine.log("Adding quick resync command");
            GameEngine var1 = GameEngine.getGameEngine();
            SyncPacket var2 = var1.cf.b();
            var2.i = PlayerData.i;
            var2.r = true;
            var2.u = 200;
            var1.netEngine.a(var2);
            this.br = true;
        }
    }

    public strictfp void w() {
        GameEngine var1 = GameEngine.getGameEngine();
        GameOutputStream var2 = new GameOutputStream();

        try {
            var1.ca.a(var2);
        } catch (Exception var10) {
            throw new RuntimeException(var10);
        }

        try {
            var2.flashAll();
        } catch (Exception var9) {
            var9.printStackTrace();
        }

        byte[] var3 = var2.toByteArray();
        var2.h();
        if (this.isServer) {
            Iterator var4 = this.socketList.iterator();

            while(var4.hasNext()) {
                PlayerConnect var5 = (PlayerConnect)var4.next();
                if (var5.fastSyncFlag) {
                    var5.fastSyncFlag = false;
                    var5.desyncCountFlag = false;
                    this.a(var5, var3, this.l, false);
                }
            }
        }

        GameEngine.log("Loading quick resync save data (bytes:" + var3.length + ")");
        GameInputStream var11 = new GameInputStream(var3);
        var1.a("Game resync (quick)...", true);
        int var12 = var1.tick;
        int var6 = var1.by;
        var1.ca.a(var11, true, true, true);
        var1.tick = var12;
        var1.by = var6;
        this.loaclTick = var1.tick + 1;
        this.ag = false;
        this.ah = this.loaclTick + 1;
        this.checkSumData.allSum = 0L;

        PlayerConnect var8;
        for(Iterator var7 = this.socketList.iterator(); var7.hasNext(); var8.desyncCountFlag = false) {
            var8 = (PlayerConnect)var7.next();
        }

        this.br = false;
        ++this.ar;
        this.playerTick = 0.0F;
        this.bo = 0.0F;
        if (this.bp < 1) {
            ++this.bp;
        }

        this.lastSyncTick = var1.tick;
    }

    public strictfp synchronized void x() {
        Iterator var1 = this.socketList.iterator();

        PlayerConnect var2;
        do {
            if (!var1.hasNext()) {
                return;
            }

            var2 = (PlayerConnect)var1.next();
            if (var2.fastSyncFlag) {
                throw new RuntimeException("Player: " + var2.getName() + " has complete desync");
            }

            if (var2.desyncCountFlag) {
                throw new RuntimeException("Player: " + var2.getName() + " has minor desync");
            }
        } while(var2.x != 0);

        throw new RuntimeException("Player: " + var2.getName() + " has no sync matches");
    }

    private strictfp synchronized void e(float var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        boolean var3 = false;
        boolean var4 = false;
        boolean var5 = false;
        this.playerTick += var1;
        Iterator var6 = this.socketList.iterator();

        while(var6.hasNext()) {
            PlayerConnect var7 = (PlayerConnect)var6.next();
            if (var7.fastSyncFlag) {
                var3 = true;
            }

            if (var7.desyncCountFlag) {
                if (this.debug) {
                    GameEngine.log("desync_count:" + var7.desyncCount + " lastResyncTimer:" + this.playerTick);
                }

                if (var7.desyncCount < 4 || this.playerTick > 3600.0F) {
                    var5 = true;
                }
            }
        }

        if (var5) {
            this.bo += var1;
            if (c && this.bo > 5.0F) {
                var4 = true;
            }

            if (this.bp == 0) {
                if (this.bo > 60.0F) {
                    var4 = true;
                }
            } else if (this.bp == 1) {
                if (this.bo > 420.0F) {
                    var4 = true;
                }
            } else if (this.bp == 2) {
                if (this.bo > 3600.0F) {
                    var4 = true;
                }
            } else if (this.bp == 3 && this.bo > 14400.0F) {
                var4 = true;
            }
        }

        if (as && var4) {
            GameEngine.log("disableDesyncFixing==true, running quick resync instead");
            var4 = false;
            var3 = true;
        }

        if (!var4 && var3) {
            if (b) {
                this.fasySync();
            } else {
                var4 = true;
            }
        }

        if (var4) {
            String var9 = "";
            Iterator var10 = this.socketList.iterator();

            while(true) {
                PlayerConnect var8;
                do {
                    if (!var10.hasNext()) {
                        this.j("Resyncing game for " + var9 + "...");
                        this.az();
                        this.resync(this.l, false, true);
                        return;
                    }

                    var8 = (PlayerConnect)var10.next();
                } while(!var8.fastSyncFlag && !var8.desyncCountFlag);

                if (!var9.equals("")) {
                    var9 = var9 + ", ";
                }

                var9 = var9 + var8.getName();
            }
        }
    }

    private strictfp void az() {
        GameEngine var1 = GameEngine.getGameEngine();
        this.playerTick = 0.0F;
        this.bo = 0.0F;
        ++this.bp;
        this.lastSyncTick = var1.tick;

        PlayerConnect var3;
        for(Iterator var2 = this.socketList.iterator(); var2.hasNext(); var3.x = 0) {
            var3 = (PlayerConnect)var2.next();
            var3.fastSyncFlag = false;
            var3.desyncCountFlag = false;
        }

    }

    public strictfp void c(String var1) {
        this.q(var1);
    }

    private strictfp void q(String var1) {
        Iterator var2 = this.socketList.iterator();

        while(var2.hasNext()) {
            PlayerConnect var3 = (PlayerConnect)var2.next();
            var3.a(var1);
        }

        this.socketList.clear();
        this.aN.clear();
        this.connectIndex = 1;
        this.aO = false;
    }

    public strictfp long y() {
        boolean var1 = false;
        if (var1) {
            GameEngine.log("New id set:" + this.w + 1);
            GameEngine.T();
        }

        long var2 = (long)(this.w++);
        if (var2 == 0L) {
            GameEngine.log("getNextUnitId: id==0");
            GameEngine.T();
        }

        return var2;
    }

    public strictfp long z() {
        return this.w;
    }

    public strictfp void a(long var1) {
        this.w = var1;
    }

    public strictfp boolean a(boolean var1, int var2) {
        Iterator var3 = this.socketList.iterator();

        PlayerConnect var4;
        do {
            if (!var3.hasNext()) {
                return true;
            }

            var4 = (PlayerConnect)var3.next();
        } while(!var4.p || !var4.h() || var4.s || var4.D);

        if (var1) {
            this.j("Still waiting on: " + var4.getName());
        }

        return false;
    }

    public strictfp void A() {
        PlayerConnect var2;
        for(Iterator var1 = this.socketList.iterator(); var1.hasNext(); var2.D = false) {
            var2 = (PlayerConnect)var1.next();
            var2.C = false;
        }

    }

    public strictfp int B() {
        int var1 = 0;
        Iterator var2 = this.socketList.iterator();

        while(var2.hasNext()) {
            PlayerConnect var3 = (PlayerConnect)var2.next();
            if (var3.p && var3.h() && !var3.s) {
                ++var1;
            }
        }

        return var1;
    }

    public strictfp int C() {
        ArrayList var1 = new ArrayList();
        int var2 = 0;
        Iterator var3 = this.socketList.iterator();

        while(true) {
            while(true) {
                PlayerConnect var4;
                do {
                    do {
                        do {
                            if (!var3.hasNext()) {
                                return var2;
                            }

                            var4 = (PlayerConnect)var3.next();
                        } while(!var4.p);
                    } while(!var4.h());
                } while(var4.s);

                Player var5 = var4.player;
                if (var5 == null) {
                    break;
                }

                if (!var1.contains(var5)) {
                    var1.add(var5);
                    break;
                }
            }

            ++var2;
        }
    }

    public strictfp int D() {
        int var1 = 0;
        Iterator var2 = this.socketList.iterator();

        while(var2.hasNext()) {
            PlayerConnect var3 = (PlayerConnect)var2.next();
            if (var3.p && !var3.s) {
                ++var1;
            }
        }

        return var1;
    }

    public strictfp int E() {
        int var1 = 0;
        var1 += this.C();
        if (!GameEngine.ax()) {
            ++var1;
        }

        return var1;
    }

    public strictfp void printLog(String var1) {
        Log.b("RustedWarfare", "network:" + var1);
    }

    public static strictfp void e(String var0) {
        GameEngine.log("network debug: " + var0);
    }

    public strictfp void f(String var1) {
        Log.d("RustedWarfare", "reportProblem:" + var1);
        if (this.ingame) {
            this.b((PlayerConnect)null, -1, (String)null, var1);
        } else {
            this.b((PlayerConnect)null, -1, (String)null, var1);
        }

    }

    public static strictfp void g(String var0) {
        a(var0, false);
    }

    public static strictfp void h(String var0) {
        a(var0, true);
    }

    public static strictfp void a(String var0, boolean var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        GameNetEngine var3 = var2.netEngine;
        String var4 = "desync:" + var0;
        GameEngine.print(var4);
        GameEngine.T();
        ++var3.ap;
        if (var3.ao) {
            if (var3.ap > 2 || as) {
                var1 = true;
            }

            String var5;
            if (var3.ap > 10) {
                var5 = "<suppressing desync errors>";
                var3.ao = false;
                var1 = true;
            } else {
                var5 = var4;
            }

            if (var1) {
                var5 = "-i " + var5;
            }

            var3.m(var5);
        }

    }

    public static strictfp void a(String var0, String var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        var2.replayEngine.a(-1, var0, var1, var2.tick);
        if (var2.bS != null && var2.bS.h != null) {
            var2.bS.h.a(var0, var1);
        } else {
            GameEngine.warn("interfaceEngine/messageInterface==null");
        }

    }

    public strictfp void F() {
    }

    public strictfp void a(SyncPacket var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        var1.localTick = this.loaclTick;
        var1.g();
        var2.cf.commandList.add(var1);
    }

    public strictfp void G() {
        Iterator var1 = this.socketList.iterator();

        while(var1.hasNext()) {
            PlayerConnect var2 = (PlayerConnect)var1.next();
            if (var2.p && var2.b() != -2 && var2.b() <= 500 && var2.b() < 0) {
            }
        }

    }

    public strictfp void H() {
        GameEngine var1 = GameEngine.getGameEngine();
        String var2 = "";
        ArrayList var3 = PlayerData.a(true);
        Iterator var4 = var3.iterator();

        while(var4.hasNext()) {
            PlayerData var5 = (PlayerData)var4.next();
            if (var5 != null) {
                String var6 = "unnamed";
                if (var5.name != null) {
                    var6 = var5.name;
                }

                String var7 = " " + var5.y();
                String var8 = "•";
                var2 = var2 + var8 + var5.N().toLowerCase() + " [Team " + var5.getPlayerTeamName() + "] - " + var6 + var7 + "\n";
            }
        }

        GameEngine.log("showPlayerListPopup(): Showing playlist messagebox.");
        var1.c("Players", var2);
    }

    public strictfp void a(float var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        this.at += var1;
        if (this.aZ) {
            if (this.ba > 0.0F) {
                this.ba -= var1 / 60.0F;
                GameEngine.getGameEngine().bS.a("Returning to battleroom in " + (int)this.ba + "...", 3500);
            } else {
                GameEngine.log("Sending returnToBattleroomEvent...");
                this.aZ = false;
                this.i((PlayerConnect)null);
            }
        }

        if (this.aY) {
            this.aD();
        }

        if (this.at > 60.0F) {
            this.G();
            this.at = 0.0F;
        }

        int var4;
        if (this.ingame && !this.aX) {
            this.aX = true;
            ArrayList var3 = PlayerData.f();
            var4 = 0;
            int var5 = 0;

            for(Iterator var6 = var3.iterator(); var6.hasNext(); ++var4) {
                Integer var7 = (Integer)var6.next();
                int var8 = PlayerData.a(var7, false);
                if (var8 > var5) {
                    var5 = var8;
                }
            }

            if (var4 > 2 && var5 <= 1) {
                this.bb = true;
            }
        }

        if (!this.isServer && !this.bH) {
            this.ad();
            this.bH = true;
        }

        boolean var17;
        if (this.isServer) {
            if (!this.aa && this.ingame) {
                if (this.a(false, 0)) {
                    this.Z = class_340.a(this.Z, var1);
                    if (this.Z == 0.0F) {
                        this.aa = true;
                        a("", "<All players ready>");
                        this.d.a();
                    }
                } else {
                    this.ab += var1;
                    this.ac += var1;
                    float var13 = 900.0F;
                    if (this.ab > var13) {
                        this.aa = true;
                        a("", "Starting game without all players ready!");
                    } else if (this.ac > 180.0F) {
                        this.ac = 0.0F;
                        this.a(true, (int)((var13 - this.ab) / 60.0F));
                    }
                }
            }

            if (this.aa) {
                boolean var14 = false;
                if (this.ak) {
                    var14 = true;
                }

                if (this.al) {
                    var14 = true;
                }

                if (var2.tick >= this.loaclTick - this.R && !var14) {
                    var4 = this.loaclTick + this.Q;
                    ++this.O;
                    var17 = false;

                    for(int var19 = 0; var19 < PlayerData.c; ++var19) {
                        PlayerData var23 = PlayerData.getPlayerData(var19);
                        if (var23 != null && var23.V != 0 && !var23.isTimeOut() && var23.V < 40) {
                            var17 = true;
                        }
                    }

                    if (var2.b() != 0 && var2.b() < 40 && !GameEngine.ax()) {
                        var17 = true;
                    }

                    if (var17) {
                        ++this.P;
                    }

                    if (this.O > 8) {
                        float var21 = 1.0F;
                        if (this.P > 4) {
                            var21 = 2.0F;
                        }

                        if (this.K != null) {
                            var21 = this.K;
                        }

                        if (var21 != this.getCurrentStepRate()) {
                            GameEngine.log("Changing step rate to " + var21);
                            SyncPacket var25 = var2.cf.b();
                            var25.i = PlayerData.i;
                            var25.r = true;
                            var25.s = var21;
                            this.a(var25);
                        }

                        this.O = 0;
                        this.P = 0;
                    }

                    GameOutputStream var27 = new GameOutputStream();

                    try {
                        var27.writeInt(var4);
                        int var26 = 0;
                        Iterator var28 = var2.cf.commandList.iterator();

                        label234:
                        while(true) {
                            SyncPacket var9;
                            if (!var28.hasNext()) {
                                var27.writeInt(var26);
                                var28 = var2.cf.commandList.iterator();

                                while(true) {
                                    if (!var28.hasNext()) {
                                        break label234;
                                    }

                                    var9 = (SyncPacket)var28.next();
                                    if (var9.localTick == this.loaclTick) {
                                        var9.write(var27);
                                    }
                                }
                            }

                            var9 = (SyncPacket)var28.next();
                            if (var9.localTick == this.loaclTick) {
                                ++var26;
                            }
                        }
                    } catch (Exception var12) {
                        throw new RuntimeException(var12);
                    }

                    Packet var30 = var27.getPacket(10);
                    var30.e = true;
                    this.d(var30);
                    this.loaclTick = var4;
                }
            }
        }

        Iterator var15;
        SyncPacket var16;
        if (!var2.cf.d.isEmpty()) {
            var15 = var2.cf.d.iterator();

            while(var15.hasNext()) {
                var16 = (SyncPacket)var15.next();
                var17 = false;
                if (var17) {
                    var2.cf.c.add(var16);
                    var15.remove();
                } else {
                    if (!var16.x) {
                        var16.b();
                    }

                    if (var16.a()) {
                        var2.cf.c.add(var16);
                        var15.remove();
                    }
                }
            }
        }

        if (!this.isServer) {
            if (!var2.cf.c.isEmpty()) {
                var15 = var2.cf.c.iterator();

                while(var15.hasNext()) {
                    var16 = (SyncPacket)var15.next();
                    if (!var16.e()) {
                        var16.j();
                        GameOutputStream var22 = new GameOutputStream();

                        try {
                            var16.write(var22);
                        } catch (Exception var10) {
                            throw new RuntimeException(var10);
                        }

                        this.d(var22.getPacket(20));
                    }
                }

                var2.cf.c.clear();
            }
        } else if (!var2.cf.c.isEmpty()) {
            var15 = var2.cf.c.iterator();

            while(var15.hasNext()) {
                var16 = (SyncPacket)var15.next();
                if (!var16.e()) {
                    if (!var16.l()) {
                        g("Skipped command issued from server");
                    } else {
                        var16.j();
                        this.a(var16);
                    }
                }
            }

            var2.cf.c.clear();
        }

        while(!this.aN.isEmpty()) {
            Packet var18 = (Packet)this.aN.remove();

            try {
                this.resolveSystemCommandPacket(var18);
            } catch (Exception var11) {
                String var24 = "None";
                PlayerConnect var29 = var18.playerConnect;
                if (var29 != null) {
                    var24 = var29.g();
                    String var31 = var11.getMessage();
                    if (var31 == null) {
                        var31 = "IO error";
                    }

                    var29.a(var31);
                    g("IO error on processGamePacket for " + var29.getName());
                }

                GameEngine.a((String)("Error on processGamePacket ip:" + var24), (Throwable)var11);
            }
        }

        if (this.isServer) {
            if (!this.B) {
                GameEngine.log("Skipping server updates, not networked");
            } else {
                this.ay();
                if (!this.aj) {
                    this.e(var1);
                }
            }
        }

        if (this.B) {
            String var20 = "Game paused.";
            if (this.al) {
                var2.bS.b("Game paused.", 100);
            } else {
                var2.bS.a("Game paused.");
            }
        }

        if (var2.tick < this.loaclTick) {
            this.Y = false;
        }

        if (this.bm) {
            this.closeServer("queDisconnect");
        }

    }

    public strictfp void b(float var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        if (var2 != null) {
            if (!this.isServer && this.B) {
                boolean var3 = false;
                Iterator var4 = this.socketList.iterator();

                while(var4.hasNext()) {
                    PlayerConnect var5 = (PlayerConnect)var4.next();
                    if (var5.p && !var5.a) {
                        var3 = true;
                    }
                }

                if (this.be && this.n()) {
                    var2.bS.b("Game ended by server.");
                    class_195.o();
                } else if (!var3 && this.n()) {
                    var2.bS.b("Server Disconnected.");
                    class_195.o();
                }

                if (var3 && (this.Y || this.bs + 1000L < System.currentTimeMillis()) && !this.isServer) {
                    PlayerConnect var6 = this.W();
                    if (var6 != null && var6.U > 20000) {
                        String var7 = "Receiving network data: " + var6.V + "/" + var6.U;
                        GameEngine.log(var7);
                        var2.bS.d(var7);
                        if (!this.ingame && this.bt + 4000L < System.currentTimeMillis()) {
                            this.bt = System.currentTimeMillis();
                            this.o(var7);
                        }

                        this.a(var6, var6.V, var6.U);
                    }
                }
            }

        }
    }

    public strictfp void c(float var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        this.bs = System.currentTimeMillis();
        if (this.B && (this.ah + this.ai < var2.tick || this.ah == -1)) {
            this.d();
            var2.replayEngine.a(this.checkSumData);
        }

        if ((this.B || var2.replayEngine.j()) && this.N) {
            this.N = false;
            this.w();
        }

        if (this.B) {
            if (this.isServer && !this.an && this.ah + this.ai / 2 < var2.tick && this.ah != -1) {
                try {
                    GameOutputStream var3 = new GameOutputStream();
                    var3.writeInt(this.ah);
                    var3.writeLong(this.checkSumData.allSum);
                    var3.writeInt(this.checkSumData.b.size());
                    Iterator var4 = this.checkSumData.b.iterator();

                    while(var4.hasNext()) {
                        ChecksumItem var5 = (ChecksumItem)var4.next();
                        var3.writeLong(var5.b);
                    }

                    Packet var7 = var3.getPacket(30);
                    this.h(var7);
                    if (this.debug) {
                        GameEngine.log("Sent checksum to client [" + this.ah + "]");
                    }

                    this.an = true;
                } catch (Exception var6) {
                    throw new RuntimeException(var6);
                }
            }

        }
    }

    public strictfp boolean I() {
        GameEngine var1 = GameEngine.getGameEngine();
        if (var1.bU.e()) {
            if (!this.bu) {
                GameEngine.log("shouldGameBePaused: isGoingToBlockThisFrame()==true: " + var1.bU.f());
            }

            this.bu = true;
            return true;
        } else {
            if (this.bu) {
                GameEngine.log("shouldGameBePaused: isGoingToBlockThisFrame()==false");
            }

            this.bu = false;
            return false;
        }
    }

    public strictfp void a(float var1, boolean var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        if (var3.tick >= this.loaclTick) {
            if (var3.tick > this.loaclTick) {
                throw new RuntimeException("game frame:" + var3.tick + " is greater then nest step:" + this.loaclTick);
            }

            this.Y = true;
        }

        if (var2 && this.I()) {
            this.Y = true;
        }

    }

    public strictfp void resolveSystemCommandPacket(Packet var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        if (this.b(var1)) {
            this.printLog("filtered packet (type:" + var1.type + ")");
        } else {
            GameInputStream var3;
            int var4;
            int var5;
            boolean var9;
            PlayerConnect var19;
            GameInputStream var20;
            int var23;
            switch (var1.type) {
                case 10:
                    if (this.isServer) {
                        this.printLog("we are a server! we don't follow orders");
                    } else if (var1.playerConnect.t) {
                        this.printLog("ignoring command");
                    } else {
                        var3 = new GameInputStream(var1);
                        var4 = var3.readInt();
                        var5 = var3.readInt();

                        for(var23 = 0; var23 < var5; ++var23) {
                            SyncPacket var27 = var2.cf.b();
                            var27.localTick = this.loaclTick;
                            var27.read(var3);
                            this.a(var27);
                        }

                        if (var4 < this.loaclTick) {
                            String var28 = "New nextBlockingFrame:" + var4 + " is smaller than current step:" + this.loaclTick;
                            g(var28);
                        }

                        this.loaclTick = var4;
                    }
                    break;
                case 20:
                    if (!this.isServer) {
                        this.printLog("we are not a server! skipping");
                    } else {
                        var3 = new GameInputStream(var1);
                        PlayerConnect var21 = var1.playerConnect;
                        if (!var21.a()) {
                            Player var22 = var21.player;
                            if (var22 == null) {
                                this.printLog("Player is null for message ADDCLIENTCOMMAND, skipping");
                            } else {
                                SyncPacket var25 = var2.cf.b();
                                var25.read(var3);
                                var25.p = var22;
                                if (var25.r) {
                                    this.printLog("Got system action from client, ignoring (" + var21.connectIndex + ")");
                                    var25.r = false;
                                }

                                if (var25.c() == null) {
                                    g("Invalid command from '" + var22.name + "', no team found");
                                } else if (!var25.l()) {
                                    g("Ignored command from '" + var22.name + "', check failed");
                                } else {
                                    this.a(var25);
                                }
                            }
                        }
                    }
                    break;
                case 30:
                    var19 = var1.playerConnect;
                    var20 = new GameInputStream(var1);
                    var5 = var20.readInt();
                    long var24 = var20.readLong();
                    if (this.ag) {
                        this.printLog("PACKET_SYNCCHECKSUM: skipping frame:" + var5 + ", we were told to wait for resync");
                    } else {
                        GameOutputStream var30 = new GameOutputStream();
                        var30.writeByte(0);
                        var30.writeInt(var5);
                        var30.writeInt(this.ah);
                        if (this.ah == var5 && this.checkSumData.allSum != 0L) {
                            var30.writeBoolean(true);
                            Log.d("RustedWarfare", "Running checksum");
                            var30.writeLong(var24);
                            var30.writeLong(this.checkSumData.allSum);
                            var9 = false;
                            if (var24 != this.checkSumData.allSum) {
                                g("Checksum doesn't match. Got:" + var24 + " expected:" + this.checkSumData.allSum);
                                var9 = true;
                                GameEngine.log("--- Desync for frame: " + var5 + " ---");
                                Iterator var32 = PlayerData.c().iterator();

                                while(var32.hasNext()) {
                                    PlayerData var35 = (PlayerData)var32.next();
                                    var35.t();
                                }
                            } else {
                                ++this.aq;
                            }

                            int var34 = var20.readInt();
                            if (var34 != this.checkSumData.b.size()) {
                                Log.d("RustedWarfare", "checkSumSize!=syncCheckList.size()");
                            }

                            var30.e("checkList");
                            var30.writeInt(var34);
                            var30.writeInt(this.checkSumData.b.size());
                            Iterator var36 = this.checkSumData.b.iterator();

                            while(var36.hasNext()) {
                                ChecksumItem item = (ChecksumItem)var36.next();
                                long var40 = var20.readLong();
                                var30.writeLong(var40);
                                var30.writeLong(item.b);
                                if (var40 != item.b && item.c) {
                                    g("[" + var5 + "] check(" + item.a + "): " + var40 + "!=" + item.b);
                                    var9 = true;
                                }
                            }

                            var30.endBlock("checkList");
                            var30.writeBoolean(var9);
                            //var30.writeBoolean(false);
                        } else {
                            var30.writeBoolean(false);
                            Log.d("RustedWarfare", "got remoteSyncFrame for:" + var5 + " needed:" + this.ah + " lastSyncCheckSum:" + this.checkSumData.allSum);
                        }

                        if (!this.isServer) {
                            Packet var33 = var30.getPacket(31);
                            this.a(var19, var33);
                        }
                    }
                    break;
                case 31:
                    if (!this.isServer) {
                        this.printLog("we are not a server, but got PACKET_SYNCCHECKSUM_STATUS");
                    } else {
                        var19 = var1.playerConnect;
                        var20 = new GameInputStream(var1);
                        var20.readByte();
                        var5 = var20.readInt();
                        var23 = var20.readInt();
                        boolean var26 = var20.readBoolean();
                        if (var26) {
                            long var29 = var20.readLong();
                            long var31 = var20.readLong();
                            var20.startBlock("checkList");
                            var20.readInt();
                            int var37 = var20.readInt();
                            if (var37 != this.checkSumData.b.size()) {
                                Log.d("RustedWarfare", "checkSumSize!=syncCheckList.size()");
                            }

                            Iterator var13 = this.checkSumData.b.iterator();

                            while(var13.hasNext()) {
                                ChecksumItem var14 = (ChecksumItem)var13.next();
                                long var15 = var20.readLong();
                                long var17 = var20.readLong();
                                if (var15 != var17) {
                                    GameEngine.print(var14.a + " Checksum [" + var5 + "]. server:" + var15 + " client:" + var17);
                                }
                            }

                            var20.endBlock("checkList");
                            boolean var39 = var20.readBoolean();
                            if (this.lastSyncTick >= var5) {
                                this.printLog("Not marking desync, already resynced before frame: " + this.lastSyncTick + "<=" + var5);
                            } else {
                                if (!var19.desyncCountFlag && var39) {
                                    ++var19.desyncCount;
                                }

                                var19.desyncCountFlag = var39;
                                if (!var39) {
                                    if (this.debug) {
                                        GameEngine.log("checksum: client checksum match [" + var5 + "]");
                                    }

                                    ++var19.x;
                                } else {
                                    GameEngine.log("client:" + var19.getName() + " desync [" + var5 + "]");
                                    if (this.aj && !this.ak) {
                                        g("pauseOnDesync is active, pausing");
                                        this.ak = true;
                                    }
                                }
                            }
                        } else if (this.debug) {
                            GameEngine.log("checksum for:" + var19.getName() + " frameMatch==false client:" + var23 + " server:[" + var5 + "]");
                        }
                    }
                    break;
                case 35:
                    var3 = new GameInputStream(var1);
                    var3.readByte();
                    var4 = var3.readInt();
                    var5 = var3.readInt();
                    float var6 = var3.readFloat();
                    float var7 = var3.readFloat();
                    if (!this.isServer && (double)var6 < 0.1) {
                        a("resync packet with setCurrentStepRate:" + var6 + " is too small", true);
                    }

                    PlayerConnect var8 = var1.playerConnect;
                    if (var8.t) {
                        this.printLog("ignoring resync command");
                    } else {
                        var9 = var3.readBoolean();
                        boolean var10 = var3.readBoolean();
                        byte[] var11;
                        if (var10) {
                            if (!this.isServer) {
                                this.printLog("we are not a server, but got a debug game save! skipping");
                            } else {
                                var11 = var3.getBytesAndCheckMark("gameSave");
                                this.updateDeSync(var11, var8);
                            }
                        } else {
                            GameEngine.log("Reloading from network save");
                            if (var9 && !this.isServer) {
                                this.resync(false, true, false);
                            }

                            var11 = var3.getBytesAndCheckMark("gameSave");
                            GameEngine.log("Save size: " + var11.length);
                            if (this.l) {
                                this.updateDeSync(var11, var8);
                            }

                            var2.replayEngine.a(var11, var2.tick, var4, var5, var6, var7);
                            GameInputStream var12 = new GameInputStream(var11);
                            var2.a("Resyncing game from server...", true);
                            var2.ca.a(var12, true, true, true);
                            var2.Z();
                            ++this.ar;
                            var2.tick = var4;
                            var2.by = var5;
                            this.loaclTick = var4 + 1;
                            this.ag = false;
                            this.ah = this.loaclTick + 1;
                            this.checkSumData.allSum = 0L;
                            if ((double)var6 < 0.1) {
                                a("resync setCurrentStepRate:" + var6 + " is too small", true);
                            }

                            this.setCurrentStepRate(var6, "rsync");
                            this.J = var7;
                        }
                    }
                    break;
                default:
                    this.printLog("we did not handle packet:" + var1.type);
            }

        }
    }

    public strictfp synchronized boolean b(Packet var1) {
        if (this.isServer) {
            PlayerConnect var2 = var1.playerConnect;
            if (var2 == null) {
                return false;
            }

            if (!var2.p && var1.type != 105 && var1.type != 110 && var1.type != 111 && var1.type != 108 && var1.type != 160) {
                return true;
            }
        }

        return false;
    }

    @SneakyThrows
    public strictfp synchronized void resolveCommandPacket(Packet var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        if (this.b(var1)) {
            this.printLog("filtered packet (type:" + var1.type + ")");
        } else {
            PlayerConnect var3;
            GameInputStream var4;
            int var5;
            boolean var6;
            int var7;
            int var9;
            String var10;
            GameInputStream var34;
            byte var36;
            PlayerConnect var37;
            int var40;
            String var41;
            String var42;
            PlayerConnect var43;
            String var44;
            GameInputStream var49;
            String var51;
            String var53;
            int var54;
            boolean var55;
            boolean var59;
            boolean var60;
            String var62;
            int var69;
            String var71;
            int var73;
            byte var76;
            switch (var1.type) {
                case 4:
                    var3 = var1.playerConnect;
                    var4 = new GameInputStream(var1);
                    var36 = var4.readByte();
                    var4.readInt();
                    var4.readInt();
                    break;
                case 105:
                    this.printLog("got PACKET_GET_SERVER_INFO");
                    if (!this.isServer) {
                        this.printLog("we are not a server! skipping");
                    }
                    break;
                case 106:
                    if (this.isServer) {
                        this.printLog("we are a server! we don't follow orders");
                    } else {
                        var34 = new GameInputStream(var1);
                        var37 = var1.playerConnect;
                        var34.readString();
                        var34.readInt();
                        this.gameMapData.mapType = (MapType)var34.readSimilarEnum(MapType.class);
                        this.gameMapData.mapName = var34.readString();
                        this.gameMapData.credits = var34.readInt();
                        this.gameMapData.fog = var34.readInt();
                        this.gameMapData.e = var34.readBoolean();
                        this.gameMapData.aidiff = var34.readInt();
                        var36 = var34.readByte();
                        this.G = var34.readBoolean();
                        this.H = var34.readBoolean();
                        this.av = true;
                        if (var36 >= 1) {
                            this.aw = var34.readInt();
                            this.ax = var34.readInt();
                        }

                        if (var36 >= 2) {
                            this.gameMapData.initUnit = var34.readInt();
                            this.gameMapData.income = var34.readFloat();
                            this.gameMapData.nukes = var34.readBoolean();
                            this.gameMapData.j = var34.readBoolean();
                        }

                        if (var36 >= 3) {
                            var6 = var34.readBoolean();
                            if (var6) {
                                try {
                                    class_591.a(var34);
                                    this.x = true;
                                } catch (Exception ex) {
                                    if (ex instanceof UnitException) {
                                        UnitException var31 = (UnitException) ex;
                                        this.closeServer("Missing unit:" + var31.getMessage() + " d:" + var31.b);
                                        this.b("Server sync mismatch", var31.getMessage());
                                        if (!GameEngine.av()) {
                                            var2.i(var31.getMessage());
                                        }

                                        var51 = "Server sync mismatch";
                                        if (var31.a != null) {
                                            var51 = var31.a;
                                        }

                                        var2.d(var51, var31.getMessage());
                                        break;
                                    }
                                }
                            }
                        }

                        if (var36 >= 4) {
                            this.gameMapData.sharedControl = var34.readBoolean();
                        }

                        if (var36 >= 5) {
                            this.gameMapData.m = var34.readBoolean();
                        }

                        if (var36 >= 6) {
                            this.gameMapData.n = var34.readBoolean();
                        }

                        if (var36 >= 7) {
                            this.gameMapData.spectators = var34.readBoolean();
                            this.gameMapData.p = var34.readBoolean();
                        }

                        if (var36 >= 8) {
                            this.gameMapData.q = var34.readInt();
                        }

                        class_195.o();
                    }
                    break;
                case 108:
                    var3 = var1.playerConnect;
                    var4 = new GameInputStream(var1);
                    long var63 = var4.readLong();
                    var4.readByte();
                    GameOutputStream var68 = new GameOutputStream();
                    var68.writeLong(var63);
                    var68.writeByte(1);
                    var54 = var2.b();
                    if (var54 > 130) {
                        var54 = 130;
                    }

                    var68.writeByte(var54);
                    Packet var77 = var68.getPacket(109);
                    this.a(var3, var77);
                    break;
                case 109:
                    if (!this.isServer) {
                        this.printLog("we are not a server! skipping");
                    } else {
                        long var52 = System.currentTimeMillis();
                        PlayerConnect var61 = var1.playerConnect;
                        var49 = new GameInputStream(var1);
                        long var65 = var49.readLong();
                        var76 = var49.readByte();
                        byte var75 = 0;
                        if (var76 >= 1) {
                            var75 = var49.readByte();
                        }

                        var69 = (int)(var52 - var65);
                        var61.A = var69;
                        var61.B = var52;
                        if (var61.player != null) {
                            var61.player.ping = var69;
                            var61.player.lastReciveTime = var52;
                            var61.player.V = var75;
                        }

                        if (var61.q && this.isServer && this.D && this.z != null) {
                            this.z.ping = var69;
                            this.z.lastReciveTime = var52;
                        }

                        if (!this.ingame) {
                            class_195.o();
                        }
                    }
                    break;
                case 110:
                    this.printLog("got REGISTER_CONNECTION");
                    if (!this.isServer) {
                        this.printLog("we are not a server! skipping");
                    } else {
                        var34 = new GameInputStream(var1);
                        var37 = var1.playerConnect;
                        var42 = var34.readString();
                        var40 = var34.readInt();
                        var7 = var34.readInt();
                        var54 = var34.readInt();
                        var53 = var34.readString();
                        var10 = var34.isReadString();
                        var62 = null;
                        var37.clientVersion = var7;
                        if (var40 >= 1) {
                            var37.L = var34.readString();
                        }

                        if (var40 >= 2) {
                            var62 = var34.readString();
                        }

                        var73 = -1;
                        if (var40 >= 3) {
                            var73 = var34.readInt();
                        }

                        var71 = "MISSING";
                        if (var40 >= 4) {
                            var71 = var34.readString();
                        }

                        String var14 = "";
                        if (var40 >= 5) {
                            var14 = var34.readString();
                        }

                        if (var53.length() > 20) {
                            this.a(var37, "Your username is too long");
                            var37.a("kicked");
                        } else {
                            var53 = p(var53);
                            if (var53.length() < 2) {
                                this.a(var37, "Your username is too short");
                                var37.a("kicked");
                            } else {
                                Player var15 = null;
                                if (var62 != null) {
                                    var15 = PlayerData.a(var62);
                                    if (var15 != null) {
                                        this.printLog("Existing player: " + var15.site + " - " + var15.name);
                                    }
                                }

                                class_983 var16 = this.a(var37);
                                String var17;
                                if (var16 != null) {
                                    GameEngine.log("Connection banned for " + var16.b() + " more seconds");
                                    var17 = var16.a();
                                    this.a(var37, var17);
                                    var37.a("kicked");
                                } else {
                                    var17 = this.d.a(var37, var53, var7, var54, var37.L, var15);
                                    if (var17 != null) {
                                        this.a(var37, var17);
                                        var37.a("kicked");
                                    } else if (var7 < this.e && !this.v) {
                                        this.a(var37, "Game is out of date, please update to v" + var2.u());
                                        var37.a("kicked");
                                    } else if (var7 > this.e && !this.v) {
                                        this.a(var37, "Your client is newer then the server. Server is on: v" + var2.u());
                                        var37.a("kicked");
                                    } else if (!this.v && var73 != var2.z()) {
                                        GameEngine.log("New Player kicked: Unit checksum mismatch: clientUnitsChecksum=" + var73 + " game.getAllUnitsChecksum():" + var2.z());
                                        this.a(var37, "Your core units are different to the server's core units. Game can not be synchronized");
                                        var37.a("kicked");
                                    } else {
                                        String var18;
                                        if (!this.v) {
                                            var18 = this.g(var37.connectKey);
                                            if (!var18.equals(var71)) {
                                                GameEngine.log("New Player kicked: Integrity Check Failed: expectedResponse=" + var18 + " clientResponse=" + var71);
                                                this.a(var37, "Your 'Rusted Warfare' client is different to the server. Game can not be synchronized.");
                                                var37.a("kicked");
                                                break;
                                            }
                                        }

                                        if (!this.ingame && this.gameMapData.p) {
                                            this.a(var37, "Room is locked. New players cannot join this server.");
                                            var37.a("kicked");
                                        } else if (this.ingame && var15 == null && !this.s) {
                                            this.a(var37, "A game has already been started on this server");
                                            var37.a("kicked");
                                        } else {
                                            if (this.passwd != null && var15 == null) {
                                                var18 = class_340.e(this.passwd);
                                                if (!var18.equals(var10)) {
                                                    if (var10 == null) {
                                                        GameEngine.b("processSystemPacket", "Player tried to join but needs a password");
                                                    } else {
                                                        GameEngine.b("processSystemPacket", "Player tried to join but had an incorrect password");
                                                    }

                                                    this.d(var37);
                                                    break;
                                                }
                                            }

                                            var18 = this.h(this.W);
                                            if (!var18.equals(var14)) {
                                                var37.c("no extra");
                                                var37.N = true;
                                            }

                                            if (var37.player == null) {
                                                synchronized(this.bC) {
                                                    int var20;
                                                    if (var15 == null) {
                                                        var20 = PlayerData.getNullSite();
                                                    } else {
                                                        var20 = var15.site;
                                                    }

                                                    if (var20 == -1 && !this.v) {
                                                        this.a(var37, "No free slots on server");
                                                        var37.a("no free slots");
                                                    } else {
                                                        String var21 = this.d.a(var37, var53);
                                                        if (var21 != null) {
                                                            this.a(var37, var21);
                                                            var37.a("kicked");
                                                        } else {
                                                            APIEncryption.a(var37);
                                                            if (!this.v && var37.O) {
                                                                this.a(var37, "");
                                                                var37.a("kicked");
                                                            } else {
                                                                String var22 = null;
                                                                if (var15 != null) {
                                                                    var37.player = var15;
                                                                    String var23 = "";
                                                                    if (this.ingame) {
                                                                        if (var15.b()) {
                                                                            var23 = " (Spectator)";
                                                                        } else {
                                                                            var23 = " (Team " + var15.getPlayerTeamName() + ")";
                                                                        }
                                                                    }

                                                                    this.j("'" + var37.player.name + "' reconnected. " + var23);
                                                                    var37.fastSyncFlag = true;
                                                                    var22 = var15.name;
                                                                    var15.P = var37.m;
                                                                } else {
                                                                    if (this.v && var20 == -1) {
                                                                        var37.player = new Player(-3);
                                                                    } else {
                                                                        var37.player = new Player(var20);
                                                                        var37.player.team = var20 % 2;
                                                                    }

                                                                    if (this.ingame && this.s) {
                                                                        var37.fastSyncFlag = true;
                                                                    }
                                                                }

                                                                if (var15 == null && var53 != null) {
                                                                    ArrayList var78 = this.ax();

                                                                    for(int var24 = 0; var24 < 10; ++var24) {
                                                                        boolean var25 = false;
                                                                        String var26 = var53;
                                                                        if (var24 > 0) {
                                                                            var26 = var53 + "(" + var24 + ")";
                                                                        }

                                                                        Iterator var27 = var78.iterator();

                                                                        while(var27.hasNext()) {
                                                                            PlayerData var28 = (PlayerData)var27.next();
                                                                            if (var26.equalsIgnoreCase(var28.name)) {
                                                                                var25 = true;
                                                                            }
                                                                        }

                                                                        if (!var25) {
                                                                            var53 = var26;
                                                                            break;
                                                                        }
                                                                    }
                                                                }

                                                                var37.player.name = var53;
                                                                var37.player.connectHexID = var62;
                                                                var37.player.P = var37.m;
                                                                var37.clientVersion = var7;
                                                                GameEngine.b("processSystemPacket", "New player: " + var53 + ", networkVersion:" + var37.clientVersion + " existing:" + (var15 != null));
                                                                var37.p = true;
                                                                if (var15 == null) {
                                                                    this.d.a((PlayerData)var37.player);
                                                                }

                                                                class_195.o();
                                                                this.sendTeamData(var37);
                                                                this.sendServerInfo(var37);
                                                                this.d.c(var37, var53, var22);
                                                                if ((var15 != null || this.s) && this.ingame) {
                                                                    boolean var79 = true;
                                                                    this.sendStartGamePacket(var37, var79);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            } else {
                                                GameEngine.b("processSystemPacket", "This connection already has a player");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 111:
                    var34 = new GameInputStream(var1);
                    var37 = var1.playerConnect;
                    var42 = null;

                    try {
                        var42 = var34.readString();
                    } catch (Exception var30) {
                        GameEngine.a((String)"Error reading disconnect reason", (Throwable)var30);
                    }

                    this.printLog("Got a disconnect packet:" + var42);
                    if (var37 != null) {
                        var37.a(false, false, var42);
                    }

                    if (!this.isServer) {
                    }
                    break;
                case 112:
                    if (!this.isServer) {
                        this.printLog("we are not a server! skipping");
                    } else {
                        var3 = var1.playerConnect;
                        var4 = new GameInputStream(var1);
                        var3.C = var4.readBoolean();
                        var3.D = var4.readBoolean();
                    }
                    break;
                case 113:
                    if (this.isServer) {
                        this.printLog("we are a server! skipping: " + var1.type);
                    } else {
                        a(bE);
                    }
                    break;
                case 115:
                    if (this.isServer) {
                        this.printLog("we are a server! we don't follow orders");
                    } else {
                        var34 = new GameInputStream(var1);
                        var34.setCacheInt(var1.playerConnect.clientVersion);
                        var37 = var1.playerConnect;
                        var5 = var34.readInt();
                        Object var57 = null;
                        var7 = 8;
                        var55 = false;
                        if (var34.getCacheInt() >= 90) {
                            var59 = false;
                            if (var34.getCacheInt() >= 141) {
                                var59 = true;
                                var55 = var34.readBoolean();
                            }

                            var7 = var34.readInt();
                            PlayerData.b(var7, false);
                            var34.a("teams", var59);
                            if (var7 > PlayerData.c) {
                                throw new IOException("Cannot load:" + var7 + " teams");
                            }
                        } else if (this.ingame) {
                            g("Warning old team system used in started game, stream version:" + var34.getCacheInt());
                        }

                        for(var9 = 0; var9 < var7; ++var9) {
                            Object var67 = PlayerData.getPlayerData(var9);
                            boolean var72 = var34.readBoolean();
                            if (!var72) {
                                if (var67 != null) {
                                    if (this.ingame) {
                                        g("Warning team:" + var9 + " removed while game is running");
                                    }

                                    ((PlayerData)var67).I();
                                }
                            } else {
                                var73 = var34.readInt();
                                if (var67 == null) {
                                    if (this.ingame) {
                                        g("Warning team:" + var9 + " added while game is running");
                                    }

                                    if (!this.isServer && var67 instanceof class_138) {
                                        g("Warning we are a client with an AI team");
                                    }

                                    var67 = new Player(var9);
                                }

                                if (var55) {
                                    ((PlayerData)var67).a(var34);
                                } else {
                                    ((PlayerData)var67).a(var34, this.ingame);
                                }
                            }

                            if (var67 != null && ((PlayerData)var67).site == var5) {
                                var57 = var67;
                            }
                        }

                        if (var34.getCacheInt() >= 90) {
                            var34.endBlock("teams");
                        }

                        this.z = (PlayerData)var57;
                        this.gameMapData.fog = var34.readInt();
                        this.gameMapData.credits = var34.readInt();
                        this.gameMapData.e = var34.readBoolean();
                        this.gameMapData.aidiff = var34.readInt();
                        var76 = var34.readByte();
                        this.aw = var34.readInt();
                        this.ax = var34.readInt();
                        if (var76 >= 2) {
                            this.gameMapData.initUnit = var34.readInt();
                            this.gameMapData.income = var34.readFloat();
                            this.gameMapData.nukes = var34.readBoolean();
                            this.gameMapData.j = var34.readBoolean();
                        }

                        if (var76 >= 3) {
                            var60 = var34.readBoolean();
                            if (var60) {
                                try {
                                    class_591.a(var34);
                                    this.x = true;
                                } catch (Exception ex) {
                                    if (ex instanceof UnitException) {
                                        UnitException var33 = (UnitException)ex;
                                        this.closeServer("Missing unit:" + var33.getMessage() + " d:" + var33.b);
                                        this.b("Connection Failed", var33.getMessage());
                                        if (!GameEngine.av()) {
                                            var2.i(var33.getMessage());
                                        }

                                        var2.d("Connection Failed", var33.getMessage());
                                        break;
                                    }

                                }
                            }
                        }

                        if (var76 >= 4) {
                            this.gameMapData.sharedControl = var34.readBoolean();
                        }

                        if (var76 >= 5) {
                            this.al = var34.readBoolean();
                        }

                        class_195.o();
                    }
                    break;
                case 116:
                    if (this.isServer) {
                        this.printLog("we are a server! we don't follow orders");
                    } else {
                        var34 = new GameInputStream(var1);
                        var37 = var1.playerConnect;
                        var5 = var34.readInt();
                        var6 = var34.readBoolean();
                        if (var6 && !this.be) {
                            this.be = var6;
                        }
                    }
                    break;
                case 117:
                    var3 = var1.playerConnect;
                    if (this.isServer && !var3.q) {
                        this.printLog("we are a server! skipping: " + var1.type);
                    } else {
                        var4 = new GameInputStream(var1);
                        var4.readByte();
                        var5 = var4.readInt();
                        var44 = var4.readString();
                        EnterPasswordCallback var58 = new EnterPasswordCallback();
                        var58.d = true;
                        var58.c = var5;
                        var58.b = var44;
                        a(var58);
                    }
                case 118:
                    break;
                case 120:
                    if (this.isServer) {
                        this.printLog("error, we are a server but got: PACKET_START_GAME");
                    } else {
                        var34 = new GameInputStream(var1);
                        var34.readByte();
                        this.gameMapData.mapType = (MapType)var34.readSimilarEnum(MapType.class);
                        if (this.gameMapData.mapType == MapType.savedGame) {
                            this.aA = var34.u();
                        } else if (this.gameMapData.mapType == MapType.customMap) {
                            this.aB = var34.u();
                        }

                        this.az = var34.readString();
                        this.aB();
                    }
                    break;
                case 122:
                    if (this.isServer) {
                        this.printLog("error, we are a server but got: PACKET_RETURN_TO_BATTLEROOM");
                    } else {
                        this.aC();
                    }
                    break;
                case 140:
                    if (!this.isServer) {
                        this.printLog("we are not a server! skipping");
                    } else {
                        var3 = var1.playerConnect;
                        var4 = new GameInputStream(var1);
                        Player var45 = var3.player;
                        if (var45 == null) {
                            if (!var3.q) {
                                this.printLog("player is null for message, skipping");
                                break;
                            }

                            this.printLog("Allowing message from non player on forwarding connection");
                            var45 = this.bk;
                        }

                        var44 = var4.readString();
                        var4.readByte();
                        var44 = i(var44);
                        if (this.d.a(var3, var45.name, var44)) {
                            if (this.aC.a(var3, 60000) > this.h) {
                                if (class_340.a(var3.g, System.nanoTime()) > 60000L) {
                                    var3.g = System.nanoTime();
                                    this.j("Anti-spam: Too many messages from '" + var3.getName() + "'");
                                }

                                if (this.debug) {
                                    GameEngine.log("extraDebug:" + var44);
                                }
                            } else {
                                this.a(var3, var45, var45.name, var44);
                                this.d.b(var3, var45.name, var44);
                                this.b(var3, var45, var45.name, var44);
                            }
                        }
                    }
                    break;
                case 141:
                    if (this.isServer) {
                        var3 = var1.playerConnect;
                        if (!var3.q) {
                            this.printLog("error, we are a server but got: PACKET_RECEIVE_CHAT_FROM_SERVER");
                            break;
                        }
                    }

                    var34 = new GameInputStream(var1);
                    var41 = var34.readString();
                    var36 = var34.readByte();
                    var44 = var34.isReadString();
                    var34.readInt();
                    var7 = -1;
                    if (var36 >= 3) {
                        var7 = var34.readInt();
                    }

                    this.b((PlayerConnect)null, var7, var44, var41);
                    break;
                case 150:
                    if (this.isServer) {
                        this.printLog("error, we are a server but got: PACKET_SEND_KICK");
                    } else {
                        var34 = new GameInputStream(var1);
                        var41 = var34.readString();
                        var41 = class_1009.c(var41);
                        this.printLog("we got kicked, reason:" + var41);
                        this.closeServer("I was kicked");
                        this.b("Kicked", "Kicked: " + var41);
                        var2.d("Kicked", "Kicked: " + var41);
                        var2.i("Kicked: " + var41);
                    }
                    break;
                case 151:
                    var3 = var1.playerConnect;
                    if (this.isServer && !var3.q) {
                        this.printLog("error, we are a server but got: 151");
                    } else {
                        long var39 = Unit.loadAllUnitsTook();
                        var49 = new GameInputStream(var1);
                        var7 = var49.readInt();
                        var54 = var49.readInt();
                        if (var49.readBoolean()) {
                            APIEncryption.i = var49.readInt();
                        }

                        if (var49.readBoolean()) {
                            APIEncryption.j = var49.readInt();
                        }

                        var53 = "";
                        if (var54 == 0) {
                            var53 = "" + APIEncryption.i;
                        }

                        if (var54 == 1) {
                            var53 = "" + APIEncryption.j;
                        }

                        if (var54 == 2) {
                            var53 = this.g(APIEncryption.i);
                        }

                        if (var54 == 3) {
                            var53 = class_340.c(APIEncryption.i + "|" + APIEncryption.j);
                        }

                        if (var54 == 4) {
                            var53 = class_340.c(APIEncryption.i + "|" + APIEncryption.j);
                        }

                        if (var54 == 5 || var54 == 6) {
                            var10 = var49.readString();
                            var62 = var49.readString();
                            var73 = var49.readInt();
                            if (var54 == 6) {
                                var62 = var62 + APIEncryption.i;
                            }

                            if (var73 > 10000000) {
                                var53 = "max";
                            } else {
                                var53 = "-1";

                                for(int var74 = 0; var74 <= var73; ++var74) {
                                    if (class_340.c(var62 + var74).equals(var10)) {
                                        var53 = "" + var74;
                                        break;
                                    }
                                }
                            }
                        }

                        if (var54 == 7) {
                            var10 = var49.readString();
                            var69 = var49.readInt();
                            if (var69 > 10000) {
                                var53 = "max";
                            } else {
                                var53 = "";

                                for(var73 = 0; var73 < var69; ++var73) {
                                    var53 = var53 + var10;
                                }
                            }
                        }

                        float var64 = Unit.a(var39);
                        GameOutputStream var70 = new GameOutputStream();
                        var70.writeInt(var7);
                        var70.writeInt(var54);
                        var70.writeString(var53);
                        var70.writeFloat(var64);
                        this.a(var3, var70.getPacket(152));
                    }
                    break;
                case 160:
                    var34 = new GameInputStream(var1);
                    var37 = var1.playerConnect;
                    var42 = var34.readString();
                    var40 = var34.readInt();
                    var7 = var34.readInt();
                    var55 = true;
                    if (var40 >= 1) {
                        var54 = var34.readInt();
                    }

                    if (var37.i) {
                        GameEngine.log("steam: request info packet");
                    }

                    if (var40 >= 2) {
                        var53 = var34.isReadString();
                        if (var53 != null) {
                            var37.c("Using query string: " + var53);
                            var37.o = var53;
                        }
                    }

                    if (var40 >= 3) {
                        var34.readString();
                    }

                    if (var40 >= 4) {
                        var53 = var34.readString();
                        var10 = var34.readString();
                        if (GameEngine.ax()) {
                            var37.c("Misc: " + var10);
                        }
                    }

                    this.g(var37);
                    break;
                case 161:
                    if (this.isServer) {
                        this.printLog("we are a server! we don't PREREGISTER_INFO");
                    } else {
                        var34 = new GameInputStream(var1);
                        var37 = var1.playerConnect;
                        if (var37.i) {
                            GameEngine.log("steam: got info packet");
                        }

                        var42 = var34.readString();
                        var40 = var34.readInt();
                        var7 = var34.readInt();
                        var54 = var34.readInt();
                        var53 = var34.readString();
                        this.S = var34.readString();
                        var37.clientVersion = var7;
                        if (var40 >= 1) {
                            this.T = var34.readInt();
                        }

                        if (var40 >= 2) {
                            this.U = var34.readInt();
                            this.V = var34.readInt();
                        }

                        if (this.bz) {
                            this.printLog("PACKET_SEND_PREREGISTER_INFO: Register connection has already been sent (resending)");
                        }

                        this.h(var37);
                    }
                    break;
                case 163:
                    if (this.isServer) {
                        this.printLog("we are already a server");
                    } else {
                        var34 = new GameInputStream(var1);
                        var34.readByte();
                        int var35 = var34.readInt();
                        var5 = var34.readInt();
                        var44 = var34.isReadString();
                        this.printLog("Relay version: " + var35);
                    }
                    break;
                case 170:
                    this.printLog("Got 'become server' packet");
                    if (this.isServer) {
                        this.printLog("we are already a server");
                    } else {
                        var3 = var1.playerConnect;
                        var4 = new GameInputStream(var1);
                        var36 = var4.readByte();
                        var6 = var4.readBoolean();
                        boolean var47 = var4.readBoolean();
                        var51 = var4.isReadString();
                        var59 = var4.readBoolean();
                        var60 = var4.readBoolean();
                        var62 = var4.isReadString();
                        boolean var66 = false;
                        if (var36 >= 1) {
                            var66 = var4.readBoolean();
                        }

                        var71 = null;
                        if (var36 >= 2) {
                            var71 = var4.isReadString();
                        }

                        this.printLog("Multicast:" + var66);
                        var3.r = var66;
                        if (var6) {
                            var3.q = true;
                        }

                        if (var47) {
                            var3.s = true;
                        }

                        this.D = true;
                        this.E = var62;
                        var2.netEngine.passwd = null;
                        var2.netEngine.useMods = var59;
                        var2.netEngine.publicRoom = var60;
                        this.c(false);
                        if (var71 != null) {
                            if (this.z != null) {
                                this.z.P = var71;
                            } else {
                                GameEngine.log("Become server: No local team");
                            }
                        }

                        if (var2.netEngine.publicRoom) {
                        }

                        if (var51 != null) {
                            var2.settingsEngine.networkServerId = var51;
                        }

                        if (var2.tick > 60) {
                            this.aa = true;
                        }

                        if (!this.x && !this.ingame) {
                            GameEngine.log("enableAllCustomUnitsPossible mods:" + this.useMods);
                            class_436.b(this.useMods);
                            this.x = true;
                        }
                    }
                    break;
                case 172:
                    var3 = var1.playerConnect;
                    if (!var3.q) {
                        this.printLog("forwarding not allowed on this connection");
                    } else {
                        this.printLog("got FORWARD_CLIENT_ADD");
                        var4 = new GameInputStream(var1);
                        var36 = var4.readByte();
                        var40 = var4.readInt();
                        String var46 = var4.readString();
                        var51 = var4.isReadString();
                        var53 = null;
                        if (var36 >= 1) {
                            var53 = var4.isReadString();
                        }

                        if (this.a(var3, var40) != null) {
                            this.printLog("Not adding client:" + var40 + " already exists");
                        } else {
                            PlayerConnect var56 = this.a(var3, var40, var46, var53);
                            if (var56 != null && var51 != null) {
                                Player var11 = PlayerData.b(var46);
                                if (var11 == null) {
                                    this.printLog("PACKET_FORWARD_CLIENT_ADD: Failed to find existing player with id:" + var46);
                                    Iterator var12 = PlayerData.c().iterator();

                                    while(var12.hasNext()) {
                                        PlayerData var13 = (PlayerData)var12.next();
                                        if (var13 != null) {
                                            this.printLog("option: " + var13.name + " - " + var13.P + " - localPlayer:" + (this.z == var13));
                                        }
                                    }
                                } else {
                                    var11.connectHexID = var51;
                                }
                            }
                        }
                    }
                    break;
                case 173:
                    var3 = var1.playerConnect;
                    if (!var3.q) {
                        this.printLog("forwarding not allowed on this connection");
                    } else {
                        this.printLog("got FORWARD_CLIENT_REMOVE");
                        var4 = new GameInputStream(var1);
                        var36 = var4.readByte();
                        var40 = var4.readInt();
                        var43 = null;
                        PlayerConnect var50 = this.a(var3, var40);
                        if (var50 != null) {
                            this.b((PlayerConnect)var50, null);
                        }
                    }
                    break;
                case 174:
                    var3 = var1.playerConnect;
                    if (!var3.q) {
                        this.printLog("forwarding not allowed on this connection");
                    } else {
                        var4 = new GameInputStream(var1);
                        var5 = var4.readInt();
                        byte[] var38 = var4.readBytes();
                        var43 = this.a(var3, var5);
                        if (var43 == null) {
                            this.printLog("PACKET_FORWARD_CLIENT_FROM failed, cannot find client");
                        } else if (!(var43.socket instanceof RelayForwardedSocket)) {
                            this.printLog("PACKET_FORWARD_CLIENT_FROM failed, socket is wrong type");
                        } else {
                            RelayForwardedSocket var48 = (RelayForwardedSocket)var43.socket;
                            var48.d.a(var38);
                        }
                    }
                    break;
                case 175:
                    this.printLog("got PACKET_FORWARD_CLIENT_TO");
                    break;
                case 176:
                    this.printLog("got PACKET_FORWARD_CLIENT_TO_REPEATED");
                    break;
                case 178:
                    this.printLog("got PACKET_RECONNECT_TO");
                    var3 = var1.playerConnect;
                    if (this.isServer && !var3.q) {
                        this.printLog("we are a server, ");
                    } else {
                        var4 = new GameInputStream(var1);
                        var4.readByte();
                        var5 = var4.readInt();
                        var6 = var4.readBoolean();
                        var7 = var4.readInt();
                        ArrayList var8 = new ArrayList();

                        for(var9 = 0; var9 < var7; ++var9) {
                            var10 = var4.readString();
                            var8.add(var10);
                        }

                        this.a(var8, var6);
                    }
                    break;
                default:
                    this.printLog("we did not handle packet:" + var1.type);
            }

        }
    }

    public static strictfp String i(String var0) {
        if (var0 == null) {
            return null;
        } else {
            if (var0.length() > 250) {
                var0 = var0.substring(0, 250);
            }

            if (var0.contains("\n")) {
                var0 = var0.replace("\n", "?");
            }

            var0 = var0.replace("\u0000", ".");
            boolean var1 = false;
            char[] var2 = var0.toCharArray();
            int var3 = var2.length;

            int var4;
            int var5;
            for(var4 = 0; var4 < var3; ++var4) {
                var5 = var2[var4];
                if (Character.isISOControl((char)var5)) {
                    var1 = true;
                    break;
                }
            }

            if (var1) {
                StringBuilder var7 = new StringBuilder();
                char[] var8 = var0.toCharArray();
                var4 = var8.length;

                for(var5 = 0; var5 < var4; ++var5) {
                    char var6 = var8[var5];
                    if (!Character.isISOControl(var6)) {
                        var7.append(var6);
                    }
                }

                var0 = var7.toString();
            }

            return var0;
        }
    }

    public strictfp void J() {
        GameEngine var1 = GameEngine.getGameEngine();
        var1.bS.g.m();
    }

    public strictfp void K() {
        this.b((String)null, (String)null);
    }

    public strictfp void b(String var1, String var2) {
        GameEngine.log("closeBattleroom..");
        class_195.a(var1, var2);
        this.d.d();
    }

    public strictfp synchronized void L() {
        Iterator var1 = this.socketList.iterator();

        while(var1.hasNext()) {
            PlayerConnect var2 = (PlayerConnect)var1.next();
            if (var2.p) {
                this.sendServerInfo(var2);
            }
        }

    }

    public strictfp synchronized void sendServerInfo(PlayerConnect var1) {
        if (!this.isServer) {
            this.printLog("sendServerInfo: we are not a server!");
        } else {
            GameOutputStream var2 = new GameOutputStream();

            try {
                var2.writeString("com.corrodinggames.rts");
                var2.writeInt(this.e);
                var2.writeSimilarEnum(this.gameMapData.mapType);
                if (this.v) {
                    var2.writeString("<CHAT ONLY>");
                } else {
                    var2.writeString(this.gameMapData.mapName == null ? "<NULL>" : class_697.o(this.gameMapData.mapName));
                }

                var2.writeInt(this.gameMapData.credits);
                var2.writeInt(this.gameMapData.fog);
                var2.writeBoolean(this.gameMapData.e);
                var2.writeInt(this.gameMapData.aidiff);
                var2.writeByte(8);
                var2.writeBoolean(this.d.a(var1));
                boolean var3 = this.d.b(var1);
                var2.writeBoolean(var3);
                var2.writeInt(this.aw);
                var2.writeInt(this.ax);
                var2.writeInt(this.gameMapData.initUnit);
                var2.writeFloat(this.gameMapData.income);
                var2.writeBoolean(this.gameMapData.nukes);
                var2.writeBoolean(this.gameMapData.j);
                if (this.v) {
                    var2.writeBoolean(false);
                } else {
                    var2.writeBoolean(true);
                    class_591.a(var2);
                }

                var2.writeBoolean(this.gameMapData.sharedControl);
                var2.writeBoolean(this.gameMapData.m);
                var2.writeBoolean(this.gameMapData.n);
                var2.writeBoolean(this.gameMapData.spectators);
                var2.writeBoolean(this.gameMapData.p);
                var2.writeInt(this.gameMapData.q);
            } catch (Exception var4) {
                throw new RuntimeException(var4);
            }

            this.a(var1, var2.getPacket(106));
        }
    }

    public strictfp synchronized void a(PlayerConnect var1, String var2) {
        if (!this.isServer) {
            this.printLog("sendKick: we are not a server!");
        } else {
            this.printLog("kicking client reason:" + var2);
            GameOutputStream var3 = new GameOutputStream();

            try {
                var3.writeString(var2);
            } catch (Exception var5) {
                throw new RuntimeException(var5);
            }

            this.a(var1, var3.getPacket(150));
        }
    }

    public strictfp synchronized void d(PlayerConnect var1) {
        if (!this.isServer) {
            this.printLog("sendIncorrectPassword: we are not a server!");
        } else {
            this.printLog("sendIncorrectPassword");
            GameOutputStream var2 = new GameOutputStream();

            try {
                var2.writeInt(0);
            } catch (Exception var4) {
                throw new RuntimeException(var4);
            }

            this.a(var1, var2.getPacket(113));
        }
    }

    public strictfp void M() {
        if (this.isServer) {
            int var1;
            PlayerData var2;
            for(var1 = 0; var1 < PlayerData.f; ++var1) {
                var2 = PlayerData.getPlayerData(var1);
                if (var2 != null) {
                    if (this.v) {
                        var2.ac = 0;
                    } else if (var2.b()) {
                        var2.ac = 100;
                    } else {
                        var2.ac = var2.team;
                    }

                    if (var2.b()) {
                        var2.gameColor = -1;
                    } else {
                        int var3 = var2.S();
                        if (var2.color != null) {
                            var3 = var2.color;
                        } else if (this.a(var3, (PlayerData)null)) {
                            var3 = -1;
                        }

                        var2.gameColor = var3;
                    }
                }
            }

            for(var1 = 0; var1 < PlayerData.f; ++var1) {
                var2 = PlayerData.getPlayerData(var1);
                if (var2 != null && var2.gameColor == -1 && !var2.b()) {
                    var2.gameColor = this.N();
                }
            }
        }

    }

    public strictfp int N() {
        for(int var1 = 0; var1 < 10; ++var1) {
            if (!this.f(var1)) {
                return var1;
            }
        }

        return -1;
    }

    public strictfp boolean f(int var1) {
        for(int var2 = 0; var2 < PlayerData.f; ++var2) {
            PlayerData var3 = PlayerData.getPlayerData(var2);
            if (var3 != null && var3.gameColor == var1 && !var3.b()) {
                return true;
            }
        }

        return false;
    }

    public strictfp boolean a(int var1, PlayerData var2) {
        for(int var3 = 0; var3 < PlayerData.f; ++var3) {
            PlayerData var4 = PlayerData.getPlayerData(var3);
            if (var4 != null && var4 != var2 && var4.color != null && var4.color == var1 && !var4.b()) {
                return true;
            }
        }

        return false;
    }

    public strictfp void O() {
        if (this.isServer) {
            long var1 = System.currentTimeMillis();
            int var3 = GameEngine.getGameEngine().by;
            if (this.z != null && !this.D) {
                this.z.ping = -99;
                this.z.lastReciveTime = var1;
            }

            this.M();

            for(int var4 = 0; var4 < PlayerData.c; ++var4) {
                PlayerData var5 = PlayerData.getPlayerData(var4);
                if (var5 != null) {
                    boolean var6 = this.z == var5;
                    var5.c(var6);
                    if (!this.ingame) {
                    }

                    if (this.ingame && !this.F && !var5.w) {
                        boolean var7 = false;
                        if (var5.isTimeOut()) {
                            var7 = true;
                        }

                        long var8 = 60000L;
                        if (var5.Z > 180000) {
                            var8 = 160000L;
                        }

                        boolean var10 = false;
                        if (this.aa) {
                            if (var5.Y == -1L) {
                                var5.Y = var1;
                                var5.Z = var3;
                            }

                            if ((this.ak || this.al) && !var5.ab) {
                                var5.Y = var1;
                                var5.Z = var3;
                            }

                            if (var5.Y + var8 < var1) {
                                var10 = true;
                            }
                        }

                        if (var5.ab != var10) {
                            var5.ab = var10;
                        }

                        if (var10) {
                            var7 = true;
                            if (!var5.aa) {
                                boolean var11 = var5.G || var5.F || var5.sharedControl_2 || var5.b();
                                if (!var11) {
                                    var5.aa = true;
                                }
                            }
                        }

                        if (var5.sharedControl_2 != var7) {
                            if (var7 && !var5.G && !var5.F && !var5.sharedControl_1 && !var5.b()) {
                                String var13 = "-t [Sharing control due to disconnect]";
                                if (var10) {
                                    var13 = "-t [Sharing control due to afk]";
                                }

                                GameEngine.log(var5.name + " - " + var13);
                                int var12 = PlayerData.a(var5.team, true);
                                if (var12 > 1) {
                                    this.a((PlayerConnect)null, var5, var5.name, var13);
                                }
                            }

                            var5.sharedControl_2 = var7;
                        }
                    }
                }
            }
        }

    }

    public strictfp void P() {
        if (this.au == 0L) {
            this.au = System.currentTimeMillis();
        }

    }

    public strictfp void Q() {
        this.au = 0L;
        this.sendTeamData((PlayerConnect)null);
    }

    public strictfp void sendTeamData(PlayerConnect var1) {
        if (!this.isServer) {
            this.printLog("sendUpdatePlayer: we are not a server!");
        } else {
            this.O();
            Iterator var2 = this.socketList.iterator();

            while(var2.hasNext()) {
                PlayerConnect var3 = (PlayerConnect)var2.next();
                if (var3.p) {
                    GameOutputStream var4 = new GameOutputStream(var3.clientVersion);

                    try {
                        var4.writeInt(var3.c());
                        int var5 = PlayerData.c;
                        boolean var6 = false;
                        if (var4.getPacketVersion() >= 90) {
                            boolean var7 = false;
                            if (var4.getPacketVersion() >= 141) {
                                var7 = true;
                                if (this.ingame && var3.Q) {
                                    var6 = true;
                                }

                                var4.writeBoolean(var6);
                            }

                            var4.writeInt(var5);
                            var4.startBlock("teams", var7);
                        } else {
                            var5 = 8;
                            if (!this.v) {
                                this.printLog("sendUpdatePlayer: warning saving with lower team count");
                            }
                        }

                        int var12 = 0;

                        while(true) {
                            if (var12 >= var5) {
                                if (var4.getPacketVersion() >= 90) {
                                    var4.endBlock("teams");
                                }

                                var4.writeInt(this.gameMapData.fog);
                                var4.writeInt(this.gameMapData.credits);
                                var4.writeBoolean(this.gameMapData.e);
                                var4.writeInt(this.gameMapData.aidiff);
                                var4.writeByte(5);
                                var4.writeInt(this.aw);
                                var4.writeInt(this.ax);
                                var4.writeInt(this.gameMapData.initUnit);
                                var4.writeFloat(this.gameMapData.income);
                                var4.writeBoolean(this.gameMapData.nukes);
                                var4.writeBoolean(this.gameMapData.j);
                                var4.writeBoolean(false);
                                var4.writeBoolean(this.gameMapData.sharedControl);
                                var4.writeBoolean(this.al);
                                break;
                            }

                            PlayerData var8 = PlayerData.getPlayerData(var12);
                            var4.writeBoolean(var8 != null);
                            if (var8 != null) {
                                byte var9 = 0;
                                if (var8 instanceof class_138) {
                                    var9 = 1;
                                }

                                var4.writeInt(var9);
                                if (var6) {
                                    var8.c(var4);
                                } else {
                                    var8.b(var4);
                                }
                            }

                            ++var12;
                        }
                    } catch (Exception var10) {
                        throw new RuntimeException(var10);
                    }

                    short var11 = -1;
                    if (var1 == var3 && var3.clientVersion <= 26) {
                        var11 = 1000;
                    }

                    var3.Q = true;
                    this.a(var3, var4.a(115, var11));
                }
            }

        }
    }

    public strictfp void a(PlayerConnect var1, int var2, int var3) {
        GameOutputStream var4 = new GameOutputStream();

        try {
            var4.writeByte(0);
            var4.writeInt(var2);
            var4.writeInt(var3);
        } catch (Exception var6) {
            throw new RuntimeException(var6);
        }

        this.a(var1, var4.getPacket(4));
    }

    public strictfp synchronized boolean R() {
        if (this.S()) {
            this.p = true;
            this.gameMapData.fog = 0;
            return true;
        } else {
            return false;
        }
    }

    public strictfp synchronized boolean S() {
        if (this.B) {
            this.closeServer("Started singleplayer");
        }

        GameEngine var1 = GameEngine.getGameEngine();
        this.r();
        this.B = true;
        this.isServer = true;
        this.F = true;
        this.gameMapData.mapType = var1.an();
        this.gameMapData.mapName = var1.am();
        this.aa();
        this.z = var1.playerTeam;
        class_195.o();
        this.port = var1.settingsEngine.networkPort;
        this.printLog("singleplayer server started");
        return true;
    }

    private strictfp void aA() {
        this.gameMapData.q = class_340.rand(1, 1000000000);
    }

    public strictfp synchronized boolean startNet(boolean var1) {
        if (this.B) {
            throw new RuntimeException("networking already started");
        } else {
            this.q();
            this.B = true;
            this.isServer = true;
            this.aa();
            this.aA();
            GameEngine var2 = GameEngine.getGameEngine();
            this.c(var1);
            class_195.o();
            this.port = var2.settingsEngine.networkPort;
            SteamEngine.getSteamEngine().i();
            this.tcpAccept = new ServerAcceptRunnable(this);

            try {
                this.tcpAccept.startServerSocket(false);
            } catch (Exception var6) {
                var6.printStackTrace();
                var2.log("Could not open tcp port:" + this.port + ", check this port is not in use or change the port in the game settings", 1);
                this.closeServer("Could not open tcp port");
                return false;
            }

            this.tcpThread = new Thread(this.tcpAccept);
            this.tcpThread.setDaemon(true);
            this.tcpThread.start();
            boolean var3 = true;
            if (var3) {
                this.udpAccept = new ServerAcceptRunnable(this);

                try {
                    this.udpAccept.startServerSocket(true);
                } catch (Exception var5) {
                    var5.printStackTrace();
                    var2.log("Could not open udp port:" + this.port + ", check this port is not in use or change the port in the game settings", 1);
                    this.closeServer("Could not open udp port");
                    return false;
                }

                this.udpThread = new Thread(this.udpAccept);
                this.udpThread.start();
            }

            this.am();
            if (this.publicRoom) {
                GameNetAPIOperate.b();
            }

            this.aV = null;
            if (r) {
                GameNetAPIOperate.a();
            }

            this.printLog("server started");
            return true;
        }
    }

    public strictfp void c(boolean var1) {
        this.isServer = true;
        GameEngine var2 = GameEngine.getGameEngine();
        if (this.z == null) {
            Player var4 = null;
            int var3;
            if (!var1) {
                var3 = PlayerData.getNullSite();
                if (var3 == -1) {
                    throw new RuntimeException("playerId is -1 for server player");
                }
            } else {
                var4 = this.bk;
                var3 = this.bk.site;
            }

            if (var4 == null) {
                var4 = new Player(var3);
                var4.name = this.y;
                var2.playerTeam = var4;
            }

            this.z = var4;
        }

        if (this.pingTask == null) {
            GameEngine.log("pingerTask starting");
            this.pingTask = new PingTask(this);
            this.PingTaskTimer = new Timer();
            this.PingTaskTimer.schedule(this.pingTask, 100L, 100L);
        } else {
            GameEngine.log("pingerTask already active");
        }

        class_195.o();
    }

    public strictfp boolean T() {
        GameEngine var1 = GameEngine.getGameEngine();
        return var1.settingsEngine.udpInMultiplayer;
    }

    public strictfp class_1016 a(String var1, boolean var2, Runnable var3) {
        class_1016 var4 = new class_1016(var1, var2, var3);
        var4.b();
        return var4;
    }

    @SneakyThrows
    public static strictfp Socket getSocketAndResolveIp(String var0, boolean var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        GameEngine.log("Connect to server: " + var0 + " (force tcp:" + var1 + ")");
        boolean var3 = false;
        String var4 = var0.trim();
        String var6;
        String var7;
        String var12;
        int var31;
        if (var4.startsWith("get|")) {
            String[] var30 = var4.split("\\|");

            boolean var33;
            try {
                var6 = var30[0];
                var7 = var30[1];
                var31 = Integer.parseInt(var30[2]);
                var33 = Boolean.parseBoolean(var30[3]);
                int var35 = Integer.parseInt(var30[4]);
            } catch (NumberFormatException var21) {
                var21.printStackTrace();
                var12 = "Bad server connect string";
                throw new IOException(var12);
            }

            if (var33) {
                var2.netEngine.passwd = null;
                Object var11 = new Object();
                GameNetEngine$1 var37 = new GameNetEngine$1(var11);
                GameEngine.log("Asking for password..");
                synchronized(var11) {
                    a((EnterPasswordCallback)var37);

                    try {
                        var11.wait();
                    } catch (InterruptedException var19) {
                        var19.printStackTrace();
                    }
                }

                if (var2.netEngine.passwd == null) {
                    GameEngine.print("No password entered");
                    throw new class_980();
                }

                GameEngine.log("Password has been entered");
            }

            String var36 = null;
            if (var33) {
                var36 = var2.netEngine.passwd;
                if (var36 == null) {
                    throw new IOException("This server requires a password but no password was provided");
                }
            }

            Object var38 = new Object();
            GameNetEngine$2 var13 = new GameNetEngine$2(var38);
            synchronized(var38) {
                GameNetAPIOperate.getGameServerInfoFromMasterServer(var13, var7, var31, var36);

                try {
                    var38.wait(15000L);
                } catch (InterruptedException var17) {
                }
            }

            if (var13.b != null) {
                throw new IOException(var13.b);
            } else if (var13.a == null) {
                throw new IOException("Failed to get game server info.");
            } else {
                Socket var14 = getSocketAndResolveIp(var13.a, var1);
                return var14;
            }
        } else {
            if (var4.toLowerCase(Locale.ENGLISH).endsWith(".relay")) {
                var4 = var4 + ".corrodinggames.com";
            }

            if (var4.startsWith("[TCP]")) {
                var4 = var4.substring("[TCP]".length());
                var1 = true;
            }

            String var5;
            if (var4.length() > 4 && !var4.contains(":") && !var4.contains(".") && !var4.equals("localhost") && !var4.contains("/") && !var4.contains("\\")) {
                var5 = ".relay.corrodinggames.com";
                var6 = "" + var4.charAt(0);
                var7 = var6 + var5 + "/" + var4;
                GameEngine.log("Converting connect string to: " + var7);
                var4 = var7;
            }

            var2.netEngine.L = null;
            String var8;
            int var27;
            if (var4.contains("/") || var4.contains("\\")) {
                int var26 = var4.indexOf("/");
                var27 = var4.indexOf("\\");
                if (var26 == -1) {
                    var26 = var4.length();
                }

                if (var27 == -1) {
                    var27 = var4.length();
                }

                int var28 = class_340.c(var26, var27);
                var8 = var4.substring(var28 + 1);
                var8 = var8.trim();
                if (!var8.equals("")) {
                    var2.netEngine.L = var8;
                }

                var4 = var4.substring(0, var28);
            }

            var5 = var4;
            var27 = 5123;
            String[] var29 = var4.split(":");
            if (var29.length > 1) {
                var5 = null;

                for(var31 = 0; var31 < var29.length - 1; ++var31) {
                    if (var5 == null) {
                        var5 = "";
                    } else {
                        var5 = var5 + ":";
                    }

                    var5 = var5 + var29[var31];
                }

                var8 = var29[var29.length - 1];

                try {
                    var27 = Integer.parseInt(var8);
                } catch (NumberFormatException var23) {
                    String var10 = "Bad port number:" + var8;
                    var23.printStackTrace();
                    throw new IOException(var10);
                }
            }

            if (!var1 && var2.netEngine.T()) {
                var3 = true;
            }

            short var9 = 7000;
            GameEngine.log("");
            GameEngine.log("===============================");
            GameEngine.log("Connect to: " + var4);
            Object var32;
            if (!var3) {
                var32 = new Socket();
                GameEngine.log("connecting to Server.. (tcp)");
            } else {
                var32 = new ReliableSocket();
                GameEngine.log("connecting to Server.. (udp)");
                var9 = 5000;
            }

            ((Socket)var32).setTcpNoDelay(true);

            InetSocketAddress var34;
            try {
                var34 = new InetSocketAddress(InetAddress.getByName(var5), var27);
            } catch (IllegalArgumentException var22) {
                var12 = "Incorrect server format";
                GameEngine.print("IllegalArgumentException.." + var12);
                var22.printStackTrace();
                throw new IOException(var12, var22);
            }

            try {
                ((Socket)var32).connect(var34, var9);
                return (Socket)var32;
            } catch (UnknownHostException var24) {
                var12 = "Failed to connect to host";
                if (var3) {
                    var12 = var12 + " (udp)";
                }

                GameEngine.log("UnknownHostException.." + var12);
                var24.printStackTrace();
                throw new IOException(var12, var24);
            } catch (IOException var25) {
                var12 = "Failed to connect to host";
                if (var3) {
                    var12 = var12 + " (udp)";
                }

                var12 = var12 + " - " + var25.getMessage();
                GameEngine.log("IOException.." + var12);
                var25.printStackTrace();
                throw new IOException(var12, var25);
            }
        }
    }

    public strictfp void U() {
        GameEngine var1 = GameEngine.getGameEngine();
        class_177 var2 = class_177.a(class_1009.a("menus.ingame.multiplayerReconnect.message"), false);
        var2.a(class_1009.a("menus.ingame.resume"), new GameNetEngine$3(this, var2));
        var2.a(class_1009.a("menus.ingame.reconnect"), new GameNetEngine$4(this, var2));
        var2.a(class_1009.a("menus.ingame.disconnect"), new GameNetEngine$5(this, var2, var1));
        var1.bS.a(var2);
        this.bx = true;
    }

    public strictfp synchronized boolean V() {
        Socket var1 = this.bv;
        if (var1 == null) {
            GameEngine.log("reconnectToServer: lastConnectedTo==null");
            return false;
        } else {
            GameEngine.log("reconnectToServer attempted");
            if (this.B) {
                GameEngine.log("reconnectToServer: disconnecting");
                this.closeServer("reconnecting");
            }

            if (var1.getInetAddress() == null) {
                GameEngine.log("reconnectToServer: lastConnectedTo.getInetAddress()==null");
                return false;
            } else {
                String var2 = var1.getInetAddress().getHostAddress();
                int var3 = var1.getPort();
                String var4 = var2 + ":" + var3;
                GameEngine.log("reconnectToServer: connecting to: " + var4);

                try {
                    boolean var6 = false;
                    Socket var5 = getSocketAndResolveIp(var4, var6);
                    boolean var7 = this.bindSocket(var5);
                    return var7;
                } catch (Exception var8) {
                    var8.printStackTrace();
                    return false;
                }
            }
        }
    }

    public strictfp synchronized boolean bindSocket(Socket var1) {
        if (this.B) {
            this.closeServer("starting new");
        }

        if (var1 == null) {
            throw new RuntimeException("connectedSocket==null");
        } else {
            this.q();
            GameEngine var2 = GameEngine.getGameEngine();
            this.port = var1.getPort();
            this.B = true;
            this.isServer = false;
            this.printLog("connected to Server..");
            PlayerConnect var3 = new PlayerConnect(this, var1);
            var3.p = true;
            var3.d();
            this.socketList.add(var3);
            this.f(var3);
            this.am();
            this.bv = var1;
            return true;
        }
    }

    public strictfp PlayerConnect c(PlayerData var1) {
        Iterator var2 = this.socketList.iterator();

        PlayerConnect var3;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            var3 = (PlayerConnect)var2.next();
        } while(var3.player != var1);

        return var3;
    }

    public strictfp PlayerConnect d(PlayerData var1) {
        Iterator var2 = this.socketList.iterator();

        PlayerConnect var3;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            var3 = (PlayerConnect)var2.next();
        } while(var3.a || var3.player != var1);

        return var3;
    }

    public strictfp PlayerConnect W() {
        if (this.isServer) {
            return null;
        } else {
            Iterator var1 = this.socketList.iterator();

            PlayerConnect var2;
            do {
                if (!var1.hasNext()) {
                    return null;
                }

                var2 = (PlayerConnect)var1.next();
            } while(var2.a);

            return var2;
        }
    }

    public strictfp void d(Packet var1) {
        if (!this.B) {
            GameEngine.log("Skipping sendPacketToAll, not networked");
        } else {
            this.i(var1);
        }
    }

    private strictfp void i(Packet var1) {
        Iterator var2 = this.socketList.iterator();

        while(var2.hasNext()) {
            PlayerConnect var3 = (PlayerConnect)var2.next();
            if (var3.p && !var3.a && !var3.s) {
                var3.a(var1);
            }
        }

    }

    public strictfp void e(Packet var1) {
        if (!this.B) {
            GameEngine.log("Skipping sendPacketToAllIncludingRelay, not networked");
        } else {
            Iterator var2 = this.socketList.iterator();

            while(var2.hasNext()) {
                PlayerConnect var3 = (PlayerConnect)var2.next();
                if (var3.p && !var3.a) {
                    var3.a(var1);
                }
            }

        }
    }

    public strictfp void f(Packet var1) {
        if (!this.B) {
            GameEngine.log("Skipping sendPacketToServer, not networked");
        } else if (this.isServer) {
            throw new RuntimeException("We are a server");
        } else {
            this.d(var1);
        }
    }

    public strictfp void sendPacket(Packet var1) {
        if (!this.B) {
            GameEngine.log("Skipping sendPacketToClients, not networked");
        } else if (!this.isServer) {
            throw new RuntimeException("We are not a server");
        } else {
            this.e(var1);
        }
    }

    public strictfp void h(Packet var1) {
        if (!this.B) {
            GameEngine.log("Skipping sendPacketToClients, not networked");
        } else if (!this.isServer) {
            throw new RuntimeException("We are not a server");
        } else {
            this.d(var1);
        }
    }

    public strictfp void a(PlayerConnect var1, Packet var2) {
        if (!this.B) {
            GameEngine.log("Skipping sendPacketOnConnection, not networked");
        } else {
            var1.a(var2);
        }
    }

    public strictfp void X() {
        if (this.isServer) {
            this.printLog("registerConnection: We are a server");
        }

        Iterator var1 = this.socketList.iterator();

        while(var1.hasNext()) {
            PlayerConnect var2 = (PlayerConnect)var1.next();
            this.h(var2);
        }

    }

    public strictfp void Y() {
        GameEngine var1 = GameEngine.getGameEngine();
        var1.settingsEngine.networkClientId = null;
        if (this.S == null) {
            GameEngine.log("generateNewClientId: serverUUID==null");
            this.S = "x";
        }

        this.Z();
        var1.settingsEngine.save();
    }

    public strictfp String Z() {
        GameEngine var1 = GameEngine.getGameEngine();
        boolean var2 = false;
        if (var1.settingsEngine.networkClientId == null) {
            var2 = true;
        }

        String var3;
        if (!this.by) {
            this.by = true;
            if (GameEngine.av()) {
                var3 = this.ak();
                if (!var3.equals(var1.settingsEngine.networkClientIdMachineKey)) {
                    if (var1.settingsEngine.networkClientIdMachineKey != null) {
                        GameEngine.log("Machine appears to have changed: " + var1.settingsEngine.networkClientIdMachineKey + " vs " + var3);
                    }

                    var1.settingsEngine.networkClientIdMachineKey = var3;
                    var2 = true;
                }
            }
        }

        if (var2) {
            GameEngine.log("new networkClientId needed");
            var1.settingsEngine.networkClientId = UUID.randomUUID().toString();
            var1.settingsEngine.save();
        }

        var3 = var1.settingsEngine.networkClientId;
        if (this.S == null) {
            throw new RuntimeException("getOwnClientIdHashed: serverUUID==null");
        } else {
            String var4 = class_340.e(var3 + this.S);
            return var4;
        }
    }

    public strictfp void aa() {
        GameEngine var1 = GameEngine.getGameEngine();
        var1.settingsEngine.networkServerId = UUID.randomUUID().toString();
        var1.settingsEngine.save();
    }

    public strictfp String ab() {
        GameEngine var1 = GameEngine.getGameEngine();
        if (var1.settingsEngine.networkServerId == null) {
            this.aa();
        }

        return var1.settingsEngine.networkServerId;
    }

    public strictfp String ac() {
        GameEngine var1 = GameEngine.getGameEngine();
        return this.isServer ? var1.settingsEngine.networkServerId : this.S;
    }

    public strictfp void f(PlayerConnect var1) {
        GameOutputStream var2 = new GameOutputStream();

        try {
            byte var3 = 4;
            byte var4 = 1;
            if (GameEngine.av()) {
                var4 = 2;
            }

            if (GameEngine.aZ) {
                var4 = 3;
            }

            var2.writeString("com.corrodinggames.rts");
            var2.writeInt(var3);
            var2.writeInt(this.e);
            var2.writeInt(var4);
            var2.writeIsString(this.L);
            var2.writeString(this.y);
            var2.writeString(class_1009.c());
            String var5 = "";
            if (GameEngine.aT) {
                var5 = var5 + "d";
            }

            var2.writeString(var5);
        } catch (Exception var6) {
            throw new RuntimeException(var6);
        }

        this.a(var1, var2.getPacket(160));
    }

    public strictfp void g(PlayerConnect var1) {
        GameOutputStream var2 = new GameOutputStream();

        try {
            GameEngine var3 = GameEngine.getGameEngine();
            var2.writeString("com.corrodinggames.rts");
            var2.writeInt(2);
            var2.writeInt(this.e);
            var2.writeInt(var3.c(true));
            var2.writeString(var3.l());
            var2.writeString(this.ab());
            var2.writeInt(var1.connectKey);
            var2.writeInt(this.W);
            var2.writeInt(0);
        } catch (Exception var4) {
            throw new RuntimeException(var4);
        }

        this.a(var1, var2.getPacket(161));
    }

    public strictfp void h(PlayerConnect var1) {
        GameEngine.log("sendRegisterConnection...");
        GameOutputStream var2 = new GameOutputStream();

        try {
            var2.writeString("com.corrodinggames.rts");
            var2.writeInt(5);
            var2.writeInt(this.e);
            GameEngine var3 = GameEngine.getGameEngine();
            var2.writeInt(var3.c(true));
            var2.writeString(this.y);
            String var4 = null;
            if (this.passwd != null) {
                var4 = class_340.e(this.passwd);
            }

            var2.writeIsString(var4);
            var2.writeString(var3.l());
            var2.writeString(this.Z());
            var2.writeInt(var3.z());
            var2.writeString(this.g(this.T));
            var2.writeString(this.h(this.U));
        } catch (Exception var5) {
            throw new RuntimeException(var5);
        }

        this.a(var1, var2.getPacket(110));
        this.bz = true;
    }

    public strictfp String g(int var1) {
        String var2 = "";
        var2 = var2 + "c:" + var1;
        var2 = var2 + "m:" + (var1 * 87 + 24);
        var2 = var2 + "0:" + this.e(0) * 11 * var1;
        var2 = var2 + "1:" + (this.e(1) * 12 + var1);
        var2 = var2 + "2:" + this.e(2) * 13 * var1;
        var2 = var2 + "3:" + (this.e(3) * 14 + var1);
        var2 = var2 + "4:" + this.e(4) * 15 * var1;
        var2 = var2 + "5:" + (this.e(5) * 16 + var1);
        var2 = var2 + "6:" + this.e(6) * 17 * var1;
        var2 = var2 + "7:" + this.e(7) * 18 * var1;
        var2 = var2 + "8:" + this.e(8) * 19 * var1;
        var2 = var2 + "t1:" + PlayerData.j.credits * 11.0 * (double)var1;
        int var3 = 5 * var1;
        if (this.k() != this.e(this.gameMapData.credits)) {
            var3 = 7 * var1;
        }

        var2 = var2 + "d:" + var3;
        return var2;
    }

    public strictfp String h(int var1) {
        return class_340.h(var1);
    }

    public strictfp void ad() {
        if (this.isServer) {
            throw new RuntimeException("We are a server");
        } else {
            GameEngine var1 = GameEngine.getGameEngine();
            GameOutputStream var2 = new GameOutputStream();

            try {
                var2.writeBoolean(this.bG);
                var2.writeBoolean(var1.bq);
            } catch (Exception var4) {
                throw new RuntimeException(var4);
            }

            this.f(var2.getPacket(112));
        }
    }

    public strictfp void j(String var1) {
        if (!this.isServer) {
            this.printLog("cannot send sendSystemMessage:" + var1 + ", we are not a server");
        } else if (this.B && !this.F) {
            GameEngine.log("sendSystemMessage:" + var1);
            this.a((PlayerConnect)null, (PlayerData)null, (String)null, var1);
        } else {
            this.printLog("cannot send sendSystemMessage:" + var1 + ", not networked");
        }
    }

    public strictfp void k(String var1) {
        this.m("-qc " + var1);
    }

    public strictfp void l(String var1) {
        boolean var2 = true;
        String var3 = null;
        if (var1 != null) {
            String var4 = var1.trim();
            if ((var4.startsWith("-") || var4.startsWith(".") || var4.startsWith("_")) && var4.length() >= 2) {
                String var5 = var4.substring(1).trim();
                int var6 = var5.indexOf(" ");
                if (var6 == -1) {
                    var6 = var5.length();
                }

                var3 = var5.substring(0, var6).toLowerCase(Locale.ENGLISH);
            }
        }

        if ("share".equals(var3)) {
            var2 = false;
        }

        if ("t".equals(var3)) {
            var2 = false;
        }

        if (var2) {
            var1 = "-t " + var1;
        }

        this.m(var1);
    }

    public strictfp void m(String var1) {
        if (!this.B) {
            GameEngine.log("sendChatMessage: not networked:" + var1);
            this.b((PlayerConnect)null, -1, (String)null, var1);
        } else if (this.isServer) {
            this.a((PlayerConnect)null, this.z, this.y, var1);
            this.b((PlayerConnect)null, this.z, this.y, var1);
        } else {
            try {
                GameOutputStream var2 = new GameOutputStream();
                var2.writeString(var1);
                var2.writeByte(0);
                this.f(var2.getPacket(140));
            } catch (Exception var3) {
                throw new RuntimeException(var3);
            }
        }
    }

    public strictfp void a(PlayerConnect var1, PlayerData var2, String var3, String var4) {
        this.a(var1, var2, var3, var4, (PlayerConnect)null);
    }

    public strictfp void a(PlayerConnect var1, PlayerData var2, String var3, String var4, PlayerConnect var5) {
        try {
            boolean var6 = false;
            boolean var7 = false;
            String var8 = n(var4);
            if ("t".equalsIgnoreCase(var8)) {
                if (var2 != null) {
                    var6 = true;
                    var4 = var4.substring("-t".length());
                    var4 = "[TEAM] " + var4;
                } else {
                    GameEngine.print("toOnlyTeams failed team==null");
                }
            }

            if (var2 != null && "surrender".equalsIgnoreCase(var8)) {
                var6 = true;
                var4 = "[TEAM] " + var4;
            }

            if (var2 != null && "i".equalsIgnoreCase(var8)) {
                var7 = true;
                var4 = var4.substring("-i".length());
                var4 = "[INFO] " + var4;
            }

            if (var2 != null && "qc".equalsIgnoreCase(var8)) {
                var7 = true;
                var4 = var4.substring("-qc".length());
                var4 = "[COMMAND] " + var4;
            }

            if (!var7 && var2 != null && var2 != this.bj && var2 != this.bk && !this.d.a(var1, var2, var4, var6)) {
                var7 = true;
            }

            GameOutputStream var9 = new GameOutputStream();
            var9.writeString(var4);
            var9.writeByte(3);
            var9.writeIsString(var3);
            var9.a(var1);
            int var10 = -1;
            if (var2 != null) {
                var10 = var2.site;
            }

            var9.writeInt(var10);
            Packet var11 = var9.getPacket(141);
            if (var6) {
                Iterator var12 = this.socketList.iterator();

                while(var12.hasNext()) {
                    PlayerConnect var13 = (PlayerConnect)var12.next();
                    if (var13.p && !var13.a) {
                        Player var14 = var13.player;
                        if (var14 != null && var14.d(var2)) {
                            var13.a(var11);
                        }
                    }
                }

                PlayerData var16 = this.z;
                if (var16 != null && var16.d(var2)) {
                    this.b(var1, var10, var3, var4);
                }
            } else if (var7) {
                GameEngine.print("info message:" + c(var3, var4));
            } else {
                if (var5 != null) {
                    this.a(var5, var11);
                } else {
                    this.sendPacket(var11);
                }

                this.b(var1, var10, var3, var4);
            }

        } catch (Exception var15) {
            throw new RuntimeException(var15);
        }
    }

    public static strictfp String n(String var0) {
        if (var0 == null) {
            return null;
        } else {
            String var1 = var0.trim();
            if ((var1.startsWith("-") || var1.startsWith(".") || var1.startsWith("_")) && var1.length() >= 2) {
                String var2 = var1.substring(1).trim();
                int var3 = var2.indexOf(" ");
                if (var3 == -1) {
                    var3 = var2.length();
                }

                return var2.substring(0, var3).toLowerCase(Locale.ENGLISH);
            } else {
                return null;
            }
        }
    }

    public static strictfp String c(String var0, String var1) {
        return var0 != null ? var0 + ": " + var1 : var1;
    }

    public strictfp void o(String var1) {
        var1 = class_1009.c(var1);
        byte var2 = -1;
        Object var3 = null;
        Object var4 = null;
        this.aC.a(var2, (String)var3, var1, (PlayerConnect)var4);
        this.d.a(var2, (String)var3, var1, (PlayerConnect)var4);
        boolean var5 = false;
        if (this.ingame) {
            var5 = true;
        }

        if (!this.B) {
            var5 = true;
        }

        if (var5) {
            a((String)var3, (String)var1);
        } else {
            String var6 = c((String)var3, var1);
            if (!GameEngine.isModsInSD) {
                class_195.d(var6);
            }
        }

    }

    private strictfp void b(PlayerConnect var1, int var2, String var3, String var4) {
        if (this.B || !var4.startsWith("-i ")) {
            if (this.B || !var4.startsWith("-qc ")) {
                var4 = class_1009.c(var4);
                if (var3 != null) {
                    boolean var5 = true;
                    if (var4 != null) {
                        if (var4.equals("-surrender")) {
                        }

                        if (this.z != null && var2 >= 0 && this.z.site == var2) {
                        }
                    }

                    if (var5) {
                        this.d("New Message", var3 + ": " + var4);
                    }
                }

                PlayerConnect var8 = null;
                if (this.isServer) {
                    var8 = var1;
                }

                this.aC.a(var2, var3, var4, var8);
                this.d.a(var2, var3, var4, var1);
                boolean var6 = false;
                if (this.ingame) {
                    var6 = true;
                }

                if (!this.B) {
                    var6 = true;
                }

                if (var6) {
                    a(var3, var4);
                } else {
                    String var7 = c(var3, var4);
                    if (!GameEngine.isModsInSD) {
                        class_195.d(var7);
                    }
                }

            }
        }
    }

    public strictfp void a(PlayerConnect var1, byte[] var2, boolean var3, boolean var4) {
        GameEngine var5 = GameEngine.getGameEngine();

        try {
            GameOutputStream var6 = new GameOutputStream();
            var6.writeByte(0);
            var6.writeInt(var5.tick);
            var6.writeInt(var5.by);
            var6.writeFloat(this.getCurrentStepRate());
            var6.writeFloat(1.0F);
            var6.writeBoolean(var3);
            var6.writeBoolean(var4);
            var6.e("gameSave");
            var6.b(var2);
            var6.endBlock("gameSave");
            Packet var7 = var6.getPacket(35);
            this.a(var1, var7);
        } catch (Exception var8) {
            throw new RuntimeException(var8);
        }
    }

    public strictfp void resync(boolean var1, boolean var2, boolean var3) {
        GameEngine var4 = GameEngine.getGameEngine();

        try {
            GameOutputStream var5 = new GameOutputStream();
            var5.writeByte(0);
            var5.writeInt(var4.tick);
            var5.writeInt(var4.by);
            var5.writeFloat(this.getCurrentStepRate());
            var5.writeFloat(1.0F);
            var5.writeBoolean(var1);
            var5.writeBoolean(var2);
            var5.e("gameSave");
            var4.ca.a(var5);
            var5.endBlock("gameSave");
            if (var1) {
            }

            Packet var6 = var5.getPacket(35);
            this.d(var6);
            if (var3) {
                if (!this.isServer) {
                    throw new RuntimeException("sendResyncSave: reloadCreatedSave: We are not a server");
                }

                var6.playerConnect = this.aL;
                this.resolveSystemCommandPacket(var6);
            }

        } catch (Exception var7) {
            throw new RuntimeException(var7);
        }
    }

    public strictfp boolean ae() {
        this.Q();
        this.L();
        return this.sendStartGamePacket((PlayerConnect)null, false);
    }

    public strictfp boolean sendStartGamePacket(PlayerConnect var1, boolean var2) {
        GameEngine.log("Sending start game.... ");

        if (!this.isServer) {
            throw new RuntimeException("We are not a server");
        } else {
            GameEngine var3 = GameEngine.getGameEngine();
            GameOutputStream var4 = new GameOutputStream();

            try {
                var4.writeByte(0);
                var4.writeSimilarEnum(this.gameMapData.mapType);
                if (this.gameMapData.mapType == MapType.savedGame) {
                    try {
                        var3.ca.a(this.gameMapData.mapName, var4);
                    } catch (Exception var7) {
                        var7.printStackTrace();
                        var3.c("Map error starting game", "Map error: " + var7.getMessage());
                        return false;
                    }

                    var4.writeString("SAVE:" + this.gameMapData.mapName);
                } else if (this.gameMapData.mapType == MapType.customMap) {
                    GameEngine.log("Starting with custom map: " + this.l());

                    try {
                        class_484.a(this.az, var4);
                    } catch (Exception var6) {
                        var6.printStackTrace();
                        var3.c("Map error starting game", "Map error: " + var6.getMessage());
                        return false;
                    }

                    var4.writeString("STEAM:" + this.l());
                } else {
                    var4.writeString(this.l());
                }

                var4.writeBoolean(var2);
            } catch (Exception var8) {
                throw new RuntimeException(var8);
            }

            Packet var5 = var4.getPacket(120);
            if (var1 == null) {
                this.sendPacket(var5);
            } else {
                this.a(var1, var5);
            }

            if (!this.ingame) {
                this.aB();
            }

            return true;
        }
    }

    public strictfp void af() {
        this.bc = true;
        GameEngine.log("onStartGameFailed");
        if (this.isServer) {
            this.ingame = false;
            this.j("Map load failed.");
        } else {
            this.closeServer("Map load failed");
        }

    }

    private strictfp void aB() {
        this.aY = false;
        this.ingame = true;
        this.bc = false;
        this.bd = false;
        GameEngine.log("Starting new network game (" + this.ac() + ")");
        if (this.publicRoom && this.isServer) {
            GameNetAPIOperate.c();
        }

        if (!GameEngine.isModsInSD) {
            class_195.p();
        }

        this.d.startGame();
    }

    public strictfp void ag() {
        this.d(5.0F);
    }

    public strictfp void d(float var1) {
        if (!this.isServer) {
            throw new RuntimeException("We are not a server");
        } else if (!this.aZ) {
            GameEngine.log("Setting up return to battleroom timer...");
            this.ba = var1;
            this.aZ = true;
            this.j("Game ended by host. Returning to battleroom in " + (int)var1 + " seconds...");
        }
    }

    public strictfp void i(PlayerConnect var1) {
        if (!this.isServer) {
            throw new RuntimeException("We are not a server");
        } else {
            try {
                GameOutputStream var2 = new GameOutputStream();
                var2.writeByte(0);
                Packet var3 = var2.getPacket(122);
                if (var1 == null) {
                    this.h(var3);
                } else {
                    this.a(var1, var3);
                }
            } catch (Exception var4) {
                throw new RuntimeException(var4);
            }

            this.aC();
        }
    }

    private strictfp void aC() {
        this.aY = true;
    }

    private strictfp void aD() {
        GameEngine.log("----- returnToBattleroom -----");
        this.aY = false;
        GameEngine var1 = GameEngine.getGameEngine();
        var1.replayEngine.close();
        PlayerData var2 = this.z;
        var1.g();
        this.s();
        this.z = var2;
        var1.tick = 0;
        var1.by = 0;
        this.A();
        PlayerData.n();
        if (this.isServer) {
            this.aA();
        }

        this.J();
        if (this.publicRoom && this.isServer) {
            GameNetAPIOperate.c();
        }

        if (!GameEngine.isModsInSD) {
        }

    }

    public strictfp String ah() {
        ArrayList var1 = this.aj();
        return var1 != null && var1.size() != 0 ? (String)var1.get(0) : null;
    }

    public strictfp String ai() {
        ArrayList var1 = this.aj();
        if (var1 != null && var1.size() != 0) {
            String var2 = "";
            boolean var3 = true;

            String var5;
            for(Iterator var4 = var1.iterator(); var4.hasNext(); var2 = var2 + var5) {
                var5 = (String)var4.next();
                if (var3) {
                    var3 = false;
                } else {
                    var2 = var2 + ", ";
                }
            }

            return var2;
        } else {
            return null;
        }
    }

    public strictfp ArrayList aj() {
        if (bA != null) {
            return new ArrayList(bA);
        } else {
            long var1 = Unit.loadAllUnitsTook();
            ArrayList var3 = null;
            ArrayList var4 = this.d(true);
            if (var4 != null && var4.size() > 0) {
                var3 = var4;
            } else {
                var3 = this.d(false);
            }

            double var5 = (double)Unit.a(var1);
            if (var5 > 2.0) {
                GameEngine.print("getLocalIpAddressList was slow, taking:" + Unit.a(var5));
            }

            if (var5 > 10.0 && var3 != null && var3.size() > 0) {
                GameEngine.log("getLocalIpAddressList: creating cache");
                bA = new ArrayList(var3);
            }

            return var3;
        }
    }

    public strictfp String ak() {
        String var1 = null;

        try {
            Enumeration var2 = NetworkInterface.getNetworkInterfaces();

            while(var2.hasMoreElements()) {
                NetworkInterface var3 = (NetworkInterface)var2.nextElement();
                byte[] var4 = var3.getHardwareAddress();
                if (var4 != null) {
                    String var5 = new String(var4);
                    var5 = var5.trim();
                    if (var5.length() > 2) {
                        var1 = var5;
                        break;
                    }
                }
            }
        } catch (Exception var6) {
            var6.printStackTrace();
        }

        return var1 != null ? class_340.c(var1) : "[blank]";
    }

    public strictfp ArrayList d(boolean var1) {
        ArrayList var2 = new ArrayList();

        try {
            Enumeration var3 = NetworkInterface.getNetworkInterfaces();

            while(var3.hasMoreElements()) {
                NetworkInterface var4 = (NetworkInterface)var3.nextElement();
                Enumeration var5 = var4.getInetAddresses();

                while(var5.hasMoreElements()) {
                    InetAddress var6 = (InetAddress)var5.nextElement();
                    if (!var6.isLoopbackAddress()) {
                        String var7 = var6.getHostAddress().toString();
                        if (!var7.contains("%")) {
                            if (!var1) {
                                var2.add(var7);
                            } else if (var7.contains(".")) {
                                var2.add(var7);
                            }
                        }
                    }
                }
            }
        } catch (SocketException var8) {
            Log.d("RustedWarfare", var8.toString());
        }

        return var2;
    }

    strictfp InetAddress al() {
        try {
            GameEngine var1 = GameEngine.getGameEngine();
            WifiManager var2 = (WifiManager)var1.am.c("wifi");
            DhcpInfo var3 = var2.getDhcpInfo();
            int var4 = var3.ipAddress & var3.netmask | ~var3.netmask;
            byte[] var5 = new byte[4];

            for(int var6 = 0; var6 < 4; ++var6) {
                var5[var6] = (byte)(var4 >> var6 * 8 & 255);
            }

            return InetAddress.getByAddress(var5);
        } catch (UnknownHostException var7) {
            var7.printStackTrace();
            return null;
        }
    }

    public strictfp void d(String var1, String var2) {
        if (!GameEngine.isModsInSD) {
            GameEngine var3 = GameEngine.getGameEngine();
            if (!this.F && !var3.replayEngine.j()) {
                boolean var4 = class_195.l();
                class_0 var5 = var3.ao;
                if (var5 != null && !var5.e()) {
                    var4 = true;
                }

                if (var4) {
                    if (this.bB) {
                        this.i(2);
                    }

                } else {
                    NotificationManager var6 = (NotificationManager)var3.am.c("notification");
                    Intent var7 = new Intent(var3.am, class_193.class);
                    PendingIntent var8 = PendingIntent.getActivity(var3.am, 0, var7, 2);
                    if (VERSION.SDK_INT >= 11) {
                        Notification.Builder var9 = new Notification.Builder(var3.am);
                        var9.setContentTitle("Rusted Warfare Multiplayer");
                        var9.setContentText(var1 + ": " + var2);
                        var9.setSmallIcon(AssetsID$drawable.icon);
                        var9.setContentIntent(var8);
                        var9.setOngoing(false);
                        var9.setAutoCancel(true);
                        this.a(var6);
                        this.a(var9, "multiplayerChatId");
                        Notification var10 = var9.getNotification();
                        var6.notify(2, var10);
                        this.bB = true;
                    }

                }
            }
        }
    }

    public strictfp void am() {
        GameEngine var1 = GameEngine.getGameEngine();
        if (this.B && var1 != null && var1.M()) {
            this.aE();
        } else {
            this.i(1);
            this.i(2);
        }

    }

    private strictfp void a(Notification.Builder var1, String var2) {
        if (VERSION.SDK_INT >= 26) {
            try {
                Method var3 = var1.getClass().getDeclaredMethod("setChannelId", String.class);
                var3.invoke(var1, var2);
            } catch (Exception var4) {
                GameEngine.a((String)"setChannelId failed", (Throwable)var4);
            }
        }

    }

    private strictfp void a(NotificationManager var1) {
        this.a(var1, "multiplayerChatId", "Multiplayer Chat");
        this.a(var1, "multiplayerStatusId", "Multiplayer Status");
    }

    private strictfp void a(NotificationManager var1, String var2, String var3) {
        if (VERSION.SDK_INT >= 26) {
            byte var4 = 3;

            try {
                Class var5 = Class.forName("android.app.NotificationChannel");
                Constructor var6 = var5.getDeclaredConstructor(String.class, CharSequence.class, Integer.TYPE);
                Object var7 = var6.newInstance(var2, var3, Integer.valueOf(var4));
                Method var8 = var1.getClass().getDeclaredMethod("createNotificationChannel", var5);
                var8.invoke(var1, var7);
            } catch (Exception var9) {
                GameEngine.a((String)"Creating notification channel failed", (Throwable)var9);
            }
        }

    }

    private strictfp void aE() {
        if (!GameEngine.isModsInSD) {
            GameEngine var1 = GameEngine.getGameEngine();
            Intent var2 = new Intent(var1.am, class_193.class);
            PendingIntent var3 = PendingIntent.getActivity(var1.am, 0, var2, 2);
            NotificationManager var4 = (NotificationManager)var1.am.c("notification");
            if (VERSION.SDK_INT >= 11) {
                if (VERSION.SDK_INT >= 26) {
                }

                Notification.Builder var5 = new Notification.Builder(var1.am);
                var5.setContentTitle("Rusted Warfare Multiplayer");
                var5.setContentText("A multiplayer game is in progress");
                var5.setSmallIcon(AssetsID$drawable.icon);
                var5.setContentIntent(var3);
                var5.setOngoing(true);
                this.a(var4);
                this.a(var5, "multiplayerStatusId");
                if (VERSION.SDK_INT >= 16) {
                    var5.build();
                }

                Notification var6 = var5.getNotification();
                var4.notify(1, var6);
            }

        }
    }

    private strictfp void i(int var1) {
        if (!GameEngine.isModsInSD) {
            GameEngine var2 = GameEngine.getGameEngine();
            NotificationManager var3 = (NotificationManager)var2.am.c("notification");
            var3.cancel(var1);
        }
    }

    public strictfp int an() {
        int var1 = 0;

        for(int var2 = 0; var2 < PlayerData.c; ++var2) {
            PlayerData var3 = PlayerData.getPlayerData(var2);
            if (var3 != null && !var3.w) {
                ++var1;
            }
        }

        return var1;
    }

    public strictfp int ao() {
        int var1 = 0;

        for(int var2 = 0; var2 < PlayerData.c; ++var2) {
            PlayerData var3 = PlayerData.getPlayerData(var2);
            if (var3 != null) {
                ++var1;
            }
        }

        return var1;
    }

    public strictfp void e(PlayerData var1) {
        if (this.isServer) {
            this.f(var1);
        } else if (this.H) {
            this.k("-kick " + (var1.site + 1));
        } else {
            GameEngine.print("kickTeamAndAttachedPlayer: but not server or proxy controller");
        }

    }

    public strictfp void f(PlayerData var1) {
        if (var1 instanceof class_138) {
            var1.I();
        } else {
            if (this.z == var1) {
                GameEngine.b("kickTeamAndAttachedPlayer", "Cannot kick self");
                return;
            }

            PlayerConnect var2 = this.c(var1);
            if (var2 == null) {
                g("Kick player: cannot find connection for team");
            } else {
                int var3 = GameEngine.getGameEngine().settingsEngine.banTimeInSecondsAfterKick;
                if (var3 > 0) {
                    this.a(var2, "Temporarily banned due to recent kick", var3);
                }

                this.a(var2, "Kicked by host");
                var2.a("Kicked by host");
            }

            var1.I();
        }

        this.P();
        class_195.o();
    }

    public strictfp void ap() {
        GameEngine var1 = GameEngine.getGameEngine();
        if (!this.isServer) {
            GameEngine.b("addAIToGame", "We are not a server");
        } else {
            int var2 = PlayerData.getNullSite();
            if (var2 == -1) {
                var1.log("No free slots for AI", 1);
            }

            class_138 var3 = new class_138(var2);
            var3.name = "AI";
            var3.team = var2 % 2;
            var3.x = this.gameMapData.aidiff;
            this.aq();
            var1.netEngine.d.a((PlayerData)var3);
            var1.netEngine.sendTeamData((PlayerConnect)null);
            class_195.o();
        }
    }

    public strictfp boolean aq() {
        if (!this.isServer && this.B) {
            GameEngine.b("updateNamesOfAI", "We are not a server");
            return false;
        } else {
            boolean var1 = false;

            for(int var2 = 0; var2 < PlayerData.c; ++var2) {
                PlayerData var3 = PlayerData.getPlayerData(var2);
                if (var3 != null && this.b(var3)) {
                    var1 = true;
                }
            }

            return var1;
        }
    }

    public strictfp void setPlayerTeamSynchronized(PlayerData var1, int var2) {
        synchronized(this.bC) {
            this.setPlayerTeam(var1, var2);
        }
    }

    private strictfp void setPlayerTeam(PlayerData var1, int var2) {
        if (var1.site != var2) {
            int var3 = var1.site;
            int var4 = var1.team;
            boolean var5 = false;
            if (var2 == -3) {
                var5 = true;
                var2 = PlayerData.m5451H();
                if (var2 == -1) {
                    e("No free spectator slots");
                    return;
                }
            }

            PlayerData var6 = PlayerData.getPlayerData(var2);
            var1.f(var2);
            var1.team = var4;
            if (var5) {
                var1.team = -3;
            }

            if (var6 != null) {
                int var7 = var6.team;
                var6.f(var3);
                if (var7 == -3) {
                    var6.team = -3;
                } else {
                    var6.team = var4;
                }
            }

            this.M();
            this.P();
        }

    }

    public strictfp void a(Server_type var1) {
        synchronized(this.bC) {
            this.b(var1);
        }
    }

    private strictfp synchronized void b(Server_type var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        if (!var2.netEngine.isServer) {
            GameEngine.log("Not server");
        } else {
            ArrayList var3;
            int var4;
            PlayerData var5;
            int var6;
            int var7;
            int var11;
            if (var1 == Server_type.LAYOUT_2_SIDES) {
                var3 = new ArrayList();

                for(var4 = 0; var4 < PlayerData.c; ++var4) {
                    var5 = PlayerData.getPlayerData(var4);
                    if (var5 != null) {
                        var3.add(var5);
                    }
                }

                Collections.shuffle(var3);
                var4 = var3.size() / 2;
                if (var3.size() % 2 != 0) {
                    var4 += class_340.rand(0, 1);
                }

                if (var4 >= var3.size()) {
                    var4 = var3.size();
                }

                var11 = 0;
                var6 = 0;

                for(var7 = var11; var7 < var4; ++var7) {
                    ((PlayerData)var3.get(var7)).f(var6);
                    var6 += 2;
                    ((PlayerData)var3.get(var7)).team = 0;
                }

                var11 += var4;
                var6 = 1;

                for(var7 = var11; var7 < var3.size(); ++var7) {
                    ((PlayerData)var3.get(var7)).f(var6);
                    var6 += 2;
                    ((PlayerData)var3.get(var7)).team = 1;
                }
            } else if (var1 == Server_type.LAYOUT_3_SIDES) {
                var3 = new ArrayList();

                for(var4 = 0; var4 < PlayerData.c; ++var4) {
                    var5 = PlayerData.getPlayerData(var4);
                    if (var5 != null) {
                        var3.add(var5);
                    }
                }

                Collections.shuffle(var3);
                var4 = var3.size() / 3;
                if (var4 >= var3.size()) {
                    var4 = var3.size();
                }

                byte var12 = 0;
                var6 = 0;

                for(var7 = var12; var7 < var4; ++var7) {
                    PlayerData var8 = (PlayerData)var3.get(var7);
                    var8.f(var6);
                    var8.team = 0;
                    var6 += 3;
                    var3.set(var7, (Object)null);
                }

                var11 = var12 + var4;
                var7 = var11 + var3.size() / 3;
                if (var7 >= var3.size()) {
                    var7 = var3.size();
                }

                if (var11 >= var3.size()) {
                    var11 = var3.size();
                }

                var6 = 1;

                PlayerData var9;
                int var13;
                for(var13 = var11; var13 < var7; ++var13) {
                    var9 = (PlayerData)var3.get(var13);
                    var9.f(var6);
                    var9.team = 1;
                    var6 += 3;
                    var3.set(var13, (Object)null);
                }

                var11 += var4;
                if (var11 >= var3.size()) {
                    var11 = var3.size();
                }

                var6 = 2;

                for(var13 = var11; var13 < var3.size(); ++var13) {
                    var9 = (PlayerData)var3.get(var13);
                    if (var6 >= PlayerData.c) {
                        var9.f(var6);
                        var9.team = 2;
                        var6 += 3;
                        var3.set(var13, (Object)null);
                    }
                }

                for(var13 = 0; var13 < var3.size(); ++var13) {
                    var9 = (PlayerData)var3.get(var13);
                    if (var9 != null) {
                        for(int var10 = 0; var10 < PlayerData.c; ++var10) {
                            if (PlayerData.getPlayerData(var10) == null) {
                                var9.f(var10);
                                var9.team = 2;
                                var3.set(var13, (Object)null);
                            }
                        }
                    }
                }
            } else if (var1 == Server_type.LAYOUT_FFA) {
                var3 = new ArrayList();

                for(var4 = 0; var4 < PlayerData.c; ++var4) {
                    var5 = PlayerData.getPlayerData(var4);
                    if (var5 != null) {
                        var3.add(var5);
                    }
                }

                Collections.shuffle(var3);
                var4 = 0;

                for(var11 = 0; var11 < var3.size(); ++var11) {
                    ((PlayerData)var3.get(var11)).f(var4);
                    ((PlayerData)var3.get(var11)).team = var4++;
                }
            } else {
                if (var1 != Server_type.LAYOUT_SPECTATORS) {
                    throw new RuntimeException("overrideTeamLayout: unhandled layout: " + var1);
                }

                var3 = new ArrayList();

                for(var4 = 0; var4 < PlayerData.c; ++var4) {
                    var5 = PlayerData.getPlayerData(var4);
                    if (var5 != null) {
                        var3.add(var5);
                    }
                }

                Collections.shuffle(var3);
                var4 = 0;

                for(var11 = 0; var11 < var3.size(); ++var11) {
                    var6 = PlayerData.m5451H();
                    if (var6 != -1) {
                        ((PlayerData)var3.get(var11)).f(var6);
                    }

                    ((PlayerData)var3.get(var11)).team = -3;
                    ++var4;
                }
            }

            this.M();
        }
    }

    public strictfp void a(PlayerData var1, int var2, Integer var3) {
        String var4 = "";
        if (var3 != null) {
            var4 = " " + var3;
        }

        if (!this.H && this.z == var1) {
            this.k("-self_move " + (var2 + 1) + var4);
        } else {
            this.k("-move " + (var1.site + 1) + " " + (var2 + 1) + var4);
        }
    }

    public strictfp void b(PlayerData var1, int var2) {
        if (var2 != -1) {
            ++var2;
        }

        if (!this.H && this.z == var1) {
            this.k("-self_team " + var2);
        } else {
            this.k("-team " + (var1.site + 1) + " " + var2);
        }
    }

    public strictfp void g(PlayerData var1) {
        if (!var1.H) {
            var1.H = true;
            String var2 = var1.name;
            if (var2 == null) {
                var2 = "Player - " + (var1.site + 1) + "";
            }

            String var3 = var2 + " is victorious!";
            this.j(var3);
        }

    }

    public strictfp void h(PlayerData var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        boolean var3 = false;
        String var4 = var1.name;
        if (var4 == null) {
            var4 = "Player - " + (var1.site + 1) + "";
        }

        String var5 = var4 + " was defeated";
        if (!this.bb) {
            var5 = var5 + " (Team: " + var1.getPlayerTeamName() + ")";
        } else {
            int var6 = PlayerData.g();
            var5 = var5 + " (" + var6 + " players remaining)";
            if (var6 == 1) {
                var3 = true;
            }
        }

        if (!var2.N() && var2.tick < 60) {
            GameEngine.log("Not showing defeated message: " + var5);
            var5 = null;
        }

        if (var1.E) {
            var5 = null;
        }

        if (var5 != null) {
            this.j(var5);
        }

        if (var3) {
            PlayerData.Q();
        }

    }

    public strictfp void i(PlayerData var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        String var3 = var1.name;
        if (var3 == null) {
            var3 = "Player - " + (var1.site + 1) + "";
        }

        boolean var4 = false;
        String var5;
        if (var2.tick < 10) {
            var5 = var3 + " had no starting units";
        } else {
            var5 = var3 + " has been wiped out";
        }

        if (!this.bb) {
            var5 = var5 + " (Team: " + var1.getPlayerTeamName() + ")";
        } else {
            int var6 = PlayerData.g();
            var5 = var5 + " (" + var6 + " players remaining)";
            if (var6 == 1) {
                var4 = true;
            }
        }

        if (!var2.N() && var2.tick < 60) {
            GameEngine.log("Not showing defeated message: " + var5);
            var5 = null;
        }

        if (var1.E) {
            var5 = null;
        }

        if (var1.b()) {
            var5 = null;
        }

        if (var5 != null) {
            this.j(var5);
        }

        if (var4) {
            PlayerData.Q();
        }

    }

    public strictfp synchronized void ar() {
        if (this.bD != null) {
            this.bD.cancel();
            this.bD = null;
        }

    }

    public strictfp synchronized void as() {
        if (this.publicRoom && this.isServer && this.bD == null) {
            this.bD = new Timer();
            GameNetEngine$6 var1 = new GameNetEngine$6(this);
            this.bD.schedule(var1, 60000L, 60000L);
        }

    }

    public strictfp String at() {
        GameEngine var1 = GameEngine.getGameEngine();
        String var2 = "";
        if (var1.netEngine.isServer && !var1.netEngine.F) {
            String var3 = var1.netEngine.ai();
            String var4;
            if (this.D) {
                if (this.E != null) {
                    var4 = this.E;
                    var2 = var2 + var4;
                }
            } else if (var3 != null) {
                var4 = "Local IP address: " + var3 + " port: " + var1.netEngine.port;
                if (var1.netEngine.aV != null) {
                    if (!var1.netEngine.aV) {
                        var4 = var4 + "\nUnable to get a public IP address, check your internet connection";
                    } else if (var1.netEngine.aT != null && var1.netEngine.aU != null) {
                        var4 = var4 + "\nYour public address is " + (var1.netEngine.aU ? "<Open>" : "<CLOSED>") + " to the internet";
                    }
                } else {
                    var4 = var4 + "\nRetrieving your public IP...";
                }

                var2 = var2 + var4;
            } else {
                var2 = var2 + "You do not have a network connection";
            }
        }

        if (var1.P()) {
            if (this.p) {
                var2 = var2 + "SandBox Mode!\nPlace any unit, Control all teams, Special powers";
            } else {
                var2 = var2 + "Local skirmish";
            }
        }

        boolean var9 = true;
        if (GameEngine.at() && var1.netEngine.isServer) {
            var9 = false;
        }

        if (var2.length() != 0) {
            var2 = var2 + "\n";
            if (GameEngine.av()) {
                var2 = var2 + "\n";
            }
        }

        if (var1.netEngine.av || var1.netEngine.isServer) {
            if (var9) {
                if (var1.netEngine.gameMapData.mapType != null) {
                    var2 = var2 + "Game Mode: " + var1.netEngine.gameMapData.mapType.type();
                }

                if (var1.netEngine.gameMapData.mapName != null) {
                    var2 = var2 + "\nMap: " + class_200.e(var1.netEngine.gameMapData.mapName);
                }
            }

            var2 = var2 + "\nStarting Credits: " + var1.netEngine.j();
            var2 = var2 + "\nFog: " + var1.netEngine.g();
            if (var1.netEngine.gameMapData.initUnit != 1) {
                var2 = var2 + "\nStarting Units: " + var1.netEngine.h();
            }

            if (var1.netEngine.gameMapData.income != 1.0F) {
                var2 = var2 + "\n" + class_340.a(var1.netEngine.gameMapData.income, 1) + "X income";
            }

            if (var1.netEngine.gameMapData.nukes) {
                var2 = var2 + "\nNo nukes";
            }

            if (var1.netEngine.gameMapData.sharedControl) {
                var2 = var2 + "\nShared control: On";
            }

            if (this.isServer) {
                if (var1.netEngine.passwd != null) {
                    var2 = var2 + "\nPassword Protection: On";
                }

                if (!var1.netEngine.publicRoom && !var1.netEngine.F) {
                    var2 = var2 + "\nServer Visibility: Hidden";
                }

                if (var1.netEngine.useMods && !var1.netEngine.F) {
                    ArrayList var10 = var1.bZ.j();
                    var2 = var2 + "\n-- Required Mods: --\n";
                    int var5 = 0;

                    String var8;
                    for(Iterator var6 = var10.iterator(); var6.hasNext(); var2 = var2 + " mod: \"" + var8 + "\"\n") {
                        class_800 var7 = (class_800)var6.next();
                        if (var5 > 2 && var5 < var10.size() - 1) {
                            var2 = var2 + "" + (var10.size() - var5) + " more mods...";
                            break;
                        }

                        ++var5;
                        var8 = var7.b();
                        var8.replace("\"", "'");
                        var8.replace(";", ".");
                    }
                }
            }
        }

        return var2;
    }

    public strictfp String au() {
        if (!this.useMods) {
            return null;
        } else {
            GameEngine var1 = GameEngine.getGameEngine();
            ArrayList var2 = var1.bZ.j();
            String var3 = "";
            int var4 = 0;

            String var7;
            for(Iterator var5 = var2.iterator(); var5.hasNext(); var3 = var3 + var7) {
                class_800 var6 = (class_800)var5.next();
                if (var4 != 0) {
                    var3 = var3 + "; ";
                }

                if (var4 > 1 && var4 < var2.size() - 1) {
                    var3 = var3 + "" + (var2.size() - var4) + " more...";
                    break;
                }

                ++var4;
                var7 = var6.b();
                var7.replace(";", ".");
            }

            return var3;
        }
    }

    public strictfp String av() {
        GameEngine var1 = GameEngine.getGameEngine();
        if (var1.netEngine.gameMapData.mapName == null) {
            return null;
        } else if (var1.netEngine.gameMapData.mapType == null) {
            return null;
        } else if (var1.netEngine.gameMapData.mapType == MapType.skirmishMap) {
            return "maps/skirmish/" + var1.netEngine.gameMapData.mapName;
        } else if (var1.netEngine.gameMapData.mapType == MapType.customMap) {
            return "/SD/rusted_warfare_maps/" + var1.netEngine.gameMapData.mapName;
        } else {
            GameEngine.log("getNetworkMapPath: unhandled type:" + var1.netEngine.gameMapData.mapType);
            return null;
        }
    }

    public strictfp boolean aw() {
        return this.isServer || this.H;
    }

    public strictfp void a(String var1, PlayerConnect var2) {
        GameEngine.log("sendCommandError: " + var1);
        if (var2 == null) {
            this.b((PlayerConnect)null, -1, (String)null, var1);
        } else {
            this.a((PlayerConnect)null, (PlayerData)null, (String)null, var1, var2);
        }

    }

    public strictfp boolean b(PlayerConnect var1, PlayerData var2, String var3, String var4) {
        String var5 = null;
        String var6 = "";
        String[] var7 = new String[0];
        String var8 = var4.trim();
        boolean var9 = false;
        if (var8.startsWith("-qc ")) {
            var8 = var8.substring("-qc ".length());
            var8 = var8.trim();
            var9 = true;
        }

        String var10;
        int var11;
        if ((var8.startsWith("-") || var8.startsWith(".") || var8.startsWith("_")) && var8.length() >= 2) {
            var10 = var8.substring(1).trim();
            var11 = var10.indexOf(" ");
            if (var11 == -1) {
                var11 = var10.length();
            }

            var5 = var10.substring(0, var11).toLowerCase(Locale.ENGLISH);
            if (var11 != -1 && var10.length() >= var11 + 1) {
                var6 = var10.substring(var11 + 1).trim();
                var7 = var6.split(" ");
            }
        }

        if (var5 == null) {
            return false;
        } else if (var9 && !"self_move".equals(var5) && !"self_team".equals(var5)) {
            return false;
        } else if (!"pause".equals(var5) && !"unpause".equals(var5)) {
            if ("endgame".equals(var5)) {
                if (var2 == null) {
                    this.a("[Could not find player]", var1);
                    return true;
                } else if (this.isServer && var2 == this.z) {
                    if (!this.ingame) {
                        this.a("[Game not yet started]", var1);
                        return true;
                    } else {
                        this.ag();
                        return true;
                    }
                } else {
                    this.a("[Only the host can end game]", var1);
                    return true;
                }
            } else if ("teamlock".equals(var5)) {
                if (var2 == null) {
                    this.a("[Could not find player]", var1);
                    return true;
                } else if ((!this.isServer || var2 != this.z) && !this.d.b(var1)) {
                    this.a("[Only the host can change teamlock]", var1);
                    return true;
                } else if (!"true".equalsIgnoreCase(var6) && !"on".equalsIgnoreCase(var6)) {
                    if (!"false".equalsIgnoreCase(var6) && !"off".equalsIgnoreCase(var6)) {
                        this.a("[Expected true or false]", var1);
                        return true;
                    } else {
                        this.gameMapData.m = false;
                        this.a("[teams are unlocked]", var1);
                        return true;
                    }
                } else {
                    this.gameMapData.m = true;
                    this.a("[teams are locked]", var1);
                    return true;
                }
            } else if ("roomlock".equals(var5)) {
                if (var2 == null) {
                    this.a("[Could not find player]", var1);
                    return true;
                } else if (this.isServer && var2 == this.z) {
                    if (!"true".equalsIgnoreCase(var6) && !"on".equalsIgnoreCase(var6)) {
                        if (!"false".equalsIgnoreCase(var6) && !"off".equalsIgnoreCase(var6)) {
                            this.a("[Expected true or false]", var1);
                            return true;
                        } else {
                            this.gameMapData.p = false;
                            this.a("[room is unlocked]", var1);
                            return true;
                        }
                    } else {
                        this.gameMapData.p = true;
                        this.a("[room is locked]", var1);
                        return true;
                    }
                } else {
                    this.a("[Only the host can change roomlock]", var1);
                    return true;
                }
            } else if ("share".equals(var5)) {
                if (var2 == null) {
                    this.a("[Could not find player]", var1);
                    return true;
                } else if (!this.gameMapData.sharedControl) {
                    this.a("[Shared control is not enabled in this game]", var1);
                    return true;
                } else if (!"true".equalsIgnoreCase(var6) && !"on".equalsIgnoreCase(var6)) {
                    if (!"false".equalsIgnoreCase(var6) && !"off".equalsIgnoreCase(var6)) {
                        this.a("[Expected true or false]", var1);
                        return true;
                    } else {
                        if (var2.sharedControl_1) {
                            var2.sharedControl_1 = false;
                            this.j("[shared control now off for " + var3 + "]");
                        } else {
                            this.j("[shared control already off for " + var3 + "]");
                        }

                        return true;
                    }
                } else {
                    if (!var2.sharedControl_1) {
                        var2.sharedControl_1 = true;
                        this.j("[shared control now on for " + var3 + "]");
                    } else {
                        this.j("[shared control already on for " + var3 + "]");
                    }

                    return true;
                }
            } else {
                int var24;
                if ("self_move".equals(var5)) {
                    if (var2 == null) {
                        this.a("[Cannot Move - Player not found]", var1);
                        return true;
                    } else if (this.ingame) {
                        this.a("[Cannot Move '" + var2.name + "' - Game has been started]", var1);
                        return true;
                    } else if (this.o()) {
                        this.a("[Cannot Move '" + var2.name + "' - Game is starting]", var1);
                        return true;
                    } else if (this.gameMapData.m) {
                        this.a("[Cannot Move '" + var2.name + "' - Teams locked]", var1);
                        return true;
                    } else if (var7.length > 0) {
                        try {
                            var24 = Integer.valueOf(var7[0]);
                        } catch (NumberFormatException var20) {
                            this.a("[Cannot Move '" + var2.name + "' - team '" + var7[0] + "' is not a number]", var1);
                            return true;
                        }

                        Integer var28 = null;
                        if (var7.length > 1) {
                            try {
                                var28 = Integer.valueOf(var7[1]);
                            } catch (NumberFormatException var19) {
                                this.a("[Cannot Move '" + var2.name + "' - ally group '" + var7[1] + "' is not a number]", var1);
                                return true;
                            }

                            if (var28 != -1 && (var28 < 1 || var28 > 99)) {
                                this.a("[Cannot Move Team - Ally group - Out of range]", var1);
                                return true;
                            }
                        }

                        boolean var25 = false;
                        if (var24 - 1 == -3) {
                            if (!this.gameMapData.spectators) {
                                this.a("[Spectators are disabled on this server]", var1);
                                return true;
                            }

                            synchronized(this.bC) {
                                var24 = PlayerData.m5451H();
                                if (var24 != -1) {
                                    this.setPlayerTeamSynchronized(var2, -3);
                                }
                            }

                            var25 = true;
                        }

                        int var13 = var2.team;
                        boolean var14 = var13 == -3;
                        if (!var25) {
                            if (var24 < 1 || var24 > PlayerData.c) {
                                this.a("[Cannot Move '" + var2.name + "' - target slotId must between 1-" + PlayerData.c + "]", var1);
                                return true;
                            }

                            synchronized(this.bC) {
                                if (this.z != var2) {
                                    PlayerData var16 = PlayerData.getPlayerData(var24 - 1);
                                    if (var16 != null && !var16.w && !var16.b()) {
                                        this.a("[Cannot move '" + var2.name + "' to slot: " + var24 + " - Player: " + var16.name + " is in that slot.]", var1);
                                        return true;
                                    }
                                }

                                this.setPlayerTeamSynchronized(var2, var24 - 1);
                            }
                        }

                        var2.team = var13;
                        if (var28 != null) {
                            if (var28 == -1) {
                                var2.team = var2.site % 2;
                            } else {
                                var2.team = var28;
                            }
                        }

                        if (this.gameMapData.n) {
                            var2.team = var2.site % 2;
                        }

                        if (var25) {
                            var2.team = -3;
                        }

                        if (var25) {
                            if (!var14) {
                                this.j("Player '" + var2.name + "' is now a spectator");
                            }
                        } else {
                            this.j("Player '" + var2.name + "' moved themselves to: " + var24);
                        }

                        this.P();
                        class_195.o();
                        return true;
                    } else {
                        this.a("[Cannot Move '" + var2.name + "' - No target]", var1);
                        return true;
                    }
                } else if (!"self_team".equals(var5)) {
                    if ("surrender".equals(var5)) {
                        if (!this.ingame) {
                            this.a("[Cannot Surrender - Game has not started]", var1);
                            return true;
                        } else if (var2 == null) {
                            this.a("[Could not find player]", var1);
                            return true;
                        } else {
                            var10 = "";
                            if (!var2.k()) {
                                var2.l();
                                boolean var26 = var2.m();
                                GameEngine.log(var3 + ": Is voting to surrender (can surrender:" + var26 + ", afk:" + var2.ab + ", defeated:" + var2.G + ", disconnected:" + var2.isTimeOut() + ")");
                                if (var26) {
                                    var10 = "";
                                } else {
                                    var10 = "(Cannot vote) ";
                                }
                            } else {
                                GameEngine.log(var3 + ": Is already voting to surrender but updating timestamp");
                                var2.l();
                                var10 = "(Already voted) ";
                            }

                            String var27 = PlayerData.b(var2.team) + "/" + PlayerData.c(var2.team);
                            String var12 = "-t " + var10 + "[Votes to surrender " + var27 + "]";
                            this.a(var1, var2, var3, var12);
                            return true;
                        }
                    } else {
                        return false;
                    }
                } else if (var2 == null) {
                    this.a("[Cannot Set Team - Player not found]", var1);
                    return true;
                } else if (this.ingame) {
                    this.a("[" + var2.name + ": Cannot Set Team - Game has been started]", var1);
                    return true;
                } else if (this.o()) {
                    this.a("[" + var2.name + ": Cannot Set Team - Game is starting]", var1);
                    return true;
                } else if (this.gameMapData.m) {
                    this.a("[" + var2.name + ": Cannot Set Team - Teams locked]", var1);
                    return true;
                } else if (this.gameMapData.n) {
                    return true;
                } else {
                    try {
                        var24 = Integer.valueOf(var6);
                    } catch (NumberFormatException var21) {
                        this.m("'" + var6 + "' is not a number");
                        return true;
                    }

                    if (var24 == -1) {
                        var11 = var2.site % 2;
                    } else {
                        if (var24 < 1 || var24 > 99) {
                            this.a("[Cannot Set Team - Out of range]", var1);
                            return true;
                        }

                        var11 = var24 - 1;
                    }

                    if (var2.team != var11) {
                        var2.team = var11;
                        this.a("Player '" + var2.name + "' team changed to: " + var24, var1);
                    }

                    this.P();
                    class_195.o();
                    return true;
                }
            }
        } else if (var2 == null) {
            this.a("[Could not find player]", var1);
            return true;
        } else if ((!this.isServer || var2 != this.z) && !this.d.b(var1)) {
            this.a("[Only the host can change pause state]", var1);
            return true;
        } else if (!this.ingame) {
            this.a("[Game not yet started]", var1);
            return true;
        } else {
            boolean var23 = !this.al;
            if ("unpause".equals(var5)) {
                var23 = false;
            }

            this.e(var23);
            return true;
        }
    }

    public static strictfp void a(EnterPasswordCallback var0) {
        GameEngine var1 = GameEngine.getGameEngine();
        if (var1.netEngine != null) {
            var1.netEngine.d.a(var0);
        }

        if (!GameEngine.isModsInSD) {
            GameNetEngine$7 var2 = new GameNetEngine$7(var0);
            class_208.a((Runnable)var2);
        }
    }

    public strictfp ArrayList ax() {
        synchronized(this.bC) {
            return PlayerData.c();
        }
    }

    public strictfp void e(boolean var1) {
        this.al = var1;
        if (this.al) {
            this.j("Game Paused");
        } else {
            this.j("Game unpaused");
        }

    }

    public strictfp void b(PlayerConnect var1, String var2) {
        var1.a(false, false, var2);
    }

    public strictfp void c(PlayerConnect var1, String var2) {
        Iterator var3 = this.socketList.iterator();

        while(var3.hasNext()) {
            PlayerConnect var4 = (PlayerConnect)var3.next();
            if (var4.j == var1) {
                this.b(var4, var2);
            }
        }

    }

    public strictfp PlayerConnect a(PlayerConnect var1, int var2, String var3, String var4) {
        GameEngine var5 = GameEngine.getGameEngine();
        RelayForwardedSocket var6 = new RelayForwardedSocket(var1, var2);
        PlayerConnect var7 = new PlayerConnect(this, var6);
        var7.k = var2;
        var7.j = var1;
        var7.m = var3;
        var7.n = var4;

        try {
            var7.d();
            var5.netEngine.socketList.add(var7);
            var5.netEngine.Q();
            return var7;
        } catch (Exception var9) {
            var9.printStackTrace();
            var7.a("crash");
            return null;
        }
    }

    public strictfp PlayerConnect a(PlayerConnect var1, int var2) {
        Iterator var3 = this.socketList.iterator();

        PlayerConnect var4;
        do {
            if (!var3.hasNext()) {
                return null;
            }

            var4 = (PlayerConnect)var3.next();
        } while(var4.k != var2 || var4.j != var1);

        return var4;
    }

    public static strictfp String p(String var0) {
        var0 = var0.trim();
        var0 = var0.replace("\n", ".");
        var0 = var0.replace("\r", ".");
        var0 = var0.replace("\t", ".");
        var0 = var0.replace("\u0000", ".");

        for(var0 = var0.replace(" ", "_"); var0.startsWith(".") || var0.startsWith("-") || var0.startsWith(" "); var0 = var0.substring(1)) {
        }

        StringBuilder var1 = new StringBuilder();
        char[] var2 = var0.toCharArray();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            char var5 = var2[var4];
            if (!Character.isISOControl(var5)) {
                var1.append(var5);
            }
        }

        var0 = var1.toString();
        return var0;
    }

    public strictfp void a(ArrayList var1, boolean var2) {
        if (this.bF != null) {
            GameEngine.log("startJoinServerInternalThread: Already joining");
        } else if (var1.size() == 0) {
            GameEngine.log("startJoinServerInternalThread: no servers");
        } else {
            String var3 = (String)var1.get(0);
            boolean var4 = false;
            GameNetEngine$8 var5 = new GameNetEngine$8(this, var2);
            this.bF = this.a(var3, var4, var5);
        }
    }
}
