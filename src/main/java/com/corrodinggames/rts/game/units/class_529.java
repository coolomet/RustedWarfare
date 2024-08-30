package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.gameFramework.GameEngine;

// $FF: renamed from: com.corrodinggames.rts.game.units.h.3.1
class class_529 implements Runnable {
    // $FF: synthetic field
    final String a;
    // $FF: synthetic field
    final class_274 b;

    class_529(class_274 var1, String var2) {
        this.b = var1;
        this.a = var2;
    }

    public void run() {
        GameEngine var1 = GameEngine.getGameEngine();
        boolean var2 = var1.replayEngine.j();
        if (!var2) {
            boolean var3 = var1.bL.E;
            EditorOrBuilder var4 = EditorOrBuilder.L();
            boolean var5 = var1.dq;
            boolean var6 = var1.dr;
            var1.replayEngine.h = true;
            var1.replayEngine.c(this.a);
            var1.replayEngine.h = false;
            var1.dq = var5;
            var1.dr = var6;
            EditorOrBuilder var7 = EditorOrBuilder.L();
            if (var7 != null && var4 != null) {
                var7.a(var4);
            } else {
                GameEngine.print("Failed copySettingsFromAnotherEditor");
            }

            var1.bv = true;
            if (var1.bL != null) {
                var1.bL.E = var3;
            }

            var1.cU = true;
            if (var7 != null) {
                var7.M();
            }
        } else {
            GameEngine.log("stopPlaybackRunnable: Already started");
        }

    }
}
