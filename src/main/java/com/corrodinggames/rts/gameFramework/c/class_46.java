package com.corrodinggames.rts.gameFramework.c;

import com.corrodinggames.rts.gameFramework.GameEngine;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.c.c
class class_46 implements Runnable {
    // $FF: synthetic field
    final class_39 a;

    class_46(class_39 var1) {
        this.a = var1;
    }

    public void run() {
        GameEngine var1 = GameEngine.getGameEngine();
        if (this.a.f) {
            this.a.f = false;
        } else {
            if (class_39.c) {
                if (var1.bL == null) {
                    return;
                }

                var1.bN.F = true;
                if (!var1.bN.j()) {
                    ++class_39.e;
                }

                if (class_39.e > 5.0F) {
                    class_39.e = 0.0F;
                    System.gc();
                    System.gc();
                    var1.bN.e();
                }
            }

            if (class_39.d && var1.bL != null) {
                var1.bL.g();
            }

        }
    }
}
