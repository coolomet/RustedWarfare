package com.corrodinggames.rts.game.units.a;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.f.class_523;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;

// $FF: renamed from: com.corrodinggames.rts.game.units.a.h
public strictfp class class_231 extends class_226 {
    class_226 a;
    class_661 b;
    boolean c;
    public int d;
    public boolean e;
    public final int f;

    public float m_() {
        return this.a.m_();
    }

    public int a(class_226 var1) {
        return this.a.a(var1);
    }

    public String b() {
        return this.a.b();
    }

    public String d(Unit var1) {
        return this.a.d(var1);
    }

    public String type() {
        String var1 = this.a.type();
        return var1;
    }

    public String e(Unit var1) {
        return this.a.e(var1);
    }

    public int c() {
        return 0;
    }

    public int b(Unit var1, boolean var2) {
        return this.a.b(var1, var2);
    }

    public boolean n_() {
        return this.a.n_();
    }

    public boolean a(Unit var1, boolean var2) {
        return this.c ? this.a.a(var1, var2) : true;
    }

    public int t() {
        return this.a.t();
    }

    public void f(Unit var1) {
        this.a.f(var1);
    }

    public boolean equals(Object var1) {
        return var1 instanceof class_231 ? this.a.equals(((class_231)var1).a) : false;
    }

    public boolean g(Unit var1) {
        return this.a.g(var1);
    }

    public boolean b(Unit var1) {
        return !this.b.isAvailable(this, var1) ? false : this.a.b(var1);
    }

    public boolean u() {
        return this.a.u();
    }

    public boolean h() {
        return this.a.h();
    }

    public class_31 i() {
        return this.a.i();
    }

    public boolean g() {
        return this.a.g();
    }

    public class_1052 e() {
        return this.a.e();
    }

    public DisplayType f() {
        return this.a.f();
    }

    public String d() {
        return this.a.d();
    }

    public boolean h_() {
        return this.a.h_();
    }

    public void a(Unit var1, class_523 var2, Paint var3, Paint var4) {
        this.a.a(var1, var2, var3, var4);
    }

    public void a(Unit var1, class_523 var2) {
        this.a.a(var1, var2);
        class_31 var3 = this.a.i();
        if (var3 != null && var3 instanceof class_591) {
            class_591 var4 = (class_591)var3;
            if (var4.J != null) {
                String var5 = var4.J.modName();
                var5 = class_340.a((String)var5, (int)30);
                var2.a("\n(mod: " + var5 + ")", this.f, true);
            }
        }

    }

    public TeamImageCache j() {
        return this.a.j();
    }

    public TeamImageCache h(Unit var1) {
        return this.a.h(var1);
    }

    public Rect v() {
        return this.a.v();
    }

    public Unit i(Unit var1) {
        return this.a.i(var1);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a.toString();
    }

    public class_231(class_226 var1, class_661 var2) {
        this(var1, var2, false);
    }

    public class_231(class_226 var1, class_661 var2, boolean var3) {
        super(var1.N());
        this.b = class_661.emptyActionFilter;
        this.d = 0;
        this.f = Color.a(255, 50, 50, 50);
        this.a = var1;
        this.b = var2;
        this.e(this.a.N());
        this.g = this.a.g;
        this.c = var3;
    }

    public class_226 q_() {
        return this.a;
    }

    public boolean x() {
        return true;
    }

    public boolean s() {
        if (!this.b.isAvailable(this, (Unit)null)) {
            return false;
        } else {
            return this.c ? this.a.s() : true;
        }
    }

    public class_31 y() {
        return this.a.y();
    }

    public boolean c(Unit var1, boolean var2) {
        return this.a.c(var1, var2);
    }

    public boolean a(Unit var1) {
        return this.a.a(var1);
    }

    // $FF: synthetic method
    public int compareTo(Object var1) {
        return this.a((class_226)var1);
    }
}
