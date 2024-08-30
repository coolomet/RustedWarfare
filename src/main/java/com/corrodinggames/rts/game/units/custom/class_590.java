package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.gameFramework.utility.UnitConfig;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.m
public strictfp class class_590 {
    public boolean a;
    public float b;
    public int c;
    public int d;
    public float e;

    public static strictfp class_590 a(class_591 var0, UnitConfig var1, String var2, String var3, boolean var4) {
        class_590 var5 = new class_590();
        var5.a = var1.getValueAsBoolean(var2, var3 + "direction_useMainTurret", false);
        var5.b = var1.getValueAsFloatOrDefault(var2, var3 + "direction_units", 0.0F);
        var5.c = var1.getValueAsIntegerOrDefault(var2, var3 + "direction_strideX", -1);
        var5.d = var1.getValueAsIntegerOrDefault(var2, var3 + "direction_strideY", -1);
        var5.e = var1.getValueAsFloatOrDefault(var2, var3 + "direction_starting", 0.0F);
        return var5.b == 0.0F ? null : var5;
    }
}
