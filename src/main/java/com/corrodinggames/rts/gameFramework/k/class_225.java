package com.corrodinggames.rts.gameFramework.k;

import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import com.corrodinggames.rts.game.maps.Layer;
import com.corrodinggames.rts.game.maps.class_482;
import com.corrodinggames.rts.game.maps.class_484;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.gameFramework.GameEngine;
import java.util.LinkedList;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.k.f
public strictfp class class_225 extends class_224 {
    class_221 a = new class_222(this);
    class_301 b;
    static Paint c = new Paint();
    static Point d = new Point();

    public class_225(PathEngine var1, boolean var2) {
        super(var1, var2);
    }

    public class_221 a(Unit var1) {
        return this.a() != null ? this.a : null;
    }

    public LinkedList a() {
        return super.a();
    }

    public boolean b() {
        return true;
    }

    public boolean a(class_224 var1) {
        if (this == var1) {
            return true;
        } else if (!(var1 instanceof class_225)) {
            return false;
        } else {
            class_225 var2 = (class_225)var1;
            if (this.l == var2.l && this.m == var2.m) {
                return this.o == var2.o;
            } else {
                return false;
            }
        }
    }

    protected boolean c() {
        return this.x != null;
    }

    public final byte a(int var1, int var2) {
        return this.b == null ? -1 : this.b.a(var1, var2);
    }

    public static final void a(byte var0, Point var1) {
        int var2 = 0;
        int var3 = 0;
        --var0;
        if (var0 == 0) {
            ++var2;
        }

        if (var0 == 1) {
            ++var2;
            ++var3;
        }

        if (var0 == 2) {
            ++var3;
        }

        if (var0 == 3) {
            ++var3;
            --var2;
        }

        if (var0 == 4) {
            --var2;
        }

        if (var0 == 5) {
            --var2;
            --var3;
        }

        if (var0 == 6) {
            --var3;
        }

        if (var0 == 7) {
            --var3;
            ++var2;
        }

        var1.a = var2;
        var1.b = var3;
    }

    public void d() {
        GameEngine var1 = GameEngine.getGameEngine();
        class_484 var2 = var1.bL;
        Rect var3 = new Rect();
        float var4 = var1.cw;
        float var5 = var1.cx;
        float var6 = var1.cA;
        float var7 = var1.cB;
        Layer var8 = var1.bL.u;
        int var9 = (int)(var4 * var2.r - 1.0F);
        if (var9 < 0) {
            var9 = 0;
        }

        int var10 = (int)(var5 * var2.s - 1.0F);
        if (var10 < 0) {
            var10 = 0;
        }

        int var11 = (int)((var4 + var6) * var2.r + 1.0F);
        if (var11 > var2.width - 1) {
            var11 = var2.width - 1;
        }

        int var12 = (int)((var5 + var7) * var2.s + 1.0F);
        if (var12 > var2.height - 1) {
            var12 = var2.height - 1;
        }

        boolean var13 = false;

        for(int var14 = var9; var14 < var11 + 1; ++var14) {
            for(int var15 = var10; var15 < var12 + 1; ++var15) {
                class_482 var16 = var8.a(var14, var15);
                if (var16 != null) {
                    int var17 = var14 * var2.n;
                    int var18 = var15 * var2.o;
                    var3.a(var17, var18, var17 + var2.n, var18 + var2.o);
                    var3.a((int)(-var4), (int)(-var5));
                    boolean var19 = var3.b((int)(var1.bS.x / var1.cX), (int)(var1.bS.y / var1.cX));
                    int var20 = 50;
                    int var21 = 0;
                    int var22 = 0;
                    if (var20 == -1) {
                        var20 = 255;
                    } else {
                        var20 *= 2;
                    }

                    if (var21 == -1) {
                        var21 = 255;
                    } else {
                        var21 *= 2;
                    }

                    if (var22 == -1) {
                        var22 = 255;
                    } else {
                        if (var22 != 0) {
                            var22 += 30;
                        }

                        var22 *= 2;
                    }

                    c.a(128, var20, var21, var22);
                    byte var23 = this.a(var14, var15);
                    a(var23, d);
                    float var24 = (float)(var17 + var2.p) - var4;
                    float var25 = (float)(var18 + var2.q) - var5;
                    var1.bO.a(var24, var25, var24 + (float)(d.a * (var2.n - 3)) + 1.0F, var25 + (float)(d.b * (var2.o - 3)) + 1.0F, c);
                    if (var19) {
                    }
                }
            }
        }

    }
}
