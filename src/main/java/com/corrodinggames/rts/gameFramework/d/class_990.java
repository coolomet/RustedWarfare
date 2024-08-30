package com.corrodinggames.rts.gameFramework.d;

import android.graphics.Paint;
import android.graphics.Paint$Style;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.maps.class_484;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.m.class_525;
import com.corrodinggames.rts.gameFramework.utility.class_682;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.d.a
public strictfp class class_990 {
    float a;
    float b;
    public boolean c;
    public class_31 d;
    public PlayerData e;
    public int f = 1;
    public float g;
    public float h;
    public boolean i;
    public PlayerData j;
    public boolean k;
    public int l;
    public int m;
    public boolean n;
    public OrderableUnit o;
    boolean p = false;
    public boolean q = false;
    public int r;
    public float s;
    public float t = 0.04F;
    public boolean u;
    public Unit v;
    public static class_682 w = new class_682();
    static Point x = new Point();
    static RectF y = new RectF();
    static RectF z = new RectF();
    static RectF A = new RectF();
    Paint B = new Paint();
    static Paint C = new class_525();
    static Paint D;
    static RectF E = new RectF();

    public class_990() {
        w.add(this);
        w.a();
    }

    public static void a() {
        w.clear();
    }

    public static void a(float var0) {
        Iterator var1 = w.iterator();

        while(var1.hasNext()) {
            class_990 var2 = (class_990)var1.next();
            var2.c(var0);
        }

        w.a();
    }

    public static void b(float var0) {
        Object[] var1 = w.b();
        int var2 = 0;

        for(int var3 = w.size(); var2 < var3; ++var2) {
            class_990 var4 = (class_990)var1[var2];
            var4.d(var0);
        }

    }

    public static boolean a(PlayerData var0, int var1, int var2, int var3) {
        GameEngine var4 = GameEngine.getGameEngine();
        var4.bL.a(var1, var2);
        float var5 = (float)(var4.bL.T + var4.bL.p);
        float var6 = (float)(var4.bL.U + var4.bL.q);
        y.a(var5, var6, var5 + 1.0F, var6 + 1.0F);
        return a(var0, y, var3);
    }

    public static boolean a(PlayerData var0, OrderableUnit var1, int var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        class_484 var4 = var3.bL;
        y = var1.a((class_484)var4, (RectF)y);
        return a(var0, y, var2);
    }

    public static boolean a(OrderableUnit var0, OrderableUnit var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        class_484 var3 = var2.bL;
        y = var0.a((class_484)var3, (RectF)y);
        z = var1.a((class_484)var3, (RectF)z);
        return class_340.a(y, z);
    }

    public static boolean a(PlayerData var0, RectF var1, int var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        class_484 var4 = var3.bL;
        RectF var5 = A;
        Iterator var6 = w.iterator();

        while(true) {
            class_990 var7;
            do {
                do {
                    do {
                        if (!var6.hasNext()) {
                            return false;
                        }

                        var7 = (class_990)var6.next();
                    } while(var7.j != var0);
                } while(!var7.n);
            } while(var2 != -1 && var2 != var7.r);

            Unit var8 = Unit.a(var7.d);
            if (var8 == null) {
                GameEngine.log("isTileRectOverBlueprint: Failed to get shared unit for: " + var7.d);
            } else {
                var8.xCord = var7.g;
                var8.yCord = var7.h;
                var5 = var8.a(var4, var5);
                if (class_340.a(var5, var1)) {
                    return true;
                }
            }
        }
    }

    public static class_990 a(PlayerData var0, float var1, float var2) {
        Iterator var3 = w.iterator();

        while(var3.hasNext()) {
            class_990 var4 = (class_990)var3.next();
            if (var4.j == var0 && var4.n) {
                float var5 = class_340.a(var4.g, var4.h, var1, var2);
                Unit var6 = Unit.a(var4.d);
                float var7 = var6.cj + 1.0F;
                if (var7 < 20.0F) {
                    var7 = 20.0F;
                }

                if (var5 < var7 * var7) {
                    return var4;
                }
            }
        }

        return null;
    }

    public boolean b() {
        if (this.n) {
            if (this.o == null || this.o.bV) {
                return false;
            }

            if (!UnitType.a(this.d, this.g, this.h, 0.0F, 0.0F, this.e)) {
                return false;
            }
        } else {
            if (this.v == null) {
                return false;
            }

            if (this.v.cf()) {
                return false;
            }
        }

        return true;
    }

    public void c(float var1) {
        ++this.a;
        this.b += var1;
        boolean var2 = false;
        this.s = class_340.a(this.s, this.t * var1);
        if (this.n) {
            if (this.a > 6.0F) {
                this.a = 0.0F;
                boolean var3 = this.o.a(this.d, this.g, this.h);
                if (!this.p && var3) {
                    this.p = true;
                }

                if (!var3) {
                    if (this.p) {
                        var2 = true;
                    } else if (this.b > 180.0F) {
                        var2 = true;
                    }
                }

                if (!this.b()) {
                    var2 = true;
                }
            }
        } else if (this.a > 2.0F && !this.b()) {
            var2 = true;
        }

        if (var2) {
            this.c = true;
            w.b((Object)this);
        }

    }

    public void d(float var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        if (var2.playerTeam == this.j) {
            if (var2.cO.b(this.g, this.h)) {
                if (!this.q || this.p) {
                    float var3 = 0.0F;
                    float var4 = this.g;
                    float var5 = this.h;
                    float var6 = 0.0F;
                    float var7 = 0.0F;
                    float var8 = 1.0F;
                    float var9 = 500.0F;
                    boolean var10 = false;
                    boolean var11 = false;
                    if (this.n) {
                        var11 = true;
                    } else {
                        var10 = true;
                    }

                    boolean var12 = true;
                    if (this.i) {
                        var12 = false;
                    }

                    if (var11) {
                        var3 = this.s;
                        if (var3 <= 0.0F) {
                            var3 = 0.0F;
                        } else if (this.s < 1.0F) {
                            var3 = 1.0F - class_340.k(var3 * 90.0F);
                        } else {
                            var3 = 1.0F;
                        }
                    }

                    if (var11 && this.s < 1.0F) {
                        Unit var13 = Unit.c(this.d);
                        if (var13 != null && var13.bI()) {
                            Rect var14 = var13.cd();
                            if (var14 != null) {
                                E.a(var14);
                                RectF var10000 = E;
                                var10000.b *= (float)var2.bL.o;
                                var10000 = E;
                                var10000.d *= (float)var2.bL.o;
                                var10000 = E;
                                var10000.a *= (float)var2.bL.n;
                                var10000 = E;
                                var10000.c *= (float)var2.bL.n;
                                float var15 = (float)(var2.bL.p - 3) + var3 * 5.0F;
                                E.a(-(var13.cZ() - (float)var2.bL.p), -(var13.da() - (float)var2.bL.q));
                                class_340.a(E, var15);
                                float var16 = this.g - var2.cw;
                                float var17 = this.h - var2.cx - var7;
                                E.a(var16, var17);
                                float var18 = 3.0F + var3 * 7.0F;
                                Paint var19 = C;
                                if (this.s <= 0.0F) {
                                    var19 = D;
                                }

                                var2.bO.a(E.a - var18, E.b, E.c + var18, E.b, var19);
                                var2.bO.a(E.a - var18, E.d, E.c + var18, E.d, var19);
                                var2.bO.a(E.a, E.b - var18, E.a, E.d + var18, var19);
                                var2.bO.a(E.c, E.b - var18, E.c, E.d + var18, var19);
                            }
                        }
                    }

                    float var20 = 0.0F;
                    if (var11) {
                        var20 -= 10.0F * var3;
                    }

                    UnitType.a(this.d, var4, var5 + var20, var6, var7, this.e, var8, var9, var10, var11, this.f, var12, (Unit)null);
                }
            }
        }
    }

    static {
        C.a(90, 0, 0, 255);
        C.a(Paint$Style.b);
        C.a(2.0F);
        D = new class_525();
        D.a(40, 0, 0, 255);
        D.a(Paint$Style.b);
        D.a(2.0F);
    }
}
