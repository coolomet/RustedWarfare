package com.corrodinggames.rts.gameFramework.f;

import android.graphics.Paint;
import android.graphics.Rect;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.f.aj
public strictfp class class_499 {
    class_684 a;
    Rect b;
    Paint c;
    Paint d;

    public void a(float var1, float var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        int var4 = 0;
        int var5 = class_550.a(this.c);

        for(Iterator var6 = this.a.iterator(); var6.hasNext(); ++var4) {
            class_500 var7 = (class_500)var6.next();
            int var8 = 0;
            class_508 var9 = null;
            Iterator var10 = var7.a.iterator();

            while(var10.hasNext()) {
                class_508 var11 = (class_508)var10.next();
                if (var9 != null) {
                    var8 += var9.a(this.c);
                }

                int var12 = (int)(var1 + (float)var8 + (float)this.b.d());
                var12 -= var7.b / 2;
                int var13 = (int)(var2 + (float)this.b.b + (float)(var5 / 2) + (float)(var4 * var5));
                if (!(var11 instanceof class_510)) {
                    if (var11 instanceof class_509) {
                        class_509 var14 = (class_509)var11;
                        TeamImageCache var15 = var14.a;
                        var3.bO.a(var15, (float)var12, (float)var13 - (float)var15.q * var14.b, class_523.c, 0.0F, var14.b);
                    }

                    var9 = var11;
                } else {
                    class_510 var16 = (class_510)var11;
                    Paint var17 = var16.b(this.c);
                    var3.bO.a(var16.d, (float)var12, (float)var13, var17);
                    var9 = var11;
                }
            }
        }

    }
}
