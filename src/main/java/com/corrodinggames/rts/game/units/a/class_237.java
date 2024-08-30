package com.corrodinggames.rts.game.units.a;

import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.h.class_1009;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;

// $FF: renamed from: com.corrodinggames.rts.game.units.a.o
public strictfp class class_237 extends class_226 {
    public class_237() {
        super("c_1");
    }

    public String type() {
        return class_1009.a("gui.actions.setRally.description");
    }

    public String b() {
        return class_1009.a("gui.actions.setRally");
    }

    public int c() {
        return 0;
    }

    public int b(Unit var1, boolean var2) {
        return -1;
    }

    public UnitType K() {
        return null;
    }

    public class_1052 e() {
        return class_1052.setRally;
    }

    public DisplayType f() {
        return DisplayType.rally;
    }

    public boolean g() {
        return false;
    }

    public TeamImageCache j() {
        return GameEngine.getGameEngine().bS.bj;
    }

    public boolean h() {
        return true;
    }

    // $FF: synthetic method
    public class_31 i() {
        return this.K();
    }
}
