package com.corrodinggames.rts.gameFramework.utility;

import com.corrodinggames.rts.gameFramework.GameEngine;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

public strictfp class SlickToAndroidKeycodes {
    static HashMap a;
    static HashMap b;
    static HashMap c;
    static HashMap d = a(SlickToAndroidKeycodes$SlickCodes.class);
    static HashMap e = a(SlickToAndroidKeycodes$AndroidCodes.class);
    static HashMap f = a(SlickToAndroidKeycodes$GdxCodes.class);
    static HashMap g;

    static HashMap a(Class var0) {
        HashMap var1 = new HashMap();
        Field[] var2 = var0.getFields();
        Field[] var3 = var2;
        int var4 = var2.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            Field var6 = var3[var5];
            String var7 = var6.getName();
            var7 = var7.replace("KEYCODE_", "");
            var7 = var7.replace("KEY_", "");
            var7 = var7.replace("NUMPAD_", "NUMPAD");
            var7 = var7.replace("NUM_", "NUMPAD");

            int var8;
            try {
                var8 = var6.getInt((Object)null);
            } catch (IllegalArgumentException var10) {
                throw new RuntimeException(var10);
            } catch (IllegalAccessException var11) {
                throw new RuntimeException(var11);
            }

            var1.put(var7, var8);
        }

        return var1;
    }

    public static void a() {
        a = a("slickToAndroidCodes", d, e);
        g = new HashMap();
        ArrayList var0 = new ArrayList();
        Iterator var1 = d.keySet().iterator();

        while(var1.hasNext()) {
            String var2 = (String)var1.next();
            int var3 = (Integer)d.get(var2);
            Integer var4 = (Integer)e.get(var2);
            if (var4 == null) {
                var0.add(var2);
            }

            if (a.get(var3) == null) {
            }

            String var5 = var2.toLowerCase(Locale.ENGLISH);
            if (var4 != null) {
                g.put(var4, var5);
            }
        }

    }

    public static void b() {
        b = a("gdxToAndroidCodes", f, e);
    }

    public static void c() {
        c = a("gdxToSlickCodes", f, d);
    }

    public static HashMap a(String var0, HashMap var1, HashMap var2) {
        HashMap var3 = new HashMap();
        ArrayList var4 = new ArrayList();
        Iterator var5 = var1.keySet().iterator();

        while(var5.hasNext()) {
            String var6 = (String)var5.next();
            int var7 = (Integer)var1.get(var6);
            Integer var8 = (Integer)var2.get(var6);
            if (var8 == null) {
                var4.add(var6);
            }

            if (var3.get(var7) == null) {
                var3.put(var7, var8);
            }

            String var9 = var6.toLowerCase(Locale.ENGLISH);
            if (var8 != null) {
            }
        }

        if (var4.size() != 0) {
            String var10 = "";
            Iterator var11 = var4.iterator();

            while(var11.hasNext()) {
                String var12 = (String)var11.next();
                int var13 = (Integer)var1.get(var12);
                if (var3.get(var13) == null) {
                    var10 = var10 + var12 + ", ";
                }
            }

            GameEngine.log(var0 + ": Could not find keycode for: " + var10);
        }

        return var3;
    }

    @SneakyThrows
    public static int a(String var0) {
        var0 = var0.toUpperCase();
        Integer var1 = (Integer)e.get(var0);
        if (var1 == null) {
            throw new SlickToAndroidKeycodes$MissingKey("Could not find key:" + var0);
        } else {
            return var1;
        }
    }

    public static String a(int var0) {
        String var1 = (String)g.get(var0);
        return var1 == null ? "unknown" : var1;
    }

    public static int b(int var0) {
        Integer var1 = (Integer)a.get(var0);
        return var1 == null ? 0 : var1;
    }

    public static Integer c(int var0) {
        Object var1 = null;
        if (var0 == 14) {
            return 69;
        } else if (var0 == 211) {
            return 99;
        } else if (var0 == 28) {
            return 72;
        } else if (var0 == 203) {
            return 90;
        } else if (var0 == 205) {
            return 92;
        } else if (var0 == 200) {
            return 91;
        } else if (var0 == 208) {
            return 93;
        } else if (var0 == 15) {
            return 70;
        } else if (var0 == 42) {
            return 138;
        } else if (var0 == 54) {
            return 139;
        } else if (var0 == 29) {
            return 140;
        } else {
            return var0 == 157 ? 141 : null;
        }
    }

    static {
        a();
        b();
        c();
    }
}
