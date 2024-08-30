package com.corrodinggames.rts.appFramework;

import com.corrodinggames.rts.gameFramework.GameEngine;

// $FF: renamed from: com.corrodinggames.rts.appFramework.g.1
class class_1029 implements Runnable {
    // $FF: synthetic field
    final int a;
    // $FF: synthetic field
    final class_198 b;

    class_1029(class_198 var1, int var2) {
        this.b = var1;
        this.a = var2;
    }

    public void run() {
        GameEngine.log("inner selectMenuOption: " + this.a);
        this.b.d(this.a);
    }
}
