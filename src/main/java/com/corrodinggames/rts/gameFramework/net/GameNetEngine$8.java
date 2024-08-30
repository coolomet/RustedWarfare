package com.corrodinggames.rts.gameFramework.net;

import com.corrodinggames.rts.gameFramework.GameEngine;
import java.io.IOException;

class GameNetEngine$8 implements Runnable {
    // $FF: synthetic field
    final boolean a;
    // $FF: synthetic field
    final GameNetEngine b;

    GameNetEngine$8(GameNetEngine var1, boolean var2) {
        this.b = var1;
        this.a = var2;
    }

    public strictfp void run() {
        GameEngine var1 = GameEngine.getGameEngine();
        GameEngine.log("startJoinServerInternalThread callback");
        class_1016 var2 = this.b.bF;
        this.b.bF = null;
        if (var2 == null) {
            GameEngine.log("startJoinServerInternalThread callback gameConnector==null");
        } else if (var2.e != null) {
            GameEngine.log("startJoinServerInternalThread failed to connect: " + var2.e);
            if (this.a) {
                var1.netEngine.closeServer("Reconnect failed: " + var2.e);
                this.b.b("Reconnect failed", "reconnect failed");
                var1.d("Reconnect failed", "Reconnect failed: " + var2.e);
                var1.i("Reconnect failed: " + var2.e);
            }

        } else {
            try {
                var1.netEngine.closeServer("starting new");
                var1.netEngine.bindSocket(var2.g);
            } catch (Exception var5) {
                String var4 = var5.getMessage();
                var1.c(var4, "Connection failed");
                var5.printStackTrace();
            }

        }
    }
}
