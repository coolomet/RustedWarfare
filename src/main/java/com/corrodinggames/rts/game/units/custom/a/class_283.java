package com.corrodinggames.rts.game.units.custom.a;

import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.a.class_1052;
import com.corrodinggames.rts.game.units.a.DisplayType;
import com.corrodinggames.rts.game.units.a.class_281;
import com.corrodinggames.rts.game.units.custom.class_113;
import com.corrodinggames.rts.game.units.custom.class_588;
import com.corrodinggames.rts.game.units.custom.class_601;
import com.corrodinggames.rts.game.units.custom.d.class_447;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.f.class_517;
import com.corrodinggames.rts.gameFramework.f.class_71;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.a.g
public strictfp class class_283 extends class_281 {
    public class_1037 a;
    public class_601 b;
    public AIUse c;

    public class_283(class_1037 var1, class_601 var2) {
        super((String)null);
        this.c = AIUse.disabled;
        String var3 = "";
        if (var1.k != null) {
            var3 = var3 + var1.k;
        }

        var3 = var3 + "_" + var1.a;
        if (var1.b != null) {
            var3 = var1.b;
        }

        this.a((String)var3);
        this.a = var1;
        this.b = var2;
        if (var1.J != null) {
            this.b = var1.J;
        }

        this.c = var1.aN;
        if (this.c == AIUse.auto) {
            boolean var4 = false;
            boolean var5 = false;
            if (var1.ag != null && var1.ah == null) {
                var5 = true;
            }

            if (var1.q.d()) {
                var4 = true;
                this.c = AIUse.upgrade;
            }

            if (var4 && !var5) {
                this.c = AIUse.upgrade;
            } else {
                this.c = AIUse.movementChange;
            }

            if (var1.I != null) {
                this.c = AIUse.sameAsBuilding;
            }
        }

    }

    public class_588 P() {
        return this.a.s;
    }

    public boolean F() {
        return true;
    }

    public boolean d(Unit var1, boolean var2) {
        return this.a.M;
    }

    public boolean k(Unit var1) {
        return this.a.O;
    }

    public boolean l(Unit var1) {
        return this.a.P;
    }

    public boolean u() {
        return super.u();
    }

    public boolean a(Unit var1, boolean var2) {
        class_113 var3 = (class_113)var1;
        if (!this.a.N && var3.a(this.N(), var2) > 0) {
            return false;
        } else {
            if (this.a.u != null) {
                if (var2 && this.Q()) {
                    if (!class_517.a((LogicBoolean)this.a.u, (OrderableUnit)var3)) {
                        return false;
                    }
                } else if (!this.a.u.read(var3)) {
                    return false;
                }
            }

            return super.a(var1, var2);
        }
    }

    public boolean g(Unit var1) {
        return this.a(var1, -1) ? true : super.g(var1);
    }

    public boolean a(Unit var1, int var2) {
        if (this.a.z != null && (var2 == -1 || var2 == 1)) {
            if (!(var1 instanceof class_113)) {
                GameEngine.n("CustomActionConfig lockedInGame:" + var1.r().i() + " is not a custom unit");
                return false;
            }

            if (this.a.z.read((class_113)var1)) {
                return true;
            }
        }

        if (this.a.B != null && (var2 == -1 || var2 == 2)) {
            if (!(var1 instanceof class_113)) {
                GameEngine.n("CustomActionConfig lockedInGame:" + var1.r().i() + " is not a custom unit");
                return false;
            }

            if (this.a.B.read((class_113)var1)) {
                return true;
            }
        }

        if (this.a.D != null && (var2 == -1 || var2 == 3)) {
            if (!(var1 instanceof class_113)) {
                GameEngine.n("CustomActionConfig lockedInGame:" + var1.r().i() + " is not a custom unit");
                return false;
            }

            if (this.a.D.read((class_113)var1)) {
                return true;
            }
        }

        return false;
    }

    public String j(Unit var1) {
        if (this.a(var1, 1) && this.a.A != null) {
            return this.a.A.b(var1);
        } else if (this.a(var1, 2) && this.a.C != null) {
            return this.a.C.b(var1);
        } else {
            return this.a(var1, 3) && this.a.E != null ? this.a.E.b(var1) : super.j(var1);
        }
    }

    public boolean r(Unit var1) {
        class_113 var2 = (class_113)var1;
        if (this.a.v != null) {
            return this.Q() ? class_517.a((LogicBoolean)this.a.v, (OrderableUnit)var2) : this.a.v.read(var2);
        } else {
            return super.b(var1);
        }
    }

    public boolean b(Unit var1) {
        class_113 var2 = (class_113)var1;
        return this.a.v != null ? this.a.v.read(var2) : super.b(var1);
    }

    public boolean a(Unit var1, PlayerData var2) {
        if (!this.a.w && !this.a.x) {
            return false;
        } else {
            return var1.bX.d(var2) ? this.a.w : this.a.x;
        }
    }

    public class_447 r_() {
        class_447 var1 = this.h.b();
        return var1 != null ? var1 : this.a.r;
    }

    public int b(Unit var1, boolean var2) {
        return this.a.aI ? this.a.q.a(var1, true) : super.b(var1, var2);
    }

    public String d() {
        return super.d();
    }

    public String b() {
        String var1 = null;
        if (this.a.d != null) {
            var1 = this.a.d.b();
        }

        return var1;
    }

    public String d(Unit var1) {
        String var2 = null;
        if (this.a.d != null) {
            var2 = this.a.d.b(var1);
        }

        if (this.a.e != null) {
            class_31 var3 = this.a.e.getTypeOrNull(var1);
            if (var3 != null) {
                if (var2 == null) {
                    var2 = "";
                } else if (!var2.equals("")) {
                    var2 = var2 + " ";
                }

                var2 = var2 + var3.e();
            }
        }

        if (this.a.h != null) {
            if (var2 == null) {
                var2 = "";
            } else if (!var2.equals("")) {
                var2 = var2 + " ";
            }

            var2 = var2 + this.a.h.b();
        }

        return var2;
    }

    public String type() {
        String var1 = null;
        if (this.a.i != null) {
            var1 = this.a.i.b();
        }

        return var1;
    }

    public String e(Unit var1) {
        String var2 = null;
        if (this.a.i != null) {
            var2 = this.a.i.b(var1);
        }

        if (this.a.f != null) {
            class_31 var3 = this.a.f.getTypeOrNull(var1);
            if (var3 != null) {
                if (var2 == null) {
                    var2 = "";
                } else if (!var2.equals("")) {
                    var2 = var2 + " ";
                }

                var2 = var2 + var3.f();
            }
        }

        if (this.a.g != null) {
            Unit var7 = this.a.g.getUnitReferenceOrNull(var1);
            if (var7 != null) {
                if (var2 == null) {
                    var2 = "";
                } else if (!var2.equals("")) {
                    var2 = var2 + "\n\n";
                }

                boolean var4 = false;
                String var5 = class_71.a(var7, false, false, var4);
                var2 = var2 + var5;
            } else {
                Unit var8 = this.a.g.getUnitOrSharedUnit(var1);
                if (var8 != null) {
                    if (var2 == null) {
                        var2 = "";
                    } else if (!var2.equals("")) {
                        var2 = var2 + "\n\n";
                    }

                    boolean var9 = true;
                    String var6 = class_71.a(var8, false, false, var9);
                    var2 = var2 + var6;
                }
            }
        }

        return var2;
    }

    public boolean L() {
        return this.a.U;
    }

    public float K() {
        return this.a.S >= 1.0F ? 1000.0F : this.a.S;
    }

    public class_1052 e() {
        return this.a.j;
    }

    public class_447 B() {
        class_447 var1 = this.h.a();
        return var1 != null ? var1 : this.a.q;
    }

    public int c() {
        return this.B().a();
    }

    public class_31 i() {
        return this.b == null ? null : this.b.c();
    }

    public class_31 y() {
        return this.a.J != null ? this.a.J.c() : null;
    }

    public class_31 E() {
        return this.a.I != null ? this.a.I.c() : null;
    }

    public boolean A() {
        return true;
    }

    public boolean g() {
        return this.a.J != null;
    }

    public DisplayType f() {
        return this.a.aG;
    }

    public boolean m(Unit var1) {
        return this.a.G.read((class_113)var1);
    }

    public boolean n(Unit var1) {
        if (this.a.F == null) {
            return false;
        } else if (!(var1 instanceof class_113)) {
            GameEngine.print("ai_isHighPriority non customUnit:" + var1.r().i());
            return false;
        } else {
            return this.a.F.read((class_113)var1);
        }
    }

    public AIUse v(Unit var1) {
        return this.c;
    }

    public boolean H() {
        return this.a.K;
    }

    public boolean I() {
        return this.a.L;
    }

    public TeamImageCache j() {
        return this.a.ay;
    }

    public TeamImageCache h(Unit var1) {
        return this.a.aB != null && var1 instanceof class_113 && !class_517.a((LogicBoolean)this.a.aB, (OrderableUnit)((class_113)var1)) ? null : this.a.az;
    }

    public int J() {
        return this.a.aA;
    }

    public Unit i(Unit var1) {
        if (this.a.aC != null) {
            Unit var2 = this.a.aC.getUnitOrSharedUnit(var1);
            return var2;
        } else {
            return null;
        }
    }

    public boolean s(Unit var1) {
        return this.a.aD;
    }

    public boolean t(Unit var1) {
        return this.a.aE;
    }

    public boolean a(Unit var1) {
        return this.a.aF != null ? class_517.a((LogicBoolean)this.a.aF, (OrderableUnit)((class_113)var1)) : false;
    }

    public boolean Q() {
        return this.a.o;
    }

    public void a(OrderableUnit var1) {
        if (this.a.ae != null) {
            class_517.b(var1, this.a.ae);
        }

    }
}
