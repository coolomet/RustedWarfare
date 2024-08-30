package com.corrodinggames.rts.game.units.a;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.class_588;
import com.corrodinggames.rts.game.units.custom.a.AIUse;
import com.corrodinggames.rts.game.units.custom.d.class_447;
import com.corrodinggames.rts.game.units.g.class_794;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_987;
import com.corrodinggames.rts.gameFramework.f.class_523;
import com.corrodinggames.rts.gameFramework.f.class_71;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import java.util.ArrayList;

// $FF: renamed from: com.corrodinggames.rts.game.units.a.s
public abstract strictfp class class_226 implements Comparable {
    public float g = -999.0F;
    public class_1033 h;
    public static final class_1059 i;
    private class_1059 a;
    private class_447 b;

    public float m_() {
        if (this instanceof class_237) {
            return -100.0F;
        } else if (this.g != -999.0F) {
            return this.g;
        } else {
            class_31 var1 = this.i();
            return var1 != null && this.g() ? (float)var1.g() : 1.0F;
        }
    }

    public int a(class_226 var1) {
        if (var1 == null) {
            return 0;
        } else {
            float var2 = this.m_() - var1.m_();
            if (var2 < 0.0F) {
                return -1;
            } else {
                return var2 > 0.0F ? 1 : 0;
            }
        }
    }

    public boolean equals(Object var1) {
        if (this == var1) {
            return true;
        } else if (var1 != null && var1.getClass() == this.getClass()) {
            class_226 var2 = (class_226)var1;
            return this.a.equals(var2.a);
        } else {
            return false;
        }
    }

    public static final boolean b(class_1059 var0) {
        return var0 == null || var0 == i;
    }

    public static final boolean c(class_1059 var0) {
        return !b(var0);
    }

    public static boolean a(class_226 var0, class_226 var1) {
        return var0 == var1;
    }

    public final boolean d(class_1059 var1) {
        return this.a == var1;
    }

    public class_226(int var1) {
        this.h = class_1033.a;
        this.a(String.valueOf(var1));
    }

    public class_226(String var1) {
        this.h = class_1033.a;
        this.a(var1);
    }

    public class_226(class_1059 var1) {
        this.h = class_1033.a;
        this.e(var1);
    }

    public final void a(String var1) {
        this.a = class_1059.a(var1);
    }

    public final void e(class_1059 var1) {
        this.a = var1;
    }

    public final class_1059 N() {
        return this.a;
    }

    public class_1059 z() {
        return this.N();
    }

    public final String O() {
        return this.a == null ? "<null index>" : this.a.a();
    }

    public abstract String b();

    public abstract String type();

    public class_588 P() {
        return null;
    }

    public String d(Unit var1) {
        return this.b();
    }

    public String e(Unit var1) {
        return this.type();
    }

    public abstract int c();

    public class_447 B() {
        class_447 var1 = this.h.a();
        if (var1 != null) {
            return var1;
        } else {
            int var2 = this.c();
            if (var2 == 0) {
                return class_447.a;
            } else {
                if (this.b == null || this.b.a() != var2) {
                    this.b = class_447.a(var2);
                }

                return this.b;
            }
        }
    }

    public class_447 r_() {
        return this.h.b() != null ? this.h.b() : null;
    }

    public abstract int b(Unit var1, boolean var2);

    public boolean n_() {
        return false;
    }

    public boolean g(Unit var1) {
        return this.h.b(var1);
    }

    public String j(Unit var1) {
        return this.h.c(var1);
    }

    public void a(Unit var1, Unit var2) {
        this.h.a(var1, var2);
    }

    public boolean d(Unit var1, boolean var2) {
        return true;
    }

    public boolean k(Unit var1) {
        return false;
    }

    public boolean l(Unit var1) {
        return false;
    }

    public boolean a(Unit var1, boolean var2) {
        if (this.g(var1)) {
            return false;
        } else if (class_794.a(var1, this.N()) > 0) {
            return false;
        } else {
            return var2 ? this.B().c(var1, this.Q()) : this.B().b(var1);
        }
    }

    public boolean r(Unit var1) {
        return this.b(var1);
    }

    public boolean u(Unit var1) {
        return this.h.a(var1);
    }

    public boolean b(Unit var1) {
        return this.h.a(var1, false);
    }

    public boolean a(Unit var1, PlayerData var2) {
        return false;
    }

    public boolean u() {
        return false;
    }

    public boolean h() {
        return false;
    }

    public boolean C() {
        return false;
    }

    public boolean D() {
        return true;
    }

    public boolean A() {
        return false;
    }

    public abstract class_31 i();

    public class_31 y() {
        return null;
    }

    public class_31 E() {
        return null;
    }

    public boolean F() {
        return false;
    }

    public int t() {
        return 1;
    }

    public abstract boolean g();

    public abstract class_1052 e();

    public boolean o() {
        return false;
    }

    public abstract DisplayType f();

    public boolean m(Unit var1) {
        return false;
    }

    public boolean n(Unit var1) {
        return false;
    }

    public AIUse v(Unit var1) {
        return null;
    }

    public String d() {
        String var1 = null;
        GameEngine var2 = GameEngine.getGameEngine();
        int var3 = 0;
        Unit[] var4 = var2.bS.bZ.a();
        int var5 = var2.bS.bZ.size();

        for(int var6 = 0; var6 < var5; ++var6) {
            Unit var7 = var4[var6];
            if (var7 instanceof OrderableUnit) {
                OrderableUnit var8 = (OrderableUnit)var7;
                if (var1 == null) {
                    var1 = this.d((Unit)var8);
                }

                int var9 = this.b(var8, true);
                if (var9 != -1 && var9 != 0) {
                    var3 += var9;
                }
            }
        }

        if (var1 == null) {
            var1 = this.b();
        }

        if (var3 != -1 && var3 != 0) {
            var1 = var1 + " (" + var3 + ")";
        }

        return var1;
    }

    public boolean h_() {
        return true;
    }

    public String w(Unit var1) {
        return this.d(var1);
    }

    public void a(Unit var1, class_523 var2, Paint var3, Paint var4) {
        Paint var5 = var2.g;
        if (var3 != null) {
            var2.a(var3);
        }

        if (this.h_()) {
            String var6 = this.w(var1);
            if (var6 != null && !var6.equals("")) {
                var2.b(var6);
            }
        }

        if (var3 != null) {
            var2.a(var5);
        }

        DisplayType var11 = this.f();
        class_447 var7 = this.B();
        if (!var7.c() && var11 != DisplayType.infoOnlyStockpile) {
            boolean var8 = true;
            var2.b(" (");
            Unit var9 = null;
            int var10 = 0;
            if (var4 != null) {
                var9 = var1;
                var10 = var4.e();
            }

            var7.a(var2, false, true, 5, var8, var9, var10);
            var2.b(")");
        }

        class_447 var12 = this.r_();
        if (var12 != null && !var12.c() && var11 != DisplayType.infoOnlyStockpile) {
            boolean var13 = true;
            var2.b(" (");
            byte var14 = 0;
            var12.a(var2, false, true, 5, var13, (Unit)null, var14);
            var2.b(")");
        }

    }

    public void a(Unit var1, class_523 var2) {
        String var3 = class_71.a(this, false);
        if (var3 != null && !"".equals(var3)) {
            var3 = var3.trim();
            var2.b("\n" + var3);
        }

        String var4 = this.e(var1);
        if (var4 != null && !"".equals(var4)) {
            var4 = var4.trim();
            var2.b("\n" + var4);
        }

    }

    public boolean c(Unit var1, boolean var2) {
        return false;
    }

    public void f(Unit var1) {
    }

    public TeamImageCache j() {
        return this.f() == DisplayType.upgrade ? GameEngine.getGameEngine().bS.bk : null;
    }

    public TeamImageCache h(Unit var1) {
        return null;
    }

    public int J() {
        return Color.a(100, 255, 255, 255);
    }

    public Rect v() {
        return null;
    }

    public Unit i(Unit var1) {
        return null;
    }

    public boolean s(Unit var1) {
        return true;
    }

    public boolean t(Unit var1) {
        return true;
    }

    public boolean a(Unit var1) {
        return this.h.d(var1);
    }

    public boolean s() {
        return false;
    }

    public boolean o(Unit var1) {
        return true;
    }

    public boolean G() {
        return false;
    }

    public void c(Unit var1) {
    }

    public float l() {
        return 1.0F;
    }

    public int m() {
        return -1;
    }

    public boolean H() {
        return false;
    }

    public boolean I() {
        return false;
    }

    public boolean x() {
        return false;
    }

    public float p(Unit var1) {
        return -1.0F;
    }

    public ArrayList q(Unit var1) {
        return null;
    }

    public class_987 M() {
        return null;
    }

    public boolean o_() {
        return false;
    }

    public boolean Q() {
        return false;
    }

    public void a(OrderableUnit var1) {
    }

    public boolean a(float var1, float var2) {
        return false;
    }

    public boolean p() {
        return false;
    }

    // $FF: synthetic method
    public int compareTo(Object var1) {
        return this.a((class_226)var1);
    }

    static {
        i = class_1059.a;
    }
}
