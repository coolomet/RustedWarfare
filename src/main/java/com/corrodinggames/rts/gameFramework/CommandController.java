package com.corrodinggames.rts.gameFramework;

import com.corrodinggames.rts.game.PlayerData;
import java.util.ArrayList;
import java.util.Iterator;

public strictfp class CommandController {
    static final boolean a = false;
    public ArrayList commandList = new ArrayList();
    public ArrayList c = new ArrayList();
    public ArrayList d = new ArrayList();
    static int e;

    public static strictfp void a(String var0) {
        ++e;
        if (e == 5) {
            GameEngine.log("(Rate Limiting...)");
        }

        if (e < 5) {
            GameEngine.log(var0);
        }
    }

    public strictfp void a() {
        this.commandList.clear();
        this.c.clear();
        this.d.clear();
    }

    public strictfp SyncPacket b() {
        SyncPacket var1 = new SyncPacket(this);
        if (a) {
            GameEngine.log("Tracing source");
            var1.b = GameEngine.a((Throwable)(new Exception("Test")));
        }

        return var1;
    }

    public strictfp SyncPacket a(PlayerData var1) {
        return this.b(var1);
    }

    public strictfp SyncPacket b(PlayerData var1) {
        if (var1 == null) {
            throw new RuntimeException("team==null");
        } else {
            GameEngine var2 = GameEngine.getGameEngine();
            SyncPacket var3 = new SyncPacket(this);
            var3.i = var1;
            var3.d = var2.by;
            if (a) {
                GameEngine.log("Tracing source");
                var3.b = GameEngine.a((Throwable)(new Exception("Test")));
            }

            if (!var2.netEngine.B) {
                if (!var3.l()) {
                    GameEngine.print("Command failed prepareAndCheckOnServer()");
                }

                this.commandList.add(var3);
            } else {
                this.d.add(var3);
            }

            return var3;
        }
    }

    public strictfp void c() {
        GameEngine var1 = GameEngine.getGameEngine();
        e = 0;
        if (!var1.netEngine.B) {
            this.d();
        } else {
            this.e();
        }

    }

    public strictfp void d() {
        GameEngine var1 = GameEngine.getGameEngine();
        int var2 = var1.tick;
        int var3 = 0;

        for(Iterator var4 = this.commandList.iterator(); var4.hasNext(); ++var3) {
            SyncPacket var5 = (SyncPacket)var4.next();
            var1.replayEngine.a(var5, var2);
            var5.k();
        }

        this.commandList.clear();
        if (var3 > 0) {
            var1.replayEngine.c();
        }

    }

    public strictfp void e() {
        GameEngine var1 = GameEngine.getGameEngine();
        int var2 = var1.tick;
        int var3 = 0;
        Iterator var4 = this.commandList.iterator();

        while(var4.hasNext()) {
            SyncPacket var5 = (SyncPacket)var4.next();
            if (var5.localTick == var2) {
                var1.replayEngine.a(var5, var2);
                var5.k();
                var4.remove();
                ++var3;
            }
        }

        if (var3 > 0) {
            var1.replayEngine.c();
        }

    }
}
