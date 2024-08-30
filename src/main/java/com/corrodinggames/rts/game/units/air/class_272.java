package com.corrodinggames.rts.game.units.air;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.a.class_253;
import com.corrodinggames.rts.gameFramework.h.class_1009;

// $FF: renamed from: com.corrodinggames.rts.game.units.b.d.1
final class class_272 extends class_253 {
    class_272(int var1) {
        super(var1);
    }

    public String type() {
        return "-Will unload all units when stopped";
    }

    public String b() {
        return class_1009.a("gui.actions.unload");
    }

    public int b(Unit var1, boolean var2) {
        return ((Dropship)var1).o.size();
    }

    public boolean a(Unit var1, boolean var2) {
        if (((Dropship)var1).g) {
            return false;
        } else {
            return !((OrderableUnit)var1).cK() && ((Dropship)var1).o.size() > 0;
        }
    }
}
