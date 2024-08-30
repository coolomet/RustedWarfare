package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.a.class_253;
import com.corrodinggames.rts.gameFramework.GameEngine;

// $FF: renamed from: com.corrodinggames.rts.game.units.h.8
final class class_279 extends class_253 {
    class_279(String var1) {
        super(var1);
    }

    public String type() {
        return "Fast Forward 1-5x";
    }

    public String b() {
        GameEngine var1 = GameEngine.getGameEngine();
        return "Fast Forward: " + var1.bt;
    }

    public boolean c(Unit var1, boolean var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        if (var3.replayEngine.j()) {
        }

        if (var3.bt == 1.0F) {
            var3.bt = 2.0F;
        } else if (var3.bt == 2.0F) {
            var3.bt = 3.0F;
        } else if (var3.bt == 3.0F) {
            var3.bt = 4.0F;
        } else if (var3.bt == 4.0F) {
            var3.bt = 5.0F;
        } else if (var3.bt == 5.0F) {
            var3.bt = 10.0F;
        } else {
            var3.bt = 1.0F;
        }

        return false;
    }
}
