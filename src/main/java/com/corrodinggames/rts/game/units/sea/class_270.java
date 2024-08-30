package com.corrodinggames.rts.game.units.sea;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.a.class_253;

// $FF: renamed from: com.corrodinggames.rts.game.units.h.e.1
final class class_270 extends class_253 {
    class_270(int var1) {
        super(var1);
    }

    public String type() {
        return "-Surface unit. Allows it to fire missiles";
    }

    public String b() {
        return "Surface";
    }

    public boolean a(Unit var1, boolean var2) {
        return !((AttackSubmarine)var1).a;
    }
}
