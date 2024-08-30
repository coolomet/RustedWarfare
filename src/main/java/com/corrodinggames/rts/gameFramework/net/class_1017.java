package com.corrodinggames.rts.gameFramework.net;

import com.corrodinggames.rts.game.EngineLoad;
import com.corrodinggames.rts.gameFramework.GameEngine;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.net.ar
public strictfp class class_1017 {
    public static int a(int var0) {
        return var0 + 5;
    }

    public static String a() {
        if (!GameEngine.at()) {
            return null;
        } else {
            EngineLoad var0 = (EngineLoad)GameEngine.getGameEngine();
            String var1 = var0.o();
            return var1;
        }
    }
}
