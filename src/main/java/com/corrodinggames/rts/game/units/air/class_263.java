package com.corrodinggames.rts.game.units.air;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.a.class_253;

// $FF: renamed from: com.corrodinggames.rts.game.units.b.c.1
final class class_263 extends class_253 {
    class_263(int var1) {
        super(var1);
    }

    public String type() {
        return "-Surface unit.";
    }

    public String b() {
        return "Fly";
    }

    public boolean a(Unit var1, boolean var2) {
        return !((AmphibiousJet)var1).r;
    }
}
