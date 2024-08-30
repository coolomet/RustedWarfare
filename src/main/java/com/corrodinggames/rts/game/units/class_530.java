package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.gameFramework.GameEngine;

// $FF: renamed from: com.corrodinggames.rts.game.units.h.3.3
class class_530 implements Runnable {
    // $FF: synthetic field
    final class_274 a;

    class_530(class_274 var1) {
        this.a = var1;
    }

    public void run() {
        GameEngine var1 = GameEngine.getGameEngine();
        boolean var2 = var1.replayEngine.j();
        if (!var2) {
            GameEngine.log("stopPlaybackRunnable: Already stopped");
        } else {
            var1.replayEngine.close();
            var1.bt = 1.0F;
            var1.bv = true;
            EditorOrBuilder var3 = EditorOrBuilder.L();
            if (var3 != null) {
                var1.playerTeam = var3.bX;
            }
        }

    }
}
