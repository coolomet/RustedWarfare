package com.corrodinggames.librocket.scripts;

import com.corrodinggames.rts.gameFramework.GameEngine;

class Root$8 implements Runnable {
    // $FF: synthetic field
    final GameEngine val$game;
    // $FF: synthetic field
    final String val$saveName;
    // $FF: synthetic field
    final Root this$0;

    Root$8(Root var1, GameEngine var2, String var3) {
        this.this$0 = var1;
        this.val$game = var2;
        this.val$saveName = var3;
    }

    public void run() {
        this.val$game.ca.b(this.val$saveName);
        this.this$0.closePopup();
        this.this$0.showMaps();
    }
}
