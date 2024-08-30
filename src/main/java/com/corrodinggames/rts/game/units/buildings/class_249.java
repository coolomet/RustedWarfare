package com.corrodinggames.rts.game.units.buildings;

import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.a.class_1052;
import com.corrodinggames.rts.game.units.a.DisplayType;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.gameFramework.h.class_1009;

// $FF: renamed from: com.corrodinggames.rts.game.units.d.c.1
final class class_249 extends class_226 {
    class_249(int var1) {
        super(var1);
    }

    public boolean g() {
        return false;
    }

    public String type() {
        return "";
    }

    public String b() {
        return class_1009.a("gui.actions.antiNukeCount");
    }

    public int c() {
        return 0;
    }

    public boolean a(Unit var1, boolean var2) {
        return this.b(var1, false) != 0;
    }

    public UnitType K() {
        return null;
    }

    public class_1052 e() {
        return class_1052.none;
    }

    public DisplayType f() {
        return DisplayType.none;
    }

    public int b(Unit var1, boolean var2) {
        AntiNukeLaucher var3 = (AntiNukeLaucher)var1;
        return var3.d;
    }

    // $FF: synthetic method
    public class_31 i() {
        return this.K();
    }
}
