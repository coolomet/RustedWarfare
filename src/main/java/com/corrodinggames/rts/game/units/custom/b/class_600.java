package com.corrodinggames.rts.game.units.custom.b;

import com.corrodinggames.rts.game.units.custom.class_113;
import com.corrodinggames.rts.game.units.custom.CustomException;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.custom.class_599;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import lombok.SneakyThrows;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.b.g
public strictfp class class_600 extends class_599 {
    String a;
    class_684 b = new class_684();

    public class_600(String var1) {
        this.a = var1;
    }

    @SneakyThrows
    public strictfp void a(class_591 var1) {
        if (this.a != null) {
            String[] var2 = this.a.split(",");
            String[] var3 = var2;
            int var4 = var2.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                String var6 = var3[var5];
                var6 = var6.trim();
                class_930 var7 = class_828.b(var1, var6);
                if (var7 == null) {
                    throw new CustomException("Failed to find decal: " + var6);
                }

                this.b.add(var7);
            }

            this.a = null;
        }

    }

    public strictfp void a(class_113 var1, float var2, float var3) {
        class_828.i.setSite(var2, var3);
        class_828.a(var1, 0.0F, LayerType.inactive, this.b, class_828.i);
    }
}
