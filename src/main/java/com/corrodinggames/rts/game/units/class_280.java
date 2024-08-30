package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.a.class_253;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.net.EnterPasswordCallback;
import com.corrodinggames.rts.gameFramework.net.GameNetEngine;

// $FF: renamed from: com.corrodinggames.rts.game.units.h.9
final class class_280 extends class_253 {
    class_280(String var1) {
        super(var1);
    }

    public TeamImageCache j() {
        return EditorOrBuilder.g;
    }

    public String type() {
        return "Search for units";
    }

    public String b() {
        GameEngine var1 = GameEngine.getGameEngine();
        EditorOrBuilder var2 = EditorOrBuilder.L();
        return var2 != null && var2.G == class_812.e ? "Search: " + class_340.b(var2.H, (int)8) : "Search units";
    }

    public boolean c(Unit var1, boolean var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        if (var3.replayEngine.i()) {
            var3.c("Reply active", "Changing search filter is currently not supported while recording a replay");
            return false;
        } else {
            class_929 var4 = new class_929(this);
            var4.b = "Search units by internal name or text title.";
            var4.e = "Search units";
            var4.f = "Search";
            var4.g = "Cancel";
            GameNetEngine.a((EnterPasswordCallback)var4);
            return false;
        }
    }
}
