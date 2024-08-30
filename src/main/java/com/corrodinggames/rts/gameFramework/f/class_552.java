package com.corrodinggames.rts.gameFramework.f;

import android.graphics.Point;
import com.corrodinggames.rts.game.maps.class_482;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.buildings.class_88;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.f.j
public strictfp class class_552 {
    static Point a = new Point();

    public static Point a(int var0, int var1, int var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        int var4 = var2;
        var3.bL.a((float)var0, (float)var1);
        int var5 = var3.bL.T;
        int var6 = var3.bL.U;
        Point var7 = null;
        float var8 = -1.0F;

        for(int var9 = var5 - var2; var9 <= var5 + var4; ++var9) {
            for(int var10 = var6 - var4; var10 <= var6 + var4; ++var10) {
                if (var3.bL.c(var9, var10)) {
                    class_482 var11 = var3.bL.e(var9, var10);
                    if (var11 != null && var11.i) {
                        Unit var12 = class_88.b(var9, var10);
                        if (var12 != null && !var12.cf()) {
                            var12 = null;
                        }

                        if (var12 == null) {
                            float var13 = class_340.a((float)var5, (float)var6, (float)var9, (float)var10);
                            if (var8 == -1.0F || var8 > var13) {
                                var3.bL.a(var9, var10);
                                a.a(var3.bL.T, var3.bL.U);
                                var7 = a;
                                var8 = var13;
                            }
                        }
                    }
                }
            }
        }

        return var7;
    }
}
