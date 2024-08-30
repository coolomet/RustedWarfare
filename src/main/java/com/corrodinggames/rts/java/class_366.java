package com.corrodinggames.rts.java;

import org.lwjgl.opengl.Display;

// $FF: renamed from: com.corrodinggames.rts.java.c
public strictfp class class_366 extends Thread {
    // $FF: synthetic field
    final RWAppGameContainer a;

    public class_366(RWAppGameContainer var1) {
        this.a = var1;
    }

    public void run() {
        while(true) {
            try {
                Thread.sleep(1L);
            } catch (InterruptedException var2) {
            }

            Display.processMessages();
        }
    }
}
