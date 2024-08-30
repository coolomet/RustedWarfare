package com.corrodinggames.rts.java;

import com.corrodinggames.librocket.class_790;
import com.corrodinggames.rts.appFramework.class_195;
import com.corrodinggames.rts.gameFramework.GameEngine;

class Main$3 implements Runnable {
    // $FF: synthetic field
    final Main a;

    Main$3(Main var1) {
        this.a = var1;
    }

    public void run() {
        GameEngine var1 = GameEngine.getGameEngine();
        GameEngine.log("got startGameEvent..");
        class_195.r();
        if (var1.bL != null && var1.bL.W) {
            var1.netEngine.bd = true;
            var1.bH = false;
            var1.aq = false;
            this.a.i.c(false);
            class_790.a().f();
            this.a.p.getActiveDocument();
            if (this.a.p.c != null) {
                this.a.p.c.getRoot().resumeNonMenu();
            } else {
                GameEngine.log("startGameEvent: scriptEngine==null");
                GameEngine.T();
            }

        } else {
            GameEngine.log("Not starting multiplayer game because map failed to load");
            var1.netEngine.af();
        }
    }
}
