package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.a.class_253;

// $FF: renamed from: com.corrodinggames.rts.game.units.h.5
final class class_276 extends class_253 {
    class_276(String var1) {
        super(var1);
    }

    public String type() {
        return "Freeze full high level logic for all AI forever";
    }

    public String b() {
        return "Freeze AI";
    }

    public String d() {
        String var1 = "Freeze AI";
        EditorOrBuilder var2 = EditorOrBuilder.L();
        if (var2 != null) {
            boolean var3 = var2.c;
            if (var3) {
                var1 = "Unfreeze AIs";
            }
        }

        return var1;
    }

    public boolean a(Unit var1, boolean var2) {
        return true;
    }
}
