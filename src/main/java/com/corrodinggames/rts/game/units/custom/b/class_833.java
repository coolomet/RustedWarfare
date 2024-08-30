package com.corrodinggames.rts.game.units.custom.b;

import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import com.corrodinggames.rts.game.units.custom.class_113;
import com.corrodinggames.rts.game.units.custom.class_431;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.d.class_998;
import com.corrodinggames.rts.gameFramework.m.class_28;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.utility.class_694;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.b.h
public strictfp class class_833 extends class_827 {
    public static final class_827 a = new class_833();
    static final Rect b = new Rect();
    static final RectF c = new RectF();
    static final Paint d = new Paint();

    public strictfp void b(class_113 var1, float var2) {
        class_591 var3 = var1.x;
        class_928[] var4 = var1.dT;
        if (var4 != null) {
            if (var2 == 0.0F || !((double)var1.f > 0.3)) {
                class_826 var5 = var1.dn();
                if (var5 == null || !var5.t) {
                    if (var1.cN != null && var5 == null) {
                        for(int var27 = 0; var27 < var4.length; ++var27) {
                            class_928 var28 = var4[var27];
                            var28.m = true;
                        }

                    } else {
                        GameEngine var6 = GameEngine.getGameEngine();
                        float var7 = var1.cg;
                        if (var3.dE) {
                            var7 = var1.cL[var3.dG].a;
                        }

                        float var8 = var1.xCord - var1.dP;
                        float var9 = var1.yCord - var1.dQ;
                        float var10 = var1.zCord - var1.dR;
                        float var11 = var7 - var1.dS;
                        boolean var12 = var8 != 0.0F || var9 != 0.0F || var11 != 0.0F;
                        var1.dP = var1.xCord;
                        var1.dQ = var1.yCord;
                        var1.dR = var1.zCord;
                        var1.dS = var7;
                        PointF var15 = var1.n(15.0F);
                        float var13 = var15.x;
                        float var14 = var15.y;
                        float var16;
                        if (var13 != 0.0F || var14 != 0.0F) {
                            var16 = class_340.a(0.0F, 0.0F, var13, var14);
                            float var17 = class_340.d(0.0F, 0.0F, var13, var14);
                            var16 *= 240.0F;
                            if (var16 > 15.0F) {
                                var16 = 15.0F;
                            }

                            var13 = class_340.k(var17) * var16;
                            var14 = class_340.j(var17) * var16;
                        }

                        int var29 = 0;
                        var16 = 0.0F;
                        int var30 = 0;

                        int var18;
                        class_928 var19;
                        class_431 var20;
                        float var23;
                        float var24;
                        for(var18 = 0; var18 < var4.length; ++var18) {
                            var19 = var4[var18];
                            var20 = var3.ax[var18];
                            boolean var21 = false;
                            boolean var22 = false;
                            if (var19.m) {
                                var21 = true;
                                var19.m = false;
                                var19.o = true;
                                if (var19.n) {
                                    var22 = true;
                                }

                                var19.n = false;
                            }

                            if (!var20.h) {
                                var19.d -= var10;
                            }

                            if (!var20.l) {
                                if (var12) {
                                    var19.b -= var8;
                                    var19.c -= var9;
                                    var19.o = true;
                                }
                            } else if (var12 && var11 != 0.0F) {
                                class_340.c.setSite(var19.b, var19.c);
                                class_340.a(0.0F, 0.0F, var11, class_340.c);
                                var19.b = class_340.c.x;
                                var19.c = class_340.c.y;
                                var19.i += var11;
                                var19.o = true;
                            }

                            if (!var20.p) {
                                if (var20.T != 0.0F) {
                                    var19.r += var20.T * var2;
                                    var19.r %= 360.0F;
                                }

                                if (var19.o) {
                                    var23 = class_340.k(var7);
                                    var24 = class_340.j(var7);
                                    float var25 = var20.d + var19.p;
                                    float var26 = var20.e + var19.q;
                                    var19.f = var23 * var26 - var24 * var25;
                                    var19.g = var24 * var26 + var23 * var25;
                                    if (var21) {
                                        var19.b = var19.f;
                                        var19.c = var19.g;
                                        var19.i = var7 + var20.i;
                                        var19.o = true;
                                        if (var22) {
                                            var19.b *= 0.6F;
                                            var19.c *= 0.6F;
                                            var19.d = -3.0F;
                                        }
                                    }

                                    if (!var20.l) {
                                        var19.f += var13 * var20.m;
                                        var19.g += var14 * var20.m;
                                    }

                                    var19.h = class_340.a(var19.b, var19.c, var19.f, var19.g);
                                    if (var19.h > var16) {
                                        var30 = var18;
                                        var16 = var19.h;
                                    }

                                    if (var19.k && !var20.l) {
                                        ++var29;
                                    }
                                }
                            }
                        }

                        for(var18 = 0; var18 < var4.length; ++var18) {
                            var19 = var4[var18];
                            var20 = var3.ax[var18];
                            if (!var20.p) {
                                float var31 = var20.g;
                                if (!var20.h) {
                                    var31 -= var1.zCord;
                                }

                                float var32 = var31 + var20.f;
                                if (var19.h > 90000.0F) {
                                    var19.b = var20.d;
                                    var19.c = var20.e;
                                } else if (var19.h > var20.O * var20.O) {
                                    var23 = class_340.d(var19.f, var19.g, var19.b, var19.c);
                                    var19.b = var19.f + class_340.k(var23) * var20.O;
                                    var19.c = var19.g + class_340.j(var23) * var20.O;
                                    var19.k = true;
                                }

                                if (!var19.k && var19.d <= var31 + 0.1F && var29 < var20.L && (var18 == var30 || !var20.M)) {
                                    boolean var33 = false;
                                    if (var20.n) {
                                        for(int var34 = 0; var34 < var20.S.length; ++var34) {
                                            if (var4[var20.S[var34]].k) {
                                                var33 = true;
                                            }
                                        }
                                    }

                                    var24 = var20.K;
                                    if (var33) {
                                        var24 = var20.N;
                                    }

                                    if (var19.h > var24 * var24) {
                                        var19.k = true;
                                        ++var29;
                                    }
                                }

                                if (var20.l) {
                                    var19.k = true;
                                }

                                if (var19.k) {
                                    if (!(var19.d > var32) && !var20.l) {
                                        if (var19.e < var20.t) {
                                            var19.e += var2;
                                        } else {
                                            var19.d += var2 * var20.v;
                                        }
                                    } else {
                                        var23 = var2 * var20.s;
                                        if (var19.h <= var23 * var23) {
                                            var19.b = var19.f;
                                            var19.c = var19.g;
                                            var19.o = true;
                                            var19.k = false;
                                        } else {
                                            var24 = class_340.d(var19.b, var19.c, var19.f, var19.g);
                                            var19.b += class_340.k(var24) * var23;
                                            var19.c += class_340.j(var24) * var23;
                                            var19.o = true;
                                        }

                                        if (var20.l && var19.d > var31) {
                                            var19.d -= var2 * var20.v;
                                            if (var19.d <= var31) {
                                                var19.d = var31;
                                            }
                                        }

                                        var24 = class_340.c(var19.i, var7 + var20.i, var20.u * var2);
                                        var19.i += var24;
                                        var19.j = false;
                                    }
                                } else {
                                    var19.e = 0.0F;
                                    if (var19.d > var31) {
                                        var19.d -= var2 * var20.v;
                                        if (var19.d <= var31) {
                                            var19.d = var31;
                                            var23 = var1.xCord + var19.b;
                                            var24 = var1.yCord + var19.c;
                                            var19.l = class_694.c(var23, var24);
                                            if (var20.I && !var19.j) {
                                                var19.j = true;
                                                if (var19.l) {
                                                    if (var6.dd && var1.el) {
                                                        var6.bR.a(var23, var24, var19.d, 0, 0.0F, 0.0F);
                                                    }
                                                } else if (var6.dc && var1.el) {
                                                    class_998 var35 = var6.bR.c(var23, var24, var19.d, var19.i, 0);
                                                    if (var35 != null) {
                                                        var35.P = 0.0F;
                                                        var35.Q = 0.0F;
                                                        var35.G = 1.6F;
                                                        var35.F = 2.8F;
                                                    }
                                                }
                                            }
                                        }
                                    } else if (var19.l && var19.d > -3.0F + var31) {
                                        var19.d -= var2 * 0.3F;
                                    }
                                }
                            }
                        }

                    }
                }
            }
        }
    }

    public static strictfp void a(class_113 var0, float var1, boolean var2, boolean var3) {
        class_928[] var4 = var0.dT;
        if (var4 != null) {
            class_591 var5 = var0.x;
            float var6 = var0.cg;
            if (var5.dE) {
                var6 = var0.cL[var5.dG].a;
            }

            GameEngine var7 = GameEngine.getGameEngine();
            if (var0.cq || var0.cp) {
                for(int var8 = 0; var8 < var5.ax.length; ++var8) {
                    var4[var8].m = true;
                }

                var0.dv();
            }

            float var30 = var0.cD();
            Paint var9 = null;
            boolean var10 = var7.dg || var0.cp;

            for(int var11 = 0; var11 < var4.length; ++var11) {
                class_431 var12 = var5.ax[var11];
                if ((var12.P == var2 || var12.D != null) && var12.Q == var3 && !var12.p && (var12.q == null || !var12.q.read(var0))) {
                    class_928 var13 = var4[var11];
                    if (!(var13.s <= 0.0F)) {
                        float var14 = var0.zCord + var13.d;
                        if (var9 == null) {
                            var9 = var0.aN();
                        }

                        Paint var15 = var9;
                        float var16 = 1.0F;
                        if (var14 < -0.3F) {
                            var16 = (float)var0.l(var14) * 0.003921569F;
                        }

                        if (var13.s < 1.0F) {
                            var16 *= var13.s;
                        }

                        if (var16 < 1.0F) {
                            int var17 = (int)(255.0F * var16);
                            if (var9.f() != var17) {
                                d.a(var9);
                                int var18 = d.f();
                                if (var18 < var17) {
                                    var17 = var18;
                                }

                                d.c(var17);
                                var15 = d;
                            }
                        }

                        float var31 = var0.xCord + var13.b - var7.cw;
                        float var32 = var0.yCord + var13.c - var7.cx - var13.d - var0.zCord;
                        class_28 var19 = var7.bO;
                        if (var30 != 1.0F) {
                            var19.k();
                            var19.a(var30, var30, var31, var32);
                        }

                        if (var12.D != null && !var2 && var7.df && var13.d + var0.zCord > 0.0F) {
                            float var20 = var32 + var13.d + var0.zCord;
                            var19.a(var12.D, var31, var20, var13.i + var13.r + var12.R, var0.R());
                        }

                        if (var12.P == var2) {
                            TeamImageCache var33 = var12.B;
                            if (var12.C != null) {
                                var33 = var12.C[var0.bX.R()];
                            }

                            if (!var12.H && (var10 || var12.G) && var33 != null) {
                                var19.a(var33, var31, var32, var13.i + var13.r + var12.R, var15);
                            }

                            TeamImageCache var21 = var12.x;
                            if (var12.y != null) {
                                var21 = var12.y[var0.bX.R()];
                            }

                            if (var21 != null && (var10 || var12.F)) {
                                float var22 = var21.u;
                                float var23 = var22;
                                float var24 = class_340.k(var6);
                                float var25 = class_340.j(var6);
                                float var26 = var24 * var12.k - var25 * var12.j;
                                float var27 = var25 * var12.k + var24 * var12.j;
                                float var28 = class_340.d(var13.b, var13.c, var26, var27);
                                float var29 = class_340.a(var13.b, var13.c, var26, var27);
                                if (var29 < (var22 - 2.0F) * (var22 - 2.0F)) {
                                    var23 = (float)class_340.a((int)var29);
                                }

                                var19.k();
                                var19.a(var28 + 90.0F, var31, var32);
                                b.a(0, (int)(var22 - var23), var21.p, (int)(var22 + var23));
                                c.a(var31 - (float)var21.r, var32 - var23, var31 + (float)var21.r, var32 + var23);
                                var19.a(var21, b, c, var15);
                                var19.l();
                            }

                            if (var12.H && (var10 || var12.G) && var33 != null) {
                                var19.a(var33, var31, var32, var13.i + var13.r + var12.R, var15);
                            }
                        }

                        if (var30 != 1.0F) {
                            var19.l();
                        }
                    }
                }
            }

        }
    }
}
