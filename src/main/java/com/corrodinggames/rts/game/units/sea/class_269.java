package com.corrodinggames.rts.game.units.sea;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.a.class_253;

// $FF: renamed from: com.corrodinggames.rts.game.units.h.e.2
final class class_269 extends class_253 {
    class_269(int var1) {
        super(var1);
    }

    public String type() {
        return "-Dive unit underwater. Evades most attacks";
    }

    public String b() {
        return "Dive";
    }

    public boolean a(Unit var1, boolean var2) {
        return ((AttackSubmarine)var1).a;
    }
}
