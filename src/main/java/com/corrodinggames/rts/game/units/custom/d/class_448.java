package com.corrodinggames.rts.game.units.custom.d;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.CustomException;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.custom.e.BuiltInResource;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$StaticValueBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.utility.UnitConfig;
import com.corrodinggames.rts.gameFramework.utility.class_675;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.d.c
public strictfp class class_448 extends class_446 {
    public final class_684 a = new class_684();
    boolean b;
    public int c;
    public int d;
    public int e;
    public int f;

    @SneakyThrows
    public static class_448 a(class_591 var0, UnitConfig var1, String var2, String var3, class_448 var4) {
        String var5 = var1.getValueAsStaticString(var2, var3, (String)null);
        if (var5 == null) {
            return var4;
        } else {
            try {
                class_448 var6 = a(var0, var5);
                return var6;
            } catch (RuntimeException var7) {
                var7.printStackTrace();
                throw new CustomException("[" + var2 + "]" + var3 + ": " + var7.getMessage());
            }
        }
    }

    public static class_448 a(class_591 var0, String var1) {
        return a(var0, var1, false);
    }

    @SneakyThrows
    public static class_448 a(class_591 var0, String var1, boolean var2) {
        class_448 var3 = new class_448();
        ArrayList var4 = class_675.a(var1, ",", "|", false);
        Iterator var5 = var4.iterator();

        while(var5.hasNext()) {
            String var6 = (String)var5.next();
            int var7 = class_675.a(var6, "=", ":");
            String var8;
            String var9;
            if (var7 == -1) {
                if (!var2) {
                    throw new CustomException("Unknown price format:" + var1);
                }

                var8 = "credits";
                var9 = var6;
            } else {
                var8 = var6.substring(0, var7).trim();
                var9 = var6.substring(var7 + 1);
            }

            if (var8.equals("hasFlag")) {
                var3.e = class_447.a(var3.e, var9);
            } else if (var8.equals("hasMissingFlag")) {
                var3.f = class_447.a(var3.f, var9);
            } else if (var8.equals("setFlag")) {
                var3.c = class_447.a(var3.c, var9);
            } else if (var8.equals("unsetFlag")) {
                var3.d = class_447.a(var3.d, var9);
            } else {
                BuiltInResource var10 = var0.j(var8);
                if (var10 == null) {
                    throw new CustomException("Could not find resource type:" + var8 + " from [" + var1 + "]");
                }

                LogicBoolean var11 = LogicBooleanLoader.parseNumberBlock(var0, var9);
                if (var11 == null) {
                    throw new CustomException("Value missing for:" + var8 + " from [" + var1 + "]");
                }

                if (!(var11 instanceof LogicBoolean$StaticValueBoolean)) {
                    var3.b = true;
                }

                class_445 var12 = new class_445(var10, var11);
                var3.a.add(var12);
            }
        }

        return var3;
    }

    public boolean b(Unit var1) {
        return this.b(var1, 1.0);
    }

    public boolean b(Unit var1, double var2) {
        if (!(var1 instanceof OrderableUnit)) {
            return false;
        } else {
            OrderableUnit var4 = (OrderableUnit)var1;
            int var5 = this.a.a;
            Object[] var6 = this.a.a();

            for(int var7 = 0; var7 < var5; ++var7) {
                class_445 var8 = (class_445)var6[var7];
                double var9;
                if (var8.c != null) {
                    var9 = (double)var8.c.readNumber(var4) * var2;
                } else {
                    var9 = var8.b * var2;
                }

                if (var9 > 0.0) {
                    double var11 = var8.a.a((Unit)var4);
                    if (var11 < var9) {
                        return false;
                    }
                }
            }

            if (!this.g(var4)) {
                return false;
            } else {
                return true;
            }
        }
    }

    public void d(Unit var1) {
        if (!(var1 instanceof OrderableUnit)) {
            GameEngine.n("DynamicResourcePrice doesn't work on: " + var1.c());
        } else {
            OrderableUnit var2 = (OrderableUnit)var1;
            int var3 = this.a.a;
            Object[] var4 = this.a.a();

            for(int var5 = 0; var5 < var3; ++var5) {
                class_445 var6 = (class_445)var4[var5];
                double var7;
                if (var6.c != null) {
                    var7 = (double)var6.c.readNumber(var2);
                } else {
                    var7 = var6.b;
                }

                var6.a.a(var2, var7);
            }

            this.f(var2);
            class_447.d(var2);
        }
    }

    public void a(Unit var1) {
        this.a(var1, 1.0);
    }

    public void a(Unit var1, double var2) {
        if (!(var1 instanceof OrderableUnit)) {
            GameEngine.n("DynamicResourcePrice doesn't work on: " + var1.c());
        } else {
            OrderableUnit var4 = (OrderableUnit)var1;
            int var5 = this.a.a;
            Object[] var6 = this.a.a();

            for(int var7 = 0; var7 < var5; ++var7) {
                class_445 var8 = (class_445)var6[var7];
                double var9;
                if (var8.c != null) {
                    var9 = (double)var8.c.readNumber(var4);
                } else {
                    var9 = var8.b;
                }

                var8.a.b(var4, -var9 * var2);
            }

            this.f(var4);
            class_447.d(var4);
        }
    }

    public void e(Unit var1) {
        if (!(var1 instanceof OrderableUnit)) {
            GameEngine.n("DynamicResourcePrice doesn't work on: " + var1.c());
        } else {
            OrderableUnit var2 = (OrderableUnit)var1;
            int var3 = this.a.a;
            Object[] var4 = this.a.a();

            for(int var5 = 0; var5 < var3; ++var5) {
                class_445 var6 = (class_445)var4[var5];
                double var7;
                if (var6.c != null) {
                    var7 = (double)var6.c.readNumber(var2);
                } else {
                    var7 = var6.b;
                }

                var6.a.b(var2, var7);
            }

            this.f(var2);
            class_447.d(var2);
        }
    }

    public void f(Unit var1) {
        if (this.d != 0) {
            var1.cF &= ~this.d;
        }

        if (this.c != 0) {
            var1.cF |= this.c;
        }

    }

    public boolean g(Unit var1) {
        if (this.e != 0 && !a(var1.cF, this.e)) {
            return false;
        } else {
            return this.f == 0 || !b(var1.cF, this.f);
        }
    }

    public static boolean a(int var0, int var1) {
        return (var1 & var0) == var1;
    }

    public static boolean b(int var0, int var1) {
        return (var1 & var0) != 0;
    }
}
