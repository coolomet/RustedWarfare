package com.corrodinggames.rts.game.units;

import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import com.corrodinggames.rts.game.maps.class_484;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.k.PathEngine;
import com.corrodinggames.rts.gameFramework.k.class_223;

// $FF: renamed from: com.corrodinggames.rts.game.units.aq
public final strictfp class class_1050 {
    public static final Paint a = new Paint();
    static final Point b = new Point();
    static final Rect c = new Rect();
    static final PointF d = new PointF();
    static final PointF e = new PointF();
    static final PointF f = new PointF();
    static final PointF g = new PointF();
    static final PointF h = new PointF();
    static final PointF i = new PointF();
    static final PointF j = new PointF();

    private static strictfp Point a(MovementType var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
        GameEngine var8 = GameEngine.getGameEngine();
        PathEngine var9 = var8.bU;
        class_223 var10 = var9.a(var0);
        int var11 = class_340.d(var3 - var1);
        int var12 = class_340.d(var4 - var2);
        int var13 = var1;
        int var14 = var2;
        int var15 = 1 + var11 + var12;
        int var16 = var3 > var1 ? 1 : -1;
        int var17 = var4 > var2 ? 1 : -1;
        int var18 = var11 - var12;
        var11 *= 2;
        var12 *= 2;

        for(int var19 = 0; var15 > 0; --var15) {
            int var22;
            if (var6 != 0) {
                var22 = var9.c(var10, var13, var14);
                if (var22 < var6) {
                    b.a(var13, var14);
                    return b;
                }
            }

            if (var5 != 0) {
                var22 = var9.b(var10, var13, var14);
                if (var22 == -1) {
                    b.a(var13, var14);
                    return b;
                }

                if (var7 > 0) {
                    --var7;
                } else {
                    var19 += var22;
                }

                if (var19 >= var5) {
                    b.a(var13, var14);
                    return b;
                }
            } else if (var9.a(var10, var13, var14)) {
                b.a(var13, var14);
                return b;
            }

            if (var18 > 0) {
                var13 += var16;
                var18 -= var12;
            } else if (var18 < 0) {
                var14 += var17;
                var18 += var11;
            } else if (var18 == 0) {
                var13 += var16;
                var14 += var17;
                var18 -= var12;
                var18 += var11;
                --var15;
            }
        }

        return null;
    }

    public static strictfp boolean a(MovementType var0, float var1, float var2, float var3, float var4, int var5, int var6, int var7) {
        GameEngine var8 = GameEngine.getGameEngine();
        boolean var9 = true;
        class_223 var10 = var8.bU.a(var0);
        var8.bU.a(var10, true);
        return b(var0, var1, var2, var3, var4, var5, var6, var7);
    }

    public static strictfp boolean b(MovementType var0, float var1, float var2, float var3, float var4, int var5, int var6, int var7) {
        GameEngine var8 = GameEngine.getGameEngine();
        class_484 var9 = var8.bL;
        var9.a(var1, var2);
        int var10 = var9.T;
        int var11 = var9.U;
        var9.a(var3, var4);
        int var12 = var9.T;
        int var13 = var9.U;
        Point var14 = a(var0, var10, var11, var12, var13, var5, var6, var7);
        return var14 == null;
    }

    public static strictfp PointF a(MovementType var0, float var1, float var2, float var3, float var4, int var5, int var6, boolean var7) {
        GameEngine var8 = GameEngine.getGameEngine();
        PathEngine var9 = var8.bU;
        c.a(var5, var6, var5 + 1, var6 + 1);
        d.setSite(var1, var2);
        e.setSite(var3, var4);
        f.setSite(e);
        byte var10 = -1;
        g.setSite((float)c.a, (float)c.d);
        h.setSite((float)c.c, (float)c.b);
        i.setSite((float)c.a, (float)c.b);
        j.setSite((float)c.c, (float)c.d);
        boolean var11;
        if (d.y < e.y) {
            var11 = var7 || !var9.a(var0, var5, var6 - 1);
            if (var11 && class_340.a(d, e, i, h)) {
                var10 = 3;
            }
        } else {
            var11 = var7 || !var9.a(var0, var5, var6 + 1);
            if (var11 && class_340.a(d, e, g, j)) {
                var10 = 1;
            }
        }

        if (d.x < e.x) {
            var11 = var7 || !var9.a(var0, var5 - 1, var6);
            if (var11 && class_340.a(d, e, i, g)) {
                var10 = 2;
            }
        } else {
            var11 = var7 || !var9.a(var0, var5 + 1, var6);
            if (var11 && class_340.a(d, e, h, j)) {
                var10 = 0;
            }
        }

        if (var10 == -1) {
            return null;
        } else {
            if (var10 == 0) {
                f.x = (float)(var5 + 1) + 0.01F;
            }

            if (var10 == 2) {
                f.x = (float)var5 - 0.01F;
            }

            if (var10 == 1) {
                f.y = (float)(var6 + 1) + 0.01F;
            }

            if (var10 == 3) {
                f.y = (float)var6 - 0.01F;
            }

            return f;
        }
    }

    public static strictfp boolean a(OrderableUnit var0, Unit var1) {
        if (var1.cN != null) {
            return false;
        } else if (!var0.k(var1)) {
            return false;
        } else {
            return var1.d((Unit)var0);
        }
    }

    public static strictfp boolean b(OrderableUnit var0, Unit var1) {
        if (!a(var0, var1)) {
            return false;
        } else if (!var0.h(var1)) {
            return false;
        } else {
            return var0.i(var1);
        }
    }
}
