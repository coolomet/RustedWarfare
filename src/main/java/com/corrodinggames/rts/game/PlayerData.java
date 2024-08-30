package com.corrodinggames.rts.game;

import android.graphics.Color;
import android.graphics.Paint;
import com.corrodinggames.rts.game.a.class_138;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.DummyNonUnitWithTeam;
import com.corrodinggames.rts.game.units.custom.class_585;
import com.corrodinggames.rts.game.units.custom.class_587;
import com.corrodinggames.rts.game.units.custom.class_588;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.custom.e.class_1065;
import com.corrodinggames.rts.game.units.custom.e.class_1069;
import com.corrodinggames.rts.game.units.custom.e.BuiltInResource;
import com.corrodinggames.rts.game.units.buildings.CommandCenter;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.SyncPacket;
import com.corrodinggames.rts.gameFramework.class_324;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.class_62;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.m.class_371;
import com.corrodinggames.rts.gameFramework.m.class_525;
import com.corrodinggames.rts.gameFramework.m.class_936;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameNetEngine;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import com.corrodinggames.rts.gameFramework.utility.class_694;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public abstract strictfp class PlayerData extends class_62 implements Comparable {
    static class_684 a = new class_684();
    static PlayerData[] b = new PlayerData[0];
    public static int c = 10;
    public static int d = 0;
    public static int e = 100;
    public static int f;
    public static final PlayerData g;
    public static final PlayerData h;
    public static final PlayerData i;
    private static PlayerData[] playerArray;
    public static PlayerData j;
    public int site;
    public final String l;
    public boolean m;
    public boolean n;
    public double credits;
    public double p;
    public int q;
    public int team;
    public OrderableUnit s;
    public OrderableUnit t;
    public boolean u;
    public String name;
    public boolean w;
    public int x;
    public boolean y;
    public Integer aiDifficulty;
    public Integer startUnit;
    public Integer B;
    public Integer color;
    public int gameColor;
    private boolean at;
    private int serverHostFlag;
    public boolean E;
    private int av;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean sharedControl_1;
    public boolean sharedControl_2;
    public final Object K;
    public int L;
    public int M;
    public byte[][] N;
    public String connectHexID;
    public String P;
    public int Q;
    public int R;
    public boolean S;
    public class_151 T;
    public boolean U;
    public byte V;
    public int ping;
    public long lastReciveTime;
    public long Y;
    public int Z;
    public boolean aa;
    public boolean ab;
    public int ac;
    int ad;
    public Paint ae;
    public Paint af;
    static int[] ag;
    static String[] ah;
    int ai;
    static int aj;
    class_588 ak;
    class_1069 al;
    public class_1065 am;
    public float an;
    public static float ao;
    public static float ap;
    long aq;
    double ar;

    public strictfp int a(PlayerData var1) {
        int var2 = this.ac - var1.ac;
        if (var2 != 0) {
            return var2;
        } else {
            int var3 = this.site - var1.site;
            if (var3 != 0) {
                return var3;
            } else {
                return this.name != null && var1.name != null ? this.name.compareTo(var1.name) : 0;
            }
        }
    }

    public strictfp void b(GameOutputStream var1) {
        var1.writeByte(this.site);
        var1.writeInt((int)this.credits);
        var1.writeInt(this.team);
        var1.writeIsString(this.name);
        var1.writeBoolean(this.U);
        if (var1.getPacketVersion() > 26) {
            var1.writeInt(this.getPing());
            var1.d("lastPingTimeReceivedAt");
            var1.writeLong(this.lastReciveTime);
        }

        if (var1.getPacketVersion() >= 55) {
            var1.writeBoolean(this.w);
            var1.writeInt(this.x);
        }

        if (var1.getPacketVersion() >= 91) {
            var1.writeInt(this.ac);
            var1.writeByte(0);
        }

        if (var1.getPacketVersion() >= 97) {
            var1.writeBoolean(this.sharedControl_1);
            var1.writeBoolean(this.sharedControl_2);
        }

        if (var1.getPacketVersion() >= 125) {
            var1.writeBoolean(this.E);
            var1.writeBoolean(this.at);
            var1.writeInt(this.serverHostFlag);
        }

        if (var1.getPacketVersion() >= 149) {
            var1.writeIsString(this.P);
            var1.writeInt(this.Q);
        }

        if (var1.getPacketVersion() >= 156) {
            var1.writeIsInt(this.aiDifficulty);
            var1.writeIsInt(this.startUnit);
            var1.writeIsInt(this.B);
            var1.writeIsInt(this.color);
            var1.writeInt(this.gameColor);
        }

    }

    public strictfp void c(GameOutputStream var1) {
        var1.writeByte(0);
        var1.writeInt(this.getPing());
        var1.writeBoolean(this.sharedControl_1);
        var1.writeBoolean(this.sharedControl_2);
    }

    public strictfp void a(GameInputStream var1) {
        var1.readByte();
        this.ping = var1.readInt();
        this.lastReciveTime = System.currentTimeMillis();
        this.sharedControl_1 = var1.readBoolean();
        this.sharedControl_2 = var1.readBoolean();
    }

    public strictfp void b(GameInputStream var1) {
        this.a(var1, false);
    }

    public strictfp void a(GameInputStream var1, boolean var2) {
        if (!var2) {
            this.f(var1.readByte());
            this.credits = (double)var1.readInt();
            this.p = 0.0;
            this.q = 0;
            this.team = var1.readInt();
            this.name = var1.isReadString();
            this.U = var1.readBoolean();
        } else {
            var1.readByte();
            var1.readInt();
            var1.readInt();
            var1.isReadString();
            var1.readBoolean();
        }

        if (var1.b() >= 14) {
            this.ping = var1.readInt();
            var1.readLong();
            this.lastReciveTime = System.currentTimeMillis();
        }

        int var4;
        boolean var8;
        if (var1.b() >= 34 && var1.getCacheInt() >= 55) {
            var8 = var1.readBoolean();
            var4 = var1.readInt();
            if (!var2) {
                this.w = var8;
                this.x = var4;
            }
        } else {
            GameEngine var3 = GameEngine.getGameEngine();
            if (var3.netEngine.B) {
                GameNetEngine.g("AI was skipping in networked game, steam version:" + var1.getCacheInt());
            }
        }

        if (var1.b() >= 50 && var1.getCacheInt() >= 91) {
            this.ac = var1.readInt();
            var1.readByte();
        }

        if (var1.b() >= 52 && var1.getCacheInt() >= 97) {
            this.sharedControl_1 = var1.readBoolean();
            this.sharedControl_2 = var1.readBoolean();
        }

        if (var1.b() >= 70 && var1.getCacheInt() >= 125) {
            var8 = var1.readBoolean();
            boolean var10 = var1.readBoolean();
            int var5 = var1.readInt();
            if (!var2) {
                this.E = var8;
                this.at = var10;
                this.serverHostFlag = var5;
            }
        }

        if (var1.b() >= 90 && var1.getCacheInt() >= 149) {
            String var9 = var1.isReadString();
            var4 = var1.readInt();
            if (!var2) {
                this.P = var9;
                this.Q = var4;
            }
        }

        if (var1.b() >= 93 && var1.getCacheInt() >= 156) {
            Integer var11 = var1.isReadInt();
            Integer var12 = var1.isReadInt();
            Integer var13 = var1.isReadInt();
            Integer var6 = var1.isReadInt();
            int var7 = var1.readInt();
            if (!var2) {
                if (this.aiDifficulty != var11) {
                    this.c("readIn aiDifficultyOverride was:" + this.aiDifficulty + " now:  " + var11);
                }

                this.aiDifficulty = var11;
                this.startUnit = var12;
                this.B = var13;
                this.color = var6;
                this.gameColor = var7;
            }
        }

    }

    public strictfp void a(GameOutputStream var1) {
        var1.d("Writing team: " + this.name);
        this.b(var1);
        if (var1.getPacketVersion() >= 44) {
            var1.writeByte(4);
            var1.writeBoolean(this.G);
            var1.writeBoolean(this.F);
            boolean var2 = true;
            var1.writeBoolean(var2);
            if (var2) {
                this.d(var1);
            }

            this.al.a(var1);
            class_585.a(this.ak, var1);
            var1.writeBoolean(this.y);
        }

    }

    public strictfp void c(GameInputStream var1) {
        this.b(var1);
        if (var1.b() >= 26) {
            byte var2 = var1.readByte();
            this.G = var1.readBoolean();
            if (var2 >= 1) {
                this.F = var1.readBoolean();
            }

            boolean var3 = var1.readBoolean();
            if (var3) {
                this.d(var1);
            }

            if (var2 >= 2) {
                this.al.a(var1);
            }

            if (var2 >= 3) {
                this.a(class_585.a(var1));
            }

            if (var2 >= 4) {
                this.y = var1.readBoolean();
            }
        }

    }

    public strictfp void d(GameOutputStream var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        var1.d("-- Saving fog --");
        var1.writeBoolean(this.N != null);
        if (this.N != null) {
            var1.writeInt(this.L);
            var1.writeInt(this.M);

            for(int var3 = 0; var3 < this.L; ++var3) {
                for(int var4 = 0; var4 < this.M; ++var4) {
                    var1.writeByte(this.N[var3][var4]);
                }
            }
        }

        var1.d("--End fog--");
    }

    public strictfp void d(GameInputStream var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        boolean var3 = var1.readBoolean();
        if (var3) {
            this.L = var1.readInt();
            this.M = var1.readInt();
            boolean var4 = true;
            int var5 = this.L;
            int var6 = this.M;
            if (var2.bL != null) {
                var5 = var2.bL.width;
                var6 = var2.bL.height;
                if (this.L != var5 || this.M != var6) {
                    GameEngine.print("Map size does not match fog size: " + this.L + "!=" + var5 + "|" + this.M + "!=" + var6);
                }
            }

            if (var4) {
                this.N = new byte[var5][var6];
            } else {
                this.N = (byte[][])null;
            }

            for(int var7 = 0; var7 < this.L; ++var7) {
                for(int var8 = 0; var8 < this.M; ++var8) {
                    if (var4) {
                        this.N[var7][var8] = var1.readByte();
                    } else {
                        var1.readByte();
                    }
                }
            }
        } else {
            this.N = (byte[][])null;
        }

    }

    public strictfp void a() {
        if (this.N != null) {
            for(int var1 = 0; var1 < this.L; ++var1) {
                for(int var2 = 0; var2 < this.M; ++var2) {
                    this.N[var1][var2] = 0;
                }
            }
        }

        GameEngine var3 = GameEngine.getGameEngine();
        if (var3.playerTeam == this) {
            var3.bW.O = true;
            if (var3.bL != null) {
                var3.bL.k();
                var3.bL.g();
            }
        }

    }

    public strictfp boolean b() {
        return this.team == -3;
    }

    public static strictfp ArrayList a(boolean var0) {
        ArrayList var1 = new ArrayList();

        for(int var2 = 0; var2 < f; ++var2) {
            PlayerData var3 = playerArray[var2];
            if (var3 != null && (var0 || var3.b())) {
                var1.add(var3);
            }
        }

        Collections.sort(var1);
        return var1;
    }

    public static strictfp ArrayList c() {
        return b(false);
    }

    public static strictfp ArrayList b(boolean var0) {
        ArrayList var1 = new ArrayList();

        for(int var2 = 0; var2 < f; ++var2) {
            PlayerData var3 = playerArray[var2];
            if (var3 != null && (var0 || !var3.b())) {
                var1.add(var3);
            }
        }

        return var1;
    }

    public static strictfp PlayerData[] d() {
        return b;
    }

    public static strictfp void e() {
        class_684 var0 = a;
        var0.clear();
        var0.add(i);
        var0.add(h);

        int var1;
        for(var1 = 0; var1 < c; ++var1) {
            PlayerData var2 = playerArray[var1];
            if (var2 != null) {
                var0.add(var2);
            }
        }

        if (b.length != var0.a) {
            b = new PlayerData[var0.a];
        }

        var1 = var0.a;
        Object[] var4 = var0.a();

        for(int var3 = 0; var3 < var1; ++var3) {
            b[var3] = (PlayerData)var4[var3];
        }

    }

    public static strictfp ArrayList f() {
        ArrayList var0 = new ArrayList();

        for(int var1 = 0; var1 < c; ++var1) {
            PlayerData var2 = playerArray[var1];
            if (var2 != null && !var2.b() && !var0.contains(var2.team)) {
                var0.add(var2.team);
            }
        }

        Collections.sort(var0);
        return var0;
    }

    public static strictfp int a(int var0, boolean var1) {
        int var2 = 0;

        for(int var3 = 0; var3 < c; ++var3) {
            PlayerData var4 = playerArray[var3];
            if (var4 != null && var4.team == var0 && !var4.b() && (!var1 || !var4.w)) {
                ++var2;
            }
        }

        return var2;
    }

    public static strictfp int g() {
        int var0 = 0;

        for(int var1 = 0; var1 < c; ++var1) {
            PlayerData var2 = playerArray[var1];
            if (var2 != null && !var2.b() && !var2.F && !var2.G) {
                ++var0;
            }
        }

        return var0;
    }

    @SneakyThrows
    public static strictfp void b(int var0, boolean var1) {
        if (var0 >= 10) {
            if (var0 != c) {
                if (var0 > e) {
                    throw new IOException("setMaxTeamId: " + var0 + " is over limit of:" + e);
                } else if (var1 || var0 > c) {
                    int var2 = var0 + d;
                    PlayerData[] var3 = new PlayerData[var2];

                    for(int var4 = 0; var4 < playerArray.length; ++var4) {
                        PlayerData var5 = playerArray[var4];
                        if (var4 < var3.length) {
                            var3[var4] = var5;
                        }
                    }

                    playerArray = var3;
                    c = var0;
                    f = var2;
                }
            }
        }
    }

    public static strictfp String getTeamName(int var0) {
        if (var0 == 0) {
            return "A";
        } else if (var0 == 1) {
            return "B";
        } else if (var0 == 2) {
            return "C";
        } else if (var0 == 3) {
            return "D";
        } else if (var0 == 4) {
            return "E";
        } else if (var0 == 5) {
            return "F";
        } else if (var0 == 6) {
            return "G";
        } else if (var0 == 7) {
            return "H";
        } else if (var0 == 8) {
            return "I";
        } else if (var0 == 9) {
            return "J";
        } else if (var0 == 10) {
            return "K";
        } else {
            return var0 == -3 ? "S" : "" + var0;
        }
    }

    public strictfp String getPlayerTeamName() {
        return getTeamName(this.team);
    }

    public strictfp void i() {
        this.E = false;
        this.at = false;
        this.serverHostFlag = -9999;
    }

    public strictfp boolean j() {
        return this.E;
    }

    public strictfp boolean k() {
        return this.serverHostFlag >= 0;
    }

    public strictfp void l() {
        GameEngine var1 = GameEngine.getGameEngine();
        this.serverHostFlag = var1.by;
    }

    public strictfp boolean m() {
        GameEngine var1 = GameEngine.getGameEngine();
        if ((this.F || this.G) && !var1.netEngine.gameMapData.sharedControl) {
            return false;
        } else if (this.w) {
            return false;
        } else if (this.isTimeOut()) {
            return false;
        } else {
            return !this.ab || this.k();
        }
    }

    public static strictfp int b(int var0) {
        int var1 = 0;

        for(int var2 = 0; var2 < c; ++var2) {
            PlayerData var3 = playerArray[var2];
            if (var3 != null && var3.team == var0 && var3.k() && var3.m()) {
                ++var1;
            }
        }

        return var1;
    }

    public static strictfp int c(int var0) {
        int var1 = 0;

        for(int var2 = 0; var2 < c; ++var2) {
            PlayerData var3 = playerArray[var2];
            if (var3 != null && var3.team == var0 && var3.m()) {
                ++var1;
            }
        }

        return var1;
    }

    public static strictfp void n() {
        for(int var0 = 0; var0 < c; ++var0) {
            PlayerData var1 = playerArray[var0];
            if (var1 != null) {
                var1.Z();
            }
        }

        Y();
    }

    public static strictfp void o() {
        for(int var0 = 0; var0 < c; ++var0) {
            PlayerData var1 = playerArray[var0];
            if (var1 != null) {
                var1.serverHostFlag = -9999;
            }
        }

    }

    public static strictfp void d(int var0) {
        GameEngine var1 = GameEngine.getGameEngine();
        if (var1.netEngine.isServer) {
            if (!var1.replayEngine.j()) {
                for(int var2 = 0; var2 < c; ++var2) {
                    PlayerData var3 = playerArray[var2];
                    if (var3 != null && var3.team == var0 && !var3.at) {
                        var3.at = true;
                        SyncPacket var4 = var1.cf.b();
                        var4.i = var3;
                        var4.r = true;
                        var4.u = 100;
                        var1.netEngine.a(var4);
                    }
                }

            }
        }
    }

    public static strictfp void e(int var0) {
        int var1 = -9999;

        for(int var2 = 0; var2 < c; ++var2) {
            PlayerData var3 = playerArray[var2];
            if (var3 != null && var3.team == var0 && var3.k() && var3.m() && var3.serverHostFlag > var1) {
                var1 = var3.serverHostFlag;
            }
        }

        if (var1 >= 0 && class_694.a(var1, 120000)) {
            PlayerData[] var6 = playerArray;
            int var7 = var6.length;

            for(int var4 = 0; var4 < var7; ++var4) {
                PlayerData var5 = var6[var4];
                if (var5 != null && var5.team == var0) {
                    var5.serverHostFlag = -9999;
                }
            }
        }

    }

    public strictfp boolean b(PlayerData var1) {
        return this.p() && var1 != null && this.d(var1);
    }

    public strictfp boolean p() {
        return this.sharedControl_1 || this.sharedControl_2;
    }

    public strictfp boolean q() {
        GameEngine var1 = GameEngine.getGameEngine();
        return var1.playerTeam == this;
    }

    public strictfp void c(boolean var1) {
        if (var1) {
            this.Q = 1;
        } else {
            this.Q = 0;
        }

    }

    public strictfp boolean r() {
        return this.Q == 1;
    }

    public final strictfp int a(boolean var1, boolean var2) {
        class_151 var3 = this.T;
        int var4 = var3.c;
        if (var1) {
            var4 += var3.f;
        }

        if (var2) {
            var4 += var3.e;
        }

        return var4;
    }

    public final strictfp int s() {
        return this.T.c + this.T.f + this.T.e;
    }

    public final strictfp int a(class_585 var1, boolean var2, boolean var3) {
        class_151 var4 = this.T;
        if (var4.d == 0) {
            return 0;
        } else {
            class_150 var5 = null;
            class_153 var6 = var4.p;
            class_150[] var7 = var6.b;
            int var8 = 0;

            for(int var9 = var6.c; var8 < var9; ++var8) {
                class_150 var10 = var7[var8];
                if (var10.a == var1) {
                    var5 = var10;
                    break;
                }
            }

            if (var5 == null) {
                var5 = var4.a(var1);
                if (var5.e > 50) {
                    var6.a(var5);
                }

                ++var5.e;
            }

            var8 = var5.b;
            if (var2) {
                var8 += var5.c;
            }

            if (var3) {
                var8 += var5.d;
            }

            return var8;
        }
    }

    public strictfp boolean t() {
        boolean var1 = false;
        class_151 var2 = this.e(false);
        if (this.T.b != var2.b) {
            GameEngine.print("unitCountExcludingBuildingsIncludingQueued: " + this.T.b + "!=" + var2.b + " (team:" + this.site + " fails: " + this.ad + ")");
            ++this.ad;
            var1 = true;
        }

        if (this.T.a != var2.a) {
            GameEngine.print("unitsMax: " + this.T.a + "!=" + var2.a + " (team:" + this.site + " fails: " + this.ad + ")");
            ++this.ad;
            var1 = true;
        }

        if (this.T.g != var2.g) {
            GameEngine.print("incomeRate: " + this.T.g + "!=" + var2.g + " (team:" + this.site + " fails: " + this.ad + ")");
            ++this.ad;
            var1 = true;
        }

        if (this.T.f != var2.f) {
            GameEngine.print("incompleteUnitCountOfAllTypes: " + this.T.f + "!=" + var2.f + " (team:" + this.site + " fails: " + this.ad + ")");
            ++this.ad;
            var1 = true;
        }

        if (this.T.e != var2.e) {
            GameEngine.print("queuedCountOfAllTypes: " + this.T.e + "!=" + var2.e + " (team:" + this.site + " fails: " + this.ad + ")");
            ++this.ad;
            var1 = true;
        }

        if (this.T.c != var2.c) {
            GameEngine.print("unitCountOfAllTypesOnlyCompleted: " + this.T.c + "!=" + var2.c + " (team:" + this.site + " fails: " + this.ad + ")");
            ++this.ad;
            var1 = true;
        }

        if (!this.T.h.e(var2.h)) {
            GameEngine.print("customIncomeRate: " + this.T.h + "!=" + var2.h + " (team:" + this.site + " fails: " + this.ad + ")");
            GameEngine.print("currentCaches:" + this.T.h.a(false, true, 30, true, true));
            GameEngine.print("targetUnitCache:" + var2.h.a(false, true, 30, true, true));
            ++this.ad;
            var1 = true;
        }

        if (!this.T.l.e(var2.l)) {
            GameEngine.print("streamingRateNegative (team:" + this.site + " fails: " + this.ad + ")");
            GameEngine.print("currentCaches:" + this.T.l.a(false, true, 30, true, true));
            GameEngine.print("targetUnitCache:" + var2.l.a(false, true, 30, true, true));
            ++this.ad;
            var1 = true;
        }

        if (!this.T.k.e(var2.k)) {
            GameEngine.print("streamingRatePositive (team:" + this.site + " fails: " + this.ad + ")");
            GameEngine.print("currentCaches:" + this.T.k.a(false, true, 30, true, true));
            GameEngine.print("targetUnitCache:" + var2.k.a(false, true, 30, true, true));
            ++this.ad;
            var1 = true;
        }

        if (var1) {
        }

        return var1;
    }

    private strictfp class_151 e(boolean var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        class_151 var3 = new class_151();
        var3.a = var2.bB;
        Unit[] var4 = Unit.bE.a();
        int var5 = 0;

        for(int var6 = Unit.bE.size(); var5 < var6; ++var5) {
            Unit var7 = var4[var5];
            if (var7.bX == this) {
                var3.a(var7);
                if (var1) {
                    var7.bY = true;
                }
            }
        }

        if (var3.a > var2.bC) {
            var3.a = var2.bC;
        }

        return var3;
    }

    public strictfp void d(boolean var1) {
        if (var1 || this.S) {
            this.T = this.e(true);
            this.S = false;
            if (this.R < this.T.b) {
                this.R = this.T.b;
            }

            if (!this.n && this.T.m) {
                this.n = true;
            }

            if (!this.m && this.s() > 0) {
                this.m = true;
            }

            this.T();
        }
    }

    public strictfp int u() {
        int var1 = this.T.g;
        var1 = (int)((float)var1 * this.D());
        return var1;
    }

    public strictfp int v() {
        return (int)((float)this.u() * this.E() + 0.5F);
    }

    public strictfp int a(BuiltInResource var1) {
        int var2 = 0;
        var2 -= (int)this.T.l.a(var1);
        return var2;
    }

    public strictfp int b(BuiltInResource var1) {
        int var2;
        if (var1 == BuiltInResource.D) {
            var2 = this.T.g;
        } else {
            var2 = (int)this.T.h.a(var1);
        }

        var2 += (int)this.T.k.a(var1);
        GameEngine var3 = GameEngine.getGameEngine();
        boolean var4 = false;
        if (var1 == BuiltInResource.D) {
            var4 = true;
        }

        if (var4) {
            var2 = (int)((float)var2 * this.D());
        }

        return var2;
    }

    public strictfp int w() {
        return this.T.b;
    }

    public strictfp int x() {
        return this.T.a;
    }

    public strictfp String y() {
        int var1 = this.getPing();
        if (var1 == -99) {
            return "";
        } else if (this.w) {
            return "";
        } else if (var1 == -2) {
            return "(disconnected)";
        } else {
            return var1 == -1 ? "(disconnected)" : "(" + var1 + ")";
        }
    }

    public strictfp String getStatus() {
        int var1 = this.getPing();
        if (var1 == -99) {
            return "HOST";
        } else if (this.w) {
            return "-";
        } else if (var1 == -1) {
            return "N/A";
        } else if (var1 == -2) {
            return "-";
        } else {
            return this.r() ? var1 + " (HOST)" : "" + var1;
        }
    }

    public strictfp int getPing() {
        if (this.lastReciveTime == -1L) {
            return -2;
        } else {
            return this.lastReciveTime < System.currentTimeMillis() - 5000L ? -1 : this.ping;
        }
    }

    public strictfp boolean isTimeOut() {
        if (this.lastReciveTime == -99L) {
            return false;
        } else {
            return this.lastReciveTime != -1L && this.lastReciveTime < System.currentTimeMillis() - 15000L;
        }
    }

    public strictfp void a(float var1) {
        this.an += var1;
        if (this.an > 90.0F) {
            this.an = 0.0F;
            this.am.a();
        }

        ++this.q;
        if (this.q > 1000 && this.p != 0.0) {
            GameEngine.log("Warning: anti-lag credits is still: " + this.p + " (force clearing)");
            this.p = 0.0;
        }

    }

    public final strictfp int C() {
        if (this.y) {
            return this.x;
        } else {
            GameEngine var1 = GameEngine.getGameEngine();
            if ((var1.netEngine.B || var1.replayEngine.i()) && !var1.netEngine.F) {
                if (this.aiDifficulty != null && this.aiDifficulty != this.x) {
                    this.c("aiDifficultyOverride:  " + this.aiDifficulty + "!=" + this.x);
                }

                return this.x;
            } else if (this.aiDifficulty != null) {
                return this.aiDifficulty;
            } else {
                int var2 = GameEngine.getGameEngine().settingsEngine.aiDifficulty;
                return var2;
            }
        }
    }

    public final strictfp float D() {
        GameEngine var1 = GameEngine.getGameEngine();
        return var1.O() ? var1.netEngine.gameMapData.income : 1.0F;
    }

    public final strictfp float E() {
        if (!this.w) {
            return 1.0F;
        } else {
            int var1 = this.C();
            float var2 = 1.0F;
            if (var1 > 0) {
                var2 += (float)var1 * 0.4F;
            } else {
                var2 += (float)var1 * 0.3F;
            }

            if (var1 == 3) {
                ++var2;
            }

            if (var2 < 0.1F) {
                var2 = 0.1F;
            }

            return var2;
        }
    }

    public final strictfp void b(float var1) {
        if (!this.w) {
            this.c(var1);
        } else {
            float var2 = this.E();
            this.c(var2 * var1);
        }
    }

    public final strictfp void c(float var1) {
        var1 *= this.D();
        this.d(var1);
    }

    public final strictfp void d(float var1) {
        this.credits += (double)var1;
        if (this.credits > 9.99999999E8) {
            this.credits = 9.99999999E8;
        }

    }

    public static strictfp void F() {
        try {
            b(10, true);
        } catch (Exception var1) {
            throw new RuntimeException(var1);
        }

        for(int var0 = 0; var0 < playerArray.length; ++var0) {
            playerArray[var0] = null;
        }

    }

    public static strictfp Player a(String var0) {
        if (var0 != null && !var0.equals("")) {
            for(int var1 = 0; var1 < playerArray.length; ++var1) {
                PlayerData var2 = playerArray[var1];
                if (var2 != null && var0.equals(var2.connectHexID)) {
                    if (var2 instanceof Player) {
                        return (Player)var2;
                    }

                    GameEngine.print("Player:" + var1 + " with matching clientId is not an instanceof player");
                }
            }

            return null;
        } else {
            GameEngine.print("findExistingPlayer: No clientId id");
            return null;
        }
    }

    public static strictfp Player b(String var0) {
        if (var0 != null && !var0.equals("")) {
            for(int var1 = 0; var1 < playerArray.length; ++var1) {
                PlayerData var2 = playerArray[var1];
                if (var2 != null && var0.equals(var2.P)) {
                    if (var2 instanceof Player) {
                        return (Player)var2;
                    }

                    GameEngine.print("Player:" + var1 + " with matching clientId is not an instanceof player");
                }
            }

            return null;
        } else {
            GameEngine.print("No id");
            return null;
        }
    }

    public static strictfp int getNullSite() {
        for(int var0 = 0; var0 < c; ++var0) {
            if (playerArray[var0] == null) {
                return var0;
            }
        }

        return -1;
    }

    public static strictfp int m5451H() {
        int var0;
        for(var0 = c; var0 < f; ++var0) {
            if (playerArray[var0] == null) {
                return var0;
            }
        }

        for(var0 = c - 1; var0 >= 0; --var0) {
            if (playerArray[var0] == null) {
                return var0;
            }
        }

        return -1;
    }

    public strictfp void I() {
        for(int var1 = 0; var1 < playerArray.length; ++var1) {
            if (playerArray[var1] == this) {
                playerArray[var1] = null;
            }
        }

    }

    public PlayerData() {
        this.site = -1;
        this.l = "Note to modifiers: Changing credits will not allow you to cheat in multiplayer games, but it will only break sync";
        this.credits = 4000.0;
        this.p = 0.0;
        this.q = 0;
        this.s = DummyNonUnitWithTeam.a(this);
        this.t = DummyNonUnitWithTeam.a(this);
        this.u = false;
        this.gameColor = -1;
        this.serverHostFlag = -9999;
        this.av = -9999;
        this.K = new Object();
        this.S = true;
        this.T = new class_151();
        this.ping = -1;
        this.lastReciveTime = -1L;
        this.Y = -1L;
        this.Z = -1;
        this.ac = 0;
        this.ae = new class_525();
        this.af = new class_525();
        this.ai = -2;
        this.ak = class_585.d;
        this.al = new class_1069();
        this.am = new class_1065();
        this.aq = -9999L;
        this.w = this instanceof class_138;
    }

    public PlayerData(int var1) {
        this(var1, true);
    }

    public PlayerData(int var1, boolean var2) {
        this();
        this.c(var1, var2);
    }

    public strictfp void f(int var1) {
        this.c(var1, true);
    }

    public strictfp void c(int var1, boolean var2) {
        if (this.site != var1) {
            if (var2) {
                this.I();
            }

            this.site = var1;
            this.team = var1;
            if (var2 && var1 != -3) {
                PlayerData var3 = playerArray[var1];
                if (var3 != null) {
                    var3.c("Being replaced");
                }

                playerArray[var1] = this;
            }

            this.J();
        }

    }

    public strictfp void J() {
        int var1 = this.K();
        this.ae.b(var1);
        int var2 = Color.a(Color.a(var1), (int)((float)Color.b(var1) * 0.5F), (int)((float)Color.c(var1) * 0.5F), (int)((float)Color.d(var1) * 0.5F));
        this.af.b(var2);
    }

    public strictfp boolean a(double var1) {
        return this.credits >= var1 || var1 == 0.0;
    }

    public strictfp boolean g(int var1) {
        return this.credits + this.p >= (double)var1 || var1 == 0;
    }

    public final strictfp boolean c(PlayerData var1) {
        if (var1 != i && this != i) {
            return this.team != var1.team;
        } else {
            return false;
        }
    }

    public final strictfp boolean d(PlayerData var1) {
        if (var1 == i && this == i) {
            return true;
        } else if (var1 != i && this != i) {
            return this.team == var1.team;
        } else {
            return false;
        }
    }

    public strictfp int K() {
        return i(this.R());
    }

    public static strictfp void L() {
        GameEngine var0 = GameEngine.getGameEngine();

        try {
            d(var0.settingsEngine.teamColors);
        } catch (IllegalArgumentException var3) {
            GameEngine.a((String)("initColors: Failed to read setting: '" + var0.settingsEngine.teamColors + "': " + var3.getMessage()), (Throwable)var3);
            d("#00ff00,#d02013,#0463f3,#ffff40,#00ffff,#d0f8f7,#000000,#ff00ea,#ff7f18,#9368c4");
        }

        try {
            e(var0.settingsEngine.teamColorsNames);
        } catch (IllegalArgumentException var2) {
            GameEngine.a((String)("initColors: Failed to read setting: '" + var0.settingsEngine.teamColorsNames + "': " + var2.getMessage()), (Throwable)var2);
            e("GREEN,RED,BLUE,YELLOW,CYAN,WHITE,BLACK,PINK,ORANGE,PURPLE");
        }

    }

    private static strictfp void d(String var0) {
        String[] var1 = var0.split(",");
        if (var1.length != 10) {
            throw new IllegalArgumentException("Expected 10 hex colors");
        } else {
            for(int var2 = 0; var2 < 10; ++var2) {
                String var3 = var1[var2];
                ag[var2] = Color.a(var3);
            }

        }
    }

    private static strictfp void e(String var0) {
        String[] var1 = var0.split(",");
        if (var1.length != 10) {
            throw new IllegalArgumentException("Expected 10 team color names");
        } else {
            for(int var2 = 0; var2 < 10; ++var2) {
                ah[var2] = var1[var2];
            }

        }
    }

    public strictfp int M() {
        return this.team == -3 ? i(-3) : h(this.site);
    }

    public static strictfp int h(int var0) {
        return var0 >= c ? i(-3) : i(var0 % 2);
    }

    public static strictfp int i(int var0) {
        if (var0 >= 0 && var0 < 10) {
            return ag[var0];
        } else {
            return var0 == -3 ? Color.a(185, 90, 90, 90) : -7829368;
        }
    }

    public strictfp String N() {
        if (this.site == -1) {
            return "GRAY";
        } else {
            return this.site == -2 ? "GRAY" : j(this.R());
        }
    }

    public static strictfp String j(int var0) {
        return var0 >= 0 && var0 < 10 ? ah[var0] : "GRAY";
    }

    public static strictfp TeamImageCache[] a(TeamImageCache var0) {
        return a(var0, ColoringMode.PURE_GREEN, false);
    }

    public static strictfp TeamImageCache[] a(TeamImageCache var0, ColoringMode var1, boolean var2) {
        return var2 && !var0.A() ? a(var0, var1) : b(var0, var1);
    }

    public static strictfp TeamImageCache[] a(TeamImageCache var0, ColoringMode var1) {
        TeamImageCache[] var2 = new TeamImageCache[10];
        if ((!GameEngine.isModsInSD || GameEngine.aW) && var1 != ColoringMode.DISABLED) {
            TeamImageCache[] var7 = var0.getTeamImageCache(var1);
            if (var7 != null) {
                return var7;
            } else {
                com.corrodinggames.rts.gameFramework.Unit var4 = GameEngine.getGameEngine().cd;
                var4.a(class_324.D);

                for(int var5 = 0; var5 < var2.length; ++var5) {
                    int var6 = i(var5);
                    if (var5 == 0) {
                        var2[var5] = var0;
                    } else {
                        var2[var5] = new class_371(var0, var6, var1, var5);
                    }
                }

                var4.b(class_324.D);
                var0.setTeamImageCache(var1, var2);
                return var2;
            }
        } else {
            for(int var3 = 0; var3 < var2.length; ++var3) {
                var2[var3] = var0;
            }

            return var2;
        }
    }

    public static strictfp TeamImageCache[] b(TeamImageCache var0, ColoringMode var1) {
        TeamImageCache[] var2 = new TeamImageCache[10];
        if ((!GameEngine.isModsInSD || GameEngine.aW) && var1 != ColoringMode.DISABLED && !var0.A()) {
            TeamImageCache[] var8 = var0.getTeamImageCache(var1);
            if (var8 != null) {
                return var8;
            } else {
                com.corrodinggames.rts.gameFramework.Unit var4 = GameEngine.getGameEngine().cd;
                var4.a(class_324.D);
                int[] var5 = new int[10];
                int[] var6 = new int[10];

                int var7;
                for(var7 = 0; var7 < var5.length; var6[var7] = var7++) {
                    var5[var7] = i(var7);
                }

                for(var7 = 0; var7 < var2.length; ++var7) {
                    if (var7 != 0) {
                        var2[var7] = var0.h();
                        var2[var7].a("color(" + var7 + "):" + var0.a());
                        var2[var7].j();
                    }
                }

                var0.j();
                if (var1 == ColoringMode.HUE_ADD) {
                    b(var0, var2, var5);
                } else if (var1 == ColoringMode.HUE_SHIFT) {
                    a(var0, var2, var5, var6);
                } else {
                    a(var0, var2, var5);
                }

                for(var7 = 0; var7 < var2.length; ++var7) {
                    if (var2[var7] != null) {
                        var2[var7].p();
                        var2[var7].s();
                    }
                }

                var0.r();
                var2[0] = var0;
                var4.b(class_324.D);
                var0.setTeamImageCache(var1, var2);
                return var2;
            }
        } else {
            for(int var3 = 0; var3 < var2.length; ++var3) {
                var2[var3] = var0;
            }

            return var2;
        }
    }

    public static strictfp void a(TeamImageCache var0, TeamImageCache[] var1, int[] var2) {
        int var3 = var0.m();
        int var4 = var0.l();
        int[] var5 = new int[var2.length];
        int[] var6 = new int[var2.length];
        int[] var7 = new int[var2.length];

        for(int var8 = 0; var8 < var2.length; ++var8) {
            var5[var8] = Color.b(var2[var8]);
            var6[var8] = Color.c(var2[var8]);
            var7[var8] = Color.d(var2[var8]);
        }

        float var23 = 0.003921569F;

        for(int var9 = 0; var9 < var4; ++var9) {
            for(int var10 = 0; var10 < var3; ++var10) {
                int var11 = var0.a(var10, var9);
                int var12 = class_936.a(var11);
                int var13;
                if (var12 == 0) {
                    if (var11 != 0) {
                        for(var13 = 0; var13 < var1.length; ++var13) {
                            if (var1[var13] != null) {
                                var1[var13].a(var10, var9, 0);
                            }
                        }
                    }
                } else {
                    var13 = class_936.c(var11);
                    if (var13 > 0) {
                        int var14 = class_936.b(var11);
                        int var15 = class_936.d(var11);
                        if (var14 == var15) {
                            int var16;
                            int var19;
                            int var20;
                            if (var14 == 0) {
                                var16 = var13;

                                for(int var24 = 0; var24 < var1.length; ++var24) {
                                    if (var1[var24] != null) {
                                        int var25 = var5[var24] * var16 >> 8;
                                        var19 = var6[var24] * var16 >> 8;
                                        var20 = var7[var24] * var16 >> 8;
                                        var1[var24].a(var10, var9, Color.a(var12, var25, var19, var20));
                                    }
                                }
                            } else if (var13 != var14) {
                                var16 = var14;
                                float var17 = (float)var14 * 0.003921569F;
                                float var18 = (float)var13 * 0.003921569F - var17;

                                for(var19 = 0; var19 < var1.length; ++var19) {
                                    if (var1[var19] != null) {
                                        var20 = (int)((float)var16 + (float)var5[var19] * var18);
                                        int var21 = (int)((float)var16 + (float)var6[var19] * var18);
                                        int var22 = (int)((float)var16 + (float)var7[var19] * var18);
                                        var20 = class_340.b(var20, 0, 255);
                                        var21 = class_340.b(var21, 0, 255);
                                        var22 = class_340.b(var22, 0, 255);
                                        var1[var19].a(var10, var9, Color.a(var12, var20, var21, var22));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    public static strictfp void a(TeamImageCache var0, TeamImageCache[] var1, int[] var2, int[] var3) {
        int var4 = var0.m();
        int var5 = var0.l();
        int[] var6 = new int[var2.length];
        int[] var7 = new int[var2.length];
        int[] var8 = new int[var2.length];

        int var9;
        for(var9 = 0; var9 < var2.length; ++var9) {
            var6[var9] = Color.b(var2[var9]);
            var7[var9] = Color.c(var2[var9]);
            var8[var9] = Color.d(var2[var9]);
        }

        for(var9 = 0; var9 < var5; ++var9) {
            for(int var10 = 0; var10 < var4; ++var10) {
                int var11 = var0.a(var10, var9);
                int var12 = Color.a(var11);
                int var13;
                if (var12 == 0) {
                    if (Color.b(var11) > 0 || Color.c(var11) > 0 || Color.d(var11) > 0) {
                        for(var13 = 0; var13 < var1.length; ++var13) {
                            if (var1[var13] != null) {
                                var1[var13].a(var10, var9, Color.a(0, 0, 0, 0));
                            }
                        }
                    }
                } else {
                    var13 = Color.c(var11);
                    int var14 = Color.b(var11);
                    int var15 = Color.d(var11);
                    float var16 = (float)class_340.c(class_340.c(var14, var13), var15);
                    float var17 = (float)class_340.d(var14 - var13);
                    var17 = class_340.f(var17, (float)class_340.d(var13 - var15));
                    var17 = class_340.f(var17, (float)class_340.d(var15 - var14));
                    if (var17 > 15.0F) {
                        for(int var18 = 0; var18 < var1.length; ++var18) {
                            if (var1[var18] != null) {
                                float var19 = var17 / 255.0F;
                                int var20 = (int)(var16 + (float)var6[var18] * var19);
                                int var21 = (int)(var16 + (float)var7[var18] * var19);
                                int var22 = (int)(var16 + (float)var8[var18] * var19);
                                var20 = class_340.b(var20, 0, 255);
                                var21 = class_340.b(var21, 0, 255);
                                var22 = class_340.b(var22, 0, 255);
                                var1[var18].a(var10, var9, Color.a(var12, var20, var21, var22));
                            }
                        }
                    }
                }
            }
        }

    }

    public static strictfp void b(TeamImageCache var0, TeamImageCache[] var1, int[] var2) {
        int var3 = var0.m();
        int var4 = var0.l();
        int[] var5 = new int[var2.length];
        int[] var6 = new int[var2.length];
        int[] var7 = new int[var2.length];

        int var8;
        for(var8 = 0; var8 < var2.length; ++var8) {
            var5[var8] = Color.b(var2[var8]);
            var6[var8] = Color.c(var2[var8]);
            var7[var8] = Color.d(var2[var8]);
        }

        for(var8 = 0; var8 < var3; ++var8) {
            for(int var9 = 0; var9 < var4; ++var9) {
                int var10 = var0.a(var8, var9);
                int var11 = Color.a(var10);
                if (var11 > 0) {
                    int var12 = Color.b(var10);
                    int var13 = Color.c(var10);
                    int var14 = Color.d(var10);
                    float var15 = 0.15F;

                    for(int var16 = 0; var16 < var1.length; ++var16) {
                        int var17 = (int)((float)var12 + (float)var5[var16] * var15);
                        int var18 = (int)((float)var13 + (float)var6[var16] * var15);
                        int var19 = (int)((float)var14 + (float)var7[var16] * var15);
                        var17 = class_340.b(var17, 0, 255);
                        var18 = class_340.b(var18, 0, 255);
                        var19 = class_340.b(var19, 0, 255);
                        if (var1[var16] != null) {
                            var1[var16].a(var8, var9, Color.a(var11, var17, var18, var19));
                        }
                    }
                }
            }
        }

    }

    public static strictfp PlayerData getPlayerData(int var0) {
        if (var0 == -1) {
            return i;
        } else if (var0 == -2) {
            return h;
        } else if (var0 >= f) {
            GameEngine.warn("team index too high: " + var0);
            return null;
        } else if (var0 < 0) {
            GameEngine.warn("team index too low: " + var0);
            return null;
        } else {
            return playerArray[var0];
        }
    }

    public strictfp void e(float var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        if (this.ai > 0) {
            --this.ai;
        } else {
            if (this.ai == -2) {
                this.ai = this.site;
            } else {
                this.ai = 10;
            }

            if (!this.G && !var2.replayEngine.j()) {
                boolean var3 = false;
                boolean var4 = false;
                boolean var5 = false;
                boolean var6 = var2.netEngine.gameMapData.sharedControl;
                boolean var7 = false;
                Unit[] var8 = Unit.bE.a();
                int var9 = 0;

                Unit var11;
                for(int var10 = Unit.bE.size(); var9 < var10; ++var9) {
                    var11 = var8[var9];
                    if (var11.bX == this) {
                        if (!var11.cT()) {
                            var3 = true;
                            if (!this.F && (var11.bJ() || var11.ak())) {
                                var4 = true;
                                break;
                            }
                        } else {
                            var7 = true;
                        }
                    } else if (var6 && var11.bX != null && var11.bX.d(this) && !var11.cT()) {
                        var5 = true;
                    }
                }

                if (!var3 && !var5) {
                    boolean var14 = false;
                    if (var7 && var2.tick < 100 && var2.bv) {
                        var14 = true;
                    }

                    this.G = true;
                    this.a();
                    Iterator var15 = Unit.bE.iterator();

                    while(var15.hasNext()) {
                        var11 = (Unit)var15.next();
                        if (var11.bX == this && !var11.u()) {
                            if (var14 && !var11.bV && var11.cT()) {
                                class_31 var12 = var11.r();
                                String var13 = var11.c() + " Warning: This unit got ignored in defeated check and now being removed";
                                if (var12 instanceof class_591 && ((class_591)var12).aO) {
                                    var13 = var13 + " (Likely due to canNotBeDirectlyAttacked:true)";
                                }

                                GameNetEngine.a((String)null, (String)var13);
                            }

                            var11.cj();
                        }
                    }

                    var2.netEngine.i(this);
                }

                if (!var4 && !this.F && !this.G) {
                    this.F = true;
                    var2.netEngine.h(this);
                }
            }

        }
    }

    public strictfp void a(OrderableUnit var1) {
    }

    public static strictfp void b(OrderableUnit var0) {
        for(int var1 = 0; var1 < c; ++var1) {
            PlayerData var2 = playerArray[var1];
            if (var2 != null) {
                var2.a(var0);
            }
        }

    }

    public static strictfp void a(Unit var0) {
        if (var0.bX != null && var0.bY && var0.bL) {
            PlayerData var1 = var0.bX;
            var0.bY = false;
            var1.T.b(var0);
            var0.dj();
        }

    }

    public static strictfp void b(Unit var0) {
        a(var0);
    }

    public static strictfp void c(Unit var0) {
        if (var0.bX != null && !var0.bY && var0.bL && !var0.bV) {
            var0.bY = true;
            PlayerData var1 = var0.bX;
            var1.T.a(var0);
            var0.di();
            if (!var1.n && var1.T.m) {
                var1.n = true;
            }

            if (!var1.m) {
                var1.m = true;
            }

            var1.T();
        }

    }

    public static strictfp void O() {
        i.S = true;
        h.S = true;

        PlayerData var1;
        for(Iterator var0 = c().iterator(); var0.hasNext(); var1.S = true) {
            var1 = (PlayerData)var0.next();
        }

    }

    public static strictfp void P() {
        GameEngine var0 = GameEngine.getGameEngine();
        if (var0.M()) {
            GameEngine.log("Skipping updateAllCachesFromChangedMetadata due to desync risk");
        } else {
            for(int var1 = 0; var1 < c; ++var1) {
                PlayerData var2 = playerArray[var1];
                if (var2 != null) {
                    var2.S = true;
                }
            }

        }
    }

    public static strictfp void f(float var0) {
        GameEngine var1 = GameEngine.getGameEngine();
        i.a(var0);
        h.a(var0);

        for(int var2 = 0; var2 < c; ++var2) {
            PlayerData var3 = playerArray[var2];
            if (var3 != null) {
                var3.a(var0);
                var3.e(var0);
                int var4;
                if (!var3.at) {
                    var4 = b(var3.team);
                    if (var4 > 0) {
                        int var5 = c(var3.team);
                        if (var4 >= var5) {
                            d(var3.team);
                            o();
                        } else {
                            e(var3.team);
                        }
                    }
                }

                if (var3.E) {
                    if (var3.av < 0) {
                        var3.av = var1.by;
                    }

                    if (!var3.G) {
                        var4 = 0;
                        Iterator var9 = Unit.bE.iterator();

                        while(var9.hasNext()) {
                            Unit var6 = (Unit)var9.next();
                            if (var6.bX == var3 && !var6.u()) {
                                boolean var7 = false;
                                byte var8 = 1;
                                if (class_694.a(var3.av, 10000)) {
                                    var7 = true;
                                    var8 = 50;
                                } else if (class_694.a(var3.av, 6000)) {
                                    var7 = class_340.a(var6, 0, 100) > 90;
                                    var8 = 20;
                                } else if (class_694.a(var3.av, 2000)) {
                                    var7 = class_340.a(var6, 0, 100) > 98;
                                    var8 = 2;
                                }

                                if (var6 instanceof CommandCenter) {
                                    var7 = true;
                                }

                                if (var7) {
                                    var6.health = -1.0F;
                                    ++var4;
                                    if (var4 > var8) {
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (var1.P() && var1.settingsEngine.aiDifficulty != aj) {
            var1.netEngine.aq();
            aj = var1.settingsEngine.aiDifficulty;
        }

    }

    public static strictfp void g(float var0) {
        e();
        PlayerData[] var1 = d();
        PlayerData[] var2 = var1;
        int var3 = var1.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            PlayerData var5 = var2[var4];
            var5.d(false);
        }

    }

    public static strictfp void Q() {
        i.d(false);

        for(int var0 = 0; var0 < c; ++var0) {
            PlayerData var1 = playerArray[var0];
            if (var1 != null && !var1.b() && !var1.G && !var1.F && !var1.E) {
                GameEngine var2 = GameEngine.getGameEngine();
                var2.netEngine.g(var1);
            }
        }

    }

    public static strictfp void h(float var0) {
        for(int var1 = 0; var1 < c; ++var1) {
            PlayerData var2 = playerArray[var1];
            if (var2 != null && var2 instanceof class_138) {
                class_138 var3 = (class_138)var2;
                var3.i(var0);
            }
        }

    }

    public strictfp int R() {
        return this.gameColor == -1 ? this.S() : this.gameColor;
    }

    public strictfp int S() {
        if (this.site == -1) {
            return 5;
        } else if (this.site == -2) {
            return 5;
        } else {
            int var1 = this.site;
            if (var1 >= 10) {
                var1 %= 10;
            }

            if (c > 10) {
                PlayerData var2 = GameEngine.getGameEngine().netEngine.z;
                if (var2 != null && var2 != this && var2.R() == var1) {
                    if (var1 != 5) {
                        var1 = 5;
                    } else {
                        var1 = 4;
                    }
                }
            }

            return var1;
        }
    }

    public strictfp void T() {
    }

    public strictfp void a(class_588 var1) {
        this.ak = var1;
    }

    public strictfp class_588 U() {
        return this.ak;
    }

    public strictfp void b(class_588 var1) {
        class_588 var2 = this.U();
        if (var2 != null && var2.b() != 0) {
            if (!class_585.b(var2, var1)) {
                class_587 var3 = new class_587(var2);
                if (var3.a(var1)) {
                    this.a(var3.a());
                }
            }
        } else {
            this.a(var1);
        }
    }

    public strictfp void c(class_588 var1) {
        class_588 var2 = this.U();
        if (var2 != null && var2.b() != 0) {
            if (class_585.a(var1, var2)) {
                class_587 var3 = new class_587(var2);
                if (var3.b(var1)) {
                    this.a(var3.a());
                }
            }
        }
    }

    public strictfp class_1069 V() {
        return this.al;
    }

    public strictfp double c(BuiltInResource var1) {
        return this.al.a(var1);
    }

    public strictfp boolean a(Side var1, PlayerData var2) {
        if (var1 == Side.OWN) {
            return var2 == this;
        } else if (var1 == Side.ANY) {
            return true;
        } else if (var1 == Side.ALLY) {
            return this.d(var2);
        } else if (var1 != Side.ALLY_NOT_OWN) {
            if (var1 == Side.ENEMY) {
                return this.c(var2);
            } else if (var1 == Side.NEUTRAL) {
                return var2 == i;
            } else if (var1 == Side.NOT_OWN) {
                return var2 != this;
            } else {
                throw new RuntimeException("Unsupported type: " + var1);
            }
        } else {
            return var2 != this && this.d(var2);
        }
    }

    public strictfp void d(Unit var1) {
    }

    public strictfp void W() {
        GameEngine.log("debugUnitCountByType for team:" + this.site);
        class_684 var1 = new class_684();
        Unit[] var2 = Unit.bE.a();
        int var3 = 0;

        int var4;
        for(var4 = Unit.bE.size(); var3 < var4; ++var3) {
            Unit var5 = var2[var3];
            if (var5.bX == this && !var5.bV) {
                class_31 var6 = var5.dz;
                boolean var7 = false;
                Iterator var8 = var1.iterator();

                while(var8.hasNext()) {
                    class_152 var9 = (class_152)var8.next();
                    if (var9.a == var6) {
                        ++var9.b;
                        var7 = true;
                        break;
                    }
                }

                if (!var7) {
                    class_152 var14 = new class_152();
                    var14.a = var6;
                    var14.b = 1;
                    var1.add(var14);
                }
            }
        }

        GameEngine.log("--- Units ---");
        var3 = 0;
        Iterator var10 = var1.iterator();

        while(var10.hasNext()) {
            class_152 var11 = (class_152)var10.next();
            if (!var11.a.k()) {
                GameEngine.log(var11.a.i() + " - count:" + var11.b);
                var3 += var11.b;
            }
        }

        GameEngine.log("total:" + var3);
        GameEngine.log("--- Buildings/Ignored in count ---");
        var4 = 0;
        Iterator var12 = var1.iterator();

        while(var12.hasNext()) {
            class_152 var13 = (class_152)var12.next();
            if (var13.a.k()) {
                GameEngine.log(var13.a.i() + " - count:" + var13.b);
                var4 += var13.b;
            }
        }

        GameEngine.log("total:" + var4);
    }

    public strictfp void c(String var1) {
        GameEngine.log("Team(id: " + this.site + ", name:" + this.name + "):" + var1);
    }

    public strictfp int b(class_585 var1, boolean var2, boolean var3) {
        int var4 = 0;
        if (this == i) {
            return 0;
        } else {
            PlayerData[] var5 = playerArray;
            int var6 = c;

            for(int var7 = 0; var7 < var6; ++var7) {
                PlayerData var8 = var5[var7];
                if (var8 != null && this != var8 && this.team != var8.team) {
                    if (var1 == null) {
                        var4 += var8.a(var2, var3);
                    } else {
                        var4 += var8.a(var1, var2, var3);
                    }
                }
            }

            return var4;
        }
    }

    public strictfp int c(class_585 var1, boolean var2, boolean var3) {
        int var4 = 0;
        PlayerData[] var5 = playerArray;
        int var6 = c;

        for(int var7 = 0; var7 < var6; ++var7) {
            PlayerData var8 = var5[var7];
            if (var8 != null && this != var8 && this.d(var8)) {
                if (var1 == null) {
                    var4 += var8.a(var2, var3);
                } else {
                    var4 += var8.a(var1, var2, var3);
                }
            }
        }

        return var4;
    }

    public static strictfp void X() {
        GameEngine var0 = GameEngine.getGameEngine();
        i.T.a = var0.bB;
        h.T.a = var0.bB;

        for(int var1 = 0; var1 < c; ++var1) {
            PlayerData var2 = playerArray[var1];
            if (var2 != null) {
                var2.T.a = var0.bB;
            }
        }

    }

    public static strictfp void Y() {
        i.Z();
        h.Z();
    }

    public strictfp void Z() {
        this.m = false;
        this.n = false;
        this.credits = 4000.0;
        this.p = 0.0;
        this.q = 0;
        this.ai = -2;
        this.at = false;
        this.serverHostFlag = -9999;
        this.E = false;
        this.av = -9999;
        this.F = false;
        this.G = false;
        this.H = false;
        this.sharedControl_1 = false;
        this.sharedControl_2 = false;
        this.am.a();
        this.an = 0.0F;
        this.ad = 0;
        this.R = 0;
        this.S = true;
        this.T = new class_151();
        this.T.a = GameEngine.getGameEngine().bB;
        this.ak = class_585.d;
        this.al = new class_1069();
    }

    public strictfp double aa() {
        long var1 = System.currentTimeMillis();
        if (class_340.c((float)(this.aq - var1)) > 166.66666F) {
            this.aq = var1;
            this.ar = this.credits + this.p;
        }

        return this.ar;
    }

    public strictfp class_1069 ab() {
        return this.V();
    }

    // $FF: synthetic method
    public int compareTo(Object var1) {
        return this.a((PlayerData)var1);
    }

    static {
        f = c + d;
        g = new Player(-1, false, "<blank>");
        h = new class_139(-2);
        i = new class_139(-1);
        playerArray = new PlayerData[f];
        j = new class_141(-99);
        ag = new int[10];
        ah = new String[10];
        aj = -99;
        ao = 40.0F;
        ap = 10.0F;
    }
}
