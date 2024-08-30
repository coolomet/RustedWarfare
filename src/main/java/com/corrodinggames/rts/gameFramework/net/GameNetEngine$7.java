package com.corrodinggames.rts.gameFramework.net;

import com.corrodinggames.rts.appFramework.class_195;

final class GameNetEngine$7 implements Runnable {
    // $FF: synthetic field
    final EnterPasswordCallback a;

    GameNetEngine$7(EnterPasswordCallback var1) {
        this.a = var1;
    }

    public strictfp void run() {
        class_195.a(this.a);
    }
}
