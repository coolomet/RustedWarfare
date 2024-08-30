package com.corrodinggames.rts.game.units.air;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.a.class_253;
import com.corrodinggames.rts.gameFramework.h.class_1009;

// $FF: renamed from: com.corrodinggames.rts.game.units.b.d.2
final class class_271 extends class_253 {
    class_271(int var1) {
        super(var1);
    }

    public String type() {
        return "-Stop unloading";
    }

    public String b() {
        return class_1009.a("gui.actions.cancel");
    }

    public boolean a(Unit var1, boolean var2) {
        return ((Dropship)var1).g;
    }

    public boolean b(Unit var1) {
        return this.a(var1, false);
    }
}
