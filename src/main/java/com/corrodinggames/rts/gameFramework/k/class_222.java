package com.corrodinggames.rts.gameFramework.k;

import android.graphics.Point;
import com.corrodinggames.rts.game.maps.class_484;
import com.corrodinggames.rts.game.units.class_1045;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.gameFramework.GameEngine;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.k.h
public strictfp class class_222 extends class_221 {
    class_225 a;
    class_1045 b = new class_1045();
    static Point c = new Point();

    public class_222(class_225 var1) {
        this.a = var1;
    }

    public class_1045 a(Unit var1) {
        class_1045 var2 = this.a(var1.xCord, var1.yCord);
        if (var2 == null) {
            return null;
        } else {
            class_1045 var3 = this.a(var2.a, var2.b);
            if (var3 == null) {
                return var2;
            } else {
                class_1045 var4 = this.a(var3.a, var3.b);
                return var4 == null ? var3 : var4;
            }
        }
    }

    public void d(Unit var1) {
        if (this.a != null) {
            this.a.d();
        }

        GameEngine var2 = GameEngine.getGameEngine();
        float var3 = var2.cw;
        float var4 = var2.cx;
        class_1045 var5 = this.e(var1);
        float var7;
        if (var5 != null) {
            float var6 = var5.a;
            var7 = var5.b;
            class_225.c.b(-16776961);
            var2.bO.a(var1.xCord - var3, var1.yCord - var4, var6 - var3, var7 - var4, class_225.c);
            class_1045 var8 = this.b(var1);
            if (var8 != null) {
                class_225.c.b(-7829368);
                var2.bO.a(var6 - var3, var7 - var4, var8.a - var3, var8.b - var4, class_225.c);
            }
        }

        class_1045 var9 = this.a(var1);
        if (var9 != null) {
            var7 = var9.a;
            float var10 = var9.b;
            class_225.c.b(-256);
            var2.bO.a(var1.xCord - var3, var1.yCord - var4, var7 - var3, var10 - var4, class_225.c);
        }

    }

    public class_1045 e(Unit var1) {
        return this.a(var1.xCord, var1.yCord);
    }

    public class_1045 b(Unit var1) {
        class_1045 var2 = this.a(var1.xCord, var1.yCord);
        return var2 == null ? null : this.a(var2.a, var2.b);
    }

    public void c(Unit var1) {
    }

    public class_1045 a(float var1, float var2) {
        if (this.a.b == null) {
            return null;
        } else {
            GameEngine var3 = GameEngine.getGameEngine();
            class_484 var4 = var3.bL;
            int var5 = (int)(var1 * var4.r);
            int var6 = (int)(var2 * var4.s);
            if (!var4.c(var5, var6)) {
                return null;
            } else {
                byte var7 = this.a.a(var5, var6);
                if (var7 == 0) {
                    return null;
                } else {
                    class_225.a(var7, c);
                    int var8 = var5 - c.a;
                    int var9 = var6 - c.b;
                    this.b.a = (float)(var8 * var4.n + var4.p);
                    this.b.b = (float)(var9 * var4.o + var4.q);
                    return this.b;
                }
            }
        }
    }
}
