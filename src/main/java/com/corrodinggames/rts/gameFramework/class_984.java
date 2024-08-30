package com.corrodinggames.rts.gameFramework;

import com.corrodinggames.rts.game.units.class_1042;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.ab
public strictfp class class_984 {
    class_684 a;
    boolean b;
    float c;
    float d;
    int e;
    boolean f;
    public class_684 g;
    // $FF: synthetic field
    final GroupController h;

    public class_984(GroupController var1) {
        this.h = var1;
        this.a = new class_684();
    }

    public void a(OrderableUnit var1, class_1042 var2) {
        var2.i = this;
        this.f = var2.j;
    }

    public void a(class_1042 var1) {
        Iterator var2 = this.a.iterator();

        while(var2.hasNext()) {
            OrderableUnit var3 = (OrderableUnit)var2.next();
            if (!var3.bV) {
                class_1042 var4 = var3.ar();
                if (var4 != null && var4.b(var1)) {
                    var3.ay();
                }
            }
        }

    }

    public void a() {
        this.a.clear();
        Unit[] var1 = Unit.bE.a();
        int var2 = 0;

        for(int var3 = Unit.bE.size(); var2 < var3; ++var2) {
            Unit var4 = var1[var2];
            if (var4 instanceof OrderableUnit) {
                OrderableUnit var5 = (OrderableUnit)var4;
                if (var5.I()) {
                    class_1042 var6 = var5.ar();
                    if (var6 != null && var6.i == this && var5.bg()) {
                        this.a.add(var5);
                        this.c = var6.g();
                        this.d = var6.h();
                    }
                }
            }
        }

    }

    public void a(OrderableUnit var1) {
        var1.ac = this.e;
        class_1042 var2 = var1.ar();
        if (var2 != null) {
            var2.i = this;
        }

    }

    public void b() {
        long var1 = com.corrodinggames.rts.gameFramework.Unit.loadAllUnitsTook();
        this.c();
    }

    public OrderableUnit a(class_684 var1, float var2, float var3, boolean var4) {
        float var5 = -1.0F;
        OrderableUnit var6 = null;
        Iterator var7 = var1.iterator();

        while(true) {
            OrderableUnit var8;
            float var9;
            do {
                do {
                    if (!var7.hasNext()) {
                        return var6;
                    }

                    var8 = (OrderableUnit)var7.next();
                } while(!var4 && (var8.ad != null || var8.ae));

                var9 = class_340.b(var2, var3, var8.xCord, var8.yCord);
                if (var8.af) {
                    var9 -= 160.0F;
                }
            } while(var5 != -1.0F && !(var9 < var5));

            var5 = var9;
            var6 = var8;
        }
    }

    public class_684 a(float var1, float var2, boolean var3) {
        class_684 var4 = new class_684(1);
        class_684 var5 = new class_684();
        var5.clear();
        var5.addAll(this.a);

        while(true) {
            OrderableUnit var6 = this.a(var5, var1, var2, true);
            if (var6 == null) {
                return var4;
            }

            var4.add(var6);
            var5.remove(var6);
            class_684 var7 = this.a(var5, var6, true, var3);
            var5.removeAll(var7);
        }
    }

    public class_684 a(class_684 var1, OrderableUnit var2, boolean var3, boolean var4) {
        class_684 var5 = new class_684(1);
        var5.clear();
        int var6 = 0;
        boolean var7 = false;
        boolean var8 = true;
        Object[] var9 = var1.a();
        int var10 = 0;

        int var11;
        for(var11 = var1.size(); var10 < var11; ++var10) {
            OrderableUnit var12 = (OrderableUnit)var9[var10];
            var12.ap = false;
        }

        for(var10 = 0; var10 <= 2; ++var10) {
            var11 = 0;

            for(int var15 = var1.size(); var11 < var15; ++var11) {
                OrderableUnit var13 = (OrderableUnit)var9[var11];
                if (!var13.ap && var13 != var2 && (var3 || var13.ad == null && !var13.ae) && var13.h() == var2.h()) {
                    float var14 = class_340.a(var13.xCord, var13.yCord, var2.xCord, var2.yCord);
                    if ((var10 != 0 || !(var14 > 3600.0F)) && (var10 != 1 || !(var14 > 14400.0F)) && (var4 && var14 < 160000.0F || var14 < 40000.0F && var6 < 25) && (var4 || class_340.c(var13.speed() - var2.speed()) < 0.4F)) {
                        var13.ap = true;
                        var5.add(var13);
                        ++var6;
                    }
                }
            }
        }

        return var5;
    }

    public void c() {
        GameEngine var1 = GameEngine.getGameEngine();
        float var2 = 0.0F;
        float var3 = 0.0F;
        float var4 = 0.0F;
        float var5 = 0.0F;
        long var6 = com.corrodinggames.rts.gameFramework.Unit.loadAllUnitsTook();
        this.a();
        this.h.b.setSite(0.0F, 0.0F);
        Iterator var8 = this.a.iterator();

        while(var8.hasNext()) {
            OrderableUnit var9 = (OrderableUnit)var8.next();
            this.h.b.moveAdd(var9.xCord, var9.yCord);
        }

        this.h.b.setSite(this.h.b.x / (float)this.a.size(), this.h.b.y / (float)this.a.size());
        float var24 = class_340.d(this.h.b.x, this.h.b.y, this.c, this.d);

        OrderableUnit var10;
        for(Iterator var25 = this.a.iterator(); var25.hasNext(); var10.ac = this.e) {
            var10 = (OrderableUnit)var25.next();
            if (var10.ah > 1) {
                var10.af = var10.ae;
            } else {
                var10.af = false;
            }

            if (var10.af && var10.ah > 7) {
                float var11 = class_340.c(var10.am, var24, 360.0F);
                if (class_340.c(var11) > 80.0F) {
                    var10.af = false;
                }
            }

            var10.aB();
            var10.ah = 0;
            var10.an = var1.by;
        }

        int var26 = 0;

        while(true) {
            var10 = null;
            long var27 = com.corrodinggames.rts.gameFramework.Unit.loadAllUnitsTook();
            var10 = this.a(this.a, this.c, this.d, false);
            if (var10 == null) {
                return;
            }

            var10.ae = true;
            class_984 var13 = null;
            if (var26 > 0) {
                var13 = this.h.b();
            }

            if (var13 != null) {
                var13.g = this.g;
                var13.a(var10);
            }

            class_684 var14 = this.a(this.a, var10, false, this.f);
            int var15 = 0;
            float var16 = 0.0F;

            for(Iterator var17 = var14.iterator(); var17.hasNext(); ++var15) {
                OrderableUnit var18 = (OrderableUnit)var17.next();
                if (var18.cj > var16) {
                    var16 = var18.cj;
                }

                var18.a(var10);
                if (var13 != null) {
                    var13.a(var18);
                }
            }

            if (var10 != null) {
                var10.ah = (short)(var15 + 1);
            }

            class_684 var28 = new class_684();
            Object[] var29 = this.a.a();
            int var19 = 0;

            for(int var20 = this.a.size(); var19 < var20; ++var19) {
                OrderableUnit var21 = (OrderableUnit)var29[var19];
                if (var21.ad == var10) {
                    var28.add(var21);
                }
            }

            class_684 var30 = this.h.a(var15, var16, var24);
            long var31 = com.corrodinggames.rts.gameFramework.Unit.loadAllUnitsTook();
            this.h.a(var28, var10, var30, var24, var15);
            long var22 = com.corrodinggames.rts.gameFramework.Unit.loadAllUnitsTook();
            this.h.a(var28, var10);
            ++var26;
        }
    }
}
