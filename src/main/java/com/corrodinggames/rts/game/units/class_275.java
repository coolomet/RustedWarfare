package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.a.class_253;
import com.corrodinggames.rts.gameFramework.GameEngine;

// $FF: renamed from: com.corrodinggames.rts.game.units.h.4
final class class_275 extends class_253 {
    class_275(String var1) {
        super(var1);
    }

    public String type() {
        String var1 = "Hide interface till the screen is clicked/pressed";
        if (GameEngine.av()) {
            var1 = var1 + "\n-Enable mouse capture to also hide the mouse";
        }

        return var1;
    }

    public String b() {
        return "Hide interface";
    }

    public boolean c(Unit var1, boolean var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        var3.cU = true;
        return false;
    }
}
