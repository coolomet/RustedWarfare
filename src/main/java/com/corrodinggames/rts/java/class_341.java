package com.corrodinggames.rts.java;

import com.corrodinggames.rts.gameFramework.GameEngine;

// $FF: renamed from: com.corrodinggames.rts.java.r
public strictfp class class_341 extends Thread {
    // $FF: synthetic field
    final class_352 a;

    public class_341(class_352 var1) {
        this.a = var1;
    }

    public void run() {
        GameEngine.aq();

        try {
            while(true) {
                class_354 var1 = (class_354)this.a.b.take();
                var1.a();
                this.a.c.a(var1);
            }
        } catch (InterruptedException var2) {
        }
    }
}
