package com.corrodinggames.rts.gameFramework.utility;

import android.graphics.Paint;
import android.graphics.Paint$Style;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.maps.class_482;
import com.corrodinggames.rts.game.maps.class_484;
import com.corrodinggames.rts.game.units.MovementType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.air.class_107;
import com.corrodinggames.rts.game.units.custom.b.class_826;
import com.corrodinggames.rts.game.units.sea.class_114;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.k.PathEngine;
import com.corrodinggames.rts.gameFramework.k.class_223;
import com.corrodinggames.rts.gameFramework.m.class_28;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.m.class_525;
import java.util.ArrayList;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.utility.y
public final strictfp class class_694 {
    static final Paint a = new Paint();
    static final RectF b = new RectF();
    static ArrayList c = new ArrayList();
    static final Rect d;
    static final RectF e;
    static Paint f;
    static class_695[] g;
    static boolean h;

    public static strictfp void a(Unit var0, float var1) {
        a(var0, var1, false, false);
    }

    public static strictfp void a(Unit var0, float var1, boolean var2) {
        a(var0, var1, var2, false);
    }

    public static strictfp boolean a(Unit var0) {
        GameEngine var1 = GameEngine.getGameEngine();
        return var0.cG && var1.bS.q() == 1 && !var1.bS.g.e;
    }

    public static strictfp void a(Unit var0, float var1, boolean var2, boolean var3) {
        GameEngine var4 = GameEngine.getGameEngine();
        if (a(var0) || var2) {
            float var5 = var0.xCord - var4.cw;
            float var6 = var0.yCord - var4.cx;
            Paint var7 = Unit.dg;
            if (var3) {
                var7 = Unit.dh;
            }

            var4.bO.a(var5, var6, var1, var7);
        }

    }

    public static strictfp void a(Unit var0, float var1, int var2, int var3, boolean var4) {
        GameEngine var5 = GameEngine.getGameEngine();
        if (var0.cG && var5.bS.q() < 10 || var4) {
            float var6 = var0.xCord - var5.cw;
            float var7 = var0.yCord - var5.cx;
            Paint var8 = Unit.dk;
            var8.b(var2);
            var8.a((float)var3);
            var5.bO.a(var6, var7, var1, var8);
        }

    }

    public static strictfp void b(Unit var0, float var1, boolean var2) {
        a(var0, var1, var2, Unit.di);
    }

    public static strictfp void a(Unit var0, float var1, boolean var2, Paint var3) {
        GameEngine var4 = GameEngine.getGameEngine();
        if (a(var0) || var2) {
            float var5 = var0.xCord - var4.cw;
            float var6 = var0.yCord - var4.cx;
            var4.bO.a(var5, var6, var1, var3);
        }

    }

    public static strictfp void a(TeamImageCache var0, float var1, float var2, float var3, float var4, float var5, Paint var6, int var7, int var8, int var9) {
        GameEngine var10 = GameEngine.getGameEngine();
        int var11 = 0;
        byte var12 = 0;
        var11 += var9 * var7;
        d.a(var11, var12, var11 + var7, var12 + var8);
        float var13 = var5 * 0.5F;
        var2 -= var3;
        float var14 = (float)var7 * var13;
        float var15 = (float)var8 * var13;
        e.a(var1 - var14, var2 - var15, var1 + var14, var2 + var15);
        class_28 var16 = var10.bO;
        var16.k();
        var16.a(var4 + 90.0F, var1, var2);
        if (var5 != 1.0F) {
            var16.a(var5, var5, var1, var2);
        }

        var16.a(var0, d, e, var6);
        var16.l();
    }

    public static strictfp boolean a(Unit var0, boolean var1, boolean var2) {
        if (var0.cr() && var2) {
            return false;
        } else if (var1 && (var0 instanceof class_107 || var0 instanceof class_114)) {
            return false;
        } else if (var0.bI()) {
            return false;
        } else if (var1 && (var0.cv() || var0.ct())) {
            return false;
        } else if (var0.P()) {
            return false;
        } else {
            return var0.cN == null && var0.cO == null;
        }
    }

    public static strictfp Paint a() {
        class_525 var0 = new class_525();
        GameEngine var1 = GameEngine.getGameEngine();
        if (var1.settingsEngine.renderAntiAlias) {
            var0.a(true);
            var0.d(true);
            var0.b(true);
        } else {
            var0.a(false);
            var0.d(false);
            var0.b(false);
        }

        return var0;
    }

    public static strictfp class_525 b() {
        class_525 var0 = new class_525();
        var0.a(false);
        var0.d(false);
        var0.b(false);
        return var0;
    }

    public static strictfp void a(OrderableUnit var0) {
        if (!var0.bV) {
            int var1 = var0.bl();

            for(int var2 = 0; var2 < var1; ++var2) {
                a(var0, var2);
            }
        }

    }

    public static strictfp void a(OrderableUnit var0, TeamImageCache var1, float var2, int var3) {
        if (!var0.bV && var2 != 0.0F) {
            GameEngine var4 = GameEngine.getGameEngine();
            Point3DF var5 = var0.D(var3);
            var4.bO.k();
            var4.bO.b(var5.x - var4.cw, var5.y - var5.z - var0.zCord - var4.cx);
            var4.bO.a(var2, var2);
            var4.bO.a((TeamImageCache)var1, 0.0F, 0.0F, (Paint)null);
            var4.bO.l();
        }

    }

    public static strictfp void a(OrderableUnit var0, int var1) {
        TeamImageCache var2 = var0.d(var1);
        if (var2 != null) {
            float var3 = var0.p(var1);
            Paint var4 = var0.aN();
            GameEngine var5 = GameEngine.getGameEngine();
            Point3DF var6 = var0.F(var1);
            float var7 = var6.x - GameEngine.getGameEngine().cw;
            float var8 = var6.y - GameEngine.getGameEngine().cx - var0.zCord - var6.z;
            class_28 var9 = var5.bO;
            var9.k();
            if (var3 != 1.0F) {
                var9.a(var3, var3, var7, var8);
            }

            var9.a(var0.cL[var1].a + 90.0F, var7, var8);
            var9.b(var2, var7 - var2.t - var0.h(var1), var8 - var2.u - var0.i(var1), var4);
            var9.l();
        }
    }

    public static strictfp boolean a(Unit var0, float var1, float var2) {
        return !a(var1, var2, var0.h());
    }

    public static strictfp boolean a(float var0, float var1, MovementType var2) {
        PathEngine var3 = GameEngine.getGameEngine().bU;
        class_484 var4 = GameEngine.getGameEngine().bL;
        var4.a(var0, var1);
        int var5 = var4.T;
        int var6 = var4.U;
        return var3.a(var2, var5, var6);
    }

    public static strictfp short b(float var0, float var1, MovementType var2) {
        PathEngine var3 = GameEngine.getGameEngine().bU;
        class_484 var4 = GameEngine.getGameEngine().bL;
        class_223 var5 = var3.a(var2);
        if (var5.g == null) {
            return -3;
        } else {
            var4.a(var0, var1);
            int var6 = var4.T;
            int var7 = var4.U;
            if (!var4.c(var6, var7)) {
                return -2;
            } else {
                short var8 = var5.g[var6 * var5.c + var7];
                return var8;
            }
        }
    }

    public static strictfp int c(float var0, float var1, MovementType var2) {
        short var3 = b(var0, var1, var2);
        if (var3 != -3 && var3 != -2 && var3 != -1 && var3 != 0) {
            PathEngine var4 = GameEngine.getGameEngine().bU;
            class_223 var5 = var4.a(var2);
            Integer var6 = (Integer)var5.h.get(var3);
            if (var6 == null) {
                GameEngine.print("Could not find groupSize for:" + var3 + " at X:" + var0 + " y:" + var1);
                return 0;
            } else {
                return var6;
            }
        } else {
            return 0;
        }
    }

    public static strictfp boolean a(float var0, float var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        class_484 var3 = var2.bL;
        if (var3 == null) {
            GameEngine.log("isInMap called without map loaded");
            return false;
        } else {
            int var4 = (int)(var0 * var3.r);
            int var5 = (int)(var1 * var3.s);
            return var3.c(var4, var5);
        }
    }

    public static strictfp boolean b(float var0, float var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        class_484 var3 = var2.bL;
        if (var3 == null) {
            GameEngine.log("isOverClift called without map loaded");
            return false;
        } else {
            int var4 = (int)(var0 * var3.r);
            int var5 = (int)(var1 * var3.s);
            return var2.bU.b(var4, var5);
        }
    }

    public static strictfp boolean c(float var0, float var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        class_484 var3 = var2.bL;
        if (var3 == null) {
            GameEngine.log("isOverWater called without map loaded");
            return false;
        } else {
            int var4 = (int)(var0 * var3.r);
            int var5 = (int)(var1 * var3.s);
            return var2.bU.a(var4, var5);
        }
    }

    public static strictfp boolean d(float var0, float var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        class_484 var3 = var2.bL;
        if (var3 == null) {
            GameEngine.log("isOverLiquid called without map loaded");
            return false;
        } else {
            class_482 var4 = var3.c(var0, var1);
            if (var4 == null) {
                return false;
            } else if (!var4.e && !var4.g) {
                int var5 = (int)(var0 * var3.r);
                int var6 = (int)(var1 * var3.s);
                return var2.bU.a(var5, var6);
            } else {
                return true;
            }
        }
    }

    public static final strictfp Paint a(int var0, int var1, int var2, int var3, Paint$Style var4) {
        return a(class_340.b(var0, var1, var2, var3), var4);
    }

    public static final strictfp Paint a(int var0, Paint$Style var1) {
        for(int var2 = 0; var2 < g.length; ++var2) {
            class_695 var3;
            if (g[var2] == null) {
                var3 = new class_695(var0, var1);
                g[var2] = var3;
                return var3.c;
            }

            var3 = g[var2];
            if (var3.a == var0 && var3.b == var1) {
                return var3.c;
            }
        }

        if (!h) {
            h = true;
            GameEngine.print("----- getCachingPaint --- Paint fallback was needed!!");
        }

        f.b(var0);
        f.a(var1);
        return f;
    }

    public static strictfp void a(float var0) {
        if (c.size() != 0) {
            Iterator var1 = c.iterator();

            while(var1.hasNext()) {
                class_673 var2 = (class_673)var1.next();
                if (var2.e <= 0.0F) {
                    var1.remove();
                } else {
                    var2.e -= var0;
                    if (var0 == 0.0F && var2.e < 1.0F) {
                        var2.e = -1.0F;
                    }
                }
            }

        }
    }

    public static strictfp void b(float var0) {
        if (c.size() != 0) {
            GameEngine var1 = GameEngine.getGameEngine();
            Iterator var2 = c.iterator();

            while(var2.hasNext()) {
                class_673 var3 = (class_673)var2.next();
                float var4 = var3.b.a;
                float var5 = var3.b.b;
                float var6 = var3.b.c;
                float var7 = var3.b.d;
                if (var3.d) {
                    var4 -= GameEngine.getGameEngine().cw;
                    var5 -= GameEngine.getGameEngine().cx;
                    var6 -= GameEngine.getGameEngine().cw;
                    var7 -= GameEngine.getGameEngine().cx;
                }

                if (var3.c) {
                    var1.bO.a(var4, var5, var6, var7, var3.a);
                } else {
                    if (var3.d) {
                    }

                    var1.bO.a(var3.b, var3.a);
                }

                if (var3.f != null) {
                    var1.bO.i();
                    var1.S();
                    float var8 = var6;
                    float var9 = var7;
                    if (var3.d) {
                        var8 = var6 * var1.cX;
                        var9 = var7 * var1.cX;
                    }

                    var1.bO.a(var3.f, var8, var9, var3.a);
                    var1.bO.j();
                }
            }

        }
    }

    public static final strictfp boolean a(int var0, int var1) {
        int var2 = GameEngine.getGameEngine().by;
        if (var0 + var1 < var2) {
            return true;
        } else {
            return var2 < var0 - 1000;
        }
    }

    public static final strictfp boolean b(int var0, int var1) {
        int var2 = GameEngine.getGameEngine().by;
        if (var0 < 0) {
            return false;
        } else {
            return var0 + var1 >= var2 && var0 <= var2;
        }
    }

    public static strictfp boolean a(float var0, float var1, float var2, float var3, MovementType var4) {
        if (var4 != MovementType.AIR && var4 != MovementType.NONE) {
            short var5 = b(var0, var1, var4);
            short var6 = b(var2, var3, var4);
            if (var5 == -3 || var6 == -3) {
                String var7 = "null";
                if (var4 != null) {
                    var7 = var4.name();
                }

                GameEngine.warn("pathPossible: no isolatedGroups found! (" + var7 + ")");
            }

            if (var5 != -1 && var6 != -1) {
                if (var5 == -2) {
                    return false;
                } else if (var6 == -2) {
                    return false;
                } else {
                    return var5 == var6;
                }
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    public static strictfp boolean b(Unit var0, float var1, float var2) {
        return a(var0.xCord, var0.yCord, var1, var2, var0.h());
    }

    public static strictfp void a(PlayerData var0, PointF var1) {
        GameEngine var2 = GameEngine.getGameEngine();

        for(int var3 = 0; var3 <= 2; ++var3) {
            Iterator var4 = Unit.bF().iterator();

            while(var4.hasNext()) {
                Unit var5 = (Unit)var4.next();
                if (var5 instanceof Unit && !var5.bV && var5.bX == var0) {
                    if (var3 == 0 && var5.bO) {
                        var1.setSite(var5.xCord, var5.yCord);
                        return;
                    }

                    if (var3 == 1 && var5.bP) {
                        var1.setSite(var5.xCord, var5.yCord);
                        return;
                    }

                    if (var3 == 2) {
                        var1.setSite(var5.xCord, var5.yCord);
                        return;
                    }
                }
            }
        }

        var1.setSite(var2.bL.i() / 2.0F, var2.bL.j() / 2.0F);
    }

    public static strictfp void a(Unit var0, OrderableUnit var1) {
        var0.cN = null;
        class_826 var2 = null;
        if (var0 instanceof OrderableUnit) {
            OrderableUnit var3 = (OrderableUnit)var0;
            if (var3.cO == var1) {
                var2 = var3.dn();
                if (var2 == null) {
                    GameEngine.log("Unload, attachment data is null");
                }

                var3.bx();
            }
        }

    }

    static {
        a.a(205, 255, 0, 0);
        a.a(Paint$Style.b);
        d = new Rect();
        e = new RectF();
        f = new Paint();
        g = new class_695[30];
        h = false;
    }
}
