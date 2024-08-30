package com.corrodinggames.rts.game.units.custom.a.a;

import android.graphics.PointF;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.custom.class_113;
import com.corrodinggames.rts.game.units.custom.CustomException;
import com.corrodinggames.rts.game.units.custom.class_398;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.custom.class_598;
import com.corrodinggames.rts.game.units.custom.a.class_1037;
import com.corrodinggames.rts.game.units.custom.a.class_776;
import com.corrodinggames.rts.game.units.custom.d.class_447;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$ReturnType;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope$CachedWriter;
import com.corrodinggames.rts.game.units.g.class_794;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.utility.Point3DF;
import com.corrodinggames.rts.gameFramework.utility.UnitConfig;
import lombok.SneakyThrows;

import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.a.a.j
public strictfp class class_779 extends class_776 {
    boolean a;
    boolean b;
    boolean c;
    LogicBoolean d;
    LogicBoolean e;
    LogicBoolean f;
    LogicBoolean g;
    boolean h;
    float i;
    float j;
    class_598 k;
    boolean l;
    boolean m;
    float n = -1.0F;
    Point3DF o;
    boolean p;
    VariableScope$CachedWriter q;

    @SneakyThrows
    public static void a(class_591 var0, UnitConfig var1, String var2, String var3, class_1037 var4, String var5, boolean var6) {
        boolean var7 = var1.getValueAsBoolean(var2, var3 + "resetUnitStats", false);
        String var8 = var1.getValueAsStaticString(var2, var3 + "setUnitStats", (String)null);
        if (var7 || var8 != null) {
            class_779 var9 = new class_779();
            var9.p = var7;
            if (var8 != null) {
                var9.q = class_398.a(var8, var0, var2, var3 + "setUnitStats");
            }

            var4.ac.add(var9);
        }

        boolean var25 = var1.getValueAsBoolean(var2, var3 + "deleteSelf", false);
        if (var25) {
            class_779 var10 = new class_779();
            var10.a = var25;
            var4.ac.add(var10);
        }

        boolean var26 = var1.getValueAsBoolean(var2, var3 + "switchToNeutralTeam", false);
        boolean var11 = var1.getValueAsBoolean(var2, var3 + "switchToAggressiveTeam", false);
        LogicBoolean var12 = var1.a((class_591)var0, (String)var2, var3 + "switchToTeam", (LogicBoolean)null, (LogicBoolean$ReturnType)LogicBoolean$ReturnType.number);
        if (var26 || var11 || var12 != null) {
            class_779 var13 = new class_779();
            var13.b = var26;
            var13.c = var11;
            var13.d = var12;
            var4.ac.add(var13);
        }

        LogicBoolean var27 = var1.c(var0, var2, var3 + "setBodyRotation", (LogicBoolean)null);
        if (var27 != null) {
            class_779 var14 = new class_779();
            var14.e = var27;
            var4.ac.add(var14);
        }

        LogicBoolean var28 = var1.c(var0, var2, var3 + "setHeight", (LogicBoolean)null);
        if (var28 != null) {
            class_779 var15 = new class_779();
            var15.f = var28;
            var4.ac.add(var15);
        }

        LogicBoolean var29 = var1.b(var0, var2, var3 + "teleportTo", (LogicBoolean)null);
        if (var29 != null) {
            class_779 var16 = new class_779();
            var16.g = var29;
            var4.ac.add(var16);
        }

        float var30 = var1.getValueAsFloatOrDefault(var2, var3 + "setBuilt", -1.0F);
        if (var30 > 1.0F) {
            throw new CustomException("[" + var2 + "] setBuilt cannot be greater than 1");
        } else {
            boolean var17 = var1.getValueAsBoolean(var2, var3 + "clearAllActionCooldowns", false);
            float var18 = var1.c(var2, var3 + "addAllActionCooldownsTime", 0.0F);
            if (var18 == 0.0F) {
                var18 = var1.c(var2, var3 + "addAllActionCooldownsFor", 0.0F);
            }

            float var19 = var1.c(var2, var3 + "addActionCooldownTime", 0.0F);
            if (var19 == 0.0F) {
                var19 = var1.c(var2, var3 + "addActionCooldownFor", 0.0F);
            }

            class_598 var20 = var1.a((class_591)var0, var2, (String)(var3 + "addActionCooldownApplyToActions"), (class_598)null);
            Point3DF var21 = var1.getValueAsPoint3DFOrDefault(var2, var3 + "offsetSelfAbsolute", (Point3DF)null);
            if (var20 != null && var19 <= 0.0F) {
                throw new CustomException("[" + var2 + "]addActionCooldownApplyToActions requires addActionCooldownTime to be set");
            } else {
                boolean var22 = var1.getValueAsBoolean(var2, var3 + "removeAllQueuedItemsWithoutRefund", false);
                boolean var23 = var1.getValueAsBoolean(var2, var3 + "refundAllQueuedItems", false);
                if (var22 && var23) {
                    throw new CustomException("[" + var2 + "]Cannot set removeAllQueuedActionsWithoutRefund and refundAllQueuedActions at the same time, pick one.");
                } else {
                    if (var19 > 0.0F || var18 > 0.0F || var17 || var30 >= 0.0F || var21 != null || var22 || var23) {
                        class_779 var24 = new class_779();
                        var24.h = var17;
                        var24.i = var18;
                        var24.j = var19;
                        var24.k = var20;
                        var24.n = var30;
                        var24.o = var21;
                        var24.l = var22;
                        var24.m = var23;
                        var4.ac.add(var24);
                    }

                }
            }
        }
    }

    public boolean a(class_113 var1, class_226 var2, PointF var3, Unit var4, int var5) {
        if (this.p) {
            var1.y = var1.x.cL;
            var1.totalHealth = (float)var1.y.c;
            if (var1.health > var1.totalHealth) {
                var1.o(var1.totalHealth);
            }

            var1.cA = (float)var1.y.g;
            if (var1.cx > var1.cA) {
                var1.cx = var1.cA;
            }
        }

        if (this.q != null) {
            this.q.writeToUnit(var1);
            class_447.d(var1);
        }

        if (this.a) {
            var1.ci();
            if (var1.bI()) {
                GameEngine var6 = GameEngine.getGameEngine();
                var6.bU.a((OrderableUnit)var1);
            }
        }

        if (this.b) {
            var1.e(PlayerData.i);
        }

        if (this.c) {
            var1.e(PlayerData.h);
        }

        if (this.d != null) {
            int var8 = (int)this.d.readNumber(var1);
            PlayerData var7 = PlayerData.getPlayerData(var8);
            if (var7 != null) {
                var1.e(var7);
            }
        }

        float var9;
        if (this.e != null) {
            var9 = this.e.readNumber(var1);
            var1.h(var9);
        }

        if (this.f != null) {
            var9 = this.f.readNumber(var1);
            var1.zCord = var9;
        }

        if (this.g != null) {
            Unit var10 = this.g.readUnit(var1);
            if (var10 != null) {
                var1.f(var10.xCord, var10.yCord);
            }
        }

        if (this.h) {
            class_794.c(var1, class_226.i);
        }

        if (this.l) {
            var1.i(false);
        }

        if (this.m) {
            var1.i(true);
        }

        if (this.i > 0.0F) {
            class_794.a(var1, class_226.i, (int)this.i);
        }

        if (this.j > 0.0F) {
            if (this.k == null) {
                class_794.a(var1, var2.N(), (int)this.j);
            } else {
                Iterator var12 = this.k.a().iterator();

                while(var12.hasNext()) {
                    class_226 var11 = (class_226)var12.next();
                    class_794.a(var1, var11.N(), (int)this.j);
                }
            }
        }

        if (this.n >= 0.0F) {
            var1.r(this.n);
            var1.cn = this.n;
        }

        if (this.o != null) {
            var1.b(var1.xCord + this.o.x, var1.yCord + this.o.y);
            var1.zCord += this.o.z;
            var1.cK = true;
        }

        return true;
    }
}
