package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.utility.UnitConfig;
import java.util.ArrayList;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.ba
public strictfp class class_431 {
    int a;
    String b;
    boolean c;
    public float d;
    public float e;
    public float f = 2.0F;
    public float g = 0.0F;
    public boolean h = true;
    public float i;
    public float j;
    public float k;
    public boolean l;
    public float m = 1.0F;
    public boolean n = true;
    public boolean o = false;
    public boolean p;
    public LogicBoolean q;
    public float r = 1.0F;
    public float s = 1.0F;
    public float t = 0.0F;
    public float u = 3.0F;
    public float v = 0.3F;
    public float w;
    public TeamImageCache x;
    public TeamImageCache[] y;
    public boolean z;
    public float A;
    public TeamImageCache B;
    public TeamImageCache[] C;
    public TeamImageCache D;
    public boolean E;
    public boolean F = true;
    public boolean G = true;
    public boolean H;
    public boolean I = true;
    public boolean J = true;
    public float K = 7.0F;
    public int L = 3;
    public boolean M = true;
    public float N = 16.0F;
    public float O = 50.0F;
    public boolean P = false;
    public boolean Q = false;
    public float R = 0.0F;
    public int[] S;
    public float T;

    public void a(class_431 var1) {
        this.d = var1.d;
        this.e = var1.e;
        this.i = var1.i;
        this.j = var1.j;
        this.k = var1.k;
        this.f = var1.f;
        this.g = var1.g;
        this.h = var1.h;
        this.l = var1.l;
        this.m = var1.m;
        this.n = var1.n;
        this.o = var1.o;
        this.t = var1.t;
        this.p = var1.p;
        this.r = var1.r;
        this.s = var1.s;
        this.u = var1.u;
        this.w = var1.w;
        this.x = var1.x;
        this.y = var1.y;
        this.A = var1.A;
        this.z = var1.z;
        this.B = var1.B;
        this.C = var1.C;
        this.D = var1.D;
        this.E = var1.E;
        this.F = var1.F;
        this.G = var1.G;
        this.v = var1.v;
        this.H = var1.H;
        this.I = var1.I;
        this.J = var1.J;
        this.K = var1.K;
        this.L = var1.L;
        this.M = var1.M;
        this.N = var1.N;
        this.O = var1.O;
        this.P = var1.P;
        this.Q = var1.Q;
        this.R = var1.R;
        this.T = var1.T;
    }

    public static void a(class_431 var0, class_591 var1, UnitConfig var2, String var3, boolean var4, ArrayList var5) {
        if (!var4) {
            var0.l = true;
            var0.J = false;
        }

        int var6 = var2.getValueAsIntegerOrDefault(var3, "copyFrom", 0);
        if (var6 != 0) {
            if (var6 - 1 >= var5.size()) {
                throw new RuntimeException("copyFrom: Leg/Arm copy target not loaded yet: " + var6);
            }

            class_431 var7 = (class_431)var5.get(var6 - 1);
            var0.a(var7);
        }

        var0.d = var2.i(var3, "x");
        var0.e = var2.i(var3, "y");
        var0.b = var3.replace("_", "");
        var0.c = var4;
        Float var28 = var2.getValueAsFloatOrDefault(var3, "attach_x", (Float)null);
        if (var28 != null) {
            var0.j = var28;
        }

        Float var8 = var2.getValueAsFloatOrDefault(var3, "attach_y", (Float)null);
        if (var8 != null) {
            var0.k = var8;
        }

        var0.f = var2.getValueAsFloatOrDefault(var3, "liftingHeightOffset", var0.f);
        var0.g = var2.getValueAsFloatOrDefault(var3, "targetHeight", var0.g);
        var0.h = var2.getValueAsBoolean(var3, "targetHeightRelative", var0.h);
        var0.i = var2.getValueAsFloatOrDefault(var3, "endDirOffset", 0.0F);
        var0.l = var2.getValueAsBoolean(var3, "lockMovement", var0.l);
        var0.m = var2.getValueAsFloatOrDefault(var3, "estimatingPositionMultiplier", var0.m);
        var0.q = var2.a(var1, var3, "hidden", var0.q);
        var0.p = var0.q == LogicBoolean.trueBoolean;
        var0.r = var2.getValueAsFloatOrDefault(var3, "alpha", var0.r);
        Float var9 = var2.getValueAsFloatOrDefault(var3, "moveSpeed", (Float)null);
        if (var9 != null) {
            var0.s = var9;
        }

        var0.t = var2.b(var3, "moveWarmUp", var0.t);
        var0.u = var2.getValueAsFloatOrDefault(var3, "rotateSpeed", var0.u);
        Float var10 = var2.getValueAsFloatOrDefault(var3, "resetAngle", (Float)null);
        if (var10 != null) {
            var0.w = var10;
        }

        boolean var11 = var2.getValueAsBoolean(var3, "image_end_teamColors", false);
        TeamImageCache var12 = var1.a(var2, var3, "image_foot");
        if (var12 != null) {
            var0.B = var12;
            if (var11) {
                var0.C = var1.a(var0.B, var1.ac);
            } else {
                var0.C = null;
            }
        }

        TeamImageCache var13 = var1.a(var2, var3, "image_end");
        if (var13 != null) {
            var0.B = var13;
            if (var11) {
                var0.C = var1.a(var0.B, var1.ac);
            } else {
                var0.C = null;
            }
        }

        TeamImageCache var14 = var1.a(var2, var3, "image_foot_shadow");
        if (var14 != null) {
            var0.D = var14;
        }

        TeamImageCache var15 = var1.a(var2, var3, "image_end_shadow");
        if (var15 != null) {
            var0.D = var15;
        }

        TeamImageCache var16 = var1.a(var2, var3, "image_leg");
        if (var16 != null) {
            var0.x = var16;
        }

        TeamImageCache var17 = var1.a(var2, var3, "image_middle");
        if (var17 != null) {
            var0.x = var17;
        }

        boolean var18 = var2.getValueAsBoolean(var3, "image_middle_teamColors", false);
        if (var0.x != null && var18) {
            var0.y = var1.a(var0.x, var1.ac);
        } else {
            var0.y = null;
        }

        Float var19 = var2.getValueAsFloatOrDefault(var3, "heightSpeed", (Float)null);
        if (var19 != null) {
            var0.v = var19;
        }

        Boolean var20 = var2.getValueAsBoolean(var3, "draw_foot_on_top", (Boolean)null);
        if (var20 != null) {
            var0.H = var20;
        }

        Boolean var21 = var2.getValueAsBoolean(var3, "dust_effect", (Boolean)null);
        if (var21 != null) {
            var0.I = var21;
        }

        Boolean var22 = var2.getValueAsBoolean(var3, "drawLegWhenZoomedOut", (Boolean)null);
        if (var22 != null) {
            var0.F = var22;
            var0.E = true;
        }

        Boolean var23 = var2.getValueAsBoolean(var3, "drawFootWhenZoomedOut", (Boolean)null);
        if (var23 != null) {
            var0.G = var23;
            var0.E = true;
        }

        if (!var0.E && !var0.l && !var0.P) {
            if (var1.cW < 30) {
                var0.F = false;
            }

            if (var1.cW < 20) {
                var0.G = false;
            }
        }

        Boolean var24 = var2.getValueAsBoolean(var3, "explodeOnDeath", (Boolean)null);
        if (var24 != null) {
            var0.J = var24;
        }

        Float var25 = var2.getValueAsFloatOrDefault(var3, "holdDisMin", (Float)null);
        if (var25 != null) {
            var0.K = var25;
        }

        var0.L = var2.getValueAsIntegerOrDefault(var3, "holdDisMin_maxMovingLegs", var0.L);
        var0.M = var2.getValueAsBoolean(var3, "hold_moveOnlyIfFurthest", var0.M);
        var0.n = var2.getValueAsBoolean(var3, "holdDisMin_checkNeighbours", var0.n);
        var0.o = var2.getValueAsBoolean(var3, "favourOppositeSideNeighbours", var0.o);
        Float var26 = var2.getValueAsFloatOrDefault(var3, "holdDisMax", (Float)null);
        if (var26 != null) {
            var0.N = var26;
        }

        Float var27 = var2.getValueAsFloatOrDefault(var3, "hardLimit", (Float)null);
        if (var27 != null) {
            var0.O = var27;
        }

        var0.P = var2.getValueAsBoolean(var3, "drawOverBody", var0.P);
        if (var0.P) {
            var1.ay = true;
        }

        var0.Q = var2.getValueAsBoolean(var3, "drawUnderAllUnits", var0.Q);
        if (var0.Q) {
            var1.az = true;
        }

        if (var0.Q && var0.P) {
            throw new RuntimeException("Both drawUnderAllUnits and drawOverBody can not be set true at the same time in leg/arm");
        } else {
            var0.R = var2.getValueAsFloatOrDefault(var3, "drawDirOffset", var0.R);
            var0.T = var2.getValueAsFloatOrDefault(var3, "spinRate", var0.T);
        }
    }
}
