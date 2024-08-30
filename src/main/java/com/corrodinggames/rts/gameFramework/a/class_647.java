package com.corrodinggames.rts.gameFramework.a;

import com.corrodinggames.rts.gameFramework.GameEngine;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.a.d
public strictfp class class_647 extends Thread {
    // $FF: synthetic field
    final class_351 a;

    public class_647(class_351 var1) {
        this.a = var1;
    }

    public void run() {
        GameEngine.aq();

        try {
            while(true) {
                class_646 var1 = (class_646)this.a.a.take();
                var1.a();
                this.a.c.a(var1);
            }
        } catch (InterruptedException var2) {
        }
    }
}
