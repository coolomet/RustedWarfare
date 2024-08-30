package com.corrodinggames.rts.gameFramework.net;

import java.util.TimerTask;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.net.o
class class_217 extends TimerTask {
    int a;

    class_217(int var1) {
        this.a = var1;
    }

    public void run() {
        GameNetAPIOperate.a(this.a, -1);
    }
}
