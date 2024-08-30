package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.d.class_447;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.utility.UnitConfig;
import com.corrodinggames.rts.gameFramework.utility.class_675;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import com.corrodinggames.rts.gameFramework.utility.class_694;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.bp
public strictfp class class_395 {
    class_684 a;

    public static class_395 a(String var0, String var1, String var2) {
        return b((class_591)null, var0, var1, var2, false);
    }

    public static class_395 a(class_591 var0, UnitConfig var1, String var2, String var3) {
        String var4 = var1.getValueAsStaticString(var2, var3, (String)null);
        return a(var0, var4, var2, var3, false);
    }

    public static class_395 b(class_591 var0, UnitConfig var1, String var2, String var3) {
        String var4 = var1.getValueAsStaticString(var2, var3, (String)null);
        return a(var0, var4, var2, var3, true);
    }

    public static class_395 a(class_591 var0, String var1, String var2, String var3, boolean var4) {
        if (var0 == null) {
            throw new RuntimeException("meta==null");
        } else {
            return b(var0, var1, var2, var3, var4);
        }
    }

    @SneakyThrows
    public static class_395 b(class_591 var0, String var1, String var2, String var3, boolean var4) {
        class_395 var5 = new class_395();
        if (var1 != null && !"".equals(var1) && !"NONE".equalsIgnoreCase(var1)) {
            ArrayList var6 = class_675.a(var1, ",", false);
            Iterator var7 = var6.iterator();

            while(true) {
                String var8;
                do {
                    if (!var7.hasNext()) {
                        if (var4) {
                            int var23 = var5.a();
                            if (var23 > 1) {
                                throw new CustomException("[" + var2 + "]" + var3 + " Too many units: " + var23 + ", only single unit is allowed here");
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
                    var11 = class_675.b(var8, "(");
                    if (var11 == null) {
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

                class_601 var13 = new class_601();
                var13.a = var3;
                var13.b = var2;
                var13.c = var8;
                if (var0 != null) {
                    var0.p.add(var13);
                } else {
                    var13.a();
                }

                class_396 var14 = new class_396(var13);
                if (var5.a == null) {
                    var5.a = new class_684();
                }

                var14.d = var12;
                if (var10 != null) {
                    if (!var10.endsWith(")")) {
                        throw new CustomException("[" + var2 + "]" + var3 + " UnitList: Expected ')' in '" + var9 + "' of " + var1);
                    }

                    var10 = var10.substring(0, var10.length() - 1);
                    ArrayList var15 = class_675.a(var10, ",", false, false);
                    Iterator var16 = var15.iterator();

                    while(var16.hasNext()) {
                        String var17 = (String)var16.next();
                        if (!var17.trim().equals("")) {
                            String[] var18 = class_675.b(var17, "=");
                            if (var18 == null) {
                                throw new RuntimeException("[" + var2 + "]" + var3 + " UnitList: Unexpected key format for '" + var9 + "' of " + var1);
                            }

                            String var19 = var18[0].trim();
                            String var20 = var18[1].trim();
                            if (var19.equalsIgnoreCase("neutralTeam")) {
                                var14.e = UnitConfig.g(var2, var3, var20);
                            } else if (var19.equalsIgnoreCase("setToTeamOfLastAttacker")) {
                                var14.g = UnitConfig.g(var2, var3, var20);
                            } else if (var19.equalsIgnoreCase("aggressiveTeam")) {
                                var14.f = UnitConfig.g(var2, var3, var20);
                            } else if (var19.equalsIgnoreCase("spawnChance")) {
                                var14.h = UnitConfig.h(var2, var3, var20);
                            } else if (var19.equalsIgnoreCase("maxSpawnLimit")) {
                                var14.i = UnitConfig.i(var2, var3, var20);
                            } else if (var19.equalsIgnoreCase("techLevel")) {
                                var14.m = UnitConfig.i(var2, var3, var20);
                            } else if (var19.equalsIgnoreCase("gridAlign")) {
                                var14.j = UnitConfig.g(var2, var3, var20);
                            } else if (var19.equalsIgnoreCase("skipIfOverlapping")) {
                                var14.k = UnitConfig.g(var2, var3, var20);
                            } else if (var19.equalsIgnoreCase("falling")) {
                                var14.l = UnitConfig.g(var2, var3, var20);
                            } else if (var19.equalsIgnoreCase("transportedUnitsToTransfer")) {
                                var14.w = (short)UnitConfig.i(var2, var3, var20);
                            } else if (var19.equalsIgnoreCase("alwaysStartDirAtZero")) {
                                var14.n = UnitConfig.g(var2, var3, var20);
                            } else if (var19.equalsIgnoreCase("alwayStartDirAtZero")) {
                                var14.n = UnitConfig.g(var2, var3, var20);
                            } else if (var19.equalsIgnoreCase("offsetX")) {
                                var14.o = UnitConfig.h(var2, var3, var20);
                            } else if (var19.equalsIgnoreCase("offsetY")) {
                                var14.p = UnitConfig.h(var2, var3, var20);
                            } else if (var19.equalsIgnoreCase("offsetRandomXY")) {
                                float var21 = UnitConfig.h(var2, var3, var20);
                                var14.s = var21;
                                var14.t = var21;
                            } else if (var19.equalsIgnoreCase("offsetRandomX")) {
                                var14.s = UnitConfig.h(var2, var3, var20);
                            } else if (var19.equalsIgnoreCase("offsetRandomY")) {
                                var14.t = UnitConfig.h(var2, var3, var20);
                            } else if (var19.equalsIgnoreCase("offsetHeight")) {
                                var14.q = UnitConfig.h(var2, var3, var20);
                            } else if (var19.equalsIgnoreCase("offsetRandomDir")) {
                                var14.u = UnitConfig.h(var2, var3, var20);
                            } else if (var19.equalsIgnoreCase("offsetDir")) {
                                var14.r = UnitConfig.h(var2, var3, var20);
                            } else if (var19.equalsIgnoreCase("addResources")) {
                                if (var0 == null) {
                                    throw new CustomException("[" + var2 + "]" + var3 + " addResources not supported from here");
                                }

                                try {
                                    var14.v = class_447.b(var0, var20);
                                } catch (Exception var22) {
                                    var22.printStackTrace();
                                    throw new CustomException("[" + var2 + "]" + var3 + " addResources:" + var22.getMessage());
                                }
                            } else if (var19.equalsIgnoreCase("spawnSource")) {
                                var14.b = UnitConfig.a((String)var20, (class_591)var0, var2, (String)var3, (LogicBoolean)null);
                            } else {
                                if (!var19.equalsIgnoreCase("copyWaypointsFrom")) {
                                    throw new CustomException("[" + var2 + "]" + var3 + " UnitList: Unknown parameter '" + var19 + "' for '" + var9 + "' of " + var1);
                                }

                                var14.c = UnitConfig.a((String)var20, (class_591)var0, var2, (String)var3, (LogicBoolean)null);
                            }
                        }
                    }

                    if (var14.g && var14.e) {
                        throw new CustomException("[" + var2 + "]" + var3 + " Cannot set setToTeamOfLastAttacker and neutralTeam at same time in " + var1);
                    }

                    if (var14.f && var14.e) {
                        throw new CustomException("[" + var2 + "]" + var3 + " Cannot set aggressiveTeam and neutralTeam at same time in " + var1);
                    }

                    if (var14.f && var14.g) {
                        throw new CustomException("[" + var2 + "]" + var3 + " Cannot set aggressiveTeam and setToTeamOfLastAttacker at same time in " + var1);
                    }
                }

                var5.a.add(var14);
            }
        } else {
            return var5;
        }
    }

    public int a() {
        if (this.a != null && this.a.size() != 0) {
            int var1 = 0;

            class_396 var3;
            for(Iterator var2 = this.a.iterator(); var2.hasNext(); var1 += var3.d) {
                var3 = (class_396)var2.next();
            }

            return var1;
        } else {
            return 0;
        }
    }

    public boolean b() {
        return this.a == null || this.a.size() == 0;
    }

    public strictfp void a(class_684 var1, PlayerData var2, Unit var3, boolean var4) {
        this.spawnUnitsAt(0.0F, 0.0F, 0.0F, 0.0F, var2, false, var3, var1, var4);
    }

    public strictfp void spawnUnitsAt(float var1, float var2, float var3, float var4, PlayerData var5, boolean var6, Unit var7) {
        this.spawnUnitsAt(var1, var2, var3, var4, var5, var6, var7, (class_684)null, false);
    }

    public strictfp void spawnUnitsAt(float var1, float var2, float var3, float var4, PlayerData var5, boolean var6, Unit var7, class_684 var8, boolean var9) {
        if (this.a != null && this.a.size() != 0) {
            boolean var10 = false;
            GameEngine var11 = GameEngine.getGameEngine();
            int var12 = 0;
            int var13 = 0;
            Iterator var14 = this.a.iterator();

            while(true) {
                while(var14.hasNext()) {
                    class_396 var15 = (class_396)var14.next();
                    PlayerData var16 = var5;
                    Unit var17 = var7;
                    float var18 = var1;
                    float var19 = var2;
                    float var20 = var3;
                    float var21 = var4;
                    if (var15.b != null) {
                        if (!(var7 instanceof OrderableUnit)) {
                            GameEngine.print("spawnUnitsAt: sourceUnit!=OrderableUnit is:" + Unit.A(var7));
                            continue;
                        }

                        Unit var22 = var15.b.readUnit((OrderableUnit)var7);
                        if (var22 == null) {
                            GameEngine.print("spawnUnitsAt: spawnSource==null");
                            continue;
                        }

                        var16 = var22.bX;
                        var17 = var22;
                        var18 = var22.xCord;
                        var19 = var22.yCord;
                        var20 = var22.zCord;
                        var21 = var22.cg;
                        if (var16 == null) {
                            GameEngine.print("spawnUnitsAt: newSpawnSource.team==null");
                            continue;
                        }
                    }

                    if (!var9) {
                        if (var16.w() > var16.x() + 300) {
                            var10 = true;
                        }
                    } else if (var16.a(true, false) > var16.x() + 20000) {
                        var10 = true;
                    }

                    String var33;
                    if (var10) {
                        var33 = "";
                        if (var17 != null) {
                            var33 = var33 + "source:" + var17.cB();
                        }

                        GameEngine.print("spawnUnitsAt: Skipping, too many units already on team:" + var16.site + " count:" + var16.w() + " " + var33);
                        if (GameEngine.getGameEngine().bl) {
                            var16.W();
                        }
                    } else if (var16.s() > var16.x() + 25000) {
                        var33 = "";
                        if (var17 != null) {
                            var33 = var33 + "source:" + var17.cB();
                        }

                        GameEngine.print("spawnUnitsAt: Failsafe, too many units already on team (including ignored):" + var16.site + " total count:" + var16.s() + " " + var33);
                        if (GameEngine.getGameEngine().bl) {
                            var16.W();
                        }
                    } else {
                        class_31 var32 = var15.a.c();
                        if (var32 != null) {
                            for(int var23 = 0; var23 < var15.d; ++var23) {
                                ++var13;
                                PlayerData var24 = var16;
                                if (var15.h < 1.0F) {
                                    float var25 = class_340.a(var17, 0.0F, 1.0F, var13);
                                    if (var25 > var15.h) {
                                        continue;
                                    }
                                }

                                if (var15.g) {
                                    if (var17 == null || var17.bt == null) {
                                        continue;
                                    }

                                    var24 = var17.bt.bX;
                                    if (var24 == null) {
                                        throw new RuntimeException("setToTeamOfLastAttacker targetTeam==null");
                                    }
                                }

                                if (var12 < var15.i) {
                                    Unit var34 = var32.a();
                                    if (var15.e) {
                                        var24 = PlayerData.i;
                                    }

                                    if (var15.f) {
                                        var24 = PlayerData.h;
                                    }

                                    if (var24 == null) {
                                        throw new RuntimeException("Team==null");
                                    }

                                    var34.f(var24);
                                    var34.B(var17);
                                    var34.xCord = var18;
                                    var34.yCord = var19;
                                    var34.zCord = var20;
                                    if (!var34.bI() && !var15.n) {
                                        var34.cg = var21;
                                    }

                                    var34.zCord += var15.q;
                                    if (var15.m != -1 && var34 instanceof OrderableUnit) {
                                        ((OrderableUnit)var34).a(var15.m);
                                    }

                                    float var26 = var15.r;
                                    if (var15.u != 0.0F) {
                                        var26 += class_340.a(var17, -var15.u, var15.u, var13 * 4 + 3);
                                    }

                                    if (var26 != 0.0F) {
                                        if (var34 instanceof OrderableUnit) {
                                            ((OrderableUnit)var34).i(var26);
                                        } else {
                                            var34.cg += var26;
                                        }
                                    }

                                    var34.xCord += (float)var23;
                                    if (var15.s != 0.0F) {
                                        var34.xCord += class_340.a(var17, -var15.s, var15.s, var13 * 2 + 1);
                                    }

                                    if (var15.t != 0.0F) {
                                        var34.yCord += class_340.a(var17, -var15.t, var15.t, var13 * 3 + 2);
                                    }

                                    if (var15.j) {
                                        var11.bL.b(var34.xCord, var34.yCord);
                                        var34.xCord = (float)var11.bL.T;
                                        var34.yCord = (float)var11.bL.U;
                                        var34.xCord += var34.cZ();
                                        var34.yCord += var34.da();
                                    }

                                    var34.xCord += var15.o;
                                    var34.yCord += var15.p;
                                    ++var12;
                                    if (var15.k && var34 instanceof OrderableUnit && !((OrderableUnit)var34).c((PlayerData)null)) {
                                        var34.ci();
                                    } else {
                                        if (var15.l && var34 instanceof OrderableUnit) {
                                            var34.dc();
                                        }

                                        if (var15.v != null) {
                                            var15.v.h(var34);
                                        }

                                        if (var15.w > 0 && var17 != null && var17 instanceof class_113) {
                                            class_113 var27 = (class_113)var17;
                                            int var28 = var15.w;
                                            if (var27.B != null) {
                                                for(; var28 > 0; --var28) {
                                                    int var29 = -1;

                                                    for(int var30 = var27.B.size() - 1; var30 >= 0; --var30) {
                                                        Unit var31 = (Unit)var27.B.get(var30);
                                                        if (var34.c(var31, true)) {
                                                            var29 = var30;
                                                            break;
                                                        }
                                                    }

                                                    if (var29 == -1) {
                                                        break;
                                                    }

                                                    Unit var36 = (Unit)var27.B.remove(var29);
                                                    class_694.a((Unit)var36, (OrderableUnit)var27);
                                                    var27.D(var36);
                                                    var36.xCord = var34.xCord;
                                                    var36.yCord = var34.yCord;
                                                    var36.cg = var34.cg;
                                                    if (var36 instanceof OrderableUnit) {
                                                        OrderableUnit var37 = (OrderableUnit)var36;
                                                        var37.az();
                                                    }

                                                    if (!var34.e(var36, true)) {
                                                        GameEngine.print("transportedUnitsToTransfer failed for: " + var36.cB() + " to: " + var34.cB());
                                                        var36.ci();
                                                    }
                                                }
                                            }
                                        }

                                        PlayerData.c(var34);
                                        if (var34.bI() && var34 instanceof OrderableUnit) {
                                            var11.bU.a((OrderableUnit)var34);
                                        }

                                        if (var6 && !var34.u()) {
                                            GameEngine.getGameEngine().bS.k(var34);
                                        }

                                        if (var15.c != null) {
                                            if (!(var34 instanceof OrderableUnit)) {
                                                GameEngine.print("copyWaypointsFrom: spawnedUnit!=OrderableUnit is:" + Unit.A(var17));
                                            } else {
                                                Unit var35 = var15.c.readUnit((OrderableUnit)var7);
                                                if (var35 != null) {
                                                    if (!(var35 instanceof OrderableUnit)) {
                                                        GameEngine.print("copyWaypointsFrom: copyWaypointsFrom!=OrderableUnit is:" + Unit.A(var17));
                                                    } else {
                                                        OrderableUnit.a((OrderableUnit)var35, (OrderableUnit)var34);
                                                    }
                                                }
                                            }
                                        }

                                        if (var8 != null) {
                                            var8.add(var34);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                return;
            }
        }
    }

    @Deprecated
    public static class_395 a(GameInputStream var0, boolean var1) {
        int var2 = var0.readInt();
        if (var1 && var2 == 0) {
            return null;
        } else {
            class_395 var3 = new class_395();

            for(int var4 = 0; var4 < var2; ++var4) {
                class_396 var5 = new class_396((class_601)null);
                class_31 var6 = var0.q();
                if (var6 != null) {
                    if (var3.a == null) {
                        var3.a = new class_684();
                    }

                    var5.a = class_591.a(var6);
                }

                if (var0.b() >= 75) {
                    boolean var7 = var0.readBoolean();
                    if (var7) {
                        var5.d = var0.readInt();
                        var5.e = var0.readBoolean();
                        var5.g = var0.readBoolean();
                        if (var0.b() >= 76) {
                            var5.h = var0.readFloat();
                        }
                    }
                }

                if (var6 != null) {
                    var3.a.add(var5);
                }
            }

            return var3;
        }
    }
}
