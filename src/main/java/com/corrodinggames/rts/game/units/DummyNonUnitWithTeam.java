package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.PlayerData;

// $FF: renamed from: com.corrodinggames.rts.game.units.t
public strictfp class DummyNonUnitWithTeam extends class_83 {
    public static DummyNonUnitWithTeam a(PlayerData var0) {
        DummyNonUnitWithTeam var1 = new DummyNonUnitWithTeam(true);
        var1.b(var0);
        var1.bV = true;
        return var1;
    }

    DummyNonUnitWithTeam(boolean var1) {
        super(var1);
    }

    public class_31 r() {
        return UnitType.dummyNonUnitWithTeam;
    }

    public static void b() {
    }

    public String c() {
        String var1 = this.r().i() + "(pos:" + (int)this.xCord + "," + (int)this.yCord;
        if (this.bX != null) {
            var1 = var1 + " t:" + this.bX.site;
        }

        var1 = var1 + ")";
        return var1;
    }
}
