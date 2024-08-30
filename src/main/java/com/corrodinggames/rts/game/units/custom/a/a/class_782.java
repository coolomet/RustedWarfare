package com.corrodinggames.rts.game.units.custom.a.a;

import android.graphics.PointF;
import com.corrodinggames.rts.game.units.class_32;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.custom.class_113;
import com.corrodinggames.rts.game.units.custom.CustomException;
import com.corrodinggames.rts.game.units.custom.class_395;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.custom.a.class_1037;
import com.corrodinggames.rts.game.units.custom.a.class_776;
import com.corrodinggames.rts.game.units.custom.b.class_826;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.utility.UnitConfig;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.a.a.e
public strictfp class class_782 extends class_776 {
    public class_395 a;
    public ArrayList b;
    public int c;
    public boolean d;
    public boolean e;
    public boolean f;

    @SneakyThrows
    public static void a(class_591 var0, UnitConfig var1, String var2, String var3, class_1037 var4, String var5, boolean var6) {
        class_395 var7 = class_395.a(var0, var1, var2, var3 + "attachments_addNewUnits");
        int var8 = var1.getValueAsIntegerOrDefault(var2, var3 + "attachments_deleteNumUnits", 0);
        boolean var9 = var1.getValueAsBoolean(var2, var3 + "attachments_disconnect", false);
        boolean var10 = var1.getValueAsBoolean(var2, var3 + "attachments_unload", false);
        boolean var11 = var1.getValueAsBoolean(var2, var3 + "disconnectFromParent", false);
        if (!var7.b() || var8 != 0 || var11 || var9 || var10) {
            class_782 var12 = new class_782();
            var12.a = var7;
            String var13 = var1.getValueAsStaticString(var2, "attachments_onlyOnSlots", (String)null);
            if (var13 != null) {
                String[] var14 = var13.split(",");
                String[] var15 = var14;
                int var16 = var14.length;

                for(int var17 = 0; var17 < var16; ++var17) {
                    String var18 = var15[var17];
                    var18 = var18.trim();
                    if (!var18.equals("")) {
                        class_826 var19 = var0.i(var18);
                        if (var12.b == null) {
                            var12.b = new ArrayList();
                        }

                        if (var19 == null) {
                            throw new CustomException("[" + var2 + "]attachments_onlyOnSlots: Could not find attachment slot with name: " + var18);
                        }

                        var12.b.add(var19);
                    }
                }
            }

            var12.c = var8;
            var12.f = var11;
            var12.d = var9;
            var12.e = var10;
            var4.ac.add(var12);
        }

    }

    public boolean a(class_113 var1, class_226 var2, PointF var3, Unit var4, int var5) {
        int var6;
        boolean var18;
        if ((this.d || this.e) && var1.C != null && var1.C.size() > 0) {
            for(var6 = var1.C.size() - 1; var6 >= 0; --var6) {
                Unit var7 = (Unit)var1.C.get(var6);
                if (var7 != null) {
                    if (this.b != null) {
                        boolean var8 = false;
                        Iterator var9 = this.b.iterator();

                        while(var9.hasNext()) {
                            class_826 var10 = (class_826)var9.next();
                            if (var10.a() == var6) {
                                var8 = true;
                                break;
                            }
                        }

                        if (!var8) {
                            continue;
                        }
                    }

                    if (var7 instanceof OrderableUnit) {
                        OrderableUnit var16 = (OrderableUnit)var7;
                        if (this.e) {
                            var18 = var1.B.size() % 2 == 0;
                            var1.a((Unit)var16, true, var18);
                        } else {
                            var16.bx();
                        }
                        break;
                    }

                    GameEngine.log("Failed to deattach unit:" + var7.r().i() + " is not an OrderableUnit");
                }
            }
        }

        Unit var17;
        if (this.c != 0) {
            label144:
            for(var6 = 0; var6 < this.c; ++var6) {
                if (var1.C != null && var1.C.size() > 0) {
                    int var14 = var1.C.size() - 1;

                    while(true) {
                        if (var14 < 0) {
                            continue label144;
                        }

                        var17 = (Unit)var1.C.get(var14);
                        if (var17 != null) {
                            if (this.b == null) {
                                break;
                            }

                            var18 = false;
                            Iterator var19 = this.b.iterator();

                            while(var19.hasNext()) {
                                class_826 var11 = (class_826)var19.next();
                                if (var11.a() == var14) {
                                    var18 = true;
                                    break;
                                }
                            }

                            if (var18) {
                                break;
                            }
                        }

                        --var14;
                    }

                    var17.ci();
                }
            }
        }

        if (this.a != null) {
            class_684 var13 = new class_684();
            this.a.a(var13, var1.bX, var1, true);
            Iterator var15 = var13.iterator();

            label113:
            while(true) {
                while(true) {
                    if (!var15.hasNext()) {
                        break label113;
                    }

                    var17 = (Unit)var15.next();
                    var18 = false;
                    if (!(var17 instanceof OrderableUnit)) {
                        GameEngine.log("Failed to attach unit:" + var17.r().i() + " is not an OrderableUnit");
                    } else {
                        OrderableUnit var20 = (OrderableUnit)var17;
                        class_826 var12;
                        Iterator var21;
                        if (this.b != null) {
                            var21 = this.b.iterator();

                            while(var21.hasNext()) {
                                var12 = (class_826)var21.next();
                                if (var1.a(var12) == null && var1.a(var20, var12)) {
                                    var20.cQ = -9999;
                                    var18 = true;
                                    break;
                                }
                            }
                        } else {
                            var21 = var1.x.aA.iterator();

                            while(var21.hasNext()) {
                                var12 = (class_826)var21.next();
                                if (var1.a(var12) == null && var1.a(var20, var12)) {
                                    var20.cQ = -9999;
                                    var18 = true;
                                    break;
                                }
                            }
                        }

                        if (!var18) {
                            var20.a();
                        }
                    }
                }
            }
        }

        if (this.f) {
            if (var1.cO != null) {
                var1.bx();
            }

            if (var1.cN != null) {
                if (var1.cN instanceof class_32) {
                    ((class_32)var1.cN).e(var1);
                } else {
                    GameEngine.warn("transportedBy is not a TransportInterface");
                    var1.cN = null;
                }
            }
        }

        return true;
    }
}
