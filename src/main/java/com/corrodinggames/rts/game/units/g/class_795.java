package com.corrodinggames.rts.game.units.g;

import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import lombok.SneakyThrows;

import java.io.IOException;

// $FF: renamed from: com.corrodinggames.rts.game.units.g.c
public final strictfp class class_795 {
    public static void a(OrderableUnit var0, float var1) {
        class_684 var2 = var0.bp;
        if (var2 != null) {
            GameEngine var3 = GameEngine.getGameEngine();
            int var4 = var3.by;
            Object[] var5 = var2.a();

            for(int var6 = var2.a - 1; var6 >= 0; --var6) {
                class_792 var7 = (class_792)var5[var6];
                if (var7.a <= var4) {
                    var2.remove(var6);
                } else {
                    var7.a(var0, var1);
                }
            }

        }
    }

    public static void a(OrderableUnit var0, class_792 var1) {
        if (var0.bp == null) {
            var0.bp = new class_684();
        }

        if (var0.bp.size() > 1000) {
            var0.a("status effect limit reached");
        } else {
            var0.bp.add(var1);
        }
    }

    public static void a(OrderableUnit var0, GameOutputStream var1) {
        class_684 var3 = var0.bp;
        int var2;
        if (var3 == null) {
            var2 = 0;
        } else {
            var2 = var3.size();
        }

        var1.a((short)var2);
        if (var2 != 0) {
            var1.e("s");
            Object[] var4 = var3.a();

            for(int var5 = 0; var5 < var3.a; ++var5) {
                class_792 var6 = (class_792)var4[var5];
                var1.writeSimilarEnum(var6.b());
                var6.a(var0, var1);
            }

            var1.endBlock("s");
        }
    }

    @SneakyThrows
    public static void a(OrderableUnit var0, GameInputStream var1) {
        short var2 = var1.readShort();
        if (var2 <= 0) {
            var0.bp = null;
        } else {
            if (var0.bp == null) {
                var0.bp = new class_684();
            } else {
                var0.bp.clear();
            }

            class_684 var3 = var0.bp;
            var1.startBlock("s");

            for(int var4 = 0; var4 < var2; ++var4) {
                StatusEffectType var5 = (StatusEffectType)var1.readSimilarEnum(StatusEffectType.class);
                if (var5 == null) {
                    throw new IOException("Unknown status effect type");
                }

                class_792 var6 = var5.a();
                var6.a(var0, var1);
                var3.add(var6);
            }

            var1.endBlock("s");
        }
    }
}
