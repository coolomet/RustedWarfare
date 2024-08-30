package com.corrodinggames.rts.game.units.a;

import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.custom.d.class_447;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.f.class_71;

// $FF: renamed from: com.corrodinggames.rts.game.units.a.v
public strictfp class class_241 extends class_226 {
    class_31 a;
    int b;

    public boolean equals(Object var1) {
        if (this == var1) {
            return true;
        } else if (var1 != null && var1.getClass() == this.getClass()) {
            class_241 var2 = (class_241)var1;
            if (this.b != var2.b) {
                return false;
            } else {
                return this.a != var2.a ? false : super.equals(var1);
            }
        } else {
            return false;
        }
    }

    public class_241(class_31 var1) {
        this(var1, 1, (Integer)null);
    }

    public class_241(class_31 var1, int var2, Integer var3) {
        super("b_" + var1.v());
        this.b = 1;
        class_31 var4 = class_591.c(var1);
        if (var4 != null) {
            var1 = var4;
            this.a("b_" + var4.v());
        }

        if (var2 != 1) {
            this.a(this.N() + "_" + var2);
        }

        this.a = var1;
        this.b = var2;
        if (var3 != null) {
            this.g = (float)var3;
        }

    }

    public class_31 i() {
        return this.a;
    }

    public class_31 y() {
        return this.a;
    }

    public int t() {
        return this.b;
    }

    public String type() {
        String var1 = this.i().f();
        boolean var2 = false;
        boolean var3 = true;
        Unit var4 = Unit.c(this.i());
        if (this.b != 1 && var4 instanceof OrderableUnit) {
            ((OrderableUnit)var4).a(this.b);
        }

        var1 = var1 + "\n\n" + class_71.a(var4, false, var2, var3);
        if (this.b != 1 && var4 instanceof OrderableUnit) {
            ((OrderableUnit)var4).a((int)1);
        }

        return var1;
    }

    public String b() {
        class_31 var1 = this.i();
        String var2 = this.i().e();
        if (!(var1 instanceof class_591)) {
            if (this.t() == 2) {
                var2 = var2 + " T-2";
            }

            if (this.t() == 3) {
                var2 = var2 + " T-3";
            }
        }

        return var2;
    }

    public int c() {
        return this.B().a();
    }

    public class_447 B() {
        class_447 var1 = this.h.a();
        return var1 != null ? var1 : this.i().d(this.t());
    }

    public class_447 r_() {
        class_447 var1 = this.h.b();
        return var1 != null ? var1 : this.i().B();
    }

    public int b(Unit var1, boolean var2) {
        return -1;
    }

    public class_1052 e() {
        return class_1052.placeBuilding;
    }

    public DisplayType f() {
        return DisplayType.building;
    }

    public boolean n_() {
        return !this.i().C();
    }

    public boolean g(Unit var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        if ((this.i() == UnitType.AntiNukeLaucher || this.i() == UnitType.NukeLaucher) && var2.O() && var2.netEngine.gameMapData.nukes) {
            return true;
        } else {
            return this.i().w() ? true : super.g(var1);
        }
    }

    public boolean g() {
        return false;
    }

    public boolean u() {
        return true;
    }

    public boolean D() {
        return false;
    }

    public float p(Unit var1) {
        if (!(var1 instanceof OrderableUnit)) {
            return -1.0F;
        } else {
            OrderableUnit var2 = (OrderableUnit)var1;
            Unit var3 = var2.X();
            return var3 != null && var3.cm < 1.0F && var3.r() == this.i() ? var3.cm : -1.0F;
        }
    }

    public boolean r(Unit var1) {
        return this.h.a(var1, true);
    }

    public boolean b(Unit var1) {
        return this.h.a(var1, false);
    }
}
