package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.a.class_138;
import com.corrodinggames.rts.game.units.a.class_253;
import com.corrodinggames.rts.gameFramework.GameEngine;

// $FF: renamed from: com.corrodinggames.rts.game.units.h.11
final class class_257 extends class_253 {
    class_257(String var1) {
        super(var1);
    }

    public String type() {
        return "AI debug view";
    }

    public String b() {
        GameEngine var1 = GameEngine.getGameEngine();
        return !class_138.as ? "AI Debug: Off" : "AI Debug: On";
    }
}
