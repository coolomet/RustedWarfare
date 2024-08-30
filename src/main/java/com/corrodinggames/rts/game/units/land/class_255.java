package com.corrodinggames.rts.game.units.land;

import com.corrodinggames.rts.game.units.class_32;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.a.class_253;
import com.corrodinggames.rts.gameFramework.h.class_1009;

// $FF: renamed from: com.corrodinggames.rts.game.units.e.i.1
final class class_255 extends class_253 {
    class_255(int var1) {
        super(var1);
    }

    public String type() {
        return "-Will unload all units when stopped";
    }

    public String b() {
        return class_1009.a("gui.actions.unload");
    }

    public int b(Unit var1, boolean var2) {
        return ((class_32)var1).bB();
    }

    public boolean a(Unit var1, boolean var2) {
        if (((class_32)var1).bA()) {
            return false;
        } else {
            return ((class_32)var1).f() && ((class_32)var1).bB() > 0;
        }
    }

    public boolean b(Unit var1) {
        return ((class_32)var1).j();
    }
}
