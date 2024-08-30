package com.corrodinggames.rts.gameFramework.n;

import android.graphics.PointF;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.a.class_1059;
import com.corrodinggames.rts.game.units.custom.class_585;
import com.corrodinggames.rts.game.units.custom.class_588;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.SyncPacket;
import com.corrodinggames.rts.gameFramework.f.class_532;
import com.corrodinggames.rts.gameFramework.f.class_536;
import com.corrodinggames.rts.gameFramework.n.a.class_1005;
import com.corrodinggames.rts.gameFramework.net.GameNetEngine;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.n.d
public strictfp class class_622 {
    public static void a(class_70 var0, class_637 var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        boolean var3 = false;
        if (!var1.j) {
            var3 = true;
        }

        var0.a(var1);
        var1.i = true;
        var1.j = true;
        var1.k = var2.by;
        boolean var4 = false;
        String var5;
        String var7;
        String var8;
        if (var1.A != null) {
            var5 = var1.A.b();
            class_532 var6 = var2.bS.h.a((String)null, var5);
            if (var6 != null) {
                var7 = "globalMessage_delayPerChar";
                var8 = var1.b(var7);
                int var9;
                if (var8 != null) {
                    if (var8.equals("slow")) {
                        var6.e = 18;
                    } else {
                        var9 = var1.b(var7, -1);
                        if (var9 != -1) {
                            var6.e = var9;
                        }
                    }
                }

                var9 = var1.c("globalMessage_textColor", -1);
                if (var9 != -1) {
                    var6.f = var9;
                }
            }

            var4 = true;
        }

        var5 = var1.b("debugMessage");
        if (var5 != null) {
            var1.h("Debug: " + var5);
            if (var2.bv && var2.bl) {
                String var16 = "Debug: " + var5;
                GameNetEngine.a((String)null, (String)var16);
            }

            var4 = true;
        }

        boolean var17 = var1.a("showOnMap", false);
        if (var17) {
            var2.bW.a(var1.b(), var1.c(), class_536.MESSAGE);
            var4 = true;
        }

        if (var1.f.a > 0) {
            Iterator var18 = var1.f.iterator();

            while(var18.hasNext()) {
                class_1005 var20 = (class_1005)var18.next();
                if (var20.c(var1)) {
                    var4 = true;
                }
            }
        }

        if (var1.g == class_609.a) {
            if (var3) {
                var1.h("objective met");
            }

            var4 = true;
        }

        if (var1.g == class_609.k) {
            var4 = true;
        }

        if (var1.g == class_609.i) {
            var4 = true;
        }

        if (var1.g == class_609.j) {
            var4 = true;
        }

        if (var1.g == class_609.g) {
            var4 = true;
        }

        float var19;
        float var22;
        if (var1.g == class_609.h) {
            var4 = true;
            var19 = (float)var1.b();
            var22 = (float)var1.c();
            var2.b(var19, var22);
        }

        Iterator var12;
        OrderableUnit var14;
        if (var1.g == class_609.e) {
            var19 = (float)var1.b();
            var22 = (float)var1.c();
            float var25 = 0.0F;
            float var10 = 0.0F;
            PlayerData var11 = var1.a();
            var12 = null;
            boolean var13 = false;
            var14 = null;
            boolean var15 = false;
            if (var11 == null) {
                var1.g("No team set, cannot spawn");
            } else if (var1.v != null) {
                var1.v.spawnUnitsAt(var19, var22, var25, var10, var11, var13, null, null, var15);
            } else {
                var1.g("No valid unit list to spawn");
            }

            var4 = true;
        }

        PlayerData var23;
        if (var1.g == class_609.c) {
            var23 = var1.a();
            if (var23 == null) {
                var1.g("Team not set for changeCredits");
            } else {
                Integer var29 = var1.d("set");
                if (var29 != null) {
                    var23.credits = (double)var29;
                }

                Integer var36 = var1.d("add");
                if (var36 != null) {
                    var23.d((float)var36);
                }

                var4 = true;
            }
        } else if (var1.g == class_609.d) {
            var23 = var1.a();
            if (var23 == null) {
                var1.g("Team not set for event_teamTags");
            } else {
                var8 = var1.a("addTeamTags", (String)null);
                if (var8 != null) {
                    class_588 var31 = class_585.a(var8);
                    var23.b(var31);
                }

                String var33 = var1.a("removeTeamTags", (String)null);
                if (var33 != null) {
                    class_588 var34 = class_585.a(var33);
                    var23.c(var34);
                }

                var4 = true;
            }
        } else if (var1.g == class_609.b) {
            var7 = var1.b("target");
            if (var7 == null) {
                class_70.i("Move trigger has no target id:" + var1.a);
            } else {
                PointF var26 = var0.f(var7);
                if (var26 == null) {
                    class_70.i("Move trigger: Cannot find target for:" + var1.a + " target:" + var7);
                } else {
                    PlayerData var30 = var1.a();
                    if (var30 == null) {
                        class_70.i("Team not set map trigger:" + var1.a);
                    } else {
                        int var28 = 0;
                        SyncPacket var35 = var2.cf.b(var30);
                        var12 = Unit.bE.iterator();

                        while(var12.hasNext()) {
                            Unit var39 = (Unit)var12.next();
                            if (var39.bX == var30 && var39 instanceof OrderableUnit && var1.a(var39) && var1.b(var39)) {
                                var14 = (OrderableUnit)var39;
                                var35.a(var14);
                                ++var28;
                            }
                        }

                        var35.a(var26.x, var26.y);
                        if (var3) {
                            var0.b("firstActivation: move at:" + var2.by + " for teamId:" + var30.site + " to targetId:" + var7 + " (#units:" + var28 + ")");
                        }

                        if (var1.b("unload") != null) {
                            Iterator var32 = Unit.bE.iterator();

                            while(var32.hasNext()) {
                                Unit var37 = (Unit)var32.next();
                                if (var37.bX == var30 && var37 instanceof OrderableUnit && var1.a(var37) && var1.b(var37) && var37.cr()) {
                                    OrderableUnit var38 = (OrderableUnit)var37;
                                    SyncPacket var40 = var2.cf.b(var30);
                                    var40.e = true;
                                    var40.a(var38);
                                    class_1059 var41 = var38.cp();
                                    var40.a(var41);
                                }
                            }
                        }

                        var4 = true;
                    }
                }
            }
        } else {
            if (var1.g == class_609.f) {
                class_684 var21 = new class_684();
                Iterator var24 = Unit.bE.iterator();

                Unit var27;
                while(var24.hasNext()) {
                    var27 = (Unit)var24.next();
                    if (var27 instanceof OrderableUnit && var1.a(var27) && var1.b(var27)) {
                        var21.add(var27);
                    }
                }

                if (var21.size() > 0) {
                    var24 = var21.iterator();

                    while(var24.hasNext()) {
                        var27 = (Unit)var24.next();
                        var27.ci();
                        if (var27 instanceof OrderableUnit && var27.bI()) {
                            var2.bU.a((OrderableUnit)var27);
                        }
                    }
                }

                var4 = true;
            }

            if (!var4) {
                var1.h("Trigger activated with no effect");
            }

        }
    }
}
