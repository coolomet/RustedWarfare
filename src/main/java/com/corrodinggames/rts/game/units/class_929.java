package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.f.InterfaceEngine;
import com.corrodinggames.rts.gameFramework.net.EnterPasswordCallback;

// $FF: renamed from: com.corrodinggames.rts.game.units.h.9.1
class class_929 extends EnterPasswordCallback {
    // $FF: synthetic field
    final class_280 a;

    class_929(class_280 var1) {
        this.a = var1;
    }

    public void a(String var1) {
        GameEngine.log("Searching for: " + var1);
        GameEngine var2 = GameEngine.getGameEngine();
        if (var2.replayEngine.i()) {
            var2.c("Reply active", "Changing search filter is currently not supported while recording a replay");
        } else {
            EditorOrBuilder var3 = EditorOrBuilder.L();
            if (var3 == null) {
                GameEngine.log("search: No editor");
            } else if (var1 != null && !var1.trim().equals("")) {
                var3.G = class_812.e;
                var3.H = var1;
                var3.I = true;
                InterfaceEngine.K();
            } else {
                GameEngine.log("search: No text entered");
                if (var3.G == class_812.e) {
                    var3.G = class_812.a;
                }

                var3.H = null;
                var3.I = true;
                InterfaceEngine.K();
            }
        }
    }

    public strictfp void a() {
    }
}
