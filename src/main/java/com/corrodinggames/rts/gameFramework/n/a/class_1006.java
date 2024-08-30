package com.corrodinggames.rts.gameFramework.n.a;

import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.maps.MapException;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.CustomException;
import com.corrodinggames.rts.game.units.custom.class_585;
import com.corrodinggames.rts.gameFramework.n.class_637;
import lombok.SneakyThrows;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.n.a.c
public strictfp class class_1006 extends class_1005 {
    Integer a;
    Integer b;
    PlayerData c;
    class_31 d;
    boolean e;
    boolean f;
    boolean g;
    boolean h;
    boolean i;
    boolean j;
    int k;
    boolean l;
    boolean m;
    boolean n;
    class_585 o;
    boolean p;

    @SneakyThrows
    public static class_1006 d(class_637 var0) {
        class_1006 var1 = new class_1006();
        var1.a = var0.d("maxUnits");
        byte var2 = 1;
        if (var1.a != null) {
            var2 = 0;
        }

        var1.b = var0.a("minUnits", var2);
        var1.c = var0.a();
        class_31 var3 = null;
        String var4 = var0.b("unitType");
        if (var4 != null) {
            var3 = UnitType.a(var4);
            if (var3 == null) {
                var0.g("Cound not find unitType:" + var4);
            }
        }

        var1.d = var3;
        var1.e = var0.a("onlybuildings", "onlyBuildings", false);
        var1.g = var0.a("onlyMainBuildings", false);
        var1.h = var0.a("onlyOnResourcePool", false);
        var1.f = var0.a("onlyidle", "onlyIdle", false);
        var1.k = var0.a("onlyTechLevel", -1);
        var1.j = var0.a("onlyBuilders", false);
        var1.i = var0.a("onlyEmptyQueue", false);
        var1.l = var0.a("onlyAttack", false);
        var1.m = var0.a("onlyAttackAir", false);
        var1.n = var0.a("onlyIfEmpty", false);
        String var5 = var0.b("onlyWithTag");
        if (var5 != null && !var5.equals("")) {
            try {
                var1.o = class_585.b(var5);
            } catch (Exception var7) {
                throw new MapException(var7.getMessage());
            }
        }

        var1.p = var0.a("includeIncomplete", false);
        return var1;
    }

    public boolean b(class_637 var1) {
        return this.e(var1);
    }

    public boolean e(class_637 var1) {
        int var2 = 0;
        Unit[] var3 = Unit.bE.a();
        int var4 = 0;

        for(int var5 = Unit.bE.size(); var4 < var5; ++var4) {
            Unit var6 = var3[var4];
            if ((this.c == null || var6.bX == this.c) && var6 instanceof OrderableUnit && var6.cN == null && var1.a(var6) && (this.d == null || var6.r() == this.d)) {
                OrderableUnit var7 = (OrderableUnit)var6;
                if ((this.p || var6.bT()) && (!this.l || var6.l()) && (!this.m || var6.l() && var7.af()) && (!this.e || var6.bI()) && (!this.g || var6.bI() && var6.bJ()) && (!this.h || var6.r().p()) && (!this.j || var6.ak()) && (!this.f || var7.aq()) && (!this.i || var7.a((class_585)null) <= 0) && (this.k == -1 || var6.V() == this.k) && (this.o == null || class_585.a(this.o, var6.de())) && (!this.n || var7.bB() <= 0)) {
                    ++var2;
                }
            }
        }

        if (var2 < this.b || this.a != null && var2 > this.a) {
            return false;
        } else {
            return true;
        }
    }
}
