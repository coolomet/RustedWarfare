package com.corrodinggames.rts.game.units.a;

import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.gameFramework.f.InterfaceEngine;
import com.corrodinggames.rts.gameFramework.h.class_1009;

// $FF: renamed from: com.corrodinggames.rts.game.units.a.m
public strictfp class class_234 extends class_226 {
    boolean a;

    public class_234(boolean var1) {
        super("c_2");
        this.a = var1;
    }

    public String type() {
        return !this.a ? class_1009.a("gui.actions.reclaimBuildingTarget.description") : class_1009.a("gui.actions.reclaimTarget.description");
    }

    public String b() {
        return !this.a ? class_1009.a("gui.actions.reclaimBuildingTarget") : class_1009.a("gui.actions.reclaimTarget");
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
        return class_1052.reclaimTarget;
    }

    public DisplayType f() {
        return DisplayType.action;
    }

    public boolean g() {
        return false;
    }

    public boolean h() {
        return true;
    }

    public boolean o(Unit var1) {
        if (var1 == null) {
            return true;
        } else {
            return !this.a ? var1.bI() : true;
        }
    }

    public float l() {
        return !InterfaceEngine.bP ? 0.6F : 1.0F;
    }

    // $FF: synthetic method
    public class_31 i() {
        return this.K();
    }
}
