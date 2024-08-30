package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.a.class_253;

// $FF: renamed from: com.corrodinggames.rts.game.units.h.23
final class class_261 extends class_253 {
    class_261(String var1) {
        super(var1);
    }

    public String type() {
        return "Change selected player's alliance (players with the same letter are allied)";
    }

    public String b() {
        return "Ally:";
    }

    public String d() {
        String var1 = "Ally";
        EditorOrBuilder var2 = EditorOrBuilder.L();
        if (var2 != null) {
            var1 = "Ally: " + var2.bX.getPlayerTeamName();
        }

        return var1;
    }

    public boolean a(Unit var1, boolean var2) {
        return true;
    }
}
