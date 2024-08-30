package com.corrodinggames.rts.gameFramework.utility;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.utility.a.class_668;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.utility.ae
public strictfp class class_670 {
    static Object a = new Object();
    static class_669 b = new class_669();
    static class_667 c;

    public static boolean a() {
        return GameEngine.at();
    }

    public static class_667 a(String var0) {
        if (class_669.i(var0)) {
            return b;
        } else if (a() && class_668.l(var0)) {
            if (c == null) {
                synchronized(a) {
                    if (c == null) {
                        c = new class_668();
                    }
                }
            }

            return c;
        } else {
            return null;
        }
    }

    public static class_667 b(String var0) {
        if (a() && class_668.l(var0)) {
            if (c == null) {
                synchronized(a) {
                    if (c == null) {
                        c = new class_668();
                    }
                }
            }

            return c;
        } else {
            return null;
        }
    }

    public static void c(String var0) {
        if (b != null && class_669.i(var0)) {
            b.k(var0);
        }

    }

    public static void b() {
        if (b != null) {
            b.a();
        }

        if (c != null) {
            c.a();
        }

    }
}
