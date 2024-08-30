package com.corrodinggames.rts.gameFramework.net;

class GameNetEngine$5$1 implements Runnable {
    // $FF: synthetic field
    final GameNetEngine$5 a;

    GameNetEngine$5$1(GameNetEngine$5 var1) {
        this.a = var1;
    }

    public strictfp void run() {
        this.a.c.closeServer("already disconnected");
        this.a.b.bS.g.l();
    }
}
