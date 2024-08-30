package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.a.class_253;
import com.corrodinggames.rts.gameFramework.GameEngine;

// $FF: renamed from: com.corrodinggames.rts.game.units.h.6
final class class_277 extends class_253 {
    class_277(String var1) {
        super(var1);
    }

    public String type() {
        return "Pause Game";
    }

    public String b() {
        GameEngine var1 = GameEngine.getGameEngine();
        return var1.bt != 0.0F ? "Pause: Off" : "Pause: On";
    }

    public boolean c(Unit var1, boolean var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        if (var3.replayEngine.j()) {
        }

        if (var3.bt != 0.0F) {
            var3.bt = 0.0F;
        } else {
            var3.bt = 1.0F;
        }

        return false;
    }
}
