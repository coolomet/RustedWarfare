package com.corrodinggames.rts.java.steam;

import com.codedisaster.steamworks.SteamID;
import com.corrodinggames.librocket.scripts.Root;
import com.corrodinggames.librocket.scripts.ScriptEngine;
import com.corrodinggames.rts.gameFramework.GameEngine;

public strictfp class SteamData implements Runnable {
    SteamEngine a;
    String b;
    SteamID c;
    SteamID d;
    long e;
    Thread f;

    public SteamData(SteamEngine var1, SteamID var2, SteamID var3, long var4) {
        this.a = var1;
        this.c = var2;
        this.d = var3;
        this.e = var4;
        this.b = var1.c.getFriendPersonaName(var2);
    }

    public void a() {
        if (this.f != null) {
            throw new RuntimeException("already started");
        } else {
            SteamData$1 var1 = new SteamData$1(this);
            ScriptEngine.getInstance().addRunnableToQueue(var1);
        }
    }

    public void run() {
        GameEngine.log("Join clicked");
        Root var1 = ScriptEngine.getInstance().getRoot();
        var1.closePopup();
        GameEngine var2 = GameEngine.getGameEngine();
        this.a.d.joinLobby(this.d);
    }
}
