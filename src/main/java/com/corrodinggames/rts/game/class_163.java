package com.corrodinggames.rts.game;

import android.graphics.Color;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.custom.class_164;
import com.corrodinggames.rts.game.units.custom.class_390;
import com.corrodinggames.rts.game.units.custom.class_395;
import com.corrodinggames.rts.game.units.custom.class_588;
import com.corrodinggames.rts.game.units.custom.class_605;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.game.g
public strictfp class class_163 {
    public static final class_163 a = new class_163();
    public int b;
    public int c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public int i = 35;
    public float j = -1.0F;
    public boolean k = false;
    public boolean l = false;
    public boolean m = false;
    public boolean n = false;
    public float o = 1.0F;
    public boolean p = false;
    public boolean q = false;
    public boolean r = false;
    public boolean s = false;
    public boolean t = false;
    public float u;
    public float v;
    public float w = 5.0F;
    public short x = -1;
    public short y;
    public short z = -1;
    public boolean A;
    public TeamImageCache B;
    public TeamImageCache C;
    public float D;
    public float E;
    public float F;
    public float G;
    public float H;
    public boolean I = false;
    public boolean J = false;
    public float K = -1.0F;
    public boolean L = false;
    public boolean M = false;
    public boolean N = false;
    public float O = -1.0F;
    public float P = -1.0F;
    public float Q;
    public float R;
    public float S;
    public boolean T;
    public boolean U = false;
    public boolean V = false;
    public boolean W = false;
    public boolean X = false;
    public TeamImageCache Y;
    public TeamImageCache Z;
    public boolean aa;
    public TeamImageCache ab;
    public boolean ac;
    public float ad;
    public boolean ae = false;
    public boolean af = false;
    public float ag = 3.0F;
    public class_605 ah;
    public class_605 ai;
    public class_390 aj;
    public class_390 ak;
    public class_390 al;
    public float am;
    public float an = 5.0F;
    public int ao = -1;
    public float ap = 0.5F;
    public boolean aq;
    public boolean ar = false;
    public float as = -1.0F;
    public float at = -1.0F;
    public float au = -1.0F;
    public float av = 0.1F;
    public boolean aw = false;
    public float ax = 120.0F;
    public float ay = 15.0F;
    public boolean az;
    public float aA = 5.0F;
    public float aB = 120.0F;
    public float aC = 15.0F;
    public class_588 aD;
    public int aE = Color.a(255, 255, 255, 255);
    public float aF = 1.0F;
    public float aG = 0.0F;
    public float aH = 1.0F;
    public boolean aI;
    public boolean aJ = true;
    public float aK;
    public float aL;
    public float aM;
    public boolean aN;
    public boolean aO;
    public float aP;
    public float aQ;
    public float aR = 1.0F;
    public float aS = 1.0F;
    public float aT = 1.0F;
    public float aU = 1.0F;
    public float aV;
    public float aW = -1.0F;
    public class_605 aX;
    public class_605 aY;
    public class_395 aZ;
    public int ba;
    public boolean bb;
    public boolean bc;
    public class_588 bd;
    public class_684 be = null;
    public class_684 bf = null;
    public class_684 bg = null;

    public class_605 a(Unit var1) {
        class_684 var2 = this.bg;
        if (var2 != null && var2.a > 0) {
            Iterator var3 = var2.iterator();

            while(var3.hasNext()) {
                class_168 var4 = (class_168)var3.next();
                if (var4.a(var1) && var4.g != null) {
                    return var4.g;
                }
            }
        }

        return null;
    }

    public float a(Unit var1, float var2, boolean var3) {
        class_684 var4;
        if (!var3) {
            var4 = this.be;
        } else {
            var4 = this.bf;
        }

        if (var4 != null && var4.a > 0) {
            Iterator var5 = var4.iterator();

            while(var5.hasNext()) {
                class_168 var6 = (class_168)var5.next();
                if (var6.a(var1)) {
                    float var7;
                    if (!var3) {
                        if (var6.e != null) {
                            var6.e.h(var1);
                        }

                        var7 = var6.c;
                    } else {
                        if (var6.f != null) {
                            var6.f.h(var1);
                        }

                        var7 = var6.d;
                    }

                    var2 *= var7;
                }
            }
        }

        return var2;
    }

    public static void a(class_163 var0, GameOutputStream var1) {
        if (var0 == a) {
            var1.writeByte(0);
        } else if (var0 instanceof class_164) {
            var1.writeByte(1);
            class_164.a((class_164)var0, var1);
        } else {
            GameEngine.warn("writeOutLink: Unhandled projectile type");
            var1.writeByte(0);
        }
    }

    @SneakyThrows
    public static class_163 a(GameInputStream var0) {
        byte var1 = var0.readByte();
        if (var1 == 0) {
            return a;
        } else if (var1 == 1) {
            class_163 var2 = class_164.b(var0);
            return var2 == null ? a : var2;
        } else {
            throw new IOException("Unknown projectile type:" + var1);
        }
    }
}
