package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope$CachedWriter;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import com.corrodinggames.rts.gameFramework.utility.UnitConfig;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.as
public strictfp class class_398 implements Cloneable {
    public boolean a;
    public float b;
    public int c;
    public float d;
    public float e = 1.0F;
    public float f = 1.0F;
    public int g;
    public float h;
    public float i;
    public float j;
    public float k;
    public float l;
    public boolean m;
    public int n;
    public int o;
    public float p;
    public float q;
    public float r;
    static LinkedHashMap s = new LinkedHashMap();
    static LinkedHashMap t;

    public class_398(boolean var1) {
        this.a = var1;
    }

    public static VariableScope$CachedWriter a(String var0, class_591 var1, String var2, String var3) {
        try {
            return VariableScope$CachedWriter.create(var0, new class_58(var1));
        } catch (Exception var5) {
            throw new RuntimeException("[" + var2 + "]" + var3 + ": " + var5.getMessage(), var5);
        }
    }

    public class_398 a() {
        try {
            class_398 var1 = (class_398)super.clone();
            var1.a = false;
            return var1;
        } catch (CloneNotSupportedException var2) {
            throw new RuntimeException(var2);
        }
    }

    static void a(LinkedHashMap var0, class_399 var1) {
        var0.put(var1.b, var1);
    }

    public class_398 b() {
        class_398 var1 = this.a();
        var1.a = false;
        return var1;
    }

    public static class_399 a(int var0) {
        Iterator var1 = s.values().iterator();

        class_399 var2;
        do {
            if (!var1.hasNext()) {
                return null;
            }

            var2 = (class_399)var1.next();
        } while(var0 != var2.a);

        return var2;
    }

    public static void a(class_113 var0, class_398 var1, class_399[] var2) {
        class_399[] var3 = var2;
        int var4 = var2.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            class_399 var6 = var3[var5];
            double var7 = var6.a(var0, var0.y);
            double var9 = var6.a(var0, var1);
            if (var7 != var9) {
                var0.dJ();
                var6.a(var0, var9);
            }
        }

    }

    public static void a(class_113 var0, class_398 var1, class_591 var2) {
        boolean var3 = true;
        boolean var4 = var1 != var2.cL;
        if (var4) {
            Iterator var5 = t.keySet().iterator();

            while(var5.hasNext()) {
                String var6 = (String)var5.next();
                class_399 var7 = (class_399)t.get(var6);
                double var8 = var7.a(var0, var2.cL);
                double var10 = var7.a(var0, var1);
                if (var8 != var10) {
                    var0.dJ();
                    var7.a(var0, var10);
                }
            }

        }
    }

    @SneakyThrows
    public static void a(class_398 var0, class_113 var1, GameOutputStream var2) {
        class_591 var3 = var1.x;
        boolean var4 = var0 != var3.cL;
        if (!var4) {
            var2.writeBoolean(true);
        } else {
            var2.writeBoolean(false);
            short var5 = 0;
            Iterator var6 = t.keySet().iterator();

            while(var6.hasNext()) {
                String var7 = (String)var6.next();
                class_399 var8 = (class_399)t.get(var7);
                double var9 = var8.a(var1, var3.cL);
                double var11 = var8.a(var1, var0);
                if (var9 != var11) {
                    ++var5;
                }
            }

            var2.a(var5);
            int var14 = 0;
            Iterator var15 = t.keySet().iterator();

            while(var15.hasNext()) {
                String var16 = (String)var15.next();
                class_399 var17 = (class_399)t.get(var16);
                double var10 = var17.a(var1, var3.cL);
                double var12 = var17.a(var1, var0);
                if (var10 != var12) {
                    ++var14;
                    if (var5 < var14) {
                        throw new IOException("numberOfChangedFields>fieldsWritten: " + var5 + ">" + var14);
                    }

                    var2.a((short)var17.a);
                    var2.writeDouble(var12);
                    var2.writeDouble(var10);
                }
            }
        }

    }

    @SneakyThrows
    public static void a(class_113 var0, GameInputStream var1, int var2) {
        class_591 var3 = var0.x;
        boolean var4 = var1.readBoolean();
        if (!var4) {
            short var5 = var1.readShort();

            for(int var6 = 0; var6 < var5; ++var6) {
                short var7 = var1.readShort();
                double var8 = var1.readDouble();
                double var10 = var1.readDouble();
                class_399 var12 = a(var7);
                if (var12 == null) {
                    throw new IOException("Field " + var7 + " doesn't exist");
                }

                var0.dJ();
                var12.a(var0, var8);
            }

        }
    }

    public static class_399[] a(UnitConfig var0, String var1, String var2, class_399[] var3) {
        String var4 = var0.getValueAsStaticString(var1, var2, (String)null);

        try {
            return a(var4, var3);
        } catch (RuntimeException var6) {
            throw new RuntimeException("[" + var1 + "]" + var2 + ": " + var6.getMessage(), var6);
        }
    }

    public static class_399[] a(String var0, class_399[] var1) {
        if (var0 == null) {
            return var1;
        } else {
            ArrayList var2 = new ArrayList();
            String[] var3 = class_340.c(var0, ',');
            int var4 = var3.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                String var6 = var3[var5];
                var6 = var6.trim();
                var6 = var6.toLowerCase(Locale.ROOT);
                class_399 var7 = (class_399)t.get(var6);
                if (var2.contains(var7)) {
                    throw new RuntimeException("Value: " + var6 + " is repeated");
                }

                if (var7 == null) {
                    String var8 = "";

                    String var10;
                    for(Iterator var9 = t.keySet().iterator(); var9.hasNext(); var8 = var8 + var10) {
                        var10 = (String)var9.next();
                        if (!var8.equals("")) {
                            var8 = var8 + ", ";
                        }
                    }

                    throw new RuntimeException("Unknown value: " + var6 + " (Expected: " + class_340.b(var8, (int)100) + ")");
                }

                var2.add(var7);
            }

            return (class_399[])var2.toArray(new class_399[0]);
        }
    }

    // $FF: synthetic method
    public Object clone() {
        return this.a();
    }

    static {
        a((LinkedHashMap)s, (class_399)(new class_405(s.size(), "mass")));
        a((LinkedHashMap)s, (class_399)(new class_419(s.size(), "maxenergy")));
        a((LinkedHashMap)s, (class_399)(new class_403(s.size(), "energy")));
        a((LinkedHashMap)s, (class_399)(new class_417(s.size(), "maxhp")));
        a((LinkedHashMap)s, (class_399)(new class_402(s.size(), "hp")));
        a((LinkedHashMap)s, (class_399)(new class_416(s.size(), "maxshield")));
        a((LinkedHashMap)s, (class_399)(new class_401(s.size(), "shield")));
        a((LinkedHashMap)s, (class_399)(new class_415(s.size(), "shieldregen")));
        a((LinkedHashMap)s, (class_399)(new class_414(s.size(), "armour")));
        a((LinkedHashMap)s, (class_399)(new class_408(s.size(), "maxattackrange")));
        a((LinkedHashMap)s, (class_399)(new class_409(s.size(), "shootdelaymultiplier")));
        a((LinkedHashMap)s, (class_399)(new class_406(s.size(), "shootdamagemultiplier")));
        a((LinkedHashMap)s, (class_399)(new class_407(s.size(), "movespeed")));
        a((LinkedHashMap)s, (class_399)(new class_412(s.size(), "maxturnspeed")));
        a((LinkedHashMap)s, (class_399)(new class_413(s.size(), "fogofwarsightrange")));
        a((LinkedHashMap)s, (class_399)(new class_410(s.size(), "nanorange")));
        a((LinkedHashMap)s, (class_399)(new class_411(s.size(), "selfregenrate")));
        a((LinkedHashMap)s, (class_399)(new class_420(s.size(), "targetHeight")));
        a((LinkedHashMap)s, (class_399)(new class_418(s.size(), "nanoFactorySpeed")));
        t = new LinkedHashMap();
        Iterator var0 = s.keySet().iterator();

        while(var0.hasNext()) {
            String var1 = (String)var0.next();
            if (!var1.equals(var1.toLowerCase(Locale.ROOT))) {
                throw new RuntimeException(var1);
            }

            class_399 var2 = (class_399)s.get(var1);
            if (!var2.b()) {
                t.put(var1, var2);
            }
        }

    }
}
