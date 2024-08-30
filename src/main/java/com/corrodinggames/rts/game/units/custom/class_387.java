package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.game.maps.class_484;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.utility.UnitConfig;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.be
public final strictfp class class_387 {
    class_684 a = new class_684();
    class_684 b = new class_684();
    boolean c;
    boolean d;
    public static final class_313 e = new class_313();

    public static class_387 a(class_591 var0, UnitConfig var1) {
        class_387 var2 = new class_387();
        var2.b(var0, var1);
        if (var2.b.size() == 0) {
            return null;
        } else {
            Iterator var3 = var2.a.iterator();

            while(true) {
                class_585 var4;
                do {
                    if (!var3.hasNext()) {
                        return var2;
                    }

                    var4 = (class_585)var3.next();
                } while(var4 == null);

                int var5 = 0;
                class_391 var6 = null;
                Iterator var7 = var2.b.iterator();

                while(var7.hasNext()) {
                    class_391 var8 = (class_391)var7.next();
                    if (var8.b == var4) {
                        ++var5;
                        var6 = var8;
                    }
                }

                if (var5 == 1) {
                    var0.r("[placementRule_" + var6.a + "]anyRuleInGroup: No other rule with this same group name found");
                }
            }
        }
    }

    public void b(class_591 var1, UnitConfig var2) {
        Iterator var3 = var2.e("placementRule_").iterator();

        while(var3.hasNext()) {
            String var4 = (String)var3.next();
            String var5 = var4.substring("placementRule_".length());
            class_391 var6 = new class_391();
            var6.a = var5;
            var6.a(var1, var2, var4);
            if (var6.a()) {
                if (!this.a.contains(var6.b)) {
                    this.a.add(var6.b);
                }

                if (var6.n) {
                    if (!var6.p) {
                        this.c = true;
                    } else {
                        this.d = true;
                    }
                }

                this.b.add(var6);
            }
        }

    }

    public String a(OrderableUnit var1, float var2, float var3) {
        return !this.c ? null : this.b(var1, var2, var3);
    }

    public String a(OrderableUnit var1, int var2, int var3) {
        if (!this.d) {
            return null;
        } else {
            class_484 var4 = GameEngine.getGameEngine().bL;
            var4.b(var2, var3);
            return this.b(var1, (float)var4.T, (float)var4.U);
        }
    }

    public String b(OrderableUnit var1, float var2, float var3) {
        Iterator var4 = this.a.iterator();

        class_391 var8;
        boolean var12;
        do {
            if (!var4.hasNext()) {
                return null;
            }

            class_585 var5 = (class_585)var4.next();
            boolean var6 = false;
            boolean var7 = false;
            var8 = null;
            Iterator var9 = this.b.iterator();

            while(var9.hasNext()) {
                class_391 var10 = (class_391)var9.next();
                if (var10.b == var5 && var10.n) {
                    boolean var11 = a(var1, var10, var2, var3);
                    if (!var11) {
                        if (var8 == null) {
                            var8 = var10;
                        }

                        var7 = true;
                    } else {
                        var6 = true;
                    }
                }
            }

            if (var5 == null) {
                var12 = !var7;
            } else {
                var12 = var6;
            }
        } while(var12 || var8 == null);

        if (var8.o != null) {
            return var8.o.b();
        } else {
            return "{0}";
        }
    }

    private static boolean a(OrderableUnit var0, class_391 var1, float var2, float var3) {
        e.a = var2 + var1.g;
        e.b = var3 + var1.h;
        e.c = var1;
        e.d = 0;
        GameEngine var4 = GameEngine.getGameEngine();
        var4.cc.a(e.a, e.b, var1.e, var0, 0.0F, e);
        return e.d >= var1.k && e.d <= var1.l;
    }
}
