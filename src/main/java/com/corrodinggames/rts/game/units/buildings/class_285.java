package com.corrodinggames.rts.game.units.buildings;

import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.a.DisplayType;
import com.corrodinggames.rts.game.units.a.class_281;
import com.corrodinggames.rts.gameFramework.h.class_1009;

// $FF: renamed from: com.corrodinggames.rts.game.units.d.g.2
final class class_285 extends class_281 {
    class_285(int var1) {
        super(var1);
    }

    public boolean g() {
        return false;
    }

    public String type() {
        return class_1009.a("units.extractor.upgrade.descriptionT3");
    }

    public String b() {
        return class_1009.a("gui.actions.upgradeT3");
    }

    public int c() {
        return UnitType.extractor.upgradePrice(3);
    }

    public float K() {
        return 3.0E-4F;
    }

    public boolean a(Unit var1, boolean var2) {
        Extractor var3 = (Extractor)var1;
        return var3.b == 2 && var3.a(this.N(), var2) <= 0 ? super.a(var1, var2) : false;
    }

    public UnitType L() {
        return null;
    }

    public DisplayType f() {
        return DisplayType.upgrade;
    }

    // $FF: synthetic method
    public class_31 i() {
        return this.L();
    }
}
