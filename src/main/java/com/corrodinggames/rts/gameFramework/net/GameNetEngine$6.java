package com.corrodinggames.rts.gameFramework.net;

import java.util.TimerTask;

class GameNetEngine$6 extends TimerTask {
    // $FF: synthetic field
    final GameNetEngine a;

    GameNetEngine$6(GameNetEngine var1) {
        this.a = var1;
    }

    public strictfp void run() {
        GameNetAPIOperate.c();
    }
}
