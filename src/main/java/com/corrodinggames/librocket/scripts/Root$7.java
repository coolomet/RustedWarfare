package com.corrodinggames.librocket.scripts;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.l.class_1039;
import java.io.File;

class Root$7 implements Runnable {
    // $FF: synthetic field
    final GameEngine val$game;
    // $FF: synthetic field
    final String val$saveName;
    // $FF: synthetic field
    final Root this$0;

    Root$7(Root var1, GameEngine var2, String var3) {
        this.this$0 = var1;
        this.val$game = var2;
        this.val$saveName = var3;
    }

    public void run() {
        this.this$0.closePopup();
        File var1 = this.val$game.ca.a(this.val$saveName, false);
        class_1039.a(var1);
    }
}
