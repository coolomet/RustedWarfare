package com.corrodinggames.rts.java.steam;

import com.codedisaster.steamworks.SteamID;
import com.corrodinggames.librocket.scripts.Root;
import com.corrodinggames.librocket.scripts.ScriptEngine;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.net.PlayerConnect;
import java.io.IOException;
import java.util.Iterator;

class SteamEngine$1 implements Runnable {
    // $FF: synthetic field
    final SteamID a;
    // $FF: synthetic field
    final SteamEngine b;

    SteamEngine$1(SteamEngine var1, SteamID var2) {
        this.b = var1;
        this.a = var2;
    }

    public void run() {
        GameEngine var1 = GameEngine.getGameEngine();

        String var3;
        try {
            this.b.a("connectTo runnable start");
            Root var2 = ScriptEngine.getInstance().getRoot();
            var1.netEngine.closeServer("starting new");
            this.b.n = this.a;
            this.b.p = this.b.d.getLobbyOwner(this.b.n);
            var3 = var1.settingsEngine.lastNetworkPlayerName;
            String var4 = com.corrodinggames.rts.gameFramework.steam.SteamEngine.getSteamEngine().c();
            if (var4 != null && var3 == null) {
                var3 = var4.replace(" ", "_");
                var3 = class_340.a((String)var3, (int)20);
            }

            var1.netEngine.y = var3;
            SteamSocket var5 = new SteamSocket(this.b, this.b.p);
            this.b.l.put(this.b.p, var5);
            var1.netEngine.bindSocket(var5);

            PlayerConnect var7;
            for(Iterator var6 = var1.netEngine.socketList.iterator(); var6.hasNext(); var7.i = true) {
                var7 = (PlayerConnect)var6.next();
            }

            this.b.a("connected");
            var2.showBattleroom();
            this.b.a("connectTo runnable end");
        } catch (Exception var8) {
            var3 = var8.getMessage();
            var1.c(var3, "Connection failed");
            var8.printStackTrace();
        }

    }
}
