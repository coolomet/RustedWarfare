package com.corrodinggames.rts.game.units.custom.a;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.a.class_1033;
import com.corrodinggames.rts.game.units.custom.class_441;
import com.corrodinggames.rts.game.units.custom.class_595;
import com.corrodinggames.rts.game.units.custom.d.class_447;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.f.class_517;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.a.c
public strictfp class class_1035 extends class_1033 {
    public LogicBoolean b;
    public LogicBoolean c;
    public class_441 d;
    public LogicBoolean e;
    public class_441 f;
    public LogicBoolean g;
    public class_441 h;
    public boolean i;
    public LogicBoolean j;
    public class_447 k;
    public class_447 l;
    public class_447 m;

    public static class_1033 a(class_1037 var0) {
        boolean var1 = false;
        if (var0.z != null && var0.z != LogicBoolean.falseBoolean) {
            var1 = true;
        }

        if (var0.B != null && var0.B != LogicBoolean.falseBoolean) {
            var1 = true;
        }

        if (var0.D != null && var0.D != LogicBoolean.falseBoolean) {
            var1 = true;
        }

        if (var0.v != null && var0.v != LogicBoolean.trueBoolean) {
            var1 = true;
        }

        if (var0.aF != null && var0.aF != LogicBoolean.falseBoolean) {
            var1 = true;
        }

        if (var0.ae != null) {
            var1 = true;
        }

        if (var0.q != null) {
            var1 = true;
        }

        if (!var1) {
            return class_1033.a;
        } else {
            class_1035 var2 = new class_1035();
            var2.c = var0.z;
            var2.d = var0.A;
            var2.e = var0.B;
            var2.f = var0.C;
            var2.g = var0.D;
            var2.h = var0.E;
            var2.b = var0.v;
            var2.j = var0.aF;
            var2.l = var0.ae;
            var2.k = var0.q;
            var2.m = var0.r;
            var2.i = var0.y;
            return var2;
        }
    }

    public static class_1033 a(class_595 var0) {
        boolean var1 = false;
        if (var0.f != null && var0.f != LogicBoolean.falseBoolean) {
            var1 = true;
        }

        if (!var1) {
            return class_1033.a;
        } else {
            class_1035 var2 = new class_1035();
            var2.c = var0.f;
            var2.d = class_441.a(var0.g);
            return var2;
        }
    }

    public boolean a(Unit var1) {
        return this.i;
    }

    public boolean b(Unit var1) {
        return this.a(var1, -1);
    }

    public boolean a(Unit var1, int var2) {
        if (this.c != null && (var2 == -1 || var2 == 1)) {
            if (!(var1 instanceof OrderableUnit)) {
                GameEngine.n("CustomActionConfig lockedInGame:" + var1.r().i() + " is not a OrderableUnit unit");
                return false;
            }

            if (this.c.read((OrderableUnit)var1)) {
                return true;
            }
        }

        if (this.e != null && (var2 == -1 || var2 == 2)) {
            if (!(var1 instanceof OrderableUnit)) {
                GameEngine.n("CustomActionConfig lockedInGame:" + var1.r().i() + " is not a OrderableUnit unit");
                return false;
            }

            if (this.e.read((OrderableUnit)var1)) {
                return true;
            }
        }

        if (this.g != null && (var2 == -1 || var2 == 3)) {
            if (!(var1 instanceof OrderableUnit)) {
                GameEngine.n("CustomActionConfig lockedInGame:" + var1.r().i() + " is not a OrderableUnit unit");
                return false;
            }

            if (this.g.read((OrderableUnit)var1)) {
                return true;
            }
        }

        return false;
    }

    public String c(Unit var1) {
        if (this.a(var1, 1) && this.d != null) {
            return this.d.b(var1);
        } else if (this.a(var1, 2) && this.f != null) {
            return this.f.b(var1);
        } else {
            return this.a(var1, 3) && this.h != null ? this.h.b(var1) : null;
        }
    }

    public boolean a(Unit var1, boolean var2) {
        if (this.b != null) {
            if (!(var1 instanceof OrderableUnit)) {
                GameEngine.n("CustomActionConfig isAvailable:" + var1.r().i() + " is not a OrderableUnit unit");
                return true;
            } else {
                return var2 ? class_517.a(this.b, (OrderableUnit)var1) : this.b.read((OrderableUnit)var1);
            }
        } else {
            return true;
        }
    }

    public boolean d(Unit var1) {
        if (this.j != null) {
            if (!(var1 instanceof OrderableUnit)) {
                GameEngine.n("CustomActionConfig isGuiBlinking:" + var1.r().i() + " is not a OrderableUnit unit");
                return true;
            } else {
                return this.j.read((OrderableUnit)var1);
            }
        } else {
            return false;
        }
    }

    public void a(Unit var1, Unit var2) {
        if (this.l != null) {
            this.l.h(var1);
        }

    }

    public class_447 a() {
        return this.k;
    }

    public class_447 b() {
        return this.m;
    }
}
