package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.a.class_253;
import com.corrodinggames.rts.gameFramework.GameEngine;

// $FF: renamed from: com.corrodinggames.rts.game.units.h.2
final class class_273 extends class_253 {
    class_273(String var1) {
        super(var1);
    }

    public String type() {
        return "Start recording a replay to file";
    }

    public String b() {
        return "Start Recording";
    }

    public String d() {
        String var1 = "Start Recording";
        GameEngine var2 = GameEngine.getGameEngine();
        boolean var3 = var2.replayEngine.k();
        if (!var3) {
            var1 = "Start Recording";
        } else {
            var1 = "Stop Recording";
        }

        return var1;
    }

    public boolean a(Unit var1, boolean var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        boolean var4 = var3.replayEngine.j();
        return !var4;
    }

    public boolean a(Unit var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        boolean var3 = var2.replayEngine.k();
        return var3;
    }

    public boolean c(Unit var1, boolean var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        GameEngine.log("Start recording clicked");
        if (var3.replayEngine.j()) {
            GameEngine.log("Already in a replay");
            return false;
        } else {
            var3.a((Runnable)(new class_643(this)));
            return false;
        }
    }
}
