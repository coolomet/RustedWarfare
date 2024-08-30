package com.corrodinggames.librocket;

import com.corrodinggames.librocket.scripts.Root;
import com.corrodinggames.rts.gameFramework.GameEngine;

// $FF: renamed from: com.corrodinggames.librocket.a.2.1
class class_961 implements Runnable {
    // $FF: synthetic field
    final Root a;
    // $FF: synthetic field
    final class_641 b;

    class_961(class_641 var1, Root var2) {
        this.b = var1;
        this.a = var2;
    }

    public void run() {
        if (this.b.a.a) {
            GameEngine.print("AskPasswordCallBack already called");
        } else {
            this.b.a.a = true;
            String var1 = this.a.getPopupText();
            this.a.closeAlertOnly();
            this.b.c.a(var1);
        }
    }
}
