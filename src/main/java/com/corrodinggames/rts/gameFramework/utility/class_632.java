package com.corrodinggames.rts.gameFramework.utility;

import com.corrodinggames.rts.gameFramework.GameEngine;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.utility.ag.1
final class class_632 implements Runnable {
    // $FF: synthetic field
    final String a;
    // $FF: synthetic field
    final class_666 b;

    class_632(String var1, class_666 var2) {
        this.a = var1;
        this.b = var2;
    }

    public void run() {
        try {
            Thread.sleep(1500L);
        } catch (InterruptedException var2) {
            var2.printStackTrace();
        }

        GameEngine.log("Running delayed close of zip: " + this.a);
        this.b.a();
    }
}
