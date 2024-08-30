package com.corrodinggames.rts.game.units.p026f;

import android.graphics.Rect;
import android.graphics.RectF;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.maps.class_484;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.f.class_1012;
import com.corrodinggames.rts.game.units.f.class_1013;
import com.corrodinggames.rts.game.units.f.class_1014;
import com.corrodinggames.rts.game.units.f.class_1015;
import com.corrodinggames.rts.game.units.f.class_1019;
import com.corrodinggames.rts.game.units.f.class_1020;
import com.corrodinggames.rts.game.units.f.class_1021;
import com.corrodinggames.rts.game.units.f.class_304;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.utility.class_692;

public final strictfp class UnitGeoIndex {
    int a;
    int b;
    float c;
    float d;
    public class_1021[][] e = (class_1021[][])null;
    class_1013 f = new class_1013();
    class_1014 g = new class_1014();
    class_1015 h = new class_1015();
    final class_692 i = new class_692();
    final class_1019 j = new class_1019();
    final Rect k = new Rect();
    final int l = 32;
    int m;

    public void a(float var1, float var2, float var3, OrderableUnit var4, float var5, class_304 var6) {
        float var7 = var1 - var3;
        float var8 = var2 - var3;
        float var9 = var1 + var3;
        float var10 = var2 + var3;
        this.g.a(var7, var8, var9, var10);
        this.a(this.g.a, this.g, var4, var5, var6);
    }

    public final class_1019 a(float var1, float var2, float var3) {
        class_692 var4 = this.i;
        var4.clear();
        this.a(var1, var2, var3, var4);
        this.j.a(var4);
        return this.j;
    }

    public final void a(float var1, float var2, float var3, class_692 var4) {
        class_1021[][] var5 = this.e;
        float var6 = var1 - var3;
        float var7 = var1 + var3;
        float var8 = var2 - var3;
        float var9 = var2 + var3;
        int var10 = this.a(var6);
        int var11 = this.a(var7);
        int var12 = this.b(var8);
        int var13 = this.b(var9);

        for(int var14 = var10; var14 <= var11; ++var14) {
            for(int var15 = var12; var15 <= var13; ++var15) {
                class_1020 var16 = var5[var14][var15].a;
                Unit[] var17 = var16.a();
                int var18 = 0;

                for(int var19 = var16.b; var18 < var19; ++var18) {
                    Unit var20 = var17[var18];
                    float var21 = var20.xCord;
                    float var22 = var20.yCord;
                    if (var6 <= var21 && var21 <= var7 && var8 <= var22 && var22 <= var9) {
                        var4.a(var20);
                    }
                }
            }
        }

    }

    public final class_1019 b(float var1, float var2, float var3) {
        class_692 var4 = this.i;
        var4.clear();
        this.b(var1, var2, var3, var4);
        this.j.a(var4);
        return this.j;
    }

    public final void b(float var1, float var2, float var3, class_692 var4) {
        class_1021[][] var5 = this.e;
        float var6 = var1 - var3;
        float var7 = var1 + var3;
        float var8 = var2 - var3;
        float var9 = var2 + var3;
        float var10 = 50.0F;
        int var11 = this.a(var6 - 50.0F);
        int var12 = this.a(var7 + 50.0F);
        int var13 = this.b(var8 - 50.0F);
        int var14 = this.b(var9 + 50.0F);

        for(int var15 = var11; var15 <= var12; ++var15) {
            for(int var16 = var13; var16 <= var14; ++var16) {
                class_1020 var17 = var5[var15][var16].a;
                Unit[] var18 = var17.a();
                int var19 = 0;

                for(int var20 = var17.b; var19 < var20; ++var19) {
                    Unit var21 = var18[var19];
                    float var22 = var21.xCord;
                    float var23 = var21.yCord;
                    float var24 = var21.cj;
                    if (var6 - var24 <= var22 && var22 <= var7 + var24 && var8 - var24 <= var23 && var23 <= var9 + var24) {
                        var4.b(var21);
                    }
                }
            }
        }

    }

    public final void a(PlayerData var1, float var2, float var3, float var4, class_692 var5) {
        class_1021[][] var6 = this.e;
        float var7 = var2 - var4;
        float var8 = var2 + var4;
        float var9 = var3 - var4;
        float var10 = var3 + var4;
        float var11 = 50.0F;
        int var12 = this.a(var7 - 50.0F);
        int var13 = this.a(var8 + 50.0F);
        int var14 = this.b(var9 - 50.0F);
        int var15 = this.b(var10 + 50.0F);
        int var16 = var1.site;

        for(int var17 = var12; var17 <= var13; ++var17) {
            for(int var18 = var14; var18 <= var15; ++var18) {
                class_1020 var19 = var6[var17][var18].b[var16];
                Unit[] var20 = var19.a();
                int var21 = 0;

                for(int var22 = var19.b; var21 < var22; ++var21) {
                    Unit var23 = var20[var21];
                    float var24 = var23.xCord;
                    float var25 = var23.yCord;
                    float var26 = var23.cj;
                    if (var7 - var26 <= var24 && var24 <= var8 + var26 && var9 - var26 <= var25 && var25 <= var10 + var26) {
                        var5.b(var23);
                    }
                }
            }
        }

    }

    public void a(RectF var1, class_1012 var2, OrderableUnit var3, float var4, class_304 var5) {
        class_1021[][] var6 = this.e;
        int var7 = this.a(var1.a);
        int var8 = this.a(var1.c);
        int var9 = this.b(var1.b);
        int var10 = this.b(var1.d);
        PlayerData var11 = null;
        int var12 = var5.excludeTeam(var3);
        if (var12 != -2 && var12 != -3) {
            var11 = PlayerData.getPlayerData(var12);
        }

        PlayerData var13 = var5.onlyEnemiesOfTeam(var3);
        PlayerData var14 = var5.onlyTeam(var3);
        var5.setup(var3, var4);
        int var15;
        int var16;
        int var20;
        class_1020 var25;
        Unit[] var26;
        int var29;
        Unit var30;
        if (var13 == null && var14 == null) {
            for(var15 = var7; var15 <= var8; ++var15) {
                for(var16 = var9; var16 <= var10; ++var16) {
                    var25 = var6[var15][var16].a;
                    var26 = var25.a();
                    var29 = 0;

                    for(var20 = var25.b; var29 < var20; ++var29) {
                        var30 = var26[var29];
                        if ((var11 == null || var30.bX != var11) && var2.a(var30)) {
                            var5.callback(var3, var4, var30);
                        }
                    }
                }
            }
        } else {
            int var21;
            if (var14 != null) {
                var15 = var14.site;
                int var17;
                class_1020 var18;
                Unit[] var19;
                Unit var22;
                if (var15 == -1) {
                    for(var16 = var7; var16 <= var8; ++var16) {
                        for(var17 = var9; var17 <= var10; ++var17) {
                            var18 = var6[var16][var17].d;
                            if (var18.b > 0) {
                                var19 = var18.a();
                                var20 = 0;

                                for(var21 = var18.b; var20 < var21; ++var20) {
                                    var22 = var19[var20];
                                    if (var2.a(var22)) {
                                        var5.callback(var3, var4, var22);
                                    }
                                }
                            }
                        }
                    }
                } else if (var15 == -2) {
                    for(var16 = var7; var16 <= var8; ++var16) {
                        for(var17 = var9; var17 <= var10; ++var17) {
                            var18 = var6[var16][var17].c;
                            if (var18.b > 0) {
                                var19 = var18.a();
                                var20 = 0;

                                for(var21 = var18.b; var20 < var21; ++var20) {
                                    var22 = var19[var20];
                                    if (var2.a(var22)) {
                                        var5.callback(var3, var4, var22);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    for(var16 = var7; var16 <= var8; ++var16) {
                        for(var17 = var9; var17 <= var10; ++var17) {
                            var18 = var6[var16][var17].b[var15];
                            if (var18.b > 0) {
                                var19 = var18.a();
                                var20 = 0;

                                for(var21 = var18.b; var20 < var21; ++var20) {
                                    var22 = var19[var20];
                                    if (var2.a(var22)) {
                                        var5.callback(var3, var4, var22);
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                if (var13 != PlayerData.h) {
                    for(var15 = var7; var15 <= var8; ++var15) {
                        for(var16 = var9; var16 <= var10; ++var16) {
                            var25 = var6[var15][var16].c;
                            if (var25.b > 0) {
                                var26 = var25.a();
                                var29 = 0;

                                for(var20 = var25.b; var29 < var20; ++var29) {
                                    var30 = var26[var29];
                                    if (var2.a(var30)) {
                                        var5.callback(var3, var4, var30);
                                    }
                                }
                            }
                        }
                    }
                }

                var15 = this.m;

                for(var16 = 0; var16 <= var15; ++var16) {
                    PlayerData var27 = PlayerData.getPlayerData(var16);
                    if (var27 != null && var13 != var27 && var13.c(var27)) {
                        for(int var28 = var7; var28 <= var8; ++var28) {
                            for(var29 = var9; var29 <= var10; ++var29) {
                                class_1020 var31 = var6[var28][var29].b[var16];
                                var21 = var31.b;
                                if (var21 > 0) {
                                    Unit[] var32 = var31.a();

                                    for(int var23 = 0; var23 < var21; ++var23) {
                                        Unit var24 = var32[var23];
                                        if (var2.a(var24)) {
                                            var5.callback(var3, var4, var24);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    public final int a(float var1) {
        int var2 = (int)(var1 * this.c);
        if (var2 < 0) {
            var2 = 0;
        }

        if (var2 >= 32) {
            var2 = 31;
        }

        return var2;
    }

    public final int b(float var1) {
        int var2 = (int)(var1 * this.d);
        if (var2 < 0) {
            var2 = 0;
        }

        if (var2 >= 32) {
            var2 = 31;
        }

        return var2;
    }

    public void a() {
        float var1 = this.c;
        float var2 = this.d;
        Unit[] var3 = Unit.bE.a();
        int var4 = 0;

        for(int var5 = Unit.bE.size(); var4 < var5; ++var4) {
            Unit var6 = var3[var4];
            if (var6.bV || (int)(var6.xCord * var1) != var6.dl || (int)(var6.yCord * var2) != var6.dm || var6.bX == null || var6.dn != var6.bX.site) {
                this.a(var6);
            }
        }

    }

    public void a(Unit var1) {
        if (this.e == null) {
            if (GameEngine.getGameEngine().tick != 0) {
                GameEngine.print("updateUnitGeoIndex: areaList not active");
            }

            var1.dl = -1;
            var1.dm = -1;
        } else if (var1.bV) {
            if (var1.dl != -1 && var1.dm != -1) {
                this.e[var1.dl][var1.dm].b(var1);
                var1.dl = -1;
                var1.dm = -1;
            }

        } else {
            int var2 = this.a(var1.xCord);
            int var3 = this.b(var1.yCord);
            int var4 = -2;
            if (var1.bX != null) {
                var4 = var1.bX.site;
            }

            if (var1.dl != var2 || var1.dm != var3 || var1.dn != var4) {
                if (var1.dl != -1 && var1.dm != -1) {
                    this.e[var1.dl][var1.dm].b(var1);
                }

                var1.dl = var2;
                var1.dm = var3;
                var1.dn = var4;
                if (var4 > this.m && this.m < PlayerData.c) {
                    this.m = var4;
                }

                this.e[var1.dl][var1.dm].a(var1);
            }
        }
    }

    public void a(class_484 var1) {
        this.e = new class_1021[32][32];
        this.m = 0;

        for(int var2 = 0; var2 < 32; ++var2) {
            for(int var3 = 0; var3 < 32; ++var3) {
                this.e[var2][var3] = new class_1021();
            }
        }

        this.a = var1.width * var1.n / 32;
        this.b = var1.height * var1.o / 32;
        this.c = 1.0F / (float)this.a;
        this.d = 1.0F / (float)this.b;
    }

    public void b() {
        this.e = (class_1021[][])null;
    }

    public void c(float var1) {
    }
}
