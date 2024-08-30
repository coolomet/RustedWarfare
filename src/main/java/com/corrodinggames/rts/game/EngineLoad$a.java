package com.corrodinggames.rts.game;

class EngineLoad$a extends Thread {
    // $FF: synthetic field
    final EngineLoad a;

    EngineLoad$a(EngineLoad var1) {
        this.a = var1;
    }

    public strictfp void run() {
        this.a.netEngine.closeServer("gotoNextLevel");
    }
}
