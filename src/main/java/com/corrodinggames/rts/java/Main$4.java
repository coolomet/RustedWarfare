package com.corrodinggames.rts.java;

import com.corrodinggames.rts.gameFramework.net.PlayerConnect;

class Main$4 implements Runnable {
    // $FF: synthetic field
    final int a;
    // $FF: synthetic field
    final String b;
    // $FF: synthetic field
    final String c;
    // $FF: synthetic field
    final PlayerConnect d;
    // $FF: synthetic field
    final Main e;

    Main$4(Main var1, int var2, String var3, String var4, PlayerConnect var5) {
        this.e = var1;
        this.a = var2;
        this.b = var3;
        this.c = var4;
        this.d = var5;
    }

    public void run() {
        this.e.p.c.getRoot().receiveChatMessage(this.a, this.b, this.c, this.d);
    }
}
