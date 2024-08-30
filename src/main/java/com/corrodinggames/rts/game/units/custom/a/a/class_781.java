package com.corrodinggames.rts.game.units.custom.a.a;

import android.graphics.PointF;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.custom.class_113;
import com.corrodinggames.rts.game.units.custom.class_586;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.custom.class_592;
import com.corrodinggames.rts.game.units.custom.a.class_1037;
import com.corrodinggames.rts.game.units.custom.a.class_776;
import com.corrodinggames.rts.gameFramework.utility.UnitConfig;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.a.a.d
public strictfp class class_781 extends class_776 {
    boolean a;
    boolean b;
    class_592 c;
    class_592 d;
    boolean e;
    int f = Integer.MIN_VALUE;
    int g = Integer.MIN_VALUE;

    public static void a(class_591 var0, UnitConfig var1, String var2, String var3, class_1037 var4, String var5, boolean var6) {
        boolean var7 = var1.getValueAsBoolean(var2, var3 + "finishPlayingLastAnimation", false);
        boolean var8 = var1.getValueAsBoolean(var2, var3 + "stopLastAnimation", false);
        class_592 var9 = var0.a((String)var1.getValueAsStaticString(var2, var3 + "playAnimation", (String)null), (class_592)null);
        class_592 var10 = var0.a((String)var1.getValueAsStaticString(var2, var3 + "playAnimationIfNotPlaying", (String)null), (class_592)null);
        if (var9 != null && var10 != null) {
            throw new RuntimeException("Cannot use playAnimation and playAnimationIfNotPlaying at same time");
        } else if (var8 && var7) {
            throw new RuntimeException("Cannot use stopLastAnimation and finishPlayingLastAnimation at same time");
        } else {
            if (var9 != null || var10 != null || var7 || var8) {
                class_781 var11 = new class_781();
                var11.a = var7;
                var11.b = var8;
                var11.c = var9;
                var11.d = var10;
                var11.e = var1.getValueAsBoolean(var2, var3 + "playAnimation_lowPriority", false);
                var4.ac.add(var11);
            }

        }
    }

    public boolean a(class_113 var1, class_226 var2, PointF var3, Unit var4, int var5) {
        if (this.a) {
            var1.b.b();
        }

        if (this.b) {
            var1.b.a();
        }

        byte var6;
        if (this.c != null) {
            var6 = 15;
            if (this.e) {
                var6 = 4;
            }

            var1.b.a(this.c.b(), var6, true);
        }

        if (this.d != null) {
            var6 = 15;
            if (this.e) {
                var6 = 4;
            }

            class_586 var7 = this.d.b();
            if (!var1.b.a(var7)) {
                var1.b.a(this.d.b(), var6, true);
            }
        }

        return true;
    }
}
