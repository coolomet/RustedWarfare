package com.corrodinggames.rts.game.units.a;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_987;

// $FF: renamed from: com.corrodinggames.rts.game.units.a.q
public strictfp class class_239 extends class_238 {
    public class_239() {
        super("c__cut_chat");
    }

    public String b() {
        return "Team Chat";
    }

    public String type() {
        return "Send a team chat message to your allies";
    }

    public boolean c(Unit var1, boolean var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        var3.bS.g.n();
        return true;
    }

    public class_987 M() {
        GameEngine var1 = GameEngine.getGameEngine();
        return var1.bT.u;
    }
}
