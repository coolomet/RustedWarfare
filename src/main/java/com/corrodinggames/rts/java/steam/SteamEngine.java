package com.corrodinggames.rts.java.steam;

import com.codedisaster.steamworks.SteamAPI;
import com.codedisaster.steamworks.SteamException;
import com.codedisaster.steamworks.SteamFriends;
import com.codedisaster.steamworks.SteamID;
import com.codedisaster.steamworks.SteamMatchmaking;
import com.codedisaster.steamworks.SteamMatchmaking$LobbyType;
import com.codedisaster.steamworks.SteamNetworking;
import com.codedisaster.steamworks.SteamNetworking$API;
import com.codedisaster.steamworks.SteamUGC;
import com.codedisaster.steamworks.SteamUtils;
import com.corrodinggames.librocket.scripts.ScriptEngine;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.i.class_800;
import com.corrodinggames.rts.gameFramework.net.PlayerConnect;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;

public strictfp class SteamEngine extends com.corrodinggames.rts.gameFramework.steam.SteamEngine {
    SteamFriendsCallback b;
    SteamFriends c;
    SteamMatchmaking d;
    SteamMatchmakingCallback e;
    SteamNetworkingCallback f;
    class_156 g;
    SteamNetworking h;
    SteamUtilsCallback i;
    SteamUtils j;
    boolean k = false;
    HashMap l = new HashMap();
    ByteBuffer m;
    SteamID n;
    boolean o;
    SteamID p;

    public class_156 n() {
        return this.g;
    }

    public void b() {
        if (this.k) {
            GameEngine.log("SteamEngine - init already called");
        } else {
            this.k = true;
            GameEngine.log("SteamEngine - java steamEngine init()");

            try {
                if (!SteamAPI.init()) {
                    GameEngine.print("steamAPI init failed");
                    this.d();
                    return;
                }

                this.m = ByteBuffer.allocateDirect(100000);
                this.b = new SteamFriendsCallback(this);
                this.c = new SteamFriends(this.b);
                this.e = new SteamMatchmakingCallback(this);
                this.d = new SteamMatchmaking(this.e);
                this.f = new SteamNetworkingCallback(this);
                this.h = new SteamNetworking(this.f, SteamNetworking$API.Client);
                this.g = new class_156(this);

                SteamUGC var1;
                try {
                    var1 = new SteamUGC(this.g.a());
                } catch (RuntimeException var3) {
                    var3.printStackTrace();
                    throw new SteamException("Failed to create workshop");
                }

                this.g.a(var1);
                this.i = new SteamUtilsCallback(this);
                this.j = new SteamUtils(this.i);
            } catch (SteamException var4) {
                var4.printStackTrace();
                this.d();
            }

        }
    }

    public void a(float var1) {
        SteamAPI.runCallbacks();
        if (this.h != null) {
            if (GameEngine.aK != null) {
                GameEngine.log("Joining game from commandline invite:" + GameEngine.aK);
                long var2 = Long.parseLong(GameEngine.aK);
                GameEngine.aK = null;
                SteamID var4 = SteamID.createFromNativeHandle(var2);
                this.d.joinLobby(var4);
            }

            while(true) {
                int var9 = this.h.isP2PPacketAvailable(0);
                if (var9 == 0) {
                    break;
                }

                if (var9 > this.m.capacity()) {
                    GameEngine.print("nextPacketSize:" + var9 + " larger then byteBuffer:" + this.m.capacity() + " resizing");
                    this.m = ByteBuffer.allocateDirect(var9);
                }

                SteamID var3 = new SteamID();

                try {
                    this.m.clear();
                    int var10 = this.h.readP2PPacket(var3, this.m, 0);
                    if (var10 == 0) {
                        GameEngine.print("readP2PPacket with rtn==" + var10);
                    }

                    SteamSocket var5 = (SteamSocket)this.l.get(var3);
                    if (var5 != null && var5.isClosed()) {
                        GameEngine.print("Removing stale steam socket");
                        this.l.remove(var3);
                        var5 = null;
                    }

                    if (var5 == null) {
                        this.b(var3);
                        var5 = (SteamSocket)this.l.get(var3);
                    }

                    if (var5 == null) {
                        GameEngine.log("Could not find remote ID steamSocket: " + var3);
                    } else {
                        int var6 = this.m.limit();
                        byte[] var7 = new byte[var6];
                        this.m.get(var7);
                        var5.c.a(var7);
                    }
                } catch (Exception var8) {
                    var8.printStackTrace();
                }
            }
        }

    }

    public void d() {
        GameEngine.print("JavaSteamEngine: disableSteam");
        GameEngine var1 = GameEngine.getGameEngine();
        if (var1 != null) {
            var1.i("Steam connection failed.");
        } else {
            GameEngine.log("cannot show alert game has not been created");
        }

        com.corrodinggames.rts.gameFramework.steam.SteamEngine.steamEngine = new com.corrodinggames.rts.gameFramework.steam.SteamEngine();
    }

    public String c() {
        return this.c.getPersonaName();
    }

    public boolean f() {
        return false;
    }

    public void a(String var1) {
        GameEngine.log("Steam: " + var1);
    }

    public void b(String var1) {
        GameEngine.print("Steam: " + var1);
    }

    public void i() {
        this.a("createLobby");
        if (this.n != null) {
            this.b("createLobby: activeLobby!=null");
        }

        this.d.createLobby(SteamMatchmaking$LobbyType.FriendsOnly, 10);
    }

    public synchronized void a(SteamID var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        this.n = var1;
    }

    public PlayerConnect b(SteamID var1) {
        GameEngine.log("addPeer: " + var1);
        GameEngine var2 = GameEngine.getGameEngine();
        SteamSocket var3 = (SteamSocket)this.l.get(var1);
        if (var3 != null) {
            if (var3.isClosed()) {
                this.l.remove(var1);
            } else {
                this.b("addPeer, user already exists");

                try {
                    var3.close();
                } catch (Exception var8) {
                    var8.printStackTrace();
                }
            }
        }

        SteamSocket var4 = new SteamSocket(this, var1);
        PlayerConnect var5 = new PlayerConnect(var2.netEngine, var4);

        try {
            var5.i = true;
            var5.d();
            var2.netEngine.socketList.add(var5);
            this.l.put(var1, var4);
            var2.netEngine.Q();
            return var5;
        } catch (Exception var7) {
            var7.printStackTrace();
            var5.a("crash");
            return null;
        }
    }

    public void c(SteamID var1) {
        GameEngine.log("connectTo: " + var1);
        SteamSocket var2 = (SteamSocket)this.l.get(var1);
        if (var2 != null) {
            if (var2.isClosed()) {
                this.l.remove(var1);
            } else {
                this.b("connectTo, user already exists");

                try {
                    var2.close();
                } catch (Exception var6) {
                    var6.printStackTrace();
                }
            }
        }

        GameEngine var3 = GameEngine.getGameEngine();
        if (!this.o) {
            SteamEngine$1 var5 = new SteamEngine$1(this, var1);
            ScriptEngine.getInstance().addRunnableToQueue(var5);
        } else {
            this.a("connectTo as server?");
            this.b(var1);
        }

    }

    public void j() {
        this.a("stopLobby");
        if (this.n == null) {
            this.b("stopLobby: activeLobby==null");
        } else {
            this.d.leaveLobby(this.n);
        }

        this.a("stopLobby: activeSteamSockets:" + this.l.size());
        Iterator var1 = this.l.values().iterator();

        while(var1.hasNext()) {
            SteamSocket var2 = (SteamSocket)var1.next();

            try {
                var2.close();
            } catch (Exception var4) {
                var4.printStackTrace();
            }
        }

        this.l.clear();
        this.n = null;
        this.p = null;
    }

    public void g() {
        if (this.n == null) {
        }

        if (this.n == null) {
            GameEngine.getGameEngine().i("Error: No steam lobby has been started");
        } else {
            this.c.activateGameOverlayInviteDialog(this.n);
        }
    }

    public void k() {
        this.g.c();
    }

    public void l() {
        this.g.d();
    }

    public void m() {
        this.n().b();
    }

    public void a(class_800 var1) {
        this.n().c(var1);
    }

    public void b(class_800 var1) {
        this.n().b(var1);
    }

    public void a(class_800 var1, boolean var2, String var3) {
        this.n().a(var1, var2, var3);
    }
}
