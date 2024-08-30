package com.corrodinggames.rts.game.units.buildings;

import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.a.class_1052;
import com.corrodinggames.rts.game.units.a.DisplayType;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.gameFramework.h.class_1009;

// $FF: renamed from: com.corrodinggames.rts.game.units.d.q.1
final class class_251 extends class_226 {
    class_251(int var1) {
        super(var1);
    }

    public String type() {
        return class_1009.a("gui.actions.launchNuke");
    }

    public String b() {
        return class_1009.a("gui.actions.launchNuke");
    }

    public int c() {
        return 0;
    }

    public int b(Unit var1, boolean var2) {
        NukeLaucher var3 = (NukeLaucher)var1;
        return var3.c;
    }

    public UnitType K() {
        return null;
    }

    public class_1052 e() {
        return class_1052.targetGround;
    }

    public DisplayType f() {
        return DisplayType.action;
    }

    public boolean g() {
        return false;
    }

    public boolean a(Unit var1, boolean var2) {
        NukeLaucher var3 = (NukeLaucher)var1;
        return var3.c > 0;
    }

    // $FF: synthetic method
    public class_31 i() {
        return this.K();
    }
}
