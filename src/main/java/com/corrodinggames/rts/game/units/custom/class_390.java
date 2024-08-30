package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.game.Projectile;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.utility.UnitConfig;
import com.corrodinggames.rts.gameFramework.utility.class_675;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.bi
public strictfp class class_390 {
    class_684 a;
    public static final class_312 b = new class_312();

    public static class_390 a(class_591 var0, UnitConfig var1, String var2, String var3, class_390 var4) {
        String var5 = var1.getValueAsStaticString(var2, var3, (String)null);
        return var5 == null ? var4 : a(var0, var5, var2, var3, false);
    }

    public static class_390 a(class_591 var0, String var1, String var2, String var3, boolean var4) {
        if (var0 == null) {
            throw new RuntimeException("meta==null");
        } else {
            return b(var0, var1, var2, var3, var4);
        }
    }

    @SneakyThrows
    public static class_390 b(class_591 var0, String var1, String var2, String var3, boolean var4) {
        class_390 var5 = new class_390();
        if (var1 != null && !"".equals(var1) && !"NONE".equalsIgnoreCase(var1)) {
            if (var0 == null) {
                throw new CustomException("meta required");
            } else {
                ArrayList var6 = class_675.a(var1, ",", false);
                Iterator var7 = var6.iterator();

                while(true) {
                    String var8;
                    do {
                        if (!var7.hasNext()) {
                            if (var4) {
                                int var24 = var5.a();
                                if (var24 > 1) {
                                    throw new CustomException("[" + var2 + "]" + var3 + " Too many units: " + var24 + ", only single unit is allowed here");
                                }
                            }

                            return var5;
                        }

                        var8 = (String)var7.next();
                        var8 = var8.trim();
                    } while("".equals(var8));

                    String var9 = var8;
                    String var10 = null;
                    String[] var11;
                    if (var8.contains("(") && var8.contains(")")) {
                        var11 = var8.split("\\(");
                        if (var11.length != 2) {
                            throw new CustomException("[" + var2 + "]" + var3 + " UnitList: Unexpected format for '" + var8 + "' of " + var1);
                        }

                        var8 = var11[0];
                        var10 = var11[1].trim();
                    }

                    var11 = var8.split("\\*");
                    var8 = var11[0];
                    int var12 = 1;
                    if (var11.length >= 2) {
                        var12 = Integer.parseInt(var11[1]);
                    }

                    class_603 var13 = var0.b(var8, var3, var2);
                    class_394 var14 = new class_394(var13);
                    if (var5.a == null) {
                        var5.a = new class_684();
                    }

                    var14.b = var12;
                    if (var10 != null) {
                        if (!var10.endsWith(")")) {
                            throw new CustomException("[" + var2 + "]" + var3 + " UnitList: Expected ')' in '" + var9 + "' of " + var1);
                        }

                        var10 = var10.substring(0, var10.length() - 1);
                        String[] var15 = var10.split("\\,");
                        String[] var16 = var15;
                        int var17 = var15.length;

                        for(int var18 = 0; var18 < var17; ++var18) {
                            String var19 = var16[var18];
                            if (!var19.trim().equals("")) {
                                String[] var20 = var19.split("\\=");
                                if (var20.length != 2) {
                                    throw new RuntimeException("[" + var2 + "]" + var3 + " UnitList: Unexpected key format for '" + var9 + "' of " + var1);
                                }

                                String var21 = var20[0].trim();
                                String var22 = var20[1].trim();
                                if (var21.equalsIgnoreCase("spawnChance")) {
                                    var14.c = UnitConfig.h(var2, var3, var22);
                                } else if (var21.equalsIgnoreCase("maxSpawnLimit")) {
                                    var14.d = UnitConfig.i(var2, var3, var22);
                                } else if (var21.equalsIgnoreCase("recursionLimit")) {
                                    var14.n = UnitConfig.i(var2, var3, var22);
                                } else if (!var21.equalsIgnoreCase("offsetX") && !var21.equalsIgnoreCase("xOffsetAbsolute")) {
                                    if (!var21.equalsIgnoreCase("offsetY") && !var21.equalsIgnoreCase("yOffsetAbsolute")) {
                                        if (var21.equalsIgnoreCase("xOffsetRelative")) {
                                            var14.i = UnitConfig.h(var2, var3, var22);
                                        } else if (var21.equalsIgnoreCase("yOffsetRelative")) {
                                            var14.j = UnitConfig.h(var2, var3, var22);
                                        } else if (var21.equalsIgnoreCase("offsetRandomXY")) {
                                            float var23 = UnitConfig.h(var2, var3, var22);
                                            var14.k = var23;
                                            var14.l = var23;
                                        } else if (var21.equalsIgnoreCase("offsetRandomX")) {
                                            var14.k = UnitConfig.h(var2, var3, var22);
                                        } else if (var21.equalsIgnoreCase("offsetRandomY")) {
                                            var14.l = UnitConfig.h(var2, var3, var22);
                                        } else if (var21.equalsIgnoreCase("offsetHeight")) {
                                            var14.g = UnitConfig.h(var2, var3, var22);
                                        } else if (var21.equalsIgnoreCase("offsetRandomDir")) {
                                            var14.m = UnitConfig.h(var2, var3, var22);
                                        } else {
                                            if (!var21.equalsIgnoreCase("offsetDir")) {
                                                throw new CustomException("[" + var2 + "]" + var3 + " ProjectileList: Unknown parameter '" + var21 + "' for '" + var9 + "' of " + var1);
                                            }

                                            var14.h = UnitConfig.h(var2, var3, var22);
                                        }
                                    } else {
                                        var14.f = UnitConfig.h(var2, var3, var22);
                                    }
                                } else {
                                    var14.e = UnitConfig.h(var2, var3, var22);
                                }
                            }
                        }
                    }

                    var5.a.add(var14);
                }
            }
        } else {
            return var5;
        }
    }

    public int a() {
        if (this.a != null && this.a.size() != 0) {
            int var1 = 0;

            class_394 var3;
            for(Iterator var2 = this.a.iterator(); var2.hasNext(); var1 += var3.b) {
                var3 = (class_394)var2.next();
            }

            return var1;
        } else {
            return 0;
        }
    }

    public void a(float var1, float var2, float var3, float var4, Unit var5, class_684 var6, boolean var7, int var8, Projectile var9, Unit var10) {
        if (this.a != null && this.a.size() != 0) {
            int var11 = 0;
            int var12 = 0;
            if (var5 == null) {
                GameEngine.log("projectile spawn At: Skipping, source unit required");
            } else {
                Iterator var13 = this.a.iterator();

                while(true) {
                    while(var13.hasNext()) {
                        class_394 var14 = (class_394)var13.next();
                        class_164 var15 = var14.a.f();
                        if (var15 == null) {
                            GameEngine.log("projectile spawn At: Skipping, projectileType==null");
                        } else {
                            for(int var16 = 0; var16 < var14.b; ++var16) {
                                ++var12;
                                float var17;
                                if (var14.c < 1.0F) {
                                    var17 = class_340.a(var5, 0.0F, 1.0F, var12);
                                    if (var17 > var14.c) {
                                        continue;
                                    }
                                }

                                if (var11 < var14.d && var8 <= var14.n) {
                                    var17 = var1 + var14.e;
                                    float var18 = var2 + var14.f;
                                    float var19 = var3 + var14.g;
                                    float var20 = var4 + var14.h;
                                    if (var14.m != 0.0F) {
                                        var20 += class_340.a(var5, -var14.m, var14.m, var12 * 4 + 3);
                                    }

                                    if (var14.k != 0.0F) {
                                        var17 += class_340.a(var5, -var14.k, var14.k, var12 * 2 + 1);
                                    }

                                    if (var14.l != 0.0F) {
                                        var18 += class_340.a(var5, -var14.l, var14.l, var12 * 3 + 2);
                                    }

                                    if (var14.i != 0.0F || var14.j != 0.0F) {
                                        float var21 = class_340.k(var4);
                                        float var22 = class_340.j(var4);
                                        float var23 = var14.i;
                                        float var24 = var14.j;
                                        var17 += var21 * var24 - var22 * var23;
                                        var18 += var22 * var24 + var21 * var23;
                                    }

                                    byte var25 = -1;
                                    Projectile var26 = class_113.a(var5, var25, var15, var17, var18, var19, var20);
                                    var26.aD = var8;
                                    if (var9 != null && var5 != null) {
                                        var15.a(var5, var26, var9.l, var9.n, var9.o, -1.0F);
                                    }

                                    this.a(var26, var14, var5, var9, var10);
                                    ++var11;
                                    if (var6 != null) {
                                        var6.add(var26);
                                    }
                                }
                            }
                        }
                    }

                    return;
                }
            }
        }
    }

    public void a(Projectile var1, class_394 var2, Unit var3, Projectile var4, Unit var5) {
        GameEngine var6 = GameEngine.getGameEngine();
        b.a = var1;
        b.b = var2;
        b.c = var3;
        b.d = var4;
        b.e = var5;
        float var7 = var1.xCord;
        float var8 = var1.yCord;
        float var9 = 100.0F;
        var6.cc.a(var7, var8, var9, (OrderableUnit)null, 0.0F, b);
    }
}
