package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.a.class_253;
import com.corrodinggames.rts.gameFramework.GameEngine;

// $FF: renamed from: com.corrodinggames.rts.game.units.h.14
final class class_259 extends class_253 {
    class_259(String var1) {
        super(var1);
    }

    public String type() {
        return "Clear save history";
    }

    public String b() {
        GameEngine var1 = GameEngine.getGameEngine();
        return "Clear history";
    }

    public boolean b(Unit var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        return var2.bl;
    }
}
