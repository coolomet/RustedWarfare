package com.corrodinggames.librocket.scripts;

import com.corrodinggames.rts.a.a.class_650;
import com.corrodinggames.rts.debug.ScriptServerSocket;
import com.corrodinggames.rts.debug.test.TestNewSocket;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.maps.class_484;
import com.corrodinggames.rts.game.units.MovementType;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.Tree;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.a.class_1059;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.buildings.class_8;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.GameSaver;
import com.corrodinggames.rts.gameFramework.SyncPacket;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.GameObject;
import com.corrodinggames.rts.gameFramework.k.class_224;
import com.corrodinggames.rts.gameFramework.k.class_315;
import com.corrodinggames.rts.gameFramework.k.class_318;
import com.corrodinggames.rts.gameFramework.k.class_319;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameMapData;
import com.corrodinggames.rts.gameFramework.net.GameNetEngine;
import com.corrodinggames.rts.gameFramework.net.MapType;
import com.corrodinggames.rts.gameFramework.net.PlayerConnect;
import com.corrodinggames.rts.gameFramework.net.ServerAcceptRunnable;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;
import net.rudp.ReliableSocket;
//import sun.management.VMManagement;


public class Debug extends ScriptContext {
    Root root;
    boolean allFeatures;
    ConcurrentLinkedQueue backgroundClientConnections;
    Thread backgroundConnectionThread;
    Runnable backgroundConnectionRunnable = new Debug$1(this);
    boolean forceNonThreaded = true;

    Debug(Root var1) {
        this.root = var1;
    }

    /*public int currentPid() {
        try {
            RuntimeMXBean var1 = ManagementFactory.getRuntimeMXBean();
            Field var2 = var1.getClass().getDeclaredField("jvm");
            var2.setAccessible(true);
            VMManagement var3 = (VMManagement)var2.get(var1);
            Method var4 = var3.getClass().getDeclaredMethod("getProcessId");
            var4.setAccessible(true);
            int var5 = (Integer)var4.invoke(var3);
            return var5;
        } catch (Exception var6) {
            var6.printStackTrace();
            return -1;
        }
    }*/

    public void setLocalPlayerName(String var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        var2.netEngine.a(var1);
    }

    public void setDdosProtection(boolean var1) {
        ServerAcceptRunnable.b = var1;
    }

    public void lookAt(float var1, float var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        var3.b(var1, var2);
    }

    public void createManyUnits(String var1, float var2, float var3, int var4, boolean var5, int var6) {
        int var7 = 0;
        int var8 = 0;

        for(int var9 = 0; var9 < var6; ++var9) {
            var7 += 9;
            if (var7 > 400) {
                var7 = 0;
                var8 += 9;
            }

            this.createUnit(var1, var2 + (float)var7, var3 + (float)var8, var4, var9 == 0 ? var5 : false);
        }

    }

    public Long createUnit(String var1, float var2, float var3, int var4, boolean var5) {
        GameEngine var6 = GameEngine.getGameEngine();
        class_31 var7 = UnitType.a(var1);
        if (var7 == null) {
            this.root.logWarn("Could not find type:" + var1);
            return null;
        } else {
            Unit var8 = var7.a();
            var8.xCord = var2;
            var8.yCord = var3;

            try {
                var8.Q(var4);
            } catch (Exception var10) {
                throw new RuntimeException(var10);
            }

            PlayerData.c(var8);
            var8.cK = true;
            if (var5) {
                var6.b(var2, var3);
            }

            return var8.id;
        }
    }

    public int getMaxCustomUnitTypeId() {
        return class_591.d.size();
    }

    public Long createCustomUnitFromTypeId(int var1, float var2, float var3, int var4, boolean var5) {
        GameEngine var6 = GameEngine.getGameEngine();
        class_591 var7 = (class_591)class_591.d.get(var1);
        Unit var8 = var7.a();
        var8.xCord = var2;
        var8.yCord = var3;

        try {
            var8.Q(var4);
        } catch (Exception var10) {
            throw new RuntimeException(var10);
        }

        PlayerData.c(var8);
        var8.cK = true;
        if (var5) {
            var6.b(var2, var3);
        }

        return var8.id;
    }

    public void enableFeatures(String var1) {
        String var2 = class_340.e(var1);
        if (var2.startsWith("221FC410BD29D786")) {
            this.allFeatures = true;
            ScriptServerSocket.d = true;
        } else {
            throw new RuntimeException("unknown");
        }
    }

    public void selectNextUnit() {
        GameEngine var1 = GameEngine.getGameEngine();
        Unit var2 = null;
        boolean var3 = false;
        Iterator var4 = Unit.bF().iterator();

        while(var4.hasNext()) {
            Unit var5 = (Unit)var4.next();
            if (var5 instanceof Unit && !(var5 instanceof Tree) && !var5.t()) {
                if (var2 == null) {
                    var2 = var5;
                }

                if (var3) {
                    var2 = var5;
                    break;
                }

                var3 = var5.cG;
            }
        }

        var1.bS.y();
        if (var2 != null) {
            var1.bS.j(var2);
        }

    }

    public void removeAllUnits() {
        Iterator var1 = GameObject.dK().iterator();

        while(var1.hasNext()) {
            GameObject var2 = (GameObject)var1.next();
            var2.a();
        }

    }

    public void killAllUnits() {
        Iterator var1 = Unit.bF().iterator();

        while(var1.hasNext()) {
            Unit var2 = (Unit)var1.next();
            if (var2 instanceof Unit) {
                var2.health = -1.0F;
            }
        }

    }

    public boolean backgroundCurrentClientConnection() {
        if (!this.allFeatures) {
            return false;
        } else {
            GameEngine var1 = GameEngine.getGameEngine();
            if (!var1.netEngine.B) {
                GameEngine.log("Not networked");
                return false;
            } else if (var1.netEngine.isServer) {
                throw new RuntimeException("server=true");
            } else {
                if (this.backgroundConnectionThread == null) {
                    this.backgroundConnectionThread = new Thread(this.backgroundConnectionRunnable);
                    this.backgroundConnectionThread.start();
                }

                if (this.backgroundClientConnections == null) {
                    this.backgroundClientConnections = new ConcurrentLinkedQueue();
                }

                Iterator var2 = var1.netEngine.socketList.iterator();

                while(var2.hasNext()) {
                    PlayerConnect var3 = (PlayerConnect)var2.next();
                    var3.t = true;
                    this.backgroundClientConnections.add(var3);
                    var1.netEngine.socketList.remove(var3);
                }

                var1.netEngine.closeServer("backgrounded");
                var1.netEngine.B = true;
                return true;
            }
        }
    }

    public boolean isTeamWipedOut(int var1) {
        PlayerData var2 = PlayerData.getPlayerData(var1);
        if (var2 == null) {
            this.root.logWarn("Could not find team:" + var1);
            return true;
        } else {
            return var2.G;
        }
    }

    public boolean isTeamDefeated(int var1) {
        PlayerData var2 = PlayerData.getPlayerData(var1);
        if (var2 == null) {
            this.root.logWarn("Could not find team:" + var1);
            return true;
        } else {
            return var2.G;
        }
    }

    public boolean isTeamInVictory(int var1) {
        PlayerData var2 = PlayerData.getPlayerData(var1);
        if (var2 == null) {
            this.root.logWarn("Could not find team:" + var1);
            return false;
        } else {
            return var2.H;
        }
    }

    public String getPlayerName(int var1) {
        PlayerData var2 = PlayerData.getPlayerData(var1);
        if (var2 == null) {
            this.root.logWarn("Could not find team:" + var1);
            return null;
        } else {
            return var2.name;
        }
    }

    public String getQueryStringOfPlayer(int var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        PlayerData var3 = PlayerData.getPlayerData(var1);
        if (var3 == null) {
            this.root.logWarn("Could not find team:" + var1);
            return null;
        } else {
            PlayerConnect var4 = var2.netEngine.c(var3);
            if (var4 == null) {
                this.root.logWarn("Found team but could not find connection for team:" + var1);
                return null;
            } else {
                return var4.o;
            }
        }
    }

    public boolean setTeamCredits(int var1, int var2) {
        PlayerData var3 = PlayerData.getPlayerData(var1);
        if (var3 == null) {
            this.root.logWarn("Could not find team:" + var1);
            return false;
        } else {
            var3.credits = (double)var2;
            return true;
        }
    }

    public boolean setTeamAllyGroup(int var1, int var2) {
        PlayerData var3 = PlayerData.getPlayerData(var1);
        if (var3 == null) {
            this.root.logWarn("Could not find team:" + var1);
            return false;
        } else {
            var3.team = var2;
            return true;
        }
    }

    public void giveUpgradeToAllUnits() {
        Iterator var1 = Unit.bF().iterator();

        while(var1.hasNext()) {
            Unit var2 = (Unit)var1.next();
            if (var2 instanceof OrderableUnit) {
                OrderableUnit var3 = (OrderableUnit)var2;
                class_1059 var4 = var3.cm();
                class_226 var5 = var3.a((class_1059)var4);
                if (var5 != null) {
                    var3.a((class_226)var5, false);
                }
            }
        }

    }

    public void giveAllActionsToAllUnits() {
        Iterator var1 = Unit.bF().iterator();

        while(true) {
            Unit var2;
            do {
                if (!var1.hasNext()) {
                    return;
                }

                var2 = (Unit)var1.next();
            } while(!(var2 instanceof OrderableUnit));

            OrderableUnit var3 = (OrderableUnit)var2;
            Iterator var4 = var3.N().iterator();

            while(var4.hasNext()) {
                class_226 var5 = (class_226)var4.next();
                var3.a((class_226)var5, false);
            }
        }
    }

    public void completeAllUnitsQueues() {
        Iterator var1 = Unit.bF().iterator();

        while(var1.hasNext()) {
            Unit var2 = (Unit)var1.next();
            if (var2 instanceof class_8) {
                class_8 var3 = (class_8)var2;
                var3.dz();
            }
        }

    }

    public boolean moveAllUnitsOnTeam(int var1, float var2, float var3) {
        PlayerData var4 = PlayerData.getPlayerData(var1);
        if (var4 == null) {
            this.root.logWarn("Could not find team:" + var1);
            return false;
        } else {
            GameEngine var5 = GameEngine.getGameEngine();
            SyncPacket var6 = var5.cf.b(var4);
            Iterator var7 = Unit.bF().iterator();

            while(var7.hasNext()) {
                Unit var8 = (Unit)var7.next();
                if (var8 instanceof OrderableUnit) {
                    OrderableUnit var9 = (OrderableUnit)var8;
                    if (var9.bX == var4) {
                        var6.a(var9);
                    }
                }
            }

            var6.a(var2, var3);
            return true;
        }
    }

    public void showMessage(String var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        if (var1 != null && !var1.trim().equals("")) {
            var1 = var1.replace("\\n", "\n");
            var2.netEngine.m(var1);
        }
    }

    public String unicodeTest1() {
        return "start ¥123 \u061c end";
    }

    public void setZoom(float var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        var2.cV = var1;
    }

    public boolean isNetworkGameActive() {
        GameEngine var1 = GameEngine.getGameEngine();
        return var1.N();
    }

    public int getLocalPlayerId() {
        GameEngine var1 = GameEngine.getGameEngine();
        return var1.netEngine.z.site;
    }

    public int numberOfHumanPlayers() {
        GameEngine var1 = GameEngine.getGameEngine();
        return var1.netEngine.an();
    }

    public int numberOfPlayersPlusAI() {
        GameEngine var1 = GameEngine.getGameEngine();
        return var1.netEngine.ao();
    }

    public int numberOfPlayerConnections() {
        GameEngine var1 = GameEngine.getGameEngine();
        return var1.netEngine.B();
    }

    public boolean enableFastSync() {
        GameEngine var1 = GameEngine.getGameEngine();
        var1.netEngine.ai = 30;
        return true;
    }

    public boolean enableExtraNetworkDebug() {
        GameEngine var1 = GameEngine.getGameEngine();
        var1.netEngine.debug = true;
        return true;
    }

    public boolean throwIfAnyPlayerNotInSync() {
        GameEngine var1 = GameEngine.getGameEngine();
        var1.netEngine.x();
        return true;
    }

    public boolean enableFastResyncTimer() {
        GameNetEngine.c = true;
        return true;
    }

    public boolean enablePauseOnDesync() {
        GameEngine var1 = GameEngine.getGameEngine();
        var1.netEngine.aj = true;
        return true;
    }

    public boolean networkSetIncomeMultiplier(float var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        GameMapData var3 = var2.netEngine.e();
        var3.income = var1;
        var2.netEngine.a(var3);
        return true;
    }

    public boolean networkSetPortNumber(int var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        var2.settingsEngine.networkPort = var1;
        return true;
    }

    public boolean networkSetUdp(boolean var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        var2.settingsEngine.udpInMultiplayer = var1;
        return true;
    }

    public boolean networkDisconnect() {
        GameEngine var1 = GameEngine.getGameEngine();
        var1.netEngine.closeServer("debug");
        return true;
    }

    public boolean networkAbort() {
        GameEngine var1 = GameEngine.getGameEngine();
        Iterator var2 = var1.netEngine.socketList.iterator();

        while(var2.hasNext()) {
            PlayerConnect var3 = (PlayerConnect)var2.next();
            if (var3.socket instanceof ReliableSocket) {
                GameEngine.log("Closing: " + var3.g());
                ((ReliableSocket)var3.socket).d();
            }
        }

        var1.netEngine.closeServer("debug");
        return true;
    }

    public boolean disableNetworkOwnInfo() {
        GameNetEngine.r = false;
        return true;
    }

    public boolean networkPause() {
        GameEngine var1 = GameEngine.getGameEngine();
        var1.netEngine.aj = true;
        var1.netEngine.ak = true;
        return true;
    }

    public boolean plainTextDebugSave(boolean var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        GameSaver.a = var1;
        return true;
    }

    public boolean checkDesync(int var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        if (var2.netEngine.ap != 0) {
            throw new RuntimeException("numberOfDesyncErrors==" + var2.netEngine.ap);
        } else if (var2.netEngine.aq < var1) {
            throw new RuntimeException("game.network.numberOfDesyncPasses:" + var2.netEngine.aq + "<" + var1);
        } else {
            this.root.logDebug("numberOfDesyncPasses:" + var2.netEngine.aq);
            return true;
        }
    }

    public int getNumberOfDesyncErrors() {
        GameEngine var1 = GameEngine.getGameEngine();
        return var1.netEngine.ap;
    }

    public int getNumberOfDesyncPasses() {
        GameEngine var1 = GameEngine.getGameEngine();
        return var1.netEngine.aq;
    }

    public int getNumberOfResyncSendsOrRecv() {
        GameEngine var1 = GameEngine.getGameEngine();
        return var1.netEngine.ar;
    }

    public boolean setMultiplayerMap(int var1, String var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        GameMapData var4 = var3.netEngine.gameMapData;
        var4.mapType = MapType.values()[var1];
        var4.mapName = var2;
        return true;
    }

    public boolean setMultiplayerSave(String var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        GameMapData var3 = var2.netEngine.gameMapData;
        var3.mapType = MapType.savedGame;
        var3.mapName = var1;
        return true;
    }

    public void generateNewClientId() {
        GameEngine var1 = GameEngine.getGameEngine();
        var1.netEngine.Y();
    }

    public void disableFog() {
        GameEngine var1 = GameEngine.getGameEngine();
    }

    public void overrideDeltaSpeed(float var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        var2.bu = var1;
    }

    public void setGameSetting(String var1, String var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        var3.settingsEngine.setValueDynamic(var1, var2);
    }

    public void setNetworkaiDifficulty(int var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        GameMapData var3 = var2.netEngine.e();
        var3.aidiff = var1;
        var2.netEngine.a(var3);
    }

    public void setNetworkStartingUnits(int var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        GameMapData var3 = var2.netEngine.e();
        var3.initUnit = var1;
        var2.netEngine.a(var3);
    }

    public void startRandomUnitDesyncTest() {
        GameEngine var1 = GameEngine.getGameEngine();
        SyncPacket var2 = var1.cf.b();
        var2.i = PlayerData.i;
        var2.r = true;
        var2.u = 1;
        var1.netEngine.a(var2);
    }

    public void startRandomUnitStressTest() {
        GameEngine var1 = GameEngine.getGameEngine();
        SyncPacket var2 = var1.cf.b();
        var2.i = PlayerData.i;
        var2.r = true;
        var2.u = 2;
        var1.netEngine.a(var2);
    }

    public void runAllUnitTests() {
        this.root.logWarn("Running unit tests..");
        class_650 var1 = new class_650();
        var1.a();
    }

    public void runAllLeakTests() {
        this.root.logWarn("Running leak tests..");
        TestNewSocket var1 = new TestNewSocket();
        var1.start();
    }

    public boolean loadSaveFromSystemPath(String var1) {
        GameEngine var2 = GameEngine.getGameEngine();

        try {
            File var3 = new File(var1);
            FileInputStream var4 = new FileInputStream(var3);
            BufferedInputStream var5 = new BufferedInputStream(var4);
            DataInputStream var6 = new DataInputStream(var5);
            GameInputStream var7 = new GameInputStream(var6);

            boolean var8;
            try {
                var8 = var2.ca.a(var7, false, false, false);
            } finally {
                var6.close();
                var5.close();
                var4.close();
            }

            return var8;
        } catch (IOException var13) {
            throw new RuntimeException(var13);
        }
    }

    public void checkTeamCaches() {
        Iterator var1 = PlayerData.c().iterator();

        PlayerData var2;
        do {
            if (!var1.hasNext()) {
                return;
            }

            var2 = (PlayerData)var1.next();
        } while(!var2.t());

        throw new RuntimeException("Team cache difference on team:" + var2.site);
    }

    public void setPathSpeedConf(boolean var1) {
        this.forceNonThreaded = var1;
    }

    public float getPathSpeed(int var1, float var2, float var3, float var4, float var5) {
        GameEngine var6 = GameEngine.getGameEngine();
        class_484 var7 = var6.bL;
        ArrayList var8 = new ArrayList();
        var7.a(var4, var5);
        int var9 = var7.T;
        int var10 = var7.U;
        long var11 = com.corrodinggames.rts.gameFramework.Unit.loadAllUnitsTook();
        class_318.a = 0;
        class_318.b = 0;
        class_318.c = 0;
        class_318.d = 0;
        class_318.e = 0;
        class_318.f = 0;
        class_318.g = 0;
        class_318.h = 0.0;
        class_318.i = 0.0;
        class_315.c = 0;
        class_318.u = 0;

        for(int var13 = 0; var13 < var1; ++var13) {
            class_224 var14 = var6.bU.a(false);
            var7.a(var2, var3);
            var14.a(MovementType.LAND, (short)var7.T, (short)var7.U, (Float)null, false);
            var7.a(var4, var5);
            var14.a((short)var7.T, (short)var7.U, (short)0);
            var14.p = true;
            var14.q = 0;
            var14.r = false;
            var6.bU.a(var14, false, this.forceNonThreaded);
            var8.add(var14);
        }

        if (!this.forceNonThreaded) {
            return -1.0F;
        } else {
            float var21 = com.corrodinggames.rts.gameFramework.Unit.a(var11);
            int var22 = -1;

            int var18;
            for(Iterator var15 = var8.iterator(); var15.hasNext(); var22 = var18) {
                class_224 var16 = (class_224)var15.next();
                LinkedList var17 = var16.a();
                var18 = 0;

                for(Iterator var19 = var17.iterator(); var19.hasNext(); ++var18) {
                    class_319 var20 = (class_319)var19.next();
                }

                if (var22 != -1 && var22 != var18) {
                    String var23 = "pathDistance inconsistency detected:" + var22 + "!=" + var18;
                    GameEngine.print(var23);
                }

                class_319 var24 = (class_319)var17.getLast();
                if (var24.a != var9 || var24.b != var10) {
                    String var25 = "path did not react goal, got to:" + var24.a + "," + var24.b + " (vs " + var9 + ", " + var10 + ")";
                    GameEngine.print(var25);
                }
            }

            GameEngine.print("hotBufferWatermark:" + class_318.a + ", nodesAdded:" + class_318.d + ", mainQueueWatermark:" + class_318.b + ", backlogWatermark:" + class_318.c + ", scannedA:" + class_318.e + ", scannedB:" + class_318.f + ", scannedC:" + class_318.g + ", time:" + com.corrodinggames.rts.gameFramework.Unit.a(class_318.i) + "/" + com.corrodinggames.rts.gameFramework.Unit.a(class_318.h) + ", dirtyPeak:" + class_318.u + ", dis:" + var22);
            if (class_315.c != 0) {
                GameEngine.print("newNodesCreated:" + class_315.c);
            }

            return var21;
        }
    }

    public void muteSounds() {
        GameEngine var1 = GameEngine.getGameEngine();
        var1.bM.b = true;
        var1.bN.f();
    }

    public void pong() {
    }
}
