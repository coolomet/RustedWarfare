package com.corrodinggames.rts.gameFramework;

import android.content.Context;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.a.class_138;
import com.corrodinggames.rts.game.units.EditorOrBuilder;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.custom.d.class_447;
import com.corrodinggames.rts.gameFramework.e.class_697;
import com.corrodinggames.rts.gameFramework.net.CheckSumData;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameNetEngine;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import com.corrodinggames.rts.gameFramework.net.ChecksumItem;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

public strictfp class ReplayEngine {
    String a = "replays/";
    public static boolean b = true;
    public static boolean c = true;
    public static boolean d = false;
    public static boolean e = true;
    public static boolean f = false;
    public CheckSumData g = new CheckSumData();
    public boolean h;
    int i;
    int j;
    boolean k;
    int l;
    boolean m;
    public boolean n = false;
    public int o;
    public int p;
    public int q;
    public String r;
    boolean s;
    private volatile boolean P;
    String t;
    boolean u;
    public int v = 1;
    class_967 w;
    class_967 x;
    int y;
    int z;
    int A;
    int B;
    InputStream C;
    BufferedInputStream D;
    DataInputStream E;
    GameInputStream F;
    OutputStream G;
    BufferedOutputStream H;
    DataOutputStream I;
    GameOutputStream J;
    RelaySaveRunnable K;
    Thread L;
    Object M = new Object();
    public boolean N = false;
    public boolean O;

    public static strictfp void a(String var0) {
        GameEngine.log("Replay: " + var0);
    }

    public static strictfp void b(String var0) {
        GameEngine.print("Replay: " + var0);
    }

    public static strictfp void a(String var0, Exception var1) {
        GameEngine.a((String)("Replay: " + var0), (Throwable)var1);
    }

    public strictfp File a(String var1, boolean var2) {
        File var3 = class_697.a(var1, this.a, var2);
        return var3;
    }

    public strictfp void a(Context var1) {
    }

    public strictfp void a() {
        GameEngine var1 = GameEngine.getGameEngine();
        if (var1.bt != 0.0F) {
            var1.bt = 0.0F;
        } else {
            var1.bt = 1.0F;
        }

    }

    public strictfp void b() {
        GameEngine var1 = GameEngine.getGameEngine();
        if (var1.bt == 1.0F) {
            var1.bt = 2.0F;
        } else if (var1.bt == 2.0F) {
            var1.bt = 4.0F;
        } else if (var1.bt == 4.0F) {
            var1.bt = 8.0F;
        } else if (var1.bt == 8.0F) {
            var1.bt = 16.0F;
        } else if (var1.bt == 16.0F) {
            var1.bt = 32.0F;
        } else if (var1.bt == 32.0F) {
            var1.bt = 64.0F;
        } else if (var1.bt == 64.0F) {
            var1.bt = 1.0F;
        } else {
            var1.bt = 1.0F;
        }

    }

    public strictfp void a(int var1, String var2, String var3, int var4) {
        RelaySaveRunnable var5 = this.K;
        if (this.P && !this.u) {
            if (var3.startsWith("-t ")) {
            }

            class_967 var6 = new class_967();
            var6.a = var4;
            var6.g = new class_966();
            var6.g.a = var1;
            var6.g.b = var2;
            var6.g.c = var3;
            if (var5 == null) {
                GameEngine.warn("Failed to record chat message, replay might have already stopped");
                return;
            }

            var5.a(var6);
        }

    }

    public strictfp void a(byte[] var1, int var2, int var3, int var4, float var5, float var6) {
        RelaySaveRunnable var7 = this.K;
        if (this.P && !this.u) {
            class_967 var8 = new class_967();
            var8.a = var2;
            var8.f = var1;
            var8.h = var3;
            var8.i = var4;
            var8.j = var5;
            var8.k = var6;
            if (var7 == null) {
                GameEngine.warn("Failed to save resync, replay might have already stopped");
                return;
            }

            var7.a(var8);
        }

    }

    public strictfp void c() {
        if (f) {
            this.d();
        }

    }

    public strictfp void a(SyncPacket var1, int var2) {
        RelaySaveRunnable var3 = this.K;
        if (this.P && !this.u) {
            if (var3 == null) {
                GameEngine.warn("Failed to record command, replay might have already stopped");
                return;
            }

            class_967 var4 = new class_967();
            var4.e = var1.clone();
            var4.a = var2;
            var3.a(var4);
            ++this.j;
            if (this.j > 5) {
                this.j = 0;
                GameEngine var6 = GameEngine.getGameEngine();
                class_967 var5 = new class_967();
                var5.c = this.f();
                var5.a = var6.tick;
                var3.a(var5);
            }
        }

    }

    public strictfp void d() {
        if (this.P && !this.u) {
            this.g.b();
            this.a(this.g, true);
        }

    }

    public strictfp void a(CheckSumData var1) {
        this.a(var1, false);
    }

    public strictfp void a(CheckSumData var1, boolean var2) {
        if (this.P && !this.u) {
            GameEngine var3 = GameEngine.getGameEngine();
            class_967 var4 = new class_967();
            GameOutputStream var5 = new GameOutputStream();

            try {
                int var6 = 0;
                if (var2) {
                    ++var6;
                }

                var5.writeByte(var6);
                var5.writeInt(var1.b.size());
                Iterator var7 = var1.b.iterator();

                while(var7.hasNext()) {
                    ChecksumItem var8 = (ChecksumItem)var7.next();
                    var5.writeLong(var8.b);
                }
            } catch (Exception var9) {
                throw new RuntimeException(var9);
            }

            var4.d = var5.toByteArray();
            var4.a = var3.tick;
            this.K.a(var4);
        }

    }

    public strictfp void close() {
        synchronized(this.M) {
            try {
                if (this.K != null) {
                    this.K.a();

                    try {
                        this.L.join();
                    } catch (InterruptedException var20) {
                        var20.printStackTrace();
                    }

                    this.P = false;
                    this.K = null;
                    this.L = null;
                }

                if (this.G != null) {
                    this.I.flush();
                    this.I.close();
                    this.H.flush();
                    this.H.close();
                    this.G.flush();
                    this.G.close();
                }
            } catch (IOException var21) {
                var21.printStackTrace();
            } finally {
                this.G = null;
                this.H = null;
                this.I = null;
                this.J = null;
            }

            this.s = false;
            this.P = false;
            this.u = false;
            this.t = null;
            this.i = 0;
            this.j = 0;
            this.k = false;
            this.l = 0;
            this.m = false;
            this.y = 0;
            this.v = 1;
            this.z = 0;
            this.A = 0;
            this.B = 0;
            this.o = -1;
            this.p = 0;
            this.q = -1;
            this.r = null;

            try {
                if (this.C != null) {
                    this.E.close();
                    this.D.close();
                    this.C.close();
                }
            } catch (IOException var18) {
                var18.printStackTrace();
            } finally {
                this.C = null;
                this.D = null;
                this.E = null;
                this.F = null;
            }

        }
    }

    public strictfp long f() {
        long var1 = 0L;
        Iterator var3 = GameObject.er.iterator();

        while(var3.hasNext()) {
            GameObject var4 = (GameObject)var3.next();
            if (var4 instanceof OrderableUnit) {
                OrderableUnit var5 = (OrderableUnit)var4;
                var1 = (long)((float)var1 + var5.xCord * 1000.0F);
                var1 = (long)((float)var1 + var5.yCord * 1000.0F);
                var1 = (long)((float)var1 + var5.health * 1.0F);
                var1 += var5.id;

            }
        }

        return var1;
    }

    public strictfp void g() {
        if (!this.N) {
            this.close();
        }

    }

    public strictfp boolean c(String var1) {
        File var2 = this.a(var1, false);
        return this.a(var1, var2);
    }

    private strictfp void l() {
        for(int var1 = 0; var1 < PlayerData.c; ++var1) {
            PlayerData var2 = PlayerData.getPlayerData(var1);
            if (var2 != null && var2 instanceof class_138) {
                ((class_138)var2).aX = true;
            }
        }

    }

    public strictfp boolean a(String var1, File var2) {
        if (this.P) {
            if (this.u) {
                GameEngine.print("startReplayingFile: A replay is already playing");
            } else {
                GameEngine.print("startReplayingFile: A replay is already saving");
            }
        }

        this.close();
        GameEngine var3 = GameEngine.getGameEngine();
        var3.e();
        var3.netEngine.q();
        this.w = null;
        this.s = false;
        this.P = true;
        this.u = true;
        this.t = var1;

        try {
            String var4;
            if (var2.isDirectory()) {
                GameEngine.log("File is a directory: " + var2.getAbsolutePath());
                var4 = "Cannot load replay: Target is a folder, instead of a file";
                GameEngine.log(var4);
                var3.log(var4, 1);
                return false;
            } else {
                this.C = class_697.a(var2);
                if (this.C == null) {
                    var4 = "Cannot load replay: Failed to read replay file";
                    GameEngine.log(var4);
                    var3.log(var4, 1);
                    return false;
                } else {
                    this.D = new BufferedInputStream(this.C);
                    this.E = new DataInputStream(this.D);
                    this.F = new GameInputStream(this.E);
                    var4 = this.F.readString();
                    if (!var4.equals("rustedWarfareReplay")) {
                        GameEngine.log("Header is not correct:" + var4);
                        String var12 = "Cannot load replay: File is missing header (check if this file is a replay)";
                        GameEngine.log(var12);
                        var3.log(var12, 1);
                        return false;
                    } else {
                        int var5 = this.F.readInt();
                        int var6 = this.F.readInt();
                        a("Loading save from version: " + var6);
                        this.F.a(var6);
                        String var7 = this.F.readString();
                        if ((var6 != 96 || var5 != var3.c(true)) && !this.n) {
                            String var8 = "Cannot load replay: This replay was recording with a different version: " + var7;
                            if (GameEngine.av()) {
                                var8 = var8 + " (You can use the beta tab in steam to switch to old versions)";
                            }

                            var3.log(var8, 1);
                            a("Replay version: " + var6 + " (" + var5 + ")");
                            a("GameSaver.thisSaveVersion: 96 (" + var3.c(true) + ")");
                            if (!GameEngine.aG) {
                                this.P = false;
                                return false;
                            }
                        }

                        this.q = var6;
                        this.r = var7;
                        this.F.readBoolean();
                        this.F.startBlock("gamesave");
                        this.O = false;
                        this.N = true;
                        a("Loading replay initial save");
                        var3.ca.a(this.F, false, false, false);
                        this.N = false;
                        this.F.endBlock("gamesave");
                        if (!this.O) {
                            a("ReplayEngine: --- No game setup read ----");
                            var3.netEngine.gameMapData.nukes = true;
                            var3.bC = var3.settingsEngine.teamUnitCapHostedGame;
                            var3.bB = var3.bC;
                        }

                        if (!this.h) {
                            this.l();
                        }

                        a("--- Reply settings ---");
                        a("Unit cap: " + var3.bC);
                        a(var3.netEngine.gameMapData.b());
                        a("Starting frame:" + var3.tick);
                        if (!this.h) {
                            for(int var13 = 0; var13 < PlayerData.c; ++var13) {
                                PlayerData var9 = PlayerData.getPlayerData(var13);
                                if (var9 != null && var9.name != null) {
                                    String var10 = "Player '" + var9.name + "' playing as " + var9.N().toLowerCase() + " (team:" + var9.getPlayerTeamName() + ")";
                                    var3.bS.h.a("", var10);
                                }
                            }
                        }

                        if (GameEngine.aw) {
                            GameNetEngine.g("Warning: editor will desync checksums.");
                            var3.bv = true;
                            var3.bl = true;
                            var3.bn = true;
                        }

                        return true;
                    }
                }
            }
        } catch (Exception var11) {
            throw new RuntimeException(var11);
        }
    }

    public strictfp void a(boolean var1) {
        if (GameEngine.aW) {
            if (!GameEngine.bd) {
                return;
            }
        } else if (!GameEngine.bc) {
            return;
        }

        GameEngine var2 = GameEngine.getGameEngine();
        if (var2.netEngine.B && !var1 && !this.N && var2.settingsEngine.saveMultiplayerReplays) {
            String var3 = var2.al() + " [v" + var2.v() + "] (" + class_340.a("d MMM yyyy HH.mm.ss") + ").replay";
            this.d(var3);
        }

    }

    public strictfp void d(String var1) {
        a("Recording replay to: " + var1);
        if (this.P) {
            if (this.u) {
                b("startSaving: A replay is already playing");
            } else {
                b("startSaving: A replay is already saving");
            }
        }

        this.close();
        GameEngine var2 = GameEngine.getGameEngine();
        f = var2.settingsEngine.replayTracing;
        if (f) {
            var2.netEngine.j("Warning traceChecksumsWriting is on. Large replay file size will be created.");
        }

        this.s = false;
        this.P = true;
        this.u = false;
        this.t = var1;

        try {
            File var3 = this.a(var1, true);
            this.G = class_697.a(var3, false);
            if (this.G == null) {
                b("Failed to create replay file at:" + var3.getAbsolutePath());
                GameEngine.getGameEngine().i("Failed to create replay file (Replay recording will be disabled)");
                this.close();
                return;
            }

            this.H = new BufferedOutputStream(this.G);
            this.I = new DataOutputStream(this.H);
            this.J = new GameOutputStream(this.I);
            this.J.writeString("rustedWarfareReplay");
            int var4 = var2.c(true);
            this.J.writeInt(var4);
            this.J.writeInt(96);
            this.J.writeString(var2.v());
            this.J.writeBoolean(var2.ar);
            this.J.e("gamesave");
            var2.ca.a(this.J);
            this.J.endBlock("gamesave");
            this.I.flush();
            this.K = new RelaySaveRunnable(this);
            this.L = new Thread(this.K);
            this.L.start();
        } catch (IOException var5) {
            a("Failed to start recording replay", (Exception)var5);
            GameEngine.getGameEngine().i("Failed to start recording replay: " + var5.getMessage());
            this.close();
        } catch (Exception var6) {
            a("Failed to start recording replay (Non IOException)", var6);
            GameEngine.getGameEngine().i("Failed to start recording replay (Non IOException): " + var6.getMessage());
            this.close();
        }

    }

    public strictfp boolean h() {
        GameEngine var1 = GameEngine.getGameEngine();
        String var2 = this.F.x();
        class_967 var3;
        if ("rc".equals(var2)) {
            ++this.y;
            var3 = new class_967();
            var3.a = this.F.readInt();
            SyncPacket var4 = var1.cf.b();
            var4.read(this.F);
            var4.a = true;
            var3.e = var4;
            this.F.endBlock("rc");
            this.w = var3;
            ++this.p;
            this.o = var3.a;
            if (c) {
                a("updateGameFrame: Command: " + var4.i.name + " (" + var4.i.site + ") count:" + var4.d() + " id:" + this.y);
                if (var4.j != null) {
                    a("updateGameFrame: Waypoint: " + var4.j.d().name());
                    if (var4.j.a() != null) {
                        a("updateGameFrame: Build Type: " + var4.j.a().i());
                    }
                }

                if (class_226.c(var4.k)) {
                    a("updateGameFrame: SpecialAction: " + var4.k.a());
                }

                if (var4.n != null) {
                    a("updateGameFrame: SetAttackMode: " + var4.n);
                }

                if (var4.g) {
                    a("updateGameFrame: stopOrUndo is set");
                }

                if (var4.r) {
                    if (var4.s != 0.0F) {
                        a("updateGameFrame: changeStepRate:" + var4.s);
                    }

                    if (var4.u != 0) {
                        a("updateGameFrame: systemAction_action:" + var4.u);
                    }
                }

                a("updateGameFrame: ------");
            }
        } else if ("wait".equals(var2)) {
            var3 = new class_967();
            var3.a = this.F.readInt();
            var3.b = true;
            this.w = var3;
            this.F.endBlock("wait");
        } else {
            int var12;
            if ("cs".equals(var2)) {
                var12 = this.F.readInt();
                long var13 = this.F.readLong();
                if (!this.n) {
                    if (var1.tick != var12) {
                        GameEngine.b("replay:updateGameFrame", "expected:" + var12 + " got:" + var1.tick);
                    }

                    if (this.f() != var13) {
                        b("checksum: checksums don't match!!");
                        b("checksum: game frameNumber:" + var1.tick);
                        b("checksum: Replay checksum:" + var13);
                        b("checksum: Game checksum  :" + this.f());
                        ++this.l;
                        if (!this.k) {
                            this.k = true;
                            var1.bS.h.a("", "Error: This replay might be out of sync");
                        }
                    } else {
                        a("checksum: checksums are matching (" + var13 + "), frameNumber:" + var1.tick);
                    }
//                    var1.bS.h.a("", "TICK" + (this.f() == var13 ? "" : "!!!") + ": " + var1.tick);
//                    String debug = "\n!!! TICK: " + var1.tick + "\n";
//                    for (Object obj : GameObject.er) {
//                        if (obj instanceof OrderableUnit) {
//                            OrderableUnit unit = (OrderableUnit)obj;
//                            debug += unit.r().i()+ "(id: " + unit.id + "; " + unit.xCord + ", " + unit.yCord + ", " + unit.health + "\n";
//                        }
//                    }
//                    GameEngine.log(debug);
                }

                this.F.endBlock("cs");
            } else {
                int var5;
                if ("es".equals(var2)) {
                    var12 = this.F.readInt();
                    if (!this.n) {
                        if (var1.tick != var12) {
                            GameEngine.print("replay.updateGameFrame: expected:" + var12 + " got:" + var1.tick);
                        }

                        GameInputStream var14 = new GameInputStream(this.F.readBytes());
                        var5 = var14.readByte();
                        boolean var6 = false;
                        if (class_447.a(var5, 1)) {
                            var6 = true;
                        }

                        if (var6) {
                            GameEngine.log("replay: -trace checksum-");
                        } else {
                            GameEngine.log("replay: -long checksum-");
                        }

                        var1.netEngine.d();
                        int var7 = var14.readInt();
                        Iterator var8 = var1.netEngine.checkSumData.b.iterator();

                        while(var8.hasNext()) {
                            ChecksumItem var9 = (ChecksumItem)var8.next();
                            long var10 = var14.readLong();
                            if (!this.m && var10 == var9.b) {
                                a("extraChecksum: " + var9.a + " Checksum [" + var12 + "]. " + var10 + " == " + var9.b + " (ok)");
                            }

                            if (var10 != var9.b) {
                                if (this.l < 150) {
                                    b("extraChecksum: " + var9.a + " Checksum [" + var12 + "]. " + var10 + " != " + var9.b + " (failed)");
                                }

                                ++this.l;
                            }
                        }
                    }

                    this.m = true;
                    this.F.endBlock("es");
                } else if ("resync".equals(var2)) {
                    var12 = this.F.readInt();
                    GameEngine.log("Loading resync from replay");
                    if (var1.tick != var12) {
                        GameEngine.b("replay:resync", "expected:" + var12 + " got:" + var1.tick);
                    }

                    int var15 = this.F.readInt();
                    var5 = this.F.readInt();
                    float var17 = this.F.readFloat();
                    float var18 = this.F.readFloat();
                    GameInputStream var19 = new GameInputStream(this.F.readBytes());
                    var1.ca.a(var19, true, true, true);
                    this.l();
                    var1.tick = var15;
                    var1.by = var5;
                    var1.netEngine.checkSumData.allSum = 0L;
                    if ((double)var17 < 0.1) {
                        GameNetEngine.a("replay setCurrentStepRate:" + var17 + " is too small", true);
                    }

                    var1.netEngine.setCurrentStepRate(var17, "replay");
                    var1.netEngine.J = var18;
                    this.F.endBlock("resync");
                } else if ("chat".equals(var2)) {
                    var3 = new class_967();
                    var3.a = this.F.readInt();
                    var3.g = new class_966();
                    var3.g.a = this.F.readInt();
                    var3.g.b = this.F.isReadString();
                    var3.g.c = this.F.isReadString();
                    this.w = var3;
                    this.F.endBlock("chat");
                } else {
                    if ("end".equals(var2)) {
                        GameEngine.b("replay:updateGameFrame", "end of replay block found");
                        var1.bS.h.a("", "Replay has ended");
                        if (!var1.bv) {
                            this.s = true;
                            var1.bt = 0.25F;
                            GameEngine.getGameEngine().bS.G();
                        } else {
                            this.s = false;
                            this.P = false;
                            this.u = false;
                            EditorOrBuilder var16 = var1.bS.i();
                            if (var16 != null) {
                                var1.playerTeam = var16.bX;
                            }
                        }

                        this.F.endBlock("end");
                        GameEngine.log("number of replay commands issued:" + this.z);
                        return false;
                    }

                    if ("endReplayMetaData".equals(var2)) {
                        this.F.endBlock("endReplayMetaData");
                    } else {
                        GameEngine.b("updateGameFrame", "Unknown command block:" + var2);
                        this.F.endBlock(var2);
                    }
                }
            }
        }

        return true;
    }

    public strictfp void updateGameFrame(float var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        if (!this.s) {
            if (this.P && this.u) {
                while(true) {
                    while(true) {
                        if (this.w == null) {
                            try {
                                boolean var3 = this.h();
                                if (!var3) {
                                    return;
                                }
                            } catch (Exception var5) {
                                GameEngine.b("updateGameFrame", "IOException, read of replay?");
                                var5.printStackTrace();
                                var2.bt = 0.25F;
                                if (!this.s && this.P) {
                                    var2.bS.h.a("", "Replay ended (unexpected)");
                                }

                                this.s = true;
                                return;
                            }
                        }

                        if (this.w != null) {
                            if (this.n) {
                                this.w = null;
                                continue;
                            }

                            if (b && this.w != null && this.x != this.w) {
                                this.x = this.w;
                                GameEngine.log("replay: upcoming in " + (this.w.a - var2.tick) + " command:" + (this.w.e != null));
                            }

                            if (this.w.b && this.z == 0) {
                                GameEngine.log("updateGameFrame: replay: Skipping wait on first resync without commands to avoid delay");
                                this.w = null;
                                continue;
                            }

                            if (var2.tick >= this.w.a) {
                                if (this.w.e != null) {
                                    if (var2.tick > this.w.a) {
                                        GameEngine.print("updateGameFrame: replay incorrect frameNumber, skipping command:" + var2.tick + " vs " + this.w.a);
                                    } else {
                                        PlayerData var6;
                                        if (d) {
                                            var6 = this.w.e.p;
                                            if (var6 == null) {
                                                GameEngine.log("Precommand Team: commandingPlayer==null");
                                                if (this.w.e.i != null) {
                                                    GameEngine.log("Precommand Team id:" + this.w.e.i.site + " credits:" + this.w.e.i.credits);
                                                }
                                            } else {
                                                GameEngine.log("Precommand Team id:" + this.w.e.p.site + " credits:" + this.w.e.p.credits + " count:" + this.w.e.p.w() + " max:" + this.w.e.p.x());
                                            }
                                        }

                                        if (this.w.e.r && this.w.e.u != 0) {
                                            GameEngine.b("replay:issueCommand", "systemAction_action:" + this.w.e.u);
                                        }

                                        this.w.e.k();
                                        if (d) {
                                            var6 = this.w.e.p;
                                            if (var6 != null) {
                                                GameEngine.log("Postcommand credits:" + this.w.e.p.credits + " count:" + this.w.e.p.w() + " max:" + this.w.e.p.x());
                                            } else if (this.w.e.i != null) {
                                                GameEngine.log("Postcommand Team id:" + this.w.e.i.site + " credits:" + this.w.e.i.credits);
                                            }
                                        }

                                        ++this.z;
                                    }
                                } else if (this.w.g != null) {
                                    class_966 var7 = this.w.g;
                                    boolean var4 = false;
                                    if (var7.c == null) {
                                        var4 = true;
                                    } else {
                                        if (var7.c.startsWith("-i ")) {
                                            var4 = true;
                                        }

                                        if (var7.c.equals("<All players ready>")) {
                                            var4 = true;
                                        }

                                        if (var7.c.equals("--too many desync errors, suppressing output--")) {
                                            var4 = true;
                                        }

                                        if (var7.c.startsWith("desync:")) {
                                            var4 = true;
                                        }
                                    }

                                    if (!var2.settingsEngine.replaysShowRecordedChat) {
                                        var4 = true;
                                    }

                                    if (var4) {
                                        GameEngine.b("replay:updateGameFrame", "Skipping message: " + var7.b + ":" + var7.c);
                                    } else {
                                        GameEngine.b("replay:updateGameFrame", "message: " + var7.b + ":" + var7.c);
                                        var2.bS.h.a(var7.b, var7.c);
                                    }
                                } else if (this.w.b) {
                                    if (c) {
                                    }
                                } else {
                                    GameEngine.b("updateGameFrame", "error: lastReadCommand null action");
                                }

                                this.w = null;
                                continue;
                            }
                        }

                        if (this.w != null) {
                            return;
                        }
                    }
                }
            }
        }
    }

    public strictfp void deleteGame(String var1) {
        GameEngine.log("ReplayEngine deleteGame: " + var1);
        String var2 = class_697.o(var1);
        if (!var2.contains("\\") && !var2.contains("/")) {
            File var3 = this.a(var1, true);
            GameEngine.log("ReplayEngine path: " + var3.getAbsolutePath());
            if (!var3.exists()) {
                GameEngine.log("ReplayEngine deleteGame: file doesn't exist");
            }

            boolean var4 = class_697.b(var3);
            if (!var4) {
                GameEngine.log("ReplayEngine deleteGame: failed to delete: " + var3.getAbsolutePath());
            }

            File var5 = this.a(var1 + ".map", true);
            if (var5.exists()) {
                class_697.b(var5);
            }

        } else {
            GameEngine.log("Cannot get replay with path: " + var1);
        }
    }

    public strictfp boolean i() {
        return this.P;
    }

    public strictfp boolean j() {
        return this.P && this.u;
    }

    public strictfp boolean k() {
        return this.P && !this.u;
    }

    // $FF: synthetic method
    static boolean a(ReplayEngine var0) {
        return var0.P;
    }

    // $FF: synthetic method
    static boolean a(ReplayEngine var0, boolean var1) {
        return var0.P = var1;
    }
}
