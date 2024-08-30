package com.corrodinggames.rts.gameFramework.net;

import com.corrodinggames.rts.gameFramework.GameEngine;

final class GameNetEngine$1 extends EnterPasswordCallback {
    // $FF: synthetic field
    final Object a;

    GameNetEngine$1(Object var1) {
        this.a = var1;
    }

    public strictfp void a(String var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        GameEngine.log("Entered password");
        if (var2.netEngine.isServer) {
            GameEngine.a("Cannot enter a password when we are a server");
        } else {
            var2.netEngine.passwd = var1;
        }

        synchronized(this.a) {
            this.a.notify();
        }
    }

    public strictfp void a() {
        synchronized(this.a) {
            this.a.notify();
        }
    }
}
