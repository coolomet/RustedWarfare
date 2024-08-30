package com.corrodinggames.rts.game.units.a;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_987;

// $FF: renamed from: com.corrodinggames.rts.game.units.a.r
public strictfp class class_240 extends class_238 {
    public class_240() {
        super("c__cut_ping");
    }

    public String b() {
        return "Map Ping";
    }

    public String type() {
        return "Send a map ping to your allies";
    }

    public boolean c(Unit var1, boolean var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        var3.bS.I();
        return true;
    }

    public class_987 M() {
        GameEngine var1 = GameEngine.getGameEngine();
        return var1.bT.v;
    }
}
