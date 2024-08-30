package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.a.class_253;
import com.corrodinggames.rts.gameFramework.GameEngine;

// $FF: renamed from: com.corrodinggames.rts.game.units.h.13
final class class_258 extends class_253 {
    class_258(String var1) {
        super(var1);
    }

    public String type() {
        return "For debugging autoTriggers. When enabled will log a message when any auto triggers fire on any selected units";
    }

    public String b() {
        GameEngine var1 = GameEngine.getGameEngine();
        return !var1.bn ? "Trigger Debug: Off" : "Trigger Debug: On";
    }

    public boolean b(Unit var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        return var2.bl;
    }
}
