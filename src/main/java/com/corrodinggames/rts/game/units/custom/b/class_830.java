package com.corrodinggames.rts.game.units.custom.b;

import android.graphics.PointF;
import com.corrodinggames.rts.game.Projectile;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.custom.class_113;
import com.corrodinggames.rts.game.units.custom.class_164;
import com.corrodinggames.rts.game.units.custom.class_397;
import com.corrodinggames.rts.game.units.custom.class_585;
import com.corrodinggames.rts.game.units.custom.class_588;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.buildings.LaserDefence;
import com.corrodinggames.rts.gameFramework.class_340;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.b.k
public strictfp class class_830 extends class_827 {
    public static final class_827 a = new class_830();
    static final PointF b = new PointF();

    public strictfp void b(class_113 var1, float var2) {
        class_591 var3 = var1.x;
        int var4 = var1.bl();

        for(int var5 = 0; var5 < var4; ++var5) {
            class_397 var6 = var3.fQ[var5];
            if (var6.aj != null && var1.cB > 0.0F && !var1.v) {
                float var7 = var6.aj;
                b.setSite(var1.E(var5));
                float var8 = var1.attackRange();
                if (var6.ab < 99999.0F) {
                    var8 = var6.ab;
                }

                if (LaserDefence.a(var1, b.x, b.y, var1.zCord, var8, var7)) {
                }

                if (var1.cB < 0.0F) {
                    var1.cB = 0.0F;
                    var1.v = true;
                }
            }

            if (var6.ak != null) {
                a(var1, var6);
            }
        }

    }

    public static strictfp void a(class_113 var0, class_397 var1) {
        if (var0.a(var1)) {
            float var2 = var1.al;
            float var3 = var1.am;
            float var4 = var1.an;
            Projectile var5 = null;
            class_588 var6 = var1.ak;
            Object[] var7 = Projectile.a.a();
            int var8 = 0;

            for(int var9 = Projectile.a.a; var8 < var9; ++var8) {
                Projectile var10 = (Projectile)var7[var8];
                if (var10.aE != null && var10.zCord > var4 && class_585.a(var10.aE, var6)) {
                    float var11 = class_340.a(var0.xCord, var0.yCord, var10.xCord, var10.yCord);
                    if (var11 < var3 * var3) {
                        float var12 = class_340.a(var0.xCord, var0.yCord, var10.n, var10.o);
                        if ((var12 < var2 * var2 || var2 < 0.0F) && (var10.j == null || !var10.j.bX.d(var0.bX) && var10.j.bX != var0.bX) && !(var10.h <= 0.0F) && !a(var10)) {
                            var5 = var10;
                        }
                    }
                }
            }

            if (var5 != null) {
                var0.b(var1);
                Projectile var13 = var0.a((Unit)null, var5.xCord, var5.yCord, var1.e, (class_164)null, 0);
                var13.aC = true;
                var13.q = var5;
            }

        }
    }

    public static strictfp boolean a(Projectile var0) {
        Object[] var1 = Projectile.a.a();
        int var2 = 0;

        for(int var3 = Projectile.a.a; var2 < var3; ++var2) {
            Projectile var4 = (Projectile)var1[var2];
            if (var4 != var0 && var4.q == var0) {
                return true;
            }
        }

        return false;
    }
}
