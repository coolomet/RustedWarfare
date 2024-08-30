package com.corrodinggames.rts.debug.test;

import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.class_113;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.custom.logicBooleans.BooleanParseException;
import com.corrodinggames.rts.game.units.custom.logicBooleans.UnitReference;
import com.corrodinggames.rts.gameFramework.GameEngine;

public strictfp class TestUnitReference extends AbstractScriptTest {
    public void a() {
        GameEngine.log("Unit Reference tests");
        class_591 var1 = class_591.b;
        class_113 var2 = class_591.a(false, var1);
        var2.b(PlayerData.i);
        class_113 var3 = class_591.a(false, var1);
        var3.b((PlayerData)PlayerData.i);
        var3.xCord = 2.0F;
        class_113 var4 = class_591.a(false, var1);
        var4.b((PlayerData)PlayerData.i);
        var4.xCord = 3.0F;
        class_113 var5 = class_591.a(false, var1);
        var5.b((PlayerData)PlayerData.i);
        var5.xCord = 3.0F;
        var3.C(var4);
        var3.C(var5);
        class_113 var6 = class_591.a(false, var1);
        var6.b((PlayerData)PlayerData.i);
        class_113 var7 = class_591.a(false, var1);
        var7.b((PlayerData)PlayerData.i);
        class_113 var8 = class_591.a(false, var1);
        var8.b((PlayerData)PlayerData.i);
        var2.bu = var6;
        var6.bv = var7;
        var4.bv = var7;
        var3.bu = var8;
        byte var9 = 2;
        GameEngine.log("=== unit reference tests == (runs:" + var9 + ")");
        Long var10 = com.corrodinggames.rts.gameFramework.Unit.loadAllUnitsTook();

        for(int var11 = 0; var11 < var9; ++var11) {
            this.a(var2, this.a("self"), var2);
            this.a(var2, this.a("self.parent"), (Unit)null);
            this.a("self.unknown", true);
            this.a(var2, this.a("self.parent"), (Unit)null);
            this.a(var2, this.a("nullUnit"), (Unit)null);
            this.a(var2, this.a("self.customTarget1"), var6);
            this.a(var2, this.a("self.customTarget1.customTarget2"), var7);
            this.a(var2, this.a("self.customTarget2"), (Unit)null);
            this.a(var2, this.a("self.nullUnit"), (Unit)null);
            this.a(var2, this.a("nullUnit.nullUnit"), (Unit)null);
            this.a(var4, this.a("self.parent.customTarget1"), var8);
            this.a(var3, this.a("self.transporting(slot=0)"), var4);
            this.a(var3, this.a("self.transporting(SLOT=0)"), var4);
            this.a("self.transporting(MISS=0)", true);
            this.a(var3, this.a("self.transporting(slot=3)"), (Unit)null);
            this.a(var3, this.a("self.transporting"), var4);
            this.a(var3, this.a("self.transporting(slot=0).customTarget2"), var7);
            this.a(var3, this.a("self.self.transporting(slot=0).customTarget2"), var7);
            this.a(var3, this.a("self.SELF.TRANsporting(slot=0).customTarget2"), var7);
            this.a(var3, this.a("self.SELF.transporting(slot=0).customTarget2"), var7);
            this.a(var2, this.a("self.nearestUnit(withinRange=500, withTag='test', relation='any')"));
            this.a("", true);
        }

        Long var14 = com.corrodinggames.rts.gameFramework.Unit.loadAllUnitsTook();
        double var12 = com.corrodinggames.rts.gameFramework.Unit.a(var10, var14);
        GameEngine.log("Took: " + var12);
    }

    public void a(String var1, boolean var2) {
        try {
            class_591 var3 = class_591.b;
            UnitReference.parseSingleUnitReferenceBlock(var3, var1);
        } catch (RuntimeException var5) {
            if (var5.getClass() != RuntimeException.class && var5.getClass() != BooleanParseException.class) {
                throw new RuntimeException(var5);
            }

            if (var2) {
                GameEngine.log("(debug)assertCreateError: " + var1 + " expected-error:" + var5.getMessage());
            }

            return;
        }

        throw new RuntimeException("assertCreateError got no error for: " + var1);
    }

    public UnitReference a(String var1) {
        try {
            class_591 var2 = class_591.b;
            UnitReference var3 = UnitReference.parseSingleUnitReferenceBlock(var2, var1);
            if (var3 == null) {
                throw new RuntimeException("Null when parsing [" + var1 + "]");
            } else {
                return var3;
            }
        } catch (RuntimeException var4) {
            throw new RuntimeException("Error: " + var4.getMessage() + " parsing [" + var1 + "]", var4);
        }
    }

    public void a(OrderableUnit var1, UnitReference var2, Unit var3) {
        Unit var4 = var2.get(var1);
        if (var4 != var3) {
            throw new RuntimeException("assertSame type expected:" + Unit.A(var3) + " got: " + Unit.A(var4));
        }
    }

    public void a(OrderableUnit var1, UnitReference var2) {
        var2.get(var1);
    }
}
