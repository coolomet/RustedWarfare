package com.corrodinggames.rts.java;

import com.corrodinggames.rts.gameFramework.GameEngine;

// $FF: renamed from: com.corrodinggames.rts.java.i.1
class class_490 implements Runnable {
    // $FF: synthetic field
    final String a;
    // $FF: synthetic field
    final class_360 b;

    class_490(class_360 var1, String var2) {
        this.b = var1;
        this.a = var2;
    }

    public void run() {
        GameEngine.log("slick post-alert:" + this.a);
        this.b.a.p.b("", this.a);
    }
}
