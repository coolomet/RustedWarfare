package com.corrodinggames.rts.gameFramework;

class GameEngine$3 extends Thread {
    // $FF: synthetic field
    final GameEngine a;

    GameEngine$3(GameEngine var1) {
        this.a = var1;
    }

    public strictfp void run() {
        try {
            sleep(3000L);
        } catch (InterruptedException var2) {
        }

        this.a.ab();
    }
}
