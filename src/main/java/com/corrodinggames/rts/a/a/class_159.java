package com.corrodinggames.rts.a.a;

import com.corrodinggames.rts.debug.test.AbstractScriptTest;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.Unit;
import com.corrodinggames.rts.gameFramework.class_340;

// $FF: renamed from: com.corrodinggames.rts.a.a.d
public strictfp class class_159 extends AbstractScriptTest {
    int a;

    public void a() {
        GameEngine.log("Running unit tests - maths (v3)");
        class_340.i(100.0F, 100.0F);
        class_340.i(0.0F, 100.0F);
        class_340.i(100.0F, 0.0F);
        class_340.i(0.0F, -100.0F);
        class_340.i(-100.0F, 0.0F);
        class_340.i(0.0F, 0.0F);
        GameEngine.log("fast_atan2 - NaN");
        class_340.i(Float.NaN, 0.0F);
        class_340.i(0.0F, Float.NaN);
        class_340.i(Float.NaN, Float.NaN);
        GameEngine.log("fast_atan2 - Max");
        class_340.i(Float.MAX_VALUE, 0.0F);
        class_340.i(Float.MIN_VALUE, 0.0F);
        class_340.i(0.0F, Float.MAX_VALUE);
        class_340.i(0.0F, Float.MIN_VALUE);
        GameEngine.log("fast_atan2 - NaN+Max");
        class_340.i(Float.MAX_VALUE, Float.NaN);
        class_340.i(Float.MIN_VALUE, Float.MAX_VALUE);
        class_340.i(Float.MAX_VALUE, Float.MIN_VALUE);
        class_340.i(900000.0F, 900000.0F);
        class_340.i(3.4028236E33F, 3.4028236E33F);
        class_340.i(3.4028236E34F, 3.4028236E34F);
        class_340.i(3.4028234E35F, 3.4028234E35F);
        class_340.i(3.4028236E36F, 3.4028236E36F);
        class_340.i(3.4028235E37F, 3.4028235E37F);
        class_340.i(Float.MAX_VALUE, Float.MAX_VALUE);
        GameEngine.log("fast_atan2 - max,max");
        class_340.i(Float.MAX_VALUE, Float.MAX_VALUE);
        class_340.i(Float.MIN_VALUE, Float.MIN_VALUE);
        GameEngine.log("cos/sin");
        class_650.a(class_340.k(0.0F), 1.0F);
        class_650.a(class_340.k(360.0F), 1.0F);
        class_650.a(class_340.k(10800.0F), 1.0F);
        class_650.a(class_340.k(45.0F), 0.70710677F);
        class_650.a(class_340.k(90.0F), 0.0F);
        class_650.a(class_340.k(450.0F), 0.0F);
        class_650.a(class_340.k(10890.0F), 0.0F);
        class_650.a(class_340.j(0.0F), 0.0F);
        class_650.a(class_340.j(90.0F), 1.0F);
        class_340.k(-999999.0F);
        class_340.k(999999.0F);
        class_340.k(Float.MAX_VALUE);
        class_340.k(Float.MIN_VALUE);
        class_340.j(Float.MAX_VALUE);
        class_340.j(Float.MIN_VALUE);
        GameEngine.log("diff sin(0):  " + String.format("%.12f", class_340.j(0.0F) - (float)StrictMath.sin(0.0)));
        GameEngine.log("diff sin(45): " + String.format("%.12f", class_340.j(45.0F) - (float)StrictMath.sin(0.7853981633974483)));
        GameEngine.log("diff sin(90): " + String.format("%.12f", class_340.j(90.0F) - (float)StrictMath.sin(1.5707963267948966)));
        GameEngine.log("diff sin(180):" + String.format("%.12f", class_340.j(180.0F) - (float)StrictMath.sin(Math.PI)));
        GameEngine.log("diff sin(360):" + String.format("%.12f", class_340.j(360.0F) - (float)StrictMath.sin(6.283185307179586)));
        GameEngine.log("Testing squareroot");

        for(int var1 = 0; var1 < 1005; ++var1) {
            class_650.a((float)class_340.a(var1), class_340.d(class_340.a((float)var1)));
        }

        byte var7 = 5;
        int var2 = 0;
        GameEngine.log("=== cos/sin tests (runs:" + var7 + ")");
        Long var3 = Unit.loadAllUnitsTook();

        for(int var4 = 0; var4 < var7; ++var4) {
            for(int var5 = 0; var5 < 2000; ++var5) {
                if (class_340.k((float)var5) == 0.0F) {
                    ++var2;
                }

                if (class_340.j((float)var5) == 0.0F) {
                    ++var2;
                }
            }
        }

        Long var8 = Unit.loadAllUnitsTook();
        double var9 = Unit.a(var3, var8);
        this.a += var2;
        GameEngine.log("Took: " + var9);
    }
}
