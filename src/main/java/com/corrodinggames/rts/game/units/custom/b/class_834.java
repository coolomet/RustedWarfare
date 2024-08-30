package com.corrodinggames.rts.game.units.custom.b;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.a.class_230;
import com.corrodinggames.rts.game.units.custom.class_113;
import com.corrodinggames.rts.game.units.custom.CustomException;
import com.corrodinggames.rts.game.units.custom.class_395;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.f.class_517;
import com.corrodinggames.rts.gameFramework.utility.UnitConfig;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import com.corrodinggames.rts.gameFramework.utility.class_694;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.b.m
public final strictfp class class_834 extends class_827 {
    public static final class_834 a = new class_834();

    public static strictfp void a(class_591 var0, UnitConfig var1) {
        String var2 = "attachment_";
        class_684 var3 = var1.e(var2);
        if (var3.size() > 0) {
            var0.a((class_827)a);
            short var4 = 0;
            Iterator var5 = var3.iterator();

            while(var5.hasNext()) {
                String var6 = (String)var5.next();
                String var7 = var6.substring(var2.length());
                class_826 var8 = new class_826();
                a(var8, var0, var1, var6, var7);
                var8.b = var7;
                var8.a = var4++;
                var0.aA.add(var8);
            }
        }

    }

    @SneakyThrows
    public static strictfp void a(class_826 var0, class_591 var1, UnitConfig var2, String var3, String var4) {
        var0.c = var2.i(var3, "x");
        var0.d = var2.i(var3, "y");
        var0.e = var2.getValueAsFloatOrDefault(var3, "height", var0.e);
        var0.i = var2.getValueAsBoolean(var3, "lockDir", var0.i);
        var0.j = var2.getValueAsBoolean(var3, "redirectDamageToParent", var0.j);
        var0.k = var2.getValueAsBoolean(var3, "redirectDamageToParent_shieldOnly", var0.k);
        if (!var0.j && var0.k) {
            throw new CustomException("[" + var3 + "] redirectDamageToParent_shieldOnly requires redirectDamageToParent");
        } else {
            var0.l = var2.getValueAsBoolean(var3, "canBeAttackedAndDamaged", var0.l);
            var0.m = var2.getValueAsBoolean(var3, "isUnselectable", var0.m);
            var0.n = var2.getValueAsBoolean(var3, "isUnselectableAsTarget", var0.m);
            var0.o = var2.getValueAsBoolean(var3, "isVisible", var0.o);
            var0.p = var2.getValueAsBoolean(var3, "showMiniHp", var0.p);
            var0.q = var2.getValueAsBoolean(var3, "hideHp", var0.q);
            var0.N = var2.a((class_591)var1, var3, (String)"showAllActionsFrom", (LogicBoolean)null);
            if (LogicBoolean.isStaticFalse(var0.N)) {
                var0.N = null;
            }

            Float var5 = var2.getValueAsFloatOrDefault(var3, "idleDir", (Float)null);
            Float var6 = var2.getValueAsFloatOrDefault(var3, "idleDirReversing", (Float)null);
            if (var5 != null) {
                var0.f = var5;
                var0.g = var5;
            }

            if (var6 != null) {
                var0.g = var6;
            } else {
                var0.g = var0.f;
            }

            var0.h = var2.getValueAsBoolean(var3, "resetRotationWhenNotAttacking", false);
            var0.r = var2.getValueAsBoolean(var3, "rotateWithParent", var0.r);
            var0.s = var2.getValueAsBoolean(var3, "lockLegMovement", var0.s);
            var0.t = var2.getValueAsBoolean(var3, "freezeLegMovement", var0.t);
            var0.u = var2.getValueAsBoolean(var3, "lockRotation", var0.u);
            if (var0.u && var0.h) {
                throw new CustomException("[" + var3 + "] Cannot use lockRotation and resetRotationWhenIdle at same time");
            } else {
                var0.v = var2.getValueAsBoolean(var3, "keepAliveWhenParentDies", var0.v);
                var0.w = class_395.b(var1, var2, var3, "onCreateSpawnUnitOf");
                if (var0.w.b()) {
                    var0.w = null;
                }

                var0.x = var2.getValueAsBoolean(var3, "createIncompleteIfParentIs", var0.x);
                var0.y = var2.getValueAsBoolean(var3, "onConvertKeepExistingUnitInSameSlot", var0.y);
                var0.z = var2.getValueAsBoolean(var3, "onParentTeamChangeKeepCurrentTeam", var0.z);
                var0.B = var2.getValueAsBoolean(var3, "setDrawLayerOnBottom", var0.B);
                if (var0.B) {
                    var0.A = false;
                }

                var0.A = var2.getValueAsBoolean(var3, "setDrawLayerOnTop", var0.A);
                if (var0.A && var0.B) {
                    throw new CustomException("[" + var3 + "] Cannot use setDrawLayerOnTop and setDrawLayerOnBottom at same time");
                } else {
                    var0.D = var2.getValueAsBoolean(var3, "addTransportedUnits", var0.D);
                    var0.E = var2.getValueAsBoolean(var3, "unloadInCurrentPosition", var0.E);
                    var0.F = var2.getValueAsBoolean(var3, "smoothlyBlendPositionWhenExistingUnitAdded", var0.F);
                    if (var0.F) {
                        var0.G = 500.0F;
                    } else {
                        var0.G = 0.0F;
                    }

                    var0.H = var2.getValueAsBoolean(var3, "deattachIfWantingToMove", var0.H);
                    var0.I = var2.getValueAsBoolean(var3, "hidden", var0.I);
                    var0.J = var2.getValueAsBoolean(var3, "prioritizeParentsMainTarget", var0.J);
                    var0.K = var2.getValueAsBoolean(var3, "onlyAttackParentsMainTarget", var0.K);
                    var0.L = var2.getValueAsBoolean(var3, "alwaysAllowedToAttackParentsMainTarget", var0.L);
                    var0.M = var2.getValueAsBoolean(var3, "canAttack", var0.M);
                    var0.O = var2.getValueAsBoolean(var3, "keepWaypointsNeedingMovement", var0.O);
                    if (var0.D) {
                        var1.aB = true;
                    }

                }
            }
        }
    }

    public strictfp void a(class_113 var1, float var2) {
        this.b(var1, var2);
    }

    public strictfp void b(class_113 var1, float var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        class_591 var4 = var1.x;
        class_684 var5 = var4.aA;
        if (var5.a != 0) {
            if (var4.aB) {
                Object[] var6 = var5.a();

                for(int var7 = 0; var7 < var5.a; ++var7) {
                    class_826 var8 = (class_826)var6[var7];
                    if (var8.D && var1.B.a > 0) {
                        OrderableUnit var9 = a(var1, var8);
                        if (var9 == null) {
                            Iterator var10 = var1.B.iterator();

                            while(var10.hasNext()) {
                                Unit var11 = (Unit)var10.next();
                                if (var11 instanceof OrderableUnit && var11.cO == null && var1.a((OrderableUnit)var11, var8)) {
                                    var11.cN = null;
                                    break;
                                }
                            }
                        }
                    }
                }
            }

            class_684 var19 = var1.C;
            if (var19 != null) {
                float var20 = var1.cg - var1.D;
                var1.D = var1.cg;
                Object[] var21 = var19.a();

                for(int var22 = var19.a - 1; var22 >= 0; --var22) {
                    OrderableUnit var23 = (OrderableUnit)var21[var22];
                    if (var23 != null) {
                        if (var23.bV) {
                            var23.bx();
                            var21[var22] = null;
                        } else {
                            if (var1.cN != null) {
                                if (var23.cN == null) {
                                    var23.cN = var1.cN;
                                    var3.bS.l(var23);
                                }
                            } else if (var23.cN != null && var23.cN != var1) {
                                var23.cN = null;
                            }

                            class_826 var24 = (class_826)var5.get(var22);
                            float var12 = class_340.k(var1.cg);
                            float var13 = class_340.j(var1.cg);
                            float var14 = var12 * var24.d - var13 * var24.c;
                            float var15 = var13 * var24.d + var12 * var24.c;
                            var14 += var1.xCord;
                            var15 += var1.yCord;
                            float var16 = var1.zCord + var24.e;
                            float var17;
                            if (class_694.b(var23.cQ, (int)var24.G)) {
                                var17 = 0.05F;
                                var23.xCord += (var14 - var23.xCord) * var17;
                                var23.yCord += (var15 - var23.yCord) * var17;
                                var23.zCord += (var16 - var23.zCord) * var17;
                            } else {
                                var23.xCord = var14;
                                var23.yCord = var15;
                                var23.zCord = var16;
                            }

                            if (var23.cm < 1.0F && var24.x) {
                                var23.r(var1.cm);
                                var23.cn = var1.cm;
                            }

                            if (var24.A) {
                                if (var23.em <= var1.em) {
                                    int var25 = 0;
                                    if (var23 instanceof class_113) {
                                        var25 = ((class_113)var23).x.cI;
                                    }

                                    var23.em = var1.em;
                                    var23.en = var1.en + 1 + var25;
                                }
                            } else if (var24.B && var23.em >= var1.em) {
                                var23.em = var1.em;
                                var23.en = var1.en - 1;
                            }

                            if (var1.ci) {
                                var17 = var1.cg + var24.g;
                            } else {
                                var17 = var1.cg + var24.f;
                            }

                            if (!var23.bI()) {
                                if (var24.u) {
                                    var23.h(var17);
                                } else {
                                    if (var20 != 0.0F && var24.r) {
                                        var23.i(var20);
                                    }

                                    if (var24.h && var23.R == null) {
                                        var23.c(var2, var17);
                                    }
                                }
                            }

                            if (var24.K) {
                                var23.R = var1.R;
                                var23.S = 5.0F;
                            }

                            if (var24.L && var23.R == null) {
                                var23.R = var1.R;
                            }

                            if (var24.J && var1.R != null && var23.R != var1.R) {
                                boolean var18 = false;
                                if (var24.L) {
                                    var18 = true;
                                }

                                if (var23.a(var1.R, var18)) {
                                    var23.R = var1.R;
                                    var23.S = 5.0F;
                                }
                            }

                            if (var23 instanceof class_113) {
                                class_113 var26 = (class_113)var23;
                                if (var24.s) {
                                    var26.dP = var26.xCord;
                                    var26.dP = var26.yCord;
                                    var26.dR = var26.zCord;
                                }
                            }
                        }
                    }
                }

            }
        }
    }

    public strictfp void a(class_113 var1, boolean var2) {
        class_684 var3 = var1.C;
        if (var3 != null) {
            class_684 var4 = var1.x.aA;
            Object[] var5 = var3.a();

            for(int var6 = var3.a - 1; var6 >= 0; --var6) {
                OrderableUnit var7 = (OrderableUnit)var5[var6];
                if (var7 != null) {
                    class_826 var8 = (class_826)var4.get(var6);
                    var7.bx();
                    var5[var6] = null;
                    if (var2 && !var8.v) {
                        var7.ci();
                    }
                }
            }

        }
    }

    public strictfp void b(class_113 var1) {
        this.a(var1, true);
    }

    public strictfp void c(class_113 var1) {
        this.a(var1, true);
    }

    public strictfp void a(class_113 var1) {
        boolean var2 = false;
        class_684 var3 = var1.x.aA;
        Object[] var4 = var3.a();

        for(int var5 = var3.a - 1; var5 >= 0; --var5) {
            class_826 var6 = (class_826)var4[var5];
            if (var6.w != null) {
                OrderableUnit var7 = a(var1, var6);
                if (var7 != null) {
                    if (var6.y) {
                        continue;
                    }

                    var7.ci();
                }

                class_684 var8 = new class_684();
                var6.w.a(var8, var1.bX, var1, true);
                if (var8.size() > 1) {
                    GameEngine.print("onCreateSpawnUnitOf: created an extra " + (var8.size() - 1) + " units");

                    for(int var9 = 1; var9 < var8.size(); ++var9) {
                        ((Unit)var8.get(var9)).ci();
                    }
                }

                if (var8.size() == 0) {
                    GameEngine.print("onCreateSpawnUnitOf: Warning no units created");
                } else {
                    Unit var11 = (Unit)var8.get(0);
                    if (!(var11 instanceof OrderableUnit)) {
                        GameEngine.print("onCreateSpawnUnitOf: Warning " + var11.r().i() + " not an orderable unit type, cannot attach");
                        var11.ci();
                    } else {
                        OrderableUnit var10 = (OrderableUnit)var11;
                        if (var1.a(var10, var6)) {
                            var10.cQ = -9999;
                            if (var1.cm < 1.0F && var6.x) {
                                var10.r(var1.cm);
                                var10.cn = var1.cm;
                            }

                            var2 = true;
                        }
                    }
                }
            }
        }

        if (var2) {
            this.b(var1, 0.0F);
        }

    }

    public strictfp void a(class_113 var1, class_591 var2) {
        class_684 var3 = var1.C;
        class_684 var4 = var1.x.aA;
        if (var4.size() == 0) {
            var1.C = null;
        } else if (var3 != null) {
            int var5;
            OrderableUnit var6;
            for(var5 = var3.size() - 1; var5 >= 0; --var5) {
                var6 = (OrderableUnit)var3.get(var5);
                if (var6 != null && var5 >= var4.size()) {
                    var6.ci();
                    var3.remove(var5);
                }
            }

            for(var5 = var3.size() - 1; var5 >= 0; --var5) {
                var6 = (OrderableUnit)var3.get(var5);
                if (var6 != null) {
                    var6.cP = (class_826)var4.get(var5);
                }
            }

        }
    }

    public static strictfp class_826 a(class_113 var0, short var1) {
        class_684 var2 = var0.x.aA;
        return var2.a <= var1 ? null : (class_826)var2.get(var1);
    }

    public static strictfp OrderableUnit a(class_113 var0, class_826 var1) {
        class_684 var2 = var0.C;
        if (var2 == null) {
            return null;
        } else {
            short var3 = var1.a;
            return var2.a <= var3 ? null : (OrderableUnit)var2.get(var3);
        }
    }

    public static strictfp boolean a(class_113 var0, class_826 var1, OrderableUnit var2) {
        class_591 var3 = var0.x;
        short var4 = var1.a;
        if (var3.aA.a <= var4 && var2 != null) {
            GameEngine.print("setAttachedUnitLookup: slot:" + var4 + " larger than max slot size:" + var3.aA.a);
            return false;
        } else {
            if (var0.C == null) {
                var0.C = new class_684();
            }

            class_684 var5 = var0.C;
            if (var5.size() == 0) {
                var0.D = var0.cg;
            }

            if (var2 == null && var4 >= var5.size()) {
                return true;
            } else {
                while(var5.size() <= var4) {
                    var5.add((Object)null);
                }

                var5.set(var4, var2);
                return true;
            }
        }
    }

    public static strictfp void a(class_113 var0, class_684 var1, boolean var2) {
        class_684 var3 = var0.C;
        if (var3 != null) {
            Iterator var4 = var3.iterator();

            while(true) {
                Unit var5;
                class_826 var6;
                do {
                    do {
                        do {
                            do {
                                if (!var4.hasNext()) {
                                    return;
                                }

                                var5 = (Unit)var4.next();
                            } while(var5 == null);
                        } while(!(var5 instanceof OrderableUnit));

                        var6 = var5.dn();
                    } while(var6 == null);
                } while(var6.N == null);

                ArrayList var7 = var5.N();
                Iterator var8 = var7.iterator();

                while(var8.hasNext()) {
                    class_226 var9 = (class_226)var8.next();
                    boolean var10;
                    if (var2) {
                        var10 = class_517.a((LogicBoolean)var6.N, (OrderableUnit)var0);
                    } else {
                        var10 = var6.N.read(var0);
                    }

                    if (var10) {
                        class_230 var11 = new class_230(var9, (OrderableUnit)var5, var9.N());
                        var1.add(var11);
                    }
                }
            }
        }
    }
}
