package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.a.class_138;
import com.corrodinggames.rts.game.units.a.class_253;
import com.corrodinggames.rts.gameFramework.GameEngine;

// $FF: renamed from: com.corrodinggames.rts.game.units.h.22
final class class_260 extends class_253 {
    class_260(String var1) {
        super(var1);
    }

    public String type() {
        return "Freeze high level AI logic (120secs)";
    }

    public String b() {
        return "Freeze AI";
    }

    public String d() {
        String var1 = "Freeze AI";
        GameEngine var2 = GameEngine.getGameEngine();
        EditorOrBuilder var3 = EditorOrBuilder.L();
        if (var3 != null) {
            int var4 = -1;
            if (var3.bX instanceof class_138) {
                class_138 var5 = (class_138)var3.bX;
                var4 = (int)var5.bG / 60;
            }

            if (var4 > 0) {
                var1 = var1 + "(" + var4 + ")";
            }
        }

        return var1;
    }

    public boolean a(Unit var1, boolean var2) {
        return var1.bX instanceof class_138;
    }
}
