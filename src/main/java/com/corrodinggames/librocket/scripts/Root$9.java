package com.corrodinggames.librocket.scripts;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.l.class_1039;
import java.io.File;

class Root$9 implements Runnable {
    // $FF: synthetic field
    final GameEngine val$game;
    // $FF: synthetic field
    final String val$replayName;
    // $FF: synthetic field
    final Root this$0;

    Root$9(Root var1, GameEngine var2, String var3) {
        this.this$0 = var1;
        this.val$game = var2;
        this.val$replayName = var3;
    }

    public void run() {
        this.this$0.closePopup();
        File var1 = this.val$game.replayEngine.a(this.val$replayName, false);
        class_1039.a(var1);
    }
}
