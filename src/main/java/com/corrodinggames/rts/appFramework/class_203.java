package com.corrodinggames.rts.appFramework;

import com.corrodinggames.rts.gameFramework.GameEngine;

// $FF: renamed from: com.corrodinggames.rts.appFramework.h
class class_203 implements Runnable {
    public String a;
    // $FF: synthetic field
    final class_198 b;

    class_203(class_198 var1) {
        this.b = var1;
    }

    public void run() {
        GameEngine var1 = GameEngine.getGameEngine();
        var1.L();
        var1.ca.b(this.a, false);
        var1.J();
        if (this.b.e != null && this.b.e.isShowing()) {
            this.b.b(0);
        }

    }
}
