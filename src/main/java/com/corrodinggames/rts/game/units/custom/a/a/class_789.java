package com.corrodinggames.rts.game.units.custom.a.a;

import android.graphics.PointF;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.custom.class_113;
import com.corrodinggames.rts.game.units.custom.CustomException;
import com.corrodinggames.rts.game.units.custom.class_395;
import com.corrodinggames.rts.game.units.custom.class_585;
import com.corrodinggames.rts.game.units.custom.class_588;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.custom.a.class_1037;
import com.corrodinggames.rts.game.units.custom.a.class_776;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.utility.UnitConfig;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import lombok.SneakyThrows;

import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.a.a.o
public strictfp class class_789 extends class_776 {
    public class_395 a;
    public int b;
    public class_588 c;
    public boolean d;
    public boolean e;
    public int f = -1;
    public LogicBoolean g;

    @SneakyThrows
    public static void a(class_591 var0, UnitConfig var1, String var2, String var3, class_1037 var4, String var5, boolean var6) {
        class_395 var7 = class_395.a(var0, var1, var2, var3 + "addUnitsIntoTransport");
        int var8 = var1.getValueAsIntegerOrDefault(var2, var3 + "deleteNumUnitsFromTransport", 0);
        class_588 var9 = class_585.a((String)var1.getValueAsStaticString(var2, "deleteNumUnitsFromTransport_onlyWithTags", (String)null), (class_588)null);
        boolean var10 = var1.getValueAsBoolean(var2, var3 + "startUnloadingTransport", false);
        boolean var11 = var1.getValueAsBoolean(var2, var3 + "forceUnloadTransportNow", false);
        int var12 = var1.getValueAsIntegerOrDefault(var2, var3 + "forceUnloadTransportNow_onlyOnSlot", -1);
        LogicBoolean var13 = var1.b(var0, var2, var3 + "transportTargetNow", (LogicBoolean)null);
        if (var12 != -1 && !var11) {
            throw new CustomException("forceUnloadTransportNow_onlyOnSlot expects forceUnloadTransportNow");
        } else {
            if (!var7.b() || var8 > 0 || var10 || var11 || var13 != null) {
                class_789 var14 = new class_789();
                if (!var7.b()) {
                    var14.a = var7;
                }

                if (var8 > 0) {
                    var14.b = var8;
                    var14.c = var9;
                }

                var14.d = var10;
                var14.e = var11;
                var14.f = var12;
                var14.g = var13;
                var4.ac.add(var14);
            }

        }
    }

    public boolean a(class_113 var1, class_226 var2, PointF var3, Unit var4, int var5) {
        int var6;
        Unit var8;
        if (this.b != 0) {
            for(var6 = 0; var6 < this.b; ++var6) {
                if (var1.B.size() > 0) {
                    for(int var7 = var1.B.size() - 1; var7 >= 0; --var7) {
                        var8 = (Unit)var1.B.get(var7);
                        if (var8 == null) {
                            GameEngine.print("deleteNumUnitsFromTransport unit==null");
                        } else if (this.c == null || class_585.a(this.c, var8.de())) {
                            var1.B.remove(var7);
                            var1.D(var8);
                            if (var8 != null) {
                                var8.ci();
                            }
                            break;
                        }
                    }
                }
            }
        }

        if (this.a != null) {
            class_684 var9 = new class_684();
            this.a.a(var9, var1.bX, var1, false);
            Iterator var10 = var9.iterator();

            while(var10.hasNext()) {
                var8 = (Unit)var10.next();
                var8.xCord = var1.xCord;
                var8.yCord = var1.yCord;
                var8.zCord = var1.zCord;
                var1.C(var8);
            }
        }

        if (this.d) {
            var1.L();
        }

        if (this.e) {
            for(var6 = var1.B.size() - 1; var6 >= 0; --var6) {
                if (this.f == -1 || this.f == var6) {
                    boolean var12 = var1.B.size() % 2 == 0;
                    var1.a((Unit)var1.B.get(var6), true, var12);
                }
            }
        }

        if (this.g != null) {
            Unit var11 = this.g.readUnit(var1);
            if (var11 != null && var11.bL && var1.d(var11, true)) {
                var1.C(var1);
            }
        }

        return true;
    }
}
