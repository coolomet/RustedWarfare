package com.corrodinggames.rts.java;

import com.corrodinggames.rts.gameFramework.GameEngine;

// $FF: renamed from: com.corrodinggames.rts.java.i.2
class class_491 implements Runnable {
    // $FF: synthetic field
    final String a;
    // $FF: synthetic field
    final String b;
    // $FF: synthetic field
    final class_360 c;

    class_491(class_360 var1, String var2, String var3) {
        this.c = var1;
        this.a = var2;
        this.b = var3;
    }

    public void run() {
        GameEngine.log("slick messageBox:" + this.a);
        this.c.a.p.b(this.b, this.a);
    }
}
