package com.corrodinggames.rts.game.units.air;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.a.class_253;

// $FF: renamed from: com.corrodinggames.rts.game.units.b.c.2
final class class_262 extends class_253 {
    class_262(int var1) {
        super(var1);
    }

    public String type() {
        return "-Dive unit underwater.";
    }

    public String b() {
        return "Dive";
    }

    public boolean a(Unit var1, boolean var2) {
        return ((AmphibiousJet)var1).r && ((OrderableUnit)var1).cJ();
    }
}
