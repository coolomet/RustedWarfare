package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.a.class_253;
import com.corrodinggames.rts.gameFramework.GameEngine;

// $FF: renamed from: com.corrodinggames.rts.game.units.h.10
final class class_256 extends class_253 {
    class_256(String var1) {
        super(var1);
    }

    public String type() {
        return "Show hidden unit information in tooltips including flags, ammo, tags and resources";
    }

    public String b() {
        GameEngine var1 = GameEngine.getGameEngine();
        return !var1.bl ? "Debug: Off" : "Debug: On";
    }
}
