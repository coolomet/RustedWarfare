package com.corrodinggames.rts.game.units.custom.a.a;

import android.graphics.PointF;
import com.corrodinggames.rts.game.Side;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.custom.*;
import com.corrodinggames.rts.game.units.custom.a.class_1037;
import com.corrodinggames.rts.game.units.custom.a.class_776;
import com.corrodinggames.rts.game.units.custom.d.class_447;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.UnitReference;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.utility.UnitConfig;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import lombok.SneakyThrows;

import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.a.a.m
public strictfp class class_788 extends class_776 {
    public class_447 a;
    public boolean b;
    public boolean c;
    public float d = -1.0F;
    public Side e;
    public LogicBoolean f;
    public class_588 g;
    public boolean h = true;
    public class_447 i;
    public UnitReference j;
    public int k = 1;
    public class_598 l;
    public class_598 m;
    public class_598 n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s = false;
    public static final class_684 t = new class_684();
    public static final class_310 u = new class_310();

    @SneakyThrows
    public static void a(class_591 var0, UnitConfig var1, String var2, String var3, class_1037 var4, String var5, boolean var6) {
        boolean var7 = var1.getValueAsBoolean(var2, var3 + "takeResources_includeUnitsInTransport", false);
        boolean var8 = var1.getValueAsBoolean(var2, var3 + "takeResources_includeParent", false);
        LogicBoolean var9 = var1.b(var0, var2, var3 + "takeResources_includeReference", (LogicBoolean)null);
        float var10 = var1.getValueAsFloatOrDefault(var2, var3 + "takeResources_includeUnitsWithinRange", -1.0F);
        boolean var11 = var1.getValueAsBoolean(var2, var3 + "takeResources_searchOnly", false);
        class_447 var12 = class_447.a(var0, var1, var2, var3 + "takeResources", true);
        if (var11 && var12 != null && !var12.c()) {
            throw new CustomException("[" + var2 + "]takeResources not supported with takeResources_searchOnly");
        } else {
            boolean var13 = var1.getValueAsBoolean(var2, var3 + "takeResources_saveFirstUnitToCustomTarget1", false);
            boolean var14 = var1.getValueAsBoolean(var2, var3 + "takeResources_saveFirstUnitToCustomTarget2", false);
            if (!var7 && !var8 && var10 < 0.0F && var9 == null) {
                if (var12 != null && !var12.c()) {
                    throw new CustomException("[" + var2 + "]takeResources requires an include (eg: takeResources_includeUnitsWithinRange, takeResources_includeUnitsInTransport) otherwise no results would be found");
                } else if (var11) {
                    throw new CustomException("[" + var2 + "]takeResources_searchOnly requires an include (eg: takeResources_includeUnitsWithinRange) otherwise no results would be found");
                }
            } else {
                class_788 var15 = new class_788();
                var4.ac.add(var15);
                var15.b = var7;
                var15.d = var10;
                var15.c = var8;
                var15.f = var9;
                var15.a = var12;
                var15.s = var1.getValueAsBoolean(var2, var3 + "takeResources_directTransferStoppingAtZero", var15.s);
                var15.e = (Side)var1.a((String)var2, "takeResources_includeUnitsWithinRange_team", (Enum) Side.OWN, (Class)Side.class);
                var15.g = var1.a((class_591)var0, var2, (String)(var3 + "takeResources_excludeUnitsWithoutTags"), (class_588)null);
                var15.j = UnitReference.parseUnitReferenceFromConf(var0, var1, var2, var3 + "takeResources_excludeUnitsWithoutCustomTarget1EqualTo", (UnitReference)null);
                if (var15.s) {
                    var15.h = false;
                }

                var15.h = var1.getValueAsBoolean(var2, var3 + "takeResources_excludeUnitsWithoutAllResources", var15.h);
                if (var11) {
                    var15.k = 200;
                    var15.q = true;
                    var15.r = true;
                }

                var15.k = var1.getValueAsIntegerOrDefault(var2, var3 + "takeResources_maxUnits", var15.k);
                var15.l = var1.a((class_591)var0, var2, (String)(var3 + "takeResources_triggerActionIfAnyCollected"), (class_598)null);
                var15.m = var1.a((class_591)var0, var2, (String)(var3 + "takeResources_triggerActionIfNoneCollected"), (class_598)null);
                var15.n = var1.a((class_591)var0, var2, (String)(var3 + "takeResources_triggerActionForEach"), (class_598)null);
                var15.o = var13;
                var15.p = var14;
                var15.q = var1.getValueAsBoolean(var2, var3 + "takeResources_discardCollected", var15.q);
                var15.r = var1.getValueAsBoolean(var2, var3 + "takeResources_keepResourcesOnTarget", var15.r);
                if (!var11 || var15.q && var15.r) {
                    var15.i = class_447.a(var0, var1, var2, var3 + "takeResources_excludeUnitsWithTheseResources", true);
                    if (var15.i != null && var15.i.c()) {
                        var15.i = null;
                    }

                    if (var15.s) {
                        if (var15.a.e()) {
                            throw new CustomException("[" + var2 + "]takeResources_directTransferStoppingAtZero:true only supports custom resources right now");
                        }

                        if (var15.h) {
                            throw new CustomException("[" + var2 + "]takeResources_directTransferStoppingAtZero:true is not supported at the same time as takeResources_excludeUnitsWithoutAllResources:true");
                        }

                        if (var15.r) {
                            throw new CustomException("[" + var2 + "]takeResources_directTransferStoppingAtZero:true is not supported at the same time as takeResources_keepResourcesOnTarget:true");
                        }

                        if (var15.q) {
                            throw new CustomException("[" + var2 + "]takeResources_directTransferStoppingAtZero:true is not supported at the same time as takeResources_discardCollected:true");
                        }
                    }

                } else {
                    throw new CustomException("[" + var2 + "]takeResources_searchOnly shortcut expects takeResources_discardCollected and takeResources_keepResourcesOnTarget to be true");
                }
            }
        }
    }

    public boolean a(class_113 var1, class_226 var2, PointF var3, Unit var4, int var5) {
        class_684 var6 = t;
        var6.clear();
        Unit var8;
        if (this.b) {
            Iterator var7 = var1.B.iterator();

            while(var7.hasNext()) {
                var8 = (Unit)var7.next();
                if (var8 != null && !var8.bV) {
                    var6.add(var8);
                }
            }
        }

        if (this.c) {
            if (var1.cO != null) {
                var6.add(var1.cO);
            } else if (var1.cN != null) {
                var6.add(var1.cO);
            }
        }

        Unit var15;
        if (this.f != null) {
            var15 = this.f.readUnit(var1);
            if (var15 != null && !var15.bV) {
                var6.add(var15);
            }
        }

        if (this.d > 0.0F) {
            u.b = this.d * this.d;
            u.a = this.g;
            u.c = true;
            u.d = this.e;
            u.e = var6;
            GameEngine var16 = GameEngine.getGameEngine();
            var16.cc.a(var1.xCord, var1.yCord, this.d, var1, 0.0F, u);
        }

        int var17;
        if (this.g != null) {
            for(var17 = var6.size() - 1; var17 >= 0; --var17) {
                var8 = (Unit)var6.get(var17);
                if (!class_585.a(this.g, var8.de())) {
                    var6.remove(var17);
                }
            }
        }

        if (this.h) {
            for(var17 = var6.size() - 1; var17 >= 0; --var17) {
                var8 = (Unit)var6.get(var17);
                if (!this.a.b(var8)) {
                    var6.remove(var17);
                }
            }
        }

        if (this.i != null) {
            for(var17 = var6.size() - 1; var17 >= 0; --var17) {
                var8 = (Unit)var6.get(var17);
                if (this.i.b(var8)) {
                    var6.remove(var17);
                }
            }
        }

        Unit var9;
        if (this.j != null) {
            var15 = this.j.get((OrderableUnit)var1);

            for(int var18 = var6.size() - 1; var18 >= 0; --var18) {
                var9 = (Unit)var6.get(var18);
                if (var9.bu != var15) {
                    var6.remove(var18);
                }
            }
        }

        if (this.n != null) {
            var6 = new class_684(var6);
        }

        boolean var20 = false;
        boolean var19 = false;
        var9 = null;
        int var10 = 0;
        int var11 = 0;

        for(int var12 = 0; var12 < var6.size(); ++var12) {
            Unit var13 = (Unit)var6.get(var12);
            if (var9 == null) {
                var9 = var13;
            }

            if (this.s) {
                boolean var14 = this.a.a((Unit)var13, (Unit)var1);
                if (!var14) {
                    continue;
                }
            } else {
                if (!this.r) {
                    this.a.a(var13);
                }

                if (!this.q) {
                    this.a.h(var1);
                }
            }

            if (this.n != null && var13 != null) {
                PointF var21 = new PointF(var13.xCord, var13.yCord);
                this.n.a(var1, var21, var13, var5 + 1, var11);
                ++var11;
            }

            var20 = true;
            ++var10;
            if (var10 >= this.k) {
                var19 = true;
                break;
            }
        }

        if (var9 != null) {
            if (this.o) {
                var1.bu = var9;
            }

            if (this.p) {
                var1.bv = var9;
            }
        }

        if (var20) {
            if (this.l != null) {
                this.l.a(var1, var3, var4, var5 + 1, 0);
            }
        } else if (this.m != null) {
            this.m.a(var1, var3, var4, var5 + 1, 0);
        }

        var6.clear();
        return true;
    }
}
