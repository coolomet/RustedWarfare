package com.corrodinggames.rts.game.units.land;

import com.corrodinggames.rts.game.units.class_32;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.a.class_253;
import com.corrodinggames.rts.gameFramework.h.class_1009;

// $FF: renamed from: com.corrodinggames.rts.game.units.e.i.2
final class class_254 extends class_253 {
    class_254(int var1) {
        super(var1);
    }

    public String type() {
        return "-Stop unloading";
    }

    public String b() {
        return class_1009.a("gui.actions.cancel");
    }

    public boolean a(Unit var1, boolean var2) {
        return ((class_32)var1).bA();
    }

    public boolean b(Unit var1) {
        return this.a(var1, false);
    }
}
