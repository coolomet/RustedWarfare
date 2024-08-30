package com.corrodinggames.librocket.scripts;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.l.class_710;

class Root$11 extends class_710 {
    // $FF: synthetic field
    final Root this$0;

    Root$11(Root var1) {
        this.this$0 = var1;
    }

    public void onFileSelected() {
        GameEngine.log("importFilePopup: onFileSelected");
    }

    public void onCancelled() {
        GameEngine.log("importFilePopup: onCancelled");
    }
}
