package com.corrodinggames.rts.game.units.a;

import android.graphics.Paint;
import android.graphics.Rect;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.d.class_447;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.f.class_523;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.utility.class_692;
import java.util.ArrayList;

// $FF: renamed from: com.corrodinggames.rts.game.units.a.g
public strictfp class class_230 extends class_226 {
    public class_226 a;
    public OrderableUnit b;
    public class_661 c;
    static class_692 d;
    static final class_692 e = new class_692();

    private void K() {
        GameEngine var1 = GameEngine.getGameEngine();
        if (d != null) {
            throw new RuntimeException("savedSelectedUnitsCache!=null");
        } else {
            d = var1.bS.bZ;
            e.clear();
            e.a((Unit)this.b);
            var1.bS.bZ = e;
        }
    }

    private void L() {
        GameEngine var1 = GameEngine.getGameEngine();
        if (d == null) {
            throw new RuntimeException("savedSelectedUnitsCache==null");
        } else {
            var1.bS.bZ = d;
            d = null;
            e.clear();
        }
    }

    public float m_() {
        return super.m_();
    }

    public int a(class_226 var1) {
        return super.a(var1);
    }

    public String b() {
        return this.a.b();
    }

    public String d(Unit var1) {
        return this.a.d((Unit)this.b);
    }

    public String type() {
        String var1 = this.a.type();
        return var1;
    }

    public String e(Unit var1) {
        return this.a.e((Unit)this.b);
    }

    public int c() {
        return this.a.c();
    }

    public int b(Unit var1, boolean var2) {
        return this.a.b(this.b, var2);
    }

    public boolean n_() {
        return this.a.n_();
    }

    public boolean a(Unit var1, boolean var2) {
        return this.a.a(this.b, var2);
    }

    public int t() {
        return this.a.t();
    }

    public void f(Unit var1) {
        this.a.f(this.b);
    }

    public boolean equals(Object var1) {
        return super.equals(var1);
    }

    public boolean g(Unit var1) {
        return this.a.g(this.b);
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
        this.K();
        String var1 = this.a.d();
        this.L();
        return var1;
    }

    public boolean h_() {
        return this.a.h_();
    }

    public void a(Unit var1, class_523 var2, Paint var3, Paint var4) {
        this.K();
        this.a.a(this.b, var2, var3, var4);
        this.L();
    }

    public void a(Unit var1, class_523 var2) {
        this.K();
        this.a.a((Unit)this.b, (class_523)var2);
        this.L();
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
        return this.a.i(this.b);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a.toString();
    }

    public class_230(class_226 var1, OrderableUnit var2, class_1059 var3) {
        super(var3);
        this.c = class_661.emptyActionFilter;
        this.a = var1;
        this.b = var2;
        this.g = this.a.g;
    }

    public class_226 p_() {
        return this.a;
    }

    public boolean x() {
        return this.a.x();
    }

    public boolean s() {
        return this.a.s();
    }

    public class_31 y() {
        return this.a.y();
    }

    public class_1059 z() {
        return this.a.N();
    }

    public void a(Unit var1, Unit var2) {
        super.a(var1, var2);
    }

    public boolean a(Unit var1, PlayerData var2) {
        return this.a.a((Unit)this.b, (PlayerData)var2);
    }

    public boolean A() {
        return this.a.A();
    }

    public boolean a(Unit var1) {
        return this.a.a((Unit)this.b);
    }

    public class_447 B() {
        return this.a.B();
    }

    public String j(Unit var1) {
        return this.a.j(this.b);
    }

    public boolean d(Unit var1, boolean var2) {
        return this.a.d(this.b, var2);
    }

    public boolean k(Unit var1) {
        return this.a.k(this.b);
    }

    public boolean l(Unit var1) {
        return this.a.l(this.b);
    }

    public boolean C() {
        return this.a.C();
    }

    public boolean D() {
        return this.a.D();
    }

    public class_31 E() {
        return this.a.E();
    }

    public boolean F() {
        return this.a.F();
    }

    public boolean m(Unit var1) {
        return this.a.m(this.b);
    }

    public boolean n(Unit var1) {
        return this.a.n(this.b);
    }

    public boolean c(Unit var1, boolean var2) {
        return this.a.c(this.b, var2);
    }

    public boolean o(Unit var1) {
        return this.a.o(this.b);
    }

    public boolean G() {
        return this.a.G();
    }

    public void c(Unit var1) {
        this.a.c((Unit)this.b);
    }

    public float l() {
        return this.a.l();
    }

    public int m() {
        return this.a.m();
    }

    public boolean H() {
        return this.a.H();
    }

    public boolean I() {
        return this.a.I();
    }

    public float p(Unit var1) {
        return this.a.p(this.b);
    }

    public ArrayList q(Unit var1) {
        return this.a.q(this.b);
    }

    public boolean r(Unit var1) {
        return !this.c.isAvailable(this, var1) ? false : this.a.r(this.b);
    }

    public boolean b(Unit var1) {
        return !this.c.isAvailable(this, var1) ? false : this.a.b((Unit)this.b);
    }

    public int J() {
        return this.a.J();
    }

    public boolean s(Unit var1) {
        return this.a.s(this.b);
    }

    public boolean t(Unit var1) {
        return this.a.t(this.b);
    }

    public boolean a(class_230 var1) {
        return this.a == var1.a && this.b == var1.b && this.N() == var1.N() && this.c == var1.c;
    }

    // $FF: synthetic method
    public int compareTo(Object var1) {
        return this.a((class_226)var1);
    }
}
