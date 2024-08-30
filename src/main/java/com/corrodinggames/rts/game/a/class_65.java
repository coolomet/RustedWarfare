package com.corrodinggames.rts.game.a;

import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.gameFramework.GameEngine;
import java.util.ArrayList;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.game.a.h
public abstract strictfp class class_65 extends class_63 {
    ArrayList F = new ArrayList();
    ArrayList G = new ArrayList();

    public int l() {
        return this.F.size();
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return false;
    }

    public class_65(class_138 var1) {
        super(var1);
    }

    public boolean m() {
        Iterator var1 = this.R.bm.iterator();

        while(var1.hasNext()) {
            class_63 var2 = (class_63)var1.next();
            if (var2 instanceof class_66) {
                class_66 var3 = (class_66)var2;
                if (var3.m == this) {
                    return true;
                }
            }
        }

        return false;
    }

    public void n() {
        Iterator var1 = this.F.iterator();

        while(true) {
            OrderableUnit var2;
            do {
                if (!var1.hasNext()) {
                    return;
                }

                var2 = (OrderableUnit)var1.next();
            } while(var2 != null && !var2.bV);

            if (var2 != null && var2.aB == this) {
                var2.aB = null;
            }

            if (var2 != null) {
                this.G.remove(var2);
            }

            var1.remove();
        }
    }

    public void o() {
        Iterator var1 = this.G.iterator();

        while(true) {
            OrderableUnit var2;
            do {
                if (!var1.hasNext()) {
                    return;
                }

                var2 = (OrderableUnit)var1.next();
            } while(var2 != null && !var2.bV && var2.cN == null && var2.cO == null);

            var1.remove();
        }
    }

    public void p() {
        this.q();
        this.G.clear();
        super.p();
    }

    protected void a(OrderableUnit var1) {
        if (var1.aB != null) {
            var1.aB.b(var1);
        }

        if (var1.bX != null && var1.bX != this.R) {
            GameEngine.warn("unit.team:" + var1.bX.site + ", ai:" + this.R.site);
        }

        this.F.add(var1);
        var1.aB = this;
    }

    public void b(OrderableUnit var1) {
        this.F.remove(var1);
        this.G.remove(var1);
        if (var1.aB == this) {
            var1.aB = null;
        }

    }

    public void q() {
        Iterator var1 = this.F.iterator();

        while(var1.hasNext()) {
            OrderableUnit var2 = (OrderableUnit)var1.next();
            if (var2 != null && var2.aB == this) {
                var2.aB = null;
            }
        }

        this.F.clear();
    }

    public void b(float var1) {
    }

    public abstract void c(float var1);
}
