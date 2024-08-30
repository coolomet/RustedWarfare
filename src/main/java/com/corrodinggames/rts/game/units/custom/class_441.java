package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader;
import com.corrodinggames.rts.gameFramework.h.class_1009;
import java.util.ArrayList;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.aj
public strictfp class class_441 {
    public static final class_441 a = a("");
    public class_421[] b;
    public class_389[] c;
    public String d;
    public int e = -1;
    public String f;
    public String g;
    class_591 h;

    public static class_441 a(String var0) {
        class_441 var1 = new class_441();
        ArrayList var2 = new ArrayList();
        class_389 var3 = new class_389();
        var3.a = null;
        var3.b = var0;
        var2.add(var3);
        var1.c = (class_389[])var2.toArray(new class_389[0]);
        var1.a();
        return var1;
    }

    public static class_441 a(class_388 var0) {
        if (var0 == null) {
            return null;
        } else {
            class_441 var1 = new class_441();
            var1.h = class_591.b;
            var1.c = var0.b;
            var1.f = var0.e;
            if (var1.c != null) {
                class_389[] var2 = var1.c;
                int var3 = var2.length;

                for(int var4 = 0; var4 < var3; ++var4) {
                    class_389 var5 = var2[var4];
                    if (var5.b != null && var5.b.contains("%{")) {
                    }
                }
            }

            var1.c();
            return var1;
        }
    }

    public class_441() {
    }

    public class_441(class_591 var1, class_388 var2) {
        this.h = var1;
        this.c = var2.b;
        this.f = var2.e;
        if (this.c != null) {
            class_389[] var3 = this.c;
            int var4 = var3.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                class_389 var6 = var3[var5];
                if (var6.b != null && var6.b.contains("%{")) {
                    this.a(var6.b, true);
                }
            }
        }

        this.a();
    }

    public void a() {
        this.a(true);
    }

    public void a(boolean var1) {
        this.c();
        if (this.d != null && this.d.contains("%{")) {
            this.b = this.a(this.d, var1);
        } else {
            this.b = null;
        }

    }

    public class_421[] a(String var1, boolean var2) {
        ArrayList var3 = new ArrayList();
        int var4 = 0;
        boolean var5 = false;

        while(true) {
            int var6;
            String var7;
            if (!var5) {
                var6 = var1.indexOf("%{", var4);
                if (var6 == -1) {
                    var7 = var1.substring(var4, var1.length());
                    if (!var7.equals("")) {
                        var3.add(new class_422(var7));
                    }
                    break;
                }

                var7 = var1.substring(var4, var6);
                if (!var7.equals("")) {
                    var3.add(new class_422(var7));
                }

                var5 = true;
                var4 = var6 + 2;
            } else {
                var6 = var1.indexOf("}", var4);
                if (var6 == -1) {
                    var3.add(new class_422("< %{ NOT CLOSED >"));
                    break;
                }

                var7 = var1.substring(var4, var6);

                try {
                    LogicBoolean var8 = LogicBooleanLoader.parseBooleanBlock(this.h, var7, false);
                    var3.add(class_423.a(var8));
                } catch (RuntimeException var10) {
                    String var9 = "Error: " + var10.getMessage() + ", [parsing: '" + var7 + "']";
                    this.g = var9;
                    var3.add(new class_422("Error:< " + var9 + " >"));
                    if (var2) {
                        throw var10;
                    }
                }

                var4 = var6 + 1;
                var5 = false;
            }
        }

        return (class_421[])var3.toArray(new class_421[0]);
    }

    public String a(Unit var1) {
        if (!(var1 instanceof OrderableUnit)) {
            return "<No unit>:" + this.d;
        } else {
            OrderableUnit var2 = (OrderableUnit)var1;
            StringBuffer var3 = new StringBuffer();
            class_421[] var4 = this.b;
            int var5 = var4.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                class_421 var7 = var4[var6];
                var3.append(var7.a(var2));
            }

            return var3.toString();
        }
    }

    public String b(Unit var1) {
        if (this.e == class_1009.c) {
            return this.b != null ? this.a(var1) : this.d;
        } else {
            this.a(false);
            return this.b != null ? this.a(var1) : this.d;
        }
    }

    public String b() {
        if (this.e == class_1009.c) {
            return this.d;
        } else {
            this.a(false);
            return this.d;
        }
    }

    public void c() {
        if (this.f != null) {
            this.e = class_1009.c;
            this.d = class_1009.a(this.f);
        } else {
            String var1 = class_1009.c();
            class_389[] var2 = this.c;
            int var3 = var2.length;

            int var4;
            class_389 var5;
            for(var4 = 0; var4 < var3; ++var4) {
                var5 = var2[var4];
                if (var1.equals(var5.a)) {
                    this.e = class_1009.c;
                    this.d = var5.b;
                    return;
                }
            }

            var2 = this.c;
            var3 = var2.length;

            for(var4 = 0; var4 < var3; ++var4) {
                var5 = var2[var4];
                if (var5.a == null) {
                    this.e = class_1009.c;
                    this.d = var5.b;
                    return;
                }
            }

            this.e = class_1009.c;
            this.d = "<NO DEFAULT TEXT FOUND>";
        }
    }
}
