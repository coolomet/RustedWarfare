package com.corrodinggames.rts.a.a;

import com.corrodinggames.rts.debug.test.TestFastNodeQueue;
import com.corrodinggames.rts.debug.test.TestMiscPerformance;
import com.corrodinggames.rts.debug.test.TestRegex;
import com.corrodinggames.rts.debug.test.TestUnitReference;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;

// $FF: renamed from: com.corrodinggames.rts.a.a.n
public strictfp class class_650 {
    public void a() {
        GameEngine.log("Running unit tests");
        (new class_158()).a();
        (new class_159()).a();
        (new TestFastNodeQueue()).a();
        (new TestRegex()).a();
        (new class_157()).a();
        (new TestMiscPerformance()).a();
        (new TestUnitReference()).a();
    }

    public static void a(boolean var0) {
        if (!var0) {
            throw new RuntimeException("Asset failed");
        }
    }

    public static void b(boolean var0) {
        if (var0) {
            throw new RuntimeException("Asset failed");
        }
    }

    public static void a(int var0, int var1) {
        if (var0 != var1) {
            throw new RuntimeException("Asset failed (int):" + var0 + "!=" + var1);
        }
    }

    public static void a(float var0, float var1) {
        if (class_340.c(var0 - var1) > 0.001F) {
            throw new RuntimeException("Asset failed (float):" + var0 + "!=" + var1);
        }
    }

    public static void a(String var0, String var1) {
        if (!var0.equals(var1)) {
            throw new RuntimeException("Asset failed:" + var0 + "!=" + var1);
        }
    }

    public static void b(String var0, String var1) {
        GameEngine.log("assertEqualDebug:'" + var0 + "' vs '" + var1 + "'");
        a(var0, var1);
    }

    public static void c(String var0, String var1) {
        Float var2 = Float.parseFloat(var0);
        Float var3 = Float.parseFloat(var1);
        a(var2, var3);
    }

    public static void a(Object var0, Object var1) {
        if (var0 != var1) {
            throw new RuntimeException("Asset failed:" + var0 + "!=" + var1);
        }
    }
}
